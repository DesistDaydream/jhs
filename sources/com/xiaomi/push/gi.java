package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.moor.imkf.lib.jobqueue.base.JobManager;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class gi {
    private static p a = new p(true);
    private static volatile int b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static long f8667c = System.currentTimeMillis();

    /* renamed from: d  reason: collision with root package name */
    private static final Object f8668d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static List<a> f8669e = Collections.synchronizedList(new ArrayList());

    /* renamed from: f  reason: collision with root package name */
    private static String f8670f = "";

    /* renamed from: g  reason: collision with root package name */
    private static com.xiaomi.push.a.a f8671g = null;

    /* loaded from: classes3.dex */
    public static class a {
        public String a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        public int f8672c;

        /* renamed from: d  reason: collision with root package name */
        public int f8673d;

        /* renamed from: e  reason: collision with root package name */
        public String f8674e;

        /* renamed from: f  reason: collision with root package name */
        public long f8675f;

        public a(String str, long j2, int i2, int i3, String str2, long j3) {
            this.a = "";
            this.b = 0L;
            this.f8672c = -1;
            this.f8673d = -1;
            this.f8674e = "";
            this.f8675f = 0L;
            this.a = str;
            this.b = j2;
            this.f8672c = i2;
            this.f8673d = i3;
            this.f8674e = str2;
            this.f8675f = j3;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.a, this.a) && TextUtils.equals(aVar.f8674e, this.f8674e) && aVar.f8672c == this.f8672c && aVar.f8673d == this.f8673d && Math.abs(aVar.b - this.b) <= 5000;
        }
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    private static long a(int i2, long j2, boolean z, long j3, boolean z2) {
        if (z && z2) {
            long j4 = f8667c;
            f8667c = j3;
            if (j3 - j4 > JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS && j2 > 1024) {
                return j2 * 2;
            }
        }
        return (j2 * (i2 == 0 ? 13 : 11)) / 10;
    }

    public static void a(Context context) {
        b = c(context);
    }

    private static void a(Context context, String str, long j2, boolean z, long j3) {
        int b2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (b2 = b(context))) {
            return;
        }
        synchronized (f8668d) {
            isEmpty = f8669e.isEmpty();
            a(new a(str, j3, b2, z ? 1 : 0, b2 == 0 ? d(context) : "", j2));
        }
        if (isEmpty) {
            a.a(new gj(context), 5000L);
        }
    }

    public static void a(Context context, String str, long j2, boolean z, boolean z2, long j3) {
        a(context, str, a(b(context), j2, z, j3, z2), z, j3);
    }

    private static void a(a aVar) {
        for (a aVar2 : f8669e) {
            if (aVar2.a(aVar)) {
                aVar2.f8675f += aVar.f8675f;
                return;
            }
        }
        f8669e.add(aVar);
    }

    public static int b(Context context) {
        if (b == -1) {
            b = c(context);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.a.a.a) {
                SQLiteDatabase writableDatabase = e(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("package_name", aVar.a);
                    contentValues.put("message_ts", Long.valueOf(aVar.b));
                    contentValues.put("network_type", Integer.valueOf(aVar.f8672c));
                    contentValues.put("bytes", Long.valueOf(aVar.f8675f));
                    contentValues.put("rcv", Integer.valueOf(aVar.f8673d));
                    contentValues.put("imsi", aVar.f8674e);
                    writableDatabase.insert(com.umeng.analytics.pro.d.F, null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.a(th);
        }
    }

    private static int c(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    private static synchronized String d(Context context) {
        synchronized (gi.class) {
            if (TextUtils.isEmpty(f8670f)) {
                return "";
            }
            return f8670f;
        }
    }

    private static com.xiaomi.push.a.a e(Context context) {
        com.xiaomi.push.a.a aVar = f8671g;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.a.a aVar2 = new com.xiaomi.push.a.a(context);
        f8671g = aVar2;
        return aVar2;
    }
}
