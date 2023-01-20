package net.sqlcipher.database;

import android.os.SystemClock;
import android.util.Log;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import net.sqlcipher.CursorWindow;

/* loaded from: classes4.dex */
public class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "Cursor";
    private String[] mBindArgs;
    private Object[] mObjectBindArgs;
    private int mOffsetIndex;

    public SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i2, String[] strArr) {
        super(sQLiteDatabase, str);
        this.mOffsetIndex = i2;
        this.mBindArgs = strArr;
    }

    private final native int native_column_count();

    private final native String native_column_name(int i2);

    private final native int native_fill_window(CursorWindow cursorWindow, int i2, int i3, int i4, int i5, int i6);

    public void bindArguments(Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null) {
                bindNull(i2 + 1);
            } else if (obj instanceof Double) {
                bindDouble(i2 + 1, ((Double) obj).doubleValue());
            } else if (obj instanceof Float) {
                bindDouble(i2 + 1, Double.valueOf(((Number) obj).floatValue()).doubleValue());
            } else if (obj instanceof Long) {
                bindLong(i2 + 1, ((Long) obj).longValue());
            } else if (obj instanceof Integer) {
                bindLong(i2 + 1, Long.valueOf(((Number) obj).intValue()).longValue());
            } else if (obj instanceof Boolean) {
                bindLong(i2 + 1, ((Boolean) obj).booleanValue() ? 1L : 0L);
            } else if (obj instanceof byte[]) {
                bindBlob(i2 + 1, (byte[]) obj);
            } else {
                bindString(i2 + 1, obj.toString());
            }
        }
    }

    @Override // net.sqlcipher.database.SQLiteProgram
    public void bindDouble(int i2, double d2) {
        this.mBindArgs[i2 - 1] = Double.toString(d2);
        if (this.mClosed) {
            return;
        }
        super.bindDouble(i2, d2);
    }

    @Override // net.sqlcipher.database.SQLiteProgram
    public void bindLong(int i2, long j2) {
        this.mBindArgs[i2 - 1] = Long.toString(j2);
        if (this.mClosed) {
            return;
        }
        super.bindLong(i2, j2);
    }

    @Override // net.sqlcipher.database.SQLiteProgram
    public void bindNull(int i2) {
        this.mBindArgs[i2 - 1] = null;
        if (this.mClosed) {
            return;
        }
        super.bindNull(i2);
    }

    @Override // net.sqlcipher.database.SQLiteProgram
    public void bindString(int i2, String str) {
        this.mBindArgs[i2 - 1] = str;
        if (this.mClosed) {
            return;
        }
        super.bindString(i2, str);
    }

    public int columnCountLocked() {
        acquireReference();
        try {
            return native_column_count();
        } finally {
            releaseReference();
        }
    }

    public String columnNameLocked(int i2) {
        acquireReference();
        try {
            return native_column_name(i2);
        } finally {
            releaseReference();
        }
    }

    public int fillWindow(CursorWindow cursorWindow, int i2, int i3) {
        int i4;
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        try {
            acquireReference();
            try {
                cursorWindow.acquireReference();
                i4 = native_fill_window(cursorWindow, cursorWindow.getStartPosition(), cursorWindow.getRequiredPosition(), this.mOffsetIndex, i2, i3);
                if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
                    Log.d("Cursor", "fillWindow(): " + this.mSql);
                }
            } catch (IllegalStateException unused) {
                i4 = 0;
            } catch (SQLiteDatabaseCorruptException e2) {
                this.mDatabase.onCorruption();
                throw e2;
            }
            cursorWindow.releaseReference();
            return i4;
        } finally {
            releaseReference();
            this.mDatabase.unlock();
        }
    }

    public void requery() {
        String[] strArr = this.mBindArgs;
        if (strArr != null) {
            int length = strArr.length;
            try {
                Object[] objArr = this.mObjectBindArgs;
                if (objArr != null) {
                    bindArguments(objArr);
                    return;
                }
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    super.bindString(i3, this.mBindArgs[i2]);
                    i2 = i3;
                }
            } catch (SQLiteMisuseException e2) {
                StringBuilder sb = new StringBuilder("mSql " + this.mSql);
                for (int i4 = 0; i4 < length; i4++) {
                    sb.append(ExpandableTextView.N);
                    sb.append(this.mBindArgs[i4]);
                }
                sb.append(ExpandableTextView.N);
                throw new IllegalStateException(sb.toString(), e2);
            }
        }
    }

    public String toString() {
        return "SQLiteQuery: " + this.mSql;
    }

    public SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i2, Object[] objArr) {
        super(sQLiteDatabase, str);
        this.mOffsetIndex = i2;
        this.mObjectBindArgs = objArr;
        this.mBindArgs = new String[objArr != null ? objArr.length : 0];
    }
}
