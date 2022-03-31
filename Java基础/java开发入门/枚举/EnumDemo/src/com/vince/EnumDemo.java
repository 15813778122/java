package com.vince;

import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;

public class EnumDemo {
    public static final int RED = 0x1;
    public static final int GREEN = 0x2;
    public static final int BLUE = 0x3;
    public int color;
    @Test
    public void test1(){
        color = RED;
        color = 4;
    }

    public Color colorEnum;
    public void test2(){
//        colorEnum = Color.RED;
//        colorEnum = Color.GREEN;
        colorEnum = Color.BLUE;
        System.out.println(colorEnum); // BLUE
        System.out.println(colorEnum.name());//BLUE
        System.out.println(colorEnum.ordinal());//2
        System.out.println(colorEnum.toString());//BLUE

        Color[] values = Color.values();
        System.out.println(Arrays.toString(values));//[RED,GREEN,BLUE]
    }

    public void test3(){
        EnumSet<Color> set = EnumSet.allOf(Color.class);
        for (Color c:set){
            System.out.println(c);//RED  GREEN  BLUE
        }

        //可用forEach来循环遍历
        EnumMap<Color,String> map = new EnumMap<>(Color.class);//以Color.class的值作为key
        map.put(Color.RED,"red");
        map.put(Color.GREEN,"green");
        map.put(Color.BLUE,"blue");

    }

    @Test
    public void test4(){
        // System.out.println(Color.BLUE);//当用Color的时候，就会开始构造
        System.out.println(Color.RED.getColor());
    }

}
