package com.huawei.hms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public class DataBufferRef {
    public final DataHolder mDataHolder;
    public int mDataRow;
    private int windowIndex;

    public DataBufferRef(DataHolder dataHolder, int i2) {
        Preconditions.checkNotNull(dataHolder, "dataHolder cannot be null");
        this.mDataHolder = dataHolder;
        getWindowIndex(i2);
    }

    public void copyToBuffer(String str, CharArrayBuffer charArrayBuffer) {
        this.mDataHolder.copyToBuffer(str, this.mDataRow, this.windowIndex, charArrayBuffer);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            return dataBufferRef.mDataRow == this.mDataRow && dataBufferRef.windowIndex == this.windowIndex && dataBufferRef.mDataHolder == this.mDataHolder;
        }
        return false;
    }

    public boolean getBoolean(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_BOOLEAN);
        if (value != null) {
            return ((Boolean) value).booleanValue();
        }
        return false;
    }

    public byte[] getByteArray(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_BYTE_ARRAY);
        if (value != null) {
            return (byte[]) value;
        }
        return null;
    }

    public int getDataRow() {
        return this.mDataRow;
    }

    public double getDouble(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_DOUBLE);
        if (value != null) {
            return ((Double) value).doubleValue();
        }
        return -1.0d;
    }

    public float getFloat(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_FLOAT);
        if (value != null) {
            return ((Float) value).floatValue();
        }
        return -1.0f;
    }

    public int getInteger(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_INT);
        if (value != null) {
            return ((Integer) value).intValue();
        }
        return -1;
    }

    public long getLong(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_LONG);
        if (value != null) {
            return ((Long) value).longValue();
        }
        return -1L;
    }

    public String getString(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_STRING);
        return value != null ? (String) value : "";
    }

    public final void getWindowIndex(int i2) {
        Preconditions.checkArgument(i2 >= 0 && i2 < this.mDataHolder.getCount(), "rowNum is out of index");
        this.mDataRow = i2;
        this.windowIndex = this.mDataHolder.getWindowIndex(i2);
    }

    public boolean hasColumn(String str) {
        return this.mDataHolder.hasColumn(str);
    }

    public boolean hasNull(String str) {
        return this.mDataHolder.hasNull(str, this.mDataRow, this.windowIndex);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.mDataRow), Integer.valueOf(this.windowIndex), this.mDataHolder);
    }

    public boolean isDataValid() {
        return !this.mDataHolder.isClosed();
    }

    public Uri parseUri(String str) {
        String str2 = (String) this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_STRING);
        if (str2 == null) {
            return null;
        }
        return Uri.parse(str2);
    }
}
