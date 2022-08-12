public class BankAccount {
    private String name;
    private double balance = 0.0;

    void deposit(double deposit_into_balance){
        balance += deposit_into_balance;
    }
    void withdraw(double withdraw_from_balance){
        balance -= withdraw_from_balance;
    }
    void get_balance() {
        System.out.printf("%.2f", balance);
        if (balance < 0) {
            System.out.println("\nYou're Account is Negative");
        }
    }
}

