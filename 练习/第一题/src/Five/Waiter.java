package Five;

public class Waiter extends Staff{
    String job = "服务生";
    public Waiter(double salary) {
        super(salary);
    }

    @Override
    public void show(Staff staff) {
        System.out.println(job+"总工资"+staff.salary);
    }
}
