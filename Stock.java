

public  class Stock {
	
	
	private int itemPrice;
	private String itemName;
	String[] storage;
	
	Stock(int itemprice, String itemname) {
		this.itemPrice =itemprice;
		this.itemName = itemname;
		this.storage = new String[10];
		for(int i=0; i< storage.length; i++) {
			storage[i] = "E";
		}
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	


}

class Water extends Stock {
	
	Water() {
		super(1000, "좋은물");
		
	}
	
	

	



	

	@Override
	public String toString() {
		return "Water";
	}
	
	
}
class Cabo extends Stock{
	Cabo() {
		super(1500,"좋은탄산수");		
	}
	@Override
	public String toString() {
		return "Cabo";
	}
}
class Juice extends Stock {
	Juice() {
		super(1300,"좋은주스");
		
	}

	@Override
	public String toString() {
		return "Juice";
	}
}
class Sikhae extends Stock {
	Sikhae() {
		super(800,"좋은식혜");		
	}
	@Override
	public String toString() {
		return "Sikhae";
	}
}
class Sujerng extends Stock  {
	Sujerng() {
		super(1000,"수정");		
	}
	@Override
	public String toString() {
		return "Sujerng";
	}
}
	
	
	


