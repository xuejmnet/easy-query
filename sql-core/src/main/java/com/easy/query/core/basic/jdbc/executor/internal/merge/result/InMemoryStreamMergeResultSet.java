package com.easy.query.core.basic.jdbc.executor.internal.merge.result;

/**
 * create time 2023/5/2 23:46
 * 文件说明
 *
 * @author xuejiaming
 */
public interface InMemoryStreamMergeResultSet extends ShardingStreamResultSet {
    int getReallyCount();
}
