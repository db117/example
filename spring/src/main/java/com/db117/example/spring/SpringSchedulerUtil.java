package com.db117.example.spring;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 基于spring的调度实现任务的增删改查
 *
 * @author db117
 * @date 2020/8/9/009 14:46
 **/
@Component
@Slf4j
public class SpringSchedulerUtil implements SchedulingConfigurer {
    /**
     * ScheduledTaskRegistrar中的Task集合,
     * 目前看只有在spring任务管理销毁的时候用来终止任务的
     * 维护这个集合是为了在ScheduledTaskRegistrar.destroy 可以销毁掉任务
     */
    private Set<ScheduledTask> scheduledTasks;
    /**
     * 保存业务中的任务和spring任务映射
     */
    private Map<String, ScheduledTask> taskNameMap = new HashMap<>();
    /**
     * spring的任务管理
     */
    private ScheduledTaskRegistrar taskRegistrar;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        this.taskRegistrar = taskRegistrar;
        scheduledTasks = BeanUtil.getProperty(taskRegistrar, "scheduledTasks");
    }

    /**
     * 添加任务
     *
     * @param taskName    任务名称
     * @param triggerTask 任务
     */
    public synchronized void addTriggerTask(String taskName, TriggerTask triggerTask) {
        if (taskNameMap.containsKey(taskName)) {
            log.warn("Task already exists, cancel and add again");
            // 如果存在任务,则取消在添加
            cancelTriggerTask(taskName);
        }

        // 添加任务
        ScheduledTask scheduledTask = taskRegistrar.scheduleTriggerTask(triggerTask);

        taskNameMap.put(taskName, scheduledTask);

        scheduledTasks.add(scheduledTask);
        log.info("task addTriggerTask,taskName->[{}]", taskName);
    }

    /**
     * 取消任务
     *
     * @param taskName 任务名称
     */
    public synchronized void cancelTriggerTask(String taskName) {
        log.info("task cancelTriggerTask,taskName->[{}]", taskName);
        ScheduledTask scheduledTask = taskNameMap.get(taskName);
        if (scheduledTask == null) {
            return;
        }
        // 取消任务
        scheduledTask.cancel();

        taskNameMap.remove(taskName);

        scheduledTasks.remove(scheduledTask);
    }

    /**
     * 重置任务
     *
     * @param taskName    任务名称
     * @param triggerTask 任务
     */
    public synchronized void resetTriggerTask(String taskName, TriggerTask triggerTask) {
        log.info("task resetTriggerTask,taskName->[{}]", taskName);
        cancelTriggerTask(taskName);
        addTriggerTask(taskName, triggerTask);
    }

    /**
     * 任务名称
     */
    public Set<String> taskNames() {
        return taskNameMap.keySet();
    }

    /**
     * 获取任务
     *
     * @param taskName 任务名称
     */
    public ScheduledTask findTask(String taskName) {
        return taskNameMap.get(taskName);
    }

    /**
     * 是否存在任务
     *
     * @param taskName 任务名称
     */
    public boolean hasTask(String taskName) {
        return this.taskNameMap.containsKey(taskName);
    }

    /**
     * 任务调度是否已经初始化完成
     *
     * @return 是否准备好
     */
    public boolean ready() {
        return this.taskRegistrar != null && this.taskRegistrar.getScheduler() != null;
    }
}
