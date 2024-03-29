package com.easy.query.test.entity.school.proxy;

import com.easy.query.core.expression.parser.core.available.TableAvailable;
import com.easy.query.core.proxy.AbstractProxyEntity;
import com.easy.query.core.proxy.SQLColumn;
import com.easy.query.core.proxy.SQLSelectAsExpression;
import com.easy.query.core.proxy.fetcher.AbstractFetcher;
import com.easy.query.core.proxy.core.EntitySQLContext;
import com.easy.query.test.entity.school.SchoolClassTeacher;
import com.easy.query.core.proxy.columns.SQLStringColumn;

/**
 * this file automatically generated by easy-query, don't modify it
 * 当前文件是easy-query自动生成的请不要随意修改
 * 如果出现属性冲突请使用@ProxyProperty进行重命名
 *
 * @author xuejiaming
 */
public class SchoolClassTeacherProxy extends AbstractProxyEntity < SchoolClassTeacherProxy, SchoolClassTeacher > {

    private static final Class < SchoolClassTeacher > entityClass = SchoolClassTeacher .class;

    public static SchoolClassTeacherProxy createTable (){
        return new SchoolClassTeacherProxy ();
    }

    public SchoolClassTeacherProxy (){
    }

    /**
     *{@link SchoolClassTeacher#getClassId}
     */
    public SQLStringColumn < SchoolClassTeacherProxy, java.lang.String> classId(){
    return getStringColumn("classId", java.lang.String.class);
}

    /**
     *{@link SchoolClassTeacher#getTeacherId}
     */
    public SQLStringColumn < SchoolClassTeacherProxy, java.lang.String> teacherId(){
    return getStringColumn("teacherId", java.lang.String.class);
}


    @Override
    public Class < SchoolClassTeacher > getEntityClass (){
        return entityClass;
    }


    /**
     * 数据库列的简单获取
     * @return
     */
    public SchoolClassTeacherProxyFetcher FETCHER =
        new SchoolClassTeacherProxyFetcher (this, null, SQLSelectAsExpression.empty);


    public static class SchoolClassTeacherProxyFetcher extends AbstractFetcher<SchoolClassTeacherProxy, SchoolClassTeacher, SchoolClassTeacherProxyFetcher> {

        public SchoolClassTeacherProxyFetcher (SchoolClassTeacherProxy proxy, SchoolClassTeacherProxyFetcher prev, SQLSelectAsExpression sqlSelectAsExpression){
        super(proxy, prev, sqlSelectAsExpression);
    }


        /**
         *{@link SchoolClassTeacher#getClassId}
         */
        public SchoolClassTeacherProxyFetcher classId() {
            return add(getProxy().classId());
        }

        /**
         *{@link SchoolClassTeacher#getTeacherId}
         */
        public SchoolClassTeacherProxyFetcher teacherId() {
            return add(getProxy().teacherId());
        }


        @Override
        protected SchoolClassTeacherProxyFetcher createFetcher(
            SchoolClassTeacherProxy cp,
            AbstractFetcher<SchoolClassTeacherProxy, SchoolClassTeacher, SchoolClassTeacherProxyFetcher> prev,
            SQLSelectAsExpression sqlSelectExpression
        ) {
            return new SchoolClassTeacherProxyFetcher (cp, this, sqlSelectExpression);
        }
    }

}
