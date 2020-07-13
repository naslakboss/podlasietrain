package naslakcode.podlasietrain.api;

import naslakcode.podlasietrain.entities.Algorithm;
import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.repositories.TownRepository;
import naslakcode.podlasietrain.services.TownService;
import naslakcode.podlasietrain.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.function.Consumer;

@RestController
@RequestMapping("/api")
public class TrainController {

    @Autowired
    TrainService trainService;

    @Autowired
    TownService townService;

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        Town zakopane = new Town("Zakopane");
        Town poronin = new Town("Poronin");
        Train train = new Train( 5, zakopane, poronin);

        Town krakow = new Town("Kraków");
        Town warszawa = new Town("Warszawa");

        Train train2 = new Train(10, krakow, warszawa);


        trainService.save(train);
        trainService.save(train2);
    }

    @GetMapping("/show-all")
    public List<Train> showAllTrains(){
       return trainService.findALl();
    }

    @PostMapping("/trains")
    public Train addTrain(Train train){
        return trainService.save(train);
    }

    @GetMapping("/shortest_route")
    public List<Town> findShortestRoute(@RequestParam ("start") Town startTown
        ,@RequestParam ("destination") Town targetTown){

            Algorithm algorithm = new Algorithm();
            algorithm.computePath(startTown);

            return  algorithm.getShortestPathTo(targetTown);
    }


    }


