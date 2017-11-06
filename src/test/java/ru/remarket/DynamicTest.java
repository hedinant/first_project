package ru.remarket;

import org.junit.Assert;
import org.junit.Test;
// Created by ENKOVALEV on 06.11.2017.
public class DynamicTest {
    @Test
    public void dynamicTest() {
        float point = 100;
        int pointUp;
        int pointDown;

        Dynamics dynamics = new Dynamics();
        Glass glass = new Glass();

        for (int i = 0; i < 100; i++) {
            point = dynamics.getPoint(point);
            pointUp=(int)(dynamics.getPointUp());
            pointDown=(int)(dynamics.getPointDown());
            //System.out.println(pointUp + " " + pointDown + " " + point);

            createOrder(glass, pointDown, 5, Direction.BUY, DirectionOption.NOT_Option);
            createOrder(glass, pointUp, 5, Direction.SELL, DirectionOption.NOT_Option);

            createOrder(glass, pointDown+10, 5, Direction.BUY, DirectionOption.BUY_Option);
            createOrder(glass, pointUp-10, 5, Direction.SELL, DirectionOption.SELL_Option);
            glass.matchOrders();

        }
        System.out.println("fetchQuantityOrders: "+glass.fetchQuantityOrders());
        System.out.println("fetchQuantityOption: "+glass.fetchQuantityOption());


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
