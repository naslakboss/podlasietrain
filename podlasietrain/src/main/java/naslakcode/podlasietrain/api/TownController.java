package naslakcode.podlasietrain.api;

import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.repositories.TownRepository;
import naslakcode.podlasietrain.services.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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
        Town katowice = new Town("Katowice");
        Town lublin = new Town("Lublin");
        Town wroclaw = new Town("Wrocław");
        Town lodz = new Town("Lódź");
        Town warszawa = new Town("Warszawa");



        Iterable<Town> townToAdd = Arrays.asList(krakow, katowice, lublin
                , wroclaw, lodz, warszawa);
        townService.saveAll(townToAdd);



    }

    @GetMapping("/show-all")
    public List<Town> showAllTowns(){
        return townService.findAll();
    }

}
