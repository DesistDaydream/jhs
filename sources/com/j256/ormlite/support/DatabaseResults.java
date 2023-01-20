package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import java.io.Closeable;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;

/* loaded from: classes2.dex */
public interface DatabaseResults extends Closeable {
    void closeQuietly();

    int findColumn(String str) throws SQLException;

    boolean first() throws SQLException;

    BigDecimal getBigDecimal(int i2) throws SQLException;

    InputStream getBlobStream(int i2) throws SQLException;

    boolean getBoolean(int i2) throws SQLException;

    byte getByte(int i2) throws SQLException;

    byte[] getBytes(int i2) throws SQLException;

    char getChar(int i2) throws SQLException;

    int getColumnCount() throws SQLException;

    String[] getColumnNames() throws SQLException;

    double getDouble(int i2) throws SQLException;

    float getFloat(int i2) throws SQLException;

    int getInt(int i2) throws SQLException;

    long getLong(int i2) throws SQLException;

    Object getObject(int i2) throws SQLException;

    ObjectCache getObjectCacheForRetrieve();

    ObjectCache getObjectCacheForStore();

    short getShort(int i2) throws SQLException;

    String getString(int i2) throws SQLException;

    Timestamp getTimestamp(int i2) throws SQLException;

    boolean last() throws SQLException;

    boolean moveAbsolute(int i2) throws SQLException;

    boolean moveRelative(int i2) throws SQLException;

    boolean next() throws SQLException;

    boolean previous() throws SQLException;

    boolean wasNull(int i2) throws SQLException;
}
