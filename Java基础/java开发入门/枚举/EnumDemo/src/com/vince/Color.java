package com.vince;

/**
 * 定义一个枚举类型
 */

public enum Color implements Info {
    BLUE {
        public String getColor2(){
            return "red";
        }
    }, GREEN(20) {
        public String getColor2() {
            return "red";
        }
    }, RED(10){
        public String getColor2(){
            return "red";
        }
    };
    private int color;

    private Color() {
        System.out.println("无参构造器");
    }

    private Color(int color) {
        this.color = color;
        System.out.println("有参构造器");
    }

    @Override
    public int getColor() {
        return color;
    }

    //public abstract int getColor2();
}
