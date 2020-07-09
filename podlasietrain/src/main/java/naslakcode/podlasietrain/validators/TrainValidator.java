package naslakcode.podlasietrain.validators;

import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TrainValidator  implements Validator {

    @Autowired
    TrainService trainService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Train.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Train train = (Train) o;
        // Walidacja dla nieistniejących nazw miast
        // Walidacja unikalności tras
        // Walidacja tras Zako -> Zako
        if(train.getStart() == train.getDestination()){
            errors.rejectValue("start", "Duplicate.startAndDestination.start");
        }
        if(train.getStart() == trainService.findByUsername(train.getStart())){
            errors.rejectValue("start", "Start.noExist");
        }
        if(train.getDestination() == trainService.findByUsername(train.getDestination())){
            errors.rejectValue("destination", "Destination.noExist");
        }

    }
}
