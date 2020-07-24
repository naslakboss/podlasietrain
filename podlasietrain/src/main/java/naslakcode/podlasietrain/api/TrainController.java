package naslakcode.podlasietrain.api;


import naslakcode.podlasietrain.entities.DijkstraAlgorithm;
import naslakcode.podlasietrain.entities.Graph;
import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.repositories.TownRepository;
import naslakcode.podlasietrain.services.TownService;
import naslakcode.podlasietrain.services.TrainService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

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
    // fill db



    @GetMapping()
    public ResponseEntity<List<Train>> getAllTrains(){
        return ResponseEntity.ok(trainService.findALl());
    }

    @GetMapping("{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable String id){
        return ResponseEntity.ok(trainService.findById(id));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Train> addNewTrain(@RequestBody @Validated Train train){
        Train newTrain = trainService.save(train);
        return newTrain != null ? ResponseEntity.ok(newTrain) : ResponseEntity.badRequest().body(null);
    }
    @PostMapping("/patch/{id}")
    public ResponseEntity<Train> uploadTrain(@PathVariable String id, @RequestBody Train train){
        Train uploadedTrain = trainService.uploadById(id, train);
        return uploadedTrain != null ? ResponseEntity.ok(uploadedTrain) : ResponseEntity.badRequest().body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTrain(@PathVariable String id){
        trainService.deleteById(id);
        return ResponseEntity.ok("Train deleted successfully");
    }

    @GetMapping("/shortest_path")
    public ResponseEntity<LinkedList<Town>> showShortestPath(@RequestParam ("start") String start,
                                             @RequestParam ("destination") String destination){

        return ResponseEntity.ok(trainService.findShortestPath(start, destination));
    }





}


