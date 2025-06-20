package org.example.redisinspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisInSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisInSpringApplication.class, args);
    }

}
