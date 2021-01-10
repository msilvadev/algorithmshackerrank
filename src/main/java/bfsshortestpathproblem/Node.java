package bfsshortestpathproblem;

import java.util.*;

/**
 * This class will represent the node of our graph from {@link MyGraph}
 * A node can be described with a name, a LinkedList in reference to the shortestPath,
 * a distance from the source, and an adjacency list named adjacentNodes
 *
 * @author msilvadev
 */
public class Node implements Comparable<Node>{

    private String name;

    /**
     * As for the shortestPath attribute, it is a list of nodes that describes
     * the shortest path calculated from the starting node.
     */
    private List<Node> shortestPath = new LinkedList<>();

    /**
     * By default, all node distances are initialized with Integer.MAX_VALUE
     * to simulate an infinite distance.
     */
    private Integer distance = Integer.MAX_VALUE;

    /**
     * The adjacentNodes attribute is used to associate immediate neighbors with edge length.
     * This is a simplified implementation of an adjacency list, which is more suitable for the
     * Dijkstra algorithm than the adjacency matrix.
     */
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public Node(String name) {
        this.name = name;
    }

    /**
     * The getLowestDistanceNode() method, returns the node with the lowest distance from the unsettled nodes set
     * @param unsettledNodes
     * @return
     */
    public static Node getLowestDistanceNode(Set< Node > unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    /**
     * The calculateMinimumDistance() method compares the actual distance with the newly calculated one while
     * following the newly explored path.
     * @param evaluationNode
     * @param edgeWeigh
     * @param sourceNode
     */
    public static void calculateMinimumDistance(Node evaluationNode,
                                                 Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    @Override
    public int compareTo(Node node) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.name, node.getName());
    }
}
