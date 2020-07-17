package naslakcode.podlasietrain.api;


import naslakcode.podlasietrain.entities.DijkstraAlgorithm;
import naslakcode.podlasietrain.entities.Graph;
import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.repositories.TownRepository;
import naslakcode.podlasietrain.services.TownService;
import naslakcode.podlasietrain.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    TrainService trainService;

    @Autowired
    TownRepository townRepository;

    @Autowired
    TownService townService;

//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDB(){
//
//        Town krakow = new Town("KRA", "Kraków");
//        Town warszawa = new Town("WAR", "Warszawa");
//        Town gdansk = new Town("GDA", "Gdańsk");
//        Town zakopane = new Town("ZAK", "Zakopane");
//        Town bydgoszcz = new Town("BYD", "Bydgoszcz");
//        Town poznan = new Town("POZ", "Poznań");
//
//
//
//        Train krawar = new Train("krawar", krakow, warszawa, 5);
//        Train wargda = new Train("wardga", warszawa, gdansk, 8);
//        Train zakkra = new Train("zakkra", zakopane, krakow, 2);
//        Train zakpoz = new Train("zakpoz", zakopane, poznan, 13);
//        Train pozbyd = new Train("pozbyd", poznan, bydgoszcz, 4);
//        Train pozgda = new Train("pozgda", poznan, gdansk, 2);
//        Train test = new Train("test", zakopane, gdansk, 1);
//
//
//        trainService.save(krawar);
//        trainService.save(wargda);
//        trainService.save(zakkra);
//        trainService.save(zakpoz);
//        trainService.save(pozbyd);
//        trainService.save(pozgda);
//        trainService.save(test);
//
//    }
    // Auto db

    @GetMapping("/shortest_path")
    public LinkedList<Town> showShortestPath(@RequestParam ("start") String start,
             @RequestParam ("destination") String destination){

        List<Town> townList = townService.findAll();
        List<Train> trainList = trainService.findALl();

        Graph graph = new Graph("graff", townList, trainList);
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graph);
        Town startTown = townService.findById(start);
        Town destinationTown = townService.findById(destination);
        algorithm.execute(startTown);
        LinkedList<Town> path = algorithm.getPath(destinationTown);

        System.out.println(algorithm.getShortestDistance(destinationTown));



        for(Town town : path){
            System.out.println(town);
        }
        return path;

    }

    @GetMapping("/show-all")
    public List<Train> showAllTrains(){
        return trainService.findALl();
    }

    @PostMapping("/add")
    public Train addTrain(@RequestBody Train train){

        String sourceTownName = train.getSource().getName();
        String destinationTownName = train.getDestination().getName();

        if(!townRepository.findById(sourceTownName).isPresent()){
            System.out.println("Source town is not valid");
        }
        if(!townRepository.findById(destinationTownName).isPresent()){
            System.out.println("Destination town is not valid");
        }

         return  trainService.save(train);
    }

    @PatchMapping("/patch")
    public Train uploadTrain(@RequestParam ("id") String id, @RequestBody Train train){
        Train uploadedTrain = trainService.findById(id);
        if(train.getId() != null) {
            uploadedTrain.setId(train.getId());
        }
        if(train.getSource() != null) {
            uploadedTrain.setSource(train.getSource());
        }
        if(train.getDestination() != null) {
            uploadedTrain.setDestination(train.getDestination());
        }
        if(train.getWeight() != 0) {
            uploadedTrain.setWeight(train.getWeight());
        }
        trainService.save(uploadedTrain);
        return uploadedTrain;
    }

    @DeleteMapping("/delete")
    public void deleteTrain(@RequestParam ("id") String id){
        trainService.deleteById(id);
    }





}


