package naslakcode.podlasietrain.repositories;

import naslakcode.podlasietrain.entities.Train;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends MongoRepository<Train, String> {

}
