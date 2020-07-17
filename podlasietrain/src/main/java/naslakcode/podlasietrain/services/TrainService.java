package naslakcode.podlasietrain.services;


import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainService {

    @Autowired
    TrainRepository trainRepository;

    public Train save(Train train){
        return trainRepository.save(train);
    }

    public List<Train> findALl(){
        return trainRepository.findAll();
    }

    public Train findById(String id) {
        Optional<Train> train = trainRepository.findById(id);
        if(!train.isPresent()){
            System.out.println("This train doesn't exist in database");
        }
        return train.get();
    }

    public void deleteById(String id) {
        Train trainToDelete = findById(id);
        trainRepository.delete(trainToDelete);
    }
}
