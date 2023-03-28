package com.easy.query.core.expression.segment.condition.predicate;

import com.easy.query.core.expression.sql.SqlEntityExpression;
import com.easy.query.core.expression.sql.SqlEntityTableExpression;
import com.easy.query.core.enums.SqlPredicateCompare;

/**
 * @FileName: ColumnValuePredicate.java
 * @Description: 文件说明
 * @Date: 2023/2/14 23:34
 * @author xuejiaming
 */
public class ColumnPredicate implements Predicate {
    private final SqlEntityTableExpression table;
    private final String propertyName;
    private final SqlPredicateCompare compare;
    private final SqlEntityExpression sqlEntityExpression;

    public ColumnPredicate(SqlEntityTableExpression table, String propertyName, SqlPredicateCompare compare, SqlEntityExpression sqlEntityExpression) {
        this.table = table;
        this.propertyName = propertyName;
        this.compare = compare;
        this.sqlEntityExpression = sqlEntityExpression;
    }

    @Override
    public String toSql() {
        String sqlColumnSegment = sqlEntityExpression.getSqlOwnerColumn(table,propertyName);
        return sqlColumnSegment +" "+ compare.getSql();
    }

    @Override
    public SqlEntityTableExpression getTable() {
        return table;
    }

    @Override
    public String getPropertyName() {
        return propertyName;
    }
}