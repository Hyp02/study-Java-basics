import com.Person;
import com.Student;

public class Main {

    public static void main(String[] args) {
        // write your code here\
        Person p1 = new Person("韩永鹏", 20);
        p1.say();
        Student han = new Student("han", 200, "1234", 99);
        han.say();
    }
}
