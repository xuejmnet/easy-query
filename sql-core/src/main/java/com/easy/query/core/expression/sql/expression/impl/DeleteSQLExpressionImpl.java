package com.easy.query.core.expression.sql.expression.impl;

import com.easy.query.core.context.QueryRuntimeContext;
import com.easy.query.core.basic.jdbc.parameter.ToSQLContext;
import com.easy.query.core.expression.sql.expression.EntityDeleteSQLExpression;
import com.easy.query.core.expression.sql.expression.factory.ExpressionFactory;
import com.easy.query.core.expression.segment.condition.AndPredicateSegment;
import com.easy.query.core.expression.segment.condition.PredicateSegment;
import com.easy.query.core.expression.sql.expression.EntityTableSQLExpression;
import com.easy.query.core.util.EasySQLExpressionUtil;
import com.easy.query.core.util.EasySQLSegmentUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * create time 2023/4/23 07:54
 * 文件说明
 *
 * @author xuejiaming
 */
public  class DeleteSQLExpressionImpl implements EntityDeleteSQLExpression {

    protected final PredicateSegment where;
    protected final List<EntityTableSQLExpression> tables=new ArrayList<>(1);
    private final EntitySQLExpressionMetadata entitySQLExpressionMetadata;

    public DeleteSQLExpressionImpl(EntitySQLExpressionMetadata entitySQLExpressionMetadata, EntityTableSQLExpression table) {
        this.entitySQLExpressionMetadata = entitySQLExpressionMetadata;
        this.tables.add(table);
        this.where = new AndPredicateSegment(true);
    }


    @Override
    public EntitySQLExpressionMetadata getExpressionMetadata() {
        return entitySQLExpressionMetadata;
    }

    @Override
    public QueryRuntimeContext getRuntimeContext() {
        return entitySQLExpressionMetadata.getRuntimeContext();
    }

    @Override
    public List<EntityTableSQLExpression> getTables() {
        return tables;
    }

    @Override
    public PredicateSegment getWhere() {
        return where;
    }


    @Override
    public String toSQL(ToSQLContext toSQLContext) {
        
        EasySQLExpressionUtil.expressionInvokeRoot(toSQLContext);
        EntityTableSQLExpression easyTableSQLExpression = tables.get(0);
        String tableName = easyTableSQLExpression.toSQL(toSQLContext);

        return "DELETE FROM " + tableName +
                " WHERE " +
                where.toSQL(toSQLContext);
    }

    @Override
    public EntityDeleteSQLExpression cloneSQLExpression() {

        ExpressionFactory expressionFactory = entitySQLExpressionMetadata.getRuntimeContext().getExpressionFactory();
        EntityDeleteSQLExpression easyDeleteSQLExpression = expressionFactory.createEasyDeleteSQLExpression(entitySQLExpressionMetadata, tables.get(0).cloneSQLExpression());
        if(EasySQLSegmentUtil.isNotEmpty(where)){
            where.copyTo(easyDeleteSQLExpression.getWhere());
        }
        return easyDeleteSQLExpression;
    }
}
