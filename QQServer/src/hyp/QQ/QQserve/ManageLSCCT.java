package hyp.QQ.QQserve;


import hyp.QQ.function.Message;

import java.util.HashMap;
import java.util.Iterator;

public class ManageLSCCT {

    private static HashMap<String, Message> hm = new HashMap<>();
    public static void addLCCST(String leaveId,Message message){
        hm.put(leaveId,message);
    }

    public static HashMap<String, Message> getHm() {
        return hm;
    }

    public static void setHm(HashMap<String, Message> hm) {
        ManageLSCCT.hm = hm;
    }
    public static String leaveUser() {
        String leaveUsers = "";
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            leaveUsers += iterator.next() + " ";
        }
        return leaveUsers;
    }
}
