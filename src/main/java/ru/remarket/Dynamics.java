package ru.remarket;
// Created by ENKOVALEV on 06.11.2017.
public class Dynamics {

    private float startPoint;
    private float point = 0;
    private float pointUp;
    private float pointDown;

    public float getPoint(float startPoint) {
        point = (float) (startPoint + 25 * (0.5 - (Math.random())));
        return point;
    }

    public float getPointUp() {
        if (!(point == 0))
        {pointUp =(float) (point + 0.1*point* (Math.random()));
        return  pointUp;}
    return 0;
    }

    public float getPointDown() {
        if (!(point == 0))
        {pointDown= (float)(point - 0.1*point* (Math.random()));
            return  pointDown;}
    return 0;
    }


}
