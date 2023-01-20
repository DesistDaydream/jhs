package com.tencent.android.tpush.c.a;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes3.dex */
public class c extends com.tencent.android.tpush.c.c {
    public Context a;

    /* renamed from: c  reason: collision with root package name */
    public String f6062c;

    /* renamed from: d  reason: collision with root package name */
    public StringBuffer f6063d;
    public BroadcastReceiver b = null;

    /* renamed from: e  reason: collision with root package name */
    private int f6064e = 0;

    /* renamed from: f  reason: collision with root package name */
    private Class<?> f6065f = null;

    /* loaded from: classes3.dex */
    public class a implements InvocationHandler {
        public a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method == null) {
                return null;
            }
            TLogger.d("OtherPushHuaWeiImpl", "invoke, method:" + method);
            try {
                if (method.getName().equals("onConnect")) {
                    if (objArr != null && objArr.length > 0) {
                        Integer num = (Integer) objArr[0];
                        TLogger.i("OtherPushHuaWeiImpl", "other push huawei onConnect code:" + num);
                        if (num.intValue() == 0) {
                            c.this.b();
                        } else {
                            c cVar = c.this;
                            Context context = cVar.a;
                            StringBuffer stringBuffer = cVar.f6063d;
                            stringBuffer.append("errCode : " + num + " ,  errMsg : unkonwn");
                            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                        }
                    }
                } else if (method.getName().equals("onResult") && objArr != null && objArr.length > 0) {
                    Integer num2 = (Integer) objArr[0];
                    TLogger.i("OtherPushHuaWeiImpl", "other push huawei onResult code:" + num2);
                    num2.intValue();
                }
            } catch (Throwable th) {
                TLogger.e("OtherPushHuaWeiImpl", "onConnectionFailed", th);
                c cVar2 = c.this;
                Context context2 = cVar2.a;
                StringBuffer stringBuffer2 = cVar2.f6063d;
                stringBuffer2.append("errCode : -126 , errMsg :" + th.getLocalizedMessage());
                SharePrefsUtil.setString(context2, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
            }
            return null;
        }
    }

    private int c() {
        try {
            try {
                this.f6065f = Class.forName("com.huawei.hms.aaid.HmsInstanceId");
                return 3;
            } catch (Throwable unused) {
                this.f6065f = Class.forName("com.huawei.android.hms.agent.HMSAgent");
                return 2;
            }
        } catch (Throwable th) {
            this.f6065f = null;
            Context context = this.a;
            StringBuffer stringBuffer = this.f6063d;
            stringBuffer.append("errCode : -121 , errMsg : " + th.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            return -1;
        }
    }

    private void g(Context context) {
        if (this.b == null) {
            this.b = new BroadcastReceiver() { // from class: com.tencent.android.tpush.c.a.c.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    if (intent != null) {
                        try {
                            String action = intent.getAction();
                            if (i.b(action)) {
                                return;
                            }
                            TLogger.i("OtherPushHuaWeiImpl", "Receive broadcast action: " + action);
                            if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                                byte[] byteArrayExtra = intent.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN);
                                if (byteArrayExtra == null) {
                                    return;
                                }
                                String str = new String(byteArrayExtra, "UTF-8");
                                TLogger.i("OtherPushHuaWeiImpl", "Get token from broadcast: " + str);
                                if (i.b(str)) {
                                    return;
                                }
                                if (!str.equals(c.this.c(context2))) {
                                    c.this.f6062c = str;
                                    SharePrefsUtil.setString(context2, "huawei_token", str);
                                }
                                com.tencent.android.tpush.c.d.a(c.this.a, "OtherPushHuaWeiImpl", "errCode : 0 , errMsg : success");
                            } else if ("com.huawei.android.push.intent.RECEIVE".equals(action)) {
                                TLogger.d("OtherPushHuaWeiImpl", "reciver action com.huawei.android.push.intent.RECEIVE");
                            } else if ("com.huawei.intent.action.PUSH_STATE".equals(action)) {
                                TLogger.d("OtherPushHuaWeiImpl", "reciver action com.huawei.intent.action.PUSH_STATEE");
                            }
                        } catch (Throwable th) {
                            TLogger.e("OtherPushHuaWeiImpl", "registerHuaweiRecevier ", th);
                            StringBuffer stringBuffer = c.this.f6063d;
                            stringBuffer.append("errCode : -120 , errMsg : " + th.getLocalizedMessage());
                            SharePrefsUtil.setString(context2, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                        }
                    }
                }
            };
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.huawei.android.push.intent.REGISTRATION");
                intentFilter.addAction("com.huawei.android.push.intent.RECEIVE");
                intentFilter.addAction("com.huawei.intent.action.PUSH_STATE");
                context.registerReceiver(this.b, intentFilter);
            } catch (Throwable th) {
                TLogger.e("OtherPushHuaWeiImpl", "registerReceiver error", th);
                StringBuffer stringBuffer = this.f6063d;
                stringBuffer.append("errCode : -129 , errMsg : " + th.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            }
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public String a() {
        return "huawei";
    }

    @Override // com.tencent.android.tpush.c.c
    public void a(Context context) {
        this.a = context;
        this.f6063d = new StringBuffer();
        TLogger.i("OtherPushHuaWeiImpl", "other push huawei registerPush");
        g(context);
        if (this.f6064e == 0) {
            this.f6064e = c();
        }
        TLogger.ii("OtherPushHuaWeiImpl", "Get HW SDK version: " + this.f6064e);
        try {
            int i2 = this.f6064e;
            if (i2 != 3) {
                if (i2 == 2) {
                    this.f6065f.getDeclaredMethod("init", Application.class).invoke(this.f6065f, context.getApplicationContext());
                    Class<?> cls = Class.forName("com.huawei.android.hms.agent.common.handler.ConnectHandler");
                    this.f6065f.getDeclaredMethod("connect", Activity.class, cls).invoke(this.f6065f, null, Proxy.newProxyInstance(this.f6065f.getClassLoader(), new Class[]{cls}, new a()));
                    return;
                } else if (i2 != -1) {
                    return;
                } else {
                    StringBuffer stringBuffer = this.f6063d;
                    stringBuffer.append("errCode : -122 , errMsg : Missing HWPush Service SDK");
                    SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                    TLogger.ww("OtherPushHuaWeiImpl", "Missing HWPush Service SDK");
                    throw new Exception();
                }
            }
            Object invoke = this.f6065f.getDeclaredMethod("getInstance", Context.class).invoke(this.f6065f, context);
            Method declaredMethod = this.f6065f.getDeclaredMethod("getToken", String.class, String.class);
            String f2 = f(context);
            TLogger.i("OtherPushHuaWeiImpl", "Get HW appId from agcp: " + f2);
            Object invoke2 = declaredMethod.invoke(invoke, f2, HmsMessaging.DEFAULT_TOKEN_SCOPE);
            if (invoke2 != null && !TextUtils.isEmpty(invoke2.toString())) {
                TLogger.i("OtherPushHuaWeiImpl", "Get HW token: " + invoke2.toString());
                if (!invoke2.toString().equals(c(context))) {
                    String obj = invoke2.toString();
                    this.f6062c = obj;
                    SharePrefsUtil.setString(context, "huawei_token", obj);
                }
                com.tencent.android.tpush.c.d.a(context, "OtherPushHuaWeiImpl", "errCode : 0 , errMsg : success");
                return;
            }
            TLogger.i("OtherPushHuaWeiImpl", "Get HW token from HWS.getToken null or empty, get it from receiver");
        } catch (Throwable th) {
            TLogger.e("OtherPushHuaWeiImpl", "" + th.getCause(), th);
            StringBuffer stringBuffer2 = this.f6063d;
            stringBuffer2.append("errCode : -123 , errMsg :" + th.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
        }
    }

    public void b() {
        try {
            Class<?> cls = Class.forName("com.huawei.android.hms.agent.HMSAgent$Push");
            Class<?> cls2 = Class.forName("com.huawei.android.hms.agent.push.handler.GetTokenHandler");
            cls.getDeclaredMethod("getToken", cls2).invoke(cls, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls2}, new a()));
        } catch (Throwable th) {
            TLogger.e("OtherPushHuaWeiImpl", "getTokenAsyn error", th);
            Context context = this.a;
            StringBuffer stringBuffer = this.f6063d;
            stringBuffer.append("errCode : -127 , errMsg :" + th.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public boolean d(Context context) {
        return true;
    }

    @Override // com.tencent.android.tpush.c.c
    public int e(Context context) {
        return 5;
    }

    public String f(Context context) {
        Object invoke;
        if (this.f6064e == 0) {
            this.f6064e = c();
        }
        String str = "";
        if (this.f6064e != 3) {
            return "";
        }
        try {
            if (!TextUtils.isEmpty(com.tencent.android.tpush.c.d.f6082h)) {
                return com.tencent.android.tpush.c.d.f6082h;
            }
            Class<?> cls = Class.forName("com.huawei.agconnect.config.AGConnectServicesConfig");
            Object invoke2 = cls.getDeclaredMethod("fromContext", Context.class).invoke(cls, context);
            if (invoke2 == null || (invoke = cls.getDeclaredMethod("getString", String.class).invoke(invoke2, "client/app_id")) == null) {
                return "";
            }
            String obj = invoke.toString();
            try {
                com.tencent.android.tpush.c.d.f6082h = obj;
                return obj;
            } catch (Throwable unused) {
                str = obj;
                TLogger.ww("OtherPushHuaWeiImpl", "Not found AGConnectServicesConfig");
                return str;
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public String c(Context context) {
        if (i.b(this.f6062c)) {
            this.f6062c = SharePrefsUtil.getString(context, "huawei_token", "");
        }
        return this.f6062c;
    }

    @Override // com.tencent.android.tpush.c.c
    public void b(Context context) {
        if (i.b(this.f6062c)) {
            return;
        }
        if (this.f6063d == null) {
            this.f6063d = new StringBuffer();
        }
        TLogger.i("OtherPushHuaWeiImpl", "other push huawei unregisterPush");
        if (this.f6064e == 0) {
            this.f6064e = c();
        }
        try {
            int i2 = this.f6064e;
            if (i2 == 3) {
                this.f6065f.getDeclaredMethod("deleteToken", String.class, String.class).invoke(this.f6065f.getDeclaredMethod("getInstance", Context.class).invoke(this.f6065f, this.a), "100167977", HmsMessaging.DEFAULT_TOKEN_SCOPE);
            } else if (i2 == 2) {
                Class<?> cls = Class.forName("com.huawei.android.hms.agent.HMSAgent$Push");
                Class<?> cls2 = Class.forName("com.huawei.android.hms.agent.push.handler.DeleteTokenHandler");
                cls.getDeclaredMethod("deleteToken", String.class, cls2).invoke(cls, this.f6062c, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls2}, new a()));
            } else if (i2 != -1) {
            } else {
                TLogger.w("OtherPushHuaWeiImpl", "Missing HWPush Service SDK");
                Context context2 = this.a;
                StringBuffer stringBuffer = this.f6063d;
                stringBuffer.append("errCode : -122 , errMsg : Missing HWPush Service SDK");
                SharePrefsUtil.setString(context2, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                throw new Exception();
            }
        } catch (Throwable th) {
            TLogger.e("OtherPushHuaWeiImpl", "unregisterPush error", th);
            Context context3 = this.a;
            StringBuffer stringBuffer2 = this.f6063d;
            stringBuffer2.append("errCode : -128 , errMsg :" + th.getLocalizedMessage());
            SharePrefsUtil.setString(context3, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
        }
    }
}
