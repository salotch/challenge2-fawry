package AdminTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import book.Book;
import inventory.Inventory;

public class Admin {
    private Inventory inventory;
    private Map<String, Double> orders = new HashMap<>();// contains all the orders details <order number, order amount

    public Admin(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addBook(Book book, int quantity) {
        inventory.addBook(book, quantity);
    }

    public void removeOutdatedBooks(int years, int currentYear) {
        inventory.removeOutdatedBooks(years, currentYear);
    }

    public double buyBook(String isbn, int quantity, String email, String address) {

        double paid = inventory.buyBook(isbn, quantity, email, address);
        String orderNum = GenerateOrderNum();
        System.out.println("your order number is: " + orderNum);
        orders.put(orderNum, paid);
        return paid;

    }

    public void removeBook(String ISBN) {
        inventory.removeBook(ISBN);
    }

    // ..................... its a temp fuction we can change the logic latter
    public void returnPaidAmount(String orderNum, String email) {
        if (orders.get(orderNum) != null)
            System.out.println(
                    "your paid amount is equal to: " + orders.get(orderNum) + " and is returned just check your mail");
        else
            throw new RuntimeException("your orderNum not found.");

    }

    private String GenerateOrderNum() {
        // a temp function to generate order number it's logic maybe changed after that
        int MAX_SUFFIX = 999;
        AtomicInteger counter = new AtomicInteger(0);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        int suffix = counter.getAndIncrement();

        if (suffix > MAX_SUFFIX) {
            counter.set(0);
            suffix = 0;
        }

        return timestamp + String.format("%03d", suffix); // return as String
    }
}
