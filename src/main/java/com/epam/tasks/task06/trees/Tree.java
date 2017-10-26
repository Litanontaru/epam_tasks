package com.epam.tasks.task06.trees;

import com.epam.tasks.task06.trees.elements.Vertex;
import com.epam.tasks.task06.trees.strategies.SearchStrategy;

import java.util.Iterator;
import java.util.Queue;

/**
 * Created by Komarov Vasiliy on 22.10.2017.
 */
public class Tree implements Iterable<Vertex> {
    private Vertex root;
    private SearchStrategy searchStrategy;

    public Tree(Vertex root, SearchStrategy searchStrategy){
        this.root = root;
        this.searchStrategy = searchStrategy;
    }

    public Vertex getRoot() {
        return root;
    }

    public void setRoot(Vertex root) {
        this.root = root;
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    @Override
    public Iterator<Vertex> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Vertex>{
        Queue<Vertex> vertexQueue;

        public Itr(){
            vertexQueue = searchStrategy.getVertexQueue(root);
        }

        @Override
        public boolean hasNext() {
            return vertexQueue.size() > 0;
        }

        @Override
        public Vertex next() {
            return vertexQueue.poll();
        }
    }
}
