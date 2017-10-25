package com.epam.tasks.task06.trees;

import com.epam.tasks.task06.trees.elements.Vertex;

/**
 * Created by Komarov Vasiliy on 22.10.2017.
 */
public class Tree {
    private Vertex root;

    public Tree(Vertex root){
        this.root = root;
    }

    public Vertex getRoot() {
        return root;
    }
}
