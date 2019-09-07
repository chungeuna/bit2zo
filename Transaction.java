import java.util.Calendar;

public class Transaction {
	
	private String transactionDate;
	private String transactionTime;
	private String kind;
	private long amount;
	private long balance;
	
	
	
	
	
	public Transaction(String kind) {
		Calendar cal = Calendar.getInstance();
		Date dat = new Date();
		this.transactionDate = dat.DateString(cal);
		this.transactionTime = dat.TimeString(cal);
		this.kind = kind;
		
	}
	
	
	
	public String getTransactionDate() {
		return transactionDate;
	}
	
	public String getTransactionTime() {
		return transactionTime;
	}
	
	
	public String getKind() {
		return kind;
	}
	
	public long getAmount() {
		return amount;
	}
	
	public long getBalance() {
		return balance;
	}



	public void setAmount(long amount) {
		this.amount = amount;
	}



	public void setBalance(long balance) {
		this.balance = balance;
	}



	@Override
	public String toString() {
		return "Transaction [transactionDate=" + transactionDate + ", transactionTime=" + transactionTime + ", kind="
				+ kind + ", amount=" + amount + ", balance=" + balance + "]";
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
