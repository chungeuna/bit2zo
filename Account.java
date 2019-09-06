package kr.or.bit;

import java.util.ArrayList;
import java.util.Calendar;

/*���´� �����ڸ�, ���¹�ȣ, �ܰ�� �����ȴ�.
���´� �Ա�,��� ��ɰ� �ܰ�Ȯ�� ����� �ִ�.
���¿��� �ܾ��� ��ȭ�� ���� ������ ����� ���� ��ϵȴ�.
 * 
 */

class Date {
	
	public static String DateString(Calendar date) {
		return date.get(Calendar.YEAR) + "��"
				+ (date.get(Calendar.MONTH)+1) + "��"
				+ date.get(Calendar.DATE) + "��";	
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



public class Account {
	private String accountNo;
	private String name;
	private long balance;
	private ArrayList<Transaction> transaction; 
	int index;
	
	
	public String getAccountNo() {
		return accountNo;
	}

	public String getName() {
		return name;
	}

	Account() {
		transaction = new ArrayList<Transaction>();
		int index = 0;
		
	}
	
	public Account(String accountNo, String name) {
		
	}

	public void deposit(long amount) {
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
	
	public void withdraw(long amount) {
		
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
	
	public long getBalance() {
		return balance;
	}
	
	public ArrayList getTransactions() {
		ArrayList ttt = new ArrayList();
		for(Transaction tr : transaction) {
			
			ttt.add(tr.getTransactionDate());
			ttt.add(tr.getTransactionTime());
			 ttt.add(tr.getAmount());
				ttt.add(tr.getBalance());
			
			
			
		}
		
		return ttt;


	}

}
