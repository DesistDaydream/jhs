package com.tencent.android.tpush.c.a;

import android.content.Context;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.Util;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class d extends com.tencent.android.tpush.c.c {
    public String a;
    public StringBuffer b;

    private String f(Context context) {
        if (i.b(this.a)) {
            this.a = SharePrefsUtil.getString(context, "meizu_token", "");
        }
        return this.a;
    }

    @Override // com.tencent.android.tpush.c.c
    public String a() {
        return "meizu";
    }

    @Override // com.tencent.android.tpush.c.c
    public void a(Context context) {
        if (i.b(com.tencent.android.tpush.c.d.f6077c)) {
            TLogger.ee("OtherPushMZImpl", "registerPush Error for mz null appid");
        } else if (i.b(com.tencent.android.tpush.c.d.f6078d)) {
            TLogger.ee("OtherPushMZImpl", "registerPush Error for mz null mzAppkey");
        } else {
            this.b = new StringBuffer();
            if (Util.isMainProcess(context)) {
                TLogger.ii("OtherPushMZImpl", "begin Mzpush register!" + com.tencent.android.tpush.c.d.f6077c + ExpandableTextView.N + com.tencent.android.tpush.c.d.f6078d);
                try {
                    Class<?> cls = Class.forName("com.meizu.cloud.pushsdk.PushManager");
                    cls.getMethod(MiPushClient.COMMAND_REGISTER, Context.class, String.class, String.class).invoke(cls, context, com.tencent.android.tpush.c.d.f6077c, com.tencent.android.tpush.c.d.f6078d);
                    TLogger.ii("OtherPushMZImpl", "creat meizu push channle success");
                } catch (InvocationTargetException e2) {
                    Throwable cause = e2.getCause();
                    TLogger.ee("OtherPushMZImpl", "meizu registerPush Error for InvocationTargetException: " + cause.getMessage());
                    StringBuffer stringBuffer = this.b;
                    stringBuffer.append("errCode : -160 , errMsg : " + e2.getLocalizedMessage());
                    SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                } catch (Throwable th) {
                    TLogger.ee("OtherPushMZImpl", "meizu registerPush Error ", th);
                    StringBuffer stringBuffer2 = this.b;
                    stringBuffer2.append("errCode : -161 , errMsg : " + th.getLocalizedMessage());
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
            Class<?> cls = Class.forName("com.meizu.cloud.pushsdk.PushManager");
            Method method = cls.getMethod("unRegister", Context.class, String.class, String.class);
            TLogger.i("OtherPushMZImpl", "begin Mzpush unregister!" + com.tencent.android.tpush.c.d.f6077c + ExpandableTextView.N + com.tencent.android.tpush.c.d.f6078d);
            method.invoke(cls, context, com.tencent.android.tpush.c.d.f6077c, com.tencent.android.tpush.c.d.f6078d);
            TLogger.ii("OtherPushMZImpl", "unregisterPush meizu push channle success");
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            TLogger.ee("OtherPushMZImpl", "meizu unregisterPush Error for InvocationTargetException: " + cause.getMessage());
            StringBuffer stringBuffer = this.b;
            stringBuffer.append("errCode : -162 , errMsg : " + e2.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
        } catch (Throwable th) {
            TLogger.ee("OtherPushMZImpl", "meizu unregisterPush Error, are you import otherpush package? " + th);
            StringBuffer stringBuffer2 = this.b;
            stringBuffer2.append("errCode : -163 , errMsg : " + th.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public String c(Context context) {
        if (this.b == null) {
            this.b = new StringBuffer();
        }
        try {
            Class<?> cls = Class.forName("com.meizu.cloud.pushsdk.PushManager");
            Object invoke = cls.getMethod("getPushId", Context.class).invoke(cls, context);
            String f2 = f(context);
            if (invoke == null || i.b(invoke.toString()) || invoke.toString().equals(f2)) {
                return f2;
            }
            this.a = invoke.toString();
            SharePrefsUtil.setString(context, "meizu_token", invoke.toString());
            return this.a;
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            TLogger.ee("OtherPushMZImpl", "meizu getToken Error for InvocationTargetException: " + cause.getMessage());
            StringBuffer stringBuffer = this.b;
            stringBuffer.append("errCode : -164 , errMsg : " + e2.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            return "";
        } catch (Throwable th) {
            TLogger.ee("OtherPushMZImpl", "meizu getToken Error", th);
            StringBuffer stringBuffer2 = this.b;
            stringBuffer2.append("errCode : -165 , errMsg : " + th.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
            return "";
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public boolean d(Context context) {
        if (i.b(com.tencent.android.tpush.c.d.f6077c) || i.b(com.tencent.android.tpush.c.d.f6078d)) {
            i.a(context, 2);
        }
        if (i.b(com.tencent.android.tpush.c.d.f6077c) || i.b(com.tencent.android.tpush.c.d.f6078d)) {
            i.k(context);
        }
        return (i.b(com.tencent.android.tpush.c.d.f6077c) || i.b(com.tencent.android.tpush.c.d.f6078d)) ? false : true;
    }

    @Override // com.tencent.android.tpush.c.c
    public int e(Context context) {
        return 2;
    }
}
