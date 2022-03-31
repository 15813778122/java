//字符串本身就是一个对象
public class RefDemo2(){
  public static void main(String[] agrs){
    String name = '小飞';
    method(name);
    System.out.println("name="+name); // 小飞,虽然string是引用数据类型，但是因为本身就是一个对象，所以sname会指向一个新开的堆内存空间，存放的是小贝，所以sname最终的指向改变(地址)
  }
  public static void method(String sname){
    sname = '小贝';
  }
}