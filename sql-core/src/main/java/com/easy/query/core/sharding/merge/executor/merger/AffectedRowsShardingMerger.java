package com.easy.query.core.sharding.merge.executor.merger;

import com.easy.query.core.basic.jdbc.executor.internal.AffectedRowsExecuteResult;
import com.easy.query.core.sharding.merge.StreamMergeContext;

import java.util.Collection;

/**
 * create time 2023/4/26 12:17
 * 文件说明
 *
 * @author xuejiaming
 */
public class AffectedRowsShardingMerger  extends AbstractShardingMerger<AffectedRowsExecuteResult> {
    private static final AffectedRowsShardingMerger instance=new AffectedRowsShardingMerger();
    public static AffectedRowsShardingMerger getInstance(){
        return instance;
    }

    @Override
    public AffectedRowsExecuteResult streamMerge(StreamMergeContext streamMergeContext, Collection<AffectedRowsExecuteResult> parallelResults) {

        long recordsAffected=0;
        for (AffectedRowsExecuteResult parallelResult : parallelResults) {
            recordsAffected+=parallelResult.getRows();
        }
        return new AffectedRowsExecuteResult(recordsAffected);
    }
}
