
import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

public class Mymain {

	public static void main(String[] args) {
		
		Account accttt = new Account();
		Bank bank = new Bank();
		bank.addAccount("101", "���Ϲ�");
		
		// bank.myprint();
		
		System.out.println(bank.getAccount("123"));
		
		bank.addAccount("102", "���̹�");
		bank.addAccount("103", "����");
		bank.addAccount("104", "����");
		bank.addAccount("105", "����");
		bank.addAccount("106", "����");
		bank.addAccount("107", "����");
		bank.addAccount("108", "���̹�");
		bank.addAccount("109", "���̹�");
		bank.addAccount("110", "���̹�");
		
		
		
		System.out.println("getAccount : \n" + bank.getAccount("102"));
		
		System.out.println("findAccount : \n" +bank.findAccounts("���̹�"));
		
		System.out.println("getAccounts : \n" + bank.getAccounts());
		
		System.out.println("totalAccount count : \n" + bank.getTotalAccount());
		
		
		System.out.println();
		
		//System.out.println(bank.getAccount("123"));
		//bank.print(bank.getAccount("123"));
		
		//System.out.println(bank.getAccount("123"));	
	}

}