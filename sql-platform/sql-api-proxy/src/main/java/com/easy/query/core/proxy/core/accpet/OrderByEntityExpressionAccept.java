package com.easy.query.core.proxy.core.accpet;

import com.easy.query.core.expression.builder.OrderSelector;

/**
 * create time 2023/12/29 13:38
 * 文件说明
 *
 * @author xuejiaming
 */
public interface OrderByEntityExpressionAccept extends EntityExpressionAccept{
    OrderSelector getOrderSelector();
}
