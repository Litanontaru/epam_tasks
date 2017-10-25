package com.epam.tasks.task06.trees.elements;

import com.epam.tasks.task06.visitors.Visitor;

import java.util.List;

/**
 * Created by Komarov Vasiliy on 22.10.2017.
 */
public class Branch implements Vertex {
    private int value;
    private List<Vertex> descendants;

    public Branch(int value, List<Vertex> descendants) {
        this.value = value;
        this.descendants = descendants;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Vertex> getDescendants() {
        return descendants;
    }

    @Override
    public void print() {
        System.out.format("Branch, value %s%n", getValue());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
