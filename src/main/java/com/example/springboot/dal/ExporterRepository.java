package com.example.springboot.dal;

import com.example.springboot.model.Exporter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExporterRepository extends MongoRepository<Exporter, String> {
    List<Exporter> findByAge(long age);
}
