package com.xiaomi.push;

import android.os.SystemClock;
import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aj;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class fb {
    public static boolean a;
    private static final AtomicInteger o = new AtomicInteger(0);

    /* renamed from: l  reason: collision with root package name */
    public fc f8580l;

    /* renamed from: m  reason: collision with root package name */
    public XMPushService f8581m;
    public int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f8571c = -1;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f8572d = 0;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f8573e = 0;
    private LinkedList<Pair<Integer, Long>> p = new LinkedList<>();
    private final Collection<fe> q = new CopyOnWriteArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final Map<fh, a> f8574f = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Map<fh, a> f8575g = new ConcurrentHashMap();

    /* renamed from: h  reason: collision with root package name */
    public fo f8576h = null;

    /* renamed from: i  reason: collision with root package name */
    public String f8577i = "";

    /* renamed from: j  reason: collision with root package name */
    public String f8578j = "";
    private int r = 2;

    /* renamed from: k  reason: collision with root package name */
    public final int f8579k = o.getAndIncrement();
    private long s = 0;
    public long n = 0;

    /* loaded from: classes3.dex */
    public static class a {
        private fh a;
        private fp b;

        public a(fh fhVar, fp fpVar) {
            this.a = fhVar;
            this.b = fpVar;
        }

        public void a(eq eqVar) {
            this.a.a(eqVar);
        }

        public void a(ft ftVar) {
            fp fpVar = this.b;
            if (fpVar == null || fpVar.a(ftVar)) {
                this.a.b(ftVar);
            }
        }
    }

    static {
        a = false;
        try {
            a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        fi.a();
    }

    public fb(XMPushService xMPushService, fc fcVar) {
        this.f8580l = fcVar;
        this.f8581m = xMPushService;
        i();
    }

    private String a(int i2) {
        return i2 == 1 ? "connected" : i2 == 0 ? "connecting" : i2 == 2 ? "disconnected" : "unknown";
    }

    private void b(int i2) {
        synchronized (this.p) {
            if (i2 == 1) {
                this.p.clear();
            } else {
                this.p.add(new Pair<>(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())));
                if (this.p.size() > 6) {
                    this.p.remove(0);
                }
            }
        }
    }

    public void a(int i2, int i3, Exception exc) {
        int i4 = this.r;
        if (i2 != i4) {
            com.xiaomi.a.a.a.c.a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i4), a(i2), com.xiaomi.push.service.an.a(i3)));
        }
        if (al.c(this.f8581m)) {
            b(i2);
        }
        if (i2 == 1) {
            this.f8581m.a(10);
            if (this.r != 0) {
                com.xiaomi.a.a.a.c.a("try set connected while not connecting.");
            }
            this.r = i2;
            for (fe feVar : this.q) {
                feVar.b(this);
            }
        } else if (i2 == 0) {
            if (this.r != 2) {
                com.xiaomi.a.a.a.c.a("try set connecting while not disconnected.");
            }
            this.r = i2;
            for (fe feVar2 : this.q) {
                feVar2.a(this);
            }
        } else if (i2 == 2) {
            this.f8581m.a(10);
            int i5 = this.r;
            if (i5 == 0) {
                for (fe feVar3 : this.q) {
                    feVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i5 == 1) {
                for (fe feVar4 : this.q) {
                    feVar4.a(this, i3, exc);
                }
            }
            this.r = i2;
        }
    }

    public void a(fe feVar) {
        if (feVar == null || this.q.contains(feVar)) {
            return;
        }
        this.q.add(feVar);
    }

    public void a(fh fhVar, fp fpVar) {
        Objects.requireNonNull(fhVar, "Packet listener is null.");
        this.f8574f.put(fhVar, new a(fhVar, fpVar));
    }

    public abstract void a(ft ftVar);

    public abstract void a(aj.b bVar);

    public synchronized void a(String str) {
        if (this.r == 0) {
            com.xiaomi.a.a.a.c.a("setChallenge hash = " + aq.a(str).substring(0, 8));
            this.f8577i = str;
            a(1, 0, null);
        } else {
            com.xiaomi.a.a.a.c.a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(eq[] eqVarArr);

    public synchronized boolean a(long j2) {
        return this.s >= j2;
    }

    public abstract void b(int i2, Exception exc);

    public abstract void b(eq eqVar);

    public void b(fe feVar) {
        this.q.remove(feVar);
    }

    public void b(fh fhVar, fp fpVar) {
        Objects.requireNonNull(fhVar, "Packet listener is null.");
        this.f8575g.put(fhVar, new a(fhVar, fpVar));
    }

    public abstract void b(boolean z);

    public boolean b() {
        return false;
    }

    public fc d() {
        return this.f8580l;
    }

    public String e() {
        return this.f8580l.e();
    }

    public String f() {
        return this.f8580l.b();
    }

    public long g() {
        return this.f8573e;
    }

    public Map<fh, a> h() {
        return this.f8574f;
    }

    public void i() {
        String str;
        if (this.f8580l.f() && this.f8576h == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (cls == null) {
                this.f8576h = new ez(this);
                return;
            }
            try {
                this.f8576h = (fo) cls.getConstructor(fb.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e3) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e3);
            }
        }
    }

    public boolean j() {
        return this.r == 0;
    }

    public boolean k() {
        return this.r == 1;
    }

    public int l() {
        return this.b;
    }

    public int m() {
        return this.r;
    }

    public synchronized void n() {
        this.s = SystemClock.elapsedRealtime();
    }

    public void o() {
        synchronized (this.p) {
            this.p.clear();
        }
    }
}
