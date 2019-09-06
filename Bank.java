import java.util.ArrayList;

public class Bank{
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private int totalAccount;
	
	void addAccount(String accountNo, String name) { //���¸� �����Ѵ� 		// 1
		accounts.add(new Account(accountNo,name));	
		totalAccount++;
	}

	
	Account getAccount(String accountNo) {		// 2
		int index2 = 0;//���¹�ȣ�� ���¸� ã�´� 
		//ArrayList<Account> acc = new ArrayList<Account>();
		
		for(int i=0; i<accounts.size(); i++) {
			if(accounts.get(i).getAccountNo().equals(accountNo)) {
				index2 = i;		
			} 
		}	
		return accounts.get(index2); //�����ؾ��Ѵ� 
	}
	
	ArrayList<Account> findAccounts(String name) { //�Լ��ȿ� ���ʸ� �ϳ� �� ����� �� �ּҰ��� ����   //�����ڸ����� ���¸� ã�´� 		// 3
		ArrayList<Account> list = new ArrayList<Account>(); 

		for(int i = 0; i < accounts.size() ; i++) {
			if(accounts.get(i).getName().equals(name)) {			
				list.add(accounts.get(i));			
			}		
		}
		return list; //���� ������ �����ұ� 		
	}
	
	ArrayList <Account> getAccounts() { //���� ����� ���� 			// 4
			return accounts;	
	}
	
	int getTotalAccount() { //�Ѱ��¼��� ��ȯ�Ѵ� 		//5
		return totalAccount;
	}
	
	@Override
	public String toString() {
		return "Bank [accounts=" + accounts + ", totalAccount=" + totalAccount + "]";
	}
	
	/*
	void print(Account acct) {
		acct.toString();
	}
	
	void myprint() {
		System.out.println(accounts.toString());
	}
	*/
	
}