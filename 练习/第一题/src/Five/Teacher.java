package Five;

public class Teacher extends Staff{
    double fee;
    int time;
    public Teacher(double salary, double fee,int time) {
        super(salary);
        this.fee = fee;
        this.time = time;
    }

    public double getFee() {
        System.out.print("基本工资 "+salary+" 课酬每节课 "+fee+"  ");
        return time*fee+salary;
    }
}
