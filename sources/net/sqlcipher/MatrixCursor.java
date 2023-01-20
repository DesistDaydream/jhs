package net.sqlcipher;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class MatrixCursor extends AbstractCursor {
    private final int columnCount;
    private final String[] columnNames;
    private Object[] data;
    private int rowCount;

    /* loaded from: classes4.dex */
    public class RowBuilder {
        private final int endIndex;
        private int index;

        public RowBuilder(int i2, int i3) {
            this.index = i2;
            this.endIndex = i3;
        }

        public RowBuilder add(Object obj) {
            if (this.index != this.endIndex) {
                Object[] objArr = MatrixCursor.this.data;
                int i2 = this.index;
                this.index = i2 + 1;
                objArr[i2] = obj;
                return this;
            }
            throw new CursorIndexOutOfBoundsException("No more columns left.");
        }
    }

    public MatrixCursor(String[] strArr, int i2) {
        this.rowCount = 0;
        this.columnNames = strArr;
        int length = strArr.length;
        this.columnCount = length;
        this.data = new Object[length * (i2 < 1 ? 1 : i2)];
    }

    private void ensureCapacity(int i2) {
        Object[] objArr = this.data;
        if (i2 > objArr.length) {
            int length = objArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            Object[] objArr2 = new Object[i2];
            this.data = objArr2;
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
    }

    private Object get(int i2) {
        int i3;
        if (i2 >= 0 && i2 < (i3 = this.columnCount)) {
            int i4 = this.mPos;
            if (i4 >= 0) {
                if (i4 < this.rowCount) {
                    return this.data[(i4 * i3) + i2];
                }
                throw new CursorIndexOutOfBoundsException("After last row.");
            }
            throw new CursorIndexOutOfBoundsException("Before first row.");
        }
        throw new CursorIndexOutOfBoundsException("Requested column: " + i2 + ", # of columns: " + this.columnCount);
    }

    public void addRow(Object[] objArr) {
        int length = objArr.length;
        int i2 = this.columnCount;
        if (length == i2) {
            int i3 = this.rowCount;
            this.rowCount = i3 + 1;
            int i4 = i3 * i2;
            ensureCapacity(i2 + i4);
            System.arraycopy(objArr, 0, this.data, i4, this.columnCount);
            return;
        }
        throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + objArr.length);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.columnNames;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getCount() {
        return this.rowCount;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public double getDouble(int i2) {
        Object obj = get(i2);
        if (obj == null) {
            return 0.0d;
        }
        return obj instanceof Number ? ((Number) obj).doubleValue() : Double.parseDouble(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public float getFloat(int i2) {
        Object obj = get(i2);
        if (obj == null) {
            return 0.0f;
        }
        return obj instanceof Number ? ((Number) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getInt(int i2) {
        Object obj = get(i2);
        if (obj == null) {
            return 0;
        }
        return obj instanceof Number ? ((Number) obj).intValue() : Integer.parseInt(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public long getLong(int i2) {
        Object obj = get(i2);
        if (obj == null) {
            return 0L;
        }
        return obj instanceof Number ? ((Number) obj).longValue() : Long.parseLong(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public short getShort(int i2) {
        Object obj = get(i2);
        if (obj == null) {
            return (short) 0;
        }
        return obj instanceof Number ? ((Number) obj).shortValue() : Short.parseShort(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String getString(int i2) {
        Object obj = get(i2);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, net.sqlcipher.Cursor
    public int getType(int i2) {
        return DatabaseUtils.getTypeOfObject(get(i2));
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean isNull(int i2) {
        return get(i2) == null;
    }

    public RowBuilder newRow() {
        int i2 = this.rowCount + 1;
        this.rowCount = i2;
        int i3 = i2 * this.columnCount;
        ensureCapacity(i3);
        return new RowBuilder(i3 - this.columnCount, i3);
    }

    public MatrixCursor(String[] strArr) {
        this(strArr, 16);
    }

    public void addRow(Iterable<?> iterable) {
        int i2 = this.rowCount;
        int i3 = this.columnCount;
        int i4 = i2 * i3;
        int i5 = i3 + i4;
        ensureCapacity(i5);
        if (iterable instanceof ArrayList) {
            addRow((ArrayList) iterable, i4);
            return;
        }
        Object[] objArr = this.data;
        for (Object obj : iterable) {
            if (i4 != i5) {
                objArr[i4] = obj;
                i4++;
            } else {
                throw new IllegalArgumentException("columnValues.size() > columnNames.length");
            }
        }
        if (i4 == i5) {
            this.rowCount++;
            return;
        }
        throw new IllegalArgumentException("columnValues.size() < columnNames.length");
    }

    private void addRow(ArrayList<?> arrayList, int i2) {
        int size = arrayList.size();
        if (size == this.columnCount) {
            this.rowCount++;
            Object[] objArr = this.data;
            for (int i3 = 0; i3 < size; i3++) {
                objArr[i2 + i3] = arrayList.get(i3);
            }
            return;
        }
        throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.size() = " + size);
    }
}
