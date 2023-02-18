package Four;

public class Staff {
    private String name;
    private double salary;
    private int day;
    public Staff(String name,double salary,int day){
        this.name=name;
        this.salary=salary;
        this.day=day;
    }

    public int getDay() {
        return day;
    }
    public double getSalary() {
        return salary;
    }
    public void print(){
        System.out.println("工资是"+getSalary());
    }
}
