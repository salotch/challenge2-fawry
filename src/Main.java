import AdminTest.Admin;
import behavior.MailDelivery;
import behavior.NoDelivery;
import behavior.ShipDelivery;
import book.Book;
import inventory.Inventory;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        Admin admin = new Admin(inventory);

        // define Books
        Book paperBook = new Book("111", "Java Basics", 2015, 100.0, true, new ShipDelivery());
        Book ebook = new Book("222", "Learn Python", 2020, 50.0, true, new MailDelivery());
        Book showcaseBook = new Book("333", "Ancient Scripts", 2012, 0.0, false, new NoDelivery());
        Book paperBook2 = new Book("444", "Harry Potter", 2003, 100.0, true, new ShipDelivery());

        admin.addBook(paperBook, 5);
        admin.addBook(ebook, 10);// we can make it a very large number if we have just one book and just sell a
                                 // copy of it or handle this situation in other logic
        admin.addBook(showcaseBook, 1);
        admin.addBook(paperBook2, 5);
        // revmove outdated books
        admin.removeOutdatedBooks(20, 2025);

        // buy ebook
        admin.buyBook("222", 1, "reader@example.com", "123 Cairo St");

        // buy paper book
        admin.buyBook("111", 2, "", "456 Giza St");

        // try to buy a demo book
        try {
            admin.buyBook("333", 1, "demo@example.com", "No Address");
        } catch (RuntimeException e) {
            System.out.println("ERROR - " + e.getMessage());
        }

        // Test return paid amount
        admin.returnPaidAmount("20250708193045012L", "reader@example.com"); //
    }
}
