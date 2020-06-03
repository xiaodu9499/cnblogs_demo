package com.example.demo.aspect;

import com.example.demo.po.response.BaseResponse;
import com.example.demo.service.impl.ValidateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class ValitorAop {

    @Autowired
    ValidateUtils validateUtils;

    @Around("execution(* com.example.*.service..*.*(..)))")
    public Object before(ProceedingJoinPoint point) {
        // 入参校验
        List<String> strings = validateParam(point);
        if (strings.size() > 0) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMsg(strings.toString());
            baseResponse.setCode(400);
            return baseResponse;
        }

        Object proceed = null;
        try {
            proceed = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

    /**
     * 校验入参
     *
     * @param point
     * @return
     */
    private List<String> validateParam(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        // 入参
        Object[] args = point.getArgs();
        //参数注解，1维是参数的下标，2维是注解
        Annotation[][] annotations = method.getParameterAnnotations();
        List<String> validate = new ArrayList<>();
        for (int i = 0; i < annotations.length; i++) {
            // 参数
            Object param = args[i];
            // 参数对应的注解
            Annotation[] paramAnn = annotations[i];
            if (paramAnn.length == 0) {
                continue;
            }
            for (Annotation annotation : paramAnn) {
                //判断当前注解是否为Valid.class
                if (!annotation.annotationType().equals(Valid.class)) {
                    continue;
                }
                //校验该参数，验证一次退出该注解
                validate = validateUtils.validate(param);
                if (validate == null && validate.size() == 0) {
                    continue;
                }
                return validate;
            }
        }
        return validate;
    }
}