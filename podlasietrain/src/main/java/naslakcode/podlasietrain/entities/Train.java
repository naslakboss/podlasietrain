package naslakcode.podlasietrain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Train {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainId;

    private Town placeOfDeparture;

    private Town placeOfArrival;

    public Train() {
    }

    public Train(Long trainId, Town placeOfDeparture, Town placeOfArrival) {
        this.trainId = trainId;
        this.placeOfDeparture = placeOfDeparture;
        this.placeOfArrival = placeOfArrival;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public Town getPlaceOfDeparture() {
        return placeOfDeparture;
    }

    public void setPlaceOfDeparture(Town placeOfDeparture) {
        this.placeOfDeparture = placeOfDeparture;
    }

    public Town getPlaceOfArrival() {
        return placeOfArrival;
    }

    public void setPlaceOfArrival(Town placeOfArrival) {
        this.placeOfArrival = placeOfArrival;
    }
}
