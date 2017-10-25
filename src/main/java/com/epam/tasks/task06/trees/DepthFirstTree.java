package com.epam.tasks.task06.trees;

import com.epam.tasks.task06.trees.elements.Branch;
import com.epam.tasks.task06.trees.elements.Vertex;

import java.util.*;

/**
 * Created by Komarov Vasiliy on 24.10.2017.
 */
public class DepthFirstTree implements Iterable<Vertex> {
    private Tree tree;

    public DepthFirstTree(Tree tree){
        this.tree = tree;
    }

    @Override
    public Iterator<Vertex> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Vertex>{
        LinkedList<Vertex> vertexQueue;

        public Itr(){
            vertexQueue = new LinkedList<>();
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
                vertexQueue.addAll(0, descendants);
            }
            return currentVertex;
        }
    }
}
