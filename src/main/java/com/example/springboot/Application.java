package com.example.springboot;

import com.example.springboot.client.*;
import com.example.springboot.data.primary.repository.AccessLogStatisticRepository;
import com.example.springboot.data.secondary.repository.LogStatisticRepository;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.HTTPServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Random;

@EnableAspectJAutoProxy(proxyTargetClass = false)
@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private AccessLogStatisticCollector accessLogStatisticCollector;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		CollectorRegistry.defaultRegistry.register(accessLogStatisticCollector);
		HTTPServer server = new HTTPServer(1234);
	}

}
