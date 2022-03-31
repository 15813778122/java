public class Test21{
	public static void main(String[] args){
		for(int i = 1; i <= 5; i++) {
			for(int j = i; j < 5; j++) {
				System.out.print(" ");
				// 4
				// 3
				// 2
				// 1
				// 0
			}
			for(int z = 1; z <= i * 2 - 1; z++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}