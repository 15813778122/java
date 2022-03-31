package com.qfedu.ioc.bean;

public class Book {
    public String name;
    public String prize;


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", prize='" + prize + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }
}
