package bfsshortestpathproblem;

import static bfsshortestpathproblem.MyGraph.calculateShortestPathFromSource;

/**
 * Link to problem on HackerRank: https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
 *
 * Consider an undirected graph consisting of nodes where each node is labeled from to and the edge
 * between any two nodes is always of length . We define node to be the starting position for a BFS.
 * Given a graph, determine the distances from the start node to each of its descendants and return
 * the list in node number order, ascending. If a node is disconnected, it's distance should be -1.
 *
 * For example n = 6 nodes in the graph with a starting node s = 1
 * The list of edges = [[1,2], [2,3], [3,4], [1,5]], and each has a weight of 6.
 *
 * @author msilvadev
 */
public class DijkstraShortestPathAlgorithm {

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        MyGraph graph = new MyGraph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        calculateShortestPathFromSource(graph, nodeA);

        // Sorted because nodes is a HashSet, sorted is smooth to see
        graph.getNodes().stream()
                        .sorted()
                        .forEach(node -> System.out.println(node.getName() + " " + node.getDistance()));
    }
}
