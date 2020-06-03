package com.example.demo.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class ValidateUtils implements InitializingBean {

    private Validator validator;

    //实现校验方法并返回校验结果
    public List<String> validate(Object bean) {
        final List result = new ArrayList<String>();
        if (Objects.isNull(bean)) {
            result.add("入参必填");
            return result;
        }


        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(bean);
        if (constraintViolationSet.size() == 0) {
            return result;
        }
        //有错误
        constraintViolationSet.forEach(constraintViolation -> {
            String errMsg = constraintViolation.getMessage();
            String propertyName = constraintViolation.getPropertyPath().toString();
            result.add(errMsg.concat("-").concat(propertyName));
        });
        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //将hibernate validator通过工厂的初始化方式使其实例化
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
}
