package com.issac.spring.reactive.loader;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * author:  ywy
 * date:    2019-01-13
 * desc: 并行数据加载器
 */
public class ParallelDataLoader extends DataLoader {

    @Override
    protected void doLoad() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletionService completionService = new ExecutorCompletionService(executorService); // 队列
        completionService.submit(super::loadConfigurations,null);
        completionService.submit(super::loadUsers,null);

        completionService.submit(super::loadOrders,null);

        int count  =0;
        while (count < 3) {
            if(completionService.poll() != null) {
                count ++;
            }
        }

        executorService.shutdown();

    }

    public static void main(String[] args) {
        new ParallelDataLoader().load();
    }
}
