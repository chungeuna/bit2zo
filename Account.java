/*
계좌는 소유자명, 계좌번호, 잔고로 구성된다.
계좌는 입금,출금 기능과 잔고확인 기능이 있다.
계좌에서 잔액의 변화가 있을 때마다 입출금 명세에 기록된다.
 */
import java.util.ArrayList;
import java.util.Calendar;


public class Account {
	private ArrayList<Transaction> tranList; 
	private String accountNo;
	private String name;
	private long balance;
	private int index;

	

	Account(String accountNo, String name) {
		
		this.accountNo = accountNo;
		this.name = name;	
		tranList = new ArrayList<Transaction>();
		int index = 0;	
	}
	
	public String getAccountNo() {
		return accountNo;
	}

	public String getName() {
		return name;
	}

	public void deposit(long amount) {			// 1
		
		
		tranList.add(new Transaction("Deposit"));
		tranList.get(index).setAmount(amount);
		balance += amount;
		tranList.get(index).setBalance(balance);
			
		index++;
	}
	
	public void withdraw(long amount) {	
		if (this.balance < amount) {
			System.out.println("잔액부족");// 2
		}else {
			tranList.add(new Transaction("Withdraw"));
			tranList.get(index).setAmount(amount);
			balance -= amount;
			tranList.get(index).setBalance(balance);
		}
		
		
		
		index++;
	}
	
	public long getBalance() {			// 3
		return this.balance;
	}
	
	public ArrayList<Transaction> getTransactions() {
		return tranList;
		//4
		/*ArrayList example = new ArrayList();
		for(Transaction tr : tranList) {
			example.add(tr.getTransactionDate());
			example.add(tr.getTransactionTime());
			example.add(tr.getAmount());
			example.add(tr.getBalance());
		} */
		
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + "]\n";	
	}
}


