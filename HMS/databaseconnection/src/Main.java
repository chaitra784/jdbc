import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientDAO dao = new PatientDAO();

        while (true) {

            System.out.println("\n===== HOSPITAL MANAGEMENT MENU =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. View Patient by ID");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Add Bill");
            System.out.println("7. Pay Bill");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Disease: ");
                    String disease = sc.nextLine();

                    System.out.print("Doctor Assigned: ");
                    String doctor = sc.nextLine();

                    System.out.print("Initial Bill: ");
                    double bill = sc.nextDouble();

                    dao.addPatient(new Patient(name, age, disease, doctor, bill));
                    break;

                case 2:
                    dao.getAllPatients();
                    break;

                case 3:
                    System.out.print("Enter Patient ID: ");
                    dao.getPatientById(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Disease: ");
                    String newDisease = sc.nextLine();

                    System.out.print("New Doctor: ");
                    String newDoctor = sc.nextLine();

                    System.out.print("New Bill: ");
                    double newBill = sc.nextDouble();

                    dao.updatePatient(id, newDisease, newDoctor, newBill);
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    dao.deletePatient(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Patient ID: ");
                    int addId = sc.nextInt();

                    System.out.print("Amount to Add: ");
                    double addAmt = sc.nextDouble();

                    dao.addBill(addId, addAmt);
                    break;

                case 7:
                    System.out.print("Enter Patient ID: ");
                    int payId = sc.nextInt();

                    System.out.print("Amount to Pay: ");
                    double payAmt = sc.nextDouble();

                    dao.payBill(payId, payAmt);
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