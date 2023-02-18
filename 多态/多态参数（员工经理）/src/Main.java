public class Main {

    public static void main(String[] args) {
        // write your code here
        Manager jack = new Manager("jack", 1500, 10000);
        Woreker Tom = new Woreker("Tom", 5000);
        Test test = new Test();
        System.out.println("=======jack年总工资=====");
        test.showEMployee(jack);//传入员工类型，是运行类型
        System.out.println("=======Tom年总工资=====");
        test.showEMployee(Tom);//传入员工类型，是运行类型
        test.work(jack);
        test.work(Tom);
    }
}
