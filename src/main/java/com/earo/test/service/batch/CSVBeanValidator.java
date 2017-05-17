package com.earo.test.service.batch;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.batch.item.validator.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by lauearo on 15/05/2017.
 */
public class CSVBeanValidator<T> implements Validator<T>, InitializingBean {
    private javax.validation.Validator validator;

    @Override
    public void afterPropertiesSet() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @Override
    public void validate(T t) throws ValidationException {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

        if(constraintViolations.size() > 0) {
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation :
                    constraintViolations) {
                message.append(constraintViolation.getMessage() + "\n");
            }
            throw new ValidationException(message.toString());
        }
    }
}

