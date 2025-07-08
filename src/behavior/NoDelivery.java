package behavior;

public class NoDelivery implements DeliveryBehavior {
    @Override
    public void deliver(String email, String address) {
        throw new UnsupportedOperationException("This book is not for sale or deliver");
    }
}
