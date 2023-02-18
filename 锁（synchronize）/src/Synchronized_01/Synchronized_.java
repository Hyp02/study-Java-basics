package Synchronized_01;

public class Synchronized_ {
    public static void main(String[] args) {

    }
}
class A extends Thread{
    boolean loop = true;
    @Override
    public void run() {
        if(loop){
            synchronized (this){//对象互斥锁（就是本类的对象锁）
                System.out.println("进入");
            }
        }
    }
}
class B extends Thread{
    //PP方法和QQ方法是一样的
    public static synchronized void PP(){
        System.out.println("静态互斥锁");
    }
    public static void QQ(){
        synchronized (B.class){//静态互斥锁
            System.out.println("静态互斥锁");
        }
    }

}