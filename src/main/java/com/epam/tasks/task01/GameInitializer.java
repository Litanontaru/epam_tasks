package com.epam.tasks.task01;

import java.util.*;

/**
 * Created by Komarov Vasiliy on 28.09.2017.
 */
public class GameInitializer {
    private Random random = new Random(System.currentTimeMillis());

    public Universe createGameWorld(){
        int countSystems = random.nextInt(10) + 5;
        List<PlanetarySystem> planetarySystems = new ArrayList<>();
        for (int i = 0; i < countSystems; i++) {
            planetarySystems.add(createPlanetarySystem());
        }
        int countHoles = random.nextInt(10) + 5;
        List<BlackHole> blackHoles = new ArrayList<>();
        for (int i = 0; i < countHoles; i++) {
            blackHoles.add(createBlackHole());
        }
        return new Universe(planetarySystems, blackHoles);
    }

    public SpaceShip createSpaceShip(String playerName){
        int x = getRandomCoordinate();
        int y = getRandomCoordinate();
        return new SpaceShip(playerName, x, y);
    }

    private PlanetarySystem createPlanetarySystem(){
        Star star = createStar();
        int countPlanets = random.nextInt(6) + 2;
        Map<Integer, HeavenlyBody> bodies = new HashMap<>();
        for (int i = 0; i < countPlanets; i++) {
            int orbit = getRandomOrbit();
            //TODO: add check for dublicates
            Planet planet = createPlanet();
            bodies.put(orbit, planet);
        }
        int countAsteroids = random.nextInt(2);
        for (int i = 0; i < countAsteroids; i++){
            int orbit = getRandomOrbit();
            //TODO: add check for dublicates
            Asteroid asteroid = createAsteroid();
            bodies.put(orbit, asteroid);
        }
        return new PlanetarySystem(star, bodies);
    }

    private int getRandomCoordinate(){
        return random.nextInt(Universe.SIZE);
    }

    private SpectralType getRandomSpectralType(){
        SpectralType[] types = SpectralType.values();
        int randomIndex = random.nextInt(types.length);
        return types[randomIndex];
    }

    private int getRandomRadius(){
        return random.nextInt(10) + 1990;
        //TODO: add dependence on type object
    }

    private int getRandomGravity(){
        return random.nextInt(10) + 2490;
        //TODO: add dependence on type object
    }

    private int getRandomOrbit(){
        return random.nextInt(100) + 5900;
        //TODO: add dependence on stars
    }

    private int getRandomDensity(){
        return random.nextInt(500) + 8500;
    }

    private boolean getAvailabilityWater(){
        return random.nextBoolean();
    }

    private Star createStar(){
        int x = getRandomCoordinate();
        int y = getRandomCoordinate();
        int radius = getRandomRadius();
        int gravity = getRandomGravity();
        SpectralType type = getRandomSpectralType();
        return new Star(x, y, radius, gravity, type);
    }

    private Planet createPlanet(){
        int x = getRandomCoordinate();
        int y = getRandomCoordinate();
        int radius = getRandomRadius();
        int gravity = getRandomGravity();
        boolean hasLiquidWater = getAvailabilityWater();
        return new Planet(x, y, radius, gravity, hasLiquidWater);
    }

    private Asteroid createAsteroid(){
        int x = getRandomCoordinate();
        int y = getRandomCoordinate();
        int radius = getRandomRadius();
        int gravity = getRandomGravity();
        int density  = getRandomDensity();
        return new Asteroid(x, y, radius, gravity, density);
    }

    private BlackHole createBlackHole(){
        int x = getRandomCoordinate();
        int y = getRandomCoordinate();
        int radius = getRandomRadius();
        int gravity = 10000;
        return new BlackHole(x, y, radius, gravity);
    }

}
