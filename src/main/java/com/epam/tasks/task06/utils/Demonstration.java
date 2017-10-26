package com.epam.tasks.task06.utils;

import com.epam.tasks.task06.Client;
import com.epam.tasks.task06.trees.BreadthFirstTree;
import com.epam.tasks.task06.trees.DepthFirstTree;
import com.epam.tasks.task06.trees.Tree;
import com.epam.tasks.task06.trees.elements.Vertex;
import com.epam.tasks.task06.trees.strategies.BreadthFirstSearch;
import com.epam.tasks.task06.trees.strategies.DepthFirstSearch;
import com.epam.tasks.task06.utils.TreeCreator;
import com.epam.tasks.task06.visitors.IncrementVisitor;
import com.epam.tasks.task06.visitors.PrintVisitor;
import com.epam.tasks.task06.visitors.Visitor;

/**
 * Created by Komarov Vasiliy on 24.10.2017.
 */
public class Demonstration {
    public static void start() {
        Tree tree = TreeCreator.createRandomTree(5,3);

        demonstrateDFS(tree);
        demonstrateBFS(tree);
        demonstrateVisitors(tree);
    }

    private static void demonstrateDFS(Tree tree){
        tree.setSearchStrategy(new DepthFirstSearch());

        System.out.println("--------------------------");
        System.out.println("--  Depth-first search  --");
        System.out.println("--------------------------");

        for (Vertex vertex : tree){
            vertex.print();
        }
    }

    private static void demonstrateBFS(Tree tree){
        tree.setSearchStrategy(new BreadthFirstSearch());

        System.out.println("--------------------------");
        System.out.println("-- Breadth-first search --");
        System.out.println("--------------------------");

        for (Vertex vertex : tree){
            vertex.print();
        }
    }

    private static void demonstrateVisitors(Iterable<Vertex> tree){
        Visitor printVisitor = new PrintVisitor();
        Visitor incrementVisitor = new IncrementVisitor();

        System.out.println("--------------------------");
        System.out.println("--    Print visitors    --");
        System.out.println("--------------------------");

        Client.actionOnElements(tree, printVisitor);

        System.out.println("--------------------------");
        System.out.println("--  Increment visitors  --");
        System.out.println("--------------------------");

        Client.actionOnElements(tree, incrementVisitor);
        Client.actionOnElements(tree, printVisitor);
    }
}
