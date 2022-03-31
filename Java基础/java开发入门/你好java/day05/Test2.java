public class Test2{
	public static void main(String[] args){
		char[] nums = {'A','B','C','D','E','F','G'};
		int lon = nums.length;
		for(int i = 1;i <= lon;i++){
			for(int j = i;j<nums.length;j++){
				System.out.print(" ");
			}
			for(int z = 1;z <= i*2-1;z++){
				System.out.print(nums[i-1]);
			}
			System.out.println();
		}
	}
}