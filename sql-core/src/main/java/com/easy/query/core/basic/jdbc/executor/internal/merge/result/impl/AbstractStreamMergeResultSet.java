//package com.easy.query.core.sharding.merge.result.impl;
//
//import com.easy.query.core.sharding.merge.result.StreamResultSet;
//
//import java.math.BigDecimal;
//import java.sql.Blob;
//import java.sql.Clob;
//import java.sql.Date;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.sql.SQLXML;
//import java.sql.Time;
//import java.sql.Timestamp;
//
///**
// * create time 2023/5/9 11:19
// * 文件说明
// *
// * @author xuejiaming
// */
//public abstract class AbstractStreamMergeResultSet implements StreamResultSet {
//
//    private StreamResultSet currentStreamResultSet;
//    private boolean wasNull;
//
//    public StreamResultSet getCurrentStreamResultSet() {
//        return currentStreamResultSet;
//    }
//
//    public void setCurrentStreamResultSet(StreamResultSet currentStreamResultSet) {
//        this.currentStreamResultSet = currentStreamResultSet;
//    }
//
//    @Override
//    public abstract boolean hasElement();
//
//    @Override
//    public abstract boolean skipFirst();
//
//    @Override
//    public abstract boolean next() throws SQLException;
//
//    @Override
//    public Object getObject(int columnIndex) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public boolean wasNull() throws SQLException {
//        return false;
//    }
//
//    @Override
//    public ResultSetMetaData getMetaData() throws SQLException {
//        return null;
//    }
//
//    @Override
//    public SQLXML getSQLXML(int columnIndex) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Timestamp getTimestamp(int columnIndex) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Time getTime(int columnIndex) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public String getString(int columnIndex) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Date getDate(int columnIndex) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public short getShort(int columnIndex) throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public long getLong(int columnIndex) throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public int getInt(int columnIndex) throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public float getFloat(int columnIndex) throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public double getDouble(int columnIndex) throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public Clob getClob(int columnIndex) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public byte getByte(int columnIndex) throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public byte[] getBytes(int columnIndex) throws SQLException {
//        return new byte[0];
//    }
//
//    @Override
//    public boolean getBoolean(int columnIndex) throws SQLException {
//        return false;
//    }
//
//    @Override
//    public Blob getBlob(int columnIndex) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public void close() throws Exception {
//
//    }
//}
