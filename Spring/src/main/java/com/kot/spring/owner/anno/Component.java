package com.kot.spring.owner.anno;

import java.lang.annotation.*;

/**
 * @author yf
 * @create 2022-12-15 16:13
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Component {
    String value() default "";
}
