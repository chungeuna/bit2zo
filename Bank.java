package kr.or.bit;

import java.util.ArrayList;

public class Bank{
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private int totalAccount;
	
	
	void addAccount(String accountNo, String name) { //���¸� �����Ѵ� 
		accounts.add(new Account(accountNo,name));	
		totalAccount++;
	}
	
	void myprint() {
		System.out.println(accounts.toString());
	}
	
	
	Account getAccount(String accountNo) {
		int index2 = 0;//���¹�ȣ�� ���¸� ã�´� 
		//ArrayList<Account> acc = new ArrayList<Account>();
		
		for(int i=0; i<accounts.size(); i++) {
			if(accounts.get(i).getAccountNo().equals(accountNo)) {
				//System.out.println(getAccounts());
				//acc.add(accounts.get(i));
				index2 = i;
			
				
				
			} 
				
		}
		
			
		return accounts.get(index2); //�����ؾ��Ѵ� 
	}
	
	ArrayList<Account> findAccounts(String name) { //�Լ��ȿ� ���ʸ� �ϳ� �� ����� �� �ּҰ��� ����   //�����ڸ����� ���¸� ã�´� 
		ArrayList<Account> list = new ArrayList<Account>(); // �ϴ� account[]�� �־�Ҵ�... 
		/*for(Account account : accounts) {
			if(account.getName() == name) {
				
				
		}*/
		for(int i = 0; i < accounts.size() ; i++) {
			if(accounts.get(i).getName().equals(name)) {
				//list.add(getAccounts());
				list.add(accounts.get(i));
				//list.get(i).getAccountNo();
				//list.add(i); 
			}
			
		}
		return list; //���� ������ �����ұ� 		
	}
	ArrayList <Account> getAccounts() { //���� ����� ���� 
		
			return accounts;
		
		
	}
	
	int getTotalAccount() { //�Ѱ��¼��� ��ȯ�Ѵ� 
		return totalAccount;
	}
	@Override
	public String toString() {
		return "Bank [accounts=" + accounts + ", totalAccount=" + totalAccount + "]";
	}
	
	
	void print(Account acct) {
		acct.toString();
	}
	
}