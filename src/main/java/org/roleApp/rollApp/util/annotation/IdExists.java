package org.roleApp.rollApp.util.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.roleApp.rollApp.util.validation.IdExistsConstraintValidator;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdExistsConstraintValidator.class)
@Documented
public @interface IdExists {
    String message() default "Entity not found";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<?> entityClass();
    String field();
}