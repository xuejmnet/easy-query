package com.easy.query.api.proxy.client;

import com.easy.query.api.proxy.delete.ProxyEntityDeletable;
import com.easy.query.api.proxy.delete.ProxyExpressionDeletable;
import com.easy.query.api.proxy.delete.impl.EasyProxyEntityDeletable;
import com.easy.query.api.proxy.delete.impl.EasyProxyExpressionDeletable;
import com.easy.query.core.proxy.func.ProxySQLFunc;
import com.easy.query.core.proxy.func.ProxySQLFuncImpl;
import com.easy.query.api.proxy.insert.EasyProxyOnlyEntityInsertable;
import com.easy.query.api.proxy.insert.ProxyOnyEntityInsertable;
import com.easy.query.api.proxy.select.ProxyQueryable;
import com.easy.query.api.proxy.select.impl.EasyProxyQueryable;
import com.easy.query.api.proxy.update.ProxyEntityUpdatable;
import com.easy.query.api.proxy.update.ProxyExpressionUpdatable;
import com.easy.query.api.proxy.update.ProxyOnlyEntityUpdatable;
import com.easy.query.api.proxy.update.impl.EasyProxyEntityUpdatable;
import com.easy.query.api.proxy.update.impl.EasyProxyExpressionUpdatable;
import com.easy.query.api.proxy.update.impl.EasyProxyOnlyEntityUpdatable;
import com.easy.query.core.annotation.NotNull;
import com.easy.query.core.api.client.EasyQueryClient;
import com.easy.query.core.basic.extension.track.EntityState;
import com.easy.query.core.basic.jdbc.tx.Transaction;
import com.easy.query.core.context.QueryRuntimeContext;
import com.easy.query.core.proxy.ProxyEntity;

import java.util.Collection;
import java.util.Objects;

/**
 * create time 2023/6/24 11:45
 * 文件说明
 *
 * @author xuejiaming
 */
public class DefaultEasyProxyQuery implements EasyProxyQuery {
    private final EasyQueryClient easyQueryClient;
    private final ProxySQLFunc sqlProxyFunc;

    public DefaultEasyProxyQuery(EasyQueryClient easyQueryClient) {
        this.easyQueryClient = easyQueryClient;
        this.sqlProxyFunc = new ProxySQLFuncImpl(easyQueryClient.getRuntimeContext().fx());
    }

    @Override
    public EasyQueryClient getEasyQueryClient() {
        return easyQueryClient;
    }

    @Override
    public QueryRuntimeContext getRuntimeContext() {
        return easyQueryClient.getRuntimeContext();
    }

    @Override
    public <TProxy extends ProxyEntity<TProxy, TEntity>, TEntity> ProxyQueryable<TProxy, TEntity> queryable(TProxy table) {
        return new EasyProxyQueryable<>(table, easyQueryClient.queryable(table.getEntityClass()));
    }

    @Override
    public <TProxy extends ProxyEntity<TProxy, T>, T> ProxyQueryable<TProxy, T> queryable(String sql, TProxy table, Collection<Object> sqlParams) {
        return new EasyProxyQueryable<>(table, easyQueryClient.queryable(sql, table.getEntityClass(), sqlParams));
    }

    @Override
    public Transaction beginTransaction(Integer isolationLevel) {
        return easyQueryClient.beginTransaction(isolationLevel);
    }

    @Override
    public <T> ProxyOnyEntityInsertable<T> insertable(T entity) {
        return new EasyProxyOnlyEntityInsertable<>(easyQueryClient.insertable(entity));
    }

    @Override
    public <T> ProxyOnyEntityInsertable<T> insertable(Collection<T> entities) {
        return new EasyProxyOnlyEntityInsertable<>(easyQueryClient.insertable(entities));
    }

    @Override
    public <TProxy extends ProxyEntity<TProxy, T>, T> ProxyExpressionUpdatable<TProxy, T> updatable(TProxy proxy) {
        return new EasyProxyExpressionUpdatable<>(proxy, easyQueryClient.updatable(proxy.getEntityClass()));
    }

    @Override
    public <T> ProxyOnlyEntityUpdatable<T> updatable(T entity) {
        return new EasyProxyOnlyEntityUpdatable<>(easyQueryClient.updatable(entity));
    }

    @Override
    public <T> ProxyOnlyEntityUpdatable<T> updatable(Collection<T> entities) {
        return new EasyProxyOnlyEntityUpdatable<>(easyQueryClient.updatable(entities));
    }

//    @Override
//    public <T extends ProxyEntityAvailable<T, TProxy>, TProxy extends ProxyEntity<TProxy, T>> @NotNull ProxyEntityUpdatable<TProxy, T> updatableProxy(@NotNull T entity) {
//        Objects.requireNonNull(entity, "entity is null");
//        TProxy proxyTable = entity.createProxyTable();
//        Objects.requireNonNull(entity, "proxyTable is null");
//        return new EasyProxyEntityUpdatable<>(proxyTable, easyQueryClient.updatable(entity));
//    }
//
//    @Override
//    public <T extends ProxyEntityAvailable<T, TProxy>, TProxy extends ProxyEntity<TProxy, T>> @NotNull ProxyEntityUpdatable<TProxy, T> updatableProxy(@NotNull Collection<T> entities) {
//        Objects.requireNonNull(entities, "entities is null");
//        if (entities.isEmpty()) {
//            return new EasyEmptyProxyEntityUpdatable<>(easyQueryClient.updatable(entities));
//        }
//        return new EasyProxyEntityUpdatable<>(EasyCollectionUtil.first(entities).createProxyTable(), easyQueryClient.updatable(entities));
//    }

    @Override
    public <TProxy extends ProxyEntity<TProxy, T>, T> ProxyEntityUpdatable<TProxy, T> updatable(@NotNull T entity, @NotNull TProxy proxy) {
        Objects.requireNonNull(entity, "entity is null");
        Objects.requireNonNull(proxy, "proxy is null");
        return new EasyProxyEntityUpdatable<>(proxy, easyQueryClient.updatable(entity));
    }


    @Override
    public <TProxy extends ProxyEntity<TProxy, T>, T> ProxyEntityUpdatable<TProxy, T> updatable(@NotNull Collection<T> entities, @NotNull TProxy proxy) {
        Objects.requireNonNull(entities, "entities is null");
        Objects.requireNonNull(proxy, "proxy is null");
        return new EasyProxyEntityUpdatable<>(proxy, easyQueryClient.updatable(entities));
    }

    @Override
    public <T> ProxyEntityDeletable<T> deletable(T entity) {
        return new EasyProxyEntityDeletable<>(easyQueryClient.deletable(entity));
    }

    @Override
    public <T> ProxyEntityDeletable<T> deletable(Collection<T> entities) {
        return new EasyProxyEntityDeletable<>(easyQueryClient.deletable(entities));
    }

    @Override
    public <TProxy extends ProxyEntity<TProxy, T>, T> ProxyExpressionDeletable<TProxy, T> deletable(TProxy proxy) {
        return new EasyProxyExpressionDeletable<>(proxy, easyQueryClient.deletable(proxy.getEntityClass()));
    }

    @Override
    public boolean addTracking(Object entity) {
        return easyQueryClient.addTracking(entity);
    }

    @Override
    public boolean removeTracking(Object entity) {
        return easyQueryClient.removeTracking(entity);
    }

    @Override
    public EntityState getTrackEntityStateNotNull(Object entity) {
        return easyQueryClient.getTrackEntityStateNotNull(entity);
    }

    @Override
    public ProxySQLFunc sqlFunc() {
        return sqlProxyFunc;
    }
}
