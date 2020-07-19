package naslakcode.podlasietrain.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueTrainValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueTrain {

    String message() default "This connection is already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}