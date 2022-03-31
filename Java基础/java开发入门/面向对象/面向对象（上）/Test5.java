public class Test5{
  public static void main(String[] args){
    Hero hero = new Hero("刘备",400);
    Weapon weapon = new Weapon("双股剑",3);

    // 把两个对象关联起来
    hero.setWeapon(weapon);
    weapon.setHero(hero);

    // 通过英雄来获取他的信息
    String name = hero.getName();
    int age = hero.getAge();
    Weapon w = hero.getWeapon();
    System.out.println("我是"+name+",我"+age+",岁了，我的武器是"+w.getName()+",等级是"+w.getGrade()+"级");
  }
}
// 英雄类
class Hero{
  private String name;
  private int age;
  private Weapon weapon;
  public void setWeapon(Weapon weapon){
    this.weapon = weapon;
  }
  public Weapon getWeapon(){
    return weapon;
  }
  public Hero(){}
  public Hero(String name, int age){
    this.name = name;
    this.age = age;
  }
  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return name;
  }
  public void setAge(int age){
    this.age = age;
  }
  public int getAge(){
    return Age;
  }
}
// 武器类
class Weapon{
  private String name;
  private int grade;
  private Hero hero;
  public void setHero(hero hero){
    this.hero = hero;
  }
  public Hero getHero(){
    return hero;
  }
  public Weapon(){}
  public Weapon(String name, int grade){
    this.name = name;
    this.grade = grade;
  }
  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return name;
  }
  public void setGrade(int grade){
    this.grade = grade;
  }
  public int getGrade(){
    return grade;
  }
}