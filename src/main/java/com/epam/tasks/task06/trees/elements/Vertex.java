package com.epam.tasks.task06.trees.elements;

import com.epam.tasks.task06.visitors.Visitor;

/**
 * Created by Komarov Vasiliy on 22.10.2017.
 */
public interface Vertex extends Printable {
    void accept(Visitor visitor);
}
