package ru.remarket;

import java.util.Date;

/**
 * Created by HEDIN on 01.11.2017.
 */
public class Future extends Instrument{
    private String source;
    private long strike;
    private Date date;
    private Direction direction;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getStrike() {
        return strike;
    }

    public void setStrike(long strike) {
        this.strike = strike;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
