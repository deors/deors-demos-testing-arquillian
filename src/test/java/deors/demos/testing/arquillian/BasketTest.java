package deors.demos.testing.arquillian;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import deors.demos.testing.arquillian.Basket;
import deors.demos.testing.arquillian.OrderRepository;
import deors.demos.testing.arquillian.SingletonOrderRepository;

@RunWith(Arquillian.class)
public class BasketTest {

    @Deployment
    public static JavaArchive createDeployment() {

        return ShrinkWrap
            .create(JavaArchive.class, "basket.jar")
            .addClasses(Basket.class, OrderRepository.class,
                SingletonOrderRepository.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    Basket basket;

    @EJB
    OrderRepository repo;

    @Test
    public void testIsDeployed() {

        Assert.assertNotNull(basket);
        Assert.assertNotNull(repo);
    }

    @Test
    @InSequence(1)
    public void testPlaceOrderShouldAddOrder() {

        basket.empty();
        basket.addItem("sunglasses");
        basket.addItem("suit");
        basket.placeOrder();
        Assert.assertEquals(1, repo.getOrderCount());
        Assert.assertEquals(0, basket.getItemCount());

        basket.empty();
        basket.addItem("raygun");
        basket.addItem("spaceship");
        basket.placeOrder();
        Assert.assertEquals(2, repo.getOrderCount());
        Assert.assertEquals(0, basket.getItemCount());
    }

    @Test
    @InSequence(2)
    public void testOrderShouldBepersistent() {

        Assert.assertEquals(2, repo.getOrderCount());
    }
}
