package deors.demos.testing.arquillian;

import java.util.List;
import javax.ejb.Local;

/**
 * The order service interface.
 *
 * @author deors
 * @version 1.0
 */
@Local
public interface OrderRepository {

    /**
     * Places an order.
     *
     * @param order the order to be placed
     */
    void addOrder(List<String> order);

    /**
     * Returns the list of orders already placed.
     *
     * @return the list of orders
     */
    List<List<String>> getOrders();

    /**
     * Returns the number of orders already placed.
     *
     * @return the number of orders
     */
    int getOrderCount();
}
