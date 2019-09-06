
import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

public class Mymain {

	public static void main(String[] args) {
		
		Account accttt = new Account();
		Bank bank = new Bank();
		bank.addAccount("101", "±èÀÏ¹ø");
		
		// bank.myprint();
		
		System.out.println(bank.getAccount("123"));
		
		bank.addAccount("102", "±èÀÌ¹ø");
		bank.addAccount("103", "±è»ï¹ø");
		bank.addAccount("104", "±è»ï¹ø");
		bank.addAccount("105", "±è»ï¹ø");
		bank.addAccount("106", "±è»ï¹ø");
		bank.addAccount("107", "±è»ï¹ø");
		bank.addAccount("108", "±èÀÌ¹ø");
		bank.addAccount("109", "±èÀÌ¹ø");
		bank.addAccount("110", "±èÀÌ¹ø");
		
		
		
		System.out.println("getAccount : \n" + bank.getAccount("102"));
		
		System.out.println("findAccount : \n" +bank.findAccounts("±èÀÌ¹ø"));
		
		System.out.println("getAccounts : \n" + bank.getAccounts());
		
		System.out.println("totalAccount count : \n" + bank.getTotalAccount());
		
		
		System.out.println();
		
		//System.out.println(bank.getAccount("123"));
		//bank.print(bank.getAccount("123"));
		
		//System.out.println(bank.getAccount("123"));	
	}

}