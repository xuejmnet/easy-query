package com.easy.query.core.expression.builder.impl;

import com.easy.query.core.context.QueryRuntimeContext;
import com.easy.query.core.expression.builder.Setter;
import com.easy.query.core.expression.lambda.SQLExpression1;
import com.easy.query.core.expression.parser.core.available.TableAvailable;
import com.easy.query.core.expression.parser.core.base.scec.core.SQLNativeChainExpressionContextImpl;
import com.easy.query.core.expression.segment.InsertUpdateSetColumnSQLSegment;
import com.easy.query.core.expression.segment.SQLNativeSegment;
import com.easy.query.core.expression.segment.builder.SQLBuilderSegment;
import com.easy.query.core.expression.segment.factory.SQLSegmentFactory;
import com.easy.query.core.expression.segment.impl.InsertUpdateColumnConfigureSegmentImpl;
import com.easy.query.core.expression.segment.impl.UpdateColumnSegmentImpl;
import com.easy.query.core.expression.segment.impl.UpdateColumnSetSegmentImpl;
import com.easy.query.core.expression.segment.impl.UpdateColumnSetSelfSegmentImpl;
import com.easy.query.core.expression.segment.scec.context.SQLNativeExpressionContext;
import com.easy.query.core.expression.segment.scec.context.SQLNativeExpressionContextImpl;
import com.easy.query.core.expression.sql.builder.EntityExpressionBuilder;
import com.easy.query.core.func.SQLFunction;

import java.util.Objects;

/**
 * create time 2023/12/8 10:08
 * 文件说明
 *
 * @author xuejiaming
 */
public class SetterImpl implements Setter {
    protected final EntityExpressionBuilder entityExpressionBuilder;
    protected final SQLBuilderSegment sqlBuilderSegment;
    protected final QueryRuntimeContext runtimeContext;
    protected final SQLSegmentFactory sqlSegmentFactory;

    public SetterImpl(EntityExpressionBuilder entityExpressionBuilder, SQLBuilderSegment sqlBuilderSegment) {

        this.entityExpressionBuilder = entityExpressionBuilder;
        this.runtimeContext = entityExpressionBuilder.getRuntimeContext();
        this.sqlSegmentFactory = runtimeContext.getSQLSegmentFactory();
        this.sqlBuilderSegment = sqlBuilderSegment;
    }

    @Override
    public Setter set(boolean condition, TableAvailable table, String property, Object val) {
        if (condition) {
            sqlBuilderSegment.append(new UpdateColumnSetSegmentImpl(table, property, val, entityExpressionBuilder.getRuntimeContext()));
        }
        return this;
    }

    @Override
    public Setter setWithColumn(boolean condition, TableAvailable table, String property1, String property2) {
        if (condition) {
            sqlBuilderSegment.append(new UpdateColumnSetSelfSegmentImpl(table, property1, table, property2, entityExpressionBuilder.getRuntimeContext()));
        }
        return this;
    }


    private void setSelf(boolean increment, TableAvailable table, String property, Number val) {

        InsertUpdateSetColumnSQLSegment columnWithSelfSegment = sqlSegmentFactory.createColumnWithSelfSegment(increment, table, property, val, entityExpressionBuilder.getRuntimeContext());
        sqlBuilderSegment.append(columnWithSelfSegment);
    }

    @Override
    public Setter setIncrementNumber(boolean condition, TableAvailable table, String property, Number val) {

        if (condition) {
            setSelf(true, table, property, val);
        }
        return this;
    }

    @Override
    public Setter setDecrementNumber(boolean condition, TableAvailable table, String property, Number val) {
        if (condition) {
            setSelf(false, table, property, val);
        }
        return this;
    }

    @Override
    public Setter sqlNativeSegment(TableAvailable table, String property, String sqlSegment, SQLExpression1<SQLNativeExpressionContext> contextConsume) {
        Objects.requireNonNull(contextConsume, "sql native context consume cannot be null");
        SQLNativeExpressionContextImpl sqlNativeExpressionContext = new SQLNativeExpressionContextImpl(entityExpressionBuilder.getExpressionContext(), runtimeContext);
//        sqlNativeExpressionContext.expression(table,property);
        contextConsume.apply(sqlNativeExpressionContext);
        InsertUpdateColumnConfigureSegmentImpl insertUpdateColumnConfigureSegment = new InsertUpdateColumnConfigureSegmentImpl(new UpdateColumnSegmentImpl(table, property, runtimeContext), runtimeContext, sqlSegment, sqlNativeExpressionContext);
        sqlBuilderSegment.append(insertUpdateColumnConfigureSegment);
        return this;
    }

    @Override
    public Setter sqlNativeSegment(String sqlSegment, SQLExpression1<SQLNativeExpressionContext> contextConsume) {

        Objects.requireNonNull(contextConsume, "sql native context consume cannot be null");
        SQLNativeExpressionContextImpl sqlNativeExpressionContext = new SQLNativeExpressionContextImpl(entityExpressionBuilder.getExpressionContext(), runtimeContext);
        contextConsume.apply(sqlNativeExpressionContext);
        SQLNativeSegment columnSegment = sqlSegmentFactory.createSQLNativeSegment(runtimeContext, sqlSegment, sqlNativeExpressionContext);
        sqlBuilderSegment.append(columnSegment);
        return this;
    }

    @Override
    public Setter setFunc(TableAvailable table, String property, SQLFunction sqlFunction) {

        SQLNativeExpressionContextImpl sqlNativeExpressionContext = new SQLNativeExpressionContextImpl(entityExpressionBuilder.getExpressionContext(),runtimeContext);
        sqlFunction.consume(new SQLNativeChainExpressionContextImpl(table,sqlNativeExpressionContext));
        sqlFunction.consume(new SQLNativeChainExpressionContextImpl(table,sqlNativeExpressionContext));
        String sqlSegment = sqlFunction.sqlSegment(table);
        InsertUpdateColumnConfigureSegmentImpl insertUpdateColumnConfigureSegment = new InsertUpdateColumnConfigureSegmentImpl(new UpdateColumnSegmentImpl(table, property, runtimeContext), runtimeContext, sqlSegment, sqlNativeExpressionContext);
        sqlBuilderSegment.append(insertUpdateColumnConfigureSegment);
        return this;
    }

    @Override
    public QueryRuntimeContext getRuntimeContext() {
        return runtimeContext;
    }
}
