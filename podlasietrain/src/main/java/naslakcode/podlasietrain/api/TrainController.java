package naslakcode.podlasietrain.api;

import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api")
public class TrainController {

    @Autowired
    TrainService trainService;

    @GetMapping("/all-trains")
    public List<Train> listOfTrains(){
       return trainService.findAll();
    }

    @PostMapping("/trains")
    public Train addTrain(@RequestBody  Train train){
        return trainService.save(train);
    }
}
