package com.bytedance.msdk.api.v2.slot.paltform;

import android.widget.FrameLayout;
import com.bytedance.msdk.api.GDTExtraOption;

/* loaded from: classes.dex */
public class GMAdSlotGDTOption {
    private boolean a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2173c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2174d;

    /* renamed from: e  reason: collision with root package name */
    private int f2175e;

    /* renamed from: f  reason: collision with root package name */
    private final int f2176f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2177g;

    /* renamed from: h  reason: collision with root package name */
    private final int f2178h;

    /* renamed from: i  reason: collision with root package name */
    private FrameLayout.LayoutParams f2179i;

    /* loaded from: classes.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: classes.dex */
    public static final class BrowserType {
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_INNER = 1;
        public static final int TYPE_SYS = 2;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2180c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2181d;

        /* renamed from: e  reason: collision with root package name */
        private int f2182e;

        /* renamed from: f  reason: collision with root package name */
        private int f2183f;

        /* renamed from: g  reason: collision with root package name */
        private int f2184g;

        /* renamed from: h  reason: collision with root package name */
        private int f2185h;

        /* renamed from: i  reason: collision with root package name */
        private FrameLayout.LayoutParams f2186i;

        public final GMAdSlotGDTOption build() {
            return new GMAdSlotGDTOption(this);
        }

        public Builder setAutoPlayPolicy(int i2) {
            this.f2184g = i2;
            return this;
        }

        public Builder setDownAPPConfirmPolicy(int i2) {
            this.f2185h = i2;
            return this;
        }

        public Builder setGDTAutoPlayMuted(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setGDTDetailPageMuted(boolean z) {
            this.f2180c = z;
            return this;
        }

        public Builder setGDTEnableDetailPage(boolean z) {
            this.a = z;
            return this;
        }

        public Builder setGDTEnableUserControl(boolean z) {
            this.f2181d = z;
            return this;
        }

        public Builder setGDTMaxVideoDuration(int i2) {
            this.f2183f = i2;
            return this;
        }

        public Builder setGDTMinVideoDuration(int i2) {
            this.f2182e = i2;
            return this;
        }

        public Builder setNativeAdLogoParams(FrameLayout.LayoutParams layoutParams) {
            this.f2186i = layoutParams;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class DownAPPConfirmPolicy {
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_NO_CONFIRM = 1;
    }

    /* loaded from: classes.dex */
    public static final class VideoPlayPolicy {
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
    }

    private GMAdSlotGDTOption(Builder builder) {
        this.a = true;
        this.b = true;
        this.f2173c = false;
        this.f2174d = false;
        this.f2175e = 0;
        this.a = builder.a;
        this.b = builder.b;
        this.f2173c = builder.f2180c;
        this.f2174d = builder.f2181d;
        this.f2176f = builder.f2182e;
        this.f2177g = builder.f2183f;
        this.f2175e = builder.f2184g;
        this.f2178h = builder.f2185h;
        this.f2179i = builder.f2186i;
    }

    public int getDownAPPConfirmPolicy() {
        return this.f2178h;
    }

    public int getGDTAutoPlayPolicy() {
        return this.f2175e;
    }

    public GDTExtraOption getGDTExtraOption(boolean z) {
        GDTExtraOption.Builder builder = new GDTExtraOption.Builder();
        builder.setAutoPlayPolicy(getGDTAutoPlayPolicy());
        builder.setDownAPPConfirmPolicy(getDownAPPConfirmPolicy());
        builder.setGDTAutoPlayMuted(isGDTAutoPlayMuted());
        builder.setGDTDetailPageMuted(isGDTDetailPageMuted());
        builder.setGDTEnableDetailPage(isGDTEnableDetailPage());
        builder.setGDTEnableUserControl(isGDTEnableUserControl());
        builder.setGDTMaxVideoDuration(getGDTMaxVideoDuration());
        builder.setGDTMinVideoDuration(getGDTMinVideoDuration());
        builder.setSplashPreLoad(z);
        return builder.build();
    }

    public int getGDTMaxVideoDuration() {
        return this.f2177g;
    }

    public int getGDTMinVideoDuration() {
        return this.f2176f;
    }

    public FrameLayout.LayoutParams getNativeAdLogoParams() {
        return this.f2179i;
    }

    public boolean isGDTAutoPlayMuted() {
        return this.b;
    }

    public boolean isGDTDetailPageMuted() {
        return this.f2173c;
    }

    public boolean isGDTEnableDetailPage() {
        return this.a;
    }

    public boolean isGDTEnableUserControl() {
        return this.f2174d;
    }
}
