package deors.demos.testing.arquillian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 * The order service implementation.
 *
 * @author deors
 * @version 1.0
 */
@Singleton
@Lock(LockType.READ)
public class SingletonOrderRepository
    implements OrderRepository {

    /**
     * The list of orders already placed.
     */
    private List<List<String>> orders;

    /**
     * Default constructor.
     */
    public SingletonOrderRepository() {
        super();
    }

    /**
     * Places an order.
     *
     * @param order the order to be placed
     */
    @Override
    @Lock(LockType.WRITE)
    public void addOrder(List<String> order) {

        orders.add(order);
    }

    /**
     * Returns the list of orders already placed.
     *
     * @return the list of orders
     */
    @Override
    public List<List<String>> getOrders() {

        return Collections.unmodifiableList(orders);
    }

    /**
     * Returns the number of orders already placed.
     *
     * @return the number of orders
     */
    @Override
    public int getOrderCount() {

        return orders.size();
    }

    /**
     * Initializes the list of orders already placed.
     */
    @PostConstruct
    void initialize() {

        orders = new ArrayList<List<String>>();
    }
}
