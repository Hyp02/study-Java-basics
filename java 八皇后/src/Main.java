 public class Main{
    public static void mian(String[] args){
        MyMethod q = new MyMethod();
        q.Q8(8);
    }
 }
 class MyMethod {
    public void Q8(int num){
        int []arr  = new int [num];
        if(num == 1 ){
            System.out.println("renyi");
        }else{
            for(int i =0;i < num; i++){
                int Qnum = num+(1-num);
                arr[Qnum] = i;
                if(Judge(arr,Qnum)){
                    Q8(Qnum+1);
                }
            print(arr);
            }
        }
    }
//判断皇后是否和上一个违规
    public boolean Judge(int[] arr, int Qnum){
        for(int j = 0; j < arr.length; j++){
            if(arr[j] == arr[Qnum]||Math.abs(j-Qnum) == Math.abs(arr[j] - arr[Qnum])){
                return false;
            }
        }
         return true;
    }
    public void print(int []arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
}
