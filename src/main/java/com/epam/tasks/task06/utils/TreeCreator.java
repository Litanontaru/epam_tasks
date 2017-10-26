package com.epam.tasks.task06.utils;

import com.epam.tasks.task06.trees.Tree;
import com.epam.tasks.task06.trees.elements.Branch;
import com.epam.tasks.task06.trees.elements.Leaf;
import com.epam.tasks.task06.trees.elements.Vertex;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Komarov Vasiliy on 24.10.2017.
 */
public class TreeCreator {
    private static final int MAX_VERTEX_VALUE = 100;
    private static Random random = new Random(System.currentTimeMillis());

    public static Tree createRandomTree(int maxLevelsCount, int maxVertexDegree){
        if (maxLevelsCount < 1 || maxVertexDegree < 1) {
            throw new IllegalArgumentException("maxLevelsCount and maxVertexDegree must be > 0");
        }
        Vertex root = createVertex(0, maxLevelsCount, maxVertexDegree);
        return new Tree(root);
    }

    private static Vertex createVertex(int currentLevel, int levelsCount, int maxVertexDegree){
        boolean createLeaf;
        int vertexValue = random.nextInt(MAX_VERTEX_VALUE + 1);

        if (currentLevel == levelsCount - 1) createLeaf = true;
        else createLeaf = random.nextBoolean();

        if (createLeaf){
            return new Leaf(vertexValue);
        }
        else {
            Branch branch = new Branch(vertexValue, new ArrayList<>());
            int vertexDegree = random.nextInt(maxVertexDegree) + 1;
            for (int i = 0; i < vertexDegree; i++) {
                branch.getDescendants()
                        .add(createVertex(currentLevel + 1, levelsCount, maxVertexDegree));
            }
            return branch;
        }
    }
}
