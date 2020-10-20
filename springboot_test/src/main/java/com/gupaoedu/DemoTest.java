package com.gupaoedu;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class DemoTest {
    public static void main(String[] args) {
        //fork join的线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> taskFuture = forkJoinPool.submit(new TestForkJoinPool.MyForkJoinTask(1,10001));
        try {
            Integer result = taskFuture.get();
            System.out.println("Result = "+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class TestForkJoinPool{

    private static final Integer MAX = 200;

    static class MyForkJoinTask extends RecursiveTask<Integer>{

        private Integer startValue;

        private Integer endValue;

        public MyForkJoinTask(Integer startValue, Integer endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        protected Integer compute() {
            //拆分任务 指导无法继续再拆分
            if(endValue-startValue<MAX){
                Integer totalValue = 0;
                for (int index = startValue;index<=endValue;index++){
                    totalValue+=index;
                }
                return totalValue;
            }else {
                MyForkJoinTask subTask = new MyForkJoinTask(startValue,(startValue+endValue)/2);
                subTask.fork();
                MyForkJoinTask subTaskTask = new MyForkJoinTask((startValue+endValue)/2+1,endValue);
                subTaskTask.fork();
                return subTask.join()+subTaskTask.join();
            }
        }
    }

}