package com.easy.query.core.expression.sql;

import com.easy.query.core.exception.EasyQueryTableNotInSQLContextException;
import com.easy.query.core.expression.parser.core.available.TableAvailable;
import com.easy.query.core.util.EasyClassUtil;

import java.util.HashMap;

/**
 * create time 2023/5/27 11:25
 * 文件说明
 *
 * @author xuejiaming
 */
public final class MultiToTableContext implements ToTableContext {
    private final HashMap<TableAvailable, String> aliasMapping;
    private final int tableCount;
    private final boolean firstHasAlias;

    public MultiToTableContext(HashMap<TableAvailable, String> aliasMapping, int tableCount, boolean firstHasAlias) {

        this.aliasMapping = aliasMapping;
        this.tableCount = tableCount;
        this.firstHasAlias = firstHasAlias;
    }

    @Override
    public String getAlias(TableAvailable table) {
        if (!aliasMapping.containsKey(table)) {
            throw new EasyQueryTableNotInSQLContextException("not found table:[" + EasyClassUtil.getSimpleName(table.getEntityClass()) + "] in sql context");
        }
        if (tableCount == 1) {
            if (firstHasAlias) {
                return aliasMapping.get(table);
            }
            return null;
        }
        return aliasMapping.get(table);
    }
}
