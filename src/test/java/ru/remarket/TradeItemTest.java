package ru.remarket;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by HEDIN on 01.11.2017.
 */
public class TradeItemTest {

    @Test
    public void calculateTest(){
        TradeItem item = new TradeItem();
        item.setPrice(1.5f);
        item.setQuantity(2);
        Assert.assertEquals(3, item.calculateValue(), 0.0001f);
    }
}
