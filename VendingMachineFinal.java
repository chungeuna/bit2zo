package Exam0903;

import java.util.Scanner;

class Product {		// ��ǰ ���� Ŭ����
	final int MAX_STORAGE_COUNT = 50;		// ��� �ִ� ������ ����
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
class Water extends Product {		// 5�� ��ǰ�� �ʱⰪ ����
	Water () {
		super ("���� ��", 49, 1000);
	}
	@Override
	public String toString() {
		return "[���� ��]";
	}
}
class Cabo extends Product {
	Cabo () {
		super ("���� ź���", 40, 1500);
	}
	@Override
	public String toString() {
		return "[���� ź���]";
	}
}
class Sujeong extends Product {
	Sujeong () {
		super ("���� ������", 32, 1000);
	}
	@Override
	public String toString() {
		return "[���� ������]";
	}
}
class Orange extends Product {
	Orange () {
		super ("���� �������ֽ�", 3, 1300);
	}
	@Override
	public String toString() {
		return "[���� �������ֽ�]";
	}
}
class CanCoffee extends Product {
	CanCoffee () {
		super ("���� ĵĿ��", 13, 800);
	}
	@Override
	public String toString() {
		return "[���� ĵĿ��]";
	}
}

class Payment {			// ��ǰ ���� Ŭ����
	Scanner scan = new Scanner(System.in);
	int totalSales=0;
	int insertMoney=0;
	
	public void insertMoneyMethod() {			// �Աݾ� �޴� ���
		System.out.println();
		System.out.println("  �ȳ��ϼ���! ");
		System.out.print("  �Ա��� �ݾ��� �Է��ϼ��� : ");
		insertMoney += Integer.parseInt(scan.nextLine());
		if (insertMoney <0) {
			System.out.print("�ݾ��� �� �� �Է��Ͽ����ϴ�.  �Ա��� �ݾ��� �Է��ϼ��� : ");
			insertMoney =0;
			insertMoney += Integer.parseInt(scan.nextLine());
		}
	}
	
	public void insertExtraMoneyMethod() {			// �߰� �Աݾ� �޴� ���
		System.out.println("�߰� �Ա��� �Ͻ÷��� �ݾ��� �Է��ϼ��� (�߰��Ա��� ��ġ �����Ŵٸ� 0�� �Է����ּ���) : ");
		insertMoney += Integer.parseInt(scan.nextLine());
		if (insertMoney <0) {
			System.out.print("�ݾ��� �� �� �Է��Ͽ����ϴ�.  �Ա��� �ݾ��� �Է��ϼ��� : ");
			insertMoney =0;
			insertMoney += Integer.parseInt(scan.nextLine());
		}
	}
	
	void payMoney (Product s) {			// ���� �� �ܵ� ��ȯ ���
		if (s.productStockCount <= 0) {			// ǰ����Ȳ �˸�
			System.out.println();
			System.out.println("!! ǰ���Դϴ�. �ٸ� ��ǰ�� �����ϼ��� !!");
			System.out.println();
		} else if (insertMoney < s.productPrice) {			// �ܾ� ������Ȳ �˸�
			System.out.println();
			System.out.println("!! ��ǰ�� �����ϱ� ���� �ܾ��� �����մϴ� !!");
			System.out.println();
		} else {
			this.insertMoney -= s.productPrice;
			s.productStockCount--;
			totalSales += s.productPrice;
			System.out.println();
		}
	}
	
}

public class VendingMachineFinal {			// ���Ǳ� �޴� ���� Ŭ����
	Scanner scan = new Scanner(System.in);
	Payment pay = new Payment();
	VendingMachineFinal () {
		System.out.println("���Ǳ� ����");
	}

	int displayStart () {			// �ʱ� ����ȭ�� ���� - ����ó��
		System.out.println("1. �����ڸ��		 2.����ڸ��		 3. �ý��� ����");
		int userinput = 0;
		do {
			try {
				userinput = Integer.parseInt(scan.nextLine());
				if (userinput >= 1 && userinput <=3) {
					break;		
				} else {
					throw new Exception("���� ���� �߻�");
				}
			} catch (Exception e) {
				System.out.println("���� �޴� ���� ����");
				System.out.println("���� �޴� 1~3������ ����");
			}
		} while (true);		
		return userinput;	
	}
	
	void machineStart (Product[] s) {			// �ʱ� ����ȭ�� ����
		int sel = displayStart();
		
		switch (sel) {
		case 1: adminSelect(s);
			break;
		case 2:	customerSelect(s);
			break;
		default : 
			System.out.println("���Ǳ� ���α׷��� �����մϴ�");
			System.exit(0);	
		}
	}
	
	int adminDisplay () {			// ������ ����ȭ�� ���� - ����ó��
		System.out.println("1. ���Ȯ��                    2. ���� Ȯ��                   3.���ݺ���                   4. �ڷΰ���");
		int userinput = 0;
		do {
			try {
				userinput = Integer.parseInt(scan.nextLine());
				if (userinput >= 1 && userinput <=4) {
					break;		
				} else {
					throw new Exception("���� ���� �߻�");
				}
			} catch (Exception e) {
				System.out.println("������ �޴� ���� ����");
				System.out.println("������ �޴� 1~4������ ����");
			}
		} while (true);		
		return userinput;	
	}
	
	void adminSelect (Product[] s) {			// ������ ����ȭ�� ����
		
		do {
			int sel = adminDisplay();
			switch (sel) {
			case 1: 			// ��� ��Ȳ �׷��� ���
				for (int i=0;i<s[0].productStockCount; i++) {
					System.out.print("�� ");
				}
				for (int i=s[0].productStockCount; i<s[0].MAX_STORAGE_COUNT; i++) {
					System.out.print("�� ");
				}
				System.out.printf("[%s�� ����   %s]\n", s[0].productStockCount, s[0].productName);
				System.out.println();
				for (int i=0;i<s[1].productStockCount; i++) {
					System.out.print("�� ");
				}
				for (int i=s[1].productStockCount; i<s[1].MAX_STORAGE_COUNT; i++) {
					System.out.print("�� ");
				}
				System.out.printf("[%s�� ����    %s]\n", s[1].productStockCount, s[1].productName);
				System.out.println();
				for (int i=0;i<s[2].productStockCount; i++) {
					System.out.print("�� ");
				}
				for (int i=s[2].productStockCount; i<s[2].MAX_STORAGE_COUNT; i++) {
					System.out.print("�� ");
				}
				System.out.printf("[%s�� ����    %s]\n", s[2].productStockCount, s[2].productName);
				System.out.println();
				for (int i=0;i<s[3].productStockCount; i++) {
					System.out.print("�� ");
				}
				for (int i=s[3].productStockCount; i<s[3].MAX_STORAGE_COUNT; i++) {
					System.out.print("�� ");
				}
				System.out.printf("[%s�� ����    %s]\n", s[3].productStockCount, s[3].productName);
				System.out.println();
				
				for (int i=0;i<s[4].productStockCount; i++) {
					System.out.print("�� ");
				}
				for (int i=s[4].productStockCount; i<s[4].MAX_STORAGE_COUNT; i++) {
					System.out.print("�� ");
				}System.out.printf("[%s�� ����    %s]\n", s[4].productStockCount, s[4].productName);
				System.out.println();
				break;
			case 2: 			// �� ����� ��ȸ
				System.out.println("�� ����� : " +pay.totalSales + "�� �Դϴ�.");
				System.out.println();
				break;
			case 3:
				changePrice(s);			// ��ǰ ���� ���� ��� ȣ��
				break;
			case 4: machineStart(s);			// �ʱ� ���ø޴��� ����
				break;
			default :	
			}
		} while (true);
	}
	
	void changePrice (Product[] s) {			// ��ǰ ���� ���� ���
		showMenuSelection(s);
		System.out.println("������ ������ ��ǰ�� ��ȣ�� �Է��ϼ��� : ");
		int userinput = (Integer.parseInt(scan.nextLine())-1);
		System.out.println("������ ������ ��ǰ�� ������ �Է��ϼ��� : ");
		s[userinput].setProductPrice(Integer.parseInt(scan.nextLine()));
	}

	void showMenuSelection(Product[] s) {			// ���Ǳ� ��ǰ ���� ��ȸ ���
		System.out.printf ("1. �� [%d ��]      2. ź��� [%d ��]     3. ������ [%d ��]     4. �������ֽ� [%d ��]  5. ĵĿ�� [%d ��]    6.�߰� �ݾ� �Ա�           0. �ݾ� ��ȯ\n",s[0].productStockCount,s[1].productStockCount,s[2].productStockCount,s[3].productStockCount,s[4].productStockCount);
		System.out.printf("   %4d��                     %4d��                        %4d��                        %4d��                        %4d��\n", s[0].productPrice, s[1].productPrice, s[2].productPrice, s[3].productPrice, s[4].productPrice);
		for (int i=0; i<5; i++) {
			if (s[i].productStockCount <=0) {
		  System.out.print("   [ǰ��]          ");
			} else {
		  System.out.print("   [��� ����]       ");
			}
		} 
		System.out.println();
	}
	
	int customerDisplay (Product[] s) {			// ����� ����ȭ�� ���� - ����ó��
		showMenuSelection(s);
		System.out.println();
		System.out.println("�ֹ��� ��ǰ�� ��ȣ�� �Է��ϼ���");
			
		int userinput = 0;
		do {
			try {
				userinput = Integer.parseInt(scan.nextLine());
				if (userinput == 98909  || userinput >= 0 && userinput <=6) {			// 98909 : ������ ��� ������ ���� �Է°�
					break;		
				} else {
					throw new Exception("���� ���� �߻�");
				}
			} catch (Exception e) {
				System.out.println("�޴� ���� ����");
				System.out.println("�޴� 0~6������ ����");
			}
		} while (true);		
		
		return userinput;	
	}

	void customerSelect (Product[] s) {			// ����� ����ȭ�� ����
		showMenuSelection(s);
		pay.insertMoneyMethod();
		do {
			System.out.println("���� ���� �ݾ��� "+pay.insertMoney +"�� �Դϴ�.");
			int sel = customerDisplay(s);
			switch (sel) {
			case 0: 			// ���� �ݾ� ������ ��ȯ
				System.out.println("< �ܾ� "+ pay.insertMoney +"���� ��ȯ�մϴ�. ������ּż� �����մϴ�! >");
				int unit = 10000;
				int num;
				int sw = 0;
				do {
					num = pay.insertMoney / unit;
					System.out.printf("%6d �� : %4d�� ��ȯ\n", unit, num );
					pay.insertMoney -= (unit * num);
					if(sw == 0) {
						sw = 1;
						unit /= 2;
					}else {
						unit /= 5;
						sw = 0;
					}
				}while((pay.insertMoney%100==0) ? unit>=100 : unit>=0);		// 100�� ���� ���� ���ο� ���� ������ ���
				 
				pay.insertMoney = 0;

				System.out.println();
				System.out.println();
				showMenuSelection(s);
				pay.insertMoneyMethod();
				break;
			case 1:
				System.out.println("< " + s[0].toString()+"�� �����߽��ϴ�.  ������ " + s[0].productPrice +"�� �Դϴ� >");
				pay.payMoney(s[0]);
				break;
			case 2:
				System.out.println("< " + s[1].toString()+"�� �����߽��ϴ�. ������ " + s[1].productPrice +"�� �Դϴ� >");
				pay.payMoney(s[1]);
				break;
			case 3:
				System.out.println("< " + s[2].toString()+"�� �����߽��ϴ�. ������ " + s[2].productPrice +"�� �Դϴ� >");
				pay.payMoney(s[2]);
				break;
			case 4:
				System.out.println("< " + s[3].toString()+"�� �����߽��ϴ�. ������ " + s[3].productPrice +"�� �Դϴ� >");
				pay.payMoney(s[3]);
				break;
			case 5:
				System.out.println("< " + s[3].toString()+"�� �����߽��ϴ�. ������ " + s[4].productPrice +"�� �Դϴ� >");
				pay.payMoney(s[4]);
				break;
			case 6:
				pay.insertExtraMoneyMethod();			// �߰� �Ա� ��� ȣ��
				break;
			case 98909:			// ������ ����ȭ�� ȣ��
				machineStart(s);
			}
			
		} while (true); 
	}
	
	public static void main(String[] args) {
		
		VendingMachineFinal vm = new VendingMachineFinal();			// ���Ǳ� �ʱ�ȭ
		Product[] stock = { new Water(), new Cabo(), new Sujeong(), new Orange(), new CanCoffee() };			// ��ü�� �ּҰ� �Ҵ�
		
		vm.machineStart(stock);
	}
}