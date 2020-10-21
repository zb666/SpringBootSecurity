package com.gupaoedu.job;


import org.springframework.boot.autoconfigure.batch.BatchProperties;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 让每一个人的职业生涯不留遗憾
 *
 * @author 波波老师【咕泡学院】
 * @Description: ${todo}
 * @date 2020/7/31 9:33
 */
public class MyJob implements Job {
    /**
     * 自定义的Job
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz任务执行了..." + new Date());
    }
}

