package Four;

public class Manager extends Staff {
    private double salary;

    public Manager(String name, double salary, int day) {
        super(name, salary, day);
        this.setSalary(salary);
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return 1000+salary * getDay() * 1.2;
    }
        public void print() {
            System.out.println("工资是" + getSalary());
        }

    }

