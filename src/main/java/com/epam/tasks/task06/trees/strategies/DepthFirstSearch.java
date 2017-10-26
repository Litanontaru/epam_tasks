package com.epam.tasks.task06.trees.strategies;

import com.epam.tasks.task06.trees.elements.Branch;
import com.epam.tasks.task06.trees.elements.Vertex;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Created by Komarov Vasiliy on 26.10.2017.
 */
public class DepthFirstSearch implements SearchStrategy {
    @Override
    public Queue<Vertex> getVertexQueue(Vertex root) {
        Queue<Vertex> vertexQueue = new ArrayDeque<>();
        addVertex(vertexQueue, root);
        return vertexQueue;
    }

    private void addVertex(Queue<Vertex> vertexQueue, Vertex vertex) {
        vertexQueue.add(vertex);
        if (vertex instanceof Branch) {
            List<Vertex> descendants = ((Branch) vertex).getDescendants();
            for (Vertex descendant : descendants) {
                addVertex(vertexQueue, descendant);
            }
        }
    }
}
