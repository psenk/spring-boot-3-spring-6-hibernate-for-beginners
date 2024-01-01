package home.springmvcdemo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// what class contains the constraint logic
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
// where the annotation can be used (methods and fields)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // creating validation
    // define default course code
    public String value() default "LUV";    

    // define default error message
    public String message() default "must start with LUV";

    // define groups
    public Class<?>[] groups() default {};
    
    // define payloads
    public Class<? extends Payload>[] payload() default {};

}
