package com.example.demo.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义注解具体实现
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if ("tom".equals(value)) {
            return true;
        }
        return false;
    }

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init");
    }
}
