package com.easy.query.api.proxy.sql;

import com.easy.query.api.proxy.sql.core.SQLProxyNative;
import com.easy.query.api.proxy.sql.core.available.ProxySQLFuncAvailable;
import com.easy.query.core.context.QueryRuntimeContext;
import com.easy.query.core.expression.builder.GroupSelector;
import com.easy.query.core.proxy.ProxyEntity;
import com.easy.query.core.proxy.SQLColumn;
import com.easy.query.core.proxy.SQLGroupByExpression;

/**
 * create time 2023/6/23 13:21
 * 文件说明
 *
 * @author xuejiaming
 */
public interface ProxyGroupSelector extends SQLProxyNative<ProxyGroupSelector> , ProxySQLFuncAvailable {
    GroupSelector getGroupSelector();
    default QueryRuntimeContext getRuntimeContext() {
        return getGroupSelector().getRuntimeContext();
    }

    default ProxyGroupSelector columns(SQLColumn<?,?>... columns) {
        if (columns != null) {
            for (SQLColumn<?,?> sqlColumn : columns) {
                getGroupSelector().column(sqlColumn.getTable(), sqlColumn.getValue());
            }
        }
        return this;
    }

    default <TProxy extends ProxyEntity<TProxy,T>,T,TProperty> ProxyGroupSelector column(SQLColumn<TProxy,TProperty> column) {
        getGroupSelector().column(column.getTable(), column.getValue());
        return this;
    }
    default ProxyGroupSelector expressions(SQLGroupByExpression... groupByExpressions) {
        for (SQLGroupByExpression groupByExpression : groupByExpressions) {
            expression(groupByExpression);
        }
        return this;
    }
    default ProxyGroupSelector expression(SQLGroupByExpression groupByExpression) {
        groupByExpression.accept(getGroupSelector());
        return this;
    }

    default ProxyGroupSelector columnFunc(ProxyColumnPropertyFunction proxyColumnPropertyFunction) {
        getGroupSelector().columnFunc(proxyColumnPropertyFunction.getColumn().getTable(), proxyColumnPropertyFunction.getColumnPropertyFunction());
        return this;
    }
}
