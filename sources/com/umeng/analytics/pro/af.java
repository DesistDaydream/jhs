package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.meizu.flyme.openidsdk.OpenIdHelper;

/* loaded from: classes3.dex */
public class af implements z {
    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a = OpenIdHelper.a();
        al.a("getOAID", "isSupported", Boolean.valueOf(a));
        if (a) {
            return OpenIdHelper.b(context);
        }
        return null;
    }
}
