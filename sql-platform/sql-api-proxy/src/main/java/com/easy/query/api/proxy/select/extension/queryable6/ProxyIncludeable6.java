package com.easy.query.api.proxy.select.extension.queryable6;

import com.easy.query.api.proxy.select.ProxyQueryable;
import com.easy.query.api.proxy.select.ProxyQueryable6;
import com.easy.query.api.proxy.sql.ProxyNavigateInclude;
import com.easy.query.api.proxy.sql.impl.ProxyNavigateIncludeImpl;
import com.easy.query.core.expression.lambda.SQLFuncExpression2;
import com.easy.query.core.proxy.ProxyEntity;

/**
 * create time 2023/8/17 13:34
 * 文件说明
 *
 * @author xuejiaming
 */
public interface ProxyIncludeable6<T1Proxy extends ProxyEntity<T1Proxy, T1>, T1,
        T2Proxy extends ProxyEntity<T2Proxy, T2>, T2,
        T3Proxy extends ProxyEntity<T3Proxy, T3>, T3,
        T4Proxy extends ProxyEntity<T4Proxy, T4>, T4,
        T5Proxy extends ProxyEntity<T5Proxy, T5>, T5,
        T6Proxy extends ProxyEntity<T6Proxy, T6>, T6> extends ClientProxyQueryable6Available<T1, T2, T3, T4, T5, T6>, ProxyQueryable6Available<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3, T4Proxy, T4, T5Proxy, T5, T6Proxy, T6> {

    default <TPropertyProxy extends ProxyEntity<TPropertyProxy, TProperty>, TProperty> ProxyQueryable6<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3, T4Proxy, T4, T5Proxy, T5, T6Proxy, T6> include(SQLFuncExpression2<ProxyNavigateInclude<T1>,T1Proxy, ProxyQueryable<TPropertyProxy, TProperty>> navigateIncludeSQLExpression) {
        return include(true, navigateIncludeSQLExpression);
    }

    default <TPropertyProxy extends ProxyEntity<TPropertyProxy, TProperty>, TProperty> ProxyQueryable6<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3, T4Proxy, T4, T5Proxy, T5, T6Proxy, T6> include(boolean condition, SQLFuncExpression2<ProxyNavigateInclude<T1>,T1Proxy, ProxyQueryable<TPropertyProxy, TProperty>> navigateIncludeSQLExpression) {
        if (condition) {
            getClientQueryable6().<TProperty>include(navigateInclude -> navigateIncludeSQLExpression.apply(new ProxyNavigateIncludeImpl<>(navigateInclude),getQueryable6().get1Proxy()).getClientQueryable());
        }
        return getQueryable6();
    }
}
