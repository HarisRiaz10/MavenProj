package maven_ManagementSys;

public class CheckingAcc extends Accounts {
	public boolean makeWithdrawal(double amt) {
		if(amt<=(balance+5000)&&amt>0) {
		balance=balance-amt;
		return true;
		}
		else 
			return false;
	}
	public boolean transferamount(CheckingAcc obj,double amount)
	{	
		if(amount<balance) {
		balance-=amount;
		obj.balance+=amount;
		return true;
		}
		else
			return false;
	}
	public void amountded() {
		balance-=10;
	}
}
