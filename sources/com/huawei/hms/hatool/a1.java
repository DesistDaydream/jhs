package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public abstract class a1 {
    public final x0 a(int i2) {
        String str;
        if (i2 != 0) {
            str = f();
            if (!TextUtils.isEmpty(str)) {
                return new x0(y0.UDID, str);
            }
        } else {
            str = "";
        }
        return new x0(y0.EMPTY, str);
    }

    public x0 a(Context context) {
        String c2 = c();
        if (TextUtils.isEmpty(c2)) {
            String a = a();
            if (TextUtils.isEmpty(a)) {
                boolean e2 = e();
                String b = b();
                return !TextUtils.isEmpty(b) ? e2 ? new x0(y0.SN, b) : new x0(y0.UDID, a(b)) : e2 ? a(d()) : b(d());
            }
            return new x0(y0.IMEI, a);
        }
        return new x0(y0.UDID, c2);
    }

    public abstract String a();

    public abstract String a(String str);

    public final x0 b(int i2) {
        String str;
        if ((i2 & 4) != 0) {
            str = f();
            if (!TextUtils.isEmpty(str)) {
                return new x0(y0.UDID, str);
            }
        } else {
            str = "";
        }
        return new x0(y0.EMPTY, str);
    }

    public abstract String b();

    public abstract String c();

    public abstract int d();

    public final boolean e() {
        l b = i.c().b();
        if (TextUtils.isEmpty(b.l())) {
            b.h(f.a());
        }
        return !TextUtils.isEmpty(b.l());
    }

    public final String f() {
        l b = i.c().b();
        if (TextUtils.isEmpty(b.i())) {
            b.e(b1.c());
        }
        return b.i();
    }
}
