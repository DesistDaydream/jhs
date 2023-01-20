package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.umeng.analytics.pro.am;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes3.dex */
public class a {
    private static Context a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f7507c;

    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0288a {
        private static final a a = new a();

        private C0288a() {
        }
    }

    public static a a(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return C0288a.a;
    }

    private void f(String str) {
        try {
            String replaceAll = str.replaceAll("&=", ExpandableTextView.N).replaceAll("&&", ExpandableTextView.N).replaceAll("==", MqttTopic.TOPIC_LEVEL_SEPARATOR);
            this.b = replaceAll + MqttTopic.TOPIC_LEVEL_SEPARATOR + "Android" + MqttTopic.TOPIC_LEVEL_SEPARATOR + Build.DISPLAY + MqttTopic.TOPIC_LEVEL_SEPARATOR + Build.MODEL + MqttTopic.TOPIC_LEVEL_SEPARATOR + Build.VERSION.RELEASE + ExpandableTextView.N + HelperUtils.getUmengMD5(UMUtils.getAppkey(a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(a, th);
        }
    }

    private void g(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] split = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(am.aQ);
            for (String str3 : split) {
                if (!TextUtils.isEmpty(str3)) {
                    String substring = str3.substring(0, 2);
                    if (substring.endsWith("=")) {
                        substring = substring.replace("=", "");
                    }
                    sb.append(substring);
                }
            }
            this.f7507c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(a, th);
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(am.aI);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(am.aD);
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("h");
    }

    public void e(String str) {
        String substring = str.substring(0, str.indexOf(95));
        g(substring);
        f(substring);
    }

    private a() {
        this.b = null;
        this.f7507c = null;
    }

    public String b() {
        return this.b;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(am.av);
    }

    public String a() {
        return this.f7507c;
    }
}
