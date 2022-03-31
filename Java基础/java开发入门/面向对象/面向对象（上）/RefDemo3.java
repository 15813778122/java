//字符串本身就是一个对象
public class RefDemo2(){
  public static void main(String[] agrs){
    Person p = new Person();
    method(p);
    System.out.println("name="+p.name); // 小贝
    // 因为p是一个引用数据类型，name存放的是一个String，所以在栈内存存放p是一个地址，堆内存name又存放一个地址(该地址存放的是"飞飞")
    // 然后p赋值给了method的person。所以person的地址=p的地址，因为name存放的是一个地址，所以当person.name='小贝'的时候，会另开一个空间存放，此时的name的地址就会改变(指向小贝)
  }
  public static void method(Person person){
    person.name = '小贝';
  }
}
class Person{
  String name = "飞飞";
}