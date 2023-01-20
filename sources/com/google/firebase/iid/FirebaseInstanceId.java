package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.moor.imkf.lib.jobqueue.base.JobManager;
import e.j.a.b.c.x.d0;
import e.j.a.b.j.c;
import e.j.a.b.j.k;
import e.j.a.b.j.n;
import e.j.d.e.b;
import e.j.d.e.d;
import e.j.d.f.f0;
import e.j.d.f.j;
import e.j.d.f.m0;
import e.j.d.f.o;
import e.j.d.f.q;
import e.j.d.f.t;
import e.j.d.f.u;
import e.j.d.f.u0;
import e.j.d.f.w;
import e.j.d.f.y;
import e.j.d.j.g;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public class FirebaseInstanceId {

    /* renamed from: i */
    private static final long f3154i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: j */
    private static u f3155j;
    @GuardedBy("FirebaseInstanceId.class")
    @d0

    /* renamed from: k */
    private static ScheduledExecutorService f3156k;
    private final Executor a;
    private final FirebaseApp b;

    /* renamed from: c */
    private final j f3157c;

    /* renamed from: d */
    private final m0 f3158d;

    /* renamed from: e */
    private final o f3159e;

    /* renamed from: f */
    private final y f3160f;
    @GuardedBy("this")

    /* renamed from: g */
    private boolean f3161g;

    /* renamed from: h */
    private final a f3162h;

    /* loaded from: classes2.dex */
    public class a {
        private final boolean a;
        private final d b;
        @Nullable
        @GuardedBy("this")

        /* renamed from: c */
        private b<DataCollectionDefaultChange> f3163c;
        @Nullable
        @GuardedBy("this")

        /* renamed from: d */
        private Boolean f3164d;

        public a(d dVar) {
            FirebaseInstanceId.this = r2;
            this.b = dVar;
            boolean d2 = d();
            this.a = d2;
            Boolean c2 = c();
            this.f3164d = c2;
            if (c2 == null && d2) {
                b<DataCollectionDefaultChange> bVar = new b(this) { // from class: e.j.d.f.l0
                    private final FirebaseInstanceId.a a;

                    {
                        this.a = this;
                    }

                    @Override // e.j.d.e.b
                    public final void a(e.j.d.e.a aVar) {
                        FirebaseInstanceId.a aVar2 = this.a;
                        synchronized (aVar2) {
                            if (aVar2.b()) {
                                FirebaseInstanceId.this.H();
                            }
                        }
                    }
                };
                this.f3163c = bVar;
                dVar.a(DataCollectionDefaultChange.class, bVar);
            }
        }

        @Nullable
        private final Boolean c() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context applicationContext = FirebaseInstanceId.this.b.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        private final boolean d() {
            try {
                Class.forName("e.j.d.i.a");
                return true;
            } catch (ClassNotFoundException unused) {
                Context applicationContext = FirebaseInstanceId.this.b.getApplicationContext();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(applicationContext.getPackageName());
                ResolveInfo resolveService = applicationContext.getPackageManager().resolveService(intent, 0);
                return (resolveService == null || resolveService.serviceInfo == null) ? false : true;
            }
        }

        public final synchronized void a(boolean z) {
            b<DataCollectionDefaultChange> bVar = this.f3163c;
            if (bVar != null) {
                this.b.d(DataCollectionDefaultChange.class, bVar);
                this.f3163c = null;
            }
            SharedPreferences.Editor edit = FirebaseInstanceId.this.b.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z);
            edit.apply();
            if (z) {
                FirebaseInstanceId.this.H();
            }
            this.f3164d = Boolean.valueOf(z);
        }

        public final synchronized boolean b() {
            Boolean bool = this.f3164d;
            if (bool != null) {
                return bool.booleanValue();
            }
            return this.a && FirebaseInstanceId.this.b.isDataCollectionDefaultEnabled();
        }
    }

    public FirebaseInstanceId(FirebaseApp firebaseApp, d dVar, g gVar) {
        this(firebaseApp, new j(firebaseApp.getApplicationContext()), f0.c(), f0.c(), dVar, gVar);
    }

    private static String B(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    public static boolean C() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
    }

    public final void H() {
        if (t(u()) || this.f3160f.b()) {
            I();
        }
    }

    private final synchronized void I() {
        if (!this.f3161g) {
            q(0L);
        }
    }

    private static String J() {
        return f3155j.f("").b();
    }

    public static FirebaseInstanceId e() {
        return getInstance(FirebaseApp.getInstance());
    }

    @Keep
    public static FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        return (FirebaseInstanceId) firebaseApp.get(FirebaseInstanceId.class);
    }

    private final k<e.j.d.f.a> j(String str, String str2) {
        return n.e(null).p(this.a, new c(this, str, B(str2)) { // from class: e.j.d.f.i0
            private final FirebaseInstanceId a;
            private final String b;

            /* renamed from: c */
            private final String f11235c;

            {
                this.a = this;
                this.b = str;
                this.f11235c = r3;
            }

            @Override // e.j.a.b.j.c
            public final Object a(e.j.a.b.j.k kVar) {
                return this.a.k(this.b, this.f11235c, kVar);
            }
        });
    }

    private final <T> T p(k<T> kVar) throws IOException {
        try {
            return (T) n.b(kVar, JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    D();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e2);
            }
        }
    }

    public static void r(Runnable runnable, long j2) {
        synchronized (FirebaseInstanceId.class) {
            if (f3156k == null) {
                f3156k = new ScheduledThreadPoolExecutor(1, new e.j.a.b.c.x.f0.b("FirebaseInstanceId"));
            }
            f3156k.schedule(runnable, j2, TimeUnit.SECONDS);
        }
    }

    @Nullable
    @d0
    private static t v(String str, String str2) {
        return f3155j.a("", str, str2);
    }

    public final void A(String str) throws IOException {
        t u = u();
        if (!t(u)) {
            p(this.f3158d.k(J(), u.a, str));
            return;
        }
        throw new IOException("token not available");
    }

    public final synchronized void D() {
        f3155j.g();
        if (this.f3162h.b()) {
            I();
        }
    }

    public final boolean E() {
        return this.f3157c.a() != 0;
    }

    public final void F() {
        f3155j.j("");
        I();
    }

    @d0
    public final boolean G() {
        return this.f3162h.b();
    }

    @WorkerThread
    public void a() throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            p(this.f3158d.b(J()));
            D();
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    @WorkerThread
    public void b(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            String B = B(str2);
            p(this.f3158d.i(J(), str, B));
            f3155j.h("", str, B);
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    public long c() {
        return f3155j.f("").c();
    }

    @WorkerThread
    public String d() {
        H();
        return J();
    }

    @NonNull
    public k<e.j.d.f.a> f() {
        return j(j.c(this.b), "*");
    }

    @Nullable
    @Deprecated
    public String g() {
        t u = u();
        if (t(u)) {
            I();
        }
        return t.b(u);
    }

    @WorkerThread
    public String h(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((e.j.d.f.a) p(j(str, str2))).getToken();
        }
        throw new IOException("MAIN_THREAD");
    }

    public final synchronized k<Void> i(String str) {
        k<Void> a2;
        a2 = this.f3160f.a(str);
        I();
        return a2;
    }

    public final /* synthetic */ k k(String str, String str2, k kVar) throws Exception {
        String J = J();
        t v = v(str, str2);
        if (!t(v)) {
            return n.e(new u0(J, v.a));
        }
        return this.f3159e.b(str, str2, new q(this, J, str, str2) { // from class: e.j.d.f.k0
            private final FirebaseInstanceId a;
            private final String b;

            /* renamed from: c */
            private final String f11241c;

            /* renamed from: d */
            private final String f11242d;

            {
                this.a = this;
                this.b = J;
                this.f11241c = str;
                this.f11242d = str2;
            }

            @Override // e.j.d.f.q
            public final e.j.a.b.j.k a() {
                return this.a.l(this.b, this.f11241c, this.f11242d);
            }
        });
    }

    public final /* synthetic */ k l(String str, String str2, String str3) {
        return this.f3158d.c(str, str2, str3).x(this.a, new e.j.a.b.j.j(this, str2, str3, str) { // from class: e.j.d.f.j0
            private final FirebaseInstanceId a;
            private final String b;

            /* renamed from: c */
            private final String f11239c;

            /* renamed from: d */
            private final String f11240d;

            {
                this.a = this;
                this.b = str2;
                this.f11239c = str3;
                this.f11240d = str;
            }

            @Override // e.j.a.b.j.j
            public final e.j.a.b.j.k a(Object obj) {
                return this.a.m(this.b, this.f11239c, this.f11240d, (String) obj);
            }
        });
    }

    public final /* synthetic */ k m(String str, String str2, String str3, String str4) throws Exception {
        f3155j.e("", str, str2, str4, this.f3157c.e());
        return n.e(new u0(str3, str4));
    }

    public final FirebaseApp n() {
        return this.b;
    }

    public final synchronized void q(long j2) {
        r(new w(this, this.f3157c, this.f3160f, Math.min(Math.max(30L, j2 << 1), f3154i)), j2);
        this.f3161g = true;
    }

    public final synchronized void s(boolean z) {
        this.f3161g = z;
    }

    public final boolean t(@Nullable t tVar) {
        return tVar == null || tVar.d(this.f3157c.e());
    }

    @Nullable
    public final t u() {
        return v(j.c(this.b), "*");
    }

    public final void x(String str) throws IOException {
        t u = u();
        if (!t(u)) {
            p(this.f3158d.j(J(), u.a, str));
            return;
        }
        throw new IOException("token not available");
    }

    @d0
    public final void y(boolean z) {
        this.f3162h.a(z);
    }

    public final String z() throws IOException {
        return h(j.c(this.b), "*");
    }

    private FirebaseInstanceId(FirebaseApp firebaseApp, j jVar, Executor executor, Executor executor2, d dVar, g gVar) {
        this.f3161g = false;
        if (j.c(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (f3155j == null) {
                    f3155j = new u(firebaseApp.getApplicationContext());
                }
            }
            this.b = firebaseApp;
            this.f3157c = jVar;
            this.f3158d = new m0(firebaseApp, jVar, executor, gVar);
            this.a = executor2;
            this.f3160f = new y(f3155j);
            a aVar = new a(dVar);
            this.f3162h = aVar;
            this.f3159e = new o(executor);
            if (aVar.b()) {
                H();
                return;
            }
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }
}
