package naslakcode.podlasietrain.services;


import naslakcode.podlasietrain.entities.DijkstraAlgorithm;
import naslakcode.podlasietrain.entities.Graph;
import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainService {

    @Autowired
    TrainRepository trainRepository;

    @Autowired
    TownService townService;

    public Train save(Train train){
        return trainRepository.save(train);
    }

    public List<Train> findALl(){
        return trainRepository.findAll();
    }

    public void deleteById(String id) {
        Train trainToDelete = findById(id);
        trainRepository.delete(trainToDelete);
    }

    public boolean isExist(Train train){
      return trainRepository.existsById(train.getId());
    }

    public Train findById(String id) {
        Optional<Train> train = trainRepository.findById(id);
        if(!train.isPresent()){
            throw new IllegalStateException("This train doesn't exist in database");
        }
        return train.get();
    }

    public Train uploadById(String id, Train train){
        Train uploadedTrain = findById(id);
        if(train.getId() != null) {
            uploadedTrain.setId(train.getId());
        }
        if(train.getSource() != null) {
            uploadedTrain.setSource(train.getSource());
        }
        if(train.getDestination() != null) {
            uploadedTrain.setDestination(train.getDestination());
        }
        if(train.getWeight() != 0) {
            uploadedTrain.setWeight(train.getWeight());
        }

        save(uploadedTrain);
        return uploadedTrain;
    }

    public LinkedList<Town> findShortestPath(String start, String destination){

        List<Town> townList = townService.findAll();
        List<Train> trainList = findALl();

        Graph graph = new Graph("graff", townList, trainList);
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graph);
        Town startTown = townService.findById(start);
        Town destinationTown = townService.findById(destination);
        algorithm.execute(startTown);
        LinkedList<Town> path = algorithm.getPath(destinationTown);

        int distance = algorithm.getShortestDistance(destinationTown);
        String sDistance = String.valueOf(distance);

        Town fakeTown = new Town("distance", sDistance);
        path.add(fakeTown);


        return path;
    }
}
