import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> accounts; 
	private int totalAccount;
	
	
	
	
	
	public Bank() {
		
		this.accounts = new ArrayList<Account>();
	}


	void addAccount(String accountNo, String name) { //계좌를 생성한다 		// 1
		/*for (Account macc : accounts) {
			if(macc.getName().equals("accountNo")) {
				System.out.println("Identical Acc exist, Try Again");
				return;
			}else {
				accounts.add(new Account(accountNo,name));
			}
		} */
		
		
		accounts.add(new Account(accountNo,name));
			
		totalAccount++;
	}

	
	Account getAccount(String accountNo) {		// 2
		int index2 = 0;//계좌번호로 계좌를 찾는다 
		//ArrayList<Account> acc = new ArrayList<Account>();
		
		for(int i=0; i<accounts.size(); i++) {
			if(accounts.get(i).getAccountNo().equals(accountNo)) {
				index2 = i;		
			} 
		}	
		return accounts.get(index2); //수정해야한다 
	}
	
	ArrayList<Account> findAccounts(String name) { //함수안에 제너릭 하나 더 만들고 그 주소값을 리턴   //소유자명으로 계좌를 찾는다 		// 3
		ArrayList<Account> list = new ArrayList<Account>(); 

		for(Account myAcc : accounts) {
			if(myAcc.getName().equals(name)) {			
				list.add(myAcc);			
			}		
		}
		return list; //수정 무엇을 리턴할까 		
	}
	
	ArrayList <Account> getAccounts() { //계좌 목록을 본다 			// 4
			return accounts;	
	}
	
	int getTotalAccount() { //총계좌수를 반환한다 		//5
		return totalAccount;
	}
	
	@Override
	public String toString() {
		return "Bank [accounts=" + accounts + ", totalAccount=" + totalAccount + "]";
	}
	
	/*
	public void print(Account acct) {
		acct.toString();
	}
	/*
	void myprint() {
		System.out.println(accounts.toString());
	}

	
	*/
	public void printAccList (ArrayList <Account> alist) {
		for(Account myAcc : alist) {
			System.out.println(myAcc);
		}
	}
	public void printTranList (ArrayList <Transaction> alist) {
		for(Transaction myAcc : alist) {
			System.out.println(myAcc);
		}
	}

}
