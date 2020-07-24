package naslakcode.podlasietrain.validators.trainvalidators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SameTownsValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SameTowns {

     String message() default  "Town source can't be the same as town destination";
     Class<?>[] groups() default {};
     Class<? extends Payload>[] payload() default {};

}
