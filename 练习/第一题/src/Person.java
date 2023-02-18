public class Person {
     String name;
     int age;
     String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }
    public String show(){
        return name+" "+age+" "+" "+job;
    }
}
