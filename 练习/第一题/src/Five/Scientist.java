package Five;

public class Scientist extends Staff{
    double award ;

    public Scientist(double salary, double award) {
        super(salary);
        this.award = award;
    }

    public double getAward() {
        System.out.print("基本工资  "+salary+" 奖金 "+award+"  ");
        return award+salary;
    }
}
