/**
  代理模式(Proxy):为其他对象提高一种代理以控制对这个对象的访问。

 */
public class Test11{
  public static void main(String[] args){
    Action ua = new UserAction();
    Action sa = new StaticAction(ua);
    sa.doAction();
  }
}

class StaticAction implements Action{
  public Action target;
  public StaticAction(Action target){
    this.target = target;
  }
  public void doAction(){
    long startTime = System.currentTimeMillis();
    target.doAction();
    long endTime = System.currentTimeMillis();
    System.out.println("spend time is"+(endTime - startTime);)
  }
}

interface Action{
  public void doAction();
}

class UserAction implements Action{
  public void doAction(){
    System.out.println("用户开始工作...");
  }
}