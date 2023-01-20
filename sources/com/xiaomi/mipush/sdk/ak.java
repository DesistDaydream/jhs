package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.l;

/* loaded from: classes3.dex */
public class ak {
    public static AbstractPushManager a(Context context, e eVar) {
        return b(context, eVar);
    }

    private static AbstractPushManager b(Context context, e eVar) {
        l.a m100a = l.m100a(eVar);
        if (m100a == null || TextUtils.isEmpty(m100a.a) || TextUtils.isEmpty(m100a.b)) {
            return null;
        }
        return (AbstractPushManager) com.xiaomi.push.am.a(m100a.a, m100a.b, context);
    }
}
