package TankGame_07;

import java.io.*;
import java.util.Vector;

public class Recorder {
    private static int allDieEnemyTankNum = 0;
    private static BufferedWriter bw = null;

    public static String getEFilePhat() {
        return EFilePhat;
    }

    public static void setEFilePhat(String EFilePhat) {
        Recorder.EFilePhat = EFilePhat;
    }

    public static String getHFilePath() {
        return HFilePath;
    }

    public static void setHFilePath(String HFilePath) {
        Recorder.HFilePath = HFilePath;
    }

    private static String EFilePhat = "src\\RecordE.txt";
    private static String HFilePath = "src\\RecordH.txt";
    private static Vector<EnemyTank>  enemyTanks = null;
    private static Vector<HeroTank> heroTanks =null;
    static EnemyTank enemyTank = null;
    static HeroTank heroTank =null;
    //保存敌人信息的Node
    static Vector<Node> nodes = new Vector<>();
    //保存自己信息的Node
    static Vector<Node> nodes1 = new Vector<>();
    static BufferedReader br = null;
    static String  MyLeft = "存活";


    //从文件中获取我方坦克信息
    public static Vector<Node> getNodesAndHeroTankInfor() throws IOException {
        br = new BufferedReader(new FileReader(HFilePath));
        MyLeft = br.readLine();
        String s = "";
        while((s=br.readLine())!=null){
            String[] syd = s.split(" ");
            Node node = new Node(Integer.parseInt(syd[0]),
                    Integer.parseInt(syd[1]),syd[2]);
            nodes1.add(node);
        }
        br.close();
        return nodes1;
    }
    //从文件中获取敌人坦克信息
    public static Vector<Node> getNodesAndEnemyTankInfor() {
        try {
            br = new BufferedReader(new FileReader(EFilePhat));
            //记录死亡坦克人数。用来显示已经击败的数量
            allDieEnemyTankNum = Integer.parseInt(br.readLine());
            String s ="";
            while ((s = br.readLine()) != null) {
                System.out.println(s);

                //根据空格来断开字符串，并返回成String数组
                String[] xyd = s.split(" ");
                //创建Node对象，吧上一局保留的坦克对象的坐标反向信息传给Node对象
                Node node = new Node(Integer.parseInt(xyd[0]),
                        Integer.parseInt(xyd[1]), xyd[2]);
                //并把活下来的坦克加入到集合中
                //这样就知道活了几个坦克，那个坐标的坦克活着
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bw!=null)
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nodes;
    }
    //保存我方坦可信息到文件中
    public static void saveHInformation()throws IOException{
        for (int i = 0; i < heroTanks.size(); i++) {
            bw = new BufferedWriter(new FileWriter(HFilePath));
            heroTank = heroTanks.get(i);
            bw.write(MyLeft);

            bw.newLine();
            String MyInformation = heroTank.getX()+" "
                    + heroTank.getY()+" "+heroTank.getDirect();
            bw.write(MyInformation);
            bw.close();
        }
    }
    //保存敌人坦克信息到文件中
    public static void saveEInformation() {
        try {
            bw = new BufferedWriter(new FileWriter(EFilePhat));
            //将int类型的数量转换成String类型读取
            bw.write(Integer.toString(getAllDieEnemyTankNum()));
            bw.newLine();
            for (int i = 0; i < enemyTanks.size(); i++) {
                enemyTank = enemyTanks.get(i);
                String information = enemyTank.getX()+" "+enemyTank.getY()
                        +" "+enemyTank.getDirect();
                bw.write(information+"\r\n");
            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    public static Vector<HeroTank> getHeroTanks() {
        return heroTanks;
    }

    public static void setHeroTanks(Vector<HeroTank> heroTanks) {
        Recorder.heroTanks = heroTanks;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }
    public static void addAllEnemyTankNum() {
        Recorder.allDieEnemyTankNum++;
    }

    public static int getAllDieEnemyTankNum() {
        return allDieEnemyTankNum;
    }

    public static void setAllDieEnemyTankNum(int allDieEnemyTankNum) {
        Recorder.allDieEnemyTankNum = allDieEnemyTankNum;
    }
    public static String getMyLeft() {
        return MyLeft;
    }

    public static void setMyLeft(String myLeft) {
        MyLeft = myLeft;
    }
}
