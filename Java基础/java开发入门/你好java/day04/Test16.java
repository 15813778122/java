public class Test16{
	public static void main(String[] args){
		int num = 0;
		int i = 1;
		do {
			int j = 1;
			int jc = 1;
			while(j<=i) {
				jc *= j;
				j++;
			}
			num += jc;
			i++;
		} while(i<=10);
		System.out.println(num);
	}
}