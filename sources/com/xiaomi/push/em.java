package com.xiaomi.push;

import com.ss.android.download.api.constant.BaseConstants;
import com.xiaomi.push.an;
import com.xiaomi.push.iu;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public class em {
    private String a;

    /* renamed from: c */
    private int f8531c;

    /* renamed from: d */
    private long f8532d;

    /* renamed from: e */
    private el f8533e;
    private boolean b = false;

    /* renamed from: f */
    private an f8534f = an.a();

    /* loaded from: classes3.dex */
    public static class a {
        public static final em a = new em();
    }

    private ef a(an.a aVar) {
        if (aVar.a == 0) {
            Object obj = aVar.f8262c;
            if (obj instanceof ef) {
                return (ef) obj;
            }
            return null;
        }
        ef f2 = f();
        f2.a(ed.CHANNEL_STATS_COUNTER.a());
        f2.c(aVar.a);
        f2.c(aVar.b);
        return f2;
    }

    public static em a() {
        return a.a;
    }

    private eg b(int i2) {
        ArrayList arrayList = new ArrayList();
        eg egVar = new eg(this.a, arrayList);
        if (!al.f(this.f8533e.a)) {
            egVar.a(ii.k(this.f8533e.a));
        }
        iw iwVar = new iw(i2);
        io a2 = new iu.a().a(iwVar);
        try {
            egVar.b(a2);
        } catch (ih unused) {
        }
        LinkedList<an.a> c2 = this.f8534f.c();
        while (c2.size() > 0) {
            try {
                ef a3 = a(c2.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (iwVar.a_() > i2) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                c2.removeLast();
            } catch (ih | NoSuchElementException unused2) {
            }
        }
        return egVar;
    }

    public static el b() {
        el elVar;
        em emVar = a.a;
        synchronized (emVar) {
            elVar = emVar.f8533e;
        }
        return elVar;
    }

    private void g() {
        if (!this.b || System.currentTimeMillis() - this.f8532d <= this.f8531c) {
            return;
        }
        this.b = false;
        this.f8532d = 0L;
    }

    public void a(int i2) {
        if (i2 > 0) {
            int i3 = i2 * 1000;
            if (i3 > 604800000) {
                i3 = BaseConstants.Time.WEEK;
            }
            if (this.f8531c == i3 && this.b) {
                return;
            }
            this.b = true;
            this.f8532d = System.currentTimeMillis();
            this.f8531c = i3;
            com.xiaomi.a.a.a.c.c("enable dot duration = " + i3 + " start = " + this.f8532d);
        }
    }

    public synchronized void a(ef efVar) {
        this.f8534f.a(efVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f8533e = new el(xMPushService);
        this.a = "";
        com.xiaomi.push.service.ay.a().a(new en(this));
    }

    public boolean c() {
        return this.b;
    }

    public boolean d() {
        g();
        return this.b && this.f8534f.b() > 0;
    }

    public synchronized eg e() {
        eg egVar;
        egVar = null;
        if (d()) {
            egVar = b(al.f(this.f8533e.a) ? 750 : 375);
        }
        return egVar;
    }

    public synchronized ef f() {
        ef efVar;
        efVar = new ef();
        efVar.a(al.l(this.f8533e.a));
        efVar.a = (byte) 0;
        efVar.f8505c = 1;
        efVar.d((int) (System.currentTimeMillis() / 1000));
        return efVar;
    }
}
