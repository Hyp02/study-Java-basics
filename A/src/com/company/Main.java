package com.company;

import java.util.HashMap;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
	// write your code here
        P p1 = new P("java", 20);
        P p2 = new P("java", 20);

        HashMap<P, String> pStringHashMap = new HashMap<>();
        HashMap<String, P> stringPHashMap = new HashMap<>();
        System.out.println(p1.equals(p2));
        System.out.println("pshash"+p1.hashCode());
        System.out.println("sp hash"+p2.hashCode());
        pStringHashMap.put(p1,"java1");
        pStringHashMap.put(p2,"java2");

        System.out.println("<P,String>"+pStringHashMap);
        stringPHashMap.put("java1",p1);
        stringPHashMap.put("java2",p2);
        System.out.println();
        System.out.println();
        System.out.println("<String,P>"+stringPHashMap);
    }
}
class P{
    private String name;
    private int age;
    public P(String name, int age) {this.name = name;this.age = age;}
    @Override
    public String toString() {return "P{" + "name='" + name + '\'' + ", age=" + age + '}';}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        P p = (P) o;
        return age == p.age && Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
