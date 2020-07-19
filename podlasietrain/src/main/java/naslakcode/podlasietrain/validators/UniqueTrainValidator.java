package naslakcode.podlasietrain.validators;

import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.services.TownService;
import naslakcode.podlasietrain.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueTrainValidator implements ConstraintValidator<UniqueTrain, Train> {

    @Autowired
    TrainService trainService;

    @Autowired
    TownService townService;

    @Override
    public void initialize(UniqueTrain constraintAnnotation) {

    }

    @Override
    public boolean isValid(Train train, ConstraintValidatorContext context) {

        return !trainService.isExist(train);
    }
}
