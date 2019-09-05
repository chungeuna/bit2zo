import java.util.Scanner;

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
class Water extends Stock {
	Water () {
		super ("나는 물", 10, 1000);
	}
	@Override
	public String toString() {
		return "[나는 물]";
	}
}
class Cabo extends Stock {
	Cabo () {
		super ("나는 탄산수", 10, 1500);
	}
	@Override
	public String toString() {
		return "[나는 탄산수]";
	}
}

class Sujeong extends Stock {
	Sujeong () {
		super ("나는 수정과", 10, 1000);
	}
	@Override
	public String toString() {
		return "[나는 수정과]";
	}
}

class Orange extends Stock {
	Orange () {
		super ("나는 오렌지주스", 10, 1300);
	}
	@Override
	public String toString() {
		return "[나는 오렌지 주스]";
	}
}
class CanCoffee extends Stock {
	CanCoffee () {
		super ("나는 캔커피", 20, 800);
	}
	@Override
	public String toString() {
		return "[나는 캔커피]";
	}
}

class MoneyExchange {
	Scanner scan = new Scanner(System.in);
	int inputMoney=0;
	
	public void inputMoneyMethod() {
		System.out.println();
		System.out.println("  안녕하세요! ");
		System.out.print("  입금할 금액을 입력하세요 : ");
		inputMoney += Integer.parseInt(scan.nextLine());
	}
	public void inputExtraMoneyMethod() {
		System.out.println("추가 입금을 하시려면 금액을 입력하세요 (추가입금을 원치 않으신다면 0을 입력해주세요) : ");
		inputMoney += Integer.parseInt(scan.nextLine());
	}
	
	void exchangeMoney (Stock s) {
		if (s.count <=0) {
			System.out.println("품절입니다. 다른 상품을 선택하세요");
		} else if (inputMoney < s.price) {
			System.out.println("상품을 사기위한 잔액이 부족합니다..");
		} else {
			this.inputMoney -= s.price;
			s.count--;
			Stock.totalSales += s.price;
			System.out.println("반환할 금액은 "+ inputMoney +"입니다.");
		}
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
		int userInput2 = 0;
		do {
			try {
				userInput2 = Integer.parseInt(scan.nextLine());
				if (userInput2 >= 1 && userInput2 <=4) {
					break;		
				} else {
					throw new Exception("ㅈㅅ 선택 문제 발생");
				}
			} catch (Exception e) {
				System.out.println("관리자 메뉴 선택 문제");
				System.out.println("관리자 메뉴 1~4번까지 선택");
			}
		} while (true);		
		return userInput2;	
	}
	
	int displayUser (Stock[] s) {
		System.out.println(                                                                                                           );
		System.out.printf ("1. 물 [%d 개]      2. 탄산수 [%d 개]     3. 수정과 [%d 개]     4. 오렌지주스 [%d 개]  5. 캔커피 [%d 개]    6.추가 금액 입금           0. 금액 반환\n",s[0].count,s[1].count,s[2].count,s[3].count,s[4].count);
		System.out.println("   1000원                     1500원                        1000원                       1300원                       800원");
		for (int i=0; i<5; i++) {
			if (s[i].count <=0) {
		  System.out.print("   [품절]          ");
			} else {
		  System.out.print("   [재고 있음]       ");
				
			}
		} 
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("주문할 상품의 번호를 입력하세요");
		int userInput = 0;
		do {
			try {
				userInput = Integer.parseInt(scan.nextLine());
				if (userInput == 98909  || userInput >= 0 && userInput <=6) {
					break;		
				} else {
					throw new Exception("ㅈㅅ 선택 문제 발생");
				}
			} catch (Exception e) {
				System.out.println("메뉴 선택 문제");
				System.out.println("메뉴 0~6번까지 선택");
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
		int sel = displayStart();
		
		switch (sel) {
		case 1: displayAdmin();
			break;
		case 2:	//displayUser(s);
			break;
		default : 
			System.out.println("자판기 프로그램을 종료합니다");
			System.exit(0);	
		}
	}
	
	void adminSelect () {
		int sel = displayAdmin();
		do {
			switch (sel) {
			case 1: System.out.println("안녕1?");
				break;
			case 2: System.out.println("안녕2?");
				break;
			case 3: System.out.println("안녕3?");
				break;
			case 4: machineStart();
				break;
			default : 
				
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
		int sel = displayUser(s);
		me.inputMoneyMethod();
		do {
			
			System.out.println("현재 남은 금액은 "+me.inputMoney +"원 입니다.");
			switch (sel) {
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
			case 6: me.inputExtraMoneyMethod();
			case 98909:
				machineStart();
			}
		} while (true); // me.inputMoney < s[4].price
		// System.out.println("<<< 잔액 "+ me.inputMoney +"를 반환하였습니다. 사용해주셔서 감사합니다! >>>");
	}
	
	public static void main(String[]args ) {
		
		VendingMachineSIMSMHAESEO ma = new VendingMachineSIMSMHAESEO();
		
		Stock[] stock = { new Water(), new Cabo(), new Sujeong(), new Orange(), new CanCoffee() };
		ma.machineStart();
		ma.userSelect(stock);
		
	}
}
