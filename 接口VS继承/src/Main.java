/**
 *
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        SmallMonkey tom = new SmallMonkey("tom");
        tom.Habit();
    }
}
interface Fish{
    void Habit();
}
class Monkey {
    private String name;
    public Monkey(String name) {
        this.name = name;
        System.out.println(name + "猴子会爬树···");
    }

    public String getName() {
        return name;
    }
}
class SmallMonkey extends Monkey implements Fish{//SmallMonkey类想实现Fish类中的功能，
    // 但java是单继承机制。所以需要将Fish设置成接口，就可以让SmallMonkey来实现其中的特有方法
    public SmallMonkey(String name) {
        super(name);
    }

    @Override
    public void Habit() {
        System.out.println(getName()+"猴子和鱼学会了游泳");
    }
}