import java.util.*;
class Book {
    private final String isbn, title;
    private boolean issued;
    Book(String isbn, String title) { this.isbn = isbn; this.title = title; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public boolean isIssued() { return issued; }
    public void issue() { if (issued) throw new IllegalStateException("Already issued"); issued = true; }
    public void returnBook() { if (!issued) throw new IllegalStateException("Book was not issued"); issued = false; }
    public String toString() { return isbn + " | " + title + " | " + (issued ? "Issued" : "Available"); }
}
class Library {
    private final Map<String, Book> books = new HashMap<>();
    public void addBook(Book book) {
        if (books.putIfAbsent(book.getIsbn(), book) != null) throw new IllegalArgumentException("ISBN already exists");
    }
    public void issueBook(String isbn) { getBook(isbn).issue(); }
    public void returnBook(String isbn) { getBook(isbn).returnBook(); }
    private Book getBook(String isbn) {
        Book b = books.get(isbn);
        if (b == null) throw new NoSuchElementException("Book not found");
        return b;
    }
    public void showBooks() { books.values().stream().sorted(Comparator.comparing(Book::getTitle)).forEach(System.out::println); }
}
public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("ISBN01", "Effective Java"));
        library.addBook(new Book("ISBN02", "Clean Code"));
        library.issueBook("ISBN01");
        library.showBooks();
        library.returnBook("ISBN01");
        System.out.println("After return:");
        library.showBooks();
    }
}
