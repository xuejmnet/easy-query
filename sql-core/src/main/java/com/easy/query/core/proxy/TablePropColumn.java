package com.easy.query.core.proxy;

import com.easy.query.core.expression.parser.core.SQLTableOwner;
import com.easy.query.core.proxy.available.EntitySQLContextAvailable;

/**
 * create time 2023/7/11 22:05
 * 文件说明
 *
 * @author xuejiaming
 */
public interface TablePropColumn extends PropColumn, SQLTableOwner, EntitySQLContextAvailable {
}
