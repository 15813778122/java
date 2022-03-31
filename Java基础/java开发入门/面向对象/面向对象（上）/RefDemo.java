public class RefDemo(){
  public static void main(String[] agrs){
    Duck d = new Deck();
    method(d);
    System.out.println("x="+x); // 5,因为d是一个引用变量，在栈中存的是地址，把地址赋给了method的duck，所以能把堆内存的age改变
  }
  public static void method(Duck duck){
    duck.age = 5;
  }
}
class Duck{
  int age = 2;
}