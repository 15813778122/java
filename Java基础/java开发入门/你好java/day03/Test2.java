import java.util.Scanner;// 接受键盘输入的工具类
public class Test2{
	public static void main(String[] args){
		int a = 1;
		int b = 2;
		int c = a + b;
		System.out.println(c);
		
		a = 10;
		b = 3;
		System.out.println(a/b);
		
		a = b++;�增
		System.out.println("a="+a);
		System.out.println("b="+b);
		// a = 3; b = 4
		a = ++b;
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		int x = 1;
		int y = 2;
		y = x+y-(++y);
		System.out.println("x="+x);
		System.out.println("y="+y);
		
		// �߼������
		short s = 10;
		// s = s + 1;
		s+=1;
		System.out.println(s); // 11
		
		// ����һ����������Ĺ���
		Scanner input = new Scanner(System.in);
		System.out.println("������һ������");
		int x1 = input.nextInt(); // �Ӽ��̽���һ������
		System.out.println(x1);
		System.out.println("������һ���ַ���");
		Stirng s1 = input.next();
		System.out.println(s1);
		
	}
}