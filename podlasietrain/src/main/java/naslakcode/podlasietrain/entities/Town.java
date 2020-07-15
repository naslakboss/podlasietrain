package naslakcode.podlasietrain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Town implements Comparable<Town> {

// Klasa głowna implementuje Comparable -> compareTo
    @Id
    private String name;
    private List<Train> trains;
    private boolean visited;
    private Town previousTown;
    private double minDistance = Double.MAX_VALUE;
//  Obiekt Miasta posiada nazwe, krawędzie, odwiedzone poprzednie

    public Town(String name) {
        this.name = name;
        this.trains = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addNeighbour(Train train) {
        this.trains.add(train);
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Town getPreviousTown() {
        return previousTown;
    }

    public void setPreviousTown(Town previousTown) {
        this.previousTown = previousTown;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

//

    @Override
    public String toString() {
        return "Town{" +
                "name='" + name + '\'' +
                ", trains=" + trains +
                ", visited=" + visited +
                ", previousTown=" + previousTown +
                ", minDistance=" + minDistance +
                '}';
    }

    @Override
    public int compareTo(Town otherTown) {
        return Double.compare(this.minDistance, otherTown.minDistance);
    }

}