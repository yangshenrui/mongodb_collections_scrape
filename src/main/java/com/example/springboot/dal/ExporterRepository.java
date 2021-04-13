package com.example.springboot.dal;

import com.example.springboot.model.Exporter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExporterRepository extends MongoRepository<Exporter, String> {
    Exporter findByAge(String age);
}
