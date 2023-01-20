package e.l.m;

import com.jihuanshe.model.GlobalConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import e.l.r.o0;
import h.k2.v.f0;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class c extends a {
    @d

    /* renamed from: c  reason: collision with root package name */
    public static final c f14093c = new c();

    private c() {
    }

    @Override // e.l.m.a
    @d
    public String c() {
        return "common";
    }

    @Override // e.l.m.a
    public boolean j() {
        return true;
    }

    @Override // e.l.m.a
    public boolean p() {
        return false;
    }

    @d
    public final String q() {
        String i2 = i("bio", "");
        return i2 != null ? i2 : "";
    }

    public final long r() {
        return g("versionCode", 0L);
    }

    public final boolean s() {
        return e(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE, 0) == 1;
    }

    public final boolean t(long j2) {
        return e(f0.C("show_dialog_", Long.valueOf(j2)), 0) == 1;
    }

    public final boolean u() {
        Long splashAdShowInternal;
        long j2 = 0;
        long currentTimeMillis = System.currentTimeMillis() - g("splash_ad_show_time", 0L);
        GlobalConfig u = o0.f14291c.u();
        if (u != null && (splashAdShowInternal = u.getSplashAdShowInternal()) != null) {
            j2 = splashAdShowInternal.longValue();
        }
        return currentTimeMillis > (j2 * ((long) 60)) * ((long) 1000);
    }

    public final void v(@e String str) {
        if (str == null) {
            str = "";
        }
        o("bio", str);
    }

    public final void w(long j2) {
        m("versionCode", j2);
    }

    public final void x(int i2) {
        l(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE, i2);
    }

    public final void y(long j2) {
        m("splash_ad_show_time", j2);
    }

    public final void z(long j2) {
        l(f0.C("show_dialog_", Long.valueOf(j2)), 1);
    }
}
