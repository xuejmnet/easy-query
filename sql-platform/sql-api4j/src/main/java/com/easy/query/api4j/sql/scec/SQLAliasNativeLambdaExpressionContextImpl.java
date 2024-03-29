package com.easy.query.api4j.sql.scec;

import com.easy.query.api4j.select.Queryable;
import com.easy.query.api4j.util.EasyLambdaUtil;
import com.easy.query.core.expression.lambda.Property;
import com.easy.query.core.expression.parser.core.EntitySQLTableOwner;
import com.easy.query.core.expression.parser.core.available.TableAvailable;
import com.easy.query.core.expression.parser.core.base.scec.SQLAliasNativePropertyExpressionContext;

import java.util.Collection;

/**
 * create time 2023/7/29 23:41
 * 文件说明
 *
 * @author xuejiaming
 */
public class SQLAliasNativeLambdaExpressionContextImpl<T1,TR> implements SQLAliasNativeLambdaExpressionContext<T1,TR>{
    private final SQLAliasNativePropertyExpressionContext sqlAliasNativePropertyExpressionContext;

    public SQLAliasNativeLambdaExpressionContextImpl(SQLAliasNativePropertyExpressionContext sqlAliasNativePropertyExpressionContext){

        this.sqlAliasNativePropertyExpressionContext = sqlAliasNativePropertyExpressionContext;
    }
    @Override
    public SQLAliasNativeLambdaExpressionContext<T1,TR> expressionAlias(Property<TR, ?> property) {
        sqlAliasNativePropertyExpressionContext.expressionAlias(EasyLambdaUtil.getPropertyName(property));
        return this;
    }

    @Override
    public SQLAliasNativeLambdaExpressionContext<T1, TR> setPropertyAlias(Property<TR, ?> property) {
        sqlAliasNativePropertyExpressionContext.setPropertyAlias(EasyLambdaUtil.getPropertyName(property));
        return this;
    }

    @Override
    public SQLAliasNativeLambdaExpressionContext<T1,TR> expression(Property<T1, ?> property) {
        sqlAliasNativePropertyExpressionContext.expression(EasyLambdaUtil.getPropertyName(property));
        return this;
    }

    @Override
    public <T2> SQLAliasNativeLambdaExpressionContext<T1,TR> expression(EntitySQLTableOwner<T2> table, Property<T2, ?> property) {
        sqlAliasNativePropertyExpressionContext.expression(table,EasyLambdaUtil.getPropertyName(property));
        return this;
    }

    @Override
    public SQLAliasNativeLambdaExpressionContext<T1,TR> columnName(String columnName) {
        sqlAliasNativePropertyExpressionContext.columnName(columnName);
        return this;
    }

    @Override
    public SQLAliasNativeLambdaExpressionContext<T1,TR> columnName(TableAvailable table, String columnName) {
        sqlAliasNativePropertyExpressionContext.columnName(table,columnName);
        return this;
    }

    @Override
    public <TEntity> SQLAliasNativeLambdaExpressionContext<T1,TR> expression(Queryable<TEntity> subQuery) {
        sqlAliasNativePropertyExpressionContext.expression(subQuery.getClientQueryable());
        return this;
    }

    @Override
    public SQLAliasNativeLambdaExpressionContext<T1,TR> value(Object val) {
        sqlAliasNativePropertyExpressionContext.value(val);
        return this;
    }

    @Override
    public <T> SQLAliasNativeLambdaExpressionContext<T1, TR> collection(Collection<T> values) {
        sqlAliasNativePropertyExpressionContext.collection(values);
        return this;
    }

    @Override
    public SQLAliasNativeLambdaExpressionContext<T1,TR> format(Object formatVal) {
        sqlAliasNativePropertyExpressionContext.format(formatVal);
        return this;
    }

    @Override
    public SQLAliasNativeLambdaExpressionContext<T1,TR> setAlias(String alias) {
        sqlAliasNativePropertyExpressionContext.setAlias(alias);
        return this;
    }

    @Override
    public SQLAliasNativeLambdaExpressionContext<T1, TR> keepStyle() {
        sqlAliasNativePropertyExpressionContext.keepStyle();
        return this;
    }

    @Override
    public SQLAliasNativeLambdaExpressionContext<T1, TR> messageFormat() {
        sqlAliasNativePropertyExpressionContext.messageFormat();
        return this;
    }
}
