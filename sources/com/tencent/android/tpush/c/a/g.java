package com.tencent.android.tpush.c.a;

import android.content.Context;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes3.dex */
public class g extends com.tencent.android.tpush.c.c {
    public StringBuffer a;
    private Object b = null;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f6072c = null;

    /* renamed from: d  reason: collision with root package name */
    private Class<?> f6073d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f6074e;

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
            if (method.getName().equals("onStateChanged") && objArr != null && objArr.length > 0) {
                int intValue = ((Integer) objArr[0]).intValue();
                if (intValue == 0) {
                    TLogger.ii("OtherPushVivoImpl", "vivoPush Register or UnRegister success, code = " + intValue);
                    com.tencent.android.tpush.c.d.a(this.b, "OtherPushVivoImpl", "errCode : " + intValue + " , errMsg : success");
                } else {
                    TLogger.ww("OtherPushVivoImpl", "vivoPush Register or UnRegister fail, code = " + intValue);
                    Context context = this.b;
                    StringBuffer stringBuffer = g.this.a;
                    stringBuffer.append("errCode : " + intValue + " , errMsg : unknown");
                    SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                }
            }
            return method;
        }
    }

    private Object f(Context context) {
        try {
            Class<?> cls = Class.forName("com.vivo.push.PushClient");
            this.f6072c = cls;
            return cls.getDeclaredMethod("getInstance", Context.class).invoke(this.f6072c, context.getApplicationContext());
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            TLogger.e("OtherPushVivoImpl", "getImplInstance Error for InvocationTargetException: " + cause.getMessage());
            cause.printStackTrace();
            return null;
        } catch (Throwable th) {
            TLogger.e("OtherPushVivoImpl", "getImplInstance Error ", th);
            return null;
        }
    }

    private String g(Context context) {
        if (i.b(this.f6074e)) {
            this.f6074e = SharePrefsUtil.getString(context, "vivo_token", "");
        }
        return this.f6074e;
    }

    @Override // com.tencent.android.tpush.c.c
    public String a() {
        return "vivo";
    }

    @Override // com.tencent.android.tpush.c.c
    public void a(Context context) {
        this.a = new StringBuffer();
        Object f2 = f(context);
        if (f2 != null) {
            try {
                if (this.f6072c == null) {
                    this.f6072c = Class.forName("com.vivo.push.PushClient");
                }
                this.f6072c.getDeclaredMethod("initialize", new Class[0]).invoke(f2, new Object[0]);
                if (this.b == null) {
                    this.f6073d = Class.forName("com.vivo.push.IPushActionListener");
                    this.b = Proxy.newProxyInstance(this.f6073d.getClassLoader(), new Class[]{this.f6073d}, new a(context));
                }
                if (this.f6073d == null) {
                    this.f6073d = Class.forName("com.vivo.push.IPushActionListener");
                }
                this.f6072c.getDeclaredMethod("turnOnPush", this.f6073d).invoke(f2, this.b);
                TLogger.ii("OtherPushVivoImpl", "registerPush vivo push channel success");
            } catch (Throwable th) {
                TLogger.e("OtherPushVivoImpl", "registerPush Throwable e: " + th.getMessage(), th);
                StringBuffer stringBuffer = this.a;
                stringBuffer.append("errCode : -140 , errMsg : " + th.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            }
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
                if (this.b == null) {
                    this.f6073d = Class.forName("com.vivo.push.IPushActionListener");
                    this.b = Proxy.newProxyInstance(this.f6073d.getClassLoader(), new Class[]{this.f6073d}, new a(context));
                }
                if (this.f6073d == null) {
                    this.f6073d = Class.forName("com.vivo.push.IPushActionListener");
                }
                if (this.f6072c == null) {
                    this.f6072c = Class.forName("com.vivo.push.PushClient");
                }
                this.f6072c.getDeclaredMethod("turnOffPush", this.f6073d).invoke(f2, this.b);
                TLogger.ii("OtherPushVivoImpl", "unregisterPush vivo push channel success");
            } catch (Throwable th) {
                TLogger.e("OtherPushVivoImpl", "unregisterPush Throwable e: " + th.getMessage(), th);
                StringBuffer stringBuffer = this.a;
                stringBuffer.append("errCode : -143 , errMsg : " + th.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            }
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public String c(Context context) {
        if (this.a == null) {
            this.a = new StringBuffer();
        }
        Object f2 = f(context);
        if (f2 != null) {
            try {
                Object invoke = Class.forName("com.vivo.push.PushClient").getDeclaredMethod("getRegId", new Class[0]).invoke(f2, new Object[0]);
                String g2 = g(context);
                if (invoke == null || i.b(invoke.toString()) || invoke.toString().equals(g2)) {
                    return g2;
                }
                String obj = invoke.toString();
                this.f6074e = obj;
                SharePrefsUtil.setString(context, "vivo_token", obj);
                return this.f6074e;
            } catch (InvocationTargetException e2) {
                TLogger.e("OtherPushVivoImpl", "getRegId Error for InvocationTargetException: ", e2.getCause());
                StringBuffer stringBuffer = this.a;
                stringBuffer.append("errCode : -141 , errMsg : " + e2.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            } catch (Throwable th) {
                TLogger.e("OtherPushVivoImpl", "getRegId Error ", th);
                StringBuffer stringBuffer2 = this.a;
                stringBuffer2.append("errCode : -142 , errMsg : " + th.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
            }
        }
        return "";
    }

    @Override // com.tencent.android.tpush.c.c
    public boolean d(Context context) {
        Object f2 = f(context);
        if (f2 != null) {
            try {
                boolean booleanValue = ((Boolean) Class.forName("com.vivo.push.PushClient").getDeclaredMethod("isSupport", new Class[0]).invoke(f2, new Object[0])).booleanValue();
                if (!booleanValue) {
                    TLogger.e("OtherPushVivoImpl", "vivo push api isSupport() returns false, the device not support for vivo push!");
                }
                return booleanValue;
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                TLogger.e("OtherPushVivoImpl", "isConfig Error for InvocationTargetException: " + cause.getMessage());
                cause.printStackTrace();
            } catch (Throwable th) {
                TLogger.e("OtherPushVivoImpl", "isConfig Error ", th);
            }
        }
        return false;
    }

    @Override // com.tencent.android.tpush.c.c
    public int e(Context context) {
        return 7;
    }
}
