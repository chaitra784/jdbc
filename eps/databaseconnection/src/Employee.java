public class Employee {

    int emp_id;
    String name;
    String email;
    String department;
    double salary;
    double bonus;

    public Employee(String name, String email, String department, double salary, double bonus) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.bonus = bonus;
    }
}