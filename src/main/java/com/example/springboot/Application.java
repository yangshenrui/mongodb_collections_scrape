package com.example.springboot;

import com.example.springboot.client.YourCustomCollector;
import com.example.springboot.client.YourCustomCollector2;
import com.example.springboot.dal.ExporterRepository;
import com.example.springboot.model.Exporter;
import io.prometheus.client.exporter.HTTPServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private ExporterRepository exporterRepository;

	public static void main(String[] args)  throws IOException {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		new YourCustomCollector().register();
		new YourCustomCollector2().register();
		HTTPServer server = new HTTPServer(1234);
		Application application = new Application();
		System.out.println(exporterRepository.findByAge("100"));
		System.out.println(exporterRepository.findAll());
	}
}
