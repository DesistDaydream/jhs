package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;

/* loaded from: classes.dex */
public class b {
    private static final Object b = new Object();
    private c a;

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0051b extends AbstractCursor {
        private C0051b(b bVar) {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i2) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i2) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i2) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i2) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i2) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i2) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i2) {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class c {
        private volatile SQLiteDatabase a = null;

        public c() {
        }

        private void a() {
            synchronized (this) {
                try {
                    synchronized (b.b) {
                        if (this.a == null || !this.a.isOpen()) {
                            this.a = j.l().e().a(j.l().d());
                            this.a.setLockingEnabled(false);
                            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("---------------DB CREATE  SUCCESS------------");
                        }
                    }
                } finally {
                }
            }
        }

        private boolean b() {
            boolean z;
            synchronized (this) {
                SQLiteDatabase sQLiteDatabase = this.a;
                if (sQLiteDatabase != null) {
                    z = sQLiteDatabase.inTransaction();
                }
            }
            return z;
        }

        public long a(String str, String str2, ContentValues contentValues) {
            long j2;
            synchronized (this) {
                try {
                    a();
                    j2 = this.a.insert(str, str2, contentValues);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (b()) {
                        throw e2;
                    }
                    j2 = -1;
                }
            }
            return j2;
        }

        public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursor;
            synchronized (this) {
                try {
                    a();
                    cursor = this.a.query(str, strArr, str2, strArr2, str3, str4, str5);
                } catch (Throwable th) {
                    th.printStackTrace();
                    C0051b c0051b = new C0051b();
                    if (b()) {
                        throw th;
                    }
                    cursor = c0051b;
                }
            }
            return cursor;
        }

        public void a(String str) throws SQLException {
            synchronized (this) {
                try {
                    a();
                    this.a.execSQL(str);
                } catch (Throwable th) {
                    if (b()) {
                        throw th;
                    }
                }
            }
        }
    }

    public b(Context context) {
        try {
            context.getApplicationContext();
            if (this.a == null) {
                this.a = new c();
            }
        } catch (Throwable unused) {
        }
    }

    public c a() {
        return this.a;
    }
}
