import java.sql.*;

public class BookDAO {

    // ADD BOOK
    public void addBook(Book b) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO books(title,author,genre,price,available_copies) VALUES(?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, b.title);
            ps.setString(2, b.author);
            ps.setString(3, b.genre);
            ps.setDouble(4, b.price);
            ps.setInt(5, b.available_copies);

            ps.executeUpdate();

            System.out.println("Book Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ ALL
    public void getAllBooks() {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM books";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("book_id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getString("genre") + " | " +
                        rs.getDouble("price") + " | " +
                        rs.getInt("available_copies")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ BY ID
    public void getBookById(int id) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM books WHERE book_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getInt("book_id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getString("genre") + " | " +
                        rs.getDouble("price") + " | " +
                        rs.getInt("available_copies")
                );
            } else {
                System.out.println("Book Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateBook(int id, String title, double price, int copies) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE books SET title=?, price=?, available_copies=? WHERE book_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, title);
            ps.setDouble(2, price);
            ps.setInt(3, copies);
            ps.setInt(4, id);

            ps.executeUpdate();

            System.out.println("Book Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteBook(int id) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "DELETE FROM books WHERE book_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Book Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ISSUE BOOK
    public void issueBook(int id) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE books SET available_copies = available_copies - 1 WHERE book_id=? AND available_copies > 0";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book Issued");
            else
                System.out.println("No copies available");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // RETURN BOOK
    public void returnBook(int id) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE books SET available_copies = available_copies + 1 WHERE book_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Book Returned");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}