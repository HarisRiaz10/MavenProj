package maven_ManagementSys;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Accounts {
	protected double balance;
	protected String date,Name,phone,address;
	protected int accNo;
	
	Accounts(){
		balance=0.0;
		Date obj1=new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/mm/yyyy");
		date=sdf.format(obj1);
		Name="";
		phone="";
		address="";
		accNo=0;
	}
	
	public void inititalize(String nam,String dat,String ph,String addr,int accN,double bal) {
		Name=nam;
		date=dat;
		phone=ph;
		address=addr;
		balance=bal;
		accNo=accN;
	}
	public double getBalance() {
		return balance;
	}
	public boolean makeDeposit(double dep) {
		if(dep>0) {
		balance=balance+dep;
		return true;
		}
		else 
			return false;
	}
	public boolean makeWithdrawal(double amt) {
		if(amt<balance&&amt>0) {
		balance=balance-amt;
		return true;
		}
		else 
			return false;
	}
	void printstatement(double amount)
	{
		System.out.print("The name is: ");
		System.out.println(Name);
		System.out.print("The address is: ");
		System.out.println(address);
		System.out.print("The phone number is: ");
		System.out.println(phone);	
		System.out.print("The account number is: ");
		System.out.println(accNo);
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date1 = new Date();  
	    System.out.print("The Transaction date and time is: ");
	    System.out.println(formatter.format(date1));
		System.out.print("The transaction amount is: ");
		System.out.println(amount);
		System.out.println("The balance remaining is: " + balance);
	}
	public int getAccNo(){
		return accNo;
	}
	void DisplayInfo() {
		System.out.print("The name of account holder is : "+Name);
		System.out.print("The address of account holder is : "+address);
		System.out.print("The phone no of account holder is : "+phone);
		System.out.print("The date of account creation is : "+date);
		System.out.print("The Account number is : "+accNo);
		System.out.print("The balance in account is : "+balance);
	}
}
