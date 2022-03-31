package com.vince;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerDemo {
    public static void main(String[] args) {
        //创建一个服务器端的Socket(1024-65535)
        //服务器应该是先读再写，因为服务器端应该是接收方，客户端才是放出信息端
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("服务器已启动，正在等候客户端的连接");
            //等待客户端的连接，造成阻塞，如果有客户端连接成功，立即返回一个Socket对象
            Socket socket = server.accept();
            System.out.println("客户端连接成功"+server.getInetAddress().getHostAddress());
            //此时客户端应该为输出流，所以我们要用输入流来接收
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //通过输入流读取网络数据，如果没有数据，那么会阻塞
            String info = br.readLine();
            System.out.println(info);
            // 获取输出流，向客户端返回消息
            //此刻服务器端已经接收到数据，应向客户端返回消息(响应已经收到信息了)
            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            //这里打印出是为了让client知道服务器已经向客户端作出了回应，echo(回应)
            ps.println("echo:"+info);
            ps.flush();
            //关闭
            ps.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
