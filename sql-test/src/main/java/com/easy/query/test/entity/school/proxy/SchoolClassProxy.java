package com.easy.query.test.entity.school.proxy;

import com.easy.query.core.expression.parser.core.available.TableAvailable;
import com.easy.query.core.proxy.AbstractProxyEntity;
import com.easy.query.core.proxy.SQLColumn;
import com.easy.query.core.proxy.SQLSelectAsExpression;
import com.easy.query.core.proxy.fetcher.AbstractFetcher;
import com.easy.query.core.proxy.core.EntitySQLContext;
import com.easy.query.test.entity.school.SchoolClass;
import com.easy.query.core.proxy.columns.types.SQLStringTypeColumn;
import com.easy.query.core.proxy.columns.SQLNavigateColumn;
import com.easy.query.core.proxy.columns.SQLManyQueryable;
import com.easy.query.core.proxy.columns.types.SQLAnyTypeColumn;

/**
 * this file automatically generated by easy-query, don't modify it
 * 当前文件是easy-query自动生成的请不要随意修改
 * 如果出现属性冲突请使用@ProxyProperty进行重命名
 *
 * @author easy-query
 */
public class SchoolClassProxy extends AbstractProxyEntity<SchoolClassProxy, SchoolClass> {

    private static final Class<SchoolClass> entityClass = SchoolClass.class;

    public static SchoolClassProxy createTable() {
        return new SchoolClassProxy();
    }

    public SchoolClassProxy() {
    }

    /**
     * {@link SchoolClass#getId}
     */
    public SQLStringTypeColumn<SchoolClassProxy> id() {
        return getStringTypeColumn("id");
    }

    /**
     * {@link SchoolClass#getName}
     */
    public SQLStringTypeColumn<SchoolClassProxy> name() {
        return getStringTypeColumn("name");
    }

    /**
     * 一对多 一个班级多个学生
     * {@link SchoolClass#getSchoolStudents}
     */
    public SQLManyQueryable<SchoolClassProxy, com.easy.query.test.entity.school.proxy.SchoolStudentProxy, com.easy.query.test.entity.school.SchoolStudent> schoolStudents() {
        return getNavigateMany("schoolStudents", new com.easy.query.test.entity.school.proxy.SchoolStudentProxy());
    }

    /**
     * 中间表多对多配置,其中mappingClass表示中间表,selfMappingProperty表示中间表的哪个字段和当前表对应,
     * {@link SchoolClass#getSchoolTeachers}
     */
    public SQLManyQueryable<SchoolClassProxy, com.easy.query.test.entity.school.proxy.SchoolTeacherProxy, com.easy.query.test.entity.school.SchoolTeacher> schoolTeachers() {
        return getNavigateMany("schoolTeachers", new com.easy.query.test.entity.school.proxy.SchoolTeacherProxy());
    }

    /**
     * {@link SchoolClass#getTopic}
     */
    public com.easy.query.test.entity.proxy.TopicProxy topic() {
        return getNavigate("topic", new com.easy.query.test.entity.proxy.TopicProxy());
    }


    @Override
    public Class<SchoolClass> getEntityClass() {
        return entityClass;
    }


    /**
     * 数据库列的简单获取
     *
     * @return
     */
    public SchoolClassProxyFetcher FETCHER = new SchoolClassProxyFetcher(this, null, SQLSelectAsExpression.empty);


    public static class SchoolClassProxyFetcher extends AbstractFetcher<SchoolClassProxy, SchoolClass, SchoolClassProxyFetcher> {

        public SchoolClassProxyFetcher(SchoolClassProxy proxy, SchoolClassProxyFetcher prev, SQLSelectAsExpression sqlSelectAsExpression) {
            super(proxy, prev, sqlSelectAsExpression);
        }


        /**
         * {@link SchoolClass#getId}
         */
        public SchoolClassProxyFetcher id() {
            return add(getProxy().id());
        }

        /**
         * {@link SchoolClass#getName}
         */
        public SchoolClassProxyFetcher name() {
            return add(getProxy().name());
        }


        @Override
        protected SchoolClassProxyFetcher createFetcher(SchoolClassProxy cp, AbstractFetcher<SchoolClassProxy, SchoolClass, SchoolClassProxyFetcher> prev, SQLSelectAsExpression sqlSelectExpression) {
            return new SchoolClassProxyFetcher(cp, this, sqlSelectExpression);
        }
    }

}
