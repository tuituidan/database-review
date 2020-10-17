package com.tuituidan.dbreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * DatabaseReviewApplication.
 *
 * @author zhujunhan
 */
@EnableScheduling
@EnableCaching
@SpringBootApplication
public class DatabaseReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseReviewApplication.class, args);
    }

}
