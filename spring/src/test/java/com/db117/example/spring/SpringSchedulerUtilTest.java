package com.db117.example.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;

public class SpringSchedulerUtilTest {
    SpringSchedulerUtil schedulerUtil;

    private TriggerTask task;
    private String taskName = "1111";

    @Before
    public void setUp() throws Exception {
        schedulerUtil = new SpringSchedulerUtil();
        ScheduledTaskRegistrar registrar = new ScheduledTaskRegistrar();
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(8);
        taskScheduler.afterPropertiesSet();
        registrar.setTaskScheduler(taskScheduler);
        schedulerUtil.configureTasks(registrar);

        task = new TriggerTask(() -> {
            System.out.println(LocalDateTime.now().toString());
        },
                new CronTrigger("* * * * * *"));
    }


    @Test
    public void addTriggerTask() throws InterruptedException {

        schedulerUtil.addTriggerTask(taskName, task);
        Thread.sleep(1000 * 5);
        schedulerUtil.cancelTriggerTask(taskName);
        Thread.sleep(1000 * 5);
    }


    @Test
    public void resetTriggerTask() throws InterruptedException {
        schedulerUtil.addTriggerTask(taskName, task);
        Thread.sleep(1000 * 5);
        schedulerUtil.resetTriggerTask(taskName, task);
        Thread.sleep(1000 * 5);
        schedulerUtil.cancelTriggerTask(taskName);
        Thread.sleep(1000 * 5);
    }

    @Test
    public void taskNames() {
        schedulerUtil.addTriggerTask(taskName, task);
        System.out.println(schedulerUtil.taskNames());
        schedulerUtil.cancelTriggerTask(taskName);
    }

    @Test
    public void hasTask() {
        schedulerUtil.addTriggerTask(taskName, task);
        System.out.println(schedulerUtil.hasTask(taskName));
        schedulerUtil.cancelTriggerTask(taskName);
    }

    @Test
    public void ready() {
        System.out.println(schedulerUtil.ready());
    }

}