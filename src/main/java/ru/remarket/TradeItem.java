package ru.remarket;

/**
 * Created by HEDIN on 01.11.2017.
 */ ////////////////////////////////////////////////////////////
public class TradeItem {
    private float intrinsicPrice; //собственная цена
    private float intrinsicPriceUp;
    private float intrinsicPriceDown;
    private float price;
    private float quantity; // Количество
    //String name;

    public float calculateValue() { //Price*Quantity
        return price * quantity;
    }

    public float getIntrinsicPrice() {
        return intrinsicPrice;
    }

    public void setIntrinsicPrice(float intrinsicPrice) {
        this.intrinsicPrice = intrinsicPrice;
    }

    public float getIntrinsicPriceUp() {
        return intrinsicPriceUp;
    }

    public void setIntrinsicPriceUp(float intrinsicPriceUp) {
        this.intrinsicPriceUp = intrinsicPriceUp;
    }

    public float getIntrinsicPriceDown() {
        return intrinsicPriceDown;
    }

    public void setIntrinsicPriceDown(float intrinsicPriceDown) {
        this.intrinsicPriceDown = intrinsicPriceDown;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
