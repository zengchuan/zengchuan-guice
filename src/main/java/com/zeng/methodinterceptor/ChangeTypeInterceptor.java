package com.zeng.methodinterceptor;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ChangeTypeInterceptor  implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        ChangeType changeType;
        Method method = methodInvocation.getMethod();
        Object target =  methodInvocation.getThis();
        Class<?> targetClass = target.getClass();

        changeType = method.getAnnotation(ChangeType.class);

        Object result;
        if (null != changeType) {
            Field fieldType = targetClass.getField("type");
            String type = (String)fieldType.get(target);

            Field fieldService = targetClass.getField("service");


            if(type.length() > 0 )   {
                if(type.equals("A")) {
                    fieldService.set(target, new AService());
                } else if(type.equals("B")) {
                    fieldService.set(target, new BService());
                } else {
                    fieldService.set(target, new AService());
                }
                result = methodInvocation.proceed();
                return result;
            }

        }
        return null;
    }


}
