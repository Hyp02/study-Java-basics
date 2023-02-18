package Map_;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSet_ {
    public static void main(String[] args) {
        //进行数据的自定义有序输出
        TreeSet treeSet = new TreeSet(new Comparator() {
            //匿名内部类以参数形式传入TreeSet的构造其中
            /*

            * public TreeSet(Comparator<? super E> comparator) {//这里传入的属性必须实现Collection接口
            否则会抛出类型转换异常
                    this(new TreeMap<>(comparator));
                    *
            底层其实是将传入的 “比较器”对象赋给了TreeMap的属性 comparator
            public TreeMap(Comparator<? super K> comparator) {
                    this.comparator = comparator;
    }
    }*/
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo((String) o2);
            }
        });
        /*
        Entry<K,V> t = root;
        if (t == null) {
            compare(key, key); // type (and possibly null) check 类型（可能为空）检查

            root = new Entry<>(key, value, null);
            size = 1;
            modCount++;
            return null;
        }
        int cmp;
        Entry<K,V> parent;
        *   Comparator<? super K> cpr = comparator;//将匿名内部类对象赋值给cpr
        if (cpr != null) {
            do {
                parent = t;
                cmp = cpr.compare(key, t.key);//动态绑定机制，调用匿名内部类中的比较方式
                if (cmp < 0)//根据返回的值，确定左右指针的指向
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
        else {
            if (key == null)
                throw new NullPointerException();
            @SuppressWarnings("unchecked")
                Comparable<? super K> k = (Comparable<? super K>) key;//这里会将add方法传入的属性进行强制类型转换
                这就是上面说的为什么要必须实现Collection接口（add方法传入的元素必须实现Collection接口）
            do {
                parent = t;
                cmp = k.compareTo(t.key);//进入compareTo方法进行对比确定是否出现相同K的元素
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);compareTo方法返回值是零的话说明存在K值相同元素，进行替换
            } while (t != null);
        }
        Entry<K,V> e = new Entry<>(key, value, parent);
        if (cmp < 0)//根据返回值确定指针指向属性的值
            parent.left = e;
        else
            parent.right = e;
        fixAfterInsertion(e);
        size++;
        modCount++;
        return null;
    }*/

        treeSet.add("bio");
        treeSet.add("bio");
        treeSet.add("akfgdfh");
        treeSet.add("lljo");
        //根据匿名内部类中的比较方式，以及链表指针的连接顺序进行输出
        System.out.println("treeSet="+treeSet);
    }
}
