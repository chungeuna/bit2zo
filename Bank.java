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
		return null; //�����ؾ��Ѵ� 
	}
	Account[] findAccounts(String name) { //�Լ��ȿ� ���ʸ� �ϳ� �� ����� �� �ּҰ��� ���� 
		ArrayList<Account[]> list = new ArrayList<Account[]>(); // �ϴ� account[]�� �־�Ҵ�... 
;		for(Account account : accounts) {
			if(account.getName() == name) {
				list.add(account.getAccountNo());
			}	
		}
		return ; //���� ������ �����ұ� 		
	}
	Account[] getAccounts() {
		for(Account account : accounts) {
			System.out.println(account);
		}
	}
	int getTotalAccount() {
		
	}
	
}
