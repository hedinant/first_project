package ru.remarket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HEDIN on 01.11.2017. TODO figure out correct term.
 */
public class Glass {
    private List<Order> buyOrders = new ArrayList<Order>();
    private List<Order> sellOrders = new ArrayList<Order>();

    public void addOrder(Order order) {
        if (order.getDirection() == Direction.BUY)
            buyOrders.add(order);
        else
            sellOrders.add(order);
    }

    // TODO implement
    public void matchOrders() {
        long maxBuyPrice = fetchMaxBuyPrice();

        long minSellPrice = fetchMinSellPrice();

        if (minSellPrice > maxBuyPrice)
            return;

        long matchPrice = (minSellPrice + maxBuyPrice) / 2;

        List<Order> buyFills = fetchBuyFills(matchPrice);

        List<Order> sellFills = fetchSellFills(matchPrice);

        doFillMatches(buyFills, sellFills);
    }

    public long fetchMinSellPrice() {
        long minSellPrice = Long.MAX_VALUE;
        for (Order order : sellOrders)
            if (order.getPrice() < minSellPrice)
                minSellPrice = order.getPrice();
        return minSellPrice;
    }

    public long fetchMaxBuyPrice() {
        long maxBuyPrice = 0;
        for (Order order : buyOrders)
            if (order.getPrice() > maxBuyPrice)
                maxBuyPrice = order.getPrice();
        return maxBuyPrice;
    }

    private void doFillMatches(List<Order> buyFills, List<Order> sellFills) {
        while (!buyFills.isEmpty() && !sellFills.isEmpty()) {
            Order buy = buyFills.remove(0);
            Order sell = sellFills.remove(0);
            if (buy.getQuantity() == sell.getQuantity()) {
                buyOrders.remove(buy);
                sellOrders.remove(sell);
                // TODO generate fill
            } else if (buy.getQuantity() > sell.getQuantity()) {
                buy.partualMatch(sell.getQuantity());
                sellOrders.remove(sell);
                buyFills.add(buy);
            } else {
                sell.partualMatch(buy.getQuantity());
                buyOrders.remove(sell);
                sellFills.add(buy);
            }
        }
    }

    private List<Order> fetchBuyFills(long matchPrice) {
        List<Order> buyFills = new ArrayList<Order>();
        for (Order order : buyOrders)
            if (order.getPrice() >= matchPrice)
                buyFills.add(order);
        return buyFills;
    }

    private List<Order> fetchSellFills(long matchPrice) {
        List<Order> sellFills = new ArrayList<Order>();
        for (Order order : sellOrders)
            if (order.getPrice() <= matchPrice)
                sellFills.add(order);
        return sellFills;
    }


}
