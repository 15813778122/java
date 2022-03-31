package com.vince.MINA;

import java.io.Serializable;

/**
 * 消息包
 */

//Serializable可序列化
//传对象要实现序列化接口
public class Message implements Serializable {
    private String from;//发送者
    private String to;//接收者
    private String type;//消息类型
    private String info;//消息

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", type=" + type +
                ", info='" + info + '\'' +
                '}';
    }

    public Message(String from, String to, String type, String info) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.info = info;
    }

    public Message() {
    }
}
