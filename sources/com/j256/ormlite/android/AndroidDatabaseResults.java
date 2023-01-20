package com.j256.ormlite.android;

import android.database.Cursor;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.support.DatabaseResults;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class AndroidDatabaseResults implements DatabaseResults {
    private static final int MIN_NUM_COLUMN_NAMES_MAP = 8;
    private static final DatabaseType databaseType = new SqliteAndroidDatabaseType();
    private final boolean cacheStore;
    private final Map<String, Integer> columnNameMap;
    private final String[] columnNames;
    private final Cursor cursor;
    private final ObjectCache objectCache;

    public AndroidDatabaseResults(Cursor cursor, ObjectCache objectCache, boolean z) {
        this.cursor = cursor;
        String[] columnNames = cursor.getColumnNames();
        this.columnNames = columnNames;
        if (columnNames.length >= 8) {
            this.columnNameMap = new HashMap();
            int i2 = 0;
            while (true) {
                String[] strArr = this.columnNames;
                if (i2 >= strArr.length) {
                    break;
                }
                this.columnNameMap.put(strArr[i2], Integer.valueOf(i2));
                i2++;
            }
        } else {
            this.columnNameMap = null;
        }
        this.objectCache = objectCache;
        this.cacheStore = z;
    }

    private int lookupColumn(String str) {
        Map<String, Integer> map = this.columnNameMap;
        if (map != null) {
            Integer num = map.get(str);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }
        int i2 = 0;
        while (true) {
            String[] strArr = this.columnNames;
            if (i2 >= strArr.length) {
                return -1;
            }
            if (strArr[i2].equals(str)) {
                return i2;
            }
            i2++;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cursor.close();
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public void closeQuietly() {
        close();
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public int findColumn(String str) throws SQLException {
        int lookupColumn = lookupColumn(str);
        if (lookupColumn >= 0) {
            return lookupColumn;
        }
        StringBuilder sb = new StringBuilder(str.length() + 4);
        databaseType.appendEscapedEntityName(sb, str);
        int lookupColumn2 = lookupColumn(sb.toString());
        if (lookupColumn2 >= 0) {
            return lookupColumn2;
        }
        String[] columnNames = this.cursor.getColumnNames();
        throw new SQLException("Unknown field '" + str + "' from the Android sqlite cursor, not in:" + Arrays.toString(columnNames));
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean first() {
        return this.cursor.moveToFirst();
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public BigDecimal getBigDecimal(int i2) throws SQLException {
        throw new SQLException("Android does not support BigDecimal type.  Use BIG_DECIMAL or BIG_DECIMAL_STRING types");
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public InputStream getBlobStream(int i2) {
        return new ByteArrayInputStream(this.cursor.getBlob(i2));
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean getBoolean(int i2) {
        return (this.cursor.isNull(i2) || this.cursor.getShort(i2) == 0) ? false : true;
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public byte getByte(int i2) {
        return (byte) getShort(i2);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public byte[] getBytes(int i2) {
        return this.cursor.getBlob(i2);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public char getChar(int i2) throws SQLException {
        String string = this.cursor.getString(i2);
        if (string == null || string.length() == 0) {
            return (char) 0;
        }
        if (string.length() == 1) {
            return string.charAt(0);
        }
        throw new SQLException("More than 1 character stored in database column: " + i2);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public int getColumnCount() {
        return this.cursor.getColumnCount();
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public String[] getColumnNames() {
        int columnCount = getColumnCount();
        String[] strArr = new String[columnCount];
        for (int i2 = 0; i2 < columnCount; i2++) {
            strArr[i2] = this.cursor.getColumnName(i2);
        }
        return strArr;
    }

    public int getCount() {
        return this.cursor.getCount();
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public double getDouble(int i2) {
        return this.cursor.getDouble(i2);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public float getFloat(int i2) {
        return this.cursor.getFloat(i2);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public int getInt(int i2) {
        return this.cursor.getInt(i2);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public long getLong(int i2) {
        return this.cursor.getLong(i2);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public Object getObject(int i2) throws SQLException {
        throw new SQLException("Android does not support Object type.");
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public ObjectCache getObjectCacheForRetrieve() {
        return this.objectCache;
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public ObjectCache getObjectCacheForStore() {
        if (this.cacheStore) {
            return this.objectCache;
        }
        return null;
    }

    public int getPosition() {
        return this.cursor.getPosition();
    }

    public Cursor getRawCursor() {
        return this.cursor;
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public short getShort(int i2) {
        return this.cursor.getShort(i2);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public String getString(int i2) {
        return this.cursor.getString(i2);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public Timestamp getTimestamp(int i2) throws SQLException {
        throw new SQLException("Android does not support timestamp.  Use JAVA_DATE_LONG or JAVA_DATE_STRING types");
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean last() {
        return this.cursor.moveToLast();
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean moveAbsolute(int i2) {
        return this.cursor.moveToPosition(i2);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean moveRelative(int i2) {
        return this.cursor.move(i2);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean next() {
        return this.cursor.moveToNext();
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean previous() {
        return this.cursor.moveToPrevious();
    }

    public String toString() {
        return getClass().getSimpleName() + TIMMentionEditText.TIM_MENTION_TAG + Integer.toHexString(super.hashCode());
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean wasNull(int i2) {
        return this.cursor.isNull(i2);
    }
}
