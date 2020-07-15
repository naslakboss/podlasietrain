package naslakcode.podlasietrain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Train {


    private int weight;
    private Town startTown;
    private Town targetTown;
    @Id
    private String connectionName;

    public Train(int weight, Town startTown, Town targetTown) {
        this.connectionName = startTown.getName() + "-" + targetTown.getName();
        this.weight = weight;
        this.startTown = startTown;
        this.targetTown = targetTown;
    }


    public String getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Town getStartTown() {
        return startTown;
    }

    public void setStartTown(Town startTown) {
        this.startTown = startTown;
    }

    public Town getTargetTown() {
        return targetTown;
    }

    public void setTargetTown(Town targetTown) {
        this.targetTown = targetTown;
    }

    @Override
    public String toString() {
        return "Train{" +
                "weight=" + weight +
                ", startTown=" + startTown +
                ", targetTown=" + targetTown +
                ", connectionName='" + connectionName + '\'' +
                '}';
    }
}

