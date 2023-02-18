package Five;

public class Worker extends Staff{
    String job = "工人";
    public Worker(double salary) {
        super(salary);
    }

    @Override
    public void show(Staff staff) {
        System.out.println(job+"总工资"+staff.salary);
    }
}
