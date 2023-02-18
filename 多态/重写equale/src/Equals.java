import java.util.Objects;

class Person {
    String name;
    int age;
    String gender;

    public Person(String name, int age, String gener) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return this.name.equals(p.name)
                    && this.age == p.age && this.gender.equals(p.gender);
        }
        return false;
    }
}
