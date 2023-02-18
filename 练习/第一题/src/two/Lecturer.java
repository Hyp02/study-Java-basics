package two;

public class Lecturer extends Teacher{//讲师类
    double salary;
    public Lecturer(String name,int age,String post,double salary){
        super(name,age,post,salary);
        this.salary = 1.1*salary;
    }

//    public void setSalary(double salary) {
//        this.salary =1.1* salary;
//    }
//
//    public double getSalary() {
//        return salary;
//    }

    @Override
    public void introduce(){
        System.out.println("姓名：" + name + " 年龄：" +age+ " 职称："
                + post + " 薪水： " + salary);
    }
}
