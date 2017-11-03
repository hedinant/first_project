package ru.remarket;

import java.util.Date;

public class Option {
    private String instrumentName;
    private Direction direction;
    private long price;
    private long quantity;
    private Date date;
    private boolean dateCorrect = true;

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void partualMatch(long quantity) {
        this.quantity -= quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDateCorrect(boolean dateCorrect) {
        this.dateCorrect = dateCorrect;
    }

    public boolean getDateCorrect() {
        return dateCorrect;
    }

    public long getPtoQ() {
        if (dateCorrect)
            return price * quantity;
    return 0;
    }


}
