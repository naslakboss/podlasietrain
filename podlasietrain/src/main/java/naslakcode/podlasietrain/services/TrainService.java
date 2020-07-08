package naslakcode.podlasietrain.services;

import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    TrainRepository trainRepository;

    public Train save(Train train){
        trainRepository.save(train);
    }

    public List<Train> findAll() {
        trainRepository.findAll();
    }
}
