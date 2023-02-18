package Runnable_class;

public class runnable_01 {
    public static void main(String[] args) {
        Dog dog = new Dog();
       //dog.start();这里不能调用start方法，因为Dog类没有继承Thread类。只是实现了Runnable接口
       //而Runnable接口中没有start()方法
        Thread thread = new Thread(dog);
        thread.start();//这里是因为运用了静态代理模式
    }
}
class Animal{}
class Dog extends Animal implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("小狗汪汪叫~~");
        }
    }
}

/*
     这里演示一个简单的代理模式
     问题:
         模拟当一个类继承其他类时，不能继承Thread类为什么要先创建Thread对象(new Thread())
         然后将创建好的要实现多线程的类（上面的Dog）的对象传入Thread的构造器中(new Thread(dog))
     问题的底层原理 大致如下:
 */
class Test{
    public static void main(String[] args) {
        person person = new person();
//      person.start(); 这里不能调用是因为person实现了Runnable接口没有继承Thread类
//      所以没有start()可以调用
        ThreadProxy threadProxy = new ThreadProxy(person);
        threadProxy.start();//让threadProxy类的start()方法来代理person实现run()方法
    }
}
class person implements Runnable{//person类实现了Runnable接口
    public void run(){
        System.out.println("人跑了");
    }

}
class ThreadProxy implements Runnable{

    private Runnable tab = null;

    public ThreadProxy(Runnable tab) {//构造器，将Runnable类型的tab传入
        this.tab = tab;
    }
    @Override
    public void run() {//从该类的start0()方法过来后，执行逻辑
        if(tab != null){//tab不指向null的时候，调用run
            tab.run();//因为动态绑定机制，tab的运行类型是谁就调用是的相关方法
        }
    }
    public void start(){//定义start方法
        start0();//此方法调用start0()方法
    }
    public void start0() {
        run();//main中调用start()方法后，因为start()方法中调用的是start0()方法
        //进来后调用该类的run()方法
    }
}
