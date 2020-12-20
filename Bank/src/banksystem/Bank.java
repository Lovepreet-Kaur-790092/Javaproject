package banksystem;


import java.io.File;
import java.io.*;
import java.util.*;

class Bankpro {
	FileWriter fr;
	File file = new File("filesys.txt");

	ArrayList<Integer> acc_no = new ArrayList<Integer>();
	ArrayList<String> acc_type = new ArrayList<String>();
	ArrayList<String> acc_name = new ArrayList<String>();
	String name[] = new String[20];
	int accno[] = new int[20];
	String acctype[] = new String[20];
	double balance[] = new double[20];
	static int totalacc = 0;
	int TotalAcc = 20, counter = 1;
	double minbal = 500;

	Bankpro() {

		for (int i = 0; i < TotalAcc; i++) {
			name[i] = "";
			accno[i] = 0;
			acctype[i] = "";
			balance[i] = 0.0;
		}
	}

	public void Newacc() {
		try {
			fr = new FileWriter(file, true);
			BufferedWriter myWriter = new BufferedWriter(fr);
			Scanner sc = new Scanner(System.in);

			String str;
			int account;
			double amount;
			boolean Flag;
			Flag = true;
			if (totalacc > TotalAcc) {
				System.out.println("\n\n\nSorry Acc. not open\n\n\n");
				Flag = false;
			}
			if (Flag = true) {
				totalacc++;
				System.out.println("\n\n\n Menu for New Account ");

				accno[totalacc] = totalacc;
				System.out.println("Account Number :  " + accno[totalacc]);
				System.out.print("Enter name  ");
				name[totalacc] = sc.nextLine();
				System.out.print("Enter Account Type (Saving/Current): ");
				System.out.flush();
				acctype[totalacc] = sc.nextLine();
				do {
					System.out.print("Enter Amount >500 for new Acc. open : ");
					balance[totalacc] = sc.nextDouble();
				} while (balance[totalacc] < minbal);
			}
			myWriter.write("\n" + accno[totalacc] + "\t" + name[totalacc] + "\t" + acctype[totalacc] + "\t"
					+ balance[totalacc]);
			myWriter.close();
			fr.close();
			System.out.println("\nFile System Updated \n\n");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void display() {
		Scanner sc = new Scanner(System.in);
		String str;
		int account = 0;
		boolean flag = true;
		System.out.print("Enter the account number: ");
		account = sc.nextInt();
		if (account < counter || account > totalacc) {
			System.out.println("\n\n\nAccount No. not exists \n\n");
			flag = false;
		}
		if (flag == true) {
			System.out.println("\n\nAccount No. : " + accno[account]);
			System.out.println("Name : " + name[account]);
			System.out.println("Account Type : " + acctype[account]);
			System.out.println("Balance Amount : " + balance[account] + "\n\n\n");
		}
	}

	
	public void update() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		String str;
		int account = 0;
		boolean flag = true;
		System.out.println("\nAccount Information Updation");
		System.out.print("Enter the account number: ");
		account = sc.nextInt();
		System.out.print("Enter name for updation  ");
		str = sc1.nextLine();
			name[account]=str;
			System.out.println("\nAccount No. : " + accno[account]);
			System.out.println("Name : " + name[account]);
			System.out.println("Account Type : " + acctype[account]);
			System.out.println("Balance Amount : " + balance[account] + "\n");
		}
	
	
	public void deposit() {
		Scanner sc = new Scanner(System.in);
		String str;
		double amount;
		int account;
		boolean flag = true;
		System.out.println("\n\n\nDeposit Amount");
		System.out.print("Enter Account No : ");
		account = sc.nextInt();
		if (account < counter || account > totalacc) {
			System.out.println("\n\n\nAccount No. not exists \n\n");
			flag = false;
		}

		if (flag == true) {
			System.out.print("Enter Amount for Deposit  : ");
			amount = sc.nextDouble();
			balance[account] = balance[account] + amount;
			System.out.println("Account No. :  " + account);
			System.out.println("Balance     :  " + balance[account] + "\n");
		}
	}

	public void withdraw() {
		Scanner sc = new Scanner(System.in);

		String str;

		double amount, checkamount;
		int account;
		boolean flag = true;

		System.out.println("\n\n\nWithdraw Amount\n");
		System.out.print("Enter the account number  : ");

		account = sc.nextInt();
		if (account < counter || account > totalacc) {
			System.out.println("\n\nAccount No. not exists \n\n");
			flag = false;
		}

		if (flag == true) {
			System.out.println("Balance is : " + balance[account]);
			System.out.print("Enter Amount for withdraw  : ");
			amount = sc.nextDouble();
			checkamount = balance[account] - amount;
			if (checkamount >= minbal) {
				balance[account] = checkamount;
							System.out.println("Account Number :  " + account);
				System.out.println("Balance Amount :  " + balance[account] + "\n\n\n");
			} else {
				System.out.println("\n\nLow balance\n\n\n");
			}
		}

	}
	
	
	public void paybill() {
		Scanner sc = new Scanner(System.in);
		String str;
		double amount, checkamount;
		int account;
		boolean flag = true;
		System.out.println("\nBill Payment\n");
		System.out.print("Enter the account number  : ");
		account = sc.nextInt();
		if (account < counter || account > totalacc) {
			System.out.println("\nAccount No. not exists \n");
			flag = false;
		}

		if (flag == true) {
			System.out.println("Balance is : " + balance[account]);
			System.out.print("Enter Amount for Bill Payment to Company  : ");
			amount = sc.nextDouble();
			checkamount = balance[account] - amount;
			if (checkamount >= minbal) {
				balance[account] = checkamount;
				System.out.println("Account Number :  " + account);
				System.out.println("Balance Amount :  " + balance[account] + "\n");
			} else {
				System.out.println("\nLow balance\n");
			}
		}

	}
	public void transfer() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		String str;
		double amount, checkamount,checkamount1;
		int account,account1;
		boolean flag = true;
		System.out.println("\nTransfer Amount\n");
		System.out.print("Enter the account number from which money transfer : ");
		account = sc.nextInt();
		System.out.print("Enter the account number where money transfer : ");
		account1 = sc.nextInt();
		if (account < counter || account > totalacc) {
			System.out.println("\nAccount No. not exists \n");
			flag = false;
		}

		if (flag == true) {
			System.out.println("Balance is : " + balance[account]);
			System.out.print("Enter Amount for withdraw  : ");
			amount = sc.nextDouble();
			checkamount = balance[account] - amount;
			checkamount1 = balance[account1] + amount;
			if (checkamount >= minbal) {
				balance[account] = checkamount;
				balance[account1] = checkamount1;
				System.out.println("Account Number :  " + account);
				System.out.println("Balance Amount :  " + balance[account] + "\n");
			} else {
				System.out.println("\nLow balance\n");
			}
		}

	}
	
	
}

class Bank {
	public static void main(String args[]) {
		String str;
		int choice;
		choice = 0;
		Bankpro obj = new Bankpro();
		do {
			System.out.println("Enter Your Choices ");
			System.out.println("Press 1 for New Record ");
			System.out.println("Press 2 for Display Record");
			System.out.println("Press 3 for Deposit");
			System.out.println("Press 4 for Withdraw");
			System.out.println("Press 5 for Updation");
			System.out.println("Press 6 for Transfer Money");
			System.out.println("Press 7 for Bill Payment");
			System.out.println("Press 8 for Exit");
			System.out.print("Enter choice :  ");
			
			Scanner sc = new Scanner(System.in);

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				obj.Newacc();
				break;
			case 2:
				obj.display();
				break;
			case 3:
				obj.deposit();
				break;
			case 4:
				obj.withdraw();
				break;
			case 5:
				obj.update(); 
				break;
			case 6:
				obj.transfer();
				break;
			case 7:
				obj.paybill();
				break;
			}

		} while (choice != 8);
	}
}
