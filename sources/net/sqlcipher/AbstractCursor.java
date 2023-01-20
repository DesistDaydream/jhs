package net.sqlcipher;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.CrossProcessCursor;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class AbstractCursor implements CrossProcessCursor, Cursor {
    private static final String TAG = "Cursor";
    public ContentResolver mContentResolver;
    private Uri mNotifyUri;
    private ContentObserver mSelfObserver;
    private boolean mSelfObserverRegistered;
    public DataSetObservable mDataSetObservable = new DataSetObservable();
    public ContentObservable mContentObservable = new ContentObservable();
    private Bundle mExtras = Bundle.EMPTY;
    public boolean mClosed = false;
    private final Object mSelfObserverLock = new Object();
    public int mPos = -1;
    public int mRowIdColumnIndex = -1;
    public Long mCurrentRowID = null;
    public HashMap<Long, Map<String, Object>> mUpdatedRows = new HashMap<>();

    /* loaded from: classes4.dex */
    public static class SelfContentObserver extends ContentObserver {
        public WeakReference<AbstractCursor> mCursor;

        public SelfContentObserver(AbstractCursor abstractCursor) {
            super(null);
            this.mCursor = new WeakReference<>(abstractCursor);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return false;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            AbstractCursor abstractCursor = this.mCursor.get();
            if (abstractCursor != null) {
                abstractCursor.onChange(false);
            }
        }
    }

    public void abortUpdates() {
        synchronized (this.mUpdatedRows) {
            this.mUpdatedRows.clear();
        }
    }

    public void checkPosition() {
        if (-1 == this.mPos || getCount() == this.mPos) {
            throw new CursorIndexOutOfBoundsException(this.mPos, getCount());
        }
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mClosed = true;
        this.mContentObservable.unregisterAll();
        deactivateInternal();
    }

    public boolean commitUpdates() {
        return commitUpdates(null);
    }

    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> map) {
        return false;
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
        String string = getString(i2);
        if (string != null) {
            char[] cArr = charArrayBuffer.data;
            if (cArr != null && cArr.length >= string.length()) {
                string.getChars(0, string.length(), cArr, 0);
            } else {
                charArrayBuffer.data = string.toCharArray();
            }
            charArrayBuffer.sizeCopied = string.length();
            return;
        }
        charArrayBuffer.sizeCopied = 0;
    }

    @Override // android.database.Cursor
    public void deactivate() {
        deactivateInternal();
    }

    public void deactivateInternal() {
        ContentObserver contentObserver = this.mSelfObserver;
        if (contentObserver != null) {
            this.mContentResolver.unregisterContentObserver(contentObserver);
            this.mSelfObserverRegistered = false;
        }
        this.mDataSetObservable.notifyInvalidated();
    }

    public boolean deleteRow() {
        return false;
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i2, android.database.CursorWindow cursorWindow) {
        DatabaseUtils.cursorFillWindow(this, i2, cursorWindow);
    }

    public void finalize() {
        ContentObserver contentObserver = this.mSelfObserver;
        if (contentObserver == null || !this.mSelfObserverRegistered) {
            return;
        }
        this.mContentResolver.unregisterContentObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i2) {
        throw new UnsupportedOperationException("getBlob is not supported");
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        return getColumnNames().length;
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Exception exc = new Exception();
            Log.e("Cursor", "requesting column name with table name -- " + str, exc);
            str = str.substring(lastIndexOf + 1);
        }
        String[] columnNames = getColumnNames();
        int length = columnNames.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (columnNames[i2].equalsIgnoreCase(str)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) {
        int columnIndex = getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist");
    }

    @Override // android.database.Cursor
    public String getColumnName(int i2) {
        return getColumnNames()[i2];
    }

    @Override // android.database.Cursor
    public abstract String[] getColumnNames();

    @Override // android.database.Cursor
    public abstract int getCount();

    public DataSetObservable getDataSetObservable() {
        return this.mDataSetObservable;
    }

    @Override // android.database.Cursor
    public abstract double getDouble(int i2);

    @Override // android.database.Cursor
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // android.database.Cursor
    public abstract float getFloat(int i2);

    @Override // android.database.Cursor
    public abstract int getInt(int i2);

    @Override // android.database.Cursor
    public abstract long getLong(int i2);

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        return this.mNotifyUri;
    }

    @Override // android.database.Cursor
    public final int getPosition() {
        return this.mPos;
    }

    @Override // android.database.Cursor
    public abstract short getShort(int i2);

    @Override // android.database.Cursor
    public abstract String getString(int i2);

    @Override // android.database.Cursor, net.sqlcipher.Cursor
    public abstract int getType(int i2);

    public Object getUpdatedField(int i2) {
        return this.mUpdatedRows.get(this.mCurrentRowID).get(getColumnNames()[i2]);
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    @Override // android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return null;
    }

    public boolean hasUpdates() {
        boolean z;
        synchronized (this.mUpdatedRows) {
            z = this.mUpdatedRows.size() > 0;
        }
        return z;
    }

    @Override // android.database.Cursor
    public final boolean isAfterLast() {
        return getCount() == 0 || this.mPos == getCount();
    }

    @Override // android.database.Cursor
    public final boolean isBeforeFirst() {
        return getCount() == 0 || this.mPos == -1;
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        return this.mClosed;
    }

    public boolean isFieldUpdated(int i2) {
        Map<String, Object> map;
        return this.mRowIdColumnIndex != -1 && this.mUpdatedRows.size() > 0 && (map = this.mUpdatedRows.get(this.mCurrentRowID)) != null && map.containsKey(getColumnNames()[i2]);
    }

    @Override // android.database.Cursor
    public final boolean isFirst() {
        return this.mPos == 0 && getCount() != 0;
    }

    @Override // android.database.Cursor
    public final boolean isLast() {
        int count = getCount();
        return this.mPos == count + (-1) && count != 0;
    }

    @Override // android.database.Cursor
    public abstract boolean isNull(int i2);

    @Override // android.database.Cursor
    public final boolean move(int i2) {
        return moveToPosition(this.mPos + i2);
    }

    @Override // android.database.Cursor
    public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    @Override // android.database.Cursor
    public final boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    @Override // android.database.Cursor
    public final boolean moveToNext() {
        return moveToPosition(this.mPos + 1);
    }

    @Override // android.database.Cursor
    public final boolean moveToPosition(int i2) {
        int count = getCount();
        if (i2 >= count) {
            this.mPos = count;
            return false;
        } else if (i2 < 0) {
            this.mPos = -1;
            return false;
        } else {
            int i3 = this.mPos;
            if (i2 == i3) {
                return true;
            }
            boolean onMove = onMove(i3, i2);
            if (!onMove) {
                this.mPos = -1;
            } else {
                this.mPos = i2;
                int i4 = this.mRowIdColumnIndex;
                if (i4 != -1) {
                    this.mCurrentRowID = Long.valueOf(getLong(i4));
                }
            }
            return onMove;
        }
    }

    @Override // android.database.Cursor
    public final boolean moveToPrevious() {
        return moveToPosition(this.mPos - 1);
    }

    public void notifyDataSetChange() {
        this.mDataSetObservable.notifyChanged();
    }

    public void onChange(boolean z) {
        synchronized (this.mSelfObserverLock) {
            this.mContentObservable.dispatchChange(z);
            Uri uri = this.mNotifyUri;
            if (uri != null && z) {
                this.mContentResolver.notifyChange(uri, this.mSelfObserver);
            }
        }
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i2, int i3) {
        return true;
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        this.mContentObservable.registerObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.registerObserver(dataSetObserver);
    }

    @Override // android.database.Cursor
    public boolean requery() {
        ContentObserver contentObserver = this.mSelfObserver;
        if (contentObserver != null && !this.mSelfObserverRegistered) {
            this.mContentResolver.registerContentObserver(this.mNotifyUri, true, contentObserver);
            this.mSelfObserverRegistered = true;
        }
        this.mDataSetObservable.notifyChanged();
        return true;
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        return Bundle.EMPTY;
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle bundle) {
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        this.mExtras = bundle;
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        synchronized (this.mSelfObserverLock) {
            this.mNotifyUri = uri;
            this.mContentResolver = contentResolver;
            ContentObserver contentObserver = this.mSelfObserver;
            if (contentObserver != null) {
                contentResolver.unregisterContentObserver(contentObserver);
            }
            SelfContentObserver selfContentObserver = new SelfContentObserver(this);
            this.mSelfObserver = selfContentObserver;
            this.mContentResolver.registerContentObserver(this.mNotifyUri, true, selfContentObserver);
            this.mSelfObserverRegistered = true;
        }
    }

    public boolean supportsUpdates() {
        return this.mRowIdColumnIndex != -1;
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        if (this.mClosed) {
            return;
        }
        this.mContentObservable.unregisterObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.unregisterObserver(dataSetObserver);
    }

    public boolean update(int i2, Object obj) {
        if (supportsUpdates()) {
            Long valueOf = Long.valueOf(getLong(this.mRowIdColumnIndex));
            if (valueOf != null) {
                synchronized (this.mUpdatedRows) {
                    Map<String, Object> map = this.mUpdatedRows.get(valueOf);
                    if (map == null) {
                        map = new HashMap<>();
                        this.mUpdatedRows.put(valueOf, map);
                    }
                    map.put(getColumnNames()[i2], obj);
                }
                return true;
            }
            throw new IllegalStateException("null rowid. mRowIdColumnIndex = " + this.mRowIdColumnIndex);
        }
        return false;
    }

    public boolean updateBlob(int i2, byte[] bArr) {
        return update(i2, bArr);
    }

    public boolean updateDouble(int i2, double d2) {
        return update(i2, Double.valueOf(d2));
    }

    public boolean updateFloat(int i2, float f2) {
        return update(i2, Float.valueOf(f2));
    }

    public boolean updateInt(int i2, int i3) {
        return update(i2, Integer.valueOf(i3));
    }

    public boolean updateLong(int i2, long j2) {
        return update(i2, Long.valueOf(j2));
    }

    public boolean updateShort(int i2, short s) {
        return update(i2, Short.valueOf(s));
    }

    public boolean updateString(int i2, String str) {
        return update(i2, str);
    }

    public boolean updateToNull(int i2) {
        return update(i2, null);
    }
}
