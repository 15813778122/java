public class Test17{
	public static void main(String[] args){
		int n1 = 1;
		int n2 = 1;
		int sum = 0;
		System.out.print(n1+" "+n2+" ");
		for(int i = 1; i <= 8; i++){
			sum = n1 + n2;
			System.out.print(sum+" ");
			n1 = n2;
			n2 = sum;
		}
	}
}