package com.epam.tasks.task06.visitors;

import com.epam.tasks.task06.trees.elements.Branch;
import com.epam.tasks.task06.trees.elements.Leaf;

/**
 * Created by Komarov Vasiliy on 24.10.2017.
 */
public interface Visitor {
    void visit(Branch branch);
    void visit(Leaf leaf);
}
