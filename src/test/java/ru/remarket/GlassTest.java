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


        createOrder(glass, 10, 5, Direction.BUY, DirectionOption.NOT_Option);
        createOrder(glass, 15, 5, Direction.BUY, DirectionOption.NOT_Option);
        createOrder(glass, 5, 5, Direction.BUY, DirectionOption.BUY_Option);


        //createOrder(glass, 18, 5, Direction.BUY);
       // createOrder(glass, 3, 5, Direction.BUY);


        createOrder(glass, 15, 5, Direction.SELL, DirectionOption.NOT_Option);
        createOrder(glass, 20, 5, Direction.SELL, DirectionOption.NOT_Option);
        createOrder(glass, 18, 5, Direction.SELL, DirectionOption.NOT_Option);


        Assert.assertEquals(15, glass.fetchMaxBuyPrice());
        Assert.assertEquals(15, glass.fetchMinSellPrice());

        glass.matchOrders();



        Assert.assertEquals(10, glass.fetchMaxBuyPrice());
        Assert.assertEquals(20, glass.fetchMinSellPrice());



    }

    private void createOrder(Glass glass, int price, int quantity, Direction buy, DirectionOption directionOption) {
        Order order = new Order();
        order.setPrice(price);
        order.setQuantity(quantity);
        order.setDirection(buy);
        order.setDirectionOption(directionOption);
        glass.addOrder(order);
    }

}
