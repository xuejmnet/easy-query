package com.easy.query.api.proxy.select.abstraction;

import com.easy.query.api.proxy.select.extension.queryable8.AbstractOverrideProxyQueryable8;
import com.easy.query.core.basic.api.select.ClientQueryable8;
import com.easy.query.core.expression.sql.builder.EntityQueryExpressionBuilder;
import com.easy.query.core.proxy.ProxyEntity;

/**
 * create time 2023/6/23 22:08
 * 文件说明
 *
 * @author xuejiaming
 */
public abstract class AbstractProxyQueryable8<T1Proxy extends ProxyEntity<T1Proxy, T1>, T1,
        T2Proxy extends ProxyEntity<T2Proxy, T2>, T2,
        T3Proxy extends ProxyEntity<T3Proxy, T3>, T3,
        T4Proxy extends ProxyEntity<T4Proxy, T4>, T4,
        T5Proxy extends ProxyEntity<T5Proxy, T5>, T5,
        T6Proxy extends ProxyEntity<T6Proxy, T6>, T6,
        T7Proxy extends ProxyEntity<T7Proxy, T7>, T7,
        T8Proxy extends ProxyEntity<T8Proxy, T8>, T8>
        extends AbstractOverrideProxyQueryable8<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3, T4Proxy, T4, T5Proxy, T5, T6Proxy, T6, T7Proxy, T7, T8Proxy, T8> {


    protected final T1Proxy t1Proxy;
    protected final T2Proxy t2Proxy;
    protected final T3Proxy t3Proxy;
    protected final T4Proxy t4Proxy;
    protected final T5Proxy t5Proxy;
    protected final T6Proxy t6Proxy;
    protected final T7Proxy t7Proxy;
    protected final T8Proxy t8Proxy;

    public AbstractProxyQueryable8(T1Proxy t1Proxy, T2Proxy t2Proxy, T3Proxy t3Proxy, T4Proxy t4Proxy, T5Proxy t5Proxy, T6Proxy t6Proxy, T7Proxy t7Proxy, T8Proxy t8Proxy, ClientQueryable8<T1, T2, T3, T4, T5, T6, T7, T8> entityQueryable) {
        super(entityQueryable);
        EntityQueryExpressionBuilder sqlEntityExpressionBuilder = entityQueryable.getSQLEntityExpressionBuilder();
        this.t1Proxy = t1Proxy.create(sqlEntityExpressionBuilder.getTable(0).getEntityTable(),sqlEntityExpressionBuilder,getRuntimeContext());
        this.t2Proxy = t2Proxy.create(sqlEntityExpressionBuilder.getTable(1).getEntityTable(),sqlEntityExpressionBuilder,getRuntimeContext());
        this.t3Proxy = t3Proxy.create(sqlEntityExpressionBuilder.getTable(2).getEntityTable(),sqlEntityExpressionBuilder,getRuntimeContext());
        this.t4Proxy = t4Proxy.create(sqlEntityExpressionBuilder.getTable(3).getEntityTable(),sqlEntityExpressionBuilder,getRuntimeContext());
        this.t5Proxy = t5Proxy.create(sqlEntityExpressionBuilder.getTable(4).getEntityTable(),sqlEntityExpressionBuilder,getRuntimeContext());
        this.t6Proxy = t6Proxy.create(sqlEntityExpressionBuilder.getTable(5).getEntityTable(),sqlEntityExpressionBuilder,getRuntimeContext());
        this.t7Proxy = t7Proxy.create(sqlEntityExpressionBuilder.getTable(6).getEntityTable(),sqlEntityExpressionBuilder,getRuntimeContext());
        this.t8Proxy = t8Proxy.create(sqlEntityExpressionBuilder.getTable(7).getEntityTable(),sqlEntityExpressionBuilder,getRuntimeContext());
    }

    @Override
    public T1Proxy get1Proxy() {
        return t1Proxy;
    }
    @Override
    public T2Proxy get2Proxy() {
        return t2Proxy;
    }

    @Override
    public T3Proxy get3Proxy() {
        return t3Proxy;
    }

    @Override
    public T4Proxy get4Proxy() {
        return t4Proxy;
    }

    @Override
    public T5Proxy get5Proxy() {
        return t5Proxy;
    }

    @Override
    public T6Proxy get6Proxy() {
        return t6Proxy;
    }

    @Override
    public T7Proxy get7Proxy() {
        return t7Proxy;
    }

    @Override
    public T8Proxy get8Proxy() {
        return t8Proxy;
    }
}

