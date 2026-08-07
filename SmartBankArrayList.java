import java.util.ArrayList;
import java.util.Scanner;
class Account{
    int accountId;
    String customerName;
    double balance;
    Account(int accountId, String customerName, double balance){
        this.accountId=accountId;
        this.customerName=customerName;
        this.balance=balance;
    }
}
public class SmartBankArrayList{
    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    static void createAccount(){
        int id;
        while(true){
            System.out.print("Enter Account ID : ");
            if(sc.hasNextInt()){
              id=sc.nextInt();

            if (id<100000||id>999999){
                System.out.println("Account ID must be exactly 6 digits.");
                    continue;
            }
                boolean duplicate = false;
                for(Account acc:accounts){
                    if(acc.accountId==id){
                        duplicate=true;
                        break;
                    }
                }
                if(duplicate){
                    System.out.println("Account ID already exists.");
                }
                else{
                    break;
                }
            }
            else{
                System.out.println("Invalid Account ID. Numbers only.");
                sc.next();
            }
        }
        sc.nextLine();
        String name;
        while(true){
            System.out.print("Enter Customer Name : ");
            name=sc.nextLine();
            if(name.matches("[a-zA-Z ]+")){
                break;
            }
            else{
                System.out.println("Name should contain only alphabets.");
            }
        }
        double balance;
        while(true){
            System.out.print("Enter Initial Balance : ");
            if(sc.hasNextDouble()){
                balance=sc.nextDouble();
                if(balance>=500){
                    break;
                }
                else{
                    System.out.println("Minimum balance should be 500.");
                }
            }
            else{
                System.out.println("Invalid Amount.");
                sc.next();
            }
        }
        accounts.add(new Account(id, name, balance));
        System.out.println("\nAccount Created Successfully.");
    }
    static void deposit(){
    System.out.print("Enter Account ID : ");
    int id = sc.nextInt();
    for (Account acc:accounts){
        if (acc.accountId==id){
            double amount;
            while(true){
                System.out.print("Enter Deposit Amount : ");
                if (sc.hasNextDouble()){
                    amount=sc.nextDouble();
                    if (amount>0){
                        break;
                    }
                    else{
                        System.out.println("Amount must be greater than 0.");
                    }
                } else{
                    System.out.println("Invalid Amount.");
                    sc.next();
                }
            }
            acc.balance+=amount;
            System.out.println("Deposit Successful.");
            return;
        }
    }
    System.out.println("Account Not Found.");
    }
    static void withdraw(){
    System.out.print("Enter Account ID : ");
    int id = sc.nextInt();
    for (Account acc : accounts){
        if (acc.accountId==id){
            double amount;
            while(true){
                System.out.print("Enter Withdraw Amount : ");
                if(sc.hasNextDouble()){
                    amount = sc.nextDouble();
                    if(amount>0){
                        break;
                    }
                    else{
                        System.out.println("Amount must be greater than 0.");
                    }
                }
                else{
                    System.out.println("Invalid Amount.");
                    sc.next();
                }
            }
            if(amount>acc.balance){
                System.out.println("Insufficient Balance.");
            }
            else{
                acc.balance-=amount;
                System.out.println("Withdrawal Successful.");
            }
            return;
        }
    }
    System.out.println("Account Not Found.");
    }
    static void balanceCheck(){
    System.out.print("Enter Account ID : ");
    int id=sc.nextInt();
    for(Account acc:accounts){
        if(acc.accountId==id){
            System.out.println("\n----- ACCOUNT DETAILS -----");
            System.out.println("Account ID      : " + acc.accountId);
            System.out.println("Customer Name   : " + acc.customerName);
            System.out.println("Balance         : " + acc.balance);
            return;
        }
    }
    System.out.println("Account Not Found.");
    }
    static void displayAccounts(){
    if(accounts.isEmpty()){
        System.out.println("No Accounts Available.");
        return;
    }
    System.out.println("\n===== ALL ACCOUNTS =====");
    for(Account acc:accounts){
        System.out.println("----------------------------");
        System.out.println("Account ID      : " + acc.accountId);
        System.out.println("Customer Name   : " + acc.customerName);
        System.out.println("Balance         : " + acc.balance);
    }
    }
    public static void main(String[] args){
        int choice;
        do{
            System.out.println("\n========== SMART BANK ==========");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Check");
            System.out.println("5. Display All Accounts");
            System.out.println("4. Exit");
            System.out.print("Enter Choice : ");
            while(!sc.hasNextInt()){
                System.out.println("Invalid Choice.");
                sc.next();
                System.out.print("Enter Choice : ");
            }
            choice=sc.nextInt();
            switch(choice){
            case 1:
              createAccount();
               break; 
            case 2:
              deposit();
               break;
            case 3:
              withdraw();
               break;
            case 4:
              balanceCheck();
               break;
            case 5:
              displayAccounts();
                break;
            case 6:
              System.out.println("Thank You...");
                break;
            default:
                System.out.println("Invalid Choice.");
        } 
    }
        while(choice!=6);
    }
}
