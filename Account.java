/*
계좌는 소유자명, 계좌번호, 잔고로 구성된다.
계좌는 입금,출금 기능과 잔고확인 기능이 있다.
계좌에서 잔액의 변화가 있을 때마다 입출금 명세에 기록된다.
 */
import java.util.ArrayList;
import java.util.Calendar;

public class Account {
	private ArrayList<Transaction> transaction; 
	private String accountNo;
	private String name;
	private long balance;
	private int index;

	Account() {
		transaction = new ArrayList<Transaction>();
		int index = 0;	
	}

	Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;	
	}
	
	public String getAccountNo() {
		return accountNo;
	}

	public String getName() {
		return name;
	}

	public void deposit(long amount) {			// 1
		Calendar cal = Calendar.getInstance();
		Date dat = new Date();
		transaction.add(new Transaction());
		transaction.get(index).setAmount(amount);
		balance += amount;
		transaction.get(index).setBalance(balance);
		transaction.get(index).setTransactionDate(dat.DateString(cal));
		transaction.get(index).setTransactionTime(dat.TimeString(cal));	
		index++;
	}
	
	public void withdraw(long amount) {			// 2
		Calendar cal = Calendar.getInstance();
		Date dat = new Date();
		transaction.add(new Transaction());
		transaction.get(index).setAmount(amount);
		balance -= amount;
		transaction.get(index).setBalance(balance);
		transaction.get(index).setTransactionDate(dat.DateString(cal));
		transaction.get(index).setTransactionTime(dat.TimeString(cal));
		index++;
	}
	
	public long getBalance() {			// 3
		return balance;
	}
	
	public ArrayList getTransactions() {		//4
		ArrayList example = new ArrayList();
		for(Transaction tr : transaction) {
			example.add(tr.getTransactionDate());
			example.add(tr.getTransactionTime());
			example.add(tr.getAmount());
			example.add(tr.getBalance());
		}
		return example;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + ", transaction="
				+ transaction+"]\n";	
	}
}

class Date {
	public static String DateString(Calendar date) {
		return date.get(Calendar.YEAR) + "년"
				+ (date.get(Calendar.MONTH)+1) + "월"
				+ date.get(Calendar.DATE) + "일";	
	}
	
	public static String DateString(Calendar date, String opr) {
		return date.get(Calendar.YEAR) + opr
				+ (date.get(Calendar.MONTH)+1) + opr
				+date.get(Calendar.DATE);
	}
	
	public static String monthFormat_DateString(Calendar date) {
		return null;
	}
	
	public static String TimeString(Calendar time) {
		return time.get(Calendar.HOUR) + ":"
				+ time.get(Calendar.MINUTE) + ":"
				+time.get(Calendar.SECOND);
	}
}

