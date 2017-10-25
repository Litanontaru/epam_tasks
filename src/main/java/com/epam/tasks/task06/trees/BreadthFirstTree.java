package com.epam.tasks.task06.trees;

import com.epam.tasks.task06.trees.elements.Branch;
import com.epam.tasks.task06.trees.elements.Vertex;

import java.util.*;

/**
 * Created by Komarov Vasiliy on 24.10.2017.
 */
public class BreadthFirstTree implements Iterable<Vertex> {
    private Tree tree;

    public BreadthFirstTree(Tree tree){
        this.tree = tree;
    }

    @Override
    public Iterator<Vertex> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Vertex>{
        Queue<Vertex> vertexQueue;

        public Itr(){
            vertexQueue = new ArrayDeque<>();
            vertexQueue.add(tree.getRoot());
        }

        @Override
        public boolean hasNext() {
            return vertexQueue.size() > 0;
        }

        @Override
        public Vertex next() {
            Vertex currentVertex = vertexQueue.poll();
            if (currentVertex instanceof Branch){
                List<Vertex> descendants = ((Branch) currentVertex).getDescendants();
                vertexQueue.addAll(descendants);
            }
            return currentVertex;
        }
    }
}
