package Thread_Method;

import org.omg.IOP.TAG_RMI_CUSTOM_MAX_STREAM_FORMAT;

public class MethodShow {
    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        Cat cat = new Cat();//创建线程对象
        Thread thread = new Thread(cat);
        thread.setPriority(Thread.MAX_PRIORITY);//线程有优先级
        thread.setName("猫线程");
        thread.start();
        while(count < 2) {
            for (int i = 0; i < 5; i++) {
                System.out.println("main线程执行" + i);
                Thread.sleep(1000);
            }
            count++;
            thread.interrupt();//这个方法的作用是中断调用该方法的线程

        }


    }
}
class Cat implements Runnable{

    int Num = 0;
    @Override
    public void run() {
        int Num = 0;
        while(Num<3){
            for (int i = 0; i < 10; i++) {

                System.out.println(Thread.currentThread().getName()+"小猫在叫~~"+i);
            }
            try {
                System.out.println("猫猫睡觉了~");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"线程被interrupt了");
            }
            Num++;
        }
    }
}
