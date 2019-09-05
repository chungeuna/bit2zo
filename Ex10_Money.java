import java.util.Scanner;
public class Ex10_Money {
	static int unit = 10000;
	static int num;
	static public void dw() {
		int sw = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("금액을 입력하세요 : ");
		int money = Integer.parseInt(scan.nextLine());
		do {
			num = money / unit;
			System.out.println(unit + "원 : " + num + "개");
			money -= (unit * num);
			//System.out.println(money);
			if(sw == 0) {
				sw = 1;
				unit /= 2;
			}else {
				unit /= 5;
				sw = 0;
			}
		}while(unit > 0);
	}
	
	public static void main(String[] args) {
		dw();
	}
}
