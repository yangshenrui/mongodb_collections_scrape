package com.example.springboot.dal;

import com.example.springboot.model.Exporter;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ExporterRepository extends MongoRepository<Exporter, String> {

}
