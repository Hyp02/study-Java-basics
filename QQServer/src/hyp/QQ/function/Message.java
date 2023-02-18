package hyp.QQ.function;

import java.io.Serializable;

public class Message implements Serializable {
    //消息类型
    private String sender;
    private String getter;
    private String sendTime;
    private String content;
    private String messageType;
    private String UserId;
    private String fileSendPath;
    private String fileSavePath;
    private byte[] fileBytes;

    public String getFileSendPath() {
        return fileSendPath;
    }

    public void setFileSendPath(String fileSendPath) {
        this.fileSendPath = fileSendPath;
    }

    public String getFileSavePath() {
        return fileSavePath;
    }

    public void setFileSavePath(String fileSavePath) {
        this.fileSavePath = fileSavePath;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }



    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
