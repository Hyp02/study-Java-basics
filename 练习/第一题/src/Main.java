public class Main {

    public static void main(String[] args) {
        // write your code here
        //定义Person数组;
        Person[] person = new Person[3];
        person[0] = new Person("韩", 18, "学生");
        person[1] = new Person("jack", 29, "程序员");
        person[2] = new Person("tom", 20, "老师");
        System.out.println("========排序前========");
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].show());
        }
        //    Person t = new Person("",0,"");
        for (int i = 0; i < person.length; i++) {
            for (int j = 0; j < person.length - 1 - i; j++) {
                if (person[j].age > person[j + 1].age) {
                    Person t = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = t;
                }
            }
        }
        System.out.println("========排序后========");
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].show());
        }
    }
}