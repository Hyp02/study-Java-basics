package com;

public class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }
//    下面吧具体的要求封装成方法
    public void passRiver() {
//        if (vehicles == null){   在第一次传入对象后就不是指向空了，而是指向传入的那个对象。
//                                 就不会创建我们需要的对象
//                                 所以在下面会直接调用第一次传入的那个对象的方法
//            vehicles = Factory.getBoat();
//        }
        if (!(vehicles instanceof Boat)) {//这样优化就解决了上面的问题，
            // 接口的对象不是我们需要的就创建我们需要的
            vehicles = Factory.getBoat();
        }
        vehicles.work();
    }

    public void passRoad() {
//        if(vehicles == null){  在第一次传入对象后就不是指向空了，而是指向传入的那个对象。
////                                 就不会创建我们需要的对象
////                                 所以在下面会直接调用第一次传入的那个对象的方法
//            vehicles = Factory. getHorse();
//        }
//        vehicles.work();
        if (!(vehicles instanceof Horse)) {//如果不是马对象 就去创建，马对象
            vehicles = Factory.getHorse();
        }
        vehicles.work();
    }
    public void passMountain(){
        if (!(vehicles instanceof Airplane)) {//如果不是山对象 就去创建，马对象
            vehicles = Factory.getPlan();
        }
        vehicles.work();
    }
}
