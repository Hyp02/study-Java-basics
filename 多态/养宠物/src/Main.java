public class Main {

    public static void main(String[] args) {
	// write your code here
        Master tom = new Master("tom");
        //给谁喂食就创建谁的对象
        Dog dog = new Dog("大黄","狗");
        //喂什么就创建什么的对象
        Food fish = new fish("黄花鱼");
        tom.Feed(dog,fish);

    }
}
