package Five;

public class Farmer extends Staff{
    String job = "农民";
    public Farmer(double salary) {
        super(salary);
    }

    @Override
    public void show(Staff staff) {
        System.out.println(job+"总工资"+staff.salary+"  ");
    }
}
