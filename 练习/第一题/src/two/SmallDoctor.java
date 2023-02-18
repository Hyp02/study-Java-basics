package two;

public class SmallDoctor extends Teacher{
    double salary;
    public SmallDoctor(String name,int age,String post,double salary){
        super(name,age,post,salary);
        this.salary = 1.2*salary;
    }
    @Override
    public void introduce(){
        System.out.println("姓名：" + name + " 年龄：" + " 职称："
                + post + " 薪水： " + salary);
    }
}
