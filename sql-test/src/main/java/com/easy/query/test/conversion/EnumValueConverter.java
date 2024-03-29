package com.easy.query.test.conversion;

import com.easy.query.core.basic.extension.conversion.EnumValueAutoConverter;
import com.easy.query.core.metadata.ColumnMetadata;
import com.easy.query.core.util.EasyObjectUtil;

/**
 * create time 2023/5/22 14:13
 * 文件说明
 *
 * @author xuejiaming
 */
public class EnumValueConverter implements EnumValueAutoConverter<Enum<?>,Integer> {
    @Override
    public Integer serialize(Enum<?> enumValue, ColumnMetadata columnMetadata) {
        if(enumValue==null){
            return null;
        }
        return (Integer) EnumValueDeserializer.serialize(enumValue);
    }

    @Override
    public Enum<?> deserialize(Integer integer, ColumnMetadata columnMetadata) {
        if(integer==null){
            return null;
        }
        return EnumValueDeserializer.deserialize(EasyObjectUtil.typeCast(columnMetadata.getPropertyType()),integer);
    }

    @Override
    public boolean apply(Class<?> entityClass, Class<Enum<?>> propertyType) {
        return true;
    }
}
