package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes3.dex */
public class aa {
    public static int a;

    public static v a(Context context) {
        if (jc.a()) {
            a = 1;
            return new z(context);
        } else if (t.a(context)) {
            a = 2;
            return new t(context);
        } else if (ad.a(context)) {
            a = 4;
            return new ad(context);
        } else if (ah.a(context)) {
            a = 5;
            return new ah(context);
        } else if (y.a(context)) {
            a = 3;
            return new w(context);
        } else {
            a = 0;
            return new ag();
        }
    }
}
