package icu.nickxiao.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author nick
 * @version 1.0, 2021/12/12
 * @since 1.0.0
 */
@ComponentScan(basePackages = "icu.nickxiao")
@SpringBootApplication
@EnableScheduling
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}