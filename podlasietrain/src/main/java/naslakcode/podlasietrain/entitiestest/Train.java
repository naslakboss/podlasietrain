package naslakcode.podlasietrain.entitiestest;

public class Train {
    private final String id;
    private final Town source;
    private final Town destination;
    private final int weight;

    public Train(String id, Town source, Town destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
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
