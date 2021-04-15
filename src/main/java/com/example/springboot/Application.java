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

@EnableAspectJAutoProxy
@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private AccessLogStatisticCollector accessLogStatisticCollector;

	@Autowired
	private LogStatisticCollector logStatisticCollector;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// 注册采集器
		CollectorRegistry.defaultRegistry.register(accessLogStatisticCollector);
		CollectorRegistry.defaultRegistry.register(logStatisticCollector);
		// 暴露端口
		HTTPServer server = new HTTPServer(1234);
	}

}
