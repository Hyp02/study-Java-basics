public class Main {

    public static void main(String[] args) {
	// write your code here
        // new Cat("小花猫");因为构造器是私有的，所以不能在其他类中调用构造器创建对象
        System.out.println(Cat.show());
    }
}
class Cat{
/**
 * 如何保证我们值能创建一个对象
 * 步骤：【单例模式--饿汉式】
 * 1、将构造器私有化
 * 2、在类的内部直接创建
 * 3、提供一个公共的static方法。返回创建的对象
 */
    private String name;
    //保证只出现一个对象，所以在本类中new，不能创建对象，所以将在本类中new的设置成静态的，
    //要保证show方法可以访问new的对象，所以将对象设置成静态的（静态方法只能调用静态成员）
    static Cat cat = new Cat("小花猫");
    //保证这个程序中只出现一个对象，所以要保证用户不能随便new（将构造器私有化）
    private Cat(String name) {
        this.name = name;
    }
   // 不能创建对象，所以将在本类中展示的方法设置成静态的，就可以直接用类名调用
    public static Cat show(){
        return cat;
    }

    @Override
    public String toString() {//重写toString方法，用来返回对象信息
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
