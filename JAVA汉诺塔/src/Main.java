import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        T p = new T();
        p.HanNuo(2,'A','B','C');
        int [][]arr = new int [8][8];
//        for(int i = 0; i < arr.length; i++){
//            for(int j =0; j < arr[i].length;j++){
//                arr[i][j] = 0;
//            }
//        }
    }
}
class T{
    public void HanNuo(int num,char a,char b,char c){
        if(num == 1){
            System.out.println(a+"——>"+c);
        }else {
            HanNuo(num-1,a,c,b);
            System.out.println(a+"-->"+c);
            HanNuo(num-1,b,a,c);
        }
    }
   
}

