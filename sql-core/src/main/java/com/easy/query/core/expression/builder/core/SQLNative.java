package com.easy.query.core.expression.builder.core;

import com.easy.query.core.expression.lambda.SQLExpression1;
import com.easy.query.core.expression.parser.core.available.ChainCast;
import com.easy.query.core.expression.segment.scec.context.SQLNativeExpressionContext;

/**
 * create time 2023/7/31 13:20
 * 文件说明
 *
 * @author xuejiaming
 */
public interface SQLNative<TChain> extends SQLNativeAble {
    /**
     * 参数格式化 占位符 {0} {1}
     *
     * @param sqlSegment
     * @param contextConsume
     * @return
     */
    @Override
    TChain sqlNativeSegment(String sqlSegment, SQLExpression1<SQLNativeExpressionContext> contextConsume);
}
