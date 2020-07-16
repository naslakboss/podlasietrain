package naslakcode.podlasietrain.entitiestest;

import java.util.List;

public class Graph {
    private final List<Town> towns;
    private final List<Train> trains;

    public Graph(List<Town> towns, List<Train> trains) {
        this.towns = towns;
        this.trains = trains;
    }

    public List<Town> getTowns() {
        return towns;
    }

    public List<Train> getTrains() {
        return trains;
    }



}
