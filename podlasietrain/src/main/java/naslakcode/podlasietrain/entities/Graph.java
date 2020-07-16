package naslakcode.podlasietrain.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Graph {

    private List<Town> towns;
    private List<Train> trains;

    public Graph(List<Town> towns, List<Train> trains) {
        this.towns = towns;
        this.trains = trains;
    }

    public List<Town> getTowns() {
        return towns;
    }

    public void setTowns(List<Town> towns) {
        this.towns = towns;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }
}
