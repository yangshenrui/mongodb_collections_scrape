package com.example.springboot.metric;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExporterMetric {
    @Autowired
    MeterRegistry registry;
    static {

    }
}
