package com.easy.query.core.basic.api.select.executor;

import com.easy.query.core.basic.api.select.QueryAvailable;

/**
 * create time 2023/10/20 23:07
 * 文件说明
 *
 * @author xuejiaming
 */
public interface QueryExecutable<T> extends QueryAvailable<T> ,MethodQuery<T>,MethodResultQuery<T>{
}
