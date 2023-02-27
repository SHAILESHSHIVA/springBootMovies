package com.movie.Movie.service;

import com.movie.Movie.Movie;
import com.movie.Movie.Reviews;
import com.movie.Movie.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate template;

    public Reviews CreateReview(String body,String imdbId){

        Reviews reviews = reviewRepository.insert(new Reviews(body));

        template.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewsIds").value(reviews)).first();


        return reviews;
    }
}
