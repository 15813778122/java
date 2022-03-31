package com.vince;

import java.io.*;
import java.net.Socket;

public class EchoClientDemo {
    public static void main(String[] args) {
        //创建一个Socket对象，指定要连接的服务器
        try {
            Socket socket = new Socket("localhost", 6666);
            //输出流
            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            //输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            ps.println("hello,my name is ben");
            ps.flush();
            //读取服务器端返回的数据
            String info = br.readLine();
            System.out.println(info);
            ps.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
