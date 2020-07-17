package naslakcode.podlasietrain;

//import naslakcode.podlasietrain.entities.Algorithm;

import naslakcode.podlasietrain.entities.Graph;
import naslakcode.podlasietrain.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import naslakcode.podlasietrain.entities.Algorithm;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
//@EnableMongoRepositories(basePackageClasses =
//		{TownRepository.class, TrainRepository.class})
public class PodlasietrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(PodlasietrainApplication.class, args);





	}


}
