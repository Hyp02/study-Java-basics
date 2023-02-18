public class Main {

    public static void main(String[] args) {
	// write your code here
        //先用二维数组遍历一个地图
        int hang =6,lie = 9;
        int [][]map = new int[hang][lie];
        //每列第一和最后一行为1
        for(int i = 0;i <  lie;i++){
                map[0][i] = 1;
                map[hang-1][i] = 1;
        }
        //每行第一和最后一列为1
        for(int i = 0; i < hang;i++){
            map[i][0] = 1;
            map[i][lie-1] = 1;
        }
        map[3][1] = 1;
        map[2][2] = 1;
        //map[2][3] = 1;
       // map[3][3] = 1;
        map[3][2] = 1;
        System.out.println("=======当前地图======");
        for(int i =0;i < map.length;i++){
            for(int j = 0;j < map[i].length;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println("======找路路径=======");
        T p1 = new T();
        p1.FindWay(map,1,1);
        for(int i =0;i < map.length;i++){
            for(int j = 0;j < map[i].length;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
class T{
    public boolean FindWay(int [][]map,int i,int j){
        if(map[4][7] == 2){//出口设置为2
            return true;
        }else{
            if(map[i][j] == 0){//是零才可以走通
                map[i][j] = 2;
                //return true;
                if(FindWay(map,i+1,j)){//下
                    return true;
                }else if(FindWay(map,i,j+1)){// 右
                    return true;
                }else if(FindWay(map,i-1,j)){//上
                    return true;
                }else if(FindWay(map,i,j-1)){//左
                    return true;
                }else {
                    map[i][j] = 3;//死胡同
                    return false;
                }
            }else{//其他数字不能走
                return false;
        }

        }
    }
}
