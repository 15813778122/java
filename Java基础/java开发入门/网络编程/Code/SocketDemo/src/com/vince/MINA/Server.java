package com.vince.MINA;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) {
        //创建一个非阻塞的server端socket NIO
        SocketAcceptor acceptor = new NioSocketAcceptor();
        //通过acceptor得到一个过滤链
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        //添加过滤器
        //添加一个名字，这个名字是一个标识，第二个参数是需要添加什么过滤器
        // 设定一个过滤器，一行一行的读取数据(/r/n)
        //chain.addLast("myChin",new ProtocolCodecFilter(new TextLineCodecFactory()));

        //设定过滤器以对象为单位读取数据
        chain.addLast("ObjectFilter",new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));

        //第三步创建一个消息处理器
        //设置服务器端的消息处理器
        acceptor.setHandler(new MinaServerHandler());
        int port = 9999;//服务器的端口号
        try {
            //绑定端口，启动服务器(不会阻塞，立即返回)
            acceptor.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Mina Sercer running,listener on:"+port);
    }
}
