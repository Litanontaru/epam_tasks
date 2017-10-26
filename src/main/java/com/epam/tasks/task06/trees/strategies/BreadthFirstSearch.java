package com.epam.tasks.task06.trees.strategies;

import com.epam.tasks.task06.trees.elements.Branch;
import com.epam.tasks.task06.trees.elements.Vertex;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Komarov Vasiliy on 26.10.2017.
 */
public class BreadthFirstSearch implements SearchStrategy {
    @Override
    public Queue<Vertex> getVertexQueue(Vertex root) {
        Queue<Vertex> vertexQueue = new ArrayDeque<>();
        vertexQueue.add(root);
        if (root instanceof Branch) {
            addDescendantsLevel(vertexQueue, ((Branch) root).getDescendants());
        }
        return vertexQueue;
    }

    private void addDescendantsLevel(Queue<Vertex> vertexQueue, List<Vertex> descendantsLevel) {
       List<Vertex> nextDescendantsLevel = new ArrayList<>();
        for (Vertex vertex : descendantsLevel) {
            vertexQueue.add(vertex);
            if (vertex instanceof Branch) {
                nextDescendantsLevel.addAll(((Branch) vertex).getDescendants());
            }
        }
        if (nextDescendantsLevel.size() > 0) {
            addDescendantsLevel(vertexQueue, nextDescendantsLevel);
        }
    }
}
