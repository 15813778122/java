// 什么是构造方法
// 1.构造方法就是类构造对象时调用的方法，用于对象的初始化工作
// 2.构造方法是实例化一个类的对象时，也就是new的时候，最先调用的方法
// 构造方法的定义：
// 构造方法实在类中定义的，构造方法的定义格式：方法名称与类名称相同，无返回值类型的声明
// 对象的实例化语法：
// Dog dog = new Dog(); // new Dog后面有个括号，带括号表示调用了方法，此时调用的方法就是构造方法了
// 每个类中都有默认构造方法
public class Text3{
  public static void main(String[] args){
   Person person = new Person();
   Person person1 = new Person("学习",12);
  }
}

// 没有封装之前
class Person{
  // 默认构造方法，通常有其他构造方法时，要保留默认构造方法
  public Person(){
    // System.out.println("构造方法执行了");
  }
  public Person(String name){
    this.name = name;
    System.out.println("带一个参数的构造方法执行了");
  }
  public Person(String name, int age){
    // this.name = name;
    this(name);// 调用其他构造方法时，此语句需要在第一句，在构造方法相互调用时必须要有出口
    this.age = age;
    System.out.println("123");
  }
  // 属性的封装
  private String name;
  private int age;

  // getter and setter

  // 对外提供一个名为name属性设值的方法
  public void setName(String name){
    this.name = name;
  }
  // 对外提供一个获取name属性的方法
  public String getName(){
    return name;
  }
  // 对外提供一个名为age属性设值的方法
  public void setAge(int age){
    this.age = age;
  }
  // 对外提供一个获取age属性的方法
  public int getAge(){
    return age;
  }
}