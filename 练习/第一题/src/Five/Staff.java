package Five;

public class Staff {
    double salary;

    public Staff(double salary) {
        this.salary = salary;
    }

    public void show(Staff staff) {
        if (staff instanceof Scientist) {
            System.out.println("科学总家工资" + ((Scientist) staff).getAward());
        } else if (staff instanceof Teacher) {
            System.out.println("老师总工资" + ((Teacher) staff).getFee());

        }
    }
}