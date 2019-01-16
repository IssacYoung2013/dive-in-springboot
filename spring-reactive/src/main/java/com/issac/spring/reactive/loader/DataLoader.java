package com.issac.spring.reactive.loader;

import java.util.concurrent.TimeUnit;

/**
 *
 * author:  ywy
 * date:    2019-01-13
 * desc: 阻塞（串行）数据加载
 */
public class DataLoader {

    public final void load() {
        long startTime = System.currentTimeMillis();
        doLoad(); // 具体执行
        long costTime = System.currentTimeMillis() - startTime; // 消耗时间
        System.out.println("load() 总耗时：" + costTime + " 毫秒");
    }

    protected void doLoad() { // 串行计算
        loadConfigurations();
        loadUsers();
        loadOrders();
    }

    protected final void loadConfigurations() {
        loadMock("loadConfigurations",1);
    }

    protected final void loadUsers() {
        loadMock("loadUsers",2);


    }
    protected final void loadOrders() {
        loadMock("loadOrders",3);

    }

    private void loadMock(String source,int seconds) {
        try {
            long startTime = System.currentTimeMillis();
            long millseconds  = TimeUnit.SECONDS.toMillis(seconds);
            Thread.sleep(millseconds);
            long constTime = System.currentTimeMillis() - startTime;
            System.out.printf("[线程:%s]%s 耗时：%d 毫秒\n",Thread.currentThread().getName(),source,constTime);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new DataLoader().load();
    }
}
