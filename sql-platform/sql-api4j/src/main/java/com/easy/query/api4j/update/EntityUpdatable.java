package com.easy.query.api4j.update;

import com.easy.query.api4j.sql.SQLColumnConfigurer;
import com.easy.query.api4j.sql.SQLColumnOnlySelector;
import com.easy.query.api4j.sql.impl.SQLColumnConfigurerImpl;
import com.easy.query.api4j.sql.impl.SQLColumnOnlySelectorImpl;
import com.easy.query.core.basic.api.internal.ConfigureVersionable;
import com.easy.query.core.basic.api.internal.SQLExecuteStrategy;
import com.easy.query.core.basic.api.update.ClientEntityUpdatable;
import com.easy.query.core.basic.api.update.Updatable;
import com.easy.query.core.expression.lambda.SQLExpression1;

/**
 * @author xuejiaming
 * @FileName: EntityUpdate.java
 * @Description: 文件说明
 * @Date: 2023/2/24 23:22
 */
public interface EntityUpdatable<T> extends Updatable<T, EntityUpdatable<T>>, SQLExecuteStrategy<EntityUpdatable<T>>,
        ConfigureVersionable<EntityUpdatable<T>> {
    ClientEntityUpdatable<T> getClientUpdate();
    default EntityUpdatable<T> columnConfigure(SQLExpression1<SQLColumnConfigurer<T>> columnConfigureExpression){
        getClientUpdate().columnConfigure(configurer->{
            columnConfigureExpression.apply(new SQLColumnConfigurerImpl<>(configurer));
        });
        return this;
    }

    /**
     * 只更新列
     * @param columnSelectorExpression
     * @return
     */
    default EntityUpdatable<T> setColumns(SQLExpression1<SQLColumnOnlySelector<T>> columnSelectorExpression) {
        getClientUpdate().setColumns(selector -> {
            columnSelectorExpression.apply(new SQLColumnOnlySelectorImpl<>(selector));
        });
        return this;
    }

    default EntityUpdatable<T> setColumns(boolean condition, SQLExpression1<SQLColumnOnlySelector<T>> columnSelectorExpression) {
        getClientUpdate().setColumns(condition, selector -> {
            columnSelectorExpression.apply(new SQLColumnOnlySelectorImpl<>(selector));
        });
        return this;
    }

    default EntityUpdatable<T> setIgnoreColumns(SQLExpression1<SQLColumnOnlySelector<T>> columnSelectorExpression) {
        getClientUpdate().setIgnoreColumns(true, selector -> {
            columnSelectorExpression.apply(new SQLColumnOnlySelectorImpl<>(selector));
        });
        return this;
    }

    default EntityUpdatable<T> setIgnoreColumns(boolean condition, SQLExpression1<SQLColumnOnlySelector<T>> columnSelectorExpression) {
        getClientUpdate().setIgnoreColumns(condition, selector -> {
            columnSelectorExpression.apply(new SQLColumnOnlySelectorImpl<>(selector));
        });
        return this;
    }

    default EntityUpdatable<T> whereColumns(SQLExpression1<SQLColumnOnlySelector<T>> columnSelectorExpression) {
        getClientUpdate().whereColumns(selector -> {
            columnSelectorExpression.apply(new SQLColumnOnlySelectorImpl<>(selector));
        });
        return this;
    }

    default EntityUpdatable<T> whereColumns(boolean condition, SQLExpression1<SQLColumnOnlySelector<T>> columnSelectorExpression) {
        getClientUpdate().whereColumns(condition, selector -> {
            columnSelectorExpression.apply(new SQLColumnOnlySelectorImpl<>(selector));
        });
        return this;
    }
    default String toSQL(Object entity) {
        return getClientUpdate().toSQL(entity);
    }
}
