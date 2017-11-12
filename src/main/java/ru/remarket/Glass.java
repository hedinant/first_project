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
    // Created by ENKOVALEV on 06.11.2017.
    public int fetchQuantityOrders() {
        int quantityOrders = 0;
        for (Order order : sellOrders)
            if (order.getDirectionOption() == DirectionOption.NOT_Option) quantityOrders++;
        for (Order order : buyOrders)
            if (order.getDirectionOption() == DirectionOption.NOT_Option) quantityOrders++;
        return quantityOrders;
    }
    // Created by ENKOVALEV on 06.11.2017.
    public int fetchQuantityOption() {
        int quantityOrders = 0;
        for (Order order : sellOrders)
            if (!(order.getDirectionOption() == DirectionOption.NOT_Option)) quantityOrders++;
        for (Order order : buyOrders)
            if (!(order.getDirectionOption() == DirectionOption.NOT_Option)) quantityOrders++;
        return quantityOrders;
    }

    public long fetchMinSellPrice() {
        long minSellPrice = Long.MAX_VALUE;
        for (Order order : sellOrders)
            if ((order.getDirectionOption() == DirectionOption.NOT_Option) && (order.getPrice() < minSellPrice))
                minSellPrice = order.getPrice();
        return minSellPrice;
    }

    public long fetchMaxBuyPrice() {
        long maxBuyPrice = 0;
        for (Order order : buyOrders)
            if ((order.getDirectionOption() == DirectionOption.NOT_Option) && (order.getPrice() > maxBuyPrice))
                maxBuyPrice = order.getPrice();
        return maxBuyPrice;
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

    // Created by ENKOVALEV on 05.11.2017.
    public long fetchMinOptionBuyPrice() {
        long minSellPrice = 0;
        for (Order order : buyOrders)
            if ((order.getDirectionOption() == DirectionOption.BUY_Option) && (order.getPrice() < minSellPrice))
                minSellPrice = order.getPrice();
        return minSellPrice;
    }

    public long fetchMaxOptionSellPrice() {
        long maxBuyPrice = Long.MAX_VALUE;
        for (Order order : sellOrders)
            if ((order.getDirectionOption() == DirectionOption.SELL_Option) && (order.getPrice() > maxBuyPrice))
                maxBuyPrice = order.getPrice();
        return maxBuyPrice;
    }

    // Created by ENKOVALEV on 05.11.2017.
    public void matchOption() {
        long maxBuyPrice = fetchMaxBuyPrice();
        long minSellPrice = fetchMinSellPrice();
        long minOptionBuyPrice = fetchMinOptionBuyPrice();
        long maxOptionSellPrice = fetchMaxOptionSellPrice();

        if ((minOptionBuyPrice < minSellPrice) & (maxOptionSellPrice < maxBuyPrice))
            return;
        if (maxOptionSellPrice < Long.MAX_VALUE) {
            List<Order> buyFills1 = fetchBuyFills(maxBuyPrice);
            List<Order> sellFills1 = fetchSellFills(maxOptionSellPrice);
            doFillMatches(buyFills1, sellFills1);
        }
        if (minOptionBuyPrice > 0) {
            List<Order> buyFills2 = fetchBuyFills(minOptionBuyPrice);
            List<Order> sellFills2 = fetchSellFills(minSellPrice);
            doFillMatches(buyFills2, sellFills2);
        }
    }


    // TODO implement
    public void matchOrders() {
        matchOption();
        long maxBuyPrice = fetchMaxBuyPrice();

        long minSellPrice = fetchMinSellPrice();

        if (minSellPrice > maxBuyPrice)
            return;

        long matchPrice = (minSellPrice + maxBuyPrice) / 2;

        List<Order> buyFills = fetchBuyFills(matchPrice);

        List<Order> sellFills = fetchSellFills(matchPrice);

        doFillMatches(buyFills, sellFills);
    }


}
