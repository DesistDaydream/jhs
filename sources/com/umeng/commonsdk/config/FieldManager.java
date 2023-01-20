package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class FieldManager {
    private static final String a = "cfgfd";
    private static b b = b.b();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f7323c = false;

    /* renamed from: d  reason: collision with root package name */
    private static Object f7324d = new Object();

    /* loaded from: classes3.dex */
    public static class a {
        private static final FieldManager a = new FieldManager();

        private a() {
        }
    }

    public static FieldManager a() {
        return a.a;
    }

    public static boolean allow(String str) {
        synchronized (f7324d) {
            if (f7323c) {
                return b.a(str);
            }
            return false;
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (f7324d) {
            z = f7323c;
        }
        return z;
    }

    private FieldManager() {
    }

    public void a(Context context) {
        String str;
        String str2 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0284d.class.getName()};
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3749699455,2130669566,262139,1983");
        synchronized (f7324d) {
            Pair<Long, String> a2 = a(imprintProperty);
            if (((Long) a2.first).longValue() > 1000 && (str = (String) a2.second) != null && str.length() > 0) {
                str2 = str;
            }
            String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i2)).a(split[i2], b, d.b(strArr[i2]));
                }
            }
            f7323c = true;
        }
    }

    public void a(Context context, String str) {
        String str2;
        String str3 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0284d.class.getName()};
        synchronized (f7324d) {
            b.a();
            if (str != null) {
                Pair<Long, String> a2 = a(str);
                if (((Long) a2.first).longValue() > 1000 && (str2 = (String) a2.second) != null && str2.length() > 0) {
                    str3 = str2;
                }
            }
            String[] split = str3.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i2)).a(split[i2], b, d.b(strArr[i2]));
                }
            }
            f7323c = true;
        }
    }

    private static Pair<Long, String> a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] split = str.split(TIMMentionEditText.TIM_MENTION_TAG);
            if (split.length < 2) {
                return pair;
            }
            try {
                long parseLong = Long.parseLong(split[0]);
                return new Pair<>(Long.valueOf(parseLong), split[1]);
            } catch (Throwable unused) {
            }
        }
        return pair;
    }
}
