/**
  内部类就是在一个类的内部定义的类
  成员内部类格式如下：
  class Outer{
    class Inner{}
  }
  编译上述代码会产生两个文件：
  Outer.class和Outer$Inner.class

  成员
  1.成员内部类：直接在类中定义的类
  3.静态内部类，在类中定义一个静态修饰的内部类
    静态的含义是该内部类可以像其他静态成员一样，没有外部类对象时，也能够访问它。
    静态嵌套类仅能访问外部类的静态成员和方法
  局部
  2.方法内部类：在一个类的方法中内定义一个类
    (1)方法内部类只能在定义该内部类的方法内实例化，不可以在此方法外对其实例化
    (2)方法内部类对象不能使用该内部类所在方法的非final局部变量
  4.匿名内部类就是没有名字的内部类。
    匿名内部类的三种情况：
      (1)继承式的匿名内部类
      (1)接口式的匿名内部类
      (1)参数式的匿名内部类
  
  在使用匿名内部类时候，要记住以下几个原则：
    (1)不能有构造方法，只能有一个实例。
    (2)不能定义任何静态成员、静态方法。
    (3)不能是public,protected,private,static。
    (4)一定是在new的后面，用其隐含实现一个接口或继承一个类
    (5)匿名内部类为局部的，所有局部内部类的所有限制对其生效
 */

/**
  内部类的作用
    每个内部类都能独立地继承自一个(接口)的实现，所以无论外部类是否已经继承了某个(接口的)实现，对于内部类都没有影响。如果没有内部类提供的可以继承多个具体的或抽象的类的能力，一些设计与编程问题就很难解决。从这个角度看，内部类使得多重继承的解决方案变得完整。接口解决了部分问题，而内部类有效地继承了"多重继承".
 */

/**
  依赖外部类对象的：成员内部类，方法内部类，匿名内部类
  静态内部类不依赖外部类的对象，所以我们在项目中优先考虑选择静态内部类(不会内存泄漏)
 */
public class Test13{
  public static void main(String[] args){
    Outer outer = new Outer();
    // 在外部创建成员内部类的实例，因为成员内部类需要依赖外部类的对象。
    // 通常情况下，我们不建议这样来实例化内部类的对象
    // Outer.Inner inner = outer.new Inner();
    // inner.print();
    outer.innerPrint();
    outer.show();
    outer.print1();
    outer.print2();

    outer.print3(new Eat(){
      public void eat(){
          System.out.println("参数式的匿名内部类");
      }
    });
  }
}

class Outer{
  private String name;
  // 成员内部类
  // 建议在外部类中定义一个方法，对外提供访问内部类的接口
  public void innerPrint(){
    Inner inner = new Inner();
    inner.print();
  }
  //成员内部类
  private class Inner{
    public void print(){
      System.out.println("成员内部类");
    }
  }


  // 方法内部类
  // show方法的局部变量或方法的参数，实际必须是常量final
  public void show(){
    final int x = 10;
    class Inner2{
      public void print(){
        x++; // 从内部类引用的本地变量必须是最终稿变量或实际上的最终变量
        System.out.println("方法内部类"+x);
      }
    }
    Inner2 inner2 = new Inner2();
    inner2.print();
  }

  
  // 静态内部类
  static class Inner3{
    // 无法从静态上下文中引用非静态变量或方法
    public void print(){
      System.out.println("静态内部类")
    }
  }


  //匿名内部类
  // 继承式
  public void print1(){
    Cat cat = new Cat(){
      public void eat(){
        System.out.println("eat:继承式匿名内部类");
      }
    };
    cat.eat();
  }

  // 接口式
  public void print2(){
    Eat eat = new Eat(){
      public void eat(){
        System.out.println("eat:接口式匿名内部类")
      }
    };
    eat.eat();
  }

  // 参数式
  public void print3(Eat eat){
    eat.eat();
  }
}

interface Eat{
  public void eat();
}

abstract class Cat{
  public abstract void eat();
}

/**
  class A extends B{
    class D extends C{

    }
  }
 */