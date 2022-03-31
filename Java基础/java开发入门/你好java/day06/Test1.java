import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class Test1{
	public static void main(String[] args){
		
		int[] userRedBall = new int[6]; // 用户手选红球号码
		int[] sysRedBall = new int[6]; // 系统选红球号码
		int userBlueBall = 0; // 用户手选蓝球
		int sysBlueBall = 0; // 系统选蓝球
		int redCount = 0; // 记录用户选择正确的红球数
		int blueCount = 0; // 记录用户选择正确的蓝球数
		int[] redBall = new int[33]; // 存放红球的 1-33
		Scanner input = new Scanner(System.in);
		// 给redBall存放1-33
		for(int i = 1;i <= redBall.length;i++) {
			redBall[i] = i;
		}
		
		// 游戏开始，系统提示
		System.out.println("双色球游戏开始，good luck");
		System.out.println("请选择是机选还是手选（1.机选，2.手选）");
		Scanner input = new Scanner(System.in);
		
		Random r = new Random();
		boolean flag = true;
		while(flag) {
			int isAuto = input.nextInt();
			switch(isAuto){
				case 1:
				// 机选
				computerSelection(redBall, userRedBall);
				userBlueBall = r.nextInt(15)+1;
				flag = false;
				break;
			case 2:
				// 手选
				System.out.println("请选择6个红球号码");
				for(int i = 0;i < userRedBall.length;i++){
					userRedBall[i] = input.nextInt();
				}
				System.out.println("请选择1个蓝球号码");
				userBlueBall = input.nextInt();
				flag = false;
				break;
			default:
				System.out.println("请选择是机选还是手选（1.机选，2.手选）");
				break;
			}
		
			// 系统随机产生的红球
			// 红球
			computerSelection(redBall, sysRedBall);
			// 蓝球
			sysBlueBall = r.nextInt(16)+1;
			// 统计结果:
			// 统计红球
			for(int i = 0;i < userRedBall.length;i++){
				for(int j = 0;j < sysRedBall.length-redCount;j++){
					if (userRedBall[i]==sysRedBall[j]){
						int temp = sysRedBall[j];
						sysRedBall[j] = sysRedBall[sysRedBall.length-1-redCount];
						sysRedBall[sysRedBall.length-1-redCount] = temp;
						redCount++;
						break;
					}
				}
			}
			// 统计蓝球
			if(userBlueBall == sysBlueBall) {
				blueCount = 1;
			}
			// 验证是否中奖
			if (blueCount == 0 && redCount <= 3) {
				System.out.println("革命尚未成功，同志仍需努力！");
			} else if(blueCount == 1 && redCount < 3) {
				System.out.println("中了六等奖，5块钱！");
			} else if ((blueCount == 1 && redCount == 3) || (blueCount == 0 && redCount == 4)){
				System.out.println("中了五等奖，10块钱！");
			} else if ((blueCount == 1 && redCount == 4) || (blueCount == 0 && redCount == 5)){
				System.out.println("中了四等奖，200块钱！");
			} else if ((blueCount == 1 && redCount == 5)){
				System.out.println("中了三等奖，3000块钱！");
			} else if ((blueCount == 0 && redCount == 6)){
				System.out.println("中了二等奖，10000块钱！");
			} else if ((blueCount == 1 && redCount == 6)){
				System.out.println("中了一等奖，100000块钱！");
			} else {
				System.out.println("系统有误");
			}
			
			// 公布系统号码
			System.out.println("本期中奖红球号码为");
			sort(sysRedBall);
			System.out.println(Array.toString(sysRedBall));
			System.out.println("本期中奖蓝球号码为"+sysBlueBall);
			
			// 公布用户号码
			System.out.println("本期您选的红球号码为");
			sort(userRedBall);
			System.out.println(Array.toString(userRedBall));
			System.out.println("本期您选择的蓝球号码为"+userBlueBall);
		}
		// 冒泡排序
		public static void sort(int[] balls){
			for(int i = 0;i < balls.length-1;i++){
				for(int j = 0;j < balls.length-1-i;j++){
					if(balls[j]>balls[j+1]){
						balls[j] = balls[j] + balls[j+1];
						balls[j+1] = balls[j] - balls[j+1];
						balls[j] = balls[j] - balls[j+1];
					}
				}
			}
		}
		
		public static void computerSelection(int[] redBall. int[] userRedBall) {
			Random r = new Random();
			int index = -1;
			for(int i = 0;i < userRedBall.length;i++) {
				index = r.nextInt(redBall.length-i);
				userRedBall[i] = redBall[index];
				
				int temp = redBall[index];
				redBall[index] = redBall[redBall.length-1-i];
				redBall[redBall.length-1-i] = temp;
			}
		}
	}
}