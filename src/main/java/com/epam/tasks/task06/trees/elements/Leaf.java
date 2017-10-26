package com.epam.tasks.task06.trees.elements;

import com.epam.tasks.task06.visitors.Visitor;

import java.util.List;

/**
 * Created by Komarov Vasiliy on 22.10.2017.
 */
public class Leaf implements Vertex {
    private int value;

    public Leaf(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Vertex transformToBranch(List<Vertex> descendants) {
        return new Branch(getValue(), descendants);
    }

    @Override
    public void print() {
        System.out.format("Leaf, value %s%n", getValue());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
