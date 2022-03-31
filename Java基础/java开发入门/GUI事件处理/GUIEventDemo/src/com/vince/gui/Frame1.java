package com.vince.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends Frame implements Frame2.MoneyLister{
    private Label label = new Label("money:");
    private Button btn = new Button("buy");
    public Frame1(){
        this.setSize(400,200);
        this.setLayout(new FlowLayout());
        this.add(btn);
        this.add(label);
        btn.addActionListener(new ActionListener() {
            //当点击btn的时候new Frame2再把自己传过去，那么Frame2就可以调用Frame1继承Frame2的setMoney方法
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame2().setMoneyLister(Frame1.this);
            }
        });
        this.setVisible(true);
    }

    @Override
    public void setMoney(String money) {
        label.setText(money);
    }

    public static void main(String[] args) {
        new Frame1();
    }
}
