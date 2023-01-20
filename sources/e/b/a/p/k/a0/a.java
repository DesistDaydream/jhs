package e.b.a.p.k.a0;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import e.b.a.p.k.x.e;
import e.b.a.p.k.y.j;
import e.b.a.p.m.d.g;
import e.b.a.v.n;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class a implements Runnable {
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    public static final String f9488i = "PreFillRunner";

    /* renamed from: k  reason: collision with root package name */
    public static final long f9490k = 32;

    /* renamed from: l  reason: collision with root package name */
    public static final long f9491l = 40;

    /* renamed from: m  reason: collision with root package name */
    public static final int f9492m = 4;
    private final e a;
    private final j b;

    /* renamed from: c  reason: collision with root package name */
    private final c f9493c;

    /* renamed from: d  reason: collision with root package name */
    private final C0308a f9494d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<d> f9495e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f9496f;

    /* renamed from: g  reason: collision with root package name */
    private long f9497g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9498h;

    /* renamed from: j  reason: collision with root package name */
    private static final C0308a f9489j = new C0308a();
    public static final long n = TimeUnit.SECONDS.toMillis(1);

    @VisibleForTesting
    /* renamed from: e.b.a.p.k.a0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0308a {
        public long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements e.b.a.p.c {
        @Override // e.b.a.p.c
        public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public a(e eVar, j jVar, c cVar) {
        this(eVar, jVar, cVar, f9489j, new Handler(Looper.getMainLooper()));
    }

    private long c() {
        return this.b.e() - this.b.getCurrentSize();
    }

    private long d() {
        long j2 = this.f9497g;
        this.f9497g = Math.min(4 * j2, n);
        return j2;
    }

    private boolean e(long j2) {
        return this.f9494d.a() - j2 >= 32;
    }

    @VisibleForTesting
    public boolean a() {
        Bitmap createBitmap;
        long a = this.f9494d.a();
        while (!this.f9493c.b() && !e(a)) {
            d c2 = this.f9493c.c();
            if (!this.f9495e.contains(c2)) {
                this.f9495e.add(c2);
                createBitmap = this.a.g(c2.d(), c2.b(), c2.a());
            } else {
                createBitmap = Bitmap.createBitmap(c2.d(), c2.b(), c2.a());
            }
            int h2 = n.h(createBitmap);
            if (c() >= h2) {
                this.b.d(new b(), g.d(createBitmap, this.a));
            } else {
                this.a.d(createBitmap);
            }
            if (Log.isLoggable(f9488i, 3)) {
                Log.d(f9488i, "allocated [" + c2.d() + "x" + c2.b() + "] " + c2.a() + " size: " + h2);
            }
        }
        return (this.f9498h || this.f9493c.b()) ? false : true;
    }

    public void b() {
        this.f9498h = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a()) {
            this.f9496f.postDelayed(this, d());
        }
    }

    @VisibleForTesting
    public a(e eVar, j jVar, c cVar, C0308a c0308a, Handler handler) {
        this.f9495e = new HashSet();
        this.f9497g = 40L;
        this.a = eVar;
        this.b = jVar;
        this.f9493c = cVar;
        this.f9494d = c0308a;
        this.f9496f = handler;
    }
}
