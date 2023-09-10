package com.easy.query.api.proxy.select.extension.queryable3.override;

import com.easy.query.api.proxy.select.ProxyQueryable;
import com.easy.query.api.proxy.select.ProxyQueryable3;
import com.easy.query.api.proxy.select.extension.queryable3.ProxyQueryable3Available;
import com.easy.query.api.proxy.sql.ProxyAggregateFilter;
import com.easy.query.api.proxy.sql.ProxyFilter;
import com.easy.query.api.proxy.sql.ProxyGroupSelector;
import com.easy.query.api.proxy.sql.ProxyNavigateInclude;
import com.easy.query.api.proxy.sql.ProxyOrderSelector;
import com.easy.query.core.api.client.EasyQueryClient;
import com.easy.query.core.enums.sharding.ConnectionModeEnum;
import com.easy.query.core.expression.builder.core.ConditionAccepter;
import com.easy.query.core.expression.lambda.SQLExpression2;
import com.easy.query.core.expression.lambda.SQLFuncExpression2;
import com.easy.query.core.proxy.ProxyEntity;

import java.util.Collection;
import java.util.function.Function;

/**
 * create time 2023/8/16 08:12
 * 文件说明
 *
 * @author xuejiaming
 */
public interface OverrideProxyQueryable3<T1Proxy extends ProxyEntity<T1Proxy, T1>, T1, T2Proxy extends ProxyEntity<T2Proxy, T2>, T2, T3Proxy extends ProxyEntity<T3Proxy, T3>, T3> extends ProxyQueryable<T1Proxy, T1>, ProxyQueryable3Available<T1Proxy, T1, T2Proxy, T2,T3Proxy,T3> {

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> cloneQueryable();

    @Override
    default ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> whereById(Object id) {
        return whereById(true, id);
    }

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> whereById(boolean condition, Object id);

    @Override
    <TProperty> ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> whereByIds(boolean condition, Collection<TProperty> ids);

    /**
     * 仅支持主表的动态对象查询
     *
     * @param object 对象查询的对象
     * @return
     */
    @Override
    default ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> whereObject(Object object) {
        return whereObject(true, object);
    }

    /**
     * 仅支持主表的动态对象查询
     *
     * @param condition 是否使用对象查询
     * @param object    对象查询的对象
     * @return
     */
    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> whereObject(boolean condition, Object object);


    @Override
    default ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> where(SQLExpression2<ProxyFilter,T1Proxy> whereExpression) {
        return where(true, whereExpression);
    }

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> where(boolean condition, SQLExpression2<ProxyFilter,T1Proxy> whereExpression);

    @Override
    default ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> groupBy(SQLExpression2<ProxyGroupSelector, T1Proxy> selectExpression) {
        return groupBy(true, selectExpression);
    }

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> groupBy(boolean condition, SQLExpression2<ProxyGroupSelector, T1Proxy> selectExpression);

    @Override
    default ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> having(SQLExpression2<ProxyAggregateFilter, T1Proxy> predicateExpression) {
        return having(true, predicateExpression);
    }

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> having(boolean condition, SQLExpression2<ProxyAggregateFilter, T1Proxy> predicateExpression);

    @Override
    default ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> orderByAsc(SQLExpression2<ProxyOrderSelector, T1Proxy> selectExpression) {
        return orderByAsc(true, selectExpression);
    }

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> orderByAsc(boolean condition, SQLExpression2<ProxyOrderSelector, T1Proxy> selectExpression);

    @Override
    default ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> orderByDesc(SQLExpression2<ProxyOrderSelector, T1Proxy> selectExpression) {
        return orderByDesc(true, selectExpression);
    }

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> orderByDesc(boolean condition, SQLExpression2<ProxyOrderSelector, T1Proxy> selectExpression);

    @Override
    default <TPropertyProxy extends ProxyEntity<TPropertyProxy, TProperty>, TProperty> ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> include(SQLFuncExpression2<ProxyNavigateInclude<T1>,T1Proxy, ProxyQueryable<TPropertyProxy, TProperty>> navigateIncludeSQLExpression) {
        return include(true, navigateIncludeSQLExpression);
    }

    @Override
    <TPropertyProxy extends ProxyEntity<TPropertyProxy, TProperty>, TProperty> ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> include(boolean condition, SQLFuncExpression2<ProxyNavigateInclude<T1>,T1Proxy, ProxyQueryable<TPropertyProxy, TProperty>> navigateIncludeSQLExpression);

    @Override
    default ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> limit(long rows) {
        return limit(true, rows);
    }

    @Override
    default ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> limit(boolean condition, long rows) {
        return limit(condition, 0, rows);
    }

    @Override
    default ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> limit(long offset, long rows) {
        return limit(true, offset, rows);
    }

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> limit(boolean condition, long offset, long rows);

    default ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> distinct() {
        return distinct(true);
    }

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> distinct(boolean condition);

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> disableLogicDelete();

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> enableLogicDelete();

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> useLogicDelete(boolean enable);

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> noInterceptor();

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> useInterceptor(String name);

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> noInterceptor(String name);

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> useInterceptor();

    /**
     * 自动将查询结果集合全部添加到当前上下文追踪中,如果当前查询结果十分庞大,并且更新数据只有个别条数,建议不要使用
     * 追踪查询，可以通过开启追踪后使用普通的查询，然后添加到当前的追踪上下文中{@link EasyQueryClient#addTracking(Object)},开始先数据追踪的差异更新
     *
     * @return
     */
    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> asTracking();

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> asNoTracking();

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> queryLargeColumn(boolean queryLarge);

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> useShardingConfigure(int maxShardingQueryLimit, ConnectionModeEnum connectionMode);

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> useMaxShardingQueryLimit(int maxShardingQueryLimit);

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> useConnectionMode(ConnectionModeEnum connectionMode);

    /**
     * 将当前表达式最近的一张表的表名修改成 {@param tableName}
     * 如果当前最近的表是正常的数据库表名,那么直接将表名改写
     * 如果当前最近的表是匿名表比如嵌套queryable的表那么将alias改成对应的表名
     *
     * @param tableName
     * @return
     */
    @Override
    default ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> asTable(String tableName) {
        return asTable(old -> tableName);
    }

    /**
     * 将当前表达式最近的一张表的表名修改成 {@param tableNameAs}返回的表名
     * 如果当前最近的表是正常的数据库表名,那么直接将表名改写
     * 如果当前最近的表是匿名表比如嵌套queryable的表那么将alias改成对应的表名
     *
     * @param tableNameAs
     * @return
     */
    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> asTable(Function<String, String> tableNameAs);

    @Override
    default ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> asSchema(String schema) {
        return asSchema(old -> schema);
    }

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> asSchema(Function<String, String> schemaAs);

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> asAlias(String alias);

    /**
     * @param linkAs 别名 FROM | LEFT JOIN | RIGHT JOIN
     * @return
     */
    @Override
    default ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> asTableLink(String linkAs) {
        return asTableLink(o -> linkAs);
    }


    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> asTableLink(Function<String, String> linkAs);

    @Override
    ProxyQueryable3<T1Proxy, T1, T2Proxy, T2, T3Proxy, T3> conditionConfigure(ConditionAccepter conditionAccepter);
}
