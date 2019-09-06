import java.util.ArrayList;
class Account {
	public Account(String accountNo, String name) {
	}
	private String accountNo;
	private String name;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
public class Bank {
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private int totalAccount;
	
	
	void addAccount(String accountNo, String name) {
		accounts.add(new Account(accountNo,name));		
	}
	Account getAccount(String accountNo) {
		for(Account account : accounts) {
			if(account.getAccountNo() == accountNo) {
				System.out.println(getAccounts());
			}
		}
		return null; //수정해야한다 
	}
	Account[] findAccounts(String name) { //함수안에 제너릭 하나 더 만들고 그 주소값을 리턴 
		ArrayList<Account[]> list = new ArrayList<Account[]>(); // 일단 account[]를 넣어보았다... 
;		for(Account account : accounts) {
			if(account.getName() == name) {
				list.add(account.getAccountNo());
			}	
		}
		return ; //수정 무엇을 리턴할까 		
	}
	Account[] getAccounts() {
		for(Account account : accounts) {
			System.out.println(account);
		}
	}
	int getTotalAccount() {
		
	}
	
}
