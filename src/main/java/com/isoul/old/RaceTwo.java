package com.isoul.old;

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

    String name;
    static double temp;

    public TortoiseAndHare(String str) {
        super(str);//线程名用动物名代表
        this.name = str;
    }

    public void run() {
        int speed = 0;
        int distance = 10;
        while (true) {
            temp = Math.random();
            try {
                //判断随机数范围
                if (temp < 0.3 && name.equals("rabbit")) {
                    //兔子跑
                    speed += 2;
                    System.out.println(getName() + "已经跑了" + speed);
                    //让线程做一点点让步
                    Thread.yield();
                }

                if (temp > 0.3 && name.equals("turtle")) {
                    //乌龟跑
                    speed += 1;
                    System.out.println(getName() + "已经跑了" + speed);
                    //让线程做一点点让步
                    Thread.yield();
                }
                sleep(50);
                if (speed >= distance) {
                    System.out.println(name + "结束了比赛");
                    break;
                }
            } catch (InterruptedException e) {
            }
        }

    }
}
