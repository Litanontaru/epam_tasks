package com.epam.tasks.task06;

import com.epam.tasks.task06.trees.BreadthFirstTree;
import com.epam.tasks.task06.trees.DepthFirstTree;
import com.epam.tasks.task06.trees.Tree;
import com.epam.tasks.task06.trees.elements.Vertex;
import com.epam.tasks.task06.visitors.IncrementVisitor;
import com.epam.tasks.task06.visitors.PrintVisitor;
import com.epam.tasks.task06.visitors.Visitor;

/**
 * Created by Komarov Vasiliy on 24.10.2017.
 */
public class Demonstration {
    public static void start() {
        Tree tree = TreeCreator.createRandomTree(5,3);
        DepthFirstTree dfTree = new DepthFirstTree(tree);
        BreadthFirstTree bfTree = new BreadthFirstTree(tree);

        demonstrateDFS(dfTree);
        demonstrateBFS(bfTree);
        demonstrateVisitors(dfTree);
    }

    private static void demonstrateDFS(DepthFirstTree dfTree){
        System.out.println("--------------------------");
        System.out.println("--  Depth-first search  --");
        System.out.println("--------------------------");

        for (Vertex vertex : dfTree){
            vertex.print();
        }
    }

    private static void demonstrateBFS(BreadthFirstTree bfTree){
        System.out.println("--------------------------");
        System.out.println("-- Breadth-first search --");
        System.out.println("--------------------------");

        for (Vertex vertex : bfTree){
            vertex.print();
        }
    }

    private static void demonstrateVisitors(Iterable<Vertex> tree){
        Visitor printVisitor = new PrintVisitor();
        Visitor incrementVisitor = new IncrementVisitor();

        System.out.println("--------------------------");
        System.out.println("--    Print visitors     --");
        System.out.println("--------------------------");

        Client.actionOnElements(tree, printVisitor);

        System.out.println("--------------------------");
        System.out.println("--  Increment visitors   --");
        System.out.println("--------------------------");

        Client.actionOnElements(tree, incrementVisitor);
        Client.actionOnElements(tree, printVisitor);
    }
}
