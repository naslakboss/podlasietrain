package naslakcode.podlasietrain.api;

import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.repositories.TownRepository;
import naslakcode.podlasietrain.services.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TownController {

    @Autowired
    TownService townService;

    @GetMapping("towns/all")
    public List<Town> showAllTowns(){
       return (List<Town>) townService.findAll();
    }

    @PostMapping("towns/add")
    public Town addTown(@RequestBody Town town){
       return townService.save(town);
    }

}
