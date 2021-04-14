package com.example.springboot;

import com.example.springboot.client.MyCollector;
import com.example.springboot.client.YourCustomCollector;
import com.example.springboot.client.YourCustomCollector2;
import com.example.springboot.config.MongodbC;
import com.example.springboot.dal.AccessLogStaticRepository;
import com.example.springboot.dal.ExporterRepository;
import com.example.springboot.data.primary.repository.AccessLogStatisticRepository;
import com.example.springboot.data.secondary.repository.LogStatisticRepository;
import com.example.springboot.util.DateUtil;
import io.prometheus.client.exporter.HTTPServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private MyCollector myCollector;

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
		HTTPServer server = new HTTPServer(1234);
//		System.out.println(exporterRepository.findByAge(100l));
//		System.out.println(exporterRepository.findByAge(202101250012l));
//		System.out.println(exporterRepository.findAll());
		// 202101250012

//		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");
//		String nowTime = LocalDateTime.now().format(timeFormatter);
//		System.out.println(accessLogStatisticRepository.findAllByMonitorTime(Long.parseLong(nowTime)).size());
//		System.out.println(logStatisticRepository.findAllByMonitorTime(Long.parseLong(nowTime)).size());
//		Thread.sleep(2000);
		System.out.println(accessLogStatisticRepository.findAllByMonitorTime(202101250000l).size());
		System.out.println(logStatisticRepository.findAllByMonitorTime(202103010000l).size());
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
