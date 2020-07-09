package naslakcode.podlasietrain.services;

import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {


    TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public Train save(Train train){
        return trainRepository.save(train);
    }

    public List<Train> findAll() {
      return (List<Train>) trainRepository.findAll();
    }


    public String findByUsername(String start) {
        return trainRepository.findByUsername(start);
    }
}
