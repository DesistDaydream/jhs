package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collection;

/* loaded from: classes3.dex */
public class jm {

    /* loaded from: classes3.dex */
    public static class a {
        private final StringBuilder a;
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private final String f9023c;

        public a() {
            this(Constants.COLON_SEPARATOR, Constants.ACCEPT_TIME_SEPARATOR_SP);
        }

        public a(String str, String str2) {
            this.a = new StringBuilder();
            this.b = str;
            this.f9023c = str2;
        }

        public a a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (this.a.length() > 0) {
                    this.a.append(this.f9023c);
                }
                StringBuilder sb = this.a;
                sb.append(str);
                sb.append(this.b);
                sb.append(obj);
            }
            return this;
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public static int a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i2;
        }
    }

    public static boolean a() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return Build.VERSION.SDK_INT >= 20 ? powerManager != null && powerManager.isInteractive() : powerManager != null && powerManager.isScreenOn();
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static int b(String str, int i2) {
        return !TextUtils.isEmpty(str) ? ((str.hashCode() / 10) * 10) + i2 : i2;
    }
}
