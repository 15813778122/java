package com.vince.gui.abserver;

/**
 * 被观察者的接口
 */

public interface MessageObject {
    //注册观察者
    public void registerObserve(Observer o);
    //移除观察者
    public void removeObject(Observer o);
    //通知所有观察者
    public void notifyObservers();
}
