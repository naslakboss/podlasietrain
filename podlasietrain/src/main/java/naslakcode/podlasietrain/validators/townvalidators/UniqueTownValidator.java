package naslakcode.podlasietrain.validators.townvalidators;

import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.services.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueTownValidator implements ConstraintValidator<UniqueTown, Town> {

    @Autowired
    TownService townService;

    @Override
    public void initialize(UniqueTown constraintAnnotation) {}

    @Override
    public boolean isValid(Town town, ConstraintValidatorContext context) {
        return !townService.isExist(town.getName());
    }
}
