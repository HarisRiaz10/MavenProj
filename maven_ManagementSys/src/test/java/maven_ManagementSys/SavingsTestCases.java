package maven_ManagementSys;

import static org.junit.Assert.*;

import org.junit.Test;

public class SavingsTestCases {

	@Test
	public void test() {//positive
		SavingsAcc obj1=new SavingsAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
	
		double available=obj1.getBalance();
		assertEquals(available,1200.0,0.0);
	}
	@Test
	public void test1() {//positive
		SavingsAcc obj1=new SavingsAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
		
		boolean state=obj1.makeDeposit(51000.0);
		assertEquals(state,true);
		
		double available=obj1.getBalance();
		assertEquals(available,52200.0,0.0);
	}
	
	@Test
	public void test2() {//negative
		SavingsAcc obj1=new SavingsAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
		
		boolean state=obj1.makeDeposit(-51000.0);
		assertEquals(state,false);
		
		double available=obj1.getBalance();
		assertEquals(available,1200.0,0.0);
	}
	@Test
	public void test3() {//positive
		SavingsAcc obj1=new SavingsAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
		
		boolean state=obj1.makeWithdrawal(1000.0);
		assertEquals(state,true);
		
		double available=obj1.getBalance();
		assertEquals(available,200.0,0.0);
	}

	@Test
	public void test4() {//negative
		SavingsAcc obj1=new SavingsAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
		
		boolean state=obj1.makeWithdrawal(10000.0);
		assertEquals(state,false);
		
		double available=obj1.getBalance();
		assertEquals(available,1200.0,0.0);
	}
	@Test
	public void test5() {//negative
		SavingsAcc obj1=new SavingsAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
		
		boolean state=obj1.makeWithdrawal(-1000.0);
		assertEquals(state,false);
		
		double available=obj1.getBalance();
		assertEquals(available,1200.0,0.0);
	}
	@Test
	//positive test case
	public void test6() { 
		SavingsAcc obj1=new SavingsAcc();
		SavingsAcc obj2=new SavingsAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
		obj2.inititalize("Shaharyar", "12/12/2018", "0312066220", "Karachi", 7137629, 50000.0);
	
		boolean status=obj2.transferamount(obj1, 25000.0);
		assertEquals(status,true);
		double bal=obj1.getBalance();
		assertEquals(bal,26200.0,0.0);
	}
	@Test
	//negative test case
	public void test7() {
		SavingsAcc obj1=new SavingsAcc();
		SavingsAcc obj2=new SavingsAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
		obj2.inititalize("Shaharyar", "12/12/2018", "0312066220", "Karachi", 7137629, 50000.0);
	
		boolean status=obj1.transferamount(obj2, 25000.0);
		assertEquals(status,false);
		double bal=obj1.getBalance();
		assertEquals(bal,1200.0,0.0);
	}
	@Test
	//negative test case
	public void test8() {
		SavingsAcc obj1=new SavingsAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
		
		double bal=obj1.calculateZakat();
		assertEquals(bal,0.0,0.0);
	}
	@Test
	//positive test case
	public void test9() {
		SavingsAcc obj1=new SavingsAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 25000.0);
		
		double bal=obj1.calculateZakat();
		assertEquals(bal,625.0,0.0);
	}
	@Test
	//positive test case
	public void test10() {
		SavingsAcc obj1=new SavingsAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 25000.0);
		
		double bal=obj1.calculateInterest(20);
		assertEquals(bal,30000.0,0.0);
	}
	@Test
	//negative test case
	public void test11() {
		SavingsAcc obj1=new SavingsAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 25000.0);
		
		double bal=obj1.calculateInterest(-20);
		assertEquals(bal,0.0,0.0);
	}
}
