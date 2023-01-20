package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.y;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import java.util.Map;

/* loaded from: classes3.dex */
public class Bugly {
    public static final String SDK_IS_DEV = "false";
    private static boolean a = false;
    public static Context applicationContext = null;
    private static String[] b = {"BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule"};

    /* renamed from: c  reason: collision with root package name */
    private static String[] f6474c = {"BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule"};
    public static boolean enable = true;
    public static Boolean isDev;

    public static synchronized String getAppChannel() {
        byte[] bArr;
        synchronized (Bugly.class) {
            com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
            if (b2 == null) {
                return null;
            }
            if (TextUtils.isEmpty(b2.f6527k)) {
                o a2 = o.a();
                if (a2 == null) {
                    return b2.f6527k;
                }
                Map<String, byte[]> a3 = a2.a(556, (n) null, true);
                if (a3 != null && (bArr = a3.get("app_channel")) != null) {
                    return new String(bArr);
                }
            }
            return b2.f6527k;
        }
    }

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static boolean isDev() {
        if (isDev == null) {
            isDev = Boolean.valueOf(Boolean.parseBoolean(SDK_IS_DEV.replace(TIMMentionEditText.TIM_MENTION_TAG, "")));
        }
        return isDev.booleanValue();
    }

    public static synchronized void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        String[] strArr;
        synchronized (Bugly.class) {
            if (a) {
                return;
            }
            a = true;
            Context a2 = ab.a(context);
            applicationContext = a2;
            if (a2 == null) {
                Log.e(y.a, "init arg 'context' should not be null!");
                return;
            }
            if (isDev()) {
                b = f6474c;
            }
            for (String str2 : b) {
                if (str2.equals("BuglyCrashModule")) {
                    b.a(CrashModule.getInstance());
                } else if (!str2.equals("BuglyBetaModule") && !str2.equals("BuglyRqdModule")) {
                    str2.equals("BuglyFeedbackModule");
                }
            }
            b.a = enable;
            b.a(applicationContext, str, z, buglyStrategy);
        }
    }
}
