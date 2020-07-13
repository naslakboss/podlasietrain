package naslakcode.podlasietrain.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Algorithm {
    public void computePath(Town sourceTown) {
// Algorytym do obliczania najkrótszego dystansu
        sourceTown.setMinDistance(0);
        PriorityQueue<Town> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceTown);
// Tworzenie priorytetowej kolejki -> Najwieksza wartosc leci do przodu


        while (!priorityQueue.isEmpty()) {
            Town town = priorityQueue.poll();
            // jesli kolejka nie jest pusta -> zabiera głowe kolejki

            for (Train train : town.getTrains()) {
                Town v = train.getTargetTown();
//                Town u = train.getStartTown();
                double weight = train.getWeight();
                double minDistance = town.getMinDistance() + weight;

                if (minDistance < v.getMinDistance()) {
                    priorityQueue.remove(town);
                    v.setPreviousTown(town);
                    v.setMinDistance(minDistance);
                    priorityQueue.add(v);
                }
            }
        }
    }

    public List<Town> getShortestPathTo(Town targetVerte) {
        List<Town> path = new ArrayList<>();

        for (Town town = targetVerte; town != null; town = town.getPreviousTown()) {
            path.add(town);
        }

        Collections.reverse(path);
        return path;
    }
}