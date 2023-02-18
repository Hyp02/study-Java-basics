package Map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 练习
 * 使用HashMap添加的三个员工对象
 * 要求：建：员工ID  值：员工对象
 * 并且遍历显示工资大于18000的员工
 * 员工类：姓名，工资，员工id
 */
public class HashMapExercise_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("123", new Worker("123", "小王", 34000));
        map.put("456", new Worker("456", "小李", 1000));
        map.put("789", new Worker("789", "jack", 80000));

        System.out.println("----使用增强for循环-----");
        Set keySet = map.keySet();
        for (Object key : keySet) {
            Worker worker = (Worker) map.get(key);
            if(worker.getSalary()>800){
                System.out.println(worker);
            }
        }

        System.out.println("----使用 EntrySet迭代器遍历----");
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            Worker worker = (Worker) entry.getValue();
            if (worker.getSalary() > 800)
                System.out.println(entry.getKey() + "_" + entry.getValue());
        }
    }

}

class Worker {
    private String id;
    private String name;
    private double salary;

    public Worker(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}