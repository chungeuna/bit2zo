
public class Main_Bank {

	public static void main(String[] args) {
		Bank mbank = new Bank();
	
		
		mbank.addAccount("101", "Kim");
		mbank.addAccount("102", "Lee");
		mbank.addAccount("103", "Jin");
		mbank.addAccount("104", "Kim");
		mbank.addAccount("105", "Back");
		
		System.out.println(mbank.getAccount("101"));
		System.out.println(mbank.getAccount("103"));
		System.out.println(mbank.getAccount("105"));
		System.out.println("===================");
		
		mbank.printAccList(mbank.findAccounts("Kim"));
		System.out.println("===================");
		
		mbank.printAccList(mbank.getAccounts());
		System.out.println("===================");
		
		System.out.println("Total number of Acc: " + mbank.getTotalAccount());
		System.out.println("================");
		
		//고객 넘버 "101" 와서  100 입금
		mbank.getAccount("101").deposit(100);
		//같은 고개 10 출금
		mbank.getAccount("101").withdraw(10);
		//같은 고객 잔액 확인
		System.out.println(mbank.getAccount("101").getBalance());
		//그 고객 거래 내역 확인
		mbank.printTranList(mbank.getAccount("101").getTransactions());
		
		
		
		
		
		
		
		
		
		
	}

}
