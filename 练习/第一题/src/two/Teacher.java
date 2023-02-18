package two;

public class Teacher {
    String name;
    int age;
    String post;
    double salary;

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
    }

    public void introduce() {
        System.out.println("姓名：" + name + " 年龄：" + " 职称：" +
                post + " 薪水： " + salary);
    }
}
