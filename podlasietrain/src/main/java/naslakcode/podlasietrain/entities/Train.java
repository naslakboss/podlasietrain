package naslakcode.podlasietrain.entities;

import naslakcode.podlasietrain.validators.trainvalidators.SameTowns;
import naslakcode.podlasietrain.validators.trainvalidators.UniqueTrain;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
@SameTowns
@UniqueTrain
public class Train {

    @Id
    private  String id;
    private  Town source;
    private  Town destination;
    @Range(min = 1, max = 40000)
    private  int weight;

    public Train() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return weight == train.weight &&
                Objects.equals(id, train.id) &&
                Objects.equals(source, train.source) &&
                Objects.equals(destination, train.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, source, destination, weight);
    }
}
