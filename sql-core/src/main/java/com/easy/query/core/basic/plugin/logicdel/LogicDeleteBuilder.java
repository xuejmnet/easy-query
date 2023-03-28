package com.easy.query.core.basic.plugin.logicdel;

import com.easy.query.core.expression.lambda.Property;
import com.easy.query.core.expression.lambda.SqlExpression;
import com.easy.query.core.expression.parser.abstraction.SqlColumnSetter;
import com.easy.query.core.expression.parser.abstraction.SqlPredicate;
import com.easy.query.core.metadata.EntityMetadata;
import com.easy.query.core.metadata.LogicDeleteMetadata;
import com.easy.query.core.util.EasyUtil;

/**
 * create time 2023/3/28 09:28
 * 文件说明
 *
 * @author xuejiaming
 */
public class LogicDeleteBuilder {
    private final EntityMetadata entityMetadata;
    private final String propertyName;
    private final Class<?> propertyType;

    public LogicDeleteBuilder(EntityMetadata entityMetadata,String propertyName,Class<?> propertyType){

        this.entityMetadata = entityMetadata;
        this.propertyName = propertyName;
        this.propertyType = propertyType;
    }

    /**
     * 配置软删除
     * @param queryFilterExpression
     * @param deletedSqlExpression
     */
    public void configure(SqlExpression<SqlPredicate<Object>> queryFilterExpression, SqlExpression<SqlColumnSetter<Object>> deletedSqlExpression){
        entityMetadata.setLogicDeleteMetadata(new LogicDeleteMetadata(propertyName,queryFilterExpression, deletedSqlExpression));
    }
    public Property<Object,?> getPropertyLambda(){
        return EasyUtil.getPropertyLambda(entityMetadata.getEntityClass(),propertyName,propertyType);
    }

    public EntityMetadata getEntityMetadata() {
        return entityMetadata;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Class<?> getPropertyType() {
        return propertyType;
    }
}