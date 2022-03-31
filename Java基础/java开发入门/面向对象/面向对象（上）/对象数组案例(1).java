/**
  对象数组与管理
  使用对象数组实现多个Chicken的管理
  动态数组：
  1.数组是一个线性数据结果
  2.数组不适合作删除插入等操作，适合添加，查找，遍历
 */
public class Test9{
  public static void main(String[] agrs){
    ChickenManager cm = new ChickenManager(5);
    cm.add(new Chicken(1,"小心",10));
    cm.add(new Chicken(2,"小心2",6));
    cm.add(new Chicken(3,"小心3",5));
    cm.add(new Chicken(4,"小心4",4));
    cm.add(new Chicken(5,"小心5",2));

    cm.add(new Chicken(6,"小心6",1));
    System.out.println("数组的长度是："+cm.length());
    System.out.println("-----printAll-----");
    cm.printAll();

    System.out.println("-----find-----");
    Chicken c = cm.find(6);
    c.getInfo();

    System.out.println("-----update-----");
    cm.update(new Chicken(1,"大大",20));
  }
}
// 小鸡管理类
class ChickenManager{
  private chicken[] cs = null;
  private int count = 0; // 记录当前数组的元素个数（下标）
  public ChickenManager(int size){
    if(size>0){
      cs = new Chicken[size];
    } else {
      cs = new Chicken[5];
    }
  }
  public int length(){
    return cs.length;
  }
  // 添加
  public void add(Chicken c){
    if(count>=cs.length){// 数组已满，需要扩充
      // 算法1：扩充原来数组大小的一般 cs.length*3/2+1
      // 算法2：扩充原来数组的一倍 cs.length*2
      int newLen = cs.length*2;
      cs = Array.copyOf(cs,newLen);
    }
    cs[count]=c;
    count++;
  }
  // 删除
  public void delete(int id){
    for(int i = 0;i < count;i++){
      // 找到了要删除的对象，把该对象之后的对象向前移动一位
      if(cs[i].getId() == id){
        for(int j = i;j < count-1;j++){
          cs[j] = cs[j+1];
        }
        // 把最后一个对象赋值为空（删除）
        cs[count-1] = null;
        count--;// 下标减一
        break;
      }
    }
  }
  // 更新
  public void update(Chicken c){
    Chicken temp = find(c.getId());
    if(temp!=null){
      temp.setName(c.getName());
      temp.setAge(c.getAge());
    }
  }
  // 查找
  public Chicken find(int id){
    for(int i = 0;i < count;i++){
      if(cs[i].getId()==id){
        return cs[i];
      }
    }
    return null;
  }
  public void printAll(){
    for(int i = 0;i < count;i++){
      cs[i].getInfo();
    }
  }
}
// 小鸡类(数据对象)value object(VO)
class Chicken{
  private int id;
  private String name;
  private int age;
  public Chicken(){}//一般情况下最好保留默认的构造方法
  public Chicken(int id,String name,int age){
    this.id = id;
    this.name = name;
    this.age = age;
  }
  public void setId(int id){
    this.id = id;
  }
   public int getId(){
    return id;
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
    return age;
  }
  public void getInfo(){
    System.out.println("name"+name+",age"+age+"")
  }
}