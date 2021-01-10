package bfsshortestpathproblem;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static bfsshortestpathproblem.Node.calculateMinimumDistance;
import static bfsshortestpathproblem.Node.getLowestDistanceNode;

/**
 * This class is a simple implementation which I will represent a graph as a set of nodes
 *
 * @author msilvadev
 */
public class MyGraph {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public static MyGraph calculateShortestPathFromSource(MyGraph graph, Node source) {
        source.setDistance(0); //Set distance to startNode to zero

        Set<Node> settledNodes = new HashSet<>(); //Settled nodes are the ones with a known minimum distance from the source.
        Set<Node> unsettledNodes = new HashSet<>(); //The unsettled nodes set gathers nodes that we can reach from the source

        unsettledNodes.add(source);

        /**
         * While the unsettled nodes set is not empty
         * Steps:
         * 1 - Choose an evaluation node from the unsettled nodes set, the evaluation
         *  node should be the one with the lowest distance from the source - {@link Node#getLowestDistanceNode(Set)}
         * 2 - Calculate new distances to direct neighbors by keeping the lowest distance at each evaluation
         *  {@link Node#calculateMinimumDistance(Node, Integer, Node)}
         * 3 - 
         */
        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);

            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    public Set<Node> getNodes() {
        return nodes;
    }
}
