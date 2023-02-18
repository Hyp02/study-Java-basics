package hyp.QQ.QQserve;

import hyp.QQ.function.User;

import java.util.HashMap;
import java.util.Iterator;

public class ManageSCCT {


    private static HashMap<String, serveConnectClientThread> hm = new HashMap<>();

    public static void addServeConnectClientThread(String userId, serveConnectClientThread sCCT) {
        hm.put(userId, sCCT);
    }

    public static serveConnectClientThread getsCCT(String userId) {
        return hm.get(userId);
    }

    public static HashMap<String, serveConnectClientThread> getHm() {
        return hm;
    }

    public static void setHm(HashMap<String, serveConnectClientThread> hm) {
        ManageSCCT.hm = hm;
    }

    public static String OnlineUser() {
        String onlineUsers = "";
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            onlineUsers += iterator.next() + " ";
        }
        return onlineUsers;
    }

}
