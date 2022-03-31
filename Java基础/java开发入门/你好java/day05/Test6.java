public class Test6{
	public static void main(String[] args){
		int[] nums = {10,20,54,63,82,90};
		int index = binarySearch(nums, 54);
		System.out.println(index);
	}
	public static int binarySearch(int[] num, int key){
		int start = 0;// start the subscript
		int end = num.length-1;
		while(start<=end){
			// int middle = (start+end)>>>1;
			int middle = (start+end)/2;
			if(num[middle]>key){
				end = middle - 1;
			} else if(num[middle]<key){
				start = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
}