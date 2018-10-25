package com.exchange.bbs.common.aop;

import com.exchange.bbs.common.annotation.ParamValidate;
import com.exchange.bbs.common.exception.BusinessException;
import com.exchange.bbs.common.exception.enums.OpenApiException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Hibernate 参数校验Aop
 *
 * @author ganbo E-mail:bo.gan@56qq.com
 * @since 2018-01-27 14:11
 */

@Aspect
@Component
public class ParamsValidateAop {

    private static final Logger logger = LoggerFactory.getLogger(ParamsValidateAop.class);

    /**
     * 使用Hibernate的注解来进行验证
     */
    @Autowired
    private ValidatorFactory validatorFactory;

    @Pointcut("execution(public * com.exchange.bbs.*.controller.*.*(..))")
    public void webLog() {

    }

    /**
     * 注解参数校验
     *
     * @param pjp
     * @param <T>
     */

    @Around(value = "webLog()")
    public <T> Object doValidate(ProceedingJoinPoint pjp) throws Throwable {

        if (!(pjp.getSignature() instanceof MethodSignature)) {
            return pjp.proceed();
        }
        MethodSignature methodSign = (MethodSignature) pjp.getSignature();
        Set<ConstraintViolation<Object>> constraintViolations; //定义校验结果集

        ParamValidate paramValidate = methodSign.getMethod().getAnnotation(ParamValidate.class);
        if (paramValidate != null) {
            // 处理方法型传参校验
            ExecutableValidator executableValidator = validatorFactory.getValidator().forExecutables();
            constraintViolations = executableValidator.validateParameters(pjp.getTarget(),
                    ((MethodSignature) pjp.getSignature()).getMethod(), pjp.getArgs());

        } else {
            //处理参数型传参校验
            constraintViolations = new HashSet<>();
            Annotation[][] parameterAnnotations = methodSign.getMethod().getParameterAnnotations();
            Object[] args = pjp.getArgs();
            if (parameterAnnotations != null && parameterAnnotations.length > 0) {
                for (int i = 0; i < parameterAnnotations.length; i++) {
                    Annotation[] parameterAnnotation = parameterAnnotations[i];
                    for (Annotation annotation : parameterAnnotation) {
                        if (annotation instanceof ParamValidate) {
                            Object param = args[i];
                            Set<ConstraintViolation<Object>> validates = validatorFactory.getValidator().validate(param);
                            constraintViolations.addAll(validates);
                        }
                    }
                }
            }

        }

        //打印校验不通过的参数
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            Map<String, String> errorParams = new HashMap<>();
            StringBuilder paramsErrorMsg = new StringBuilder();
            for (ConstraintViolation<Object> o : constraintViolations) {
                errorParams.put(o.getPropertyPath().toString(), o.getMessage());
                paramsErrorMsg.append(o.getPropertyPath()).append(":").append(o.getMessage()).append(",");
            }
            paramsErrorMsg.deleteCharAt(paramsErrorMsg.length() - 1);
            logger.error(paramsErrorMsg.toString());
            //有多个参数异常只提示一个参数错误
            throw new BusinessException(OpenApiException.PARAM_ERROR.getCode(), constraintViolations.iterator().next().getMessageTemplate(), errorParams);
        }

        return pjp.proceed();
    }

}
