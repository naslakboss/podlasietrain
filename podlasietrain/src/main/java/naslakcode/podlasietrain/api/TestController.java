package naslakcode.podlasietrain.api;

import naslakcode.podlasietrain.entities.Test;
import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestRepository tRepo;

//    @EventListener(ApplicationReadyEvent.class)
//    public void testDB(){
//        tRepo.save(new Test(1, "testik"));
//        tRepo.save(new Test(2, "najtynaj"));
//    }

    @GetMapping("/showall")
    public List<Test> showTest(){
        return tRepo.findAll();
    }
}
