package ru.remarket;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by HEDIN on 01.11.2017.
 */
public class GlassTest {

    @Test
    public void tradingTest() {

        Glass glass = new Glass();


        createOrder(glass, 10, 5, Direction.BUY);
        createOrder(glass, 15, 5, Direction.BUY);
        //createOrder(glass, 18, 5, Direction.BUY);
       // createOrder(glass, 3, 5, Direction.BUY);


        createOrder(glass, 15, 5, Direction.SELL);
        createOrder(glass, 20, 5, Direction.SELL);
        //createOrder(glass, 15, 8, Direction.SELL);
       // createOrder(glass, 5, 8, Direction.SELL);
        //createOrder(glass, 6, 3, Direction.SELL);

        Assert.assertEquals(15, glass.fetchMaxBuyPrice());
        Assert.assertEquals(15, glass.fetchMinSellPrice());

        glass.matchOrders();

        Assert.assertEquals(10, glass.fetchMaxBuyPrice());
        Assert.assertEquals(20, glass.fetchMinSellPrice());



    }

    private void createOrder(Glass glass, int price, int quantity, Direction buy) {
        Order order = new Order();
        order.setPrice(price);
        order.setQuantity(quantity);
        order.setDirection(buy);
        glass.addOrder(order);
    }

}
