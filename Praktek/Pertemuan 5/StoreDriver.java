import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreDriver {

    public static void main(String[] args) throws FileNotFoundException {
        int managerCount = 0;
        int salesAssociateCount = 0;
        int supervisorCount = 0;

        PrintWriter pwd = new PrintWriter(new File("outputFile.txt"));
        Scanner sc = new Scanner(new File("src/inputFile.txt"));

        List<Manager> managerList = new ArrayList<>();
        List<SalesAssociate> salesAssociateList = new ArrayList<>();
        List<Supervisor> supervisorList = new ArrayList<>();

        while (sc.hasNext()) {
            String employeeType = sc.nextLine();
            String storeDetails = sc.nextLine();
            String empName = sc.nextLine();
            double basePay = sc.nextDouble();
            double numberOfHoursWorked = sc.nextDouble();
            double hourlyRate = sc.nextDouble();

            if (employeeType.equals("Manager")) {
                double currentSales = sc.nextDouble();
                double currentStoreSales = sc.nextDouble();

                Manager manager = new Manager(currentStoreSales, currentSales, numberOfHoursWorked,
                        hourlyRate, storeDetails, basePay, empName);
                managerList.add(manager);
                sc.nextLine(); // Consume the newline character

            } else if (employeeType.equals("SalesAssociates")) {  // Corrected the employee type
                double salesRate = sc.nextDouble();
                SalesAssociate salesAssociate = new SalesAssociate(salesRate, numberOfHoursWorked, hourlyRate,
                        storeDetails, empName, basePay);
                salesAssociateList.add(salesAssociate);
                sc.nextLine(); // Consume the newline character

            } else if (employeeType.equals("Supervisor")) {
                double supervisionRate = sc.nextDouble();
                Supervisor supervisor = new Supervisor(numberOfHoursWorked, hourlyRate, storeDetails,
                        basePay, empName);
                supervisor.setSupervisionRate(supervisionRate);
                supervisorList.add(supervisor);
                sc.nextLine(); // Consume the newline character
            }
        }

        // Output for Managers
        System.out.println("******************************************************");
        System.out.println("Number of employees working as MANAGER are: " + managerList.size());
        System.out.println("******************************************************");
        pwd.println("******************************************************");
        pwd.println("Number of employees working as MANAGER are: " + managerList.size());
        pwd.println("******************************************************");

        for (Manager manager : managerList) {
            managerCount++;
            System.out.println(managerCount + ". Manager Details:");
            System.out.println(manager);
            pwd.println(managerCount + ". Manager Details:");
            pwd.println(manager);
            System.out.println("Percentage of sales done: " + String.format("%.2f", manager.salesPercentByManager()) + "%");
            pwd.println("Percentage of sales done: " + String.format("%.2f", manager.salesPercentByManager()) + "%");
            System.out.println("Gross Payment: $" + String.format("%.1f", manager.calculatePay()));
            pwd.println("Gross Payment: $" + String.format("%.1f", manager.calculatePay()));
            System.out.println("Remaining store revenue: $" + manager.calculateRemainingStoreRevenue(manager.getTotalStoreSales()));
            pwd.println("Remaining store revenue: $" + manager.calculateRemainingStoreRevenue(manager.getTotalStoreSales()));
            System.out.print("Is " + manager.getEmployeeName() + " eligible for promotion? ");
            System.out.println(manager.checkPromotionEligibility() ? "Yes, he is \n" : "No, he needs to work harder\n");
        }

        // Output for Sales Associates
        System.out.println("******************************************************");
        System.out.println("Number of employees working as SALES ASSOCIATES are: " + salesAssociateList.size());
        System.out.println("******************************************************");
        pwd.println("******************************************************");
        pwd.println("Number of employees working as SALES ASSOCIATES are: " + salesAssociateList.size());
        pwd.println("******************************************************");

        for (SalesAssociate salesAssociate : salesAssociateList) {
            salesAssociateCount++;
            System.out.println(salesAssociateCount + ". Sales Associate Details:");
            System.out.println(salesAssociate);
            pwd.println(salesAssociateCount + ". Sales Associate Details:");
            pwd.println(salesAssociate);
            System.out.println("Total commission: $" + salesAssociate.calculateCommission());
            System.out.println("Gross Payment: $" + salesAssociate.calculatePay());
            pwd.println("Total commission: $" + salesAssociate.calculateCommission());
            pwd.println("Gross Payment: $" + salesAssociate.calculatePay());
            System.out.print("Is " + salesAssociate.getEmployeeName() + " eligible for promotion? ");
            System.out.println(salesAssociate.checkPromotionEligibility() ? "Yes, he/she is eligible\n" : "No, he/she needs to work harder\n");
        }

        // Output for Supervisors
        System.out.println("******************************************************");
        System.out.println("Number of employees working as SUPERVISORS are: " + supervisorList.size());
        System.out.println("******************************************************");
        pwd.println("******************************************************");
        pwd.println("Number of employees working as SUPERVISORS are: " + supervisorList.size());
        pwd.println("******************************************************");

        for (Supervisor supervisor : supervisorList) {
            supervisorCount++;
            System.out.println(supervisorCount + ". Supervisor Details:");
            System.out.println(supervisor);
            pwd.println(supervisorCount + ". Supervisor Details:");
            pwd.println(supervisor);
            System.out.println("Gross Payment: $" + String.format("%.1f", supervisor.calculatePay()));
            pwd.println("Gross Payment: $" + String.format("%.1f", supervisor.calculatePay()));
            System.out.print("Is " + supervisor.getEmployeeName() + " eligible for promotion? ");
            System.out.println(supervisor.checkPromotionEligibility() ? "Yes, he/she is eligible\n" : "No, he/she needs to work harder\n");
        }

        pwd.close();
    }
}
