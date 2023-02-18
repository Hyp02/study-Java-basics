package hyp.QQ.function;

import java.io.Serializable;

public interface MessageType extends Serializable {
    String  MESSAGE_LOGIN_SUCCESS = "1";
    String MESSAGE_LOGIN_FAIL = "2";
    String RET_COMMON_MESSAGE="3";
    String RET_ONLINE_USER = "4";
    String AGAIN_LOGIN = "5";
    String INFORM_ALL = "6";
    String PRIVATE_CHAT = "7";
    String EXIT_SYSTEM="8";
    String FILE_SEND = "9";
    String SEVER_PUSH ="10";

}
