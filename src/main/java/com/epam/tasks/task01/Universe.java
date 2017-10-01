package com.epam.tasks.task01;

import java.util.List;

/**
 * Created by Komarov Vasiliy on 28.09.2017.
 */
public class Universe {
    protected static final int SIZE = 100_000_000;

    private List<PlanetarySystem> planetarySystems;
    private List<BlackHole> blackHoles;

    public Universe(List<PlanetarySystem> planetarySystems, List<BlackHole> blackHoles) {
        this.planetarySystems = planetarySystems;
        this.blackHoles = blackHoles;
    }
}