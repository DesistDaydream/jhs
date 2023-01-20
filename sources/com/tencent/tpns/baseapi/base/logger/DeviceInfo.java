package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import android.os.Build;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class DeviceInfo {
    private BuildInfo a = new BuildInfo();
    private ScreenInfo b;

    /* loaded from: classes3.dex */
    public class BuildInfo {
        private String b = Build.BRAND;

        /* renamed from: c  reason: collision with root package name */
        private String f6840c = Build.VERSION.RELEASE;

        /* renamed from: d  reason: collision with root package name */
        private int f6841d = Build.VERSION.SDK_INT;

        /* renamed from: e  reason: collision with root package name */
        private String f6842e = Locale.getDefault().getLanguage();

        /* renamed from: f  reason: collision with root package name */
        private String f6843f = TimeZone.getDefault().getID();

        public BuildInfo() {
        }

        public String toString() {
            return "BuildInfo{brand='" + this.b + "', systemVersion='" + this.f6840c + "', sdkVersion=" + this.f6841d + ", language='" + this.f6842e + "', timezone='" + this.f6843f + "'}";
        }
    }

    /* loaded from: classes3.dex */
    public class ScreenInfo {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f6844c;

        public ScreenInfo(Context context) {
            this.b = a(context);
            this.f6844c = b(context);
        }

        private int a(Context context) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }

        private int b(Context context) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }

        public String toString() {
            return "ScreenInfo{width=" + this.b + ", height=" + this.f6844c + '}';
        }
    }

    public DeviceInfo(Context context) {
        this.b = new ScreenInfo(context);
    }

    public String toString() {
        return "DeviceInfo{buildInfo=" + this.a + ", screenInfo=" + this.b + '}';
    }
}
