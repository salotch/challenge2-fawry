package behavior;

public class MailDelivery implements DeliveryBehavior {
    @Override
    public void deliver(String email, String address) {
        System.out.println("your order will be delivered too this email: " + email
                + "\nplease check your mail for the delivery status");
    }
}
