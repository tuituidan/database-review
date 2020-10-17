package com.tuituidan.dbreview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * TaskSchedulerConfig.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/17
 */
@Configuration
public class TaskSchedulerConfig {

    /**
     * ThreadPoolTaskScheduler.
     *
     * @return ThreadPoolTaskScheduler
     */
    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(2);
        scheduler.setThreadNamePrefix("定时任务-");
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        scheduler.setRemoveOnCancelPolicy(true);
        scheduler.initialize();
        return scheduler;
    }
}
