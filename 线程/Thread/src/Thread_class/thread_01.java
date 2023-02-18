package Thread_class;

import java.sql.Time;

public class thread_01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();//执行start方法才会启动多线程
        //cat.run 这样调用run方法的话，只是一个main中的普通方法，不会启动多线程
        for (int i = 0; i < 30;i++) {
            Thread.sleep(1000);
            System.out.println(i+Thread.currentThread().getName()+"线程");
        }

    }
}
class Cat extends Thread{
    int iNum;
    @Override
    public void run() {
        while(true){
            System.out.println("小猫喵喵叫~~ i="+(++iNum)+Thread.currentThread().getName()+"线程");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(iNum==80){
                break;
            }
        }
    }
}
