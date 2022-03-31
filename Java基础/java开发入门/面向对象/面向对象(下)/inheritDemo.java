public class inheritDemo{
  public static void main(String[] args){
    FindCosmeticsManager cm = new FindCosmeticsManager();
    cm.add(new Cosmetics("雅诗兰黛","进口",2000));
    cm.add(new Cosmetics("YSL","进口",1000));
    cm.add(new Cosmetics("大宝","国产",30));
    cm.add(new Cosmetics("潘婷","国产",300));
    cm.findAll();
  }
}

class FindCosmeticsManager extends CosmeticsManager{
  public void findAll(){
    for(int i = 0;i < count;i++){
      if("国产".equals(cs[i].getType())){
        System.out.println(cs[i].print());
      }
    }
  }
}

class SortCosmeticsManager extends CosmeticsManager{
  public void findAll(){
    Cosmetics[] temp = java.util.Arrays.copyOf(cs,count);
    Cosmetics c = null;
    for(int i = 0;i < temp.length -1;i++){
      for(int j = 0;j < temp.length - 1 - i;j++){
        if(temp[j].getPrice() > temp[j+1].getPrice()){
          c = temp[j];
          temp[j] = temp[j+1];
          temp[j+1] = c;
        }
      }
    }
    for(Cosmetics s: temp){
      System.out.println(s.print());
    }
  }
}

class CosmeticsManager{
  protected Cosmetics[] cs = new Cosmetics[4];
  protected int count = 0;
  public void add(Cosmetics c){
    int size = cs.length;
    if(count>=size){
      int newLen = size * 2;
      cs = java.util.Arrays.copyOf(cs,newLen);
    }
    cs[count] = c;
    count++;
  }
  public void findAll(){
    for(int i = 0;i < count;i++){
      System.out.println(cs[i].print());
    }
  }
}

class Cosmetics {
  private String name;
  private String type;
  private int price;
  public Cosmetics(){}
  public Cosmetics(String name, String type, int price){
    this.name = name;
    this.type = type;
    this.price = price;
  }
  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return name;
  }
  public void setType(String type){
    this.type = type;
  }
  public String getType(){
    return type;
  }
  public void setPrice(int price){
    this.price = price;
  }
  public int getPrice(){
    return price;
  }
  public String print(){
    return "name:"+name+",type:"+type+",price:"+price+"";
  }
}