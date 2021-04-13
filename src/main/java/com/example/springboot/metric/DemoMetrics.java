package com.example.springboot.metric;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class DemoMetrics implements MeterBinder {
    AtomicInteger count = new AtomicInteger(0);
    AtomicInteger count1 = new AtomicInteger(0);

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        count = new AtomicInteger(100);
        Gauge.builder("demo.count", count, c -> c.get())
                .tags("host", "localhost")
                .description("demo of custom meter binder")
                .register(meterRegistry);

        Gauge.builder("demo.count1", count, c -> c.incrementAndGet())
                .tags("host", "localhost")
                .description("demo of custom meter binder")
                .register(meterRegistry);

        Gauge register = Gauge.builder("demo.count1", count, c -> c.incrementAndGet())
                .tags("host", "localhost")
                .description("demo of custom meter binder")
                .register(meterRegistry);


    }
}
