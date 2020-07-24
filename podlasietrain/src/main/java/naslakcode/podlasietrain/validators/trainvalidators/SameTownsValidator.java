package naslakcode.podlasietrain.validators.trainvalidators;

import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.services.TrainService;
import naslakcode.podlasietrain.validators.trainvalidators.SameTowns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
public class SameTownsValidator implements ConstraintValidator<SameTowns, Train> {

    @Autowired
    TrainService trainService;

    @Override
    public void initialize(SameTowns constraintAnnotation) {}


    @Override
    public boolean isValid(Train train, ConstraintValidatorContext context) {
        String startName = train.getSource().getName();
        String destinationName = train.getDestination().getName();
        return !(startName.equals(destinationName));
    }
}