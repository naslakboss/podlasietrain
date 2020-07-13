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

//
//    public Town findById() {
//    }
}
