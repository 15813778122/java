/**
  接口的定义格式:(接口定义行为)
    interface 接口名称{
      全局常量;
      抽象方法;
    }
  
  接口的概念
  1.接口是一组行为的规范、定义，没有实现(JDK1.8默认方法)
  2.使用接口，可以让我们的程序更加例如变化
  3.接口是面向对象编程体系中的思想精髓之一
  4.面向对象设计法则：基于接口编程

  接口的使用规则：
  （1）定义一个接口，使用interface关键字
  （2）在一个接口中，只能定义常量，抽象方法，JDK1.8后可以定义默认的实现方法
  （3）接口可以继承多个接口：extends xxx,xxx
  （4）一个具体类是实现接口使用implements关键字
  （5）一个类可以实现多个接口
  （6）抽象类实现接口可以不实现接口的方法
  （7）在接口中定义的方法没有声明访问修饰符，默认为public
  （8）接口不能有构造方法
  （9）接口不能被实例化

  面向对象设计原则：
  （1）对修改关闭，对扩张开放
  （2）面向接口编程
 */

public class Test5{
  public static void main(String[] args){
    Girl mm = new Girl("小美");
    mm.sleep();
    mm.eat();
    mm.run();
    mm.print();
  }
}

interface IEat{
  // public abstract void eat();接口中只能定义抽象方法
  void eat();// 接口中定义的方法没有声明修饰符，默认为public abstract
  // public static final int NUM = 10;//在接口中定义一个常量
  int NUM = 10;//常量
  // 在JDK1.8后新特性，可以被所有实现类继承
  public default void print(){
    System.out.println("eat"); 
  }
}

interface IRun{
  void run();
}

//接口之间可以多继承(注意：类是只能单继承)
interface ISleep extends IEat,IRun{
  void sleep();
}

// 具体类实现接口必须实现接口的所有方法
class Girl implements ISleep,IEat{
  private String name;
  public Girl(){}
  public Girl(Stirng name){
    this.name = name;
  }
  public void sleep(){
    System.out.println("我爱睡觉");
  }
  public void eat(){
    System.out.println("我是"+name+",我爱吃JB")
  }
   public void run(){
    System.out.println("吃完就跑");
  }
}