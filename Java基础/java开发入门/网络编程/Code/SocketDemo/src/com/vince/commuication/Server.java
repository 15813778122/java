package com.vince.commuication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        //保存客户端处理的线程
        //用于保存在服务器中产生的所有的用户线程的任务的任务对象
        Vector<UserThread> vector = new Vector<>();
        ExecutorService es = Executors.newFixedThreadPool(5);
        try {
            ServerSocket server = new ServerSocket(8888);
            System.out.println("服务器已启动，正在等待连接...");
            while(true){
                Socket socket = server.accept();
                UserThread user = new UserThread(socket,vector);
                es.execute(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 客户端处理的线程
 */
class UserThread implements Runnable{
    private String name;//客户端的用户名称(唯一)
    private Socket socket;
    private Vector<UserThread> vector;// 客户端处理线程的集合
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private boolean flag = true;
    public UserThread(Socket socket,Vector<UserThread> vector){
        this.socket = socket;
        this.vector = vector;
        vector.add(this);
    }
    @Override
    public void run() {
        try {
            System.out.println("客户端"+socket.getInetAddress().getHostAddress()+"已连接");
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            while(flag){
                //读取信息的对象
                Message msg = ((Message) ois.readObject());
                int type = msg.getType();
                switch (type){
                    case MessageType.TYPE_SEND:
                        String to = msg.getTo();
                        UserThread ut;
                        int size = vector.size();
                        for (int i = 0; i < size; i++) {
                            ut = vector.get(i);
                            if(to.equals(ut.name) && ut!=this){
                                // 这句话表示从vector中循环找到接收信息方，然后服务器端给client端发送消息
                                // 所以这句话的意思是从vector找到目标后再调用服务器端的oos给client端
                                // 等下client要接收到这个msg
                                //大白话：这个线程就会把这个消息给发送出去(上面无法理解就理解这句)
                                ut.oos.writeObject(msg);
                                break;
                            }
                        }
                        break;
                    case MessageType.TYPE_LOGIN:
                        name = msg.getFrom();
                        msg.setInfo("欢迎你：");
                        oos.writeObject(msg);
                        break;
                }
            }
            ois.close();
            oos.close();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
