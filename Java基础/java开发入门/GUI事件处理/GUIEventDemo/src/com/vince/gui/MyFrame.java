package com.vince.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame implements ActionListener {

    /**
     * 初始化窗口的基本属性
     */
    public MyFrame(){
        //设置窗口大小
        this.setSize(600,400);
        //设置标题
        this.setTitle("我的第一个GUI窗口");
        //创建一个按钮
        Button button = new Button("点我一下，有惊喜");
        //给按钮绑定单击事件
        button.addActionListener(this);
        //创建一个线性布局
        FlowLayout flowLayout = new FlowLayout();
        //把布局应用到窗台上
        this.setLayout(flowLayout);

        //给窗体添加关闭事件
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        //把按钮添加到窗口上
        this.add(button);

        //意思是数据模型已经构造好了，允许JVM可以根据数据模型执行paint方法开始画图并显示到屏幕上了
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("惊喜来了");
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
