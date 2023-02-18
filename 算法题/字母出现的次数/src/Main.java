import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        Word word = new Word();
        word.num(s);
        word.Maxshow();
    }
}

class Word {
    int[] arr = new int[26];

    public void num(String str) {//传入一个字符串
        for (int i = 0; i < str.length(); i++) {//遍历字符串

            arr[(int) str.charAt(i) - 97]++;//取出字符串中对应位置的字母。
            // 转换成int型 将他减去97(a的ascll是从97开始的)每次循环将对应字母位置的数组值加1
            //最终数组的值是多少就出现了几次
        }
    }

    public void Maxshow() {
        int numMax = arr[0];//数组值代表字母个数
        int maxchar = 0;//下标是字母

        //遍历数组查找出最大的数组值（字母出现最多的个数），
        // 最大值对应的下标加97、强转成char型就是出现最多的字母
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i]!=0){
                System.out.println((char) (i+97)+"出现了"+arr[i]+"次" );
            }
            if (arr[i + 1] > numMax) {
                numMax = arr[i + 1];
                maxchar = i + 1;
            }
        }
        char ch = (char) (maxchar + 97);
        System.out.println("出现最多的字母是" + ch + "出现了" + numMax);
    }

}
