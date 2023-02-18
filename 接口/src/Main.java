public class Main {

    public static void main(String[] args) {
	// write your code here
        //创建各设备对象
        PC pc = new PC();
        Phone phone = new Phone();
        camera camera = new camera();
        //因动态绑定机制，编译器会自动定位到相关类调用类中相关的方法
        pc.work(phone);//向下转型到Phone类调该类的方法
        System.out.println("=============");
        pc.work(camera);//向下转型到Camera类调该类的方法

    }
}
interface USB{//接口。
    //声明两个方法
    public void stare();
    public void stop();
}
class PC{//定义一个电脑类
    // 创建一个实现接口的方法
    public void work(USB usb){//将用到多态的向上转型.最终运行结果看运行类型
        //调用相关类的stare和stop方法
        usb.stare();
        usb.stop();
    }
}
class Phone implements USB{//手机实现该接口

    @Override
    //实现接口中的方法
    public void stare() {
        System.out.println("手机已连接");
    }

    @Override
    //实现接口中的方法
    public void stop() {
        System.out.println("手机已断开");
    }
}
class camera implements USB{


    @Override
    public void stare() {
        System.out.println("相机连接");
    }

    @Override
    public void stop() {
        System.out.println("相机断开");
    }
}
