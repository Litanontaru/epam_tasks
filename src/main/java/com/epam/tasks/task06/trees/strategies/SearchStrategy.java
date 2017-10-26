package com.epam.tasks.task06.trees.strategies;

import com.epam.tasks.task06.trees.elements.Vertex;

import java.util.Queue;

/**
 * Created by Komarov Vasiliy on 26.10.2017.
 */
public interface SearchStrategy {
    Queue<Vertex> getVertexQueue(Vertex root);
}
