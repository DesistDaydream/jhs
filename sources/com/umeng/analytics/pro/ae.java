package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId;

/* loaded from: classes3.dex */
public class ae implements z {
    private static final int a = 1;
    private OpenDeviceId b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6996c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6997d = false;

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f6996c) {
            OpenDeviceId openDeviceId = new OpenDeviceId();
            this.b = openDeviceId;
            this.f6997d = openDeviceId.a(context, (OpenDeviceId.CallBack<String>) null) == 1;
            this.f6996c = true;
        }
        al.a("getOAID", "isSupported", Boolean.valueOf(this.f6997d));
        if (this.f6997d && this.b.c()) {
            return this.b.a();
        }
        return null;
    }
}
