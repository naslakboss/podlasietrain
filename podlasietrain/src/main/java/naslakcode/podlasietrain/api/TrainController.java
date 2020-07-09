package naslakcode.podlasietrain.api;

import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.services.TownService;
import naslakcode.podlasietrain.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrainController {

    @Autowired
    TrainService trainService;

    @GetMapping("/list")
    public List<Train> listOfTrains(){
       return trainService.findAll();
    }

    @PostMapping("/trains")
    public Train addTrain(@RequestBody  Train train){

        return trainService.save(train);
    }
}
