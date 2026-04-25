import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n===== EMPLOYEE PAYROLL MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. View Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Add Bonus");
            System.out.println("7. Deduct Salary");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();

                    System.out.print("Bonus: ");
                    double bonus = sc.nextDouble();

                    dao.addEmployee(new Employee(name, email, dept, salary, bonus));
                    break;

                case 2:
                    dao.getAllEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    dao.getEmployeeById(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("New Department: ");
                    String newDept = sc.nextLine();

                    System.out.print("New Salary: ");
                    double newSalary = sc.nextDouble();

                    dao.updateEmployee(id, newEmail, newDept, newSalary);
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    dao.deleteEmployee(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Employee ID: ");
                    int bonusId = sc.nextInt();

                    System.out.print("Bonus Amount: ");
                    double bonusAmt = sc.nextDouble();

                    dao.addBonus(bonusId, bonusAmt);
                    break;

                case 7:
                    System.out.print("Enter Employee ID: ");
                    int salId = sc.nextInt();

                    System.out.print("Amount to Deduct: ");
                    double deductAmt = sc.nextDouble();

                    dao.deductSalary(salId, deductAmt);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
            
        
    } 
}