public class Manager extends EMployee {
    private int bonus ;

    public Manager(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
    }
    public String manage(){
        return getName()+"是经理，正在管理";
    }
    public int getAnnual (){
        return super.getAnnual()+bonus;
    }
}
