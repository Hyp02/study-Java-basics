package com;

public class Horse implements Vehicles {
    //要求整个过程只能出现一匹马【用到单例模式】
    //将构造器私有化，就保证了用户不能自己去new对象
    private Horse() {
    }
    //在本类中创建一个静态的对象 供静态方法返回给 main
    static  Horse horse = new Horse();
    //因不能直接 new 所以要将返回的方法设置成静态的 用类名直接调用
    public static Horse getHorse() {
        return horse;
    }

    public  void work() {
        System.out.println("普通的路 骑马");
    }
}
