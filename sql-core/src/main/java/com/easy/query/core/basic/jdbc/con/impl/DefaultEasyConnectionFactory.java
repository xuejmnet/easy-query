package com.easy.query.core.basic.jdbc.con.impl;

import com.easy.query.core.datasource.DataSourceUnit;
import com.easy.query.core.configuration.EasyQueryOption;
import com.easy.query.core.enums.con.ConnectionStrategyEnum;
import com.easy.query.core.basic.jdbc.con.DataSourceWrapper;
import com.easy.query.core.basic.jdbc.con.EasyConnection;
import com.easy.query.core.basic.jdbc.con.EasyConnectionFactory;
import com.easy.query.core.exception.EasyQuerySQLCommandException;
import com.easy.query.core.sharding.EasyQueryDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * create time 2023/5/12 08:50
 * 文件说明
 *
 * @author xuejiaming
 */
public class DefaultEasyConnectionFactory implements EasyConnectionFactory {
    private final EasyQueryDataSource easyQueryDataSource;
    private final EasyQueryOption easyQueryOption;

    public DefaultEasyConnectionFactory(EasyQueryDataSource easyQueryDataSource, EasyQueryOption easyQueryOption){

        this.easyQueryDataSource = easyQueryDataSource;
        this.easyQueryOption = easyQueryOption;
    }
    @Override
    public List<EasyConnection> createEasyConnections(int count, String dataSourceName, Integer isolationLevel, ConnectionStrategyEnum connectionStrategy) {
        try {
            DataSourceWrapper dataSourceWrapper = easyQueryDataSource.getDataSourceNotNull(dataSourceName, connectionStrategy);
            DataSourceUnit dataSourceUnit = dataSourceWrapper.getDataSourceUnit();
            long multiConnWaitTimeoutMillis = easyQueryOption.getMultiConnWaitTimeoutMillis();
            List<Connection> connections = dataSourceUnit.getConnections(count, multiConnWaitTimeoutMillis, TimeUnit.MILLISECONDS);
            List<EasyConnection> easyConnections = new ArrayList<>(count);
            for (Connection connection : connections) {
                DefaultEasyConnection easyConnection = new DefaultEasyConnection(dataSourceName, dataSourceWrapper.getStrategy(), connection, isolationLevel);
                easyConnections.add(easyConnection);
            }
            return easyConnections;
        } catch (SQLException e) {
            throw new EasyQuerySQLCommandException(e);
        }
    }
}
