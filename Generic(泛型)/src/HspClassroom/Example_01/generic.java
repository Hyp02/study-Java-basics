package HspClassroom.Example_01;

import java.util.*;

class generic_ {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<Student>();
        set.add(new Student("han",190));
        set.add(new Student("4han",345));
        set.add(new Student("h5an",140));
        System.out.println("=====HashSet增强For=====");
        for (Student student :set) {//因为泛型的原因所以直接可以用Student类型接收
            System.out.println(student);
        }
        System.out.println("=====HashSet迭代器=====");
        Iterator<Student> iterator = set.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            System.out.println(student);
        }
        
        HashMap<String, Student> map = new HashMap<String,Student>();
        map.put("wang",new Student("wang",39));
        map.put("jal",new Student("jk",89));
        //将map的key取出，用get方法取出key对应的值
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            System.out.println(map.get(key));
        }
        //将Map中的Entry集合用entrySet() 方法取出。
        Set<Map.Entry<String, Student>> entrySet = map.entrySet();
        for (Object o :entrySet) {//赋值给o
            Map.Entry entry = (Map.Entry) o;//强转成Entry类型
            System.out.println(entry.getKey());//使用Entry的对应get方法取出值
        }
        //使用迭代器。步骤：map--（map.entrySet）-->Entry--entrySet.iterator()-->
        // iterator-->强转成Map.Entry-->相应get方法取出
        Iterator<Map.Entry<String, Student>> iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Student> studentEntry =  iterator1.next();
            System.out.println(studentEntry.getKey());
        }


    }
}
class Student{
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "HspClassroom.Example_01.Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

