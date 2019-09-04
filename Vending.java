import java.util.Scanner;

class Stock {
	int inStock; //
	String[] numOfStock; // 재고량
	int price; // 가격
	String name; // 제품명

	/* abstract */void stockMinus(int num) {
		for (String str : numOfStock) {
			if (str == name) {
				for (int j = 0; j < num; j++) {
					str = "E"; // empty
				}

			}
		}
	}

	/* abstract */void outOfStock() {
		int count = 0;
		for (String str : numOfStock) {
			if (str == name) {
				count++;
			}
		}
		if (count < 5) {
			System.out.println("재고가 없습니다.");
		}
	}

	Stock(int price, String name) {
		initStock(numOfStock);
		this.price = price;
		this.name = name;
	}

	void initStock(String[] sarray) {
		sarray = new String[50];
		for (String s : sarray) {
			s = "E";
		}
	}

	void inputStock(int num) {
		for (int i = 0; i < numOfStock.length; i++) {
			if (numOfStock[i] == "E") {
				for (int j = 0; j < num; j++)
					numOfStock[j] = name;
			}
		}
	}

	void show() {
		System.out.println("가격은 " + price + "입니다.");
	}

}

class Icis extends Stock {

	Icis() {
		super(1000, "좋은물");

	}

	@Override
	public String toString() {
		return "Icis";
	}

}

class Cabo extends Stock {
	Cabo() {
		super(1500, "좋은탄산수");
	}

	@Override
	public String toString() {
		return "Cabo";
	}
}

class Juice extends Stock {
	Juice() {
		super(1300, "좋은주스");

	}

	@Override
	public String toString() {
		return "Juice";
	}
}

class CanCoffee extends Stock {
	CanCoffee() {
		super(800, "캔커피");
	}

	@Override
	public String toString() {
		return "CanCoffee";
	}
}

class Sujerng extends Stock {
	Sujerng() {
		super(1000, "수정과");
	}

	@Override
	public String toString() {
		return "Sujerng";
	}
}

class Show {
	int money;

	void show(Stock s) {
		s.show();
		

	}

	void buy(Stock s) {

	}

	void money(int money, Stock s) {
		this.money = money;
		int change = money - s.price;
		
		System.out.println("잔돈은 :" + change);	
	}
}

class SalesMethod {

	void menu() {
		int mo;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("2조 자판기");
		
		System.out.println("돈을 넣어주세요.");
		mo = Integer.parseInt(scan.nextLine());
		System.out.println("투입 금액 : " + mo);
		
		
		System.out.println("상품을 선택하세요");
		System.out.println("1.물        │ 2.탄산수   | 3.수정과  |  4.오렌지주스   | 5.캔커피 ");
		System.out.println("1000원    │ 1500원    | 1000원    |  1300원   	  | 800원");
		
		int sel = Integer.parseInt(scan.nextLine());
		Show show = new Show();
	
		switch (sel) {
		case 1:
			show.show(new Icis());
			show.money(mo, new Icis());
			break;
		case 2:
			show.show(new Cabo());
			show.money(mo, new Cabo());
			break;
		case 3:
			show.show(new Sujerng());
			show.money(mo, new Icis());
			break;
		case 4:
			show.show(new Juice());
			break;
		case 5:
			show.show(new CanCoffee());
			break;
		}
		
		
		
	}

}
class Admin1 {
	void menuAdmin(int num) {
		if (num == 1) {
			System.out.println("관리자 모드 입니다.");
		} else {
			System.out.println("판매 모드 입니다.");
			SalesMethod m2 = new SalesMethod();
			// 돈 받기 함수
			m2.menu();
		}
	}

}

public class Vending {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Admin1 a = new Admin1();
		System.out.println("2조 자판기 관리 메뉴");
		System.out.println("1.관리자 모드    2.판매 모드 ");
		int selection = sc.nextInt();
		a.menuAdmin(selection);

	}
}