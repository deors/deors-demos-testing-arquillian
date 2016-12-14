package deors.demos.testing.arquillian;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

/**
 * The shopping basket bean.
 *
 * @author jorge.hidalgo
 * @version 1.0
 */
@SessionScoped
public class Basket
    implements Serializable {

    /**
     * Serialization Id.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The list of items in the basket.
     */
    private List<String> items;

    /**
     * The order service.
     */
    @EJB
    private transient OrderRepository repo;

    /**
     * Default constructor.
     */
    public Basket() {
        super();
    }

    /**
     * Adds an item to the basket.
     *
     * @param item the item to be added
     */
    public void addItem(String item) {

        items.add(item);
    }

    /**
     * Returns the list of items in the basket.
     *
     * @return the list of items
     */
    public List<String> getItems() {

        return Collections.unmodifiableList(items);
    }

    /**
     * Returns the number of items in the basket.
     *
     * @return the number of items
     */
    public int getItemCount() {

        return items.size();
    }

    /**
     * Empties the basket.
     */
    public void empty() {

        items.clear();
    }

    /**
     * Places the order and cleans the basket.
     */
    public void placeOrder() {

        repo.addOrder(items);
        empty();
    }

    /**
     * Initializes the list of items in the basket.
     */
    @PostConstruct
    void initialize() {

        items = new ArrayList<String>();
    }
}
