package com.fj;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestFj {

    @Test
    public void testFj() throws ExecutionException, InterruptedException {

        List<Integer> list = new ArrayList<>();

        int realSum = 0;
       for(int i = 0; i < 10; i++){
           list.add(i);
           realSum += i;
       }

        FjTask task = new FjTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        Future submit = pool.submit(task);
        Object o = submit.get();
        System.out.println("compara :: validate " + o + " realSum:: "+ realSum);


    }
}


class FjTask extends  RecursiveTask<Integer>{

    List<Integer> task;

    @Override
    protected Integer compute() {
        int sum = 0;

        if(task.size() >= 10){
            List<Integer> leftSub = task.subList(0, task.size()/2);
            List<Integer> rigthSub = task.subList(task.size()/2, task.size());
            FjTask leftTask = new FjTask(leftSub);
            FjTask rightTask = new FjTask(rigthSub);
            leftTask.fork();
            rightTask.fork();

            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }else{
            for (Integer integer : task) {
                sum += integer;
            }
        }
        System.out.println(Thread.currentThread().getId() + "::" + sum + JSON.toJSONString(task));
        return sum;
    }

    public FjTask(List<Integer> task) {
        this.task = task;
    }
}
