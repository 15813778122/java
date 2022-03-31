package com.vince.gui.abserver;

import org.junit.Test;

public class TestDemo {
    @Test
    public void testObserver(){
        Message message = new Message();
        Observer user1 = new User("lily");
        Observer user2 = new User("tom");
        Observer user3 = new User("vince");
        message.registerObserve(user1);
        message.registerObserve(user2);
        message.registerObserve(user3);

        message.setMessage("hello,everybody");

        message.removeObject(user1);

        message.setMessage("have lunch?");
    }
}
