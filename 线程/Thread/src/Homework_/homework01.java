package Homework_;

import java.util.Scanner;

public class homework01 {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        a.start();
        B b = new B(a);
        b.start();

    }
}
class A extends Thread{
    boolean loop = true;
    @Override
    public void run() {
        while(loop){
            System.out.println((int)(Math.random()*100)+1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B extends Thread {
    A a;

    public B(A a) {
        this.a = a;
    }

    Scanner scn = new Scanner(System.in);
    @Override
    public void run() {
        while (true) {
            System.out.println("输入（Q）停止");
            char key = scn.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                a.setLoop(false);
                break;
            }
        }
        System.out.println("B线程退出");
    }
}
