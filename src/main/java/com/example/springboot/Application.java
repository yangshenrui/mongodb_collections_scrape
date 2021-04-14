package com.example.springboot;

import com.example.springboot.client.*;
import com.example.springboot.config.MongodbC;
import com.example.springboot.dal.AccessLogStaticRepository;
import com.example.springboot.dal.ExporterRepository;
import com.example.springboot.data.primary.repository.AccessLogStatisticRepository;
import com.example.springboot.data.secondary.repository.LogStatisticRepository;
import com.example.springboot.util.DateUtil;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.HTTPServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@EnableAspectJAutoProxy(proxyTargetClass = false)
@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private MyCollector myCollector;
	@Autowired
	private AccessLogStatisticCollector accessLogStatisticCollector;

	@Autowired
	private AccessLogStatisticRepository accessLogStatisticRepository;
	@Autowired
	private LogStatisticRepository logStatisticRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		new YourCustomCollector().register();
		new YourCustomCollector2().register();
		myCollector.register();
//		accessLogStatisticCollector.collect();
//		accessLogStatisticCollector.register();
		CollectorRegistry.defaultRegistry.register(accessLogStatisticCollector);
		HTTPServer server = new HTTPServer(1234);
	}

	private void extracted() {
		String dateStr = "";
		String[] arr = {"20210301","20210125"};
		if (new Random().nextBoolean())
			dateStr =  arr[0];
		else
			dateStr =  arr[1];
//		MongodbC.name = "log_" + dateStr;
		System.out.println(accessLogStatisticRepository.findAllByMonitorTime(Long.parseLong(dateStr + "0000")).size());
		System.out.println(logStatisticRepository.findAllByMonitorTime(Long.parseLong(dateStr + "0000")).size());
	}
}
