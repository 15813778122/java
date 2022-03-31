public class Test3{
	public static void main(String[] args){
		int[][] scores = {{88,78,98},{80,72,94},{89,79,99}};
		int classLens = scores.length;
		for(int i = 0;i < classLens;i++){
			int sum = 0;
			for(int j = 0;j< scores[i].length;j++){
				sum += scores[i][j];
			}
			int avg = sum/scores[i].length;
			System.out.println(avg);
		}
	}
}