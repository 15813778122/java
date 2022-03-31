import java.util.Arrays;
public class Test7{
	public static void main(String[] args){
		int[] nums = {45,65,76,87,98,101};
		// 二分查找
		int index = Arrays.binarySearch(nums,98);
		System.out.println("the subscript is:"+index);
		// 在测试输出数据时，可以使用，更加方便
		System.out.println(Arrays.toString(nums)); // [45, 65, 76, 87, 98, 101]
		// 排序
		int[] num2 = {10,32,11,44,546,22,12};
		Arrays.sort(num2); // 快速排序
		System.out.println(Arrays.toString(num2));
		
		// 数组的复制
		int[] num3 = Arrays.copyOf(num2,10);
		System.out.println(Arrays.toString(num3));
		//
		int[] newNum = new int[num2.length];
		System.arraycopy(num2,0,newNum,0,num2.length);
		System.out.println(Arrays.toString(newNum));
		
		// 小结，数组的复制：
		/**
			效率由高到低排序是：System.arraycopy -> Arrays.copyOf -> for
		*/
		
		// 判断两个数组的值是否相等
		System.out.println(Arrays.equals(num2,newNum));
		
		// 填充数组
		Arrays.fill(newNum,0);
		System.out.println(Arrays.toString(newNum));
	}
}