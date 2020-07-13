package naslakcode.podlasietrain.repositories;

import naslakcode.podlasietrain.entities.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends MongoRepository<Test, Integer> {
}
