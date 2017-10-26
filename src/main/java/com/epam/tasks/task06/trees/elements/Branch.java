package com.epam.tasks.task06.trees.elements;

import com.epam.tasks.task06.visitors.Visitor;

import java.util.List;

/**
 * Created by Komarov Vasiliy on 22.10.2017.
 */
public class Branch extends Leaf {
    private List<Vertex> descendants;

    public Branch(int value, List<Vertex> descendants) {
        super(value);
        this.descendants = descendants;
    }

    public List<Vertex> getDescendants() {
        return descendants;
    }

    public Vertex transformToLeaf() {
        return new Leaf(getValue());
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
