package naslakcode.podlasietrain.api;

import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.repositories.TownRepository;
import naslakcode.podlasietrain.services.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/towns")
public class TownController {

    @Autowired
    TownRepository townRepository;

    @Autowired
    TownService townService;

    @EventListener(ApplicationReadyEvent.class)
    public void initDB(){
        Town krakow = new Town("Kraków");
        Town warszawa = new Town("Warszawa");
        Town gdansk = new Town("Gdańsk");
        Town lublin = new Town("Lubin");
        Town lodz = new Town("łódź");

        townRepository.save(krakow);
        townRepository.save(warszawa);
        townRepository.save(gdansk);
        townRepository.save(lublin);
        townRepository.save(lodz);
    }

    @GetMapping("/show-all")
    public List<Town> showAllTowns(){
        return townService.findAll();
    }

}
