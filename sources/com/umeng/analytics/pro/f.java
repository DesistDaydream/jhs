package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.e;

/* loaded from: classes3.dex */
public class f extends SQLiteOpenHelper {
    private static Context b;
    private String a;

    /* loaded from: classes3.dex */
    public static class a {
        private static final f a = new f(f.b, h.b(f.b), e.b, null, 2);

        private a() {
        }
    }

    public static f a(Context context) {
        if (b == null) {
            b = context.getApplicationContext();
        }
        return a.a;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!h.a(sQLiteDatabase, e.d.a, "__av")) {
            h.a(sQLiteDatabase, e.d.a, "__sp", "TEXT");
            h.a(sQLiteDatabase, e.d.a, "__pp", "TEXT");
            h.a(sQLiteDatabase, e.d.a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.d.a, "__vc", "TEXT");
        }
        if (!h.a(sQLiteDatabase, e.b.a, "__av")) {
            h.a(sQLiteDatabase, e.b.a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.b.a, "__vc", "TEXT");
        }
        if (h.a(sQLiteDatabase, e.a.a, "__av")) {
            return;
        }
        h.a(sQLiteDatabase, e.a.a, "__av", "TEXT");
        h.a(sQLiteDatabase, e.a.a, "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, e.d.a);
        a(sQLiteDatabase, e.b.a);
        a(sQLiteDatabase, e.a.a);
        a();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                c(sQLiteDatabase);
                d(sQLiteDatabase);
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(b);
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i3 <= i2 || i2 != 1) {
            return;
        }
        try {
            try {
                e(sQLiteDatabase);
            } catch (Exception unused) {
                e(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            f(sQLiteDatabase);
        }
    }

    private f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        this(new c(context, str), str2, cursorFactory, i2);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private f(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, TextUtils.isEmpty(str) ? e.b : str, cursorFactory, i2);
        this.a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!h.a(e.d.a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!h.a(e.c.a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!h.a(e.b.a, writableDatabase)) {
                b(writableDatabase);
            }
            if (h.a(e.a.a, writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
