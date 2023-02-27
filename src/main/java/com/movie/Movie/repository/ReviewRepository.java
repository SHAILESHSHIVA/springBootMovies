package com.movie.Movie.repository;

import com.movie.Movie.Reviews;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Reviews, ObjectId> {
}
