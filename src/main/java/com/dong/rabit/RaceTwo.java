package com.dong.rabit;

public class RaceTwo {
    public static void main(String arg[]) {
        TortoiseAndHare a1, a2;
        a1 = new TortoiseAndHare("rabbit");
        a2 = new TortoiseAndHare("turtle");
        a1.start();
        a2.start();
    }
}

class TortoiseAndHare extends Thread {

    public TortoiseAndHare(String str) {
        super(str);//线程名用动物名代表
    }

    public void run() {
        int distance = 10;
        int speed = 0;
        while (true) {
            try {
                double temp = Math.random();
                //判断随机数范围
                if (temp < 0.3 && getName().equals("rabbit")) {
                    //兔子跑
                    speed += 2;
                    System.out.println(getName() + "已经跑了" + speed);
                    if (speed >= distance) {
                        break;
                    } else {
                        //让线程做一点点让步
                        Thread.yield();
                    }
                }

                if (temp >= 0.3 && getName().equals("turtle")) {
                    //乌龟跑
                    speed += 1;
                    System.out.println(getName() + "已经跑了" + speed);
                    if (speed >= distance) {
                        break;
                    } else {
                        //让线程做一点点让步
                        Thread.yield();
                    }
                }
                sleep(50);
            } catch (InterruptedException e) {
            }
        }

    }
}