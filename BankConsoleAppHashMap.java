import java.util.HashMap;
import java.util.Scanner;
class AccountNotFoundException extends Exception{
    AccountNotFoundException(String message){
        super(message);
    }
}
class InsufficientFundsException extends Exception{
    InsufficientFundsException(String message){
        super(message);
    }
}
class Account{
    int accountId;
    String customerName;
    double balance;
    Account(int accountId,String customerName,double balance){
        this.accountId=accountId;
        this.customerName=customerName;
        this.balance=balance;
    }
}
public class BankConsoleAppHashMap{
    static HashMap<Integer, Account> accounts=new HashMap<>();
    static Scanner sc=new Scanner(System.in);
    static void createAccount(){
        int id;
        while(true){
            System.out.print("Enter Account ID : ");
            if(sc.hasNextInt()){
                id=sc.nextInt();
                if(id<100000||id>999999){
                    System.out.println("Account ID must be exactly 6 digits.");
                    continue;
                }
                if(accounts.containsKey(id)){
                    System.out.println("Account ID already exist");
                    continue;
                }
                break;
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
        Account account=new Account(id,name,balance);
        accounts.put(id,account);
        System.out.println("\nAccount Created Successfully.");
    }
    static void deposit(){
    System.out.print("Enter Account ID : ");
    int id=sc.nextInt();
    try{
        Account account=accounts.get(id);
        if(account==null){
            throw new AccountNotFoundException("Account not found.");
        }
        double amount;
        while(true){
            System.out.print("Enter Deposit Amount : ");
            if(sc.hasNextDouble()){
                amount=sc.nextDouble();
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
        account.balance+=amount;
        System.out.println("Deposit Successful.");
        System.out.println("Updated Balance : "+account.balance);
    }
    catch (AccountNotFoundException e){
        System.out.println("Error: " + e.getMessage());
    }
    }
    static void withdraw(){
    System.out.print("Enter Account ID : ");
    int id=sc.nextInt();
    try{
        Account account=accounts.get(id);
        if(account==null){
            throw new AccountNotFoundException("Account not found.");
        }
        double amount;
        while(true){
            System.out.print("Enter Withdraw Amount : ");
            if(sc.hasNextDouble()){
                amount=sc.nextDouble();
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
        if(amount>account.balance){
            throw new InsufficientFundsException("Insufficient balance.");
        }
        account.balance-=amount;
        System.out.println("Withdrawal Successful.");
        System.out.println("Updated Balance : " + account.balance);
    }
    catch(AccountNotFoundException e){
        System.out.println("Error: " + e.getMessage());
    }
    catch(InsufficientFundsException e){
        System.out.println("Error: " + e.getMessage());
    }
    }
    public static void main(String[] args){
        int choice;
        do{
            System.out.println("\n========== SECURE BANK ==========");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter Choice : ");
            while(!sc.hasNextInt()){
                System.out.println("Invalid Choice. Numbers only.");
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
                System.out.println("Thank You...");
                break;
            default:
                System.out.println("Invalid Choice.");
            }
        }
        while(choice!=4);
        }
    }    
        