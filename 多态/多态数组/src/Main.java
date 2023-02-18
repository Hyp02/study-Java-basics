import com.Person;
import com.Student;
import com.Techer;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Person[] person = new Person[5];
        person[0] = new Person("jack", 20);
        //向上转型。。父类的引用指向子类的方法
        person[1] = new Student("Tom", 18, 99);
        person[2] = new Student("marry", 17, 56);
        person[3] = new Techer("smith", 45, 12000);
        person[4] = new Techer("wude", 48, 20000);
        //遍历动态数组并输出
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].say());
            //因为多态编译类型不能访问子类的特有方法
            //所以需要向下转型
            if (person[i] instanceof Student) {//如果哪一个数组元素的运行
                // 类型是Student，
                //向下转型、、、访问特有方法
                ((Student)person[i]).studay("语文");

            }else if(person[i] instanceof Techer){
                ((Techer)person[i]).teach ("语文");

            }else if((person[i] instanceof Person)){

            }else{
                System.out.println("类型有错误");
            }
        }
    }
}
