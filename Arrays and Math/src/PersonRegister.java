import java.util.Scanner;

public class PersonRegister {
    public static void main(String[] args) {
        Person p = new Person();
        p.register();
        p.show();

    }
}

class Person {
    private String name;
    private String pwd;
    private String E_mail;
    boolean p = true;
    Scanner sca = new Scanner(System.in);

    public void register() {
        NAME();
        PWD();
        E_MAIL();
    }

    public void NAME() {
        boolean OK = true;
        do {
            System.out.println("输入用户名");
            name = sca.next();
            if (name.length() > 1 && name.length() < 5) {
                PWD();
            } else {
                System.out.println("用户名长度不正确");
                System.out.println("请重新输入用户名");
                OK = false;
                //NAME();
            }
        }while(!OK);
    }

    public void PWD() {
        boolean OK = true;
        do {
            System.out.println("请输入密码");
            pwd = sca.next();
            try {
                int pwds = Integer.parseInt(pwd);
                if (!(pwd.length() == 6)) {
                    System.out.println("长度错误");
                    OK = false;
                   //throw new RuntimeException("长度错误");
                    //PWD();
                } else {
                    E_MAIL();
                }

            } catch (NumberFormatException e) {
                System.out.println("密码必须为数字");
                System.out.println("请从新输入");
                OK = false;
            }
        }while(!OK);
    }

    public void E_MAIL() {
        boolean OK = true;
        do {
            System.out.println("亲输入邮箱");
            E_mail = sca.next();
            int indexd = E_mail.indexOf('.');
            int indexat = E_mail.indexOf('@');
            if (!(indexat > indexd || indexat == -1 || indexd == -1)) {
                System.out.println("恭喜你注册成功");
                p = false;
                show();
                System.exit(0);//注册成功就退出！
            } else {
                System.out.println("邮箱格式不正确");
                System.out.println("请从新输入邮箱");
                OK = false;
                //E_MAIL();
            }
        }while(!OK);
    }
    public  void show(){
        System.out.println("用户名是"+name+"密码是"+pwd);
    }
}
