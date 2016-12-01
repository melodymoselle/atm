import java.util.Scanner;

/**
 * Created by melmo on 11/30/16.
 */
public class User {
    private String name;
    private int balance;
    private Scanner input = new Scanner(System.in);

    public User(int startBalance) {
        this.balance = startBalance;
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    public void chooseName() throws Exception {
        System.out.println("What is your name?");
        String name = this.input.nextLine();
        if (!name.equals("")) {
            this.name = name;
            System.out.format("Hello %s.\n", this.name);
        } else {
            throw new Exception("Invalid input!");
        }
    }

    public void whichOp() throws Exception {
        System.out.format("What would you like to do?\n" +
                "1 : Check my balance\n" +
                "2 : Withdraw funds\n" +
                "3 : Deposit funds\n" +
                "4 : Exit\n");
        String choice = this.input.nextLine();
        if (choice.equals("1")) {
            System.out.println("Your balance is $" + this.getBalance());
            whichOp();
        } else if (choice.equals("2")) {
            withdraw();
            whichOp();
        } else if (choice.equals("3")) {
            deposit();
            whichOp();
        } else if (choice.equals("4")) {
            System.out.println("Thank you and please come again.");
        } else {
            System.out.println("Please enter a valid response.");
            whichOp();
        }
    }

    public void withdraw() throws Exception {
        int begBal = this.balance;
        int amount;

        System.out.println("How much would you like to withdraw?");

        try {
            amount = Integer.parseInt(this.input.nextLine());

            if (amount <= 0) {
                System.out.println("Please enter an amount greater than $0.");
                withdraw();
            }

            if (amount > this.balance) {
                throw new Exception("You do not have enough money!");
            }

            this.balance -= amount;
            System.out.format("Beginning Balance: %d\n" +
                    "Withdrawal Amount: %d\n" +
                    "   Ending Balance: %d\n", begBal, amount, this.balance);
        }
        catch (NumberFormatException e) {
            System.out.println("Please enter valid number.");
            withdraw();
        }

    }

    public void deposit() {
        int begBal = this.balance;
        int amount;

        System.out.println("How much would you like to deposit?");

        try {
            amount = Integer.parseInt(this.input.nextLine());

            if (amount <= 0) {
                System.out.println("Please enter an amount greater than $0.");
                deposit();
            }

            this.balance += amount;
            System.out.format("Beginning Balance: %d\n" +
                              "   Deposit Amount: %d\n" +
                              "   Ending Balance: %d\n", begBal, amount, this.balance);
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number.");
            deposit();
        }
    }
}