package e.j.a.b.c.w;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.WakeLockEvent;
import e.j.a.b.c.x.d0;
import e.j.a.b.c.x.g0;
import java.util.Arrays;
import java.util.List;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class d {
    private static Boolean b;
    private static d a = new d();
    @d0

    /* renamed from: c  reason: collision with root package name */
    private static boolean f10458c = false;

    @e.j.a.b.c.m.a
    public static d a() {
        return a;
    }

    private static void g(Context context, WakeLockEvent wakeLockEvent) {
        try {
            context.startService(new Intent().setComponent(b.a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent));
        } catch (Exception e2) {
            Log.wtf("WakeLockTracker", e2);
        }
    }

    private static boolean h() {
        if (b == null) {
            b = Boolean.FALSE;
        }
        return b.booleanValue();
    }

    @e.j.a.b.c.m.a
    public void b(Context context, Intent intent, String str, String str2, String str3, int i2, String str4) {
        d(context, intent.getStringExtra(b.f10456i), 7, str, str2, str3, i2, Arrays.asList(str4));
    }

    @e.j.a.b.c.m.a
    public void c(Context context, String str, String str2, String str3, int i2, List<String> list, boolean z, long j2) {
        if (h()) {
            g(context, new WakeLockEvent(System.currentTimeMillis(), 16, str, i2, c.c(list), null, j2, g0.a(context), str2, c.d(context.getPackageName()), g0.b(context), 0L, str3, z));
        }
    }

    @e.j.a.b.c.m.a
    public void d(Context context, String str, int i2, String str2, String str3, String str4, int i3, List<String> list) {
        e(context, str, i2, str2, str3, str4, i3, list, 0L);
    }

    @e.j.a.b.c.m.a
    public void e(Context context, String str, int i2, String str2, String str3, String str4, int i3, List<String> list, long j2) {
        if (h()) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                Log.e("WakeLockTracker", valueOf.length() != 0 ? "missing wakeLock key. ".concat(valueOf) : new String("missing wakeLock key. "));
            } else if (7 == i2 || 8 == i2 || 10 == i2 || 11 == i2) {
                g(context, new WakeLockEvent(System.currentTimeMillis(), i2, str2, i3, c.c(list), str, SystemClock.elapsedRealtime(), g0.a(context), str3, c.d(context.getPackageName()), g0.b(context), j2, str4, false));
            }
        }
    }

    @e.j.a.b.c.m.a
    public void f(Context context, Intent intent) {
        d(context, intent.getStringExtra(b.f10456i), 8, null, null, null, 0, null);
    }
}
