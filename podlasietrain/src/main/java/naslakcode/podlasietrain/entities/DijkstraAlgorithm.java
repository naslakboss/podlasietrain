package naslakcode.podlasietrain.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class DijkstraAlgorithm {

    private final List<Town> nodes;
    private final List<Train> trains;
    private Set<Town> settledNodes;
    private Set<Town> unSettledNodes;
    private Map<Town, Town> predecessors;
    private Map<Town, Integer> distance;

    public DijkstraAlgorithm(Graph graph) {
        // create a copy of the array so that we can operate on this array
        this.nodes = new ArrayList<Town>(graph.getTowns());
        this.trains = new ArrayList<Train>(graph.getTrains());
    }

    public void execute(Town source) {
        settledNodes = new HashSet<Town>();
        unSettledNodes = new HashSet<Town>();
        distance = new HashMap<Town, Integer>();
        predecessors = new HashMap<Town, Town>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            Town node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Town node) {
        List<Town> adjacentNodes = getNeighbors(node);
        for (Town target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }

    }

    private int getDistance(Town node, Town target) {
        for (Train train : trains) {
            if (train.getSource().equals(node)
                    && train.getDestination().equals(target)) {
                return train.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Town> getNeighbors(Town node) {
        List<Town> neighbors = new ArrayList<Town>();
        for (Train train : trains) {
            if (train.getSource().equals(node)
                    && !isSettled(train.getDestination())) {
                neighbors.add(train.getDestination());
            }
        }
        return neighbors;
    }

    private Town getMinimum(Set<Town> towns) {
        Town minimum = null;
        for (Town town : towns) {
            if (minimum == null) {
                minimum = town;
            } else {
                if (getShortestDistance(town) < getShortestDistance(minimum)) {
                    minimum = town;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Town town) {
        return settledNodes.contains(town);
    }

    public int getShortestDistance(Town destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public LinkedList<Town> getPath(Town target) {
        LinkedList<Town> path = new LinkedList<Town>();
        Town step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }

}