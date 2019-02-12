package com.example.entitychildvalidation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityChildValidationApplicationTests
{
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Autowired
    ParentRepository parentRepository;

    @Test
    @Transactional
    public void creatingNewParentShouldFailValidation()
    {
        exception.expect(ConstraintViolationException.class);
        parentRepository.saveAndFlush(new Parent());
    }

    @Test
    @Transactional
    public void changingNameOfParentShouldFailValidation()
    {
        Parent p = parentRepository.findById(1L).get();
        p.setName("CHANGED!");

        exception.expect(ConstraintViolationException.class);
        parentRepository.saveAndFlush(p);
    }

    @Test
    @Transactional
    public void addingChildToExistingParentAndChangingNameOfParentShouldFailValidation()
    {
        Parent p = parentRepository.findById(1L).get();
        p.setName("CHANGED!");
        p.getChildren().add(new Child());

        exception.expect(ConstraintViolationException.class);
        parentRepository.saveAndFlush(p);
    }

    @Test
    @Transactional
    public void addingChildToExistingParentShouldFailValidation()
    {
        Parent p = parentRepository.findById(1L).get();
        p.getChildren().add(new Child());

        exception.expect(ConstraintViolationException.class);
        parentRepository.saveAndFlush(p);
    }

}

