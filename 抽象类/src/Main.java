public class Main {

    public static void main(String[] args) {
	// write your code here
        Manager jack = new Manager("jack", "1234", 800, 10000);
        worker tom = new worker("tom", "12345", 3000);
        jack.work();
        tom.work();
    }
}
abstract class EMployee{//抽象类,员工父类
    String name;
    String id;
    double salary ;

    public EMployee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    //员工的工作，是抽象方法，（因不知道不同的员工都有什么工作，所以将工作方法定义为抽象方法）
    public abstract void work();

}
class Manager extends EMployee{//经理类，继承员工类
    double bonus;

    public Manager(String name, String id, double salary,double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }
    //抽象方法需要子类来实现（也就是重写父类的抽象方法）
    @Override
    public void work() {
        System.out.println("经理"+name +"正在工作中"+"奖金"+bonus);
    }
}
class worker extends EMployee{//普通工人类
    public worker(String name, String id, double salary) {
        super(name, id, salary);
    }
    //抽象方法需要子类来实现（也就是重写父类的抽象方法）
    @Override
    public void work() {
        System.out.println("普通员工"+name);
    }
}