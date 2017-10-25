package com.epam.tasks.task06;

import com.epam.tasks.task06.trees.elements.Vertex;
import com.epam.tasks.task06.visitors.Visitor;

/**
 * Created by Komarov Vasiliy on 24.10.2017.
 */
public class Client {
    public static void actionOnElements(Iterable<Vertex> tree, Visitor visitor){
        for (Vertex vertex : tree){
            vertex.accept(visitor);
        }
    }
}
