// Account Registration, Deposits, Withdrawals, Interests (with time skip), Display Transaction History Ledger
package BankAccount;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    private static class Account {
        private int accountId;
        private static int nextId = 1;
        private float balance;
        private float monthlyInterest;
        private ArrayList<String> transactionHistory;

        public Account(float balance, float monthlyInterest) {
            accountId = nextId;
            nextId++;
            this.balance = balance;
            this.monthlyInterest = monthlyInterest;
            transactionHistory.add(this.balance + " added to account");
        }

        public void Deposit(float amount) {
            if (amount > 0) {
                balance += amount;
                transactionHistory.add("$" + roundString(amount) + " added to account");
            }
        }

        public void Withdraw(float amount) {
            if (amount > 0) {
                balance -= amount;
                transactionHistory.add("$" + roundString(amount) + " removed from account");
            }
        }

        public void GainInterest(int month) {
            balance += (monthlyInterest * month);
        }

        public void DisplayTransaction() {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
            System.out.println("Current balance is $" + roundString(balance));
        }

        public String roundString(float number) {
            return String.format("%.2f", number);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Bank!");
        outerLoop : while (true) {
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Skip time");
            System.out.println("5. See transaction history ledger");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int userChoice = sc.nextInt();
            sc.nextLine();
            switch (userChoice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Thanks for visiting!");
                    break outerLoop;
            }
            System.out.println();
        }
    }
}
