package com.tuituidan.dbreview;

import com.tuituidan.dbreview.kit.IpKit;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * DatabaseReviewApplication.
 *
 * @author zhujunhan
 */
@EnableScheduling
@EnableCaching
@SpringBootApplication
@Slf4j
public class DatabaseReviewApplication implements CommandLineRunner {

    @Resource
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseReviewApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String port = environment.getProperty("local.server.port");
        String contextPath = environment.getProperty("server.servlet.context-path", "");
        log.info("http://{}:{}{}", IpKit.getIpAddress(), port, contextPath);
    }
}
