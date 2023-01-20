package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.List;

/* loaded from: classes3.dex */
public final class p extends SQLiteOpenHelper {
    public static String a = "bugly_db";
    private static int b = 16;

    /* renamed from: c  reason: collision with root package name */
    private Context f6780c;

    /* renamed from: d  reason: collision with root package name */
    private List<com.tencent.bugly.a> f6781d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, List<com.tencent.bugly.a> list) {
        super(context, a + "_", (SQLiteDatabase.CursorFactory) null, b);
        com.tencent.bugly.crashreport.common.info.a.a(context).getClass();
        this.f6780c = context;
        this.f6781d = list;
    }

    private synchronized boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            String[] strArr = {"t_lr", "t_ui", "t_pf"};
            for (int i2 = 0; i2 < 3; i2++) {
                String str = strArr[i2];
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str, new String[0]);
            }
        } catch (Throwable th) {
            if (!y.b(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i2 = 0;
        while (sQLiteDatabase == null && i2 < 5) {
            i2++;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                y.d("[Database] Try to get db(count: %d).", Integer.valueOf(i2));
                if (i2 == 5) {
                    y.e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i2 = 0;
        while (sQLiteDatabase == null && i2 < 5) {
            i2++;
            sQLiteDatabase = super.getWritableDatabase();
        }
        if (sQLiteDatabase == null) {
            y.d("[Database] db error delay error record 1min.", new Object[0]);
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_ui");
            sb.append(" ( _id");
            sb.append(" INTEGER PRIMARY KEY");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _ut");
            sb.append(" int");
            sb.append(" , _tp");
            sb.append(" int");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(" , _pc");
            sb.append(" text");
            sb.append(" ) ");
            y.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_lr");
            sb.append(" ( _id");
            sb.append(" INTEGER PRIMARY KEY");
            sb.append(" , _tp");
            sb.append(" int");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _pc");
            sb.append(" text");
            sb.append(" , _th");
            sb.append(" text");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(" ) ");
            y.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_pf");
            sb.append(" ( _id");
            sb.append(" integer");
            sb.append(" , _tp");
            sb.append(" text");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(",primary key(_id");
            sb.append(",_tp");
            sb.append(" )) ");
            y.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_cr");
            sb.append(" ( _id");
            sb.append(" INTEGER PRIMARY KEY");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _s1");
            sb.append(" text");
            sb.append(" , _up");
            sb.append(" int");
            sb.append(" , _me");
            sb.append(" int");
            sb.append(" , _uc");
            sb.append(" int");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(" ) ");
            y.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS dl_1002");
            sb.append(" (_id");
            sb.append(" integer primary key autoincrement, _dUrl");
            sb.append(" varchar(100), _sFile");
            sb.append(" varchar(100), _sLen");
            sb.append(" INTEGER, _tLen");
            sb.append(" INTEGER, _MD5");
            sb.append(" varchar(100), _DLTIME");
            sb.append(" INTEGER)");
            y.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append("CREATE TABLE IF NOT EXISTS ge_1002");
            sb.append(" (_id");
            sb.append(" integer primary key autoincrement, _time");
            sb.append(" INTEGER, _datas");
            sb.append(" blob)");
            y.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS st_1002");
            sb.append(" ( _id");
            sb.append(" integer");
            sb.append(" , _tp");
            sb.append(" text");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(",primary key(_id");
            sb.append(",_tp");
            sb.append(" )) ");
            y.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_sla");
            sb.append(" ( _id");
            sb.append(" TEXT NOT NULL , _tm");
            sb.append(" INTEGER NOT NULL , _dt");
            sb.append(" TEXT NOT NULL , PRIMARY KEY(");
            sb.append("_id)");
            sb.append(" ) ");
            String sb2 = sb.toString();
            y.c(sb2, new Object[0]);
            sQLiteDatabase.execSQL(sb2, new String[0]);
            List<com.tencent.bugly.a> list = this.f6781d;
            if (list == null) {
                return;
            }
            for (com.tencent.bugly.a aVar : list) {
                aVar.onDbCreate(sQLiteDatabase);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (com.tencent.bugly.crashreport.common.info.b.c() >= 11) {
            y.d("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i2), Integer.valueOf(i3));
            List<com.tencent.bugly.a> list = this.f6781d;
            if (list != null) {
                for (com.tencent.bugly.a aVar : list) {
                    aVar.onDbDowngrade(sQLiteDatabase, i2, i3);
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            y.d("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f6780c.getDatabasePath(a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        y.d("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i2), Integer.valueOf(i3));
        List<com.tencent.bugly.a> list = this.f6781d;
        if (list != null) {
            for (com.tencent.bugly.a aVar : list) {
                aVar.onDbUpgrade(sQLiteDatabase, i2, i3);
            }
        }
        if (a(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
            return;
        }
        y.d("[Database] Failed to drop, delete db.", new Object[0]);
        File databasePath = this.f6780c.getDatabasePath(a);
        if (databasePath != null && databasePath.canWrite()) {
            databasePath.delete();
        }
    }
}
