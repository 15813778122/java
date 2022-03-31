/**
  适配器模式(Adapter):将一个类的接口转换成客户希望的另外一个接口，适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。

   OO设计原则：
    1.面向接口编程(面向抽象编程)
    2.封装变化
    3.多用组合，少用继承
    4.对修改关闭，对扩展开放
 */
public class Test12{
  public static void main(String[] args){
    PowerAImpl powerA = new PowerAImpl();
    // work(powerA);
    PowerBImpl powerB = new PowerBImpl();
    Adapter adapter = new Adapter(powerB);
    work(adapter);
  }
  public static void work(PowerA a){
    System.out.println("电源正在适配...");
    a.insert();
    System.out.println("电源已经完成");
  }
}

// 适配器
abstract class AnimalFunc{
  public void sing(){}
  public void cry(){}
  public void run(){}
  public void swim(){}
}

interface Animal{
  public void sing();
  public void cry();
  public void run();
  public void swim();
}

class Dog extends AnimalFunc{
  public void run(){
    System.out.println("我喜欢跑");
  }
}

// 适配器
class Adapter implements PowerA{
  private PowerB powerB;
  public Adapter(PowerB powerB){
    this.powerB = powerB;
  }
  public void insert(){
    powerB.connect();
  }
}

interface PowerB{
  public void connect();
}

class PowerBImpl implements PowerB{
  public void connect(){
    System.out.print("电源B已经插入");
  }
}

interface PowerA{
  public void insert();
}

class PowerAImpl implements PowerA{
  public void insert(){
    System.out.print("电源A已经插入");
  }
}