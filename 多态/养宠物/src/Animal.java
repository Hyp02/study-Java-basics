public class Animal {
    private String Name;
    private String type;
    public Animal(String Name,String type) {
        this.Name=Name;
        System.out.println("动物是："+Name+"("+type+")");

    }

    public String getName() {
        return Name;
    }
}

