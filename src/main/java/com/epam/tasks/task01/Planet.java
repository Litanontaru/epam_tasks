package com.epam.tasks.task01;

/**
 * Created by Komarov Vasiliy on 27.09.2017.
 */
public class Planet extends HeavenlyBody{
    boolean hasLiquidWater;

    public Planet(int x, int y, int radius, int gravity, boolean hasLiquidWater) {
        super(x, y, radius, gravity);
        this.hasLiquidWater = hasLiquidWater;
    }
}