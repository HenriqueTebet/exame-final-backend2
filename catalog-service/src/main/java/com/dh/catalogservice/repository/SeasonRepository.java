package com.dh.catalogservice.repository;

import com.dh.catalogservice.model.Season;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeasonRepository extends MongoRepository<Season, String> {
}
