/**
  Object类是类层次结构的根类
  每个类都使用Object作为超类。所有对象(包括数组都实现这个类的方法)

  所有类都是Object类的子类
 */

public class Test9{
  public static void main(String[] args){
    Student s = new Student(1,"飞飞",18);
    System.out.println(s); // ==  System.out.println(s.toString());默认会调用toString方法
    Student s2 = new Student(2,"贝贝",20);
    boolean b = s.equals(s2);
    System.out.println(b); // false

    System.out.println(s.getClass()==s2.getClass()); // true
  }
}
class Student{
  private String name;
  private int sid;
  private int age;
  public Student(){}
  public Student(int sid,String name,int age){
    this.id = id;
    this.name = name;
    this.age = age;
  }
  // 重写Object类中的toString方法
  public String toString(){
    return "sid="+sid+",name="+name+",age="+age;
  }
  // 重写equals方法，来实现两个对象的比较
  public boolean equals(Object obj){
    if(this == obj){
      return true;
    }
    if(obj instanceof Student){
      Student s = (Student)obj;
      if(!this.name.equals(s.name)){
        return false;
      }
      if(this.sid != s.sid){
        return false;
      }
      if(this.age!=s.age){
        return false;
      }
      return true;
    }
    return false;
  }
}