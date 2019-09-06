import java.lang.reflect.Array;
import java.util.Arrays;

public class Admin {
	int change;
	static int totalSales;
	int money;
	
	void buy(Stock s, int money) {
		this.money = money;
		change = money - s.getItemPrice();
		totalSales+= s.getItemPrice();
		for(String sss : s.storage) {
			if(sss.equals(s.getItemName())) {
				sss = "E";
				
			}
		}
		
		System.out.println("선태하신 물건" + s.getItemName()+ "가져가세요.");
		System.out.println("잔돈은 :" + change+ "원 입니다.");
	}
	
	
	
	
	public void stockInfo(Stock s) {
		s.getItemName();
		s.getItemPrice();
		
	}
	
	public void changePrice(Stock s, int price) {
		s.setItemPrice(price);
	}
	
	
	
	public void totalSale() {
		System.out.println("현재까지 총 판매금액은 :" + totalSales);
		
	}
	
	void fillUp(Stock s) {

		for (int i = 0; i < 10; i++) {
			s.storage[i] = s.getItemName();

		}

	}
	
	
	
	
	void fillUp (Stock s, int num) {
		if(num <10)
		for(int i=0; i< num; i++) {
			s.storage[i] = s.getItemName();
			
		}
		
		}
	void showStorageOf(Stock s) {
		System.out.printf("%s 의 재고상황 :", s.getItemName());
		System.out.println(Arrays.toString(s.storage));
	}
	
	void showStorageOf(Stock[] str) {
		for(Stock s : str) {
			System.out.printf("%s 의 재고상황 :", s.getItemName());
			System.out.println(Arrays.toString(s.storage));
		}
	}
	
	void showPrice(Stock[] str) {
		for(Stock s : str) {
			System.out.printf("%s 가격 :", s.getItemName());
			System.out.println(s.getItemPrice());
		}
		
	}
	
	public Boolean checkStock(Stock s) {
		String[] sss = s.storage;
		int count = 0;
		for(String str : sss ) {
			if(str.equals("E")) {
				count++;
			}
		}
		if(count >= 10) {
			System.out.println("Out of Stock");
			return false;
		}
		return true;
	}

}
