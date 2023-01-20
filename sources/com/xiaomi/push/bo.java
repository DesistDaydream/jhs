package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.push.bm;

/* loaded from: classes3.dex */
public class bo implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ bm.a b;

    public bo(bm.a aVar, Context context) {
        this.b = aVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.b.d();
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.beginTransaction();
                    this.b.a(this.a, sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        e = e2;
                        com.xiaomi.a.a.a.c.a(e);
                        this.b.a(this.a);
                    }
                }
                bk bkVar = this.b.f8283c;
                if (bkVar != null) {
                    bkVar.close();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        com.xiaomi.a.a.a.c.a(e3);
                        this.b.a(this.a);
                        throw th;
                    }
                }
                bk bkVar2 = this.b.f8283c;
                if (bkVar2 != null) {
                    bkVar2.close();
                }
                this.b.a(this.a);
                throw th;
            }
        } catch (Exception e4) {
            com.xiaomi.a.a.a.c.a(e4);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e5) {
                    e = e5;
                    com.xiaomi.a.a.a.c.a(e);
                    this.b.a(this.a);
                }
            }
            bk bkVar3 = this.b.f8283c;
            if (bkVar3 != null) {
                bkVar3.close();
            }
        }
        this.b.a(this.a);
    }
}
