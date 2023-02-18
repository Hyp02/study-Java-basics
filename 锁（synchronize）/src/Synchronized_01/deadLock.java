package Synchronized_01;

public class deadLock {
    public static void main(String[] args) {
        Car car1 = new Car(true);
        Car car2 = new Car(false);
        new Thread(car1).start();
        new Thread(car2).start();


    }
}
class Bus{}
class Car1{}
class Car  implements Runnable{
    boolean loop ;
    static Car1 c = new Car1();//让线程共享一同一个对象，这里使用static
    static Bus b = new Bus();
    public Car(boolean loop) {
        this.loop = loop;
    }

    /*
        线程死锁
        两个线程同时运行‘
        运行到对象锁的地方 一个线程拿到c锁，一个线程同时拿到b锁
        往下一步运行时，需要之前各个线程拿到的对方的锁，（之前 A拿到B 现在A需要A
        之前B拿到A现在需要B  需要的锁都在对方线程手里，都没有办法释放锁，从而行成死锁）
     */
    @Override
    public void run() {
        if(loop){
            synchronized (c){
                System.out.println("拿到Car1的锁1");
                synchronized (b){
                    System.out.println("拿到Bus的锁1");
                }
            }
        }else{
            synchronized (b){
                System.out.println("拿到Bus的锁2");
                synchronized (c){
                    System.out.println("拿到Car1的锁2");
                }
            }
        }
    }
}
