package com.tencent.android.tpush.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.c.a.e;
import com.tencent.android.tpush.c.a.f;
import com.tencent.android.tpush.c.a.g;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.h;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;

/* loaded from: classes3.dex */
public class d {
    public static String a = "";
    public static String b = "";

    /* renamed from: c */
    public static String f6077c = "";

    /* renamed from: d */
    public static String f6078d = "";

    /* renamed from: e */
    public static String f6079e = "";

    /* renamed from: f */
    public static String f6080f = "";

    /* renamed from: g */
    public static Boolean f6081g = Boolean.FALSE;

    /* renamed from: h */
    public static String f6082h = "";

    /* renamed from: i */
    private static volatile d f6083i = null;

    /* renamed from: j */
    private static volatile c f6084j = null;

    /* renamed from: k */
    private static volatile c f6085k = null;

    /* renamed from: l */
    private static volatile c f6086l = null;

    /* renamed from: m */
    private Boolean f6087m;
    private Boolean n;
    private Boolean o;
    private Context p;
    private int q = -1;

    private d(Context context) {
        this.p = null;
        this.p = context;
        this.p = context;
        if (h.a(context).c() && XGPushConfig.isUsedFcmPush(context)) {
            f6086l = new com.tencent.android.tpush.c.a.a();
        }
        f6085k = b(this.p);
        if (l()) {
            f6084j = f6085k;
        } else if (m()) {
            f6084j = f6086l;
        } else {
            f6084j = f6085k;
        }
    }

    private c b(Context context) {
        c eVar;
        try {
            String h2 = h();
            if (com.tencent.android.tpush.e.a.b(this.p)) {
                TLogger.ii("OtherPushManager", "USE XgSys");
                eVar = new com.tencent.android.tpush.c.a.h(this.p);
            } else {
                if (!ChannelUtils.isBrandXiaoMi() && !ChannelUtils.isBrandBlackShark()) {
                    if (!ChannelUtils.isBrandHuaWei() && !ChannelUtils.isBrandHonor() && !ChannelUtils.isEmuiOrOhosVersion()) {
                        if (ChannelUtils.isBrandMeiZu()) {
                            TLogger.ii("OtherPushManager", "USE meizu");
                            eVar = new com.tencent.android.tpush.c.a.d();
                        } else {
                            if (!"oppo".equals(h2) && !"oneplus".equals(h2) && !"realme".equals(h2)) {
                                if ("vivo".equals(h2)) {
                                    TLogger.ii("OtherPushManager", "USE vivo");
                                    eVar = new g();
                                } else {
                                    TLogger.ii("OtherPushManager", "deviceType: " + h2);
                                    return null;
                                }
                            }
                            TLogger.ii("OtherPushManager", "USE oppo");
                            eVar = new f();
                        }
                    }
                    if (ChannelUtils.isBrandHonor() && ChannelUtils.isHonorVersionOver6() && com.tencent.android.tpush.c.a.b.b() > 0) {
                        TLogger.ii("OtherPushManager", "USE honor");
                        eVar = new com.tencent.android.tpush.c.a.b();
                    } else {
                        TLogger.ii("OtherPushManager", "USE huawei");
                        eVar = new com.tencent.android.tpush.c.a.c();
                    }
                }
                TLogger.ii("OtherPushManager", "USE xiaomi");
                eVar = new e();
            }
            return eVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String h() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) ? str.trim().toLowerCase() : str;
    }

    public boolean a() {
        if (f6084j == null || this.p == null) {
            return false;
        }
        return f6084j.d(this.p);
    }

    public void c() {
        if (f6084j == null || this.p == null || !f6084j.d(this.p)) {
            return;
        }
        f6084j.a(this.p);
    }

    public void d() {
        if (f6084j == null || this.p == null || !f6084j.d(this.p)) {
            return;
        }
        f6084j.b(this.p);
    }

    public String e() {
        if (f6084j == null || this.p == null || !f6084j.d(this.p)) {
            return null;
        }
        return f6084j.c(this.p);
    }

    public String f() {
        if (f6085k == null || this.p == null || !f6085k.d(this.p)) {
            return null;
        }
        return f6085k.c(this.p);
    }

    public String g() {
        if (f6086l == null || this.p == null || !f6086l.d(this.p)) {
            return null;
        }
        return f6086l.c(this.p);
    }

    public String i() {
        if (f6084j != null) {
            return f6084j.a();
        }
        return null;
    }

    public boolean j() {
        if (f6084j == null || this.p == null) {
            return false;
        }
        if (this.f6087m == null) {
            this.f6087m = Boolean.valueOf(f6084j.d(this.p));
        }
        return this.f6087m.booleanValue();
    }

    public boolean k() {
        return l() || m();
    }

    public boolean l() {
        try {
            if (f6085k == null || this.p == null) {
                return false;
            }
            if (this.o == null) {
                this.o = Boolean.valueOf(f6085k.d(this.p));
            }
            return this.o.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean m() {
        try {
            if (f6086l == null || this.p == null) {
                return false;
            }
            if (this.n == null) {
                this.n = Boolean.valueOf(f6086l.d(this.p));
            }
            return this.n.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void n() {
        this.o = null;
        this.n = null;
    }

    public void o() {
        try {
            String g2 = g();
            String f2 = f();
            boolean z = !i.b(g2);
            boolean z2 = !i.b(f2);
            if (z && z2) {
                if (XGPushConfig.isUseFcmFirst(this.p)) {
                    f6084j = f6086l;
                } else {
                    f6084j = f6085k;
                }
            } else if (z) {
                f6084j = f6086l;
            } else if (z2) {
                f6084j = f6085k;
            } else {
                TLogger.i("OtherPushManager", "don't have valid token");
            }
        } catch (Throwable unused) {
        }
    }

    public static d a(Context context) {
        if (f6083i == null) {
            synchronized (d.class) {
                if (f6083i == null) {
                    f6083i = new d(context);
                }
            }
        }
        return f6083i;
    }

    public static void c(Context context, String str) {
        f6077c = str;
    }

    public static void d(Context context, String str) {
        f6078d = str;
    }

    public static void e(Context context, String str) {
        f6079e = str;
    }

    public static void f(Context context, String str) {
        f6080f = str;
    }

    public static void a(Context context, String str, String str2) {
        try {
            if (str2.equals(SharePrefsUtil.getString(context, Constants.OTHER_PUSH_ERROR_CODE, ""))) {
                return;
            }
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, str2);
        }
    }

    public static void a(Context context, String str) {
        a = str;
    }

    public static void a(Context context, boolean z) {
        f6081g = Boolean.valueOf(z);
    }

    public boolean b() {
        if (f6084j != null && this.p != null) {
            r1 = f6084j.e(this.p) == 8;
            if (r1) {
                TLogger.ii("OtherPushManager", "UseXgSysDevice!");
            }
        }
        return r1;
    }

    public static void b(Context context, String str) {
        b = str;
    }
}
