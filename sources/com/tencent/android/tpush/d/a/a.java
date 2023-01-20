package com.tencent.android.tpush.d.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.android.tpush.logging.TLogger;

/* loaded from: classes3.dex */
public class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "xg_message_vip.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE messagetoshow (_id INTEGER PRIMARY KEY AUTOINCREMENT, msgid INTEGER, message TEXT, time INTEGER, busiid INTEGER, showedtime INTEGER, status INTEGER, UNIQUE (msgid) ON CONFLICT IGNORE);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        TLogger.d("MessageInfoDBHelper", "action - onCreate");
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        TLogger.d("MessageInfoDBHelper", "action - onUpgrade");
    }
}
