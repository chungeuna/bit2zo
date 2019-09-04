package Exam0903;

import java.util.Scanner;


interface Isellable {	
	void sell(MoneyExchange me);
	// void refill();
}
class Stock {
	static int totalSales=0;
	final int MAX_COUNT = 30;
	int count;
	int price;
	String productName;
	Stock (String name, int count,int price) {
		this.productName = name;
		this.count = count;
		this.price = price;
	}
}
class Water extends Stock implements Isellable{
	Water () {
		super ("���� ��", 10, 1000);
	}
	@Override
	public String toString() {
		return "[���� ��]";
	}
	@Override
	public void sell(MoneyExchange me) {
		me.inputMoney -= this.price;
		totalSales += this.price;
		count--;	
	}
}
class Cabo extends Stock implements Isellable{
	Cabo () {
		super ("���� ź���", 10, 1500);
	}
	@Override
	public String toString() {
		return "[���� ź���]";
	}
	@Override
	public void sell(MoneyExchange me) {
		me.inputMoney -= this.price;
		totalSales += this.price;
		count--;	
	}
}

class Sujeong extends Stock implements Isellable{
	Sujeong () {
		super ("���� ������", 10, 1000);
	}
	@Override
	public String toString() {
		return "[���� ������]";
	}
	@Override
	public void sell(MoneyExchange me) {
		me.inputMoney -= this.price;
		totalSales += this.price;
		count--;	
	}
}

class Orange extends Stock implements Isellable{
	Orange () {
		super ("���� �������ֽ�", 10, 1300);
	}
	@Override
	public String toString() {
		return "[���� ������ �ֽ�]";
	}
	@Override
	public void sell(MoneyExchange me) {
		me.inputMoney -= this.price;
		totalSales += this.price;
		count--;	
	}
}
class CanCoffee extends Stock implements Isellable{
	CanCoffee () {
		super ("���� ĵĿ��", 10, 800);
	}
	@Override
	public String toString() {
		return "[���� ĵĿ��]";
	}
	@Override
	public void sell(MoneyExchange me) {
		me.inputMoney -= this.price;
		totalSales += this.price;
		count--;	
	}
}

class MoneyExchange {
	Scanner scan = new Scanner(System.in);
	int inputMoney=0;
	
	public void inputMoneyMethod() {
		System.out.println();
		System.out.print("�Ա��� �ݾ��� �Է��ϼ��� (�߰��Ա��� ��ġ �����Ŵٸ� 0�� �Է����ּ���) : ");
		inputMoney += Integer.parseInt(scan.nextLine());
	}
	
	void exchangeMoney (Stock s) {
		inputMoney -= s.price;
		s.count--;
		Stock.totalSales += s.price;
		System.out.println("��ȯ�� �ݾ��� "+ inputMoney +"�Դϴ�.");
	}
	
}


public class VendingMachineSIMSMHAESEO {
	MoneyExchange me = new MoneyExchange();

	Scanner scan = new Scanner(System.in);
	VendingMachineSIMSMHAESEO () {
		System.out.println("���Ǳ� ����");
	}
	
	
	int displayAdmin () {
		System.out.println("1. ������                    2. ���� Ȯ��                   3.��������                   4. �ڷΰ���");
		int userInput = 0;
		do {
			try {
				userInput = Integer.parseInt(scan.nextLine());
				if (userInput >= 1 && userInput <=4) {
					break;		
				} else {
					throw new Exception("���� ���� ���� �߻�");
				}
			} catch (Exception e) {
				System.out.println("������ �޴� ���� ����");
				System.out.println("������ �޴� 1~4������ ����");
			}
		} while (true);		
		return userInput;	
	}
	
	int displayUser (Stock[] s) {
		System.out.printf ("1. �� [%d ��]     2. ź��� [%d ��]     3. ������ [%d ��]     4. �������ֽ� [%d ��]     5. ĵĿ�� [%d ��]          0. �ݾ� ��ȯ\n",s[0].count,s[1].count,s[2].count,s[3].count,s[4].count);
		System.out.println("   1000��                   1500��                         1000��                        1300��                             800��");
		System.out.println("�ֹ��� ��ǰ�� ��ȣ�� �Է��ϼ���");
		int userInput = 0;
		do {
			try {
				userInput = Integer.parseInt(scan.nextLine());
				if (userInput == 98909  || userInput >= 0 && userInput <=5) {
					break;		
				} else {
					throw new Exception("���� ���� ���� �߻�");
				}
			} catch (Exception e) {
				System.out.println("�޴� ���� ����");
				System.out.println("�޴� 0~5������ ����");
			}
		} while (true);		
		
		return userInput;	
	}
	int displayStart () {
		System.out.println("1. �����ڸ��		 2.����ڸ��		 3. �ý��� ����");
		int userInput = 0;
		do {
			try {
				userInput = Integer.parseInt(scan.nextLine());
				if (userInput >= 1 && userInput <=3) {
					break;		
				} else {
					throw new Exception("���� ���� ���� �߻�");
				}
			} catch (Exception e) {
				System.out.println("�޴� ���� ����");
				System.out.println("�޴� 1~3������ ����");
			}
		} while (true);		
		return userInput;	
	}
	void machineStart () {
		switch (displayStart()) {
		case 1: displayAdmin();
			break;
		case 2:	// displayUser(s);
			break;
		default : 
			System.out.println("���Ǳ� ���α׷��� �����մϴ�");
			System.exit(0);	
		}
	}
	
	void adminSelect () {
		do {
			switch (displayAdmin()) {
			case 1:System.out.println("�ȳ�1?");
			case 2:System.out.println("�ȳ�2?");
			case 3:System.out.println("�ȳ�3?");
			case 4:System.out.println("�ȳ�4?");
			break;
			}
		} while (true);
		
		/*do {
			switch(displayAdmin()) {		// ���� �� �Լ� 
			case 1:	System.out.println("�ȳ�1?");
				break;
			case 2: System.out.println(Stock.totalSales);
				break;
			case 3: System.out.println("�ȳ�3?");
				break;
			case 4: machineStart();
				break;
			default : System.out.println("�ٽ� �Է��ϼ��� -adminSelct");
			}
		} while (true);*/
	}
	
	void userSelect (Stock[] s) {
		
		do {
			me.inputMoneyMethod();
			System.out.println("���� ���� �ݾ��� "+me.inputMoney +"�� �Դϴ�.");
			switch (displayUser(s)) {
			case 0: System.out.println("<<< �ܾ� "+ me.inputMoney +"�� ��ȯ�Ͽ����ϴ�. ������ּż� �����մϴ�! >>>");
				me.inputMoney = 0;
				me.inputMoneyMethod();
			case 1:
				System.out.println("<< " + s[0].toString()+"�� �����߽��ϴ�. ������" + s[0].price +"�Դϴ� >>");
				me.exchangeMoney(s[0]);
				break;
			case 2:
				System.out.println("<< " + s[1].toString()+"�� �����߽��ϴ�. ������" + s[1].price +"�Դϴ� >>");
			me.exchangeMoney(s[1]);
			break;
			case 3:
				System.out.println("<< " + s[2].toString()+"�� �����߽��ϴ�. ������" + s[2].price +"�Դϴ� >>");
			me.exchangeMoney(s[2]);
			break;
			case 4:
				System.out.println("<< " + s[3].toString()+"�� �����߽��ϴ�. ������" + s[3].price +"�Դϴ� >>");
			me.exchangeMoney(s[3]);
			case 5:
				System.out.println("<< " + s[3].toString()+"�� �����߽��ϴ�. ������" + s[4].price +"�Դϴ� >>");
			me.exchangeMoney(s[4]);
			break;
			case 98909:
				machineStart();
			}
		} while (me.inputMoney < s[4].price);
		 System.out.println("<<< �ܾ� "+ me.inputMoney +"�� ��ȯ�Ͽ����ϴ�. ������ּż� �����մϴ�! >>>");
	}
	
	public static void main(String[]args ) {
		
		VendingMachineSIMSMHAESEO ma = new VendingMachineSIMSMHAESEO();
		
		Stock[] stock = { new Water(), new Cabo(), new Sujeong(), new Orange(), new CanCoffee() };
		ma.machineStart();
		ma.userSelect(stock);
		
	}
}
