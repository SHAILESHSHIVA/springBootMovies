package com.movie.Movie.service;


import com.movie.Movie.Movie;
import com.movie.Movie.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repo;

    public List<Movie> getAllMovies(){

        return repo.findAll();


    }

    public Movie getMovieById(String id){
        return repo.findByImdbId(id).get();
    }
}
