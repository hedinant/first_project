package ru.remarket;

import org.junit.Assert;
import org.junit.Test;

public class OptionTest {

    @Test
    public void optionTest() {

        Assert.assertEquals(70, getPtoQ(7, 10, Direction.BUY, true));
    }


    public long getPtoQ(int price, int quantity, Direction buy, boolean dateOk) {
        Option option = new Option();
        option.setPrice(price);
        option.setQuantity(quantity);
        option.setDirection(buy);
        option.setDateCorrect(dateOk);
        return option.getPtoQ();


    }


}
