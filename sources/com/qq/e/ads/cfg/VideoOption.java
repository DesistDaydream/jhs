package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class VideoOption {
    private final boolean a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4988c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f4989d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f4990e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f4991f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f4992g;

    /* renamed from: h  reason: collision with root package name */
    private final int f4993h;

    /* renamed from: i  reason: collision with root package name */
    private final int f4994i;

    /* loaded from: classes3.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private boolean a = true;
        private int b = 1;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4995c = true;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4996d = true;

        /* renamed from: e  reason: collision with root package name */
        private boolean f4997e = true;

        /* renamed from: f  reason: collision with root package name */
        private boolean f4998f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f4999g = false;

        /* renamed from: h  reason: collision with root package name */
        private int f5000h;

        /* renamed from: i  reason: collision with root package name */
        private int f5001i;

        public VideoOption build() {
            return new VideoOption(this);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.a = z;
            return this;
        }

        public Builder setAutoPlayPolicy(int i2) {
            if (i2 < 0 || i2 > 2) {
                i2 = 1;
                GDTLogger.e("setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : 1");
            }
            this.b = i2;
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f4999g = z;
            return this;
        }

        public Builder setEnableDetailPage(boolean z) {
            this.f4997e = z;
            return this;
        }

        public Builder setEnableUserControl(boolean z) {
            this.f4998f = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i2) {
            this.f5000h = i2;
            return this;
        }

        public Builder setMinVideoDuration(int i2) {
            this.f5001i = i2;
            return this;
        }

        public Builder setNeedCoverImage(boolean z) {
            this.f4996d = z;
            return this;
        }

        public Builder setNeedProgressBar(boolean z) {
            this.f4995c = z;
            return this;
        }
    }

    private VideoOption(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.f4988c = builder.f4995c;
        this.f4989d = builder.f4996d;
        this.f4990e = builder.f4997e;
        this.f4991f = builder.f4998f;
        this.f4992g = builder.f4999g;
        this.f4993h = builder.f5000h;
        this.f4994i = builder.f5001i;
    }

    public boolean getAutoPlayMuted() {
        return this.a;
    }

    public int getAutoPlayPolicy() {
        return this.b;
    }

    public int getMaxVideoDuration() {
        return this.f4993h;
    }

    public int getMinVideoDuration() {
        return this.f4994i;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f4992g));
        } catch (Exception e2) {
            GDTLogger.d("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f4992g;
    }

    public boolean isEnableDetailPage() {
        return this.f4990e;
    }

    public boolean isEnableUserControl() {
        return this.f4991f;
    }

    public boolean isNeedCoverImage() {
        return this.f4989d;
    }

    public boolean isNeedProgressBar() {
        return this.f4988c;
    }
}
