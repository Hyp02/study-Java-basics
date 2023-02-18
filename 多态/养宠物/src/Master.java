public class Master {
    String Name;

    public Master(String name) {
        Name = name;
        System.out.println("主人是" + Name);
    }

    //使用多态
    public void Feed(Animal animal, Food food) {
        System.out.println(Name + "给" + animal.getName() + "喂的是" + food.getFood() );
    }
}
