package naslakcode.podlasietrain.repositories;

import naslakcode.podlasietrain.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends CrudRepository<Town, Long> {

}
