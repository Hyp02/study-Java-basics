package hyp.QQ.Serve;

import java.util.HashMap;
import java.util.Iterator;

//管理客户端连接服务器的类
public class ccstManage {


    //创建集合管理线程
    private static HashMap<String, clientConnectServeThread> hashMap = new HashMap<>();

    //向集合中添加线程
    public static void addConnectServe(String userId, clientConnectServeThread ccst) {
        hashMap.put(userId, ccst);
    }

    //从集合中取出一个线程
    public static clientConnectServeThread getConnectServe(String userId) {
        return hashMap.get(userId);
    }

    public static HashMap<String, clientConnectServeThread> getHashMap() {
        return hashMap;
    }

    public static void setHashMap(HashMap<String, clientConnectServeThread> hashMap) {
        ccstManage.hashMap = hashMap;
    }
    public static String[] onlineUser(){
        String  user="";
        Iterator<String> iterator = hashMap.keySet().iterator();
        while(iterator.hasNext()){
            user+=iterator.next()+" ";
        }
        return user.split(" ");
    }




}
