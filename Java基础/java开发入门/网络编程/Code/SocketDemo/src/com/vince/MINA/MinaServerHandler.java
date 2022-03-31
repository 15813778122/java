package com.vince.MINA;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class MinaServerHandler extends IoHandlerAdapter {
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
        System.out.println("sessionOpened");
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        System.out.println("sessionClosed");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
//        String msg = (String) message;// 接收到的消息对象
        Message msg = (Message) message;
        System.out.println("收到客户端发来的消息:"+msg);
        msg.setInfo("吃好吃的");
        session.write(msg);
    }
}
