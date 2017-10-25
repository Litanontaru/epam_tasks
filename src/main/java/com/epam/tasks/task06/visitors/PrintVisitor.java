package com.epam.tasks.task06.visitors;

import com.epam.tasks.task06.trees.elements.Branch;
import com.epam.tasks.task06.trees.elements.Leaf;

/**
 * Created by Komarov Vasiliy on 24.10.2017.
 */
public class PrintVisitor implements Visitor {
    @Override
    public void visit(Branch branch) {
        System.out.format("I'm found branch, value: %s%n", branch.getValue());
    }

    @Override
    public void visit(Leaf leaf) {
        System.out.format("I'm found leaf, value: %s%n", leaf.getValue());
    }
}
