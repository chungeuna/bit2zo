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
public class Bank{
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private int totalAccount;
	
	
	void addAccount(String accountNo, String name) { //���¸� �����Ѵ� 
		accounts.add(new Account(accountNo,name));		
	}
	Account getAccount(String accountNo) { //���¹�ȣ�� ���¸� ã�´� 
		for(Account account : accounts) {
			if(account.getAccountNo() == accountNo) {
				System.out.println(getAccounts());
			}
		}
		return null; //�����ؾ��Ѵ� 
	}
	Account[] findAccounts(String name) { //�Լ��ȿ� ���ʸ� �ϳ� �� ����� �� �ּҰ��� ����   //�����ڸ����� ���¸� ã�´� 
		ArrayList<Account> list = new ArrayList<Account>(); // �ϴ� account[]�� �־�Ҵ�... 
;		/*for(Account account : accounts) {
			if(account.getName() == name) {
				
				
		}*/
		for(int i = 0; i < accounts.size() ; i++) {
			if(accounts.get(i).getName() == name) {
				//list.add(getAccounts());
				list.add(accounts.get(i));
				list.get(i).getAccountNo();
				//list.add(i); 
				return null;
			}
		}
		return ; //���� ������ �����ұ� 		
	}
	Account[] getAccounts() { //���� ����� ���� 
		for(Account account : accounts) {
			System.out.println(account);
		}
		return null;
	}
	int getTotalAccount() { //�Ѱ��¼��� ��ȯ�Ѵ� 
		return accounts.size();
	}
	
}
