// 1. new关键字表示创建一个对象
// 2. new关键字表示实例化对象
// 3. new关键字表示申请内存空间

public class Test1{
  public static void main(String[] args){
    // int i = 0;
    Horse h = null; // 声明一个类的变量(除了八种基本数据类型以外，都是引用类型，包括数组)

    // 创建一个Horse类型的对象，实例对象
    h = new Horse();
    // 有了对象，我们就可以调用对象的数和方法
    h.name = "赤兔马";
    h.age = 350;

    h.run(); // 调用方法，那么方法就会被执行

    h.eat();

    // 匿名对象：只能使用一次，用完后，该对象就会被释放
    new Horse().eat();

    h = null;// 把对象释放
    // h.eat(); // 当对象不存在时，调用该对象的属性和方法将报错(空指针)
  }
}

// 自定义一个类(类型)
class Horse {
  // 在类中定义属性(特征)
  String name;
  int age;
  public void run() {
    System.out.println("我是"+name+",我"+age+"岁，我跑很快");
  }
  public void eat() {
    System.out.println("我只吃仙草");
  }
}