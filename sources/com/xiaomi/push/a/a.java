package com.xiaomi.push.a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.xiaomi.a.a.a.c;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes3.dex */
public class a extends SQLiteOpenHelper {
    private static int b = 1;
    public static final Object a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f8236c = {"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};

    public a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, b);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        int i2 = 0;
        while (true) {
            String[] strArr = f8236c;
            if (i2 >= strArr.length - 1) {
                sb.append(");");
                sQLiteDatabase.execSQL(sb.toString());
                return;
            }
            if (i2 != 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(strArr[i2]);
            sb.append(ExpandableTextView.N);
            sb.append(strArr[i2 + 1]);
            i2 += 2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (a) {
            try {
                a(sQLiteDatabase);
            } catch (SQLException e2) {
                c.a(e2);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
