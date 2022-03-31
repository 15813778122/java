/**
  多态是面向对象三大特征之一
  什么是多态性？
  对象在运行过程中的多种形态。

  多态性我们大概可以分为两类：
  （1）方法的重载与重写
  （2）对象的多态性

  例如
  用父类的引用指向子类对象（用大的类型去接受小的类型，向上转型，自动转型）
  Chicken home = new HomeChicken();

  结论
  在编程时针对抽象类型的编写代码，称为面向抽象编程（或面向接口编程）
  父类通常都定义为抽象类，接口

  对象的多态性：
  对象多态性是从继承关系中的多个类而来，
  向上转型：将子类实例转为父类引用
  向上转型：将子类实例转为父类引用
  格式：父类 父类对象 = 子类实例； -> 自动转换
  以基本数据类型操作为例：int i = 'a';
  (因为char的容量比int小，所有可以自动完成)
  
  向下转型：将父类实例转为子类实例
  格式：子类 子类对象 = （子类）父类实例；强制转换
  以基本数据类型操作为例：char c = (char)97;
  因为整型是4个字节比char2个字节要大，所以需要强制完成

  多态性小结：
    1.方法的重载与重写就是方法的多态性表现
    2.多个子类就是父类中的多种形态
    3.父类引用可以指向父类对象，自动转换
    4.子类对象指向父类引用许哟强制转换（注意：类型不对会报异常）
    5.在实际开发中尽量使用父类引用（更利于扩展）
 */

 /**
  instanceOf关键字
    instanceOf是用于检查对象是否为指定的类型，通常在把父类引用强制转换为子类引用时要使用，为避免发生类型转换异常（ClassCastException）

  语法格式如下：
  对象instanceOf类型 -- 返回boolean类型值

  示例：
  if(homeChicken instanof Chicken){

  }
  该语句一般用于判读一个对象是否为某一个类的实例，是返回true，否返回false

  父类的设计法则
  通过instanceOf关键字，我们可以很方便的检查对象的类型，但如果一个父类的子类过多，这样的判断还是显得很繁琐，那么如何去设计一个父类呢？
  1.父类通常情况下都设计为抽象类或接口，其中优先考虑接口，如接口不呢个满足才考虑抽象类。
  2.一个具体的类尽可能不去继承另一个具体类，这样的好处是无需检查对象是否为父类的对象
  */

public class Test6{
  public static void main(String[] args){
    // HomeChicken hc = new HomeChicken("小鸡");
    // 用父类的引用指向子类对象（用大的类型来表示小的类型），自动转换（向上转型）
    Chicken hc = new HomeChicken("小鸡");
    // hc.eat();

    // YcChicken yc = new YcChicken("大鸡");
    Chicken yc = new YcChicken("大鸡");
    // yc.eat();

    // hc = yc;
    // hc.eat();// = yc.eat();
    // eat(hc);
    // eat(yc);

    Chicken JJC = new JJCChicken("JJC");
    eat(JJC);
    eat(hc);
    eat(yc);
  }
  public static void eat(Chicken c){
    System.out.println("吃饭");
    c.eat();
    // 当我们需要把父类的实例强制转换为子类引用时，为了避免类型转换异常 java.lang.ClassCastException
    // 那么我们需要在转换之前作类型检查（判断）
    if (c instanceOf JJCChicken){// 成立的条件是，对象本身及对象的父类型，都可以通过检查
      JJCChicken jjc = (JJCChicken)c; // 大的类型转换为小的类型，强制转换（向下转换）
      // c.song(); // error
      jjc.song();
    }
  }
}
// 鸡
abstract class Chicken{
  private String name;
  public Chicken(){}
  public Chicken(String name){
    this.name = name;
  }
  public void setName(String name){
    this.name = name;
  }
  public abstract void eat();
}
//家鸡
class HomeChicken extends Chicken{
  public HomeChicken(String name){
    super(name);
  }
  public void eat(){
    System.out.println(this.getName()+",我爱吃米");
  }
}
//野鸡
class YeChicken extends Chicken{
  public YeChicken(String name){
    super(name);
  }
  public void eat(){
    System.out.println(this.getName()+",我爱吃虫子");
  }
}
// 尖叫鸡
//野鸡
class JJCChicken extends Chicken{
  public JJCChicken(String name){
    super(name);
  }
  public void eat(){
    System.out.println(this.getName()+",我不吃东西");
  }
  public void song(){
    System.out.println("我是JJC");
  }
}