package com.easy.query.api.proxy.select.extension.queryable5;

import com.easy.query.api.proxy.select.ProxyQueryable5;
import com.easy.query.api.proxy.select.extension.queryable.Proxy1Available;
import com.easy.query.core.proxy.ProxyEntity;

/**
 * create time 2023/8/17 11:14
 * 文件说明
 *
 * @author xuejiaming
 */
public interface ProxyQueryable5Available<T1Proxy extends ProxyEntity<T1Proxy, T1>,
        T1, T2Proxy extends ProxyEntity<T2Proxy, T2>, T2,
        T3Proxy extends ProxyEntity<T3Proxy, T3>, T3,
        T4Proxy extends ProxyEntity<T4Proxy, T4>, T4,
        T5Proxy extends ProxyEntity<T5Proxy, T5>, T5> extends Proxy1Available<T1Proxy, T1> {
    ProxyQueryable5<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3, T4Proxy, T4, T5Proxy, T5> getQueryable5();
    T2Proxy get2Proxy();
    T3Proxy get3Proxy();
    T4Proxy get4Proxy();
    T5Proxy get5Proxy();
}
