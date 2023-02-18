package two;

import java.util.Date;

public class Text {
    public static void main(String[] args) {
        Teacher jack = new Lecturer("jack",22,"讲师",6000);
        Teacher tom = new Doctor("tom", 21, "副教授", 5000);
        jack.introduce();
        tom.introduce();
    }
}
