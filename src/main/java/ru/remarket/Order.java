package ru.remarket;

/**
 * Created by HEDIN on 01.11.2017.
 */
public class Order {
    private String instrumentName;
    private Direction direction;
    private long price;
    private long quantity;
    private DirectionOption directionOption;


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

    public void partualMatch(long quantity){
        this.quantity -= quantity;
    }

    public DirectionOption getDirectionOption(){return directionOption;}

    public void setDirectionOption(DirectionOption directionOption) {this.directionOption = directionOption;}
}
