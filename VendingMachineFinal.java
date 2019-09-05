package Exam0903;

import java.util.Scanner;

class Product {		// 상품 정보 클래스
	final int MAX_STORAGE_COUNT = 50;		// 재고 최대 보유량 제한
	int productStockCount;
	int productPrice;
	String productName;
	Product (String name, int productStockCount,int productPrice) {
		this.productName = name;
		this.productStockCount = productStockCount;
		this.productPrice = productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}	
	
}
class Water extends Product {		// 5개 상품의 초기값 설정
	Water () {
		super ("나는 물", 49, 1000);
	}
	@Override
	public String toString() {
		return "[나는 물]";
	}
}
class Cabo extends Product {
	Cabo () {
		super ("나는 탄산수", 40, 1500);
	}
	@Override
	public String toString() {
		return "[나는 탄산수]";
	}
}
class Sujeong extends Product {
	Sujeong () {
		super ("나는 수정과", 32, 1000);
	}
	@Override
	public String toString() {
		return "[나는 수정과]";
	}
}
class Orange extends Product {
	Orange () {
		super ("나는 오렌지주스", 3, 1300);
	}
	@Override
	public String toString() {
		return "[나는 오렌지주스]";
	}
}
class CanCoffee extends Product {
	CanCoffee () {
		super ("나는 캔커피", 13, 800);
	}
	@Override
	public String toString() {
		return "[나는 캔커피]";
	}
}

class Payment {			// 제품 결제 클래스
	Scanner scan = new Scanner(System.in);
	int totalSales=0;
	int insertMoney=0;
	
	public void insertMoneyMethod() {			// 입금 기능
		System.out.println();
		System.out.println("  안녕하세요! ");
		System.out.print("  입금할 금액을 입력하세요 : ");
		insertMoney += Integer.parseInt(scan.nextLine());
		if (insertMoney <0) {
			System.out.print("금액을 잘 못 입력하였습니다.  입금할 금액을 입력하세요 : ");
			insertMoney =0;
			insertMoney += Integer.parseInt(scan.nextLine());
		}
	}
	
	public void insertExtraMoneyMethod() {			// 추가 입금 기능
		System.out.println("추가 입금을 하시려면 금액을 입력하세요 (추가입금을 원치 않으신다면 0을 입력해주세요) : ");
		insertMoney += Integer.parseInt(scan.nextLine());
		if (insertMoney <0) {
			System.out.print("금액을 잘 못 입력하였습니다.  입금할 금액을 입력하세요 : ");
			insertMoney =0;
			insertMoney += Integer.parseInt(scan.nextLine());
		}
	}
	
	void payMoney (Product s) {			// 결제 및 잔돈 반환 기능
		if (s.productStockCount <= 0) {			// 품절상황 알림
			System.out.println();
			System.out.println("!!! 품절입니다. 다른 상품을 선택하세요 !!!");
			System.out.println();
		} else if (insertMoney < s.productPrice) {			// 잔액 부족상황 알림
			System.out.println();
			System.out.println("!!! 상품을 구매하기 위한 잔액이 부족합니다 !!!");
			System.out.println();
		} else {
			this.insertMoney -= s.productPrice;
			s.productStockCount--;
			totalSales += s.productPrice;
			System.out.println();
		}
	}
	
}

public class VendingMachineFinal {			// 자판기 메뉴 선택 클래스
	Scanner scan = new Scanner(System.in);
	Payment pay = new Payment();
	VendingMachineFinal () {
		System.out.println("자판기 가동");
	}

	int displayStart () {			// 초기 선택화면 구현 - 예외처리
		System.out.println("1. 관리자모드		 2.사용자모드		 3. 시스템 종료");
		int userinput = 0;
		do {
			try {
				userinput = Integer.parseInt(scan.nextLine());
				if (userinput >= 1 && userinput <=3) {
					break;		
				} else {
					throw new Exception("선택 문제 발생");
				}
			} catch (Exception e) {
				System.out.println("가동 메뉴 선택 문제");
				System.out.println("가동 메뉴 1~3번까지 선택");
			}
		} while (true);		
		return userinput;	
	}
	
	void machineStart (Product[] s) {			// 초기 선택화면 구현
		int sel = displayStart();
		switch (sel) {
		case 1: adminSelect(s);
			break;
		case 2:	customerSelect(s);
			break;
		default : 
			System.out.println("자판기 프로그램을 종료합니다");
			System.exit(0);	
		}
	}
	
	int adminDisplay () {			// 관리자 선택화면 구현 - 예외처리
		System.out.println("1. 재고확인                    2. 매출 확인                   3.가격변경                   4. 뒤로가기");
		int userinput = 0;
		do {
			try {
				userinput = Integer.parseInt(scan.nextLine());
				if (userinput >= 1 && userinput <=4) {
					break;		
				} else {
					throw new Exception("선택 문제 발생");
				}
			} catch (Exception e) {
				System.out.println("관리자 메뉴 선택 문제");
				System.out.println("관리자 메뉴 1~4번까지 선택");
			}
		} while (true);		
		return userinput;	
	}
	
	void adminSelect (Product[] s) {			// 관리자 선택화면 구현
		do {
			int sel = adminDisplay();
			switch (sel) {
			case 1: 			// 재고 상황 그래프 출력
				for (int i=0;i<s[0].productStockCount; i++) {
					System.out.print("■ ");
				}
				for (int i=s[0].productStockCount; i<s[0].MAX_STORAGE_COUNT; i++) {
					System.out.print("□ ");
				}
				System.out.printf("[%s개 남음   %s]\n", s[0].productStockCount, s[0].productName);
				System.out.println();
				for (int i=0;i<s[1].productStockCount; i++) {
					System.out.print("■ ");
				}
				for (int i=s[1].productStockCount; i<s[1].MAX_STORAGE_COUNT; i++) {
					System.out.print("□ ");
				}
				System.out.printf("[%s개 남음    %s]\n", s[1].productStockCount, s[1].productName);
				System.out.println();
				for (int i=0;i<s[2].productStockCount; i++) {
					System.out.print("■ ");
				}
				for (int i=s[2].productStockCount; i<s[2].MAX_STORAGE_COUNT; i++) {
					System.out.print("□ ");
				}
				System.out.printf("[%s개 남음    %s]\n", s[2].productStockCount, s[2].productName);
				System.out.println();
				for (int i=0;i<s[3].productStockCount; i++) {
					System.out.print("■ ");
				}
				for (int i=s[3].productStockCount; i<s[3].MAX_STORAGE_COUNT; i++) {
					System.out.print("□ ");
				}
				System.out.printf("[%s개 남음    %s]\n", s[3].productStockCount, s[3].productName);
				System.out.println();
				for (int i=0;i<s[4].productStockCount; i++) {
					System.out.print("■ ");
				}
				for (int i=s[4].productStockCount; i<s[4].MAX_STORAGE_COUNT; i++) {
					System.out.print("□ ");
				}System.out.printf("[%s개 남음    %s]\n", s[4].productStockCount, s[4].productName);
				System.out.println();
				break;
			case 2: 			// 총 매출액 조회
				System.out.println("총 매출액 : " +pay.totalSales + "원 입니다.");
				System.out.println();
				break;
			case 3:
				changePrice(s);			// 상품 가격 변경 기능 호출
				break;
			case 4: machineStart(s);			// 초기 선택메뉴로 복귀
				break;
			default :	
			}
		} while (true);
	}
	
	void changePrice (Product[] s) {			// 상품 가격 변경 기능
		showMenuSelection(s);
		System.out.println("가격을 변경할 상품의 번호를 입력하세요 : ");
		int userinput = (Integer.parseInt(scan.nextLine())-1);
		System.out.println("가격을 변경할 상품의 가격을 입력하세요 : ");
		s[userinput].setProductPrice(Integer.parseInt(scan.nextLine()));
	}

	void showMenuSelection(Product[] s) {			// 자판기 상품 정보 조회 기능
		System.out.printf ("1. 물 [%d 개]      2. 탄산수 [%d 개]     3. 수정과 [%d 개]     4. 오렌지주스 [%d 개]  5. 캔커피 [%d 개]    6.추가 금액 입금           0. 금액 반환\n",s[0].productStockCount,s[1].productStockCount,s[2].productStockCount,s[3].productStockCount,s[4].productStockCount);
		System.out.printf("   %4d원                     %4d원                        %4d원                        %4d원                        %4d원\n", s[0].productPrice, s[1].productPrice, s[2].productPrice, s[3].productPrice, s[4].productPrice);
		for (int i=0; i<5; i++) {
			if (s[i].productStockCount <=0) {
		  System.out.print("   [품절]          ");
			} else {
		  System.out.print("   [재고 있음]       ");
			}
		} 
		System.out.println();
	}
	
	int customerDisplay (Product[] s) {			// 사용자 선택화면 구현 - 예외처리
		showMenuSelection(s);
		System.out.println();
		System.out.println("주문할 상품의 번호를 입력하세요");
			
		int userinput = 0;
		do {
			try {
				userinput = Integer.parseInt(scan.nextLine());
				if (userinput == 98909  || userinput >= 0 && userinput <=6) {			// 98909 : 관리자 모드 진입을 위한 입력값
					break;		
				} else {
					throw new Exception("선택 문제 발생");
				}
			} catch (Exception e) {
				System.out.println("메뉴 선택 문제");
				System.out.println("메뉴 0~6번까지 선택");
			}
		} while (true);		
		
		return userinput;	
	}

	void customerSelect (Product[] s) {			// 사용자 선택화면 구현
		showMenuSelection(s);
		pay.insertMoneyMethod();
		do {
			System.out.println("현재 남은 금액은 "+pay.insertMoney +"원 입니다.");
			int sel = customerDisplay(s);
			switch (sel) {
			case 0: 			// 남은 금액 권종별 반환
				System.out.println("< 잔액 "+ pay.insertMoney +"원을 반환합니다. 사용해주셔서 감사합니다! >");
				int unit = 10000;
				int num;
				int sw = 0;
				do {
					num = pay.insertMoney / unit;
					System.out.printf("%6d 원 : %4d개 반환\n", unit, num );
					pay.insertMoney -= (unit * num);
					if(sw == 0) {
						sw = 1;
						unit /= 2;
					}else {
						unit /= 5;
						sw = 0;
					}
				}while((pay.insertMoney%100==0) ? unit>=100 : unit>=0);		// 100원 단위 존재 여부에 따른 선택적 출력
				 
				pay.insertMoney = 0;

				System.out.println();
				System.out.println();
				showMenuSelection(s);
				pay.insertMoneyMethod();
				break;
			case 1:
				System.out.println("< " + s[0].toString()+"을 선택했습니다.  가격은 " + s[0].productPrice +"원 입니다 >");
				pay.payMoney(s[0]);
				break;
			case 2:
				System.out.println("< " + s[1].toString()+"을 선택했습니다. 가격은 " + s[1].productPrice +"원 입니다 >");
				pay.payMoney(s[1]);
				break;
			case 3:
				System.out.println("< " + s[2].toString()+"을 선택했습니다. 가격은 " + s[2].productPrice +"원 입니다 >");
				pay.payMoney(s[2]);
				break;
			case 4:
				System.out.println("< " + s[3].toString()+"을 선택했습니다. 가격은 " + s[3].productPrice +"원 입니다 >");
				pay.payMoney(s[3]);
				break;
			case 5:
				System.out.println("< " + s[3].toString()+"을 선택했습니다. 가격은 " + s[4].productPrice +"원 입니다 >");
				pay.payMoney(s[4]);
				break;
			case 6:
				pay.insertExtraMoneyMethod();			// 추가 입금 기능 호출
				break;
			case 98909:			// 관리자 선택화면 호출
				machineStart(s);
			}
		} while (true); 
	}
	
	public static void main(String[] args) {
		
		VendingMachineFinal vm = new VendingMachineFinal();			// 자판기 초기화
		Product[] stock = { new Water(), new Cabo(), new Sujeong(), new Orange(), new CanCoffee() };			// 객체별 주소값 할당
		
		vm.machineStart(stock);
	}
}
