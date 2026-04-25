import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) {

        try {
            // Database details
            String url = "jdbc:mysql://localhost:3306/college_db";
            String username = "root";
            String password = "password";

            // Create connection
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully!");

            // Close connection
            con.close();

        } catch (Exception e) {
            System.out.println("Connection Failed!");
            System.out.println(e);
        }
    }
}