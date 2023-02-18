package Five;

public class Test {
    public static void main(String[] args) {
        Staff scientist = new Scientist(1000, 10000);
        Staff teacher = new Teacher(3000, 50,50);
        Staff worker = new Worker(5000);
        Staff farmer = new Farmer(6000);
        Staff waiter = new Waiter(1255);
        scientist.show(scientist);
        teacher.show(teacher);
        worker.show(worker);
        farmer.show(farmer);
        waiter.show(waiter);
    }
}
