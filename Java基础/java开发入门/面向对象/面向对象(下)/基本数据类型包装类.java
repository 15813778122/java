/**
  基本数据类型包装类
 */

/**
  八种包装类分为两大类型：
    Number:Integer、Short、Long、Double、Float、Byte都是Number的子类表示是一个数字
    Object:Character、Boolean都是Object的直接子类
 */

/**
  注意:转型操作时，字符串必须由数字组成，否则会出现错误
 */

/**
  享元模式(Flyweight Pattern)它使用共享对象，用来尽可能减少内存使用量以及分享资讯给尽可能多的相似对象；
  它适合用于当大量对象只是重复因而导致无法令人接受的使用大量内存，通常对象中的部分状态是可以分享。常见做法是把它们放在外部数据结构，当需要使用时再将它们传递给享元。

  运用共享技术有效的支持大量细粒度的对象。
 */

public class Test16{
  public static void main(String[] args){
    // 把基本数据类型转换为包装类，称为自动装箱
    Integer i1 = new Integer(10);
    // 把包装类转换为基本数据类型，称为自动拆箱
    int i2 = i1.intValue();

    Integer i3 = 10;//建议方式

    Integer i4 = new Integer("123");

    // 把数值字符串转换为int类型
    String num1 = "12";
    // 建议用此方法
    int i5 = Integer.parseInt(num1);
    // 虽然此方法也可以得到i5同样的数值，但是此做法是需要系统内部先装箱再拆箱，比i5更消耗内存
    int i6 = Integer.valueOf(num1);
  }
}