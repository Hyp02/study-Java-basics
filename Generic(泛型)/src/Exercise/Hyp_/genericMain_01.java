package Exercise.Hyp_;

import java.util.ArrayList;
import java.util.Comparator;
@SuppressWarnings({"all"})
public class genericMain_01 {
    public static void main(String[] args) {
        Employee han = new Employee("han", 342,
                new MyDate(2002, 3, 2));
        Employee wan = new Employee("aan", 3442,
                new MyDate(2005, 3, 6));
        Employee du = new Employee("han", 3432,
                new MyDate(2004, 4, 2));

        ArrayList<Employee> list = new ArrayList<>();
        list.add(han);
        list.add(wan);
        list.add(du);
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //如果姓名不同，就用姓名来排序
                if (o1.getName() != o2.getName()) {
                    int minus = (o1.getName()).compareTo(o2.getName());
                    return minus;
                }
                //调用birthday类中重写的compareTo方法判断生日
                return (o1.getBirthday()).compareTo(o2.getBirthday());
            }
        });
        for (Employee employee : list) {
            System.out.println(employee);
        }


    }
}

