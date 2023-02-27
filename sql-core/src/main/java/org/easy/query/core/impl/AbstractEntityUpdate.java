package org.easy.query.core.impl;

import org.easy.query.core.abstraction.EasyExecutor;
import org.easy.query.core.abstraction.ExecutorContext;
import org.easy.query.core.expression.lambda.SqlExpression;
import org.easy.query.core.abstraction.metadata.ColumnMetadata;
import org.easy.query.core.abstraction.metadata.EntityMetadata;
import org.easy.query.core.expression.parser.abstraction.internal.ColumnSelector;
import org.easy.query.core.expression.parser.abstraction.SqlColumnSelector;
import org.easy.query.core.basic.api.EntityUpdate;
import org.easy.query.core.basic.sql.segment.builder.SqlSegmentBuilder;
import org.easy.query.core.basic.sql.segment.segment.SqlSegment;
import org.easy.query.core.enums.MultiTableTypeEnum;
import org.easy.query.core.exception.EasyQueryException;
import org.easy.query.core.expression.parser.impl.DefaultSqlColumnSelector;
import org.easy.query.core.expression.parser.impl.DefaultSqlColumnSetSelector;
import org.easy.query.core.query.builder.SqlTableInfo;
import org.easy.query.core.basic.sql.segment.segment.ColumnSegment;
import org.easy.query.core.basic.sql.segment.segment.UpdateColumnSegment;
import org.easy.query.core.util.StringUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @FileName: AbstractUpdate.java
 * @Description: 文件说明
 * @Date: 2023/2/24 22:06
 * @Created by xuejiaming
 */
public abstract class AbstractEntityUpdate<T> implements EntityUpdate<T> {
    protected final List<T> entities= new ArrayList<>();
    protected final Class<T> clazz;
    protected final EntityMetadata entityMetadata;
    protected final UpdateContext updateContext;

    public AbstractEntityUpdate(Collection<T> entities, UpdateContext updateContext) {
        if(entities==null||entities.isEmpty()){
            throw new EasyQueryException("不支持空对象的update");
        }
        this.entities.addAll(entities);

        this.clazz = (Class<T>)entities.iterator().next().getClass();
        this.updateContext = updateContext;
        this.entityMetadata = updateContext.getRuntimeContext().getEntityMetadataManager().getEntityMetadata(clazz);
        entityMetadata.checkTable();
        updateContext.addSqlTable(new SqlTableInfo(entityMetadata, null, 0, MultiTableTypeEnum.FROM));
    }

    @Override
    public long executeRows() {
        if (!entities.isEmpty()) {
//            EasyQueryRuntimeContext runtimeContext = updateContext.getRuntimeContext();
//            EntityMetadataManager entityMetadataManager = runtimeContext.getEntityMetadataManager();

            //如果没有指定where那么就使用主键作为更新条件
            SqlSegmentBuilder whereColumns = updateContext.getWhereColumns();
            if (whereColumns.isEmpty()) {
                Collection<String> keyProperties = entityMetadata.getKeyProperties();
                if(keyProperties.isEmpty()){
                    throw new EasyQueryException("对象:"+clazz.getSimpleName()+" 未找到主键信息");
                }
                for (String keyProperty : keyProperties) {
                    ColumnMetadata column = entityMetadata.getColumn(keyProperty);
                    String propertyName = column.getProperty().getName();
                    whereColumns.append(new UpdateColumnSegment(0, column.getName(),propertyName,updateContext));
                }
            }
            //如果用户没有指定set的列,那么就是set所有列,并且要去掉主键部分
            if (updateContext.getSetColumns().isEmpty()) {
                SqlExpression<SqlColumnSelector<T>> selectExpression = ColumnSelector::columnAll;
                DefaultSqlColumnSetSelector<T> columnSelector = new DefaultSqlColumnSetSelector<>(0, updateContext, updateContext.getSetColumns());
                selectExpression.apply(columnSelector);//获取set的值
                //非手动指定的那么需要移除where的那一部分
                List<SqlSegment> sqlSegments = updateContext.getSetColumns().getSqlSegments();
                HashSet<String> whereProperties = new HashSet<>(whereColumns.getSqlSegments().size());
                for (SqlSegment sqlSegment : whereColumns.getSqlSegments()) {
                    if(sqlSegment instanceof  UpdateColumnSegment){
                        whereProperties.add(((UpdateColumnSegment)sqlSegment).getPropertyName());
                    }
                }
                sqlSegments.removeIf(o->{
                    if(o instanceof UpdateColumnSegment){
                        String propertyName = ((UpdateColumnSegment) o).getPropertyName();
                        return whereProperties.contains(propertyName);
                    }
                    return false;
                });
            }

            String updateSql = toSql();
            System.out.println("更新sql："+updateSql);
            if (!StringUtil.isBlank(updateSql)) {
                EasyExecutor easyExecutor = updateContext.getRuntimeContext().getEasyExecutor();
                return easyExecutor.update(ExecutorContext.create(updateContext.getRuntimeContext()), clazz, updateSql, entities, updateContext.getProperties());
            }
        }
        return 0;
    }

    @Override
    public void executeRows(Long expectRow, String error) {

    }

    @Override
    public EntityUpdate<T> setColumns(boolean condition,SqlExpression<SqlColumnSelector<T>> columnSelectorExpression) {
        if(condition){
            DefaultSqlColumnSetSelector<T> columnSelector = new DefaultSqlColumnSetSelector<>(0, updateContext, updateContext.getSetColumns());
            columnSelectorExpression.apply(columnSelector);
        }
        return this;
    }

    @Override
    public EntityUpdate<T> setIgnoreColumns(boolean condition,SqlExpression<SqlColumnSelector<T>> columnSelectorExpression) {
        if(condition){
            DefaultSqlColumnSetSelector<T> columnSelector = new DefaultSqlColumnSetSelector<>(0, updateContext, updateContext.getSetIgnoreColumns());
            columnSelectorExpression.apply(columnSelector);
        }
        return this;
    }

    @Override
    public EntityUpdate<T> whereColumns(boolean condition,SqlExpression<SqlColumnSelector<T>> columnSelectorExpression) {
        if(condition){
            DefaultSqlColumnSetSelector<T> columnSelector = new DefaultSqlColumnSetSelector<>(0, updateContext, updateContext.getWhereColumns());
            columnSelectorExpression.apply(columnSelector);
        }
        return this;
    }
}