package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.ek;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aj;
import java.util.Hashtable;

/* loaded from: classes3.dex */
public class eo {
    private static final int a = ed.PING_RTT.a();
    private static long b = 0;

    /* loaded from: classes3.dex */
    public static class a {
        public static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a() {
        if (b == 0 || SystemClock.elapsedRealtime() - b > com.heytap.mcssdk.constant.a.n) {
            b = SystemClock.elapsedRealtime();
            a(0, a);
        }
    }

    public static void a(int i2) {
        ef f2 = em.a().f();
        f2.a(ed.CHANNEL_STATS_COUNTER.a());
        f2.c(i2);
        em.a().a(f2);
    }

    public static synchronized void a(int i2, int i3) {
        synchronized (eo.class) {
            if (i3 < 16777215) {
                a.a.put(Integer.valueOf((i2 << 24) | i3), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.a.a.a.c.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i2, int i3, int i4, String str, int i5) {
        ef f2 = em.a().f();
        f2.a((byte) i2);
        f2.a(i3);
        f2.b(i4);
        f2.b(str);
        f2.c(i5);
        em.a().a(f2);
    }

    public static synchronized void a(int i2, int i3, String str, int i4) {
        synchronized (eo.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i5 = (i2 << 24) | i3;
            if (a.a.containsKey(Integer.valueOf(i5))) {
                ef f2 = em.a().f();
                f2.a(i3);
                f2.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i5)).longValue()));
                f2.b(str);
                if (i4 > -1) {
                    f2.c(i4);
                }
                em.a().a(f2);
                a.a.remove(Integer.valueOf(i3));
            } else {
                com.xiaomi.a.a.a.c.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, aj.b bVar) {
        new eh(xMPushService, bVar).a();
    }

    public static void a(String str, int i2, Exception exc) {
        ef f2 = em.a().f();
        if (em.b() != null && em.b().a != null) {
            f2.c(al.d(em.b().a) ? 1 : 0);
        }
        if (i2 > 0) {
            f2.a(ed.GSLB_REQUEST_SUCCESS.a());
            f2.b(str);
            f2.b(i2);
            em.a().a(f2);
            return;
        }
        try {
            ek.a a2 = ek.a(exc);
            f2.a(a2.a.a());
            f2.c(a2.b);
            f2.b(str);
            em.a().a(f2);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            ek.a b2 = ek.b(exc);
            ef f2 = em.a().f();
            f2.a(b2.a.a());
            f2.c(b2.b);
            f2.b(str);
            if (em.b() != null && em.b().a != null) {
                f2.c(al.d(em.b().a) ? 1 : 0);
            }
            em.a().a(f2);
        } catch (NullPointerException unused) {
        }
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            ek.a d2 = ek.d(exc);
            ef f2 = em.a().f();
            f2.a(d2.a.a());
            f2.c(d2.b);
            f2.b(str);
            if (em.b() != null && em.b().a != null) {
                f2.c(al.d(em.b().a) ? 1 : 0);
            }
            em.a().a(f2);
        } catch (NullPointerException unused) {
        }
    }

    public static byte[] c() {
        eg e2 = em.a().e();
        if (e2 != null) {
            return ib.a(e2);
        }
        return null;
    }
}
