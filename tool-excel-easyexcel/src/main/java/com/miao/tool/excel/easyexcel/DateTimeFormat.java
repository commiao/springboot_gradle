package com.miao.tool.excel.easyexcel;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DateTimeFormat {
    String value() default "";

    boolean use1904windowing() default false;
}
