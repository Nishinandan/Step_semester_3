package Week6.Assignments;

public class PayrollAccount {

    private double basicSalary;
    private double bonus;

    // Constructor
    public PayrollAccount(double openingBasicSalary) {

        if (openingBasicSalary < 0) {
            System.out.println(
                    "Warning: Negative basic salary. Starting with Rs 0."
            );

            basicSalary = 0;
        } else {
            basicSalary = openingBasicSalary;
        }

        bonus = 0;
    }

    // Adds bonus to the account
    public void creditBonus(double amount) {

        if (amount <= 0) {
            System.out.println(
                    "Bonus rejected: amount must be positive"
            );
        } else {
            bonus = bonus + amount;

            System.out.println(
                    "Bonus credited: Rs " + amount
            );
        }
    }

    // Deducts tax from basic salary
    public void deductTax(double percent) {

        if (percent < 0 || percent > 100) {

            System.out.println(
                    "Tax rejected: percent must be between 0 and 100"
            );

        } else {

            basicSalary =
                    basicSalary - (basicSalary * percent / 100);

            System.out.println(
                    "Tax deducted: " + percent + "%"
            );
        }
    }

    // Returns net salary
    public double getNetSalary() {

        return basicSalary + bonus;
    }

    public static void main(String[] args) {

        PayrollAccount account =
                new PayrollAccount(50000);

        account.creditBonus(5000);

        account.deductTax(10);

        System.out.println(
                "Net salary: Rs " + account.getNetSalary()
        );
    }
}