package com.bytedance.msdk.api;

import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;

@Deprecated
/* loaded from: classes.dex */
public class GDTExtraOption {
    private boolean a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1920c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1921d;

    /* renamed from: e  reason: collision with root package name */
    private int f1922e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1923f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1924g;

    /* renamed from: h  reason: collision with root package name */
    private final int f1925h;

    /* renamed from: i  reason: collision with root package name */
    private final int f1926i;

    /* renamed from: j  reason: collision with root package name */
    private final int f1927j;

    /* renamed from: k  reason: collision with root package name */
    private final int f1928k;

    /* renamed from: l  reason: collision with root package name */
    private int f1929l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1930m;

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
        private boolean f1931c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1932d;

        /* renamed from: e  reason: collision with root package name */
        private int f1933e;

        /* renamed from: f  reason: collision with root package name */
        private int f1934f;

        /* renamed from: g  reason: collision with root package name */
        private int f1935g;

        /* renamed from: h  reason: collision with root package name */
        private int f1936h;

        /* renamed from: i  reason: collision with root package name */
        private int f1937i;

        /* renamed from: j  reason: collision with root package name */
        private int f1938j;

        /* renamed from: k  reason: collision with root package name */
        private int f1939k;

        /* renamed from: l  reason: collision with root package name */
        private int f1940l = 1;

        /* renamed from: m  reason: collision with root package name */
        private boolean f1941m;

        public final GDTExtraOption build() {
            return new GDTExtraOption(this);
        }

        public Builder setAutoPlayPolicy(int i2) {
            this.f1935g = i2;
            return this;
        }

        public Builder setBrowserType(int i2) {
            this.f1936h = i2;
            return this;
        }

        public Builder setDownAPPConfirmPolicy(int i2) {
            this.f1937i = i2;
            return this;
        }

        public Builder setFeedExpressType(int i2) {
            this.f1940l = i2;
            return this;
        }

        public Builder setGDTAutoPlayMuted(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setGDTDetailPageMuted(boolean z) {
            this.f1931c = z;
            return this;
        }

        public Builder setGDTEnableDetailPage(boolean z) {
            this.a = z;
            return this;
        }

        public Builder setGDTEnableUserControl(boolean z) {
            this.f1932d = z;
            return this;
        }

        public Builder setGDTMaxVideoDuration(int i2) {
            this.f1934f = i2;
            return this;
        }

        public Builder setGDTMinVideoDuration(int i2) {
            this.f1933e = i2;
            return this;
        }

        public Builder setHeight(int i2) {
            this.f1939k = i2;
            return this;
        }

        public Builder setSplashPreLoad(boolean z) {
            this.f1941m = z;
            return this;
        }

        public Builder setWidth(int i2) {
            this.f1938j = i2;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class DownAPPConfirmPolicy {
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_NO_CONFIRM = 1;
    }

    /* loaded from: classes.dex */
    public static final class FeedExpressType {
        public static final int FEED_EXPRESS_TYPE_1 = 1;
        public static final int FEED_EXPRESS_TYPE_2 = 2;
    }

    /* loaded from: classes.dex */
    public static final class VideoPlayPolicy {
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
    }

    private GDTExtraOption(Builder builder) {
        this.a = true;
        this.b = true;
        this.f1920c = false;
        this.f1921d = false;
        this.f1922e = 0;
        this.f1929l = 1;
        this.a = builder.a;
        this.b = builder.b;
        this.f1920c = builder.f1931c;
        this.f1921d = builder.f1932d;
        this.f1923f = builder.f1933e;
        this.f1924g = builder.f1934f;
        this.f1922e = builder.f1935g;
        this.f1925h = builder.f1936h;
        this.f1926i = builder.f1937i;
        this.f1927j = builder.f1938j;
        this.f1928k = builder.f1939k;
        this.f1929l = builder.f1940l;
        this.f1930m = builder.f1941m;
    }

    public int getBrowserType() {
        return this.f1925h;
    }

    public int getDownAPPConfirmPolicy() {
        return this.f1926i;
    }

    public int getFeedExpressType() {
        return this.f1929l;
    }

    public int getGDTAutoPlayPolicy() {
        return this.f1922e;
    }

    public int getGDTMaxVideoDuration() {
        return this.f1924g;
    }

    public int getGDTMinVideoDuration() {
        return this.f1923f;
    }

    public GMAdSlotGDTOption.Builder getGMGDTExtraOption() {
        GMAdSlotGDTOption.Builder builder = new GMAdSlotGDTOption.Builder();
        builder.setAutoPlayPolicy(getGDTAutoPlayPolicy());
        builder.setDownAPPConfirmPolicy(getDownAPPConfirmPolicy());
        builder.setGDTAutoPlayMuted(isGDTAutoPlayMuted());
        builder.setGDTDetailPageMuted(isGDTDetailPageMuted());
        builder.setGDTEnableDetailPage(isGDTEnableDetailPage());
        builder.setGDTEnableUserControl(isGDTEnableUserControl());
        builder.setGDTMaxVideoDuration(getGDTMaxVideoDuration());
        builder.setGDTMinVideoDuration(getGDTMinVideoDuration());
        return builder;
    }

    public int getHeight() {
        return this.f1928k;
    }

    public int getWidth() {
        return this.f1927j;
    }

    public boolean isGDTAutoPlayMuted() {
        return this.b;
    }

    public boolean isGDTDetailPageMuted() {
        return this.f1920c;
    }

    public boolean isGDTEnableDetailPage() {
        return this.a;
    }

    public boolean isGDTEnableUserControl() {
        return this.f1921d;
    }

    public boolean isSplashPreLoad() {
        return this.f1930m;
    }
}
