/**
 * The Purchasable interface represents an entity that can be purchased by a client.
 */
public interface Purchasable {

    /**
     * Method to handle the purchase of the implementor by a client.
     *
     * @param client The client making the purchase.
     */
    void purchase(Client client);
}
