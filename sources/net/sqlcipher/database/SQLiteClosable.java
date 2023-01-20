package net.sqlcipher.database;

/* loaded from: classes4.dex */
public abstract class SQLiteClosable {
    private int mReferenceCount = 1;
    private Object mLock = new Object();

    private String getObjInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(" (");
        if (this instanceof SQLiteDatabase) {
            sb.append("database = ");
            sb.append(((SQLiteDatabase) this).getPath());
        } else if ((this instanceof SQLiteProgram) || (this instanceof SQLiteStatement) || (this instanceof SQLiteQuery)) {
            sb.append("mSql = ");
            sb.append(((SQLiteProgram) this).mSql);
        }
        sb.append(") ");
        return sb.toString();
    }

    public void acquireReference() {
        synchronized (this.mLock) {
            int i2 = this.mReferenceCount;
            if (i2 > 0) {
                this.mReferenceCount = i2 + 1;
            } else {
                throw new IllegalStateException("attempt to re-open an already-closed object: " + getObjInfo());
            }
        }
    }

    public abstract void onAllReferencesReleased();

    public void onAllReferencesReleasedFromContainer() {
    }

    public void releaseReference() {
        synchronized (this.mLock) {
            int i2 = this.mReferenceCount - 1;
            this.mReferenceCount = i2;
            if (i2 == 0) {
                onAllReferencesReleased();
            }
        }
    }

    public void releaseReferenceFromContainer() {
        synchronized (this.mLock) {
            int i2 = this.mReferenceCount - 1;
            this.mReferenceCount = i2;
            if (i2 == 0) {
                onAllReferencesReleasedFromContainer();
            }
        }
    }
}
