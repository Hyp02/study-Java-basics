package HashSet_Exercise;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
@SuppressWarnings({"all"})
/**
 * 用HashSet添加对象。
 * 定义自己的日期类
 * 要求：姓名相同和日期相同的禁止添加
 */
public class Main {
    public static void main(String[] args) {
        HashSet LinkedHashSet = new LinkedHashSet();
        LinkedHashSet.add("jflk");
        LinkedHashSet.add("fj");
        LinkedHashSet.add("jflk");


        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("jan", 10,
                new Employee.MyDate(2002, 3, 4)));
        hashSet.add(new Employee("jl", 20,
                new Employee.MyDate(2001, 5, 3)));
        hashSet.add(new Employee("jan", 10,
                new Employee.MyDate(2002, 3, 4)));
        System.out.println("hashSet=" + hashSet);
    }
}

class Employee {
    private String name;
    private int age;

    //静态内部类
    //定义MyDate类
    static class MyDate {
        int year;
        int month;
        int day;

        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", brithday=" + birthday.year + "," + birthday.month + "," + birthday.day +
                '}';
    }

    //重写equals方法，以判断生日是否相同【生日的年月日都需要判断】
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name)
                && Objects.equals(birthday.year, employee.birthday.year)
                && Objects.equals(birthday.month, employee.birthday.month)
                && Objects.equals(birthday.day, employee.birthday.day);
    }

    //重写计算hash值方法【传入姓名和面月日来确定hash值】
    @Override
    public int hashCode() {
        return Objects.hash(name, birthday.year, birthday.month, birthday.day);
    }
}
