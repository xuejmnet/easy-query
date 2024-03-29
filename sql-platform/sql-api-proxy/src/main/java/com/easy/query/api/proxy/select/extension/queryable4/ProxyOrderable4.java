package com.easy.query.api.proxy.select.extension.queryable4;

import com.easy.query.api.proxy.select.ProxyQueryable4;
import com.easy.query.api.proxy.select.extension.queryable4.sql.MultiProxyOrderSelector4;
import com.easy.query.api.proxy.select.extension.queryable4.sql.impl.MultiProxyOrderSelector4Impl;
import com.easy.query.core.api.dynamic.sort.ObjectSort;
import com.easy.query.core.exception.EasyQueryOrderByInvalidOperationException;
import com.easy.query.core.expression.lambda.SQLExpression1;
import com.easy.query.core.proxy.ProxyEntity;
import com.easy.query.core.proxy.SQLOrderByExpression;
import com.easy.query.core.util.EasyArrayUtil;

/**
 * create time 2023/8/16 08:50
 * 文件说明
 *
 * @author xuejiaming
 */
public interface ProxyOrderable4<T1Proxy extends ProxyEntity<T1Proxy, T1>, T1,
        T2Proxy extends ProxyEntity<T2Proxy, T2>, T2,
        T3Proxy extends ProxyEntity<T3Proxy, T3>, T3,
        T4Proxy extends ProxyEntity<T4Proxy, T4>, T4> extends ClientProxyQueryable4Available<T1, T2, T3, T4>, ProxyQueryable4Available<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3, T4Proxy, T4> {

    default ProxyQueryable4<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3, T4Proxy, T4> orderBy(SQLOrderByExpression... propColumns) {
        return orderBy(true, propColumns);
    }
    default ProxyQueryable4<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3, T4Proxy, T4> orderBy(boolean condition, SQLOrderByExpression... propColumns){
        if (condition) {
            if(EasyArrayUtil.isNotEmpty(propColumns)){
                for (SQLOrderByExpression propColumn : propColumns) {
                    getClientQueryable4().orderBy(columnSelector -> {
                        propColumn.accept(columnSelector.getOrderSelector());
                    }, true);
                }
            }
        }
        return getQueryable4();
    }
    default ProxyQueryable4<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3, T4Proxy, T4> orderByAsc(SQLExpression1<MultiProxyOrderSelector4<T1Proxy, T2Proxy, T3Proxy, T4Proxy>> selectExpression) {
        return orderByAsc(true, selectExpression);
    }

    default ProxyQueryable4<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3, T4Proxy, T4> orderByAsc(boolean condition, SQLExpression1<MultiProxyOrderSelector4<T1Proxy, T2Proxy, T3Proxy, T4Proxy>> selectExpression) {
        if (condition) {
            getClientQueryable4().orderByAsc((t, t1, t2, t3) -> {
                selectExpression.apply(new MultiProxyOrderSelector4Impl<>(t.getOrderSelector(), get1Proxy(), get2Proxy(), get3Proxy(), get4Proxy()));
            });
        }
        return getQueryable4();
    }
    default ProxyQueryable4<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3, T4Proxy, T4> orderByDesc(SQLExpression1<MultiProxyOrderSelector4<T1Proxy, T2Proxy, T3Proxy, T4Proxy>> selectExpression) {
        return orderByDesc(true, selectExpression);
    }

    default ProxyQueryable4<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3, T4Proxy, T4> orderByDesc(boolean condition, SQLExpression1<MultiProxyOrderSelector4<T1Proxy, T2Proxy, T3Proxy, T4Proxy>> selectExpression) {
        if (condition) {
            getClientQueryable4().orderByDesc((t, t1, t2, t3) -> {
                selectExpression.apply(new MultiProxyOrderSelector4Impl<>(t.getOrderSelector(), get1Proxy(), get2Proxy(), get3Proxy(), get4Proxy()));
            });
        }
        return getQueryable4();
    }

    /**
     * @param configuration
     * @return
     * @throws EasyQueryOrderByInvalidOperationException 当配置{@link ObjectSort} 为{@code  DynamicModeEnum.STRICT}排序设置的属性不存在当前排序对象里面或者当前查询对象无法获取
     */
    default ProxyQueryable4<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3, T4Proxy, T4> orderByObject(ObjectSort configuration) {
        return orderByObject(true, configuration);
    }

    /**
     * @param condition
     * @param objectSort
     * @return
     * @throws EasyQueryOrderByInvalidOperationException 当配置{@link ObjectSort} 为{@code  DynamicModeEnum.STRICT}排序设置的属性不存在当前排序对象里面或者当前查询对象无法获取
     */
    default ProxyQueryable4<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3, T4Proxy, T4> orderByObject(boolean condition, ObjectSort objectSort){
        if (condition) {
            getClientQueryable4().orderByObject(objectSort);
        }
        return getQueryable4();
    }

}
