package com.tencent.android.tpush.c.a;

import android.content.Context;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.Util;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class e extends com.tencent.android.tpush.c.c {
    public String a;
    public StringBuffer b;

    private String f(Context context) {
        if (i.b(this.a)) {
            this.a = SharePrefsUtil.getString(context, "xiaomi_token", "");
        }
        return this.a;
    }

    @Override // com.tencent.android.tpush.c.c
    public String a() {
        return "xiaomi";
    }

    @Override // com.tencent.android.tpush.c.c
    public void a(Context context) {
        if (i.b(com.tencent.android.tpush.c.d.a)) {
            TLogger.ee("OtherPushMiImpl", "registerPush Error for xiaomi null appid");
        } else if (i.b(com.tencent.android.tpush.c.d.b)) {
            TLogger.ee("OtherPushMiImpl", "registerPush Error for xiaomi null miAppkey");
        } else {
            this.b = new StringBuffer();
            if (Util.isMainProcess(context)) {
                try {
                    Class<?> cls = Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
                    Method method = cls.getMethod("registerPush", Context.class, String.class, String.class);
                    TLogger.i("OtherPushMiImpl", "begin Mipush register!" + com.tencent.android.tpush.c.d.a + ExpandableTextView.N + com.tencent.android.tpush.c.d.b);
                    method.invoke(cls, context, com.tencent.android.tpush.c.d.a, com.tencent.android.tpush.c.d.b);
                    TLogger.ii("OtherPushMiImpl", "registerPush xm push channle success");
                } catch (InvocationTargetException e2) {
                    Throwable cause = e2.getCause();
                    TLogger.ee("OtherPushMiImpl", "xm registerPush Error for InvocationTargetException: " + cause.getMessage());
                    StringBuffer stringBuffer = this.b;
                    stringBuffer.append("errCode : -130 , errMsg : " + e2.getLocalizedMessage());
                    SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                } catch (Throwable th) {
                    TLogger.ee("OtherPushMiImpl", "xm registerPush Error ", th);
                    StringBuffer stringBuffer2 = this.b;
                    stringBuffer2.append("errCode : -131 , errMsg : " + th.getLocalizedMessage());
                    SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
                }
            }
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public void b(Context context) {
        if (this.b == null) {
            this.b = new StringBuffer();
        }
        try {
            Class<?> cls = Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
            cls.getMethod("unregisterPush", Context.class).invoke(cls, context);
            TLogger.ii("OtherPushMiImpl", "unregisterPush xm push channle success");
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            TLogger.ee("OtherPushMiImpl", "unregisterPush Error for InvocationTargetException: " + cause.getMessage());
            StringBuffer stringBuffer = this.b;
            stringBuffer.append("errCode : -132 , errMsg : " + e2.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
        } catch (Throwable th) {
            TLogger.ee("OtherPushMiImpl", "unregisterPush Error, are you import otherpush package? " + th);
            StringBuffer stringBuffer2 = this.b;
            stringBuffer2.append("errCode : -133 , errMsg : " + th.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public String c(Context context) {
        if (this.b == null) {
            this.b = new StringBuffer();
        }
        try {
            Class<?> cls = Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
            Object invoke = cls.getMethod("getRegId", Context.class).invoke(cls, context);
            String f2 = f(context);
            if (invoke == null || i.b(invoke.toString()) || invoke.toString().equals(f2)) {
                return f2;
            }
            this.a = invoke.toString();
            SharePrefsUtil.setString(context, "xiaomi_token", invoke.toString());
            return this.a;
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            TLogger.ee("OtherPushMiImpl", "xm getToken Error for InvocationTargetException: " + cause.getMessage());
            StringBuffer stringBuffer = this.b;
            stringBuffer.append("errCode : -134 , errMsg : " + e2.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            return "";
        } catch (Throwable th) {
            TLogger.ee("OtherPushMiImpl", "xm getToken Error", th);
            StringBuffer stringBuffer2 = this.b;
            stringBuffer2.append("errCode : -135 , errMsg : " + th.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
            return "";
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public boolean d(Context context) {
        if (i.b(com.tencent.android.tpush.c.d.a) || i.b(com.tencent.android.tpush.c.d.b)) {
            i.a(context, 1);
        }
        if (i.b(com.tencent.android.tpush.c.d.a) || i.b(com.tencent.android.tpush.c.d.b)) {
            i.k(context);
        }
        return (i.b(com.tencent.android.tpush.c.d.a) || i.b(com.tencent.android.tpush.c.d.b)) ? false : true;
    }

    @Override // com.tencent.android.tpush.c.c
    public int e(Context context) {
        return 1;
    }
}
