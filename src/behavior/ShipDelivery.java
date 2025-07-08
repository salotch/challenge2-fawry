package behavior;

public class ShipDelivery implements DeliveryBehavior {

    @Override
    public void deliver(String email, String address) {
        System.out.println("your order will be delivered too this address: " + address
                + "\nplease check your mail for the delivery status");
    }

}
