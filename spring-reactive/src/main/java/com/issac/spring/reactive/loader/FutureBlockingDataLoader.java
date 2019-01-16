package com.issac.spring.reactive.loader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * author:  ywy
 * date:    2019-01-13
 * desc:
 */
public class FutureBlockingDataLoader extends DataLoader {
    @Override
    protected void doLoad() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        runCompletely(executorService.submit(super::loadConfigurations));
        runCompletely(executorService.submit(super::loadUsers));
        runCompletely(executorService.submit(super::loadOrders));

        // main -> submit -> ...
        // F1 -> F2 -> F3
    }

    private void runCompletely(Future<?> future) {
        try {
            future.get(); // 阻塞
        }catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        new FutureBlockingDataLoader().load();
    }
}
