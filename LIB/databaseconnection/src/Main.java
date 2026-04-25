import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. View Book by ID");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Genre: ");
                    String genre = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Copies: ");
                    int copies = sc.nextInt();

                    dao.addBook(new Book(title, author, genre, price, copies));
                    break;

                case 2:
                    dao.getAllBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    dao.getBookById(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("New Price: ");
                    double newPrice = sc.nextDouble();

                    System.out.print("New Copies: ");
                    int newCopies = sc.nextInt();

                    dao.updateBook(id, newTitle, newPrice, newCopies);
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    dao.deleteBook(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Book ID to issue: ");
                    dao.issueBook(sc.nextInt());
                    break;

                case 7:
                    System.out.print("Enter Book ID to return: ");
                    dao.returnBook(sc.nextInt());
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
