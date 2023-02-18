package two;

public class Doctor extends Teacher{
    double salary;
    public Doctor(String name,int age,String post,double salary){
        super(name,age,post,salary);
        this.salary = 1.3*salary;
    }

    public void setSalary(double salary) {
        this.salary = salary*1.3;
    }

    @Override
    public void introduce(){
        System.out.println("姓名：" + name + " 年龄：" + " 职称："
                + post + " 薪水： " + salary);
    }
}
