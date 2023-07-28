package com.easy.query.core.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 * create time 2023/7/18 21:30
 * 文件说明
 *
 * @author xuejiaming
 */
public class FillParams {
    private final String targetProperty;
    private final List<Object> relationIds;

    private Class<?> originalEntityClass;

    public FillParams(String targetProperty){

        this.targetProperty = targetProperty;
        this.relationIds=new ArrayList<>();
    }

    public String getTargetProperty() {
        return targetProperty;
    }

    public List<Object> getRelationIds() {
        return relationIds;
    }

    public Class<?> getOriginalEntityClass() {
        return originalEntityClass;
    }

    public void setOriginalEntityClass(Class<?> originalEntityClass) {
        this.originalEntityClass = originalEntityClass;
    }
}