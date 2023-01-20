package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.jj;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class ba implements t {

    /* renamed from: f  reason: collision with root package name */
    private static volatile ba f9122f;
    public Context a;
    private SharedPreferences b;

    /* renamed from: c  reason: collision with root package name */
    private long f9123c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f9124d = false;

    /* renamed from: e  reason: collision with root package name */
    private ConcurrentHashMap<String, a> f9125e = new ConcurrentHashMap<>();

    /* loaded from: classes3.dex */
    public static abstract class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        public String f9126c;

        /* renamed from: d  reason: collision with root package name */
        public long f9127d;

        public a(String str, long j2) {
            this.f9126c = str;
            this.f9127d = j2;
        }

        public abstract void a(ba baVar);

        @Override // java.lang.Runnable
        public void run() {
            if (ba.f9122f != null) {
                Context context = ba.f9122f.a;
                if (com.xiaomi.push.al.e(context)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences sharedPreferences = ba.f9122f.b;
                    if (currentTimeMillis - sharedPreferences.getLong(":ts-" + this.f9126c, 0L) > this.f9127d || com.xiaomi.push.j.a(context)) {
                        SharedPreferences.Editor edit = ba.f9122f.b.edit();
                        jj.a(edit.putLong(":ts-" + this.f9126c, System.currentTimeMillis()));
                        a(ba.f9122f);
                    }
                }
            }
        }
    }

    private ba(Context context) {
        this.a = context.getApplicationContext();
        this.b = context.getSharedPreferences("sync", 0);
    }

    public static ba a(Context context) {
        if (f9122f == null) {
            synchronized (ba.class) {
                if (f9122f == null) {
                    f9122f = new ba(context);
                }
            }
        }
        return f9122f;
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.b;
        return sharedPreferences.getString(str + Constants.COLON_SEPARATOR + str2, "");
    }

    @Override // com.xiaomi.push.service.t
    public void a() {
        if (this.f9124d) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f9123c < com.heytap.mcssdk.constant.a.f3315e) {
            return;
        }
        this.f9123c = currentTimeMillis;
        this.f9124d = true;
        com.xiaomi.push.m.a(this.a).a(new bb(this), (int) (Math.random() * 10.0d));
    }

    public void a(a aVar) {
        if (this.f9125e.putIfAbsent(aVar.f9126c, aVar) == null) {
            com.xiaomi.push.m.a(this.a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = f9122f.b.edit();
        jj.a(edit.putString(str + Constants.COLON_SEPARATOR + str2, str3));
    }
}
