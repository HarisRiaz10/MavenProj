package maven_ManagementSys;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestChecking {

	@Test
	public void test() {
		CheckingAcc obj1=new CheckingAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
	
		double available=obj1.getBalance();
		assertEquals(available,1200.0,0.0);
		
	}
	@Test
	public void test1() {  //positive test case
		CheckingAcc obj1=new CheckingAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
	
		boolean status=obj1.makeDeposit(22000.0);
		assertEquals(true,status);
		double now=obj1.getBalance();
		assertEquals(23200.0,now,0.0);
		
	}
	public void test2() {    //negative test case
		CheckingAcc obj1=new CheckingAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
	
		boolean status=obj1.makeDeposit(-22000.0);
		assertEquals(false,status);
		double now=obj1.getBalance();
		assertEquals(1200.0,now,0.0);
		
	}
	@Test
	public void test3() {  //positive test
		CheckingAcc obj1=new CheckingAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
		
		obj1.makeWithdrawal(200.50);
		double available=obj1.getBalance();
		assertEquals(available,999.50,0.0);	
	}
	
	@Test
	public void test4() {  //negative test
		CheckingAcc obj1=new CheckingAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
	
		boolean status=obj1.makeWithdrawal(8000.0);
		assertEquals(status,false);
		
	}
	@Test
	public void test5() {    //positive test
		CheckingAcc obj1=new CheckingAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
	
		boolean status=obj1.makeWithdrawal(6200.0);
		assertEquals(status,true);
		
	}
	@Test
	public void test5_1() {    //negative test
		CheckingAcc obj1=new CheckingAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
	
		boolean status=obj1.makeWithdrawal(-6200.0);
		assertEquals(status,false);
		
	}
	@Test
	//positive test case
	public void test6() { 
		CheckingAcc obj1=new CheckingAcc();
		CheckingAcc obj2=new CheckingAcc();
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
		CheckingAcc obj1=new CheckingAcc();
		CheckingAcc obj2=new CheckingAcc();
		obj1.inititalize("Haris", "10/10/2019", "0321239982", "Rawalpindi", 9907721, 1200.0);
		obj2.inititalize("Shaharyar", "12/12/2018", "0312066220", "Karachi", 7137629, 50000.0);
	
		boolean status=obj1.transferamount(obj2, 25000.0);
		assertEquals(status,false);
		double bal=obj1.getBalance();
		assertEquals(bal,1200.0,0.0);
	}
	
}
