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
	
	
	void addAccount(String accountNo, String name) { //계좌를 생성한다 
		accounts.add(new Account(accountNo,name));		
	}
	Account getAccount(String accountNo) { //계좌번호로 계좌를 찾는다 
		for(Account account : accounts) {
			if(account.getAccountNo() == accountNo) {
				System.out.println(getAccounts());
			}
		}
		return null; //수정해야한다 
	}
	Account[] findAccounts(String name) { //함수안에 제너릭 하나 더 만들고 그 주소값을 리턴   //소유자명으로 계좌를 찾는다 
		ArrayList<Account> list = new ArrayList<Account>(); // 일단 account[]를 넣어보았다... 
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
		return ; //수정 무엇을 리턴할까 		
	}
	Account[] getAccounts() { //계좌 목록을 본다 
		for(Account account : accounts) {
			System.out.println(account);
		}
		return null;
	}
	int getTotalAccount() { //총계좌수를 반환한다 
		return accounts.size();
	}
	
}
