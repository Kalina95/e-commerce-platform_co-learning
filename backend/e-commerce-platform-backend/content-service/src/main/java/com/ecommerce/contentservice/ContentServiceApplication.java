package com.ecommerce.contentservice;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@RequestMapping(value = "content")
public class ContentServiceApplication {

	//sudo kill -9 $(lsof -ti:8082)

	public static void main(String[] args) {
		SpringApplication.run(ContentServiceApplication.class, args);
	}

	@Bean
	public Consumer<String> testConsumer() {
		return value -> {
			System.out.println("hello");
		};
	}

	@Bean
	public Supplier<String> testSupplier() {
		String resposne = "hello";
		return ()-> {return resposne;};
		};
	}



