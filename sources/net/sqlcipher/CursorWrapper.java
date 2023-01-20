package net.sqlcipher;

/* loaded from: classes4.dex */
public class CursorWrapper extends android.database.CursorWrapper implements Cursor {
    private final Cursor mCursor;

    public CursorWrapper(Cursor cursor) {
        super(cursor);
        this.mCursor = cursor;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor, net.sqlcipher.Cursor
    public int getType(int i2) {
        return this.mCursor.getType(i2);
    }

    @Override // android.database.CursorWrapper
    public Cursor getWrappedCursor() {
        return this.mCursor;
    }
}
