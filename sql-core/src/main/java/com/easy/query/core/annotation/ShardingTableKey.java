package com.easy.query.core.annotation;

import com.easy.query.core.util.StringUtil;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * create time 2023/4/8 22:36
 * 文件说明
 *
 * @author xuejiaming
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface ShardingTableKey {

    /**
     * 分片表链接后缀
     */
    String tableSeparator() default "_";
}
