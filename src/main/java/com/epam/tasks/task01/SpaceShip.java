package com.epam.tasks.task01;

/**
 * Created by Komarov Vasiliy on 27.09.2017.
 */
public class SpaceShip {
    private String captainsName;
    private int x;
    private int y;
    private int traction;
    private int speed;
    private int fuel;
    protected final int fuelConsumption = 10;

    public SpaceShip(String captainsName, int x, int y) {
        this.captainsName = captainsName;
        this.x = x;
        this.y = y;
        this.traction = 4000;
        this.speed = 20;
        this.fuel = 100;
    }

    public String getCaptainsName() {
        return captainsName;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTraction() {
        return traction;
    }

    public int getSpeed() {
        return speed;
    }

    public int getFuel() {
        return fuel;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int calcDistanceToTarget(HeavenlyBody target){
        return (int)(Math.sqrt(Math.pow((target.getX() - getX()), 2)
                + Math.pow((target.getY() - getY()), 2)));
    }

    public void move(){
        //TODO: add motion logic
    }

    public void landOn(){
        //TODO: add landing logic
    }

    public void spaceDocking(SpaceShip target){
        //TODO: add docking logic
    }

    public void repair(){
        //TODO: add repair logic
    }

    public void refuel(){
        //TODO: add refuel logic
    }
}
