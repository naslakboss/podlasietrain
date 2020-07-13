package naslakcode.podlasietrain;

import naslakcode.podlasietrain.entities.Algorithm;
import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import naslakcode.podlasietrain.entities.Algorithm;
import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.entities.Train;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
//@EnableMongoRepositories(basePackageClasses =
//		{TownRepository.class, TrainRepository.class})
public class PodlasietrainApplication {

	@Autowired
	TrainRepository trainRepository;

	public static void main(String[] args) {
		SpringApplication.run(PodlasietrainApplication.class, args);

		Town krakow = new Town("Kraków");
		Town warszawa = new Town("Warszawa");
		Town gdansk = new Town("Gdańsk");
		Town lublin = new Town("Lubin");
		Town lodz = new Town("łódź");
		// Dodawanie nowych miast (nazwa)

		krakow.addNeighbour(new Train(5, krakow, warszawa));
		krakow.addNeighbour(new Train(6, krakow, lublin));
		krakow.addNeighbour(new Train(7, krakow, lodz));
//
//		lublin.addNeighbour(new Train(3, lublin, warszawa));
//		lublin.addNeighbour(new Train(15, lublin, gdansk));
//
//		lodz.addNeighbour(new Train(15, lodz, gdansk));
//
//		warszawa.addNeighbour(new Train(12, warszawa, gdansk));
//		// Dodawanie nowych połączeń : wartość, początek, koniec
//
//		Algorithm algorithm = new Algorithm();
//		algorithm.computePath(krakow);
//		// Tworzenie obiektu algorytmu i wykonanie
//
//		System.out.println(algorithm.getShortestPathTo(gdansk));
//		// Metoda zwraca sout'a z wartością
	}


}
