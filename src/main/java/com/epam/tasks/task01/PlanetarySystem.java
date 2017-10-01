package com.epam.tasks.task01;

import java.util.Map;

/**
 * Created by Komarov Vasiliy on 27.09.2017.
 */
public class PlanetarySystem {
    private Star star;
    private Map<Integer, HeavenlyBody> bodies;     // orbit-body
    private int habitableZone;

    public PlanetarySystem(Star star, Map<Integer, HeavenlyBody> bodies){
        this.star = star;
        this.bodies = bodies;
        switch(star.getSpectralType()){
            case TYPE_O: habitableZone = star.getRadius() * 8;
                break;
            case TYPE_B: habitableZone = star.getRadius() * 6;
                break;
            case TYPE_A: habitableZone = star.getRadius() * 4;
                break;
            case TYPE_F: habitableZone = star.getRadius() * 4;
                break;
            case TYPE_G: habitableZone = star.getRadius() * 2;
                break;
            case TYPE_K: habitableZone = star.getRadius();
                break;
            case TYPE_M: habitableZone = star.getRadius() / 2;
                break;
        }
    }
}