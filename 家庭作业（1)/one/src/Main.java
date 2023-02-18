public class Main {

    public static void main(String[] args) {
        // write your code here
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();

        System.out.println("1="+frock1.getSerialNumber());
        System.out.println("2="+frock2.getSerialNumber());
        System.out.println("3="+frock3.getSerialNumber());
    }
}

class Frock {

    private static int cuttentNum = 100000;

    private int serialNumber ;

    public Frock() {
        serialNumber = getNextNum();

    }
    public static int getNextNum() {

        return cuttentNum += 100;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}
