package com.epam.tasks.task01;

/**
 * Created by Komarov Vasiliy on 28.09.2017.
 */
public abstract class HeavenlyBody {
    private int x;
    private int y;
    private int radius;
    private int gravity;

    public HeavenlyBody(int x, int y, int radius, int gravity){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.gravity = gravity;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public int getGravity() {
        return gravity;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
