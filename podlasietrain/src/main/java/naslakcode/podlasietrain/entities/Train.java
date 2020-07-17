package naslakcode.podlasietrain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Train {
    @Id
    private  String id;
    private  Town source;
    private  Town destination;
    private  int weight;

    public Train(String id, Town source, Town destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSource(Town source) {
        this.source = source;
    }

    public void setDestination(Town destination) {
        this.destination = destination;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }
    public Town getDestination() {
        return destination;
    }

    public Town getSource() {
        return source;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }


}
