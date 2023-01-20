package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;
import bykvm_19do.bykvm_19do.bykvm_19do.e;
import bykvm_19do.bykvm_19do.bykvm_19do.v0;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class z0 {

    /* renamed from: i  reason: collision with root package name */
    private static e f204i;

    /* renamed from: j  reason: collision with root package name */
    private static String f205j;
    private a1 b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f206c;

    /* renamed from: d  reason: collision with root package name */
    private d1 f207d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f208e;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, String> f210g;

    /* renamed from: h  reason: collision with root package name */
    private Long f211h;
    private final ReentrantLock a = new ReentrantLock();

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f209f = new AtomicBoolean(false);

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            z0.this.b(this.a);
        }
    }

    public z0(Context context) {
        this.f208e = context;
        a(context);
        this.f207d = new d1(context);
    }

    private void a(Context context) {
        a1 a2 = b1.a(context);
        this.b = a2;
        this.f206c = a2 != null ? a2.a(context) : false;
    }

    private static void a(e.a aVar) {
        e eVar;
        if (aVar == null || (eVar = f204i) == null) {
            return;
        }
        eVar.a(aVar);
    }

    public static void a(e eVar) {
        f204i = eVar;
        String str = f205j;
        if (str != null) {
            a(new e.a(str));
        }
    }

    private static void a(Runnable runnable) {
        u0.a("Oaid#-query", runnable);
    }

    public static <K, V> void a(Map<K, V> map, K k2, V v) {
        if (k2 == null || v == null) {
            return;
        }
        map.put(k2, v);
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @NonNull
    @WorkerThread
    private Pair<String, Boolean> b(Context context) {
        Boolean bool;
        a1.a b;
        a1 a1Var = this.b;
        String str = null;
        if (a1Var == null || (b = a1Var.b(context)) == null) {
            bool = null;
        } else {
            str = b.a;
            boolean z = b.b;
            if (b instanceof v0.c) {
                this.f211h = Long.valueOf(((v0.c) b).f175c);
            }
            bool = Boolean.valueOf(z);
        }
        return new Pair<>(str, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int i2;
        t0.b("Oaid#", "Oaid#initOaid");
        try {
            this.a.lock();
            c1 c1Var = null;
            String str = null;
            if (z) {
                t0.b("Oaid#", "Oaid#initOaid clear");
                this.f207d.b();
                f205j = null;
                this.f210g = null;
            }
            t0.b("Oaid#", "Oaid#initOaid exec");
            c1 a2 = this.f207d.a();
            t0.b("Oaid#", "Oaid#initOaid fetch=" + a2);
            if (a2 != null) {
                f205j = a2.a;
                this.f210g = a2.a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> b = b(this.f208e);
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (b.first != null) {
                int i3 = 1;
                if (a2 != null) {
                    str = a2.b;
                    i2 = a2.f98f.intValue() + 1;
                } else {
                    i2 = -1;
                }
                if (TextUtils.isEmpty(str)) {
                    str = UUID.randomUUID().toString();
                }
                String str2 = str;
                if (i2 > 0) {
                    i3 = i2;
                }
                c1 c1Var2 = new c1((String) b.first, str2, (Boolean) b.second, Long.valueOf(elapsedRealtime2 - elapsedRealtime), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i3), this.f211h);
                this.f207d.a(c1Var2);
                c1Var = c1Var2;
            }
            if (c1Var != null) {
                f205j = c1Var.a;
                this.f210g = c1Var.a();
            }
            t0.b("Oaid#", "Oaid#initOaid oaidModel=" + c1Var);
        } finally {
            this.a.unlock();
            a(new e.a(f205j));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0060, code lost:
        if (r0 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0062, code lost:
        r7.a.unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0057, code lost:
        if (r0 != false) goto L11;
     */
    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.String> a(long r8) {
        /*
            r7 = this;
            boolean r0 = r7.f206c
            if (r0 != 0) goto L7
            r8 = 0
            goto L88
        L7:
            r0 = 0
            r7.a(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Oaid#getOaid timeoutMills="
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "Oaid#"
            bykvm_19do.bykvm_19do.bykvm_19do.t0.a(r2, r1)
            java.util.Map<java.lang.String, java.lang.String> r1 = r7.f210g
            if (r1 != 0) goto L70
            long r3 = android.os.SystemClock.elapsedRealtime()
            java.util.concurrent.locks.ReentrantLock r1 = r7.a     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L5c
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L5c
            boolean r0 = r1.tryLock(r8, r5)     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L5c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L5c
            r8.<init>()     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L5c
            java.lang.String r9 = "Oaid#getOaid locked="
            r8.append(r9)     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L5c
            r8.append(r0)     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L5c
            java.lang.String r9 = ", took "
            r8.append(r9)     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L5c
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L5c
            long r5 = r5 - r3
            r8.append(r5)     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L5c
            java.lang.String r9 = " ms"
            r8.append(r9)     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L5c
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L5c
            bykvm_19do.bykvm_19do.bykvm_19do.t0.b(r2, r8)     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L5c
            if (r0 == 0) goto L70
            goto L62
        L5a:
            r8 = move-exception
            goto L68
        L5c:
            r8 = move-exception
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L5a
            if (r0 == 0) goto L70
        L62:
            java.util.concurrent.locks.ReentrantLock r8 = r7.a
            r8.unlock()
            goto L70
        L68:
            if (r0 == 0) goto L6f
            java.util.concurrent.locks.ReentrantLock r9 = r7.a
            r9.unlock()
        L6f:
            throw r8
        L70:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Oaid#getOaid return apiMap="
            r8.append(r9)
            java.util.Map<java.lang.String, java.lang.String> r9 = r7.f210g
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            bykvm_19do.bykvm_19do.bykvm_19do.t0.a(r2, r8)
            java.util.Map<java.lang.String, java.lang.String> r8 = r7.f210g
        L88:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.z0.a(long):java.util.Map");
    }

    public void a(boolean z) {
        if (z || this.f209f.compareAndSet(false, true)) {
            a(new a(z));
        }
    }
}
