package naslakcode.podlasietrain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Town {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long townId;

    private String name;

    public Town() {
    }

    public Town( String name) {
        this.name = name;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
