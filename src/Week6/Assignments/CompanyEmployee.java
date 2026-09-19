package Week6.Assignments;

public class CompanyEmployee {

    String empName;
    double salary;

    static String companyName =
            "Bright Horizon Technologies";

    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {

        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    static void printCompanyInfo() {

        System.out.println(companyName);
        System.out.println(
                "Employees on record: " + employeeCount
        );
    }

    public static void main(String[] args) {

        CompanyEmployee employee1 =
                new CompanyEmployee("Ravi", 50000);

        CompanyEmployee employee2 =
                new CompanyEmployee("Priya", 60000);

        CompanyEmployee employee3 =
                new CompanyEmployee("Arjun", 45000);

        System.out.println("3 Employee objects created");
        System.out.println();

        CompanyEmployee.printCompanyInfo();
    }
}