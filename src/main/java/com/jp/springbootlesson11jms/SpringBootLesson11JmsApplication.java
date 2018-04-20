package com.jp.springbootlesson11jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jp")
public class SpringBootLesson11JmsApplication {

    public static void main(String[] args) {
        SpringApplication.run( SpringBootLesson11JmsApplication.class, args );
    }
}
