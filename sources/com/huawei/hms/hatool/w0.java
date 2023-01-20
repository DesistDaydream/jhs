package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import com.jihuanshe.mmkv.UserKV;

/* loaded from: classes2.dex */
public class w0 {

    /* renamed from: c  reason: collision with root package name */
    public static w0 f3611c = new w0();
    public boolean a = false;
    public Context b = b.i();

    public static w0 b() {
        return f3611c;
    }

    @TargetApi(24)
    public boolean a() {
        boolean z;
        if (!this.a) {
            Context context = this.b;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService(UserKV.f3914d);
                if (userManager != null) {
                    z = userManager.isUserUnlocked();
                } else {
                    this.a = false;
                }
            } else {
                z = true;
            }
            this.a = z;
        }
        return this.a;
    }
}
