package com.epam.tasks.task01;

/**
 * Created by Komarov Vasiliy on 27.09.2017.
 */
public class Asteroid extends HeavenlyBody {
    private int density;
    private int damagePower;

    public Asteroid(int x, int y, int radius, int gravity, int density) {
        super(x, y, radius, gravity);
        this.density = density;
        this.damagePower = (int)(radius * density * 0.25);
    }

    public int getDensity() {
        return density;
    }

    public int getDamagePower() {
        return damagePower;
    }
}
