interface IinputMoney{
	void inputMoney();
}
interface IbuyInMachine{
	void buyInMachine();
}
interface IstockInfo{
	void stockInfo();
} 



interface Itotalsale{
	void totalSale();
}

interface Ibuy{
	void buy();
}

interface IstockPlus{
	void stockPlus();
}
interface IstockMinus{
	void stockMinus();
}
interface IoutOfStock{
	void outOfStock();
}

class IMachine{
	int saleAmount;
	
	
}
class Buyer implements Ibuy{
	int money;
	boolean howtopay;
	@Override
	public void buy() {
		// TODO Auto-generated method stub
		
	}
	
}
class Admin {
	public void stockInfo() {
		
	}
	public void totalSale() {
		
	}
}
class Stock { 
	int inStock;
	String[] numOfStock;
	int price;
	String name;
	
/*abstract*/void stockMinus() {}
/*abstract*/void outOfStock() {} 
	Stock (int price) {
		this.price = price;
	}
	
	
}
class Water extends Stock {
	
	Water() {
		super(1000);
		
	}

	@Override
	public String toString() {
		return "Water";
	}
}
class Cabo extends Stock{
	Cabo() {
		super(1500);		
	}
	@Override
	public String toString() {
		return "Cabo";
	}
}
class Juice extends Stock {
	Juice() {
		super(1300);
		
	}

	@Override
	public String toString() {
		return "Juice";
	}
}
class Sikhae extends Stock {
	Sikhae() {
		super(800);		
	}
	@Override
	public String toString() {
		return "Sikhae";
	}
}
class Sujerng extends Stock  {
	Sujerng() {
		super(1000);		
	}
	@Override
	public String toString() {
		return "Sujerng";
	}
}

public class Vendingmachine {
 public static void main(String[] args) {
	 Water water =  new Water();
	 System.out.println(water.toString() + water.price);
	 Cabo cabo = new Cabo();
	 System.out.println(cabo.toString() + cabo.price);
	 Juice juice = new Juice();
	 System.out.println(juice.toString() + juice.price);
	 Sikhae sikhae = new Sikhae();
	 System.out.println(sikhae.toString() + sikhae.price);
	 Sujerng sujerng = new Sujerng();
	 System.out.println(sujerng.toString() + sujerng.price);
 }
}
