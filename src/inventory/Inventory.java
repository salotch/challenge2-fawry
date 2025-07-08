package inventory;

import java.util.HashMap;
import java.util.Map;

import book.Book;

public class Inventory {
    private Map<String, Book> books = new HashMap<>();// contains all the books
    private Map<String, Integer> stock = new HashMap<>(); // qantity of each book

    public void addBook(Book book, int quantity) {
        books.put(book.getISBN(), book);
        stock.put(book.getISBN(), stock.getOrDefault(book.getISBN(), 0) + quantity);
        System.out.println("Book is added - " + book.getTitle());
    }

    public void removeOutdatedBooks(int years, int currentYear) {
        books.entrySet().removeIf(entry -> {
            Book book = entry.getValue();
            if (currentYear - book.getYear() > years) {
                System.out.println("Removed outdated book - " + book.getTitle());
                stock.remove(entry.getKey());
                return true;
            }
            return false;
        });
    }

    public void removeBook(String ISBN) {
        if (books.get(ISBN) != null) {
            Book temp = books.get(ISBN);
            books.remove(ISBN);
            stock.remove(ISBN);
            System.out.println("Book is removed - " + temp.getTitle());
            return;
        }
        throw new RuntimeException("Book not found.");
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        if (!books.containsKey(isbn)) {
            throw new RuntimeException("Book not found.");
        }

        Book book = books.get(isbn);
        int available = stock.getOrDefault(isbn, 0);

        if (!book.isForSale()) {
            throw new RuntimeException("This book is not for sale.");
        }

        if (available < quantity) {
            throw new RuntimeException("Not enough stock.");
        }

        stock.put(isbn, available - quantity);
        book.deliver(email, address);
        double total = book.getPrice() * quantity;
        System.out.println("Purchase completed. Paid: $" + total);
        return total;
    }
}
