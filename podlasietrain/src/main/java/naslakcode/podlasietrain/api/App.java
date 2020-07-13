package naslakcode.podlasietrain.api;


import naslakcode.podlasietrain.entities.Algorithm;
import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.entities.Train;

public class App {
    public static void main(String[] args) {
        Town krakow = new Town("Kraków");
        Town warszawa = new Town("Warszawa");
        Town gdansk = new Town("Gdańsk");
        Town lublin = new Town("Lubin");
        Town lodz = new Town("łódź");
        // Dodawanie nowych miast (nazwa)

        krakow.addNeighbour(new Train(5, krakow, warszawa));
        krakow.addNeighbour(new Train(6, krakow, lublin));
        krakow.addNeighbour(new Train(7, krakow, lodz));

        lublin.addNeighbour(new Train(3, lublin, warszawa));
        lublin.addNeighbour(new Train(15, lublin, gdansk));

        lodz.addNeighbour(new Train(15, lodz, gdansk));

        warszawa.addNeighbour(new Train(12, warszawa, gdansk));
        // Dodawanie nowych połączeń : wartość, początek, koniec

        Algorithm algorithm = new Algorithm();
        algorithm.computePath(krakow);
        // Tworzenie obiektu algorytmu i wykonanie

        System.out.println(algorithm.getShortestPathTo(gdansk));
        // Metoda zwraca sout'a z wartością
    }
}
