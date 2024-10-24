import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccount {
    private static class Transaction {
        private double amount;
        private String type;
        private LocalDate date;

        public Transaction(double amount, String type) {
            this.amount = amount;
            this.type = type;
            this.date = LocalDate.now();
        }

        @Override
        public String toString() {
            return type + " - " + String.format("%,.0f", amount) + " VNĐ - " + date;
        }
    }

    private String accountHolder;
    private double balance;
    private final double MONTHLY_INTEREST_RATE = 0.005; // 0.5% monthly interest
    private List<Transaction> transactions;
    private int withdrawalsThisMonth;
    private final int MAX_WITHDRAWALS = 3;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        this.withdrawalsThisMonth = 0;
        System.out.println("Tạo tài khoản mới: " + accountHolder);
        System.out.println("Số dư ban đầu: " + String.format("%,.0f", initialBalance) + " VNĐ");
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction(amount, "Deposit"));
        System.out.println("Đã gửi " + String.format("%,.0f", amount) + " VNĐ");
    }

    public boolean withdraw(double amount) {
        if (withdrawalsThisMonth >= MAX_WITHDRAWALS) {
            System.out.println("Rút " + String.format("%,.0f", amount) +
                    " VNĐ - Lỗi: Bạn đã đạt giới hạn rút tiền tháng này.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Rút " + String.format("%,.0f", amount) +
                    " VNĐ - Lỗi: Số dư không đủ.");
            return false;
        }

        balance -= amount;
        transactions.add(new Transaction(amount, "Withdraw"));
        withdrawalsThisMonth++;
        System.out.println("Đã rút " + String.format("%,.0f", amount) + " VNĐ");
        return true;
    }

    public void applyMonthlyInterest() {
        double interest = balance * MONTHLY_INTEREST_RATE;
        balance += interest;
        transactions.add(new Transaction(interest, "Interest"));
    }

    public void printBalance() {
        System.out.println("Số dư hiện tại: " + String.format("%,.0f", balance) + " VNĐ");
    }

    public void printTransactionHistory() {
        System.out.println("Lịch sử giao dịch:");
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i + 1) + ". " + transactions.get(i));
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount("Nguyễn Văn A", 5000000);

        // Deposit 1,000,000 VND
        account.deposit(1000000);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Rút tiền");
            System.out.println("2. Xem số dư");
            System.out.println("3. Xem lịch sử giao dịch");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số tiền muốn rút (VNĐ): ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    account.printBalance();
                    break;
                case 3:
                    account.printTransactionHistory();
                    break;
                case 4:
                    // Apply interest and show final balance before exiting
                    account.applyMonthlyInterest();
                    System.out.println("\nSố dư sau khi cộng lãi: " +
                            String.format("%,.0f", account.getBalance()) + " VNĐ");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}