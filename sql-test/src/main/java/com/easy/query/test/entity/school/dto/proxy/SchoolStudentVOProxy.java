package com.easy.query.test.entity.school.dto.proxy;

import com.easy.query.core.expression.parser.core.available.TableAvailable;
import com.easy.query.core.proxy.AbstractProxyEntity;
import com.easy.query.core.proxy.SQLColumn;
import com.easy.query.core.proxy.SQLSelectAsExpression;
import com.easy.query.core.proxy.fetcher.AbstractFetcher;
import com.easy.query.core.proxy.core.EntitySQLContext;
import com.easy.query.test.entity.school.dto.SchoolStudentVO;
import com.easy.query.core.proxy.columns.SQLStringColumn;
import com.easy.query.core.proxy.columns.SQLNavigateColumn;
import com.easy.query.core.proxy.columns.SQLAnyColumn;

/**
 * this file automatically generated by easy-query, don't modify it
 * 当前文件是easy-query自动生成的请不要随意修改
 * 如果出现属性冲突请使用@ProxyProperty进行重命名
 *
 * @author xuejiaming
 */
public class SchoolStudentVOProxy extends AbstractProxyEntity<SchoolStudentVOProxy, SchoolStudentVO> {

    private static final Class<SchoolStudentVO> entityClass = SchoolStudentVO.class;

    public static SchoolStudentVOProxy createTable() {
        return new SchoolStudentVOProxy();
    }

    public SchoolStudentVOProxy() {
    }

    /**
     * {@link SchoolStudentVO#getId}
     */
    public SQLStringColumn<SchoolStudentVOProxy, java.lang.String> id() {
        return getStringColumn("id", java.lang.String.class);
    }

    /**
     * {@link SchoolStudentVO#getClassId}
     */
    public SQLStringColumn<SchoolStudentVOProxy, java.lang.String> classId() {
        return getStringColumn("classId", java.lang.String.class);
    }

    /**
     * {@link SchoolStudentVO#getName}
     */
    public SQLStringColumn<SchoolStudentVOProxy, java.lang.String> name() {
        return getStringColumn("name", java.lang.String.class);
    }

    /**
     * {@link SchoolStudentVO#getSchoolClass}
     */
    public com.easy.query.test.entity.school.dto.proxy.SchoolClassVOProxy schoolClass() {
        return getNavigate("schoolClass", new com.easy.query.test.entity.school.dto.proxy.SchoolClassVOProxy());
    }

    /**
     * {@link SchoolStudentVO#getSchoolStudentAddress}
     */
    public com.easy.query.test.entity.school.dto.proxy.SchoolStudentAddressVOProxy schoolStudentAddress() {
        return getNavigate("schoolStudentAddress", new com.easy.query.test.entity.school.dto.proxy.SchoolStudentAddressVOProxy());
    }


    @Override
    public Class<SchoolStudentVO> getEntityClass() {
        return entityClass;
    }


    /**
     * 数据库列的简单获取
     *
     * @return
     */
    public SchoolStudentVOProxyFetcher FETCHER = new SchoolStudentVOProxyFetcher(this, null, SQLSelectAsExpression.empty);


    public static class SchoolStudentVOProxyFetcher extends AbstractFetcher<SchoolStudentVOProxy, SchoolStudentVO, SchoolStudentVOProxyFetcher> {

        public SchoolStudentVOProxyFetcher(SchoolStudentVOProxy proxy, SchoolStudentVOProxyFetcher prev, SQLSelectAsExpression sqlSelectAsExpression) {
            super(proxy, prev, sqlSelectAsExpression);
        }


        /**
         * {@link SchoolStudentVO#getId}
         */
        public SchoolStudentVOProxyFetcher id() {
            return add(getProxy().id());
        }

        /**
         * {@link SchoolStudentVO#getClassId}
         */
        public SchoolStudentVOProxyFetcher classId() {
            return add(getProxy().classId());
        }

        /**
         * {@link SchoolStudentVO#getName}
         */
        public SchoolStudentVOProxyFetcher name() {
            return add(getProxy().name());
        }


        @Override
        protected SchoolStudentVOProxyFetcher createFetcher(SchoolStudentVOProxy cp, AbstractFetcher<SchoolStudentVOProxy, SchoolStudentVO, SchoolStudentVOProxyFetcher> prev, SQLSelectAsExpression sqlSelectExpression) {
            return new SchoolStudentVOProxyFetcher(cp, this, sqlSelectExpression);
        }
    }

}
