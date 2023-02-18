package Four;

public class worker extends Staff{
    private double salary;//定义工人类的特定工资
    public worker(String name,double salary,int day){
        super(name,salary,day);
        this.setSalary(salary);//封装进构造器初始化工资，
    }

    public void setSalary(double salary) {

        this.salary = salary;
    }
    public double getSalary() {
        return salary*getDay()*1.0;
    }

    public void print(){
        System.out.println("工资是"+getSalary());
    }
}
