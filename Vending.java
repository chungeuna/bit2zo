import java.util.Scanner;

class Stock {
	int inStock; //
	String[] numOfStock; // ���
	int price; // ����
	String name; // ��ǰ��

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
			System.out.println("��� �����ϴ�.");
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
		System.out.println("������ " + price + "�Դϴ�.");
	}

}

class Icis extends Stock {

	Icis() {
		super(1000, "������");

	}

	@Override
	public String toString() {
		return "Icis";
	}

}

class Cabo extends Stock {
	Cabo() {
		super(1500, "����ź���");
	}

	@Override
	public String toString() {
		return "Cabo";
	}
}

class Juice extends Stock {
	Juice() {
		super(1300, "�����ֽ�");

	}

	@Override
	public String toString() {
		return "Juice";
	}
}

class CanCoffee extends Stock {
	CanCoffee() {
		super(800, "ĵĿ��");
	}

	@Override
	public String toString() {
		return "CanCoffee";
	}
}

class Sujerng extends Stock {
	Sujerng() {
		super(1000, "������");
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
		
		System.out.println("�ܵ��� :" + change);	
	}
}

class SalesMethod {

	void menu() {
		int mo;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("2�� ���Ǳ�");
		
		System.out.println("���� �־��ּ���.");
		mo = Integer.parseInt(scan.nextLine());
		System.out.println("���� �ݾ� : " + mo);
		
		
		System.out.println("��ǰ�� �����ϼ���");
		System.out.println("1.��        �� 2.ź���   | 3.������  |  4.�������ֽ�   | 5.ĵĿ�� ");
		System.out.println("1000��    �� 1500��    | 1000��    |  1300��   	  | 800��");
		
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
			System.out.println("������ ��� �Դϴ�.");
		} else {
			System.out.println("�Ǹ� ��� �Դϴ�.");
			SalesMethod m2 = new SalesMethod();
			// �� �ޱ� �Լ�
			m2.menu();
		}
	}

}

public class Vending {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Admin1 a = new Admin1();
		System.out.println("2�� ���Ǳ� ���� �޴�");
		System.out.println("1.������ ���    2.�Ǹ� ��� ");
		int selection = sc.nextInt();
		a.menuAdmin(selection);

	}
}