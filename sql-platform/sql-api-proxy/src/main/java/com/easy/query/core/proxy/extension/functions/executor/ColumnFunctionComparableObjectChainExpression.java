package com.easy.query.core.proxy.extension.functions.executor;

import com.easy.query.core.proxy.extension.ColumnFuncComparableExpression;
import com.easy.query.core.proxy.extension.functions.executor.impl.ColumnFunctionComparableAnyChainExpressionImpl;

/**
 * create time 2023/12/21 09:19
 * 文件说明
 *
 * @author xuejiaming
 */
public interface ColumnFunctionComparableObjectChainExpression<T> extends ColumnFuncComparableExpression<T>{

    default ColumnFunctionComparableAnyChainExpression<T> asAny() {
        Class<?> propertyType = getPropertyType();
        return new ColumnFunctionComparableAnyChainExpressionImpl<>(this.getEntitySQLContext(), this.getTable(), this.getValue(), this.func(), propertyType);
    }
}
