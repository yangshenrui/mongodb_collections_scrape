package com.example.springboot.controller;

import com.example.springboot.dal.AccessLogStaticRepository;
import com.example.springboot.dal.ExporterRepository;
import com.example.springboot.model.AccessLogStatic;
import com.example.springboot.model.Exporter;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/exporter")
public class ExporterController {
    @Autowired
    MeterRegistry registry;
    @Autowired
    private final ExporterRepository exporterRepository;
    private Counter counter_age;
    private AtomicLong count_gauge;

    @PostConstruct
    private void init(){
        AtomicLong count = new AtomicLong(0l);

        count_gauge = registry.gauge("access.log.statistic.count", new ArrayList<Tag>(), count);
    }

    public ExporterController(ExporterRepository exporterRepository) {
        this.exporterRepository = exporterRepository;
    }

    @GetMapping("")
    public List<Exporter> getAllExporters() {

        count_gauge.getAndIncrement();
        return exporterRepository.findAll();
    }
}
