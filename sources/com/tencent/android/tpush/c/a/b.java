package com.tencent.android.tpush.c.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;

/* loaded from: classes3.dex */
public class b extends com.tencent.android.tpush.c.c {
    private String a;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f6061c;

    public static int b() {
        try {
            Class.forName("com.hihonor.push.sdk.HonorInstanceId");
            return 1;
        } catch (ClassNotFoundException unused) {
            return -1;
        }
    }

    private void c() {
        try {
            this.f6061c = Class.forName("com.hihonor.push.sdk.HonorInstanceId");
            this.b = 1;
        } catch (ClassNotFoundException unused) {
            this.b = -1;
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public String a() {
        return "honor";
    }

    @Override // com.tencent.android.tpush.c.c
    public void a(Context context) {
        if (this.b == 0) {
            c();
        }
        TLogger.i("OtherPushHonorImpl", "other push honor registerPush");
        if (this.b > 0) {
            try {
                Object invoke = this.f6061c.getDeclaredMethod("getPushToken", new Class[0]).invoke(this.f6061c.getDeclaredMethod("getInstance", Context.class).invoke(this.f6061c, context), new Object[0]);
                if (invoke != null && !TextUtils.isEmpty(invoke.toString())) {
                    TLogger.i("OtherPushHonorImpl", "Get Honor token: " + invoke.toString());
                    if (!invoke.toString().equals(c(context))) {
                        String obj = invoke.toString();
                        this.a = obj;
                        SharePrefsUtil.setString(context, "honor_token", obj);
                    }
                    com.tencent.android.tpush.c.d.a(context, "OtherPushHonorImpl", "errCode : 0 , errMsg : success");
                    return;
                }
                TLogger.ww("OtherPushHonorImpl", "Get Honor token null or empty");
                return;
            } catch (Throwable th) {
                TLogger.ww("OtherPushHonorImpl", "register honor push error: " + th.toString(), th);
                return;
            }
        }
        TLogger.ee("OtherPushHonorImpl", "Missing Honor Push SDK");
    }

    @Override // com.tencent.android.tpush.c.c
    public boolean d(Context context) {
        if (this.b == 0) {
            c();
        }
        if (this.b > 0) {
            try {
                Class<?> cls = Class.forName("com.hihonor.push.sdk.ipc.HonorApiAvailability");
                Object invoke = cls.getDeclaredMethod("isHonorMobileServicesAvailable", Context.class).invoke(cls, context);
                if (invoke != null) {
                    int intValue = ((Integer) invoke).intValue();
                    if (intValue == 0) {
                        return true;
                    }
                    TLogger.ee("OtherPushHonorImpl", "isConfig honor push isHonorMobileServicesAvailable = " + intValue + ", not support!");
                    return false;
                }
            } catch (Throwable th) {
                TLogger.ww("OtherPushHonorImpl", "isConfig honor push error: " + th.toString());
            }
        } else {
            TLogger.ee("OtherPushHonorImpl", "Missing Honor Push SDK");
        }
        return false;
    }

    @Override // com.tencent.android.tpush.c.c
    public int e(Context context) {
        return 9;
    }

    @Override // com.tencent.android.tpush.c.c
    public void b(Context context) {
        if (this.b == 0) {
            c();
        }
        TLogger.i("OtherPushHonorImpl", "other push honor unregisterPush");
        if (this.b > 0) {
            try {
                this.f6061c.getDeclaredMethod("deletePushToken", new Class[0]).invoke(this.f6061c.getDeclaredMethod("getInstance", Context.class).invoke(this.f6061c, context), new Object[0]);
                return;
            } catch (Throwable th) {
                TLogger.ww("OtherPushHonorImpl", "unregister honor push error: " + th.toString());
                return;
            }
        }
        TLogger.ee("OtherPushHonorImpl", "Missing Honor Push SDK");
    }

    @Override // com.tencent.android.tpush.c.c
    public String c(Context context) {
        if (i.b(this.a)) {
            this.a = SharePrefsUtil.getString(context, "honor_token", "");
        }
        return this.a;
    }
}
