package naslakcode.podlasietrain.api;

import naslakcode.podlasietrain.entities.Algorithm;
import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.repositories.TownRepository;
import naslakcode.podlasietrain.repositories.TrainRepository;
import naslakcode.podlasietrain.services.TownService;
import naslakcode.podlasietrain.services.TrainService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.*;
import java.util.function.Consumer;

@RestController
@RequestMapping("/api")
public class TrainController {

    @Autowired
    TrainService trainService;

    @Autowired
    TownService townService;

    @Autowired
    TrainRepository trainRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init(){

        Town krakow = townService.findById("Kraków");
        Town katowice = townService.findById("Katowice");
        Town lublin = townService.findById("Lublin");
        Town wroclaw = townService.findById("Wrocław");
        Town lodz = townService.findById("Lódź");
        Town warszawa = townService.findById("Warszawa");

        Train krakat = new Train(2, krakow, katowice);
        Train kralub = new Train(4, krakow, lublin);
//        Train krawar = new Train(7, krakow, warszawa);
//        Train katwro = new Train(4, katowice, wroclaw);
//        Train wrolod = new Train(8, wroclaw, lodz);
//        Train lodzwar = new Train(3, lodz, warszawa);
//        Train lubwar = new Train(6, lublin, warszawa);

        krakow.addNeighbour(krakat);
        krakow.addNeighbour(kralub);
//        krakow.addNeighbour(krawar);
//        katowice.addNeighbour(katwro);
//        wroclaw.addNeighbour(wrolod);
//        lodz.addNeighbour(lodzwar);
//        lublin.addNeighbour(lubwar);


        trainRepository.save(krakat);



        Algorithm algorithm = new Algorithm();
        algorithm.computePath(krakow);
        System.out.println(algorithm.getShortestPathTo(warszawa));




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


