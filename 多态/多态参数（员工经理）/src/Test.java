public class Test {//测试类
    public void showEMployee(EMployee e){//形参是父类类型。可指向子类,相当于 EMployee e = new Manager()

        System.out.println(e.getAnnual());
    }
    public void work(EMployee e){
        if(e instanceof Manager){//判断传入的对象是否是Manager
            //向下转型访问特有方法
            //因为父类中没有重写子类中的特有方法，直接用父类访问会访问不到。
            // 所以要将父类向下转型用来访问子类中特有的方法
            System.out.println(((Manager) e).manage());
        }else if(e instanceof Woreker){
            //向下转型，访问特有方法
            System.out.println(((Woreker) e).work());
        }else{

        }
    }
}
