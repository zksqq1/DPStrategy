package com.tdxk.dp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lin.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Inherited //如果需要事务处理，需要加上这个注解
public @interface UserTypeAnnotation {
    int userType() default 0;
}
