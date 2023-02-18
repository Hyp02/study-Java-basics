public class Main {

    public static void main(String[] args) {
	// write your code here

        Person person1 = new Person("韩",18,"男");
        Person person2 = new Person("王",3,"女");
        System.out.println(person1.equals(person1));//同一个对象，相同地址，返回true
        System.out.println(person1.equals(person2));//同一个类的不同对象，属性信息不同false
    }
}
