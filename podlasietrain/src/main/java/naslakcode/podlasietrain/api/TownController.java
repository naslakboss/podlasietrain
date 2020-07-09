package naslakcode.podlasietrain.api;

import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.repositories.TownRepository;
import naslakcode.podlasietrain.services.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/towns")
public class TownController {

    @Autowired
    TownService townService;

    @GetMapping("/all")
    public List<Town> showAllTowns(){
       return (List<Town>) townService.findAll();
    }

    @PostMapping("/add")
    public Town addTown(@RequestBody Town town){
       return townService.save(town);
    }

}
