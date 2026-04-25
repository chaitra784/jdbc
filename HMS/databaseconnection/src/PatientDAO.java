import java.sql.*;

public class PatientDAO {

    // ADD PATIENT
    public void addPatient(Patient p) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO patients(name,age,disease,doctor_assigned,bill_amount) VALUES(?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.name);
            ps.setInt(2, p.age);
            ps.setString(3, p.disease);
            ps.setString(4, p.doctor_assigned);
            ps.setDouble(5, p.bill_amount);

            ps.executeUpdate();

            System.out.println("Patient Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ ALL
    public void getAllPatients() {

        try {
            Connection conn = DBConnection.getConnection();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patients");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("patient_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("disease") + " | " +
                        rs.getString("doctor_assigned") + " | " +
                        rs.getDouble("bill_amount")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ BY ID
    public void getPatientById(int id) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM patients WHERE patient_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getInt("patient_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("disease") + " | " +
                        rs.getString("doctor_assigned") + " | " +
                        rs.getDouble("bill_amount")
                );
            } else {
                System.out.println("Patient Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updatePatient(int id, String disease, String doctor, double bill) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE patients SET disease=?, doctor_assigned=?, bill_amount=? WHERE patient_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, disease);
            ps.setString(2, doctor);
            ps.setDouble(3, bill);
            ps.setInt(4, id);

            ps.executeUpdate();

            System.out.println("Patient Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletePatient(int id) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "DELETE FROM patients WHERE patient_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Patient Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ADD BILL (CREDIT)
    public void addBill(int id, double amount) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE patients SET bill_amount = bill_amount + ? WHERE patient_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Bill Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // PAY BILL (DEBIT)
    public void payBill(int id, double amount) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE patients SET bill_amount = bill_amount - ? WHERE patient_id=? AND bill_amount >= ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, id);
            ps.setDouble(3, amount);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Bill Paid");
            else
                System.out.println("Insufficient Bill Amount");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}