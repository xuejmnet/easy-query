package com.easy.query.core.basic.extension.version;

import com.easy.query.core.metadata.EntityMetadata;

/**
 * create time 2023/3/27 09:01
 * 行版本策略
 *
 * @author xuejiaming
 */
public interface VersionStrategy {
    /**
     * 获取下次版本号值
     * @param entityMetadata
     * @param propertyName
     * @param version
     * @return
     */
    Object nextVersion(EntityMetadata entityMetadata, String propertyName, Object version);
}
