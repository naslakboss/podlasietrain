package naslakcode.podlasietrain.api;


import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.repositories.TownRepository;
import naslakcode.podlasietrain.services.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping()
    public ResponseEntity<List<Town>> getAllTowns(){
        return ResponseEntity.ok(townService.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Town> getTownById(@PathVariable String name){
        return ResponseEntity.ok(townService.findById(name));
    }

    @PostMapping("/add")
    public ResponseEntity<Town> createNewTown(@RequestBody @Validated Town town){
        Town createdTown = townService.save(town);
        return createdTown != null ? ResponseEntity.ok(createdTown) : ResponseEntity.badRequest().body(null);
    }

    @PostMapping("/patch/{name}")
    public ResponseEntity<Town> updateTown(@PathVariable String name, @RequestBody Town town){
        Town updatedTown = townService.uploadTown(town, name);
        return updatedTown != null ? ResponseEntity.ok(updatedTown) : ResponseEntity.badRequest().body(null);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity deleteTown(@PathVariable String name){
        townService.deleteById(name);
         return  ResponseEntity.ok("Town deleted successfully");
    }




}
