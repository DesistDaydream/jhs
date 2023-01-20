package net.sqlcipher;

import android.database.CharArrayBuffer;

/* loaded from: classes4.dex */
public abstract class AbstractWindowedCursor extends AbstractCursor {
    public CursorWindow mWindow;

    @Override // net.sqlcipher.AbstractCursor
    public void checkPosition() {
        super.checkPosition();
        if (this.mWindow == null) {
            throw new StaleDataException("Access closed cursor");
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i2)) {
                super.copyStringToBuffer(i2, charArrayBuffer);
            }
        }
        this.mWindow.copyStringToBuffer(this.mPos, i2, charArrayBuffer);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public byte[] getBlob(int i2) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i2)) {
                return (byte[]) getUpdatedField(i2);
            }
            return this.mWindow.getBlob(this.mPos, i2);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public double getDouble(int i2) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i2)) {
                return ((Number) getUpdatedField(i2)).doubleValue();
            }
            return this.mWindow.getDouble(this.mPos, i2);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public float getFloat(int i2) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i2)) {
                return ((Number) getUpdatedField(i2)).floatValue();
            }
            return this.mWindow.getFloat(this.mPos, i2);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getInt(int i2) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i2)) {
                return ((Number) getUpdatedField(i2)).intValue();
            }
            return this.mWindow.getInt(this.mPos, i2);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public long getLong(int i2) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i2)) {
                return ((Number) getUpdatedField(i2)).longValue();
            }
            return this.mWindow.getLong(this.mPos, i2);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public short getShort(int i2) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i2)) {
                return ((Number) getUpdatedField(i2)).shortValue();
            }
            return this.mWindow.getShort(this.mPos, i2);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String getString(int i2) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i2)) {
                return (String) getUpdatedField(i2);
            }
            return this.mWindow.getString(this.mPos, i2);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, net.sqlcipher.Cursor
    public int getType(int i2) {
        checkPosition();
        return this.mWindow.getType(this.mPos, i2);
    }

    public boolean hasWindow() {
        return this.mWindow != null;
    }

    public boolean isBlob(int i2) {
        boolean z;
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i2)) {
                Object updatedField = getUpdatedField(i2);
                if (updatedField != null && !(updatedField instanceof byte[])) {
                    z = false;
                    return z;
                }
                z = true;
                return z;
            }
            return this.mWindow.isBlob(this.mPos, i2);
        }
    }

    public boolean isFloat(int i2) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i2)) {
                Object updatedField = getUpdatedField(i2);
                return updatedField != null && ((updatedField instanceof Float) || (updatedField instanceof Double));
            }
            return this.mWindow.isFloat(this.mPos, i2);
        }
    }

    public boolean isLong(int i2) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i2)) {
                Object updatedField = getUpdatedField(i2);
                return updatedField != null && ((updatedField instanceof Integer) || (updatedField instanceof Long));
            }
            return this.mWindow.isLong(this.mPos, i2);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean isNull(int i2) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i2)) {
                return getUpdatedField(i2) == null;
            }
            return this.mWindow.isNull(this.mPos, i2);
        }
    }

    public boolean isString(int i2) {
        boolean z;
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i2)) {
                Object updatedField = getUpdatedField(i2);
                if (updatedField != null && !(updatedField instanceof String)) {
                    z = false;
                    return z;
                }
                z = true;
                return z;
            }
            return this.mWindow.isString(this.mPos, i2);
        }
    }

    public void setWindow(CursorWindow cursorWindow) {
        CursorWindow cursorWindow2 = this.mWindow;
        if (cursorWindow2 != null) {
            cursorWindow2.close();
        }
        this.mWindow = cursorWindow;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return this.mWindow;
    }
}
