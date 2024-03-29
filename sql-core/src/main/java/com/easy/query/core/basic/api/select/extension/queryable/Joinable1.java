package com.easy.query.core.basic.api.select.extension.queryable;

import com.easy.query.core.basic.api.select.ClientQueryable;
import com.easy.query.core.basic.api.select.ClientQueryable2;
import com.easy.query.core.basic.api.select.ClientQueryable3;
import com.easy.query.core.basic.api.select.ClientQueryable4;
import com.easy.query.core.basic.api.select.ClientQueryable5;
import com.easy.query.core.basic.api.select.ClientQueryable6;
import com.easy.query.core.expression.lambda.SQLExpression2;
import com.easy.query.core.expression.parser.core.base.WherePredicate;

/**
 * create time 2023/8/16 09:11
 * 文件说明
 *
 * @author xuejiaming
 */
public interface Joinable1<T1> {
    <T2> ClientQueryable2<T1, T2> leftJoin(Class<T2> joinClass, SQLExpression2<WherePredicate<T1>, WherePredicate<T2>> on);

    <T2> ClientQueryable2<T1, T2> leftJoin(ClientQueryable<T2> joinQueryable, SQLExpression2<WherePredicate<T1>, WherePredicate<T2>> on);

    <T2> ClientQueryable2<T1, T2> rightJoin(Class<T2> joinClass, SQLExpression2<WherePredicate<T1>, WherePredicate<T2>> on);

    <T2> ClientQueryable2<T1, T2> rightJoin(ClientQueryable<T2> joinQueryable, SQLExpression2<WherePredicate<T1>, WherePredicate<T2>> on);

    <T2> ClientQueryable2<T1, T2> innerJoin(Class<T2> joinClass, SQLExpression2<WherePredicate<T1>, WherePredicate<T2>> on);

    <T2> ClientQueryable2<T1, T2> innerJoin(ClientQueryable<T2> joinQueryable, SQLExpression2<WherePredicate<T1>, WherePredicate<T2>> on);

}
