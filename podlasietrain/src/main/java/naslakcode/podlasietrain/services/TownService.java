package naslakcode.podlasietrain.services;

import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.repositories.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TownService {

    @Autowired
    TownRepository townRepository;

    public List<Town> findAll() {
        return townRepository.findAll();
    }

    public Iterable<Town> saveAll(Iterable<Town> townToAdd) {
       return townRepository.saveAll(townToAdd);
    }

    public Town findById(String id) {
        Optional<Town> getTown = townRepository.findById(id);
        if(getTown.isPresent()){
             return getTown.get();
        }
        return new Town("id");
    }

//
//    public Town findById() {
//    }
}
