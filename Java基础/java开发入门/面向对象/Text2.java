/**
 * 封装性
 * 如果属性没有封装，那么在本类之外创建对象后，可以直接访问属性
 * private关键字：访问权限修饰符，public表示公有的，private表示私有的，私有的属性或者方法，只能在本类中访问，
 * 公有的属性和方法，可以被类外部的其他类访问，想要在类外部访问私有属性，我们需要提供公有的方法来间接访问
 * 通常在一个类中，属性都私有化，并对外提供getter 安定setter方法
 */
public class Text2{
  public static void main(String[] args){
    Person p1 = new Person();
    // p1.name = '菲菲';
    // p1.age = 18;
    p1.setName('菲菲');
    p1.setAge(18);
  }
}

// 没有封装之前
class Person{
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