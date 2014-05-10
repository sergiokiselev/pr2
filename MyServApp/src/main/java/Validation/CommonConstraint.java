//package Validation;
//
//import static java.lang.annotation.ElementType.*;
//import static java.lang.annotation.RetentionPolicy.*;
//
//import javax.validation.Constraint;
//import javax.validation.ConstraintValidator;
//import javax.validation.Payload;
//import java.lang.annotation.Documented;
//import java.lang.annotation.Retention;
//import java.lang.annotation.Target;
//
//@Target( { TYPE, ANNOTATION_TYPE })
//@Retention(RUNTIME)
//@Constraint(validatedBy = ConstraintValidator.class)
//@Documented
//public @interface CommonConstraint {
//
//    String message() default "CommonConstraint";
//
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
//}