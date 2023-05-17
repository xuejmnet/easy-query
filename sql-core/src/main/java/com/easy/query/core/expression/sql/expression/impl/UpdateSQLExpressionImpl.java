package com.easy.query.core.expression.sql.expression.impl;

import com.easy.query.core.context.QueryRuntimeContext;
import com.easy.query.core.basic.jdbc.parameter.SQLParameterCollector;
import com.easy.query.core.expression.sql.expression.EntityUpdateSQLExpression;
import com.easy.query.core.expression.sql.expression.factory.ExpressionFactory;
import com.easy.query.core.expression.segment.builder.SQLBuilderSegment;
import com.easy.query.core.expression.segment.builder.UpdateSetSQLBuilderSegment;
import com.easy.query.core.expression.segment.condition.AndPredicateSegment;
import com.easy.query.core.expression.segment.condition.PredicateSegment;
import com.easy.query.core.expression.sql.expression.EntityTableSQLExpression;
import com.easy.query.core.util.SQLExpressionUtil;
import com.easy.query.core.util.SQLSegmentUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * create time 2023/4/22 22:49
 * 文件说明
 *
 * @author xuejiaming
 */
public  class UpdateSQLExpressionImpl implements EntityUpdateSQLExpression {
    protected final QueryRuntimeContext runtimeContext;
    protected final SQLBuilderSegment setColumns;
    protected final PredicateSegment where;
    protected final List<EntityTableSQLExpression> tables=new ArrayList<>(1);

    public UpdateSQLExpressionImpl(QueryRuntimeContext runtimeContext, EntityTableSQLExpression table) {
        this.runtimeContext = runtimeContext;
        this.tables.add(table);
        this.setColumns = new UpdateSetSQLBuilderSegment();
        this.where = new AndPredicateSegment(true);
    }

    @Override
    public SQLBuilderSegment getSetColumns() {
        return setColumns;
    }

    @Override
    public PredicateSegment getWhere() {
        return where;
    }


    @Override
    public List<EntityTableSQLExpression> getTables() {
        return tables;
    }

    @Override
    public QueryRuntimeContext getRuntimeContext() {
        return runtimeContext;
    }


    @Override
    public String toSQL(SQLParameterCollector sqlParameterCollector) {
        SQLExpressionUtil.expressionInvokeRoot(sqlParameterCollector);
        if(SQLSegmentUtil.isEmpty(setColumns)){
            return null;
        }
        EntityTableSQLExpression easyTableSQLExpression = tables.get(0);
        String tableName = easyTableSQLExpression.getTableName();
        return "UPDATE " + tableName + " SET " + setColumns.toSQL(sqlParameterCollector) + " WHERE " +
                where.toSQL(sqlParameterCollector);
    }

    @Override
    public EntityUpdateSQLExpression cloneSQLExpression() {

        ExpressionFactory expressionFactory = runtimeContext.getExpressionFactory();
        EntityUpdateSQLExpression easyUpdateSQLExpression = expressionFactory.createEasyUpdateSQLExpression(runtimeContext,tables.get(0).cloneSQLExpression());
        if(SQLSegmentUtil.isNotEmpty(where)){
            where.copyTo(easyUpdateSQLExpression.getWhere());
        }if(SQLSegmentUtil.isNotEmpty(setColumns)){
            setColumns.copyTo(easyUpdateSQLExpression.getSetColumns());
        }
        return easyUpdateSQLExpression;
    }
}
