package Exercise.Hyp_;
//实现Comparable接口，因为需要重写接口的compareTo方法
public class MyDate implements Comparable<MyDate> {


    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //重写compareTo方法，用来排序
    @Override
    public int compareTo(MyDate o) {
        //先判断年
        int yearMinus = year - o.year;
        if (yearMinus != 0 ) {
            return yearMinus;
        }
        //月
        int monthMinus = month - o.month;
        if(monthMinus!=0){
            return monthMinus;
        }
        //日
        return day - o.day;

    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}


