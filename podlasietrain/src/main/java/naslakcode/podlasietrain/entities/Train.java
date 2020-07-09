package naslakcode.podlasietrain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Train {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainId;

    private String start;

    private String destination;

    public Train() {
    }

    public Train( String start, String destination) {
        this.start = destination;
        this.start = destination;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
