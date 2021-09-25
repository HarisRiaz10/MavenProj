package maven_ManagementSys;

public class SavingsAcc extends Accounts {
	public double calculateZakat(){
		if(balance<20000.0) {
			System.out.print("You Must have atleast an amount of  20,000 to be eligible for zakat");
			return 0;
		}
		else {
		System.out.print("the amount you have to pay for zakat is : ");
		
		return ((balance*2.5)/100);
		}

	}
	public boolean transferamount(SavingsAcc obj,double amount)
	{	
		if(amount<balance) {
		balance-=amount;
		obj.balance+=amount;
		return true;
		}
		else
			return false;
	}
	public double calculateInterest(double rate) {
		if(rate<0||rate>100) {
			return 0;
		}
		return balance+(balance*(rate/100));
	}
}
