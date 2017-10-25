package com.epam.tasks.task06.visitors;

import com.epam.tasks.task06.trees.elements.Branch;
import com.epam.tasks.task06.trees.elements.Leaf;

/**
 * Created by Komarov Vasiliy on 24.10.2017.
 */
public class IncrementVisitor implements Visitor {
    @Override
    public void visit(Branch branch) {
        int oldValue = branch.getValue();
        branch.setValue(++oldValue);
    }

    @Override
    public void visit(Leaf leaf) {
        int oldValue = leaf.getValue();
        leaf.setValue(++oldValue);
    }
}
