package maven_ManagementSys;
//import java.util.*;
import java.util.Scanner;


import java.util.Calendar;
//import CheckingAcc;
public class MainFile {
	public static void main(String[] args) {
		Scanner var = new Scanner (System.in);
		Calendar currentDate=Calendar.getInstance();
		String Name, address, phone_no,datetda;
		int count=0,accNo;
		int accalter=0;
		int usracc;
		byte choice;
		int x=10;
		int size=5;
		int size2=4;
		CheckingAcc[] chAcc=new CheckingAcc[size];
		for (int i=0;i<size;i++) {
			chAcc[i]=new CheckingAcc();
		}
		chAcc[0].inititalize("Haris", "1-12-2020", "03408142381", "Muzaffarabad", 82204465, 350000);
		chAcc[1].inititalize("Saad", "12-10-2019", "03438342331", "Mirpur", 81232465, 12000);
		chAcc[2].inititalize("Omar", "9-9-2019", "03102453451", "Islamabad", 83232155, 10000);
		chAcc[3].inititalize("Saman", "10-10-2020", "0331809811", "Multan", 85407483, 50000);
		chAcc[4].inititalize("Rashid", "1-12-2020", "03228441231", "Rawalpindi", 61202729, 32100);
		SavingsAcc[] savArr=new SavingsAcc[size2];
		for (int i=0;i<size2;i++) {
			savArr[i]=new SavingsAcc();
		}
		savArr[0].inititalize("Kashif", "1-1-2019", "0301445510", "Hyderabad", 71233412, 45100);
		savArr[1].inititalize("Asif", "11-11-2020", "0310345614", "Bhimber", 7003522, 40000);
		savArr[2].inititalize("Amara", "12-12-2019", "0341343520", "Kotli", 71096742, 2100);
		savArr[3].inititalize("Haider", "10-8-2020", "0331245212", "Peshawar", 72201321, 20150);
		
		System.out.println("\t\t\t!!!!Welcome to my Management System !!!");
		System.out.println("\n");
		Scanner menuloop= new Scanner (System.in);
		char loopcheck='C';
		while(loopcheck!='e') {
		System.out.print("Press 1 if you want to create a new account\nPress 2 if you want to perform an action on the existing account");
		choice=var.nextByte();
		while(choice>2||choice<1) {
			System.out.print("Wrong input please enter again : ");
			choice=var.nextByte();
		}
		
		if(choice==1) {
			x+=1;
			var.nextLine();
			System.out.print("\nEnter name:");
			Name=var.nextLine();
	
			System.out.print("\nEnter Address:");
			address=var.nextLine();
			//System.out.print("\nEnter name:");
			System.out.print("\nEnter phone no. : ");
			phone_no=var.nextLine();
			datetda=currentDate.toString();
			System.out.print("what type of account do you want?\npress 1 for Cheking account\npress 2 for Savings Account");
			choice=var.nextByte();
			int sizeOfnew;
			while(choice>2||choice<1)
			{
				System.out.print("enter again wrong choice");
				choice=var.nextByte();
			}
			if(choice==1) {
				CheckingAcc temp=new CheckingAcc();
				temp.inititalize(Name, datetda, phone_no, address, 82210481+x, 0.0);
				sizeOfnew=size+1;
				CheckingAcc[] newArrCh=new CheckingAcc[sizeOfnew];
				for(int i=0;i<size;i++) {
					newArrCh[i]=chAcc[i];
				}
				size=sizeOfnew;
				newArrCh[size]=temp;
				chAcc=newArrCh;
			}
			else if (choice==2) {
				SavingsAcc tempo=new SavingsAcc();
				tempo.inititalize(Name, datetda, phone_no, address, 82210481+x, 0.0);
				sizeOfnew=size2+1;
				SavingsAcc[] newArrSv=new SavingsAcc[sizeOfnew];
				for(int i=0;i<size;i++) {
					newArrSv[i]=savArr[i];
				}
				size2=sizeOfnew;
				newArrSv[size]=tempo;
				savArr=newArrSv;
				
			}
		}
		if(choice == 2) { 
			//var.nextLine();
			System.out.print("Enter the account number : ");
			boolean savings=false,checkings=false;
			
			usracc=var.nextInt();
			for(int i=0;i<size2;i++)
			{
				if(usracc==savArr[i].getAccNo()) {
					savings=true;
					accalter=i;
					break;
				}
			}
			for (int i=0;i<size;i++) {
				if(usracc==chAcc[i].getAccNo()) {
					checkings=true;
					accalter=i;
					break;
				}
			}
			if(checkings==true)
			{
				System.out.print("\nWhat operation would you like to perform : \n");
				System.out.print("Press 1 to make a Deposit \n");
				System.out.print("Press 2 to make a Withdrawal \n");
				System.out.print("Press 3 to Transfer amount to another account \n");
				System.out.print("Press 4 to print statement \n");
				System.out.print("Press 5 to check Balance \n");
				System.out.print("Press 6 to close the account \n");
			}
			if(savings==true)
			{
				System.out.print("\nWhat operation would you like to perform : \n");
				System.out.print("Press 1 to make a Deposit \n");
				System.out.print("Press 2 to make a Withdrawal \n");
				System.out.print("Press 3 to Transfer amount to another account \n");
				System.out.print("Press 4 to calculate Zakat \n");
				System.out.print("Press 5 to check Balance \n");
				System.out.print("Press 6 to close the account \n");
			}
			choice=var.nextByte();
			while(choice<1||choice>6) {
				System.out.print("Wrong input please enter again : ");
				choice=var.nextByte();
			}
			if(choice == 1) {
				double dep_am;
				
				System.out.print("enter the amount you want to deposit");
				dep_am=var.nextDouble();
				if(savings==true) {
					savArr[accalter].makeDeposit(dep_am);
				
				}
				else if(checkings==true) {
					chAcc[accalter].makeDeposit(dep_am);
					count++;
					if(count>2) {
						chAcc[accalter].amountded();
					}
				}
				
			}
				
			if(choice == 2) {
				double withdraw;
				System.out.print("enter the amount you want to withdraw");
				withdraw=var.nextDouble();
				if(savings==true) {
					savArr[accalter].makeWithdrawal(withdraw);
			
				}
				else if(checkings==true) {
					chAcc[accalter].makeWithdrawal(withdraw);
					count++;
					if(count>2) {
						chAcc[accalter].amountded();
					}
				}
			}
			if (choice == 3) {

				double transferAmount;
				boolean tp=false;
				System.out.print("enter the amount you want to Transfer");
				transferAmount=var.nextInt();
				if (checkings==true) {
				if(transferAmount>chAcc[accalter].getBalance()) {
					System.out.print("Transfer not possible as you dont have enough balance");
				}
					else {
						tp=true;
				}
				}
				if (savings==true) {
					if(transferAmount>savArr[accalter].getBalance()) {
						System.out.print("Transfer not possible as you dont have enough balance");
					}
					else {
						tp=true;
					}
					
				}
				if(tp==true) {
				System.out.print("enter the account you want to transfer to : ");
				var.nextLine();
				accNo=var.nextInt();
				if(checkings==true) {
				for(int i=0;i<size;i++){
					if(accNo==chAcc[i].getAccNo()) {
						chAcc[accalter].transferamount(chAcc[i], transferAmount);
					}
				}
				}
				if(savings==true) {
				for(int i=0;i<size2;i++){
					if(accNo==savArr[i].getAccNo()) {
						savArr[accalter].transferamount(savArr[i], transferAmount);
					}
				}
			}
		}
			}
			if (choice == 4) {
				if(savings==true) {
					double z;
					z=savArr[accalter].calculateZakat();
					System.out.print(z);
				}
				else if(checkings==true) {
					
						chAcc[accalter].printstatement(10);
					
				}
			}
			if(choice == 5){
				System.out.print("the balance is : ");
				if(savings==true) {
					System.out.print(savArr[accalter].getBalance());
				}
				if(checkings==true) {
					System.out.print(chAcc[accalter].getBalance());
				}
				
			}
			if(choice == 6){
				System.out.print("acc has been closed");
			}
		
		}	
		
		System.out.print("\npress E to quit program");
		loopcheck=menuloop.next().charAt(0);
		if(loopcheck=='E'||loopcheck=='e') {
			break;
		}
		
		}
		System.out.print("\n program Terminated");
			//goto menu;
		menuloop.close();
		var.close();
		
	}
}
