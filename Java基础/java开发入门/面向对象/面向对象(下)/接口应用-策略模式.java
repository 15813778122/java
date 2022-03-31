/**
  策略模式(Strategy Pattern),定义了一系列的算法，将每一种算法封装起来并可以相互替换使用，策略模式让算法独立于使用它的客户应用而独立变化。
 
  把可变的行为抽象出来，这样的好处是这些行为可以在真正使用时相互替换

  OO设计原则：
  1.面向接口编程(面向抽象编程)
  2.封装变化
  3.多用组合，少用继承
 */

public class Test8{
  public static void main(String[] args){
    BaseService us = new UserService();
    us.setISave(new NetSave());
    us.add("user");
  }
}

interface ISave{
  public void save(String data);
}

class FileSave implements ISave{
  public void save(String data){
    System.out.println("save file into the file"+data);
  }
}

class NetSave implements ISave{
  public void save(String data){
    System.out.println("save file into the network"+data);
  }
}

abstract class BaseService{
  private ISave iSave;
  public void setISave(ISave iSave){
    this.iSave = iSave;
  }
  public void add(String data){
    System.out.print("data is saveing,keep wait for a monent");
    iSave.save(data);
    System.out.println("the data has been saved");
  }
}

class UserService extends BaseService{

}