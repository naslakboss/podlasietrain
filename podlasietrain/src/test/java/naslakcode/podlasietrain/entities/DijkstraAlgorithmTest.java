package naslakcode.podlasietrain.entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraAlgorithmTest {

    private List<Town> towns;
    private List<Train> trains;

    @Test
    public void testExecute(){
        towns = new ArrayList<Town>();
        trains = new ArrayList<Train>();
        for(int i = 0; i <11; i ++){
            Town location = new Town("Town" + i, "Town" + i);
            towns.add(location);
        }

        addTrain("Train 1", 0, 1, 85);
        addTrain("Train 2", 0, 2, 112);
        addTrain("Train 3", 0, 4, 84);
        addTrain("Train 4", 2, 7, 113);
        addTrain("Train 5", 2, 7, 250);
        addTrain("Train 6", 3, 8, 774);
        addTrain("Train 7", 5, 9, 189);
        addTrain("Train 8", 8, 9, 167);
        addTrain("Train 9", 7, 9, 500);
        addTrain("Train 10", 9, 10, 230);
        addTrain("Train 11", 1, 10, 230);

        Graph graph = new Graph("test", towns, trains);
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graph);
        algorithm.execute(towns.get(0));
        LinkedList<Town> path = algorithm.getPath(towns.get(10));

        assertNotNull(path);
        assertTrue(path.size()>0);
        for(Town town : towns){
            System.out.println(town);
        }

    }

    private void addTrain(String trainId, int sourceLoc, int destinationLoc,
                          int duration){
        Train train = new Train(trainId,towns.get(sourceLoc),
                        towns.get(destinationLoc), duration);
                trains.add(train);

    }
}