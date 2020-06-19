package com.lwl.common.common.design;

import java.util.concurrent.CountDownLatch;

public class TestC {
    public static void main(String[] args)
    {
        try
        {
            //定义线程数量为4
            CountDownLatch count = new CountDownLatch(4);
            new Thread(new TopTask(count)).start();     //启动线程
            new Thread(new MainTask(count)).start();    //启动线程
            new Thread(new LeftTask(count)).start();    //启动线程
            new Thread(new RightTask(count)).start();   //启动线程
            //主线程等待
            count.await();
            System.out.println(Thread.currentThread().getName()+"线程加载完毕执行主线程...............");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}



class TopTask implements Runnable{

    private CountDownLatch count;

    public TopTask(CountDownLatch count)
    {
        this.count = count;
    }

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+"线程加载top...............");
        count.countDown();
    }
}


class MainTask implements Runnable{

    private CountDownLatch count;

    public MainTask(CountDownLatch count)
    {
        this.count = count;
    }

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+"线程加载main...............");
        count.countDown();
    }
}


class LeftTask implements Runnable{

    private CountDownLatch count;

    public LeftTask(CountDownLatch count)
    {
        this.count = count;
    }

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+"线程加载left...............");
        count.countDown();
    }
}

class RightTask implements Runnable{

    private CountDownLatch count;

    public RightTask(CountDownLatch count)
    {
        this.count = count;
    }

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+"线程加载right...............");
        count.countDown();
    }
}

