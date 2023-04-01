package com.easy.query.core.basic.api.internal;

/**
 * create time 2023/3/31 22:00
 * 文件说明
 *
 * @author xuejiaming
 */
public interface Interceptable<TChain> {
    TChain noInterceptor();

    /**
     * 如果用在 {@link #noInterceptor()}后面那么就是只使用name的
     * 如果用在 {@link #useInterceptor()} 后面那么就是移除name的
     * 表达式默认 {@link #useInterceptor()}
     * @param name
     * @return
     */
    TChain interceptor(String name);

    TChain useInterceptor();
}
