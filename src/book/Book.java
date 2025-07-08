package book;

import behavior.DeliveryBehavior;

public class Book {
    private String ISBN;
    private String title;
    private int year;
    private double price;
    private boolean isForSale;
    private DeliveryBehavior deliveryBehavior;

    public Book(String iSBN, String title, int year, double price, boolean isForSale,
            DeliveryBehavior deliveryBehavior) {
        ISBN = iSBN;
        this.title = title;
        this.year = year;
        this.price = price;
        this.isForSale = isForSale;
        this.deliveryBehavior = deliveryBehavior;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public boolean isForSale() {
        return isForSale;
    }

    public void deliver(String email, String address) {
        deliveryBehavior.deliver(email, address);
    }

}
