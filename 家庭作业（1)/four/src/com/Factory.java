package com;

public class Factory {
    //将得Factory类中的方法设置成静态的，就可以不用创建Factory对象
    public static Horse getHorse(){
        return Horse.getHorse();
    }
    public static Boat getBoat() {
        return new Boat();
    }
    public static Airplane getPlan(){
        return new Airplane();
    }

}
