package HomeWork_;

import java.util.*;

public class HomeWork03 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("jack", 650);
        map.put("tom", 1200);
        map.put("smith", 2900);
        map.put("jack", 2600);
        Set keyset = map.keySet();
        //给每个人工资加钱
        for (Object key : keyset) {
            map.put(key,  (Integer)map.get(key) + 100);
        }
        System.out.println("————工资集合————");
        for (Object o : keyset) {
            System.out.println(map.get(o));
        }
        System.out.println("————名字集合————");
        for (Object o : keyset) {
            System.out.println(o);
        }
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        System.out.println("键值对关系");
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey()
                    +"——"+entry.getValue());
        }
    }
}