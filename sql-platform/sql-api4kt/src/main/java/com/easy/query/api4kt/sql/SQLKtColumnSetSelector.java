package com.easy.query.api4kt.sql;

import com.easy.query.api4kt.util.EasyKtLambdaUtil;
import com.easy.query.core.expression.parser.core.EntitySQLTableOwner;
import com.easy.query.core.expression.parser.core.available.TableAvailable;
import com.easy.query.core.expression.parser.core.base.ColumnUpdateSetSelector;
import kotlin.reflect.KProperty1;

/**
 * create time 2023/6/16 22:57
 * 文件说明
 *
 * @author xuejiaming
 */
public interface SQLKtColumnSetSelector<T1> extends EntitySQLTableOwner<T1> {
    ColumnUpdateSetSelector<T1> getColumnSetSelector();

    default TableAvailable getTable() {
        return getColumnSetSelector().getTable();
    }
    default SQLKtColumnSetSelector<T1> columnKeys() {
        getColumnSetSelector().columnKeys();
        return this;
    }


    default <TProperty> SQLKtColumnSetSelector<T1> column(KProperty1<? super T1, TProperty> column) {
        getColumnSetSelector().column(EasyKtLambdaUtil.getPropertyName(column));
        return this;
    }

    default <TProperty> SQLKtColumnSetSelector<T1> columnIgnore(KProperty1<? super T1, TProperty> column) {
        getColumnSetSelector().columnIgnore(EasyKtLambdaUtil.getPropertyName(column));
        return this;
    }

    default SQLKtColumnSetSelector<T1> columnAll() {
        getColumnSetSelector().columnAll();
        return this;
    }

    default <T2> SQLKtColumnSetSelector<T2> then(SQLKtColumnSetSelector<T2> sub) {
        return sub;
    }
}
