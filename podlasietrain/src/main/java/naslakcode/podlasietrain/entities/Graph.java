package naslakcode.podlasietrain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Graph {

    @Id
    private String id;
    private final List<Town> towns;
    private final List<Train> trains;

    public Graph(String id, List<Town> towns, List<Train> trains) {
        this.id = id;
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
