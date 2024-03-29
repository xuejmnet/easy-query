package com.easy.query.api4kt.sql;

import com.easy.query.api4kt.sql.core.SQLLambdaKtNative;
import com.easy.query.api4kt.sql.core.available.SQLKtLambdaFuncAvailable;
import com.easy.query.api4kt.util.EasyKtLambdaUtil;
import com.easy.query.core.context.QueryRuntimeContext;
import com.easy.query.core.expression.func.ColumnPropertyFunction;
import com.easy.query.core.expression.parser.core.EntitySQLTableOwner;
import com.easy.query.core.expression.parser.core.available.TableAvailable;
import com.easy.query.core.expression.parser.core.base.ColumnGroupSelector;
import kotlin.reflect.KProperty1;

/**
 * create time 2023/4/30 21:49
 * 文件说明
 *
 * @author xuejiaming
 */
public interface SQLKtGroupBySelector<T1> extends EntitySQLTableOwner<T1>, SQLKtLambdaFuncAvailable<T1>, SQLLambdaKtNative<T1,SQLKtGroupBySelector<T1>> {
    ColumnGroupSelector<T1> getGroupBySelector();

    default TableAvailable getTable() {
        return getGroupBySelector().getTable();
    }
    default QueryRuntimeContext getRuntimeContext() {
        return getGroupBySelector().getRuntimeContext();
    }

    default <TProperty> SQLKtGroupBySelector<T1> column(KProperty1<? super T1, TProperty> column) {
        getGroupBySelector().column(EasyKtLambdaUtil.getPropertyName(column));
        return this;
    }

    /**
     * 请使用 sqlNativeSegment
     * @param columnConst
     * @return
     */
    @Deprecated
    default SQLKtGroupBySelector<T1> columnConst(String columnConst){
        return sqlNativeSegment(columnConst,c->{});
    }
    default SQLKtGroupBySelector<T1> columnFunc(ColumnPropertyFunction columnPropertyFunction) {
        getGroupBySelector().columnFunc(columnPropertyFunction);
        return this;
    }

    default <T2> SQLKtGroupBySelector<T2> then(SQLKtGroupBySelector<T2> sub) {
        return sub;
    }
}
