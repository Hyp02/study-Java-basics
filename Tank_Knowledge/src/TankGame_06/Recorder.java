package TankGame_06;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Recorder {
    private static int allDieEnemyTankNum = 0;
    private static BufferedWriter bw = null;
    private static String filePhat = "src\\MyRecord.txt";

    private static Vector<EnemyTank>  enemyTanks = null;
    static EnemyTank enemyTank = null;

    public static Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    //击毁坦克的数量增加
    public static void saveScore() {
        try {
            bw = new BufferedWriter(new FileWriter(filePhat));
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

    public static void addAllEnemyTankNum() {
        Recorder.allDieEnemyTankNum++;
    }

    public static int getAllDieEnemyTankNum() {
        return allDieEnemyTankNum;
    }

    public static void setAllDieEnemyTankNum(int allDieEnemyTankNum) {
        Recorder.allDieEnemyTankNum = allDieEnemyTankNum;
    }
}
