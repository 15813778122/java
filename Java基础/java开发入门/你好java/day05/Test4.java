public class Test4{
	public static void main(String[] args){
		int[] num = {3,56,86,41,88};
		int maxCount = max(num);
		System.out.println("the max count is:"+maxCount);
		int minCount = min(num);
		System.out.println("the min count is:"+minCount);
	}
	public static int max(int[] sum){
		int max = sum[0];
		int len = sum.length;
		for(int i = 0;i < len;i++){
			if(sum[i]>max){
				sum[i] = sum[i]+max;
				max = sum[i]-max;
				sum[i] = sum[i]-max;
			}
			
		}
		return max;
	}
	public static int min(int[] sum){
		int min = sum[0];
		int len = sum.length;
		for(int i = 0;i < len;i++){
			if(sum[i]<min){
				sum[i] = sum[i]+min;
				min = sum[i]-min;
				sum[i] = sum[i]-min;
			}
			
		}
		return min;
	}
}