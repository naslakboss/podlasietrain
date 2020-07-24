package naslakcode.podlasietrain.validators.townvalidators;

import naslakcode.podlasietrain.validators.trainvalidators.UniqueTrain;
import naslakcode.podlasietrain.validators.trainvalidators.UniqueTrainValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = UniqueTownValidator.class)
public @interface UniqueTown {

    String message() default "This town is already exist in database";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
