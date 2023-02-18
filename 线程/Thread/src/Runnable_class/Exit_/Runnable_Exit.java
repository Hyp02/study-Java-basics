package Runnable_class.Exit_;

public class Runnable_Exit {

    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        T t = new T();
        Thread thread = new Thread(t);
        thread.start();

        for (int i = 0; i < 30; i++) {
            System.out.println("main线程"+(++count));
            Thread.sleep(500);
        }
        Thread.sleep(5000);
        t.setLoop(false);//通知线成退出
    }

}

