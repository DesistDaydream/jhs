package com.tencent.android.tpush.c.a;

import android.content.Context;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class a extends com.tencent.android.tpush.c.c {
    private String a;

    private String f(Context context) {
        if (i.b(this.a)) {
            this.a = SharePrefsUtil.getString(context, "fcm_token", "");
        }
        return this.a;
    }

    @Override // com.tencent.android.tpush.c.c
    public String a() {
        return "fcm";
    }

    @Override // com.tencent.android.tpush.c.c
    public void a(Context context) {
        try {
            Class<?> cls = Class.forName("com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
            cls.getMethod("registerPush", Context.class).invoke(cls, context);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            TLogger.ee("OtherPushFcmImpl", "registerPush FCM Error for InvocationTargetException: " + cause.getMessage());
            cause.printStackTrace();
        } catch (Throwable th) {
            TLogger.ee("OtherPushFcmImpl", "registerPush FCM Error, are you import otherpush package? " + th);
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public void b(Context context) {
        try {
            Class<?> cls = Class.forName("com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
            cls.getMethod("unregisterPush", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            TLogger.ee("OtherPushFcmImpl", "unregisterPush FCM Error, are you import otherpush package? " + th);
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public String c(Context context) {
        Object invoke;
        String f2;
        String str = "";
        try {
            Class<?> cls = Class.forName("com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
            invoke = cls.getMethod("getToken", Context.class).invoke(cls, context);
            f2 = f(context);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            TLogger.ee("OtherPushFcmImpl", "getToken Error for InvocationTargetException: " + cause.getMessage());
        } catch (Throwable th) {
            TLogger.ee("OtherPushFcmImpl", "getToken Error", th);
        }
        if (invoke == null || i.b(invoke.toString())) {
            return f2;
        }
        str = invoke.toString();
        if (!invoke.toString().equals(f2)) {
            this.a = invoke.toString();
            SharePrefsUtil.setString(context, "fcm_token", invoke.toString());
        }
        com.tencent.android.tpush.c.d.a(context, "OtherPushFcmImpl", "errCode : 0 , errMsg : success");
        return str;
    }

    @Override // com.tencent.android.tpush.c.c
    public boolean d(Context context) {
        try {
            return com.tencent.android.tpush.c.a.a(context, "com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
        } catch (Throwable th) {
            TLogger.ee("OtherPushFcmImpl", "isConfig :" + th);
            return false;
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public int e(Context context) {
        return 4;
    }
}
