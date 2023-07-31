package com.easy.query.api4kt.sql;

import com.easy.query.api4kt.sql.core.SQLLambdaKtNative;
import com.easy.query.api4kt.sql.scec.SQLNativeLambdaKtExpressionContext;
import com.easy.query.api4kt.sql.scec.SQLNativeLambdaKtExpressionContextImpl;
import com.easy.query.api4kt.util.EasyKtLambdaUtil;
import com.easy.query.core.expression.func.ColumnPropertyFunction;
import com.easy.query.core.expression.lambda.SQLExpression1;
import com.easy.query.core.expression.parser.core.EntitySQLTableOwner;
import com.easy.query.core.expression.parser.core.available.TableAvailable;
import com.easy.query.core.expression.parser.core.base.ColumnSelector;
import kotlin.reflect.KProperty1;

/**
 * @author xuejiaming
 * @Description: 文件说明
 * @Date: 2023/2/6 23:20
 */
public interface SQLKtColumnSelector<T1> extends EntitySQLTableOwner<T1>, SQLLambdaKtNative<T1,SQLKtColumnSelector<T1>> {
    ColumnSelector<T1> getColumnSelector();

    default TableAvailable getTable() {
        return getColumnSelector().getTable();
    }

    default SQLKtColumnSelector<T1> column(KProperty1<T1, ?> column) {
        getColumnSelector().column(EasyKtLambdaUtil.getPropertyName(column));
        return this;
    }

    /**
     * 请使用 sqlNativeSegment
     * @param columnConst
     * @return
     */
    @Deprecated
    default SQLKtColumnSelector<T1> columnConst(String columnConst){
        return sqlNativeSegment(columnConst,c->{});
    }

    default SQLKtColumnSelector<T1> columnFunc(ColumnPropertyFunction columnPropertyFunction) {
        getColumnSelector().columnFunc(columnPropertyFunction);
        return this;
    }

    default SQLKtColumnSelector<T1> columnIgnore(KProperty1<T1, ?> column) {
        getColumnSelector().columnIgnore(EasyKtLambdaUtil.getPropertyName(column));
        return this;
    }

    default SQLKtColumnSelector<T1> columnAll() {
        getColumnSelector().columnAll();
        return this;
    }

    default <T2> SQLKtColumnSelector<T2> then(SQLKtColumnSelector<T2> sub) {
        getColumnSelector().then(sub.getColumnSelector());
        return sub;
    }
}
