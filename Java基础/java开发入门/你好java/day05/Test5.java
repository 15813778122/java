public class Test5{
	public static void main(String[] args){
		int[] nums = {34,4,56,17,90,65};
		int len = nums.length;
		for(int i = 1;i < len;i++){
			int temp = nums[i];
			int j = 0;
			for(j = i - 1;j>=0;j--){
				if(nums[j]>temp){	
					nums[j+1] = nums[j];
				} else {
					break;
				}
			}
			if(nums[j+1]!=temp){
				nums[j+1] = temp;
			}
		}
		for(int n:nums){
			System.out.println(n);
		}
	}
	
	public static void functionOne(String[] args){
		int[] nums = {34,4,56,17,90,65};
		int len = nums.length;
		for(int i = 0;i < len;i++){
			for(int j = i + 1; j < len; j++){
				if(nums[i]>nums[j]){
					nums[i] = nums[i]+nums[j];
					nums[j] = nums[i] - nums[j];
					nums[i] = nums[i]-nums[j];
				}
			}
		}
		for(int i: nums){
			System.out.println(i);
		}
	}
	
	public static void bubbleSort(String[] args){
		int[] nums = {34,4,56,17,90,65};
		int len = nums.length;
		for(int i = 0; i < len-1;i++){
			for(int j = 0;j < len-1-i;j++){
				if(nums[j]>nums[j+1]){
					nums[j] = nums[j] + nums[j+1];
					nums[j+1] = nums[j] - nums[j+1];
					nums[j] = nums[j] - nums[j+1];
				}
			}
			
		}
		for(int i: nums){
			System.out.println(i);
		}
	}
	
	public static void selectionSort(String[] args){
		int[] nums = {34,4,56,17,90,65};
		int len = nums.length;
		int currrentLen = 0;
		for(int i = 0;i<len-1;i++){
			currrentLen = i;
			for(int j = i + 1;j < len;j++){
				if(nums[currrentLen]>nums[j]){
					currrentLen = j;
				}
			}
			if(currrentLen!=i){
				nums[currrentLen] = nums[currrentLen] + nums[i];
				nums[i] = nums[currrentLen] - nums[i];
				nums[currrentLen] = nums[currrentLen] - nums[i];
			}
		}
		for(int n : nums){
			System.out.println(n);
		}
	}
	
	public static void inserttionSort(String[] args){
		int[] nums = {34,4,56,17,90,65};
		int len = nums.length;
		for(int i = 1;i < len;i++){
			int temp = nums[i];
			int j = 0;
			for(j = i - 1;j>=0;j--){
				if(nums[j]>temp){	
					nums[j+1] = nums[j];
				} else {
					break;
				}
			}
			if(nums[j+1]!=temp){
				nums[j+1] = temp;
			}
		}
		for(int n:nums){
			System.out.println(n);
		}
	}
	
}