import java.util.Scanner;
import java.util.Random; // Generate pseudo-random numbers
public class Test1{
	public static void main(String[] args){
		// int[] nums = {30,17,6,3,21};
		int[] nums = new int[5];
		int len = nums.length;
		Random r = new Random(); // Create a tool that generates random numbers
		for(int i = 0;i < len;i++){
			nums[i] = r.nextInt(50);
			
		}
		Scanner input = new Scanner(System.in);
		System.out.println("please input you want to gress number");
		int userNum = input.nextInt();
		
		boolean flag = false;
		for(int x:nums){
			if(userNum==x){
				flag = true;
				break;
			}
			
		}
		if(flag){
			System.out.println("congratulation, have you ever");
		} else {
			System.out.println("sorry, you did'nt gress right");
		}
		
	}
}