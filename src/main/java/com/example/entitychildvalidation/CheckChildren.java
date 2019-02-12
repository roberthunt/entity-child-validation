package com.example.entitychildvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CheckChildrenValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckChildren
{
    String message() default "this validator always fails validation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
