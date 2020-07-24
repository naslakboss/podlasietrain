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

    public Town save(Town town) {
        return townRepository.save(town);
    }

    public Town findById(String name) {
        Optional<Town> checkIfExist = townRepository.findById(name);
        if(!checkIfExist.isPresent()){
            throw new IllegalStateException("Town doesn't exist in database");
        }
        Town findedTown = checkIfExist.get();
        return findedTown;
    }

    public boolean isExist(String name){
        return townRepository.existsById(name);
    }

    public void deleteById(String name){
        townRepository.delete(findById(name));
    }
    public boolean isExistById(String townName){
        return townRepository.existsById(townName);
    }

    public Town uploadTown(Town town, String name){
        Town patchedTown = findById(name);
        if(town.getId() != null) {
            patchedTown.setId(town.getId());
        }
        if(town.getName() != null) {
            patchedTown.setName(town.getName());
        }
        townRepository.save(patchedTown);
        return patchedTown;
    }
}
