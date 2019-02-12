package com.example.entitychildvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckChildrenValidator implements ConstraintValidator<CheckChildren, Parent>
{
    @Override
    public void initialize(CheckChildren constraintAnnotation)
    {

    }

    @Override
    public boolean isValid(Parent value, ConstraintValidatorContext context)
    {
        System.out.println(" ******* VALIDATOR HIT ******* ");
        return false;
    }
}
