package naslakcode.podlasietrain.api;


import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.repositories.TownRepository;
import naslakcode.podlasietrain.services.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/towns")
public class TownController {

    @Autowired
    TownService townService;

//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDB(){
//        Town krakow = new Town("KRA", "Kraków");
//        Town warszawa = new Town("WAR", "Warszawa");
//        Town gdansk = new Town("GDA", "Gdańsk");
//        Town zakopane = new Town("ZAK", "Zakopane");
//        Town bydgoszcz = new Town("BYD", "Bydgoszcz");
//        Town poznan = new Town("POZ", "Poznań");
//
//
//        townService.save(krakow);
//        townService.save(warszawa);
//        townService.save(gdansk);
//        townService.save(zakopane);
//        townService.save(bydgoszcz);
//        townService.save(poznan);
//
//    }
    // Fill database fast

    @GetMapping("/show-all")
    public List<Town> showAllTowns(){
        return townService.findAll();
    }

    @PostMapping("add")
    public Town addTown(@RequestBody @Validated  Town town){
       return townService.save(town);
    }

    @PatchMapping("/patch")
    public Town uploadTown(@RequestParam ("name") String name, @RequestBody Town town){
        Town patchedTown = townService.findById(name);
        if(town.getId() != null) {
            patchedTown.setId(town.getId());
        }
        if(town.getName() != null) {
            patchedTown.setName(town.getName());
        }
        townService.save(patchedTown);
        return patchedTown;
    }

    @DeleteMapping("delete")
    public void deleteTown(@RequestParam ("name") String name){
        Town townToDelete = townService.findById(name);
        townService.deleteById(name);
    }




}
