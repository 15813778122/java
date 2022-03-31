package com.vince.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame2 extends Frame{
    private TextField textFiled = new TextField(20);
    private Button btn = new Button("pay");
    public Frame2(){
        this.setSize(400,200);
        this.setLayout(new FlowLayout());
        this.add(textFiled);
        this.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String money = textFiled.getText();
                moneyLister.setMoney(money);
            }
        });
        this.setVisible(true);
    }

    private MoneyLister moneyLister;

    public void setMoneyLister(MoneyLister moneyLister) {
        this.moneyLister = moneyLister;
    }

    public static interface MoneyLister{
        public void setMoney(String money);
    }
}
