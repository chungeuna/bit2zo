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
		
		System.out.println("�����Ͻ� ����" + s.getItemName()+ "����������.");
		System.out.println("�ܵ��� :" + change+ "�� �Դϴ�.");
	}
	
	
	
	
	public void stockInfo(Stock s) {
		s.getItemName();
		s.getItemPrice();
		
	}
	
	public void changePrice(Stock s, int price) {
		s.setItemPrice(price);
	}
	
	
	
	public void totalSale() {
		System.out.println("������� �� �Ǹűݾ��� :" + totalSales);
		
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
		System.out.printf("%s �� ����Ȳ :", s.getItemName());
		System.out.println(Arrays.toString(s.storage));
	}
	
	void showStorageOf(Stock[] str) {
		for(Stock s : str) {
			System.out.printf("%s �� ����Ȳ :", s.getItemName());
			System.out.println(Arrays.toString(s.storage));
		}
	}
	
	void showPrice(Stock[] str) {
		for(Stock s : str) {
			System.out.printf("%s ���� :", s.getItemName());
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
