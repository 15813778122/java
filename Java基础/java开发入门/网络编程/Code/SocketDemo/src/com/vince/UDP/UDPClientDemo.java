package com.vince.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPClientDemo {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024];
        //相当于new了个购物袋(空的)
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        try {
            DatagramSocket socket = new DatagramSocket(8000);
            System.out.println("正在接受数据中...");
            //拿购物袋来接受socket
            socket.receive(dp);//接收数据
            String s = new String(dp.getData(),0, dp.getLength());
            System.out.println(s);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
