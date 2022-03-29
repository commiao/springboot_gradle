package com.miao.tool.excel.easyexcel;

import java.lang.annotation.*;
import java.math.RoundingMode;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface NumberFormat {
    String value() default "";

    RoundingMode roundingMode() default RoundingMode.HALF_UP;
}
