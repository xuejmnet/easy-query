package com.easy.query.core.api.def;

import com.easy.query.core.abstraction.EasySqlApiFactory;
import com.easy.query.core.basic.api.delete.EntityDeletable;
import com.easy.query.core.basic.api.delete.ExpressionDeletable;
import com.easy.query.core.basic.api.jdbc.EasyJdbcExecutor;
import com.easy.query.core.basic.api.jdbc.JdbcExecutor;
import com.easy.query.core.basic.api.select.impl.EasyQueryable;
import com.easy.query.core.basic.api.select.impl.EasyQueryable3;
import com.easy.query.core.abstraction.EasyQueryRuntimeContext;
import com.easy.query.core.enums.SqlUnionEnum;
import com.easy.query.core.exception.EasyQueryInvalidOperationException;
import com.easy.query.core.expression.sql.builder.factory.EasyExpressionBuilderFactory;
import com.easy.query.core.expression.sql.builder.EntityDeleteExpressionBuilder;
import com.easy.query.core.expression.sql.builder.EntityInsertExpressionBuilder;
import com.easy.query.core.expression.sql.builder.EntityQueryExpressionBuilder;
import com.easy.query.core.expression.sql.builder.EntityTableExpressionBuilder;
import com.easy.query.core.expression.sql.builder.EntityUpdateExpressionBuilder;
import com.easy.query.core.expression.sql.builder.ExpressionContext;
import com.easy.query.core.metadata.EntityMetadata;
import com.easy.query.core.basic.api.update.EntityUpdatable;
import com.easy.query.core.basic.api.update.ExpressionUpdatable;
import com.easy.query.core.basic.api.delete.impl.EasyEmptyEntityDeletable;
import com.easy.query.core.basic.api.delete.impl.EasyEntityDeletable;
import com.easy.query.core.basic.api.delete.impl.EasyExpressionDeletable;
import com.easy.query.core.basic.api.insert.EasyEmptyInsertable;
import com.easy.query.core.basic.api.insert.EasyInsertable;
import com.easy.query.core.basic.api.insert.Insertable;
import com.easy.query.core.basic.api.select.Queryable3;
import com.easy.query.core.basic.api.select.Queryable4;
import com.easy.query.core.basic.api.select.impl.EasyQueryable2;
import com.easy.query.core.basic.api.select.Queryable;
import com.easy.query.core.basic.api.select.Queryable2;
import com.easy.query.core.basic.api.select.impl.EasyQueryable4;
import com.easy.query.core.basic.api.update.impl.EasyEmptyEntityUpdatable;
import com.easy.query.core.basic.api.update.impl.EasyEntityUpdatable;
import com.easy.query.core.basic.api.update.impl.EasyExpressionUpdatable;
import com.easy.query.core.enums.MultiTableTypeEnum;
import com.easy.query.core.util.EasyCollectionUtil;
import com.easy.query.core.util.EasyUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @FileName: DefaultEasySqlApiFactory.java
 * @Description: 文件说明
 * @Date: 2023/3/6 08:27
 * @author xuejiaming
 */
public class DefaultEasySqlApiFactory implements EasySqlApiFactory {
    private final EasyExpressionBuilderFactory easySqlExpressionFactory;

    public DefaultEasySqlApiFactory(EasyExpressionBuilderFactory easySqlExpressionFactory){
        this.easySqlExpressionFactory = easySqlExpressionFactory;
    }

    @Override
    public JdbcExecutor createJdbcExecutor(EasyQueryRuntimeContext runtimeContext) {
        return new EasyJdbcExecutor(runtimeContext);
    }

    @Override
    public <T> Queryable<T> createQueryable(Class<T> clazz, EasyQueryRuntimeContext runtimeContext, String alias) {
        ExpressionContext queryExpressionContext =easySqlExpressionFactory.createExpressionContext(runtimeContext,alias);
        EntityQueryExpressionBuilder entityQueryExpression = easySqlExpressionFactory.createEntityQueryExpression(queryExpressionContext);
        EntityMetadata entityMetadata =runtimeContext.getEntityMetadataManager().getEntityMetadata(clazz);
        int tableIndex = EasyUtil.getNextTableIndex(entityQueryExpression);;
        EntityTableExpressionBuilder sqlTable =easySqlExpressionFactory.createEntityTableExpression(entityMetadata,  tableIndex,queryExpressionContext.createTableAlias(), MultiTableTypeEnum.FROM,runtimeContext);
        entityQueryExpression.addSqlEntityTableExpression(sqlTable);
        return new EasyQueryable<>(clazz,entityQueryExpression);
    }

    @Override
    public <T> Queryable<T> createQueryable(String sql, Class<T> clazz, EasyQueryRuntimeContext runtimeContext, String alias) {

        ExpressionContext queryExpressionContext =easySqlExpressionFactory.createExpressionContext(runtimeContext,alias);
        EntityQueryExpressionBuilder innerSqlEntityQueryExpression = easySqlExpressionFactory.createAnonymousQueryExpression(sql,queryExpressionContext);
        EntityMetadata entityMetadata =runtimeContext.getEntityMetadataManager().getEntityMetadata(clazz);
        int tableIndex = EasyUtil.getNextTableIndex(innerSqlEntityQueryExpression);
        EntityTableExpressionBuilder sqlTable =easySqlExpressionFactory.createAnonymousEntityTableExpression(entityMetadata,  tableIndex,queryExpressionContext.createTableAlias(), MultiTableTypeEnum.FROM,innerSqlEntityQueryExpression);
//        //todo
//       innerSqlEntityQueryExpression.addSqlEntityTableExpression(sqlTable);


        EntityQueryExpressionBuilder sqlEntityQueryExpression = easySqlExpressionFactory.createEntityQueryExpression(queryExpressionContext);
        sqlEntityQueryExpression.addSqlEntityTableExpression(sqlTable);
        return new EasyQueryable<>(clazz,sqlEntityQueryExpression);
    }

    @Override
    public <T> Queryable<T> cloneQueryable(Queryable<T> source) {
        EntityQueryExpressionBuilder sqlEntityExpressionBuilder = source.getSqlEntityExpressionBuilder();
        EntityQueryExpressionBuilder entityQueryExpressionBuilder = sqlEntityExpressionBuilder.cloneEntityExpressionBuilder();
        return new EasyQueryable<>(source.queryClass(),entityQueryExpressionBuilder);
    }

    /**
     * 判断单表不需要匿名多表才需要
     * @param clazz
     * @param entityQueryExpressionBuilder
     * @return
     * @param <T>
     */
    @Override
    public <T> Queryable<T> createQueryable(Class<T> clazz, EntityQueryExpressionBuilder entityQueryExpressionBuilder) {
        ExpressionContext queryExpressionContext = entityQueryExpressionBuilder.getExpressionContext();
        EntityQueryExpressionBuilder sqlEntityQueryExpression = easySqlExpressionFactory.createEntityQueryExpression(queryExpressionContext);
        EntityMetadata entityMetadata = queryExpressionContext.getRuntimeContext().getEntityMetadataManager().getEntityMetadata(clazz);
        EntityTableExpressionBuilder anonymousTable = easySqlExpressionFactory.createAnonymousEntityTableExpression(entityMetadata, 0, queryExpressionContext.createTableAlias(), MultiTableTypeEnum.FROM, entityQueryExpressionBuilder);
        sqlEntityQueryExpression.addSqlEntityTableExpression(anonymousTable);
        return new EasyQueryable<>(clazz,sqlEntityQueryExpression);
    }

    @Override
    public <T> Queryable<T> createUnionQueryable(EasyQueryRuntimeContext runtimeContext, SqlUnionEnum sqlUnion, Collection<Queryable<T>> unionQueries) {
        if(EasyCollectionUtil.isEmpty(unionQueries)){
            throw new EasyQueryInvalidOperationException("cant create queryable with queryable union or union all");
        }
        List<EntityQueryExpressionBuilder> entityQueryExpressionBuilders = new ArrayList<>(unionQueries.size());
        Iterator<Queryable<T>> queryableIterator = unionQueries.iterator();
        Queryable<T> firstQueryable = queryableIterator.next();
        Class<T> queryClass = firstQueryable.queryClass();
        EntityMetadata entityMetadata = runtimeContext.getEntityMetadataManager().getEntityMetadata(queryClass);
        EntityQueryExpressionBuilder firstQueryableSqlEntityExpressionBuilder = firstQueryable.getSqlEntityExpressionBuilder();
        ExpressionContext queryExpressionContext = firstQueryableSqlEntityExpressionBuilder.getExpressionContext();


        EntityQueryExpressionBuilder sqlEntityExpressionBuilder = firstQueryable.getSqlEntityExpressionBuilder();
        entityQueryExpressionBuilders.add(sqlEntityExpressionBuilder);
        while (queryableIterator.hasNext()){
            Queryable<T> unionQuery = queryableIterator.next();
            EntityQueryExpressionBuilder unionSqlEntityExpressionBuilder = unionQuery.getSqlEntityExpressionBuilder();
            entityQueryExpressionBuilders.add(unionSqlEntityExpressionBuilder);
        }
        EntityQueryExpressionBuilder innerSqlEntityQueryExpression = easySqlExpressionFactory.createAnonymousUnionQueryExpression(entityQueryExpressionBuilders,queryExpressionContext,sqlUnion);


        int tableIndex = EasyUtil.getNextTableIndex(innerSqlEntityQueryExpression);
        EntityTableExpressionBuilder sqlTable =easySqlExpressionFactory.createAnonymousEntityTableExpression(entityMetadata,  tableIndex,queryExpressionContext.createTableAlias(), MultiTableTypeEnum.FROM,innerSqlEntityQueryExpression);
//        //todo
//       innerSqlEntityQueryExpression.addSqlEntityTableExpression(sqlTable);


        EntityQueryExpressionBuilder sqlEntityQueryExpression = easySqlExpressionFactory.createEntityQueryExpression(queryExpressionContext);
        sqlEntityQueryExpression.addSqlEntityTableExpression(sqlTable);
        return new EasyQueryable<>(queryClass,sqlEntityQueryExpression);
    }

    @Override
    public <T1, T2> Queryable2<T1, T2> createQueryable2(Class<T1> t1Class, Class<T2> t2Class, MultiTableTypeEnum selectTableInfoType, EntityQueryExpressionBuilder sqlEntityExpression) {

        EntityMetadata entityMetadata = sqlEntityExpression.getRuntimeContext().getEntityMetadataManager().getEntityMetadata(t2Class);

        int tableIndex =  EasyUtil.getNextTableIndex(sqlEntityExpression);
        ExpressionContext queryExpressionContext = sqlEntityExpression.getExpressionContext();
        EntityTableExpressionBuilder sqlTable =easySqlExpressionFactory.createEntityTableExpression(entityMetadata,  tableIndex,queryExpressionContext.createTableAlias(), selectTableInfoType,queryExpressionContext.getRuntimeContext());
        sqlEntityExpression.addSqlEntityTableExpression(sqlTable);

        return new EasyQueryable2<>(t1Class,t2Class,sqlEntityExpression);
    }

    /**
     * 只有当join外部的queryable的时候外部的queryable是独立的sql expression context
     * @param t1Class
     * @param joinQueryable
     * @param selectTableInfoType
     * @param sqlEntityExpression
     * @return
     * @param <T1> 左表对象
     * @param <T2> 右表对象
     */
    @Override
    public <T1, T2> Queryable2<T1, T2> createQueryable2(Class<T1> t1Class, Queryable<T2> joinQueryable, MultiTableTypeEnum selectTableInfoType, EntityQueryExpressionBuilder sqlEntityExpression) {

        Class<T2> t2Class = joinQueryable.queryClass();

        EntityMetadata entityMetadata = sqlEntityExpression.getRuntimeContext().getEntityMetadataManager().getEntityMetadata(t2Class);
        EntityQueryExpressionBuilder joinQueryableSqlEntityExpression = joinQueryable.getSqlEntityExpressionBuilder();

        int tableIndex =  EasyUtil.getNextTableIndex(sqlEntityExpression);
        ExpressionContext queryExpressionContext = sqlEntityExpression.getExpressionContext();
        EntityTableExpressionBuilder sqlTable =easySqlExpressionFactory.createAnonymousEntityTableExpression(entityMetadata,  tableIndex,queryExpressionContext.createTableAlias(), selectTableInfoType,joinQueryableSqlEntityExpression);
        sqlEntityExpression.addSqlEntityTableExpression(sqlTable);

        return new EasyQueryable2<>(t1Class,t2Class,sqlEntityExpression);
    }

    @Override
    public <T1, T2, T3> Queryable3<T1, T2, T3> createQueryable3(Class<T1> t1Class, Class<T2> t2Class, Class<T3> t3Class, MultiTableTypeEnum selectTableInfoType, EntityQueryExpressionBuilder sqlEntityExpression) {

        EntityMetadata entityMetadata = sqlEntityExpression.getRuntimeContext().getEntityMetadataManager().getEntityMetadata(t3Class);
        int tableIndex =  EasyUtil.getNextTableIndex(sqlEntityExpression);
        ExpressionContext queryExpressionContext = sqlEntityExpression.getExpressionContext();
        EntityTableExpressionBuilder sqlTable =easySqlExpressionFactory.createEntityTableExpression(entityMetadata,  tableIndex,queryExpressionContext.createTableAlias(), selectTableInfoType,queryExpressionContext.getRuntimeContext());
        sqlEntityExpression.addSqlEntityTableExpression(sqlTable);

        return new EasyQueryable3<>(t1Class,t2Class,t3Class,sqlEntityExpression);
    }

    @Override
    public <T1, T2, T3> Queryable3<T1, T2, T3> createQueryable3(Class<T1> t1Class, Class<T2> t2Class, Queryable<T3> joinQueryable, MultiTableTypeEnum selectTableInfoType, EntityQueryExpressionBuilder sqlEntityExpression) {

        Class<T3> t3Class = joinQueryable.queryClass();

        EntityMetadata entityMetadata = sqlEntityExpression.getRuntimeContext().getEntityMetadataManager().getEntityMetadata(t3Class);
        EntityQueryExpressionBuilder joinQueryableSqlEntityExpression = joinQueryable.getSqlEntityExpressionBuilder();

        int tableIndex =  EasyUtil.getNextTableIndex(sqlEntityExpression);
        ExpressionContext queryExpressionContext = sqlEntityExpression.getExpressionContext();
        EntityTableExpressionBuilder sqlTable =easySqlExpressionFactory.createAnonymousEntityTableExpression(entityMetadata,  tableIndex,queryExpressionContext.createTableAlias(), selectTableInfoType,joinQueryableSqlEntityExpression);
        sqlEntityExpression.addSqlEntityTableExpression(sqlTable);

        return new EasyQueryable3<>(t1Class,t2Class,t3Class,sqlEntityExpression);
    }

    @Override
    public <T1, T2, T3, T4> Queryable4<T1, T2, T3, T4> createQueryable4(Class<T1> t1Class, Class<T2> t2Class, Class<T3> t3Class, Class<T4> t4Class, MultiTableTypeEnum selectTableInfoType, EntityQueryExpressionBuilder sqlEntityExpression) {

        EntityMetadata entityMetadata = sqlEntityExpression.getRuntimeContext().getEntityMetadataManager().getEntityMetadata(t4Class);
        int tableIndex =  EasyUtil.getNextTableIndex(sqlEntityExpression);
        ExpressionContext queryExpressionContext = sqlEntityExpression.getExpressionContext();
        EntityTableExpressionBuilder sqlTable =easySqlExpressionFactory.createEntityTableExpression(entityMetadata,  tableIndex,queryExpressionContext.createTableAlias(), selectTableInfoType,queryExpressionContext.getRuntimeContext());
        sqlEntityExpression.addSqlEntityTableExpression(sqlTable);

        return new EasyQueryable4<>(t1Class,t2Class,t3Class,t4Class,sqlEntityExpression);
    }

    @Override
    public <T1, T2, T3, T4> Queryable4<T1, T2, T3, T4> createQueryable4(Class<T1> t1Class, Class<T2> t2Class, Class<T3> t3Class, Queryable<T4> joinQueryable, MultiTableTypeEnum selectTableInfoType, EntityQueryExpressionBuilder sqlEntityExpression) {

        Class<T4> t4Class = joinQueryable.queryClass();

        EntityMetadata entityMetadata = sqlEntityExpression.getRuntimeContext().getEntityMetadataManager().getEntityMetadata(t4Class);
        EntityQueryExpressionBuilder joinQueryableSqlEntityExpression = joinQueryable.getSqlEntityExpressionBuilder();

        int tableIndex =  EasyUtil.getNextTableIndex(sqlEntityExpression);
        ExpressionContext queryExpressionContext = sqlEntityExpression.getExpressionContext();
        EntityTableExpressionBuilder sqlTable =easySqlExpressionFactory.createAnonymousEntityTableExpression(entityMetadata,  tableIndex,queryExpressionContext.createTableAlias(), selectTableInfoType,joinQueryableSqlEntityExpression);
        sqlEntityExpression.addSqlEntityTableExpression(sqlTable);

        return new EasyQueryable4<>(t1Class,t2Class,t3Class,t4Class,sqlEntityExpression);
    }

    @Override
    public <T> Insertable<T> createInsertable(Class<T> clazz,EasyQueryRuntimeContext runtimeContext,String alias) {
        ExpressionContext expressionContext = easySqlExpressionFactory.createExpressionContext(runtimeContext, alias);
        EntityInsertExpressionBuilder entityInsertExpression = easySqlExpressionFactory.createEntityInsertExpression(expressionContext);
        return createInsertable(clazz,entityInsertExpression);
    }

    @Override
    public <T> Insertable<T> createEmptyInsertable(EasyQueryRuntimeContext runtimeContext, String alias) {
        ExpressionContext expressionContext = easySqlExpressionFactory.createExpressionContext(runtimeContext, alias);
        EntityInsertExpressionBuilder entityInsertExpression = easySqlExpressionFactory.createEntityInsertExpression(expressionContext);
        return new EasyEmptyInsertable<>(entityInsertExpression);
    }

    @Override
    public <T> Insertable<T> createInsertable(Class<T> clazz, EntityInsertExpressionBuilder entityInsertExpression) {
        return new EasyInsertable<>(clazz, entityInsertExpression);
    }

    @Override
    public <T> EntityUpdatable<T> createEmptyEntityUpdatable() {
        return new EasyEmptyEntityUpdatable<>();
    }

    @Override
    public <T> EntityUpdatable<T> createEntityUpdatable(T entity, EasyQueryRuntimeContext runtimeContext, String alias) {
        return createEntityUpdatable(Collections.singletonList(entity),runtimeContext,alias);
    }
    @Override
    public <T> EntityUpdatable<T> createEntityUpdatable(Collection<T> entities, EasyQueryRuntimeContext runtimeContext, String alias) {
        ExpressionContext sqlExpressionContext = easySqlExpressionFactory.createExpressionContext(runtimeContext, alias);
        EntityUpdateExpressionBuilder entityUpdateExpression = easySqlExpressionFactory.createEntityUpdateExpression(sqlExpressionContext,false);
        return new EasyEntityUpdatable<>(entities,entityUpdateExpression);
    }


    @Override
    public <T> ExpressionUpdatable<T> createExpressionUpdatable(Class<T> entityClass, EasyQueryRuntimeContext runtimeContext, String alias) {
        ExpressionContext sqlExpressionContext = easySqlExpressionFactory.createExpressionContext(runtimeContext, alias);
        EntityUpdateExpressionBuilder entityUpdateExpression = easySqlExpressionFactory.createEntityUpdateExpression(sqlExpressionContext,true);
        return new EasyExpressionUpdatable<>(entityClass,entityUpdateExpression);
    }

    @Override
    public <T> EntityDeletable<T> createEmptyEntityDeletable() {
        return new EasyEmptyEntityDeletable<>();
    }

    @Override
    public <T> EntityDeletable<T> createEntityDeletable(T entity, EasyQueryRuntimeContext runtimeContext, String alias) {
        return createEntityDeletable(Collections.singletonList(entity),runtimeContext,alias);
    }

    @Override
    public <T> EntityDeletable<T> createEntityDeletable(Collection<T> entities, EasyQueryRuntimeContext runtimeContext, String alias) {
        ExpressionContext sqlExpressionContext = easySqlExpressionFactory.createExpressionContext(runtimeContext, alias);
        EntityDeleteExpressionBuilder entityDeleteExpression = easySqlExpressionFactory.createEntityDeleteExpression(sqlExpressionContext,false);
        return new EasyEntityDeletable<>(entities,entityDeleteExpression);
    }

    @Override
    public <T> ExpressionDeletable<T> createExpressionDeletable(Class<T> entityClass, EasyQueryRuntimeContext runtimeContext, String alias) {
        ExpressionContext expressionContext = easySqlExpressionFactory.createExpressionContext(runtimeContext, alias);
        EntityDeleteExpressionBuilder entityDeleteExpression = easySqlExpressionFactory.createEntityDeleteExpression(expressionContext,true);
        return new EasyExpressionDeletable<>(entityClass,entityDeleteExpression);
    }
}
