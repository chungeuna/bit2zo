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
		super ("나는 물", 10, 1000);
	}
	@Override
	public String toString() {
		return "[나는 물]";
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
		super ("나는 탄산수", 10, 1500);
	}
	@Override
	public String toString() {
		return "[나는 탄산수]";
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
		super ("나는 수정과", 10, 1000);
	}
	@Override
	public String toString() {
		return "[나는 수정과]";
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
		super ("나는 오렌지주스", 10, 1300);
	}
	@Override
	public String toString() {
		return "[나는 오렌지 주스]";
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
		super ("나는 캔커피", 10, 800);
	}
	@Override
	public String toString() {
		return "[나는 캔커피]";
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
		System.out.print("입금할 금액을 입력하세요 (추가입금을 원치 않으신다면 0을 입력해주세요) : ");
		inputMoney += Integer.parseInt(scan.nextLine());
	}
	
	void exchangeMoney (Stock s) {
		inputMoney -= s.price;
		s.count--;
		Stock.totalSales += s.price;
		System.out.println("반환할 금액은 "+ inputMoney +"입니다.");
	}
	
}


public class VendingMachineSIMSMHAESEO {
	MoneyExchange me = new MoneyExchange();

	Scanner scan = new Scanner(System.in);
	VendingMachineSIMSMHAESEO () {
		System.out.println("자판기 가동");
	}
	
	
	int displayAdmin () {
		System.out.println("1. 재고관리                    2. 매출 확인                   3.가격조절                   4. 뒤로가기");
		int userInput = 0;
		do {
			try {
				userInput = Integer.parseInt(scan.nextLine());
				if (userInput >= 1 && userInput <=4) {
					break;		
				} else {
					throw new Exception("ㅈㅅ 선택 문제 발생");
				}
			} catch (Exception e) {
				System.out.println("관리자 메뉴 선택 문제");
				System.out.println("관리자 메뉴 1~4번까지 선택");
			}
		} while (true);		
		return userInput;	
	}
	
	int displayUser (Stock[] s) {
		System.out.printf ("1. 물 [%d 개]     2. 탄산수 [%d 개]     3. 수정과 [%d 개]     4. 오렌지주스 [%d 개]     5. 캔커피 [%d 개]          0. 금액 반환\n",s[0].count,s[1].count,s[2].count,s[3].count,s[4].count);
		System.out.println("   1000원                   1500원                         1000원                        1300원                             800원");
		System.out.println("주문할 상품의 번호를 입력하세요");
		int userInput = 0;
		do {
			try {
				userInput = Integer.parseInt(scan.nextLine());
				if (userInput == 98909  || userInput >= 0 && userInput <=5) {
					break;		
				} else {
					throw new Exception("ㅈㅅ 선택 문제 발생");
				}
			} catch (Exception e) {
				System.out.println("메뉴 선택 문제");
				System.out.println("메뉴 0~5번까지 선택");
			}
		} while (true);		
		
		return userInput;	
	}
	int displayStart () {
		System.out.println("1. 관리자모드		 2.사용자모드		 3. 시스템 종료");
		int userInput = 0;
		do {
			try {
				userInput = Integer.parseInt(scan.nextLine());
				if (userInput >= 1 && userInput <=3) {
					break;		
				} else {
					throw new Exception("ㅈㅅ 선택 문제 발생");
				}
			} catch (Exception e) {
				System.out.println("메뉴 선택 문제");
				System.out.println("메뉴 1~3번까지 선택");
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
			System.out.println("자판기 프로그램을 종료합니다");
			System.exit(0);	
		}
	}
	
	void adminSelect () {
		do {
			switch (displayAdmin()) {
			case 1:System.out.println("안녕1?");
			case 2:System.out.println("안녕2?");
			case 3:System.out.println("안녕3?");
			case 4:System.out.println("안녕4?");
			break;
			}
		} while (true);
		
		/*do {
			switch(displayAdmin()) {		// 여기 들어갈 함수 
			case 1:	System.out.println("안녕1?");
				break;
			case 2: System.out.println(Stock.totalSales);
				break;
			case 3: System.out.println("안녕3?");
				break;
			case 4: machineStart();
				break;
			default : System.out.println("다시 입력하세요 -adminSelct");
			}
		} while (true);*/
	}
	
	void userSelect (Stock[] s) {
		
		do {
			me.inputMoneyMethod();
			System.out.println("현재 남은 금액은 "+me.inputMoney +"원 입니다.");
			switch (displayUser(s)) {
			case 0: System.out.println("<<< 잔액 "+ me.inputMoney +"를 반환하였습니다. 사용해주셔서 감사합니다! >>>");
				me.inputMoney = 0;
				me.inputMoneyMethod();
			case 1:
				System.out.println("<< " + s[0].toString()+"을 선택했습니다. 가격은" + s[0].price +"입니다 >>");
				me.exchangeMoney(s[0]);
				break;
			case 2:
				System.out.println("<< " + s[1].toString()+"을 선택했습니다. 가격은" + s[1].price +"입니다 >>");
			me.exchangeMoney(s[1]);
			break;
			case 3:
				System.out.println("<< " + s[2].toString()+"을 선택했습니다. 가격은" + s[2].price +"입니다 >>");
			me.exchangeMoney(s[2]);
			break;
			case 4:
				System.out.println("<< " + s[3].toString()+"을 선택했습니다. 가격은" + s[3].price +"입니다 >>");
			me.exchangeMoney(s[3]);
			case 5:
				System.out.println("<< " + s[3].toString()+"을 선택했습니다. 가격은" + s[4].price +"입니다 >>");
			me.exchangeMoney(s[4]);
			break;
			case 98909:
				machineStart();
			}
		} while (me.inputMoney < s[4].price);
		 System.out.println("<<< 잔액 "+ me.inputMoney +"를 반환하였습니다. 사용해주셔서 감사합니다! >>>");
	}
	
	public static void main(String[]args ) {
		
		VendingMachineSIMSMHAESEO ma = new VendingMachineSIMSMHAESEO();
		
		Stock[] stock = { new Water(), new Cabo(), new Sujeong(), new Orange(), new CanCoffee() };
		ma.machineStart();
		ma.userSelect(stock);
		
	}
}
