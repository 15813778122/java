package com.qfedu.proxy;

public class MyStaticProxy {
    private GenaralDAO genaralDAO;

    public MyStaticProxy(GenaralDAO genaralDAO) {
        this.genaralDAO = genaralDAO;
    }

    public void insert(){
        begin();
        genaralDAO.insert();
        end();
    }
    public void delete(){
        begin();
        genaralDAO.delete();
        end();
    }
    public void update(){
        begin();
        genaralDAO.update();
        end();
    }
    public void begin(){
        System.out.println("-------begin");
    }
    public void end(){
        System.out.println("-------end");
    }
}
