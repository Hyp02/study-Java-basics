package tow;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = Cat.show();
        Cat cat2 = Cat.show();
        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat1 == cat2);//返回true，说明两个对象是同一个
    }
}

class Cat {
    /**
     * 步骤【单例模式---懒汉模式】
     * 1、仍将构造器私有化
     * 2、定义一个static静态属性对象
     * 3、提供一个public方法，返回一个Cat对象
     */
    private String name;
    static Cat cat = null;

    private Cat(String name) {
        //无参构造器
        this.name = name;
        System.out.println("无参构造器被调用···");
    }
    //只有用户调用show方法时才会返回一个对象
    // 并且第一次调用后再次调用时返回的是同一个对象，
    // 这就保证了只能创建一个对象的要求
    public static Cat show() {
        if (cat == null) {
            cat = new Cat("小花猫");
        }
        return cat;
    }

    @Override
    public String toString() {//重写toString方法用来返回对象信息
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
