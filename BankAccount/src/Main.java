import javax.swing.*;

private static class Account {
    private int accountId;
    private static int nextId = 1;
    private float balance;
    private float monthlyInterest; // 1 = 1%
    private ArrayList<String> transactionHistory;

    public Account(float balance, float monthlyInterest) {
        accountId = nextId;
        nextId++;
        this.balance = balance;
        this.monthlyInterest = monthlyInterest;
        transactionHistory = new ArrayList<>();
        transactionHistory.add("$" + roundString(this.balance) + " added to account");

        System.out.println("Account #" + accountId + " have been created");
        System.out.println("Current balance is $" + roundString(balance));
    }

    public void Deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("$" + roundString(amount) + " added to account");
            System.out.println("Current balance is $" + roundString(balance));
        }
    }

    public void Withdraw(float amount) {
        if (amount > 0) {
            balance -= amount;
            transactionHistory.add("$" + roundString(amount) + " removed from account");
            System.out.println("Current balance is $" + roundString(balance));
        }
    }

    public void GainInterest(int month) {
        for (int i = 0; i < month; i++) {
            float interest = balance * (monthlyInterest / 100f) / 12;
            balance += interest;
            transactionHistory.add("$" + roundString(interest) + " added to account");
        }
    }

    public void DisplayTransaction() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println();
        System.out.println("Current balance is $" + roundString(balance));
    }

    public String roundString(float number) {
        return String.format("%.2f", number);
    }
}

public static void main(String[] args) {
    Account account = null;
    float amount = 0;
    int month = 0;

    Scanner sc = new Scanner(System.in);

    System.out.println("Welcome to Chest Bank!");
    System.out.println();

    outerLoop:
    while (true) {
        System.out.println("1. Create a new account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Skip time (for interest)");
        System.out.println("5. See transaction history ledger");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");

        int userChoice = sc.nextInt();
        sc.nextLine();
        switch (userChoice) {
            case 1:
                account = new Account(100, 5);
                break;
            case 2:
                System.out.print("How much to deposit? ");
                try {
                    amount = Float.parseFloat(sc.nextLine());
                    account.Deposit(amount);
                } catch (NullPointerException e) {
                    System.out.println("Create an account before depositing!");
                } catch (NumberFormatException e) {
                    System.out.println("Amount must be a number!");
                }
                break;
            case 3:
                System.out.print("How much to withdraw? ");
                try {
                    amount = Float.parseFloat(sc.nextLine());
                    account.Withdraw(amount);
                } catch (NullPointerException e) {
                    System.out.println("Create an account before withdrawing!");
                } catch (NumberFormatException e) {
                    System.out.println("Amount must be a number!");
                }
                break;
            case 4:
                System.out.print("How many month(s) to skip? ");
                try {
                    month = Integer.parseInt(sc.nextLine());
                    account.GainInterest(month);
                } catch (NullPointerException e) {
                    System.out.println("No existing account found!");
                } catch (NumberFormatException e) {
                    System.out.println("Time must be a whole number!");
                }
                break;
            case 5:
                account.DisplayTransaction();
                break;
            default:
                System.out.println("Thanks for using our service!");
                break outerLoop;
        }
        System.out.println();
    }
}