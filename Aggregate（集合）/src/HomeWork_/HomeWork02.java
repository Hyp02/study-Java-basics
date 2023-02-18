package HomeWork_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class HomeWork02 {
    public static void main(String[] args) {
        Car car = new Car("宝马", 2000000);
        Car car1 = new Car("宾利", 343232);
        ArrayList arrayList = new ArrayList();
        //添加两个对象
        arrayList.add(car);
        arrayList.add(car1);
        //移除指定索引位置的元素
        arrayList.remove(1);
        System.out.println(arrayList);
        System.out.println("是否存在元素car1 "+arrayList.contains(car1));
        System.out.println("集合中的元素个数 "+arrayList.size());
        System.out.println("集合是否为空 "+arrayList.isEmpty());
        //添加多个元素
        arrayList.addAll(arrayList);
        System.out.println("多个元素是否否存在"+arrayList.containsAll(arrayList));
        System.out.println("——————迭代器——————");

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Car car2 =  (Car) iterator.next();
            System.out.println(car2);
        }

        System.out.println("——————增强for循环——————");
        for (Object o :arrayList) {
            System.out.println(o);
        }


    }
}
class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

