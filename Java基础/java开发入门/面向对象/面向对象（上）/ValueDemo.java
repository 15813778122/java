// 除了基本数据类型是在栈执行以外，其他都是跟堆有关系
public class ValueDemo(){
  public static void main(String[] agrs){
    int x = 10;
    method(x);
    System.out.println("x="+x); // 10,因为mx是局部变量，只存在栈内存中，当函数被销毁，mx也没有了，x没有被改变
  }
  public static void method(int mx){
    mx = 20;
  }
}