import java.util.Scanner;

    class BankAccount{
    String Name;
    String Username;
    String Password;
    String AccountNumber;
    float balance = 1000000f;
    int transactions = 0;
    String transactionhistory = "";

    public void register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Your Name: ");

        System.out.println("\nEnter Your Username: ");
        System.out.println("\nEnter Your Password: ");
        System.out.println("\nEnter Your Account Number: ");
        System.out.println("\nREGISTRATION SUCCESSFUL");
        System.out.println("Login into your Bank Account");
    }

    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while(!isLogin){
            System.out.println("\nEnter Your Username: ");
            String Username = sc.nextLine();
            if(Username.equals(Username)){
                while(!isLogin){
                    System.out.println("\nEnter Your Password: ");
                    String Password = sc.nextLine();
                    if(Password.equals(Password)) {
                        System.out.println("\n LOGIN SUCCESSFUL");
                        isLogin = true;
                    }
                    else{
                        System.out.println("\nIncorrect Password");
                    }
                }
            }
            else {
                System.out.println("\nUsername not Found");
            }
        }
        return isLogin;
    }

    public void withdraw() {
        System.out.println("\n Enter the amount:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("\n Withdraw Successful");
                String str = amount + "Rs Withdraw\n";
                transactionhistory = transactionhistory.concat(str);
            }
            else{
                System.out.println("\nINSUFFICIENT BALANCE");
            }
        }
        catch(Exception e) {

        }
    }

    public void deposit() {
        System.out.println("\nEnter amount to Deposit: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if(amount <= 1000000f) {
                transactions++;
                balance += amount;
                System.out.println("\nDEPOSIT SUCCESSFUL");
                String str = amount + "Rs Deposited\n";
                transactionhistory = transactionhistory.concat(str);
            }
            else{
                System.out.println("\nSorry! Limit is 1000000f");
            }
        }
        catch(Exception e) {

        }

    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Enter Recepient's Name");
        String Recepient = sc.nextLine();
        System.out.println("\nEnter amount to transfer");
        float amount = sc.nextFloat();
        try{
            if (balance >= amount) {
                if(amount <= 10000f) {
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSuccessfully transferred to "+ Recepient);
                    String str = amount + "Rs transferred to " + Recepient+"\n";
                    transactionhistory = transactionhistory.concat(str);
                }
                else{
                    System.out.println("\nSorry the limit is 1000000f");
                }
            }
            else {
                System.out.println("\nINSUFFICIENT BALANCE");
            }
        }
        catch(Exception e) {

        }
    }


    public void checkBalance () {
        System.out.println("\n"+balance+"Rs");
    }


    public void TransactionHistory() {
        if (transactions ==0){
            System.out.println("NO TRANSACTIONS HAPPENED");
        }
        else{
            System.out.println("\n" +transactionhistory);
        }
    }
}

public class ATMINTERFACE {

        public static int takenIntegerInput (int limit) {
            int input = 0;
            boolean flag = false;

            while(!flag) {
                try {
                    Scanner sc = new Scanner(System.in);
                    input = sc.nextInt();
                    flag = true;

                    if(flag && input>limit || input<1) {
                        System.out.println("Choose the number between 1 to "+limit);
                        flag = false;
                    }
                }
                catch (Exception e) {
                    System.out.println("Enter only integer value");
                    flag= false;
                }
            }
            return input;
        }


        public static void main(String[] args) {
            System.out.println("\n     WELCOME TO OASIS BANK INTERFACE     ");
            System.out.println("\n1.Register  \n2.Exit");
            System.out.println("Choose one option: ");
            int choose = takenIntegerInput(2);

            if(choose == 1) {
                BankAccount b = new BankAccount();
                b.register();
                while (true) {
                    System.out.println("\n1.Login  \n2.Exit");
                    System.out.println("Enter your choice");
                    int ch = takenIntegerInput(2);
                    if (ch ==1) {
                        if (b.login()) {
                            System.out.println("  WELCOME BACK "+ b.Name +" ");
                            boolean isFinished = false;
                            while(!isFinished) {
                                System.out.println("\n1.WITHDRAW  \n2.DEPOSIT  \n3.TRANSFER \n4.CHECK BALANCE \n5.TRANSACTION HISTORY  \n6.EXIT");
                                System.out.println("Enter your choice: ");
                                int c = takenIntegerInput(6);
                                switch (c) {
                                    case 1:
                                        b.withdraw();
                                        break;
                                    case 2:
                                        b.deposit();
                                        break;
                                    case 3:
                                        b.transfer();
                                        break;
                                    case 4:
                                        b.checkBalance();
                                        break;
                                    case 5:
                                        b.TransactionHistory();
                                        break;
                                    case 6:
                                        isFinished = true;
                                        break;
                                }

                            }

                        }
                    }
                    else {
                        System.exit(0);
                    }  
                }

            }
            else {
                System.exit(0);
            }
        }
    }
    
