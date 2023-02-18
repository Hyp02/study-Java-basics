/**
 * 接口类型的变量可以指向实现了该接口的类的对象实例
 * 如果IB继承了IA接口，而A类实现了IB接口
 * 实际上相当于A类也实现了IA接口
 * 这就是所谓的多台传递现象
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        IA ia = new A();//因为A类实现了IB接口，接口IB又继承了IA，相当于A类也实现了IA接口
        Aaa a = new A();//因为Aaa接口没有被A类实现，IB也没有继承Aaa接口，
        // 所以接口变量不能指向A类的实例对象
    }
}
interface Aaa{

}
interface IA{
    void hi();
}
interface  IB extends IA{
    void ok();
}

class A implements IB{

    @Override
    public void ok() {
        System.out.println("IB方法");
    }

    @Override
    public void hi() {
        System.out.println("IA方法");
    }
}