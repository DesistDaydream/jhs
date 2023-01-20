package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class c {
    private static c a;
    private ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private Context f7306c;

    private c() {
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        c cVar = a;
        cVar.f7306c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.b.get(str) == null) {
            a a2 = a.a(this.f7306c, str);
            this.b.put(str, a2);
            return a2;
        }
        return this.b.get(str);
    }

    public synchronized void b(String str) {
        c(str).b();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private AtomicInteger a = new AtomicInteger();
        private SQLiteOpenHelper b;

        /* renamed from: c  reason: collision with root package name */
        private SQLiteDatabase f7307c;

        private a() {
        }

        public static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.b = b.a(appContext, str);
            return aVar;
        }

        public synchronized void b() {
            try {
                if (this.a.decrementAndGet() == 0) {
                    this.f7307c.close();
                }
            } catch (Throwable unused) {
            }
        }

        public synchronized SQLiteDatabase a() {
            if (this.a.incrementAndGet() == 1) {
                this.f7307c = this.b.getWritableDatabase();
            }
            return this.f7307c;
        }
    }

    public synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
