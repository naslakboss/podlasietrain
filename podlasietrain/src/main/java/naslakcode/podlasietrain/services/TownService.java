package naslakcode.podlasietrain.services;

import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.repositories.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TownService {

    TownRepository townRepository;

    public TownService(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    public List<Town> findAll(){
        return (List<Town>) townRepository.findAll();
    }

    public Town save(Town town){
       return townRepository.save(town);
    }

}
