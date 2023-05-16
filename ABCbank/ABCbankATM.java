import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Hashtable;

//bank Data base contains a hashmap which each client can be accessed from his key PIN

//class BankDatabase{
//    private HashMap<Integer,Client> mapClient;
//    static{
//        BankDatabase bank = new BankDatabase();
//    }
//    private BankDatabase(){
//
//    }
//    public BankDatabase getDatabase(){
//        return bank;
//    }
//    public Client searchClient(int PIN){
//        return mapClient.get(PIN);
//    }
//}
class Client{
    private String ID, Name, Nationality, Occupation, Address, Gender, Currency;
    private int age,PIN;
    private ArrayList<Account> personalAccounts;
    Client(String ID, String Name, String Nationality, String Occupation, String Address, int Age, String Gender, String Currency, int PIN){
        this.ID = ID;
        this.Name = Name;
        this.Nationality = Nationality;
        this.Occupation = Occupation;
        this.Address = Address;
        this.age = Age;
        this.Gender = Gender;
        this.PIN = PIN;
        this.personalAccounts = new ArrayList<>();
    }

    public void showAccounts(){
        int n = 1;
        for (Account x:personalAccounts){
            System.out.print(n);
            n++;
            System.out.println(" account: " + x.getAccNumber());
        }
    }
    public Account returnAcc(int num){
        return personalAccounts.get(num);
    }
    public String getCurrency(){
        return this.Currency;
    }
    public void addAccount(Account acc){
        this.personalAccounts.add(acc);
    }

}

class Loan{
    private int Ammount,Interest,Duration;
    private String PaymentMethod;
    private Account acc;

    Loan(int Amount, int Interest, int Duration, String PaymentMethod, Account acc){
        this.Ammount = Amount;
        this.Interest = Interest;
        this.Duration = Duration;
        this.PaymentMethod = PaymentMethod;
        this.acc = acc;
    }
}

abstract class Account{
    private String AccNumber, Currency, Branch;
    private ArrayList<Loan> accountLoans;
    private int Balance;
    private Client owner;

    Account(String AccNum, String Branch, int balance, Client owner){
        this.AccNumber = AccNum;
        this.Currency = owner.getCurrency();
        this.Branch = Branch;
        this.Balance = balance;
        this.owner = owner;
        owner.addAccount(this);
    }
    public int deposit(int val){
        this.Balance = this.Balance+val;
        return this.Balance;
    }
    public int withdraw(int val){
        this.Balance = this.Balance-val;
        return this.Balance;
    }
    public int getBalance(){
        return this.Balance;
    }

    public String getAccNumber(){
        return this.AccNumber;
    }
    public void requestLoan(int Amount, int Interest, int Duration, String PaymentMethod, Account acc){
        Loan newLoan = new Loan(Amount,Interest,Duration,PaymentMethod,acc);
        accountLoans.add(newLoan);
    }

}
class SavingAcc extends Account{
    SavingAcc(String AccNum, String Branch, int balance, Client owner) {
        super(AccNum, Branch, balance, owner);
    }
    void payInterest(){
        System.out.println("Paying Interset");
    }

}
class CurrentAcc extends Account{
    CurrentAcc(String AccNum, String Branch, int balance, Client owner) {
        super(AccNum, Branch, balance, owner);
    }
}
class transection{
    static int transID = 0;
    private String Status,Date;
    private Account acc;
    transection(){
        transID++;
    }
    public Account getAcc(){
        return this.acc;
    }

}
class Inquiery extends transection{

    Inquiery() {
    }
}
class Deposit extends transection{


    Deposit(int value) {
        super();
        this.getAcc().deposit(value);
    }

    public void doDeposit(int value){
        int newBalance = super.getAcc().deposit(value);
        System.out.println("New balance is: "+newBalance);
    }
}
class Withdrowal extends transection{
    Withdrowal(int value) {
        super();
        this.getAcc().withdraw(value);
    }

    public void doWithdrawal(int value){
        int newBalance = super.getAcc().withdraw(value);
        System.out.println("New balance is: "+newBalance);
    }
}

public class ABCbankATM {
    public static void main(String[] args) {

        Client c = new Client("200105003316", "Lasana Subasinghe", "Sinhala", "Student", "62/2,Gamhatha,Velamboda", 22, "Male", "LKR", 1234); //empty client to the continuity of the code design. Client must be accessed from bank data base.

        new SavingAcc("12345", "Kandy", 10000,c);

        HashMap<Integer,Client> bankDatabase = new HashMap<>();
        bankDatabase.put(1234,c);

        System.out.println("Welcome!\nEnter your PIN number");

        //input 1234 for test Case

        Scanner sc = new Scanner(System.in);

        int PIN = sc.nextInt(); //input pin

        //search client from bank database

        c.showAccounts();

        int account = sc.nextInt();
        // select account from the account list
        Account acc = c.returnAcc(account);

        System.out.println("1.View Balance\n2.Withdraw money.\n3.Deposit money.\n4.Exit.\nSelect option");

        //select option

        int option = sc.nextInt();
        if(option == 1){

            System.out.println(acc.getBalance());
        }
        else if(option == 2){
            int value = sc.nextInt();
            acc.withdraw(value);
            System.out.println(acc.getBalance());
        }
        else if(option == 3){
            int value = sc.nextInt();
            acc.deposit(value);
            System.out.println(acc.getBalance());
        }
        else if(option == 4){
            System.out.println("Thankyou!");
        }
        else{
            System.out.println("Invalid input");
        }
    }
}
