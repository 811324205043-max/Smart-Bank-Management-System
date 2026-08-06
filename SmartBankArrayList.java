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
                if(id<=0){
                    System.out.println("Account ID must be greater than 0.");
                    continue;
                }
                boolean duplicate=false;
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
    public static void main(String[] args){
        int choice;
        do{
            System.out.println("\n========== SMART BANK ==========");
            System.out.println("1. Create Account");
            System.out.println("2. Exit");
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
                    System.out.println("Thank You...");
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        } 
        while(choice != 2);
    }
}
