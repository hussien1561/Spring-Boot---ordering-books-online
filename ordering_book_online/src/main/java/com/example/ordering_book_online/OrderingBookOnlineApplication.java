package com.example.ordering_book_online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class  OrderingBookOnlineApplication {

	public static void main(String[] args) {



		//SpringApplication.run(OrderingBookOnlineApplication.class, args);

		// context = (Context) SpringApplication.run( OrderingBookOnlineApplication.class   );

		ApplicationContext context = SpringApplication.run(OrderingBookOnlineApplication.class, args);

		System.out.println("hello world");


	}



}
