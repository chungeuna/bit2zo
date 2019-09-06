import java.util.Scanner;
/*
c
			count++;
		}
	}
	if (count <5) {
		System.out.println("채워주세요");
	}
} 

	Stock (int price, String name) {
		initStock(numOfStock);
		this.price = price;
		this.name = name;
	}
	
	void initStock (String[] sarray) {
		sarray = new String[50];
		for(String s : sarray) {
			s="E";
		}
	}
	
	void inputStock (int num) {
		for(int i =0; i< numOfStock.length; i++) {
			if(numOfStock[i] == "E") {
				for(int j=0; j<num; j++)
				numOfStock[j] = name;
			}
		}
	}
	
	void show () {
		System.out.println("가격은 " + price + "입니다.");
	}
	
	
}



class SalesMethod {
	
	void menu () {
		System.out.println("2조 자판기");
		System.out.println("머 마실래??");
		System.out.println("1.물  2.탄산수  3.주스  4.식혜  5. 수정과 ");
		Scanner scan = new Scanner(System.in);
		
		int sel = Integer.parseInt(scan.nextLine());
		Show show = new Show();
		
		switch (sel) {
		case 1 : 
			show.show(new Water());
			break;
		case 2 :
			show.show(new Cabo());
			break;
			
		case 3 :
			show.show(new Juice());
			break;
			
		case 4 :
			show.show(new Sikhae());
			break;
			
		case 5 :
			show.show(new Sujerng());
			break;
			
			
		}
	}
}


class Admin {
	
	void menuAdmin (int num) {
		if(num == 1) {
			System.out.println("관리자 모드 입니다.");
		}else {
			System.out.println("판매 모드 입니다.");
			SalesMethod m2 = new SalesMethod();
			m2.menu();
		}
	}
	
}


*/







class Vending {
	
	void menuForM(int n) {
		Scanner scan3 = new Scanner(System.in);
		
		switch(n) {
		case 1:
			System.out.println("1.물  2.탄산수  3.주스  4.식혜  5.수정과");
			int numb = Integer.parseInt(scan3.nextLine());
			if(numb ==1) {
				
			}
			
		case 2:
		case 3:
		}
		
	}
	
	
	
	
	
	
	
	
}

public class Machine {

	public static void main(String[] args) {
		Admin admin = new Admin();
		Water w = new Water();
		Cabo c = new Cabo();
		Juice j = new Juice();
		Sikhae s = new Sikhae();
		Sujerng su = new Sujerng();
		Stock[] stock = {w,c,j,s,su};
		
		Boolean mode =false;
		do {
		System.out.println("2조 자판기 관리 메뉴");
		System.out.println("1.관리자 모드   2. 판매모드");
				
		Scanner scan = new Scanner(System.in);
		int sel = Integer.parseInt(scan.nextLine());
		
		
		switch(sel) {
		case 1 :
			System.out.println("1.상품별 제고 확인  2.상품 가격 조정  3.총 판매금액 확인");
			int sel2 = Integer.parseInt(scan.nextLine());
			if(sel2 == 1) {
				admin.showStorageOf(stock);
				System.out.println("상품을 모두 가득 채울까요?(Y/N)");
				String str11 = scan.nextLine();
				if(str11.equals("Y")) {
					for(Stock s1234 : stock) {
						admin.fillUp(s1234);
					}
					admin.showStorageOf(stock);
					System.out.println("Process completed~~!!");
				}else {
					System.out.println("Please select an item to fill");
					System.out.printf("0.%s 1.%s 2.%s 3.%s 4.%s", w,c,j,s,su);
					int sel1010 = Integer.parseInt(scan.nextLine());
					admin.showStorageOf(stock[sel1010]);
					System.out.println("Please enter the amount to fill :(0~10)");
					int sel1111 = Integer.parseInt(scan.nextLine());
					admin.fillUp(stock[sel1010], sel1111);
					admin.showStorageOf(stock[sel1010]);
				}
					
				
				
			}else if(sel2 ==2) {
				admin.showPrice(stock);
				System.out.println("Please select an item to change the price");
				System.out.printf("0.%s 1.%s 2.%s 3.%s 4.%s", w,c,j,s,su);
				int selItem = Integer.parseInt(scan.nextLine());
				System.out.printf("Change the price of %s to", stock[selItem]);
				int changePrice = Integer.parseInt(scan.nextLine());
				stock[selItem].setItemPrice(changePrice);
				admin.showPrice(stock);
				
			}else {
				admin.totalSale();
			}
				
				
				
				
				
				
				
				
			
			break;
		case 2 :
			admin.showPrice(stock);
			System.out.println("Please select an item to buy");
			
			System.out.printf("0.%s 1.%s 2.%s 3.%s 4.%s", w,c,j,s,su);
			int selItemby = Integer.parseInt(scan.nextLine());
			if(!admin.checkStock(stock[selItemby])) {
				continue;
			}
			System.out.println("Please Insert Money");
			int inputMoney = Integer.parseInt(scan.nextLine());
			
			
			
			admin.buy(stock[selItemby], inputMoney);
			
			
			break;
			
			default :
				
				mode = true;
		}
		
		
		
		}while(!mode);

	}
}
