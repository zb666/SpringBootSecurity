package com.gupaoedu.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 让每一个人的职业生涯不留遗憾
 *
 * @author 波波老师【咕泡学院】
 * @Description: ${todo}
 * @date 2020/7/31 9:34
 */
public class JobMain {
    public static void main(String[] args) throws SchedulerException {
        // 1.创建Job对象
        JobDetail job = JobBuilder.newJob(MyJob.class).build();

        // 2.创建Trigger
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();
        // 3.创建Scheduler对象
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job,trigger);
        // 启动
        scheduler.start();
    }
}

