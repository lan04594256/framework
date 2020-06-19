package com.lwl.common.common.design;

import com.baomidou.mybatisplus.extension.api.R;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * 公共缓存队列
 * 只做两件事：（1）生产；（2）消费
 * @author Administrator
 */
@Component
public class PublicQueue<T>{
    /**
     *
     */
    private BlockingDeque<T> blockingDeque = new LinkedBlockingDeque<>(50);

    public void add(T msg){

        try {
            blockingDeque.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产一个产品，当前商品角标为："+"===文本为："+msg);
    }

    public T remove(){

        T t = null;
        try {
            t = blockingDeque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("消费一个产品，当前商品角标为："+"===文本为："+t);
        return t;
    }

    private static final int COUNT_RUNNER = 3;
    public static void main(String[] args) throws InterruptedException {
        // 50人参加比赛 / 创建一个有3个门闩的门
        CountDownLatch countDownLatch = new CountDownLatch(COUNT_RUNNER);
        PublicQueue<String> publicQueue=new PublicQueue();
        for(int i=0;i<51;i++){
        new Runnable() {
            @Override
            public void run() {
                System.out.println(123);
                    publicQueue.add(String.valueOf(123));
                countDownLatch.countDown();
                }
            };

        }
        countDownLatch.await();
        // 公布3人成绩 / 打开门了
       System.out.println("all runner game over.");

    }

}
