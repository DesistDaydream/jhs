package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class y {

    /* renamed from: c  reason: collision with root package name */
    private static volatile y f7283c;
    private w a = new x();
    private String b;

    /* renamed from: d  reason: collision with root package name */
    private List<a> f7284d;

    /* renamed from: e  reason: collision with root package name */
    private String f7285e;

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, long j2, long j3, long j4);

        void a(String str, String str2, long j2, long j3, long j4);
    }

    private y() {
    }

    public static y a() {
        if (f7283c == null) {
            synchronized (y.class) {
                if (f7283c == null) {
                    f7283c = new y();
                }
            }
        }
        return f7283c;
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(u.f7269d, d(context));
            edit.commit();
        } catch (Exception unused) {
        }
        long h2 = h(context);
        long i2 = i(context);
        String str = this.b;
        long a2 = u.a(context);
        long j2 = a2 * 5000;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + a2);
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
            if (UMWorkDispatch.eventHasExist()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
                UMWorkDispatch.removeEvent();
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
            }
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        }
        a(i2, h2, j2, str, false);
        this.b = this.a.a(context);
        a(i2, h2, j2, str, true);
        this.a.a(context, this.b);
        return this.b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.b) && i.a(context).a(this.b) > 0;
    }

    private long h(Context context) {
        return a(context, u.f7271f);
    }

    private long i(Context context) {
        return a(context, u.a);
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j2 = sharedPreferences.getLong(u.f7270e, 0L);
            long j3 = sharedPreferences.getLong(u.f7271f, 0L);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E) && j2 > 0 && j3 == 0) {
                long a2 = u.a(appContext);
                if (a2 > 0) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j3 = j2 + (a2 * 5000);
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j3 - j2));
            return this.a.a(j2, j3);
        } catch (Exception unused) {
            return false;
        }
    }

    public long b() {
        return this.a.a();
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.b = f(appContext);
        } catch (Exception unused) {
        }
        return this.b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            try {
                this.b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = d(context);
        }
        return TextUtils.isEmpty(this.b) || j(context) || g(context);
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.b = d(appContext);
        if (e(appContext)) {
            try {
                this.b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.b;
    }

    public void a(long j2) {
        this.a.a(j2);
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (y.class) {
                str = PreferenceWrapper.getDefault(appContext).getString(u.f7269d, "");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.f7284d) == null || list.size() == 0) {
            return;
        }
        this.f7284d.remove(aVar);
    }

    public String a(Context context, long j2) {
        if (TextUtils.isEmpty(this.f7285e)) {
            String str = "SUB" + j2;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(String.format("%0" + (32 - str.length()) + e.j.a.b.c.f.f10128d, 0));
            this.f7285e = sb.toString();
        }
        return this.f7285e;
    }

    private long a(Context context, String str) {
        long j2;
        try {
            j2 = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j2 = 0;
        }
        return j2 <= 0 ? System.currentTimeMillis() : j2;
    }

    private void a(long j2, long j3, long j4, String str, boolean z) {
        List<a> list = this.f7284d;
        if (list != null) {
            for (a aVar : list) {
                if (z) {
                    try {
                        aVar.a(str, this.b, j2, j3, j4);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(this.b, j2, j3, j4);
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f7284d == null) {
            this.f7284d = new ArrayList();
        }
        if (this.f7284d.contains(aVar)) {
            return;
        }
        this.f7284d.add(aVar);
    }
}
