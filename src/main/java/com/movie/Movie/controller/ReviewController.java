package com.movie.Movie.controller;

import com.movie.Movie.Reviews;
import com.movie.Movie.repository.ReviewRepository;
import com.movie.Movie.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/movies")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Reviews> createReview(@RequestBody Map<String,String> payload){

        return new ResponseEntity<Reviews>(reviewService.CreateReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);

    }

}
