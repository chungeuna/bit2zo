package kr.or.gp;
import java.util.ArrayList;
import java.util.Scanner;

class Drink {
	final int MAX_COUNT = 50;
	int count;
	int price;
	String productName;

	Drink(String name, int count, int price) {
		this.productName = name;
		this.count = count;
		this.price = price;
	}

	public boolean checkIsEmpty() {
		if (this.count == 0) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() { //override 여러번 할 필요 없이 한줄로 다 적어줌
		return this.productName + ":" + this.count;
	} 
}

class Water extends Drink {
	Water() {
		super("Water", 50, 1000);
	}
}

class Cabo extends Drink {
	Cabo() {
		super("Cabo", 50, 1500);
	}
}

class Sujeong extends Drink {
	Sujeong() {
		super("Sujeong", 50, 1000);
	}
}

class Orange extends Drink {
	Orange() {
		super("Orange", 50, 1300);
	}
}

class CanCoffee extends Drink {
	CanCoffee() {
		super("Coffee", 50, 800);
	}
}

class DrinkManager {
	Drink[] drink = { new Water(), new Cabo(), new Sujeong(), new Orange(), new CanCoffee() };

	public Drink findDrinkByType(String productName) { //??
		for (int i = 0; i < this.drink.length; i++) {
			if (this.drink[i].productName.equals(productName)) {
				return this.drink[i];
			}
		}
		return null;
	}

	public void addStock(String productName, int amount) {
		this.findDrinkByType(productName).count += amount;
	}

	public void reduceStock(String productName, int amount) {
		this.findDrinkByType(productName).count -= amount;
	}

	public ArrayList<Drink> getAvailableProducts(int money) {//
		ArrayList<Drink> availableDrinks = new ArrayList<Drink>();
		for (int i = 0; i < this.drink.length; i++) {
			if (this.drink[i].price <= money && !this.drink[i].checkIsEmpty()) {
				availableDrinks.add(this.drink[i]);
			}
		}
		return availableDrinks;
	}
}

class Bank {
	ArrayList<Integer> temporaryMoney = new ArrayList<Integer>(); // Money inserted by the user
	ArrayList<Integer> storedMoney = new ArrayList<Integer>(); // Money in the vending machine
	int balance = 0; // The amount of money spent by the user

	Bank() {
		// Add some change in storedMoney
		this.storedMoney.add(100);
		this.storedMoney.add(500);
		this.storedMoney.add(500);
		this.storedMoney.add(100);
		this.storedMoney.add(100);
		this.storedMoney.add(100);
	}

	public int getAvailableStoredFunds() {//
		int sum = 0;
		for (int i = 0; i < this.storedMoney.size(); i++) {
			sum += this.storedMoney.get(i);
		}
		return sum;
	}

	public int getAvailableTemporaryFunds() {//
		int sum = 0;
		for (int i = 0; i < this.temporaryMoney.size(); i++) {
			sum += this.temporaryMoney.get(i);
		}
		return sum;
	}

	public int getAvailableUserFunds() { // The amount of money the user has
		return this.getAvailableTemporaryFunds() - this.balance;
	}

	public ArrayList<Integer> getChange() {
		int temporaryFunds = this.getAvailableTemporaryFunds();
		this.storeTemporaryMoney();
		int change = temporaryFunds - this.balance;

		System.out.println("Change is " + change);
		this.balance = 0;

		//If you want to make it return the number of bills and coins - use code below
		ArrayList<Integer> changeArray = new ArrayList<Integer>();
		return changeArray;
	}

	public void addToTemporaryMoney(int money) {
		this.temporaryMoney.add(money);
	}

	public void storeTemporaryMoney() {
		for (int i = 0; i < this.temporaryMoney.size(); i++) {
			this.storedMoney.add(this.temporaryMoney.get(i));
		}
		this.temporaryMoney = new ArrayList<Integer>();
	}
}

public class VendingMachine {
	DrinkManager dm = new DrinkManager();
	Bank bank = new Bank();
	Scanner scan = new Scanner(System.in);

	int state = 0;

	VendingMachine() {
		boolean shouldExit = false;
		while (true) {
			System.out.println("1. User options, 2. Manager options, 3. Exit");
			int userInput = Integer.parseInt(this.scan.nextLine());
			switch (userInput) {
			case 1:
				this.displayUser();
				break;
			case 2:
				this.displayManager();
				break;
			case 3:
				System.out.println("Good bye");
				shouldExit = true;
				break;
			default:
				System.out.println("Invalid option");
			}
			if (shouldExit) {
				break;
			}
		}
	}

	private void displayManager() {
		System.out.println("Hello manager");
		System.out.println("1. Restock, 2. Get total funds, 3. Exit");
		int userInput = Integer.parseInt(this.scan.nextLine());
		switch (userInput) {
		case 1:
			this.displayRestock();
			break;
		case 2:
			System.out.println("Total funds = " + this.bank.getAvailableStoredFunds());
			break;
		case 3:
			System.out.println("Good bye");
			break;
		default:
			System.out.println("Invalid option");
		}
	}

	private void displayRestock() {
		System.out.println("Add stock to (type name): ");
		for (int i = 0; i < this.dm.drink.length; i++) {
			System.out.println("\t " + this.dm.drink[i]);
		}
		String userInput = this.scan.nextLine();
		if (this.dm.findDrinkByType(userInput) == null) {
			System.out.println("Invalid product name");
		} else {
			this.dm.addStock(userInput, 1);
			System.out.println("Current stock: " + this.dm.findDrinkByType(userInput));
		}
	}

	private void displayUser() {
		boolean shouldExit = false;
		while (true) {
			int userFunds = this.bank.getAvailableUserFunds();
			System.out.println("Available money " + userFunds + " won");
			this.displayAvailableStock();
			System.out.println("1. Insert money, 2. Select drink, 3. Exit");
			int userInput = Integer.parseInt(this.scan.nextLine());
			switch (userInput) {
			case 1:
				this.insertMoney();
				break;
			case 2:
				this.selectAvailableDrink();
				break;
			case 3:
				this.exitUser();
				shouldExit = true;
				break;
			default:
				System.out.println("Invalid option");
			}
			if (shouldExit) {
				break;
			}
		}
	}

	private void displayAvailableStock() {
		int temporaryFunds = this.bank.getAvailableUserFunds();
		ArrayList<Drink> availableProducts = this.dm.getAvailableProducts(temporaryFunds);
		if (availableProducts.size() == 0) {
			System.out.println("Available products: None");
		} else {
			System.out.println("Available products: ");
			for (int i = 0; i < availableProducts.size(); i++) {
				System.out.println("\t " + availableProducts.get(i));
			}
		}
	}

	private void insertMoney() {
		System.out.println("Insert 1000, 500, 100");
		int userInput = Integer.parseInt(this.scan.nextLine());
		if (userInput == 1000 || userInput == 500 || userInput == 100) {
			this.bank.addToTemporaryMoney(userInput);
		} else {
			System.out.println("Invalid option");
		}
	}

	private void selectAvailableDrink() {
		String userInput = this.scan.nextLine();
		Drink targetDrink = this.dm.findDrinkByType(userInput);
		if (targetDrink == null) {
			System.out.println("Invalid product name");
		} else {
			if (targetDrink.price > this.bank.getAvailableUserFunds()) {
				System.out.println("Insufficient funds");
			} else {
				this.dm.reduceStock(userInput, 1);
				this.bank.balance += targetDrink.price;
			}
		}
	}

	private void exitUser() {
		this.bank.getChange();
	}

	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
	}
}