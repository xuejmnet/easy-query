package com.easy.query.api4kt.sql;

import com.easy.query.api4kt.select.KtQueryable;
import com.easy.query.api4kt.sql.core.SQLAsLambdaKtNative;
import com.easy.query.api4kt.sql.core.available.SQLKtLambdaFuncAvailable;
import com.easy.query.api4kt.sql.impl.SQLKtColumnAsSelectorImpl;
import com.easy.query.api4kt.util.EasyKtLambdaUtil;
import com.easy.query.core.context.QueryRuntimeContext;
import com.easy.query.core.expression.func.ColumnPropertyFunction;
import com.easy.query.core.expression.lambda.SQLExpression1;
import com.easy.query.core.expression.lambda.SQLFuncExpression;
import com.easy.query.core.expression.parser.core.EntitySQLTableOwner;
import com.easy.query.core.expression.parser.core.available.TableAvailable;
import com.easy.query.core.expression.parser.core.base.ColumnAsSelector;
import com.easy.query.core.expression.segment.CloneableSQLSegment;
import com.easy.query.core.expression.sql.builder.ExpressionContext;
import com.easy.query.core.func.ACSSelector;
import com.easy.query.core.util.EasyCollectionUtil;
import kotlin.reflect.KProperty1;

import java.util.Collection;

/**
 * @author xuejiaming
 * @Description: 文件说明
 * @Date: 2023/2/6 22:58
 */
public interface SQLKtColumnAsSelector<T1, TR> extends EntitySQLTableOwner<T1>, SQLKtLambdaFuncAvailable<T1>, SQLAsLambdaKtNative<T1,TR,SQLKtColumnAsSelector<T1, TR>> {
    ColumnAsSelector<T1, TR> getColumnAsSelector();

    default QueryRuntimeContext getRuntimeContext() {
        return getColumnAsSelector().getRuntimeContext();
    }
    default ExpressionContext getExpressionContext() {
        return getColumnAsSelector().getExpressionContext();
    }

    default TableAvailable getTable() {
        return getColumnAsSelector().getTable();
    }


    default <TProperty> SQLKtColumnAsSelector<T1, TR> columns(Collection<KProperty1<? super T1, TProperty>> columns) {
        if(EasyCollectionUtil.isNotEmpty(columns)){
            for (KProperty1<? super T1, TProperty> column : columns) {
                this.column(column);
            }
        }
        return this;
    }

    default SQLKtColumnAsSelector<T1, TR> groupKeys(int index) {
        getColumnAsSelector().groupKeys(index);
        return this;
    }
    default <TProperty> SQLKtColumnAsSelector<T1, TR> groupKeysAs(int index, KProperty1<? super TR, TProperty> alias) {
        getColumnAsSelector().groupKeysAs(index,EasyKtLambdaUtil.getPropertyName(alias));
        return this;
    }
    default SQLKtColumnAsSelector<T1, TR> groupKeysAs(int index, String alias) {
        getColumnAsSelector().groupKeysAs(index,alias);
        return this;
    }
    default <TProperty> SQLKtColumnAsSelector<T1, TR> column(KProperty1<? super T1, TProperty> column) {
        getColumnAsSelector().column(EasyKtLambdaUtil.getPropertyName(column));
        return this;
    }

    default <TIncludeSource,TIncludeResult> SQLKtColumnAsSelector<T1, TR> columnInclude(KProperty1<? super T1, TIncludeSource> column, KProperty1<? super TR, TIncludeResult> aliasProperty){
        return columnInclude(true,column,aliasProperty, SQLKtColumnAsSelector::columnAll);
    }
    default <TIncludeSource,TIncludeResult> SQLKtColumnAsSelector<T1, TR> columnInclude(boolean condition,KProperty1<? super T1, TIncludeSource> column, KProperty1<? super TR, TIncludeResult> aliasProperty){
        return columnInclude(condition,column,aliasProperty, SQLKtColumnAsSelector::columnAll);
    }
    default <TIncludeSource,TIncludeResult> SQLKtColumnAsSelector<T1, TR> columnInclude(KProperty1<? super T1, TIncludeSource> column, KProperty1<? super TR, TIncludeResult> aliasProperty, SQLExpression1<SQLKtColumnAsSelector<TIncludeResult,TIncludeResult>> includeSelectorExpression){
        return columnInclude(true,column,aliasProperty,includeSelectorExpression);
    }
    default <TIncludeSource,TIncludeResult> SQLKtColumnAsSelector<T1, TR> columnInclude(boolean condition,KProperty1<? super T1, TIncludeSource> column, KProperty1<? super TR, TIncludeResult> aliasProperty, SQLExpression1<SQLKtColumnAsSelector<TIncludeResult,TIncludeResult>> includeSelectorExpression){
        if(condition){
            getColumnAsSelector().<TIncludeSource,TIncludeResult>columnInclude(EasyKtLambdaUtil.getPropertyName(column),EasyKtLambdaUtil.getPropertyName(aliasProperty),columnAsSelect->{
                includeSelectorExpression.apply(new SQLKtColumnAsSelectorImpl<>(columnAsSelect));
            });
        }
        return this;
    }
    default <TIncludeSource,TIncludeResult> SQLKtColumnAsSelector<T1, TR> columnIncludeMany(KProperty1<? super T1, Collection<TIncludeSource>> column, KProperty1<? super TR, Collection<TIncludeResult>> aliasProperty){
        return columnIncludeMany(true,column,aliasProperty, SQLKtColumnAsSelector::columnAll);
    }
    default <TIncludeSource,TIncludeResult> SQLKtColumnAsSelector<T1, TR> columnIncludeMany(boolean condition,KProperty1<? super T1, Collection<TIncludeSource>> column, KProperty1<? super TR, Collection<TIncludeResult>> aliasProperty){
        return columnIncludeMany(condition,column,aliasProperty, SQLKtColumnAsSelector::columnAll);
    }
    default <TIncludeSource,TIncludeResult> SQLKtColumnAsSelector<T1, TR> columnIncludeMany(KProperty1<? super T1, Collection<TIncludeSource>> column, KProperty1<? super TR, Collection<TIncludeResult>> aliasProperty, SQLExpression1<SQLKtColumnAsSelector<TIncludeResult,TIncludeResult>> includeSelectorExpression){
        return columnIncludeMany(true,column,aliasProperty,includeSelectorExpression);
    }
    default <TIncludeSource,TIncludeResult> SQLKtColumnAsSelector<T1, TR> columnIncludeMany(boolean condition,KProperty1<? super T1, Collection<TIncludeSource>> column, KProperty1<? super TR, Collection<TIncludeResult>> aliasProperty, SQLExpression1<SQLKtColumnAsSelector<TIncludeResult,TIncludeResult>> includeSelectorExpression){
        if(condition){
            getColumnAsSelector().<TIncludeSource,TIncludeResult>columnInclude(EasyKtLambdaUtil.getPropertyName(column),EasyKtLambdaUtil.getPropertyName(aliasProperty),columnAsSelect->{
                includeSelectorExpression.apply(new SQLKtColumnAsSelectorImpl<>(columnAsSelect));
            });
        }
        return this;
    }

    default <TProperty> SQLKtColumnAsSelector<T1, TR> columnIgnore(KProperty1<? super T1, TProperty> column) {
        getColumnAsSelector().columnIgnore(EasyKtLambdaUtil.getPropertyName(column));
        return this;
    }

    /**
     * 映射到TR的所有列上,按ColumnName进行映射,如果TR上没有对应的列名那么将不会映射查询列
     *
     * @return
     */
    default SQLKtColumnAsSelector<T1, TR> columnAll() {
        getColumnAsSelector().columnAll();
        return this;
    }

    default <TProperty> SQLKtColumnAsSelector<T1, TR> columnAs(KProperty1<? super T1, TProperty> column, KProperty1<? super TR, TProperty> alias) {
        getColumnAsSelector().columnAs(EasyKtLambdaUtil.getPropertyName(column), EasyKtLambdaUtil.getPropertyName(alias));
        return this;
    }

    default <TSubQuery> SQLKtColumnAsSelector<T1, TR> columnSubQueryAs(SQLFuncExpression<KtQueryable<TSubQuery>> subQueryableFunc, KProperty1<? super TR, TSubQuery> alias) {
        return columnSubQueryAs(subQueryableFunc, EasyKtLambdaUtil.getPropertyName(alias));
    }

    default <TSubQuery> SQLKtColumnAsSelector<T1, TR> columnSubQueryAs(SQLFuncExpression<KtQueryable<TSubQuery>> subQueryableFunc, String alias) {
        getColumnAsSelector().columnSubQueryAs(subQueryableFunc::apply, alias);
        return this;
    }

    default <TProperty> SQLKtColumnAsSelector<T1, TR> columnCount(KProperty1<? super T1, TProperty> column) {
        getColumnAsSelector().columnCount(EasyKtLambdaUtil.getPropertyName(column));
        return this;
    }
    default <TProperty> SQLKtColumnAsSelector<T1, TR> columnCount(KProperty1<? super T1, TProperty> column, SQLExpression1<ACSSelector> sqlExpression) {
        getColumnAsSelector().columnCount(EasyKtLambdaUtil.getPropertyName(column),sqlExpression);
        return this;
    }

    default <TProperty> SQLKtColumnAsSelector<T1, TR> columnCountAs(KProperty1<? super T1, TProperty> column, KProperty1<? super TR, TProperty> alias) {
        getColumnAsSelector().columnCountAs(EasyKtLambdaUtil.getPropertyName(column),EasyKtLambdaUtil.getPropertyName(alias));
        return this;
    }
    default <TProperty> SQLKtColumnAsSelector<T1, TR> columnCountAs(KProperty1<? super T1, TProperty> column, KProperty1<? super TR, TProperty> alias, SQLExpression1<ACSSelector> sqlExpression) {
        getColumnAsSelector().columnCountAs(EasyKtLambdaUtil.getPropertyName(column),EasyKtLambdaUtil.getPropertyName(alias),sqlExpression);
        return this;
    }

    default SQLKtColumnAsSelector<T1, TR> columnSum(KProperty1<? super T1, Number> column) {
        getColumnAsSelector().columnSum(EasyKtLambdaUtil.getPropertyName(column));
        return this;
    }
    default SQLKtColumnAsSelector<T1, TR> columnSum(KProperty1<? super T1, Number> column, SQLExpression1<ACSSelector> sqlExpression) {
        getColumnAsSelector().columnSum(EasyKtLambdaUtil.getPropertyName(column),sqlExpression);
        return this;
    }

    default SQLKtColumnAsSelector<T1, TR> columnSumAs(KProperty1<? super T1, Number> column, KProperty1<? super TR, Number> alias) {
        getColumnAsSelector().columnSumAs(EasyKtLambdaUtil.getPropertyName(column),EasyKtLambdaUtil.getPropertyName(alias));
        return this;
    }

    default SQLKtColumnAsSelector<T1, TR> columnSumAs(KProperty1<? super T1, Number> column, KProperty1<? super TR, Number> alias, SQLExpression1<ACSSelector> sqlExpression) {
        getColumnAsSelector().columnSumAs(EasyKtLambdaUtil.getPropertyName(column),EasyKtLambdaUtil.getPropertyName(alias),sqlExpression);
        return this;
    }

    default <TProperty> SQLKtColumnAsSelector<T1, TR> columnMax(KProperty1<? super T1, TProperty> column) {
        getColumnAsSelector().columnMax(EasyKtLambdaUtil.getPropertyName(column));
        return this;
    }

    default <TProperty> SQLKtColumnAsSelector<T1, TR> columnMaxAs(KProperty1<? super T1, TProperty> column, KProperty1<? super TR, TProperty> alias) {
        getColumnAsSelector().columnMaxAs(EasyKtLambdaUtil.getPropertyName(column),EasyKtLambdaUtil.getPropertyName(alias));
        return this;
    }

    default <TProperty> SQLKtColumnAsSelector<T1, TR> columnMin(KProperty1<? super T1, TProperty> column) {
        getColumnAsSelector().columnMin(EasyKtLambdaUtil.getPropertyName(column));
        return this;
    }

    default <TProperty> SQLKtColumnAsSelector<T1, TR> columnMinAs(KProperty1<? super T1, TProperty> column, KProperty1<? super TR, TProperty> alias) {
        getColumnAsSelector().columnMinAs(EasyKtLambdaUtil.getPropertyName(column),EasyKtLambdaUtil.getPropertyName(alias));
        return this;
    }

    default SQLKtColumnAsSelector<T1, TR> columnAvg(KProperty1<? super T1, Number> column) {
        getColumnAsSelector().columnAvg(EasyKtLambdaUtil.getPropertyName(column));
        return this;
    }
    default SQLKtColumnAsSelector<T1, TR> columnAvg(KProperty1<? super T1, Number> column, SQLExpression1<ACSSelector> sqlExpression) {
        getColumnAsSelector().columnAvg(EasyKtLambdaUtil.getPropertyName(column),sqlExpression);
        return this;
    }

    default SQLKtColumnAsSelector<T1, TR> columnAvgAs(KProperty1<? super T1, Number> column, KProperty1<? super TR, Number> alias) {
        getColumnAsSelector().columnAvgAs(EasyKtLambdaUtil.getPropertyName(column),EasyKtLambdaUtil.getPropertyName(alias));
        return this;
    }
    default SQLKtColumnAsSelector<T1, TR> columnAvgAs(KProperty1<? super T1, Number> column, KProperty1<? super TR, Number> alias, SQLExpression1<ACSSelector> sqlExpression) {
        getColumnAsSelector().columnAvgAs(EasyKtLambdaUtil.getPropertyName(column),EasyKtLambdaUtil.getPropertyName(alias),sqlExpression);
        return this;
    }

    default <TProperty> SQLKtColumnAsSelector<T1, TR> columnLen(KProperty1<? super T1, TProperty> column) {
        getColumnAsSelector().columnLen(EasyKtLambdaUtil.getPropertyName(column));
        return this;
    }

    default <TProperty> SQLKtColumnAsSelector<T1, TR> columnLenAs(KProperty1<? super T1, TProperty> column, KProperty1<? super TR, TProperty> alias) {
        return columnLenAs(column, EasyKtLambdaUtil.getPropertyName(alias));
    }

    default <TProperty> SQLKtColumnAsSelector<T1, TR> columnLenAs(KProperty1<? super T1, TProperty> column, String alias) {
        getColumnAsSelector().columnLenAs(EasyKtLambdaUtil.getPropertyName(column), alias);
        return this;
    }

    default <TProperty> SQLKtColumnAsSelector<T1, TR> columnFuncAs(ColumnPropertyFunction columnPropertyFunction, KProperty1<? super TR, TProperty> alias) {
        return columnFuncAs(columnPropertyFunction, EasyKtLambdaUtil.getPropertyName(alias));
    }

    default SQLKtColumnAsSelector<T1, TR> columnFuncAs(ColumnPropertyFunction columnPropertyFunction, String alias) {
        getColumnAsSelector().columnFuncAs(columnPropertyFunction, alias);
        return this;
    }

    default <TProperty> SQLKtColumnAsSelector<T1,TR> sqlSegmentAs(CloneableSQLSegment sqlColumnSegment, KProperty1<? super TR, TProperty> alias){
        getColumnAsSelector().sqlSegmentAs(sqlColumnSegment,EasyKtLambdaUtil.getPropertyName(alias));
        return this;
    }
    default <T2> SQLKtColumnAsSelector<T2, TR> then(SQLKtColumnAsSelector<T2, TR> sub) {
        getColumnAsSelector().then(sub.getColumnAsSelector());
        return sub;
    }
}
