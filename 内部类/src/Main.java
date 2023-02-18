public class Main {

    public static void main(String[] args) {
	// write your code here
        //匿名内部类可当实参数直接传入方法
        new Cellphone().alarmclock(new Bell(){
            @Override
            public void ring() {//实现接口中的方法
                System.out.println("准备起床");
            }
        });
        new Cellphone().alarmclock(new Bell() {
            @Override
            public void ring() {//实现接口中的方法
                System.out.println("上课了");
            }
        });
        //传统方式此先要让类实现接口，在使类重写接口的方法  在创建类的对象，再调用方法。比较繁琐
    }
}
interface Bell{
    void ring();
}
class Cellphone {
    public void alarmclock(Bell bell) {//将接口类型作为形参
        bell.ring();//调用接口中的方法
    }
}
