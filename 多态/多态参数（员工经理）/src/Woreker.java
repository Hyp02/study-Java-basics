public class Woreker extends EMployee {

    public Woreker(String name, int salary) {
        super(name, salary);
    }

    public String work() {
        return getName() + "是普通员工，正在打工";
    }
}
