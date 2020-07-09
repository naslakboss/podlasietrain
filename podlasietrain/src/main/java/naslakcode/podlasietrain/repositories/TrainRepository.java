package naslakcode.podlasietrain.repositories;

import naslakcode.podlasietrain.entities.Train;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends CrudRepository<Train, Long> {

    String findByStart(String start);

    String findByDestination(String destination);

}
