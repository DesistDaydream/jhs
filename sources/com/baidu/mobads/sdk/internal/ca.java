package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.bytedance.msdk.api.reward.RewardItem;
import com.effective.android.panel.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class ca {
    public static final String b = "404";

    /* renamed from: c  reason: collision with root package name */
    public final bj f1554c = bj.a();

    /* renamed from: g  reason: collision with root package name */
    private Context f1555g;
    public static final String a = v.b;

    /* renamed from: f  reason: collision with root package name */
    private static ca f1549f = new ca();

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f1547d = "";

    /* renamed from: e  reason: collision with root package name */
    public static volatile String f1548e = "";

    /* renamed from: h  reason: collision with root package name */
    private static AtomicBoolean f1550h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    private static String f1551i = "";

    /* renamed from: j  reason: collision with root package name */
    private static AtomicBoolean f1552j = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    private static String f1553k = "";

    private ca() {
    }

    public static ca a() {
        return f1549f;
    }

    private String d() {
        String str = cb.f1558e;
        if ("0.0".equals(str)) {
            try {
                double b2 = bp.b(bp.a(this.f1555g));
                return b2 > 0.0d ? String.valueOf(b2) : str;
            } catch (Throwable th) {
                this.f1554c.a(th);
                return str;
            }
        }
        return str;
    }

    public String b() {
        try {
            if (f1550h.compareAndSet(false, true)) {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                String str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
                if (!TextUtils.isEmpty(str)) {
                    f1551i = str;
                }
            }
            return f1551i;
        } catch (Throwable th) {
            this.f1554c.a(th);
            return f1551i;
        }
    }

    public String c() {
        try {
            if (f1552j.get()) {
                return f1553k;
            }
            if (!f1550h.get()) {
                b();
            }
            if (f1551i.equalsIgnoreCase("")) {
                f1552j.set(true);
                return "";
            }
            if (f1552j.compareAndSet(false, true)) {
                String a2 = a("hw_sc.build.platform.version", "");
                if (!TextUtils.isEmpty(a2)) {
                    f1553k = a2;
                }
            }
            return f1553k;
        } catch (Throwable th) {
            this.f1554c.a(th);
            return f1553k;
        }
    }

    public void a(Context context) {
        if (this.f1555g == null) {
            this.f1555g = context;
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(com.umeng.analytics.pro.am.aw, str3);
            hashMap.put("stacktrace", str2);
            a(str, b, hashMap);
        } catch (Exception e2) {
            this.f1554c.a(e2);
        }
    }

    private void a(String str, String str2, HashMap<String, String> hashMap) {
        Uri.Builder builder = new Uri.Builder();
        try {
            Uri.Builder appendQueryParameter = builder.appendQueryParameter("type", str2).appendQueryParameter(com.umeng.analytics.pro.am.bd, "9.24").appendQueryParameter("appsid", a("appsid", new Object[0]));
            Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("v", "android_" + d() + "_" + cb.f1559f);
            Context context = this.f1555g;
            Uri.Builder appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("pack", context != null ? context.getPackageName() : "").appendQueryParameter("sn", a("encodedSn", this.f1555g)).appendQueryParameter("cuid", a("encodedCUID", this.f1555g)).appendQueryParameter(com.umeng.analytics.pro.am.x, Constants.ANDROID).appendQueryParameter("osv", bc.a(this.f1555g).c()).appendQueryParameter("romn", b()).appendQueryParameter("romv", c());
            Uri.Builder appendQueryParameter4 = appendQueryParameter3.appendQueryParameter("bdr", "" + bc.a(this.f1555g).a());
            appendQueryParameter4.appendQueryParameter("brd", "" + a(bc.a(this.f1555g).e()));
            if (str != null && str.length() > 128) {
                int indexOf = str.indexOf(10);
                if (indexOf <= 0) {
                    indexOf = 127;
                }
                str = str.substring(0, indexOf);
            }
            builder.appendQueryParameter(RewardItem.KEY_REASON, str);
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.f1554c.a(th);
        }
        ak akVar = new ak(a, "POST");
        akVar.a(builder);
        akVar.b();
    }

    private String a(String str, Object... objArr) {
        IXAdContainerFactory c2;
        y a2 = y.a();
        if (a2 == null || (c2 = a2.c()) == null) {
            return "";
        }
        Object remoteParam = c2.getRemoteParam(str, objArr);
        return remoteParam instanceof String ? (String) remoteParam : "";
    }

    private String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            this.f1554c.a(th);
            return str2;
        }
    }
}
