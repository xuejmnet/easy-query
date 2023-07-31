package com.easy.query.api4kt.sql.impl;

import com.easy.query.api4kt.sql.SQLKtColumnSetSelector;
import com.easy.query.core.expression.parser.core.base.ColumnUpdateSetSelector;
import com.easy.query.core.expression.parser.core.base.core.SQLPropertyNative;
import com.easy.query.core.util.EasyObjectUtil;

/**
 * create time 2023/6/16 22:59
 * 文件说明
 *
 * @author xuejiaming
 */
public class SQLKtColumnSetSelectorImpl<T1> implements SQLKtColumnSetSelector<T1> {
    private final ColumnUpdateSetSelector<T1> columnSetSelector;

    public SQLKtColumnSetSelectorImpl(ColumnUpdateSetSelector<T1> columnSetSelector){

        this.columnSetSelector = columnSetSelector;
    }
    @Override
    public ColumnUpdateSetSelector<T1> getColumnSetSelector() {
        return columnSetSelector;
    }

    @Override
    public <T> SQLPropertyNative<T> getSQLPropertyNative() {
        return EasyObjectUtil.typeCastNullable(columnSetSelector);
    }

    @Override
    public SQLKtColumnSetSelector<T1> castTChain() {
        return this;
    }
}
