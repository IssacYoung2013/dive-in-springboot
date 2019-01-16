package com.issac.spring.reactive.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * author:  ywy
 * date:    2019-01-15
 * desc:
 */
public class FluxDemo {

    public static void main(String[] args) throws InterruptedException {
//        println("Hello World!");
        Flux.just("A", "B", "C") // 发布 A -> B -> C
//                .publishOn(Schedulers.elastic())
                .map(old -> "+" + old)
//                .subscribe(
//                        FluxDemo::println, // 消费  = onNext (T)
//                        FluxDemo::println, // 异常  = onError (Throwable)
//                        () -> {// 完成回调
//                            println("完成操作！");
//                        },
//                        // 背压操作
//                        subscription -> {    // onSubscribe(Subscription)
//                            subscription.cancel(); // 取消上游传输数据到下游
//
//                            subscription.request(3);    // n 请求元素
//                        }
//                )
                .subscribe(new Subscriber<String>() {

                    private Subscription subscription;

                    private int count = 0;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        this.subscription.request(1);

                    }

                    @Override
                    public void onNext(String s) {
                        if (count == 2) {
                            throw new RuntimeException("主动抛出异常");
                        }
                        println(s);
                        count++;
                        this.subscription.request(1);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        println(throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        println("完成操作");
                    }
                })
        ;

//        Thread.sleep(1000L);


    }

    private static void println(Object obj) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[线程：" + threadName + "] " + obj);
    }
}
