package Exercise.Hyp_;

import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.*;

public class HomeWork_ {
    public static void main(String[] args) {

    }
    @Test
    public void testList(){
        String s = new String();
        //创建一个只能添加User类型的DAO对象
        DAO<User> DAO = new DAO<>();
        //添加User对象
        DAO.save("q",new User(1,21,"q"));
        DAO.save("w",new User(2,22,"w"));
        DAO.save("HH",new User(3,44,"jan"));
        //获取“w”对应得对象
        System.out.println(DAO.get("w"));
        //替换“w"对应得对象
        DAO.update("w",new User(2,3,"Q"));
        //将对象添加到List中
        List list = DAO.list();
        for (Object o : list) {
            User u = (User) o;
            System.out.println("list1=="+o);
        }
        //删除“q"对应得对象
        DAO.delete("q");
        List list1 = DAO.list();
        for (Object o1 : list1) {
            User u = (User) o1;
            System.out.println("list2=="+o1);
        }


    }
}
class DAO<T>{
    Map<String,T> map = new HashMap<>();
    //添加
    public void save (String id,T entity){
         map.put(id,entity);
    }
    //获取
    public T get (String id){
        return map.get(id);
    }
    //替换
    public void update (String id,T entity){
        map.replace(id,entity);
    }
    //将map中的对象保存到List中
    public List<T> list(){
        List<T> list = new ArrayList<>();
        Set<String> keySet = map.keySet();
        for (Object o :keySet) {
            list.add(map.get(o));
        }
        return list;
    }
    //删除id对应的对象
    public void delete(String id){
        map.remove(id);
    }

}
class User{
    private int id;
    private int age;
    private String name;

    public  User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}