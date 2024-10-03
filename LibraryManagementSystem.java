import java.util.ArrayList;
import java.util.Scanner;

// Base Class for Users
abstract class User {
    String name;

    User(String name) {
        this.name = name;
    }

    abstract void viewBooks(Library library);
}

// Admin class inheriting from User
class Admin extends User {

    Admin(String name) {
        super(name);
    }

    @Override
    void viewBooks(Library library) {
        library.displayBooks();
    }

    // Add book to the library
    void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    // Issue a book to the user
    void issueBook(Library library, String bookName, User user) {
        if (library.issueBook(bookName, user)) {
            System.out.println("Book issued successfully to " + user.name);
        } else {
            System.out.println("Book is not available.");
        }
    }

    // View all issued books
    void viewIssuedBooks(Library library) {
        library.displayIssuedBooks();
    }
}

// Regular User class inheriting from User
class RegularUser extends User {

    RegularUser(String name) {
        super(name);
    }

    @Override
    void viewBooks(Library library) {
        library.displayBooks();
    }

    // Return a book to the library
    void returnBook(Library library, String bookName) {
        library.returnBook(bookName, this);
    }
}

// Book Class
class Book {
    String name;
    boolean isIssued;
    User issuedTo;

    Book(String name) {
        this.name = name;
        this.isIssued = false;
        this.issuedTo = null;
    }
}

// Library Class managing the books
class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Book> issuedBooks = new ArrayList<>();

    // Add book to library
    void addBook(Book book) {
        books.add(book);
    }

    // Issue book to user
    boolean issueBook(String bookName, User user) {
        for (Book book : books) {
            if (book.name.equalsIgnoreCase(bookName) && !book.isIssued) {
                book.isIssued = true;
                book.issuedTo = user;
                issuedBooks.add(book);
                return true;
            }
        }
        return false;
    }

    // Return book to the library
    void returnBook(String bookName, User user) {
        for (Book book : issuedBooks) {
            if (book.name.equalsIgnoreCase(bookName) && book.issuedTo == user) {
                book.isIssued = false;
                book.issuedTo = null;
                issuedBooks.remove(book);
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("No such issued book found.");
    }

    // Display available books
    void displayBooks() {
        System.out.println("Available books in the library:");
        for (Book book : books) {
            if (!book.isIssued) {
                System.out.println("- " + book.name);
            }
        }
    }

    // Display all issued books
    void displayIssuedBooks() {
        System.out.println("Issued books:");
        for (Book book : issuedBooks) {
            System.out.println("- " + book.name + " issued to " + book.issuedTo.name);
        }
    }
}

// Main class to run the program
public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library();
        Admin admin = new Admin("Admin");
        RegularUser user1 = new RegularUser("User1");
        RegularUser user2 = new RegularUser("User2");

        // Add some books to the library
        admin.addBook(library, new Book("Java Programming"));
        admin.addBook(library, new Book("Data Structures"));
        admin.addBook(library, new Book("Operating Systems"));

        // Admin issuing book to users
        admin.issueBook(library, "Java Programming", user1);

        // Users viewing available books
        user1.viewBooks(library);
        user2.viewBooks(library);

        // Admin viewing issued books
        admin.viewIssuedBooks(library);

        // User returning a book
        user1.returnBook(library, "Java Programming");

        // Viewing books again after return
        user1.viewBooks(library);
    }
}
