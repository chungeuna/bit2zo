package kr.or.bit;

import java.util.Arrays;

public class Mymain {

	public static void main(String[] args) {
		
		Account accttt = new Account();
		Bank bank = new Bank();
		bank.addAccount("101", "ȫ�浿");
		
		bank.myprint();
		
		//bank.getAccount("123");
		System.out.println(bank.getAccount("123"));
		
		bank.addAccount("102", "ȫȫȫ");
		bank.addAccount("103", "kim");
		
		
		for(Account accccc : bank.getAccounts()) {
			
		}
		System.out.println(bank.findAccounts("kim").get(0));
		
		
		
		
		//System.out.println(bank.getAccount("123"));
		//bank.print(bank.getAccount("123"));
		
		//System.out.println(bank.getAccount("123"));

		
		
		
		
	}

}
