package com.tencent.android.tpush.c.a;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes3.dex */
public class f extends com.tencent.android.tpush.c.c {
    public StringBuffer a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private Object f6066c = null;

    /* renamed from: d  reason: collision with root package name */
    private Object f6067d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6068e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f6069f = 0;

    /* renamed from: g  reason: collision with root package name */
    private Class<?> f6070g = null;

    /* renamed from: h  reason: collision with root package name */
    private Class<?> f6071h = null;

    /* loaded from: classes3.dex */
    public class a implements InvocationHandler {
        private Context b;

        public a(Context context) {
            this.b = context;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method == null) {
                return null;
            }
            if (method.getName().equals("onRegister")) {
                if (objArr != null && objArr.length >= 2) {
                    int intValue = ((Integer) objArr[0]).intValue();
                    String str = (String) objArr[1];
                    if (intValue == 0) {
                        TLogger.ii("OtherPushOppoImpl", "OppoPush Register success, registerId:" + str);
                        if (!i.b(str) && !str.equals(f.this.c(this.b))) {
                            f.this.b = str;
                            SharePrefsUtil.setString(this.b, "oppo_token", f.this.b);
                        }
                        com.tencent.android.tpush.c.d.a(this.b, "OtherPushOppoImpl", "errCode : " + intValue + " , errMsg : success");
                    } else {
                        TLogger.ww("OtherPushOppoImpl", "OppoPush Register failed, code=" + intValue + ", msg=" + str);
                        Context context = this.b;
                        StringBuffer stringBuffer = f.this.a;
                        stringBuffer.append("errCode : " + intValue + " , errMsg : unknown");
                        SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                    }
                    try {
                        Intent intent = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
                        intent.putExtra("TPUSH.ERRORCODE", intValue);
                        intent.putExtra("other_push_token", str);
                        intent.putExtra("TPUSH.FEEDBACK", 1);
                        intent.putExtra("PUSH.CHANNEL", 105);
                        intent.setPackage(this.b.getPackageName());
                        BroadcastAgent.sendBroadcast(this.b, intent);
                    } catch (Throwable th) {
                        TLogger.w("OtherPushOppoImpl", "OppoPush Register callback broadcast error: " + th.getMessage());
                    }
                }
            } else if (method.getName().equals("onUnRegister") && objArr != null && objArr.length >= 1) {
                int intValue2 = ((Integer) objArr[0]).intValue();
                if (intValue2 == 0) {
                    TLogger.ii("OtherPushOppoImpl", "OppoPush UnRegister success");
                } else {
                    TLogger.ww("OtherPushOppoImpl", "OppoPush UnRegister failed, code=" + intValue2);
                    Context context2 = this.b;
                    StringBuffer stringBuffer2 = f.this.a;
                    stringBuffer2.append("errCode : " + intValue2 + " , errMsg : unknown");
                    SharePrefsUtil.setString(context2, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
                }
            }
            return method;
        }
    }

    private int b() {
        try {
            return d();
        } catch (Throwable unused) {
            TLogger.ww("OtherPushOppoImpl", "unexpected for checkOppoSdkVersion_heytapOS202");
            try {
                return e();
            } catch (Throwable unused2) {
                TLogger.ww("OtherPushOppoImpl", "unexpected for checkOppoSdkVersion_heytapOS210");
                try {
                    return c();
                } catch (Throwable unused3) {
                    TLogger.ww("OtherPushOppoImpl", "unexpected for checkOppoSdkVersion_colorOS");
                    this.f6070g = null;
                    this.f6071h = null;
                    TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: -1");
                    return -1;
                }
            }
        }
    }

    private int c() {
        this.f6070g = Class.forName("com.coloros.mcssdk.PushManager");
        this.f6071h = Class.forName("com.coloros.mcssdk.callback.PushCallback");
        TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: 1");
        return 1;
    }

    private int d() {
        this.f6070g = Class.forName("com.heytap.mcssdk.PushManager");
        this.f6071h = Class.forName("com.heytap.mcssdk.callback.PushCallback");
        TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: 2");
        return 2;
    }

    private int e() {
        this.f6070g = Class.forName("com.heytap.msp.push.HeytapPushManager");
        this.f6071h = Class.forName("com.heytap.msp.push.callback.ICallBackResultService");
        try {
            String str = (String) this.f6070g.getDeclaredMethod("getSDKVersionName", new Class[0]).invoke(this.f6070g, new Object[0]);
            TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: " + str);
            if ("3.0.0".equals(str)) {
                return 300;
            }
            return AdEventType.VIDEO_READY;
        } catch (Throwable th) {
            TLogger.ww("OtherPushOppoImpl", "unexpected for checkOppoSdkVersion_heytapOS210:" + th.getMessage());
            return AdEventType.VIDEO_READY;
        }
    }

    private Object f(Context context) {
        if (this.f6069f == 0) {
            this.f6069f = b();
        }
        int i2 = this.f6069f;
        if (i2 == -1) {
            TLogger.ww("OtherPushOppoImpl", "Missing oppo push sdk");
            return null;
        }
        if (this.f6067d == null) {
            try {
                if (i2 != 210 && i2 != 300) {
                    this.f6067d = this.f6070g.getDeclaredMethod("getInstance", new Class[0]).invoke(this.f6070g, new Object[0]);
                } else {
                    this.f6067d = this.f6070g.getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.f6070g.getDeclaredMethod("init", Context.class, Boolean.TYPE).invoke(this.f6070g, context, Boolean.TRUE);
                }
                TLogger.i("OtherPushOppoImpl", "Get oppo pushManager instance:" + this.f6067d);
                return this.f6067d;
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                TLogger.ee("OtherPushOppoImpl", "getImplInstance Error for InvocationTargetException: " + cause.getMessage());
                StringBuffer stringBuffer = this.a;
                stringBuffer.append("errCode : -155 , errMsg : " + e2.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                this.f6067d = null;
                return this.f6067d;
            } catch (Throwable th) {
                TLogger.ee("OtherPushOppoImpl", "getImplInstance Error ", th);
                this.f6067d = null;
                return this.f6067d;
            }
        }
        return this.f6067d;
    }

    @Override // com.tencent.android.tpush.c.c
    public String a() {
        return "oppo";
    }

    @Override // com.tencent.android.tpush.c.c
    public int e(Context context) {
        return 6;
    }

    @Override // com.tencent.android.tpush.c.c
    public void a(Context context) {
        this.a = new StringBuffer();
        if (!this.f6068e && Build.VERSION.SDK_INT >= 26) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
                NotificationChannel notificationChannel = new NotificationChannel("default_message", "默认通知", 4);
                if (notificationManager != null) {
                    notificationManager.createNotificationChannel(notificationChannel);
                    this.f6068e = true;
                    TLogger.ii("OtherPushOppoImpl", "create oppo push channle success");
                }
            } catch (Throwable th) {
                TLogger.ee("OtherPushOppoImpl", "create oppo push channle error: ", th);
                StringBuffer stringBuffer = this.a;
                stringBuffer.append("errCode : -150 , errMsg : " + th.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            }
        }
        if (i.b(com.tencent.android.tpush.c.d.f6079e)) {
            TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null AppKey");
        } else if (i.b(com.tencent.android.tpush.c.d.f6080f)) {
            TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null AppSecret");
        } else {
            Object f2 = f(context);
            if (f2 != null) {
                try {
                    TLogger.ii("OtherPushOppoImpl", "begin oppo register!" + com.tencent.android.tpush.c.d.f6079e + ExpandableTextView.N + com.tencent.android.tpush.c.d.f6080f);
                    if (this.f6066c == null) {
                        this.f6066c = Proxy.newProxyInstance(this.f6071h.getClassLoader(), new Class[]{this.f6071h}, new a(context));
                    }
                    this.f6070g.getDeclaredMethod(MiPushClient.COMMAND_REGISTER, Context.class, String.class, String.class, this.f6071h).invoke(f2, context, com.tencent.android.tpush.c.d.f6079e, com.tencent.android.tpush.c.d.f6080f, this.f6066c);
                    TLogger.ii("OtherPushOppoImpl", "registerPush oppo push channel success");
                    if (this.f6069f < 2 || !com.tencent.android.tpush.c.d.f6081g.booleanValue()) {
                        return;
                    }
                    this.f6070g.getDeclaredMethod("requestNotificationPermission", new Class[0]).invoke(f2, new Object[0]);
                } catch (Throwable th2) {
                    TLogger.ee("OtherPushOppoImpl", "registerPush Throwable e: " + th2.getMessage());
                    StringBuffer stringBuffer2 = this.a;
                    stringBuffer2.append("errCode : -151 , errMsg : " + th2.getLocalizedMessage());
                    SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
                }
            }
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public String c(Context context) {
        if (i.b(this.b)) {
            this.b = SharePrefsUtil.getString(context, "oppo_token", "");
        }
        return this.b;
    }

    @Override // com.tencent.android.tpush.c.c
    public boolean d(Context context) {
        boolean booleanValue;
        if (i.b(com.tencent.android.tpush.c.d.f6079e) || i.b(com.tencent.android.tpush.c.d.f6080f)) {
            i.a(context, 6);
        }
        if (i.b(com.tencent.android.tpush.c.d.f6079e)) {
            TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null appid");
            return false;
        } else if (i.b(com.tencent.android.tpush.c.d.f6080f)) {
            TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null miAppkey");
            return false;
        } else {
            Object f2 = f(context);
            if (f2 != null) {
                try {
                    if (this.f6069f == 210) {
                        booleanValue = ((Boolean) this.f6070g.getDeclaredMethod("isSupportPush", new Class[0]).invoke(f2, new Object[0])).booleanValue();
                    } else {
                        booleanValue = ((Boolean) this.f6070g.getDeclaredMethod("isSupportPush", Context.class).invoke(f2, context)).booleanValue();
                    }
                    if (!booleanValue) {
                        TLogger.ee("OtherPushOppoImpl", "OPPO push api isSupportPush() returns false, the device not support for OPPO push!");
                    }
                    return booleanValue;
                } catch (InvocationTargetException e2) {
                    Throwable cause = e2.getCause();
                    TLogger.ee("OtherPushOppoImpl", "isConfig Error for InvocationTargetException: " + cause.getMessage());
                } catch (Throwable th) {
                    TLogger.ee("OtherPushOppoImpl", "isConfig Error ", th);
                }
            }
            return false;
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public void b(Context context) {
        if (this.a == null) {
            this.a = new StringBuffer();
        }
        Object f2 = f(context);
        if (f2 != null) {
            try {
                this.f6070g.getDeclaredMethod("unRegister", new Class[0]).invoke(f2, new Object[0]);
                TLogger.ii("OtherPushOppoImpl", "unregisterPush oppo push channel success");
            } catch (Throwable th) {
                TLogger.ee("OtherPushOppoImpl", "unregisterPush Throwable e: " + th.getMessage());
                StringBuffer stringBuffer = this.a;
                stringBuffer.append("errCode : -152 , errMsg : " + th.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            }
        }
    }
}
