public class Patient {

    int patient_id;
    String name;
    int age;
    String disease;
    String doctor_assigned;
    double bill_amount;

    public Patient(String name, int age, String disease, String doctor, double bill) {
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.doctor_assigned = doctor;
        this.bill_amount = bill;
    }
}