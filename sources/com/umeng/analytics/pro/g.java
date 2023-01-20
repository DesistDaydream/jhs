package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class g {
    private static SQLiteOpenHelper b;

    /* renamed from: d  reason: collision with root package name */
    private static Context f7187d;
    private AtomicInteger a;

    /* renamed from: c  reason: collision with root package name */
    private SQLiteDatabase f7188c;

    /* loaded from: classes3.dex */
    public static class a {
        private static final g a = new g();

        private a() {
        }
    }

    public static g a(Context context) {
        if (f7187d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            f7187d = applicationContext;
            b = f.a(applicationContext);
        }
        return a.a;
    }

    public synchronized void b() {
        try {
            if (this.a.decrementAndGet() == 0) {
                this.f7188c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private g() {
        this.a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        if (this.a.incrementAndGet() == 1) {
            this.f7188c = b.getWritableDatabase();
        }
        return this.f7188c;
    }
}
