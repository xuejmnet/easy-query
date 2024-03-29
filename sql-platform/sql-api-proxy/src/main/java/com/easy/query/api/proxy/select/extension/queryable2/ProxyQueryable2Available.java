package com.easy.query.api.proxy.select.extension.queryable2;

import com.easy.query.api.proxy.select.ProxyQueryable2;
import com.easy.query.core.context.QueryRuntimeContext;
import com.easy.query.core.proxy.ProxyEntity;

/**
 * create time 2023/8/17 11:14
 * 文件说明
 *
 * @author xuejiaming
 */
public interface ProxyQueryable2Available<T1Proxy extends ProxyEntity<T1Proxy, T1>, T1, T2Proxy extends ProxyEntity<T2Proxy, T2>, T2> {
    ProxyQueryable2<T1Proxy, T1, T2Proxy, T2> getQueryable2();
    QueryRuntimeContext getRuntimeContext();
    T1Proxy get1Proxy();
    T2Proxy get2Proxy();
}
