package kr.or.bit;

import java.util.ArrayList;

public class Bank{
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private int totalAccount;
	
	
	void addAccount(String accountNo, String name) { //계좌를 생성한다 
		accounts.add(new Account(accountNo,name));		
	}
	ArrayList<Account> getAccount(String accountNo) {
		int index2 = 0;//계좌번호로 계좌를 찾는다 
		ArrayList<Account> acc = new ArrayList<Account>();
		
		for(int i=0; i<accounts.size(); i++) {
			if(accounts.get(i).getAccountNo().equals(accountNo)) {
				//System.out.println(getAccounts());
				acc.add(accounts.get(i));
				System.out.println("dfjktttttt");
			}
		}
		
			
		return acc; //수정해야한다 
	}
	
	ArrayList<Account> findAccounts(String name) { //함수안에 제너릭 하나 더 만들고 그 주소값을 리턴   //소유자명으로 계좌를 찾는다 
		ArrayList<Account> list = new ArrayList<Account>(); // 일단 account[]를 넣어보았다... 
		/*for(Account account : accounts) {
			if(account.getName() == name) {
				
				
		}*/
		for(int i = 0; i < accounts.size() ; i++) {
			if(accounts.get(i).getName().equals(name)) {
				//list.add(getAccounts());
				list.add(accounts.get(i));
				list.get(i).getAccountNo();
				//list.add(i); 
			}
			return list;
		}
		return null; //수정 무엇을 리턴할까 		
	}
	Account getAccounts() { //계좌 목록을 본다 
		
			return accounts.get(0);
		
		
	}
	
	int getTotalAccount() { //총계좌수를 반환한다 
		return accounts.size();
	}
	@Override
	public String toString() {
		return "Bank [accounts=" + accounts + ", totalAccount=" + totalAccount + "]";
	}
	
	
	
	
}