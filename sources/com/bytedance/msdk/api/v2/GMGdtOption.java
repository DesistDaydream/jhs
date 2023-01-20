package com.bytedance.msdk.api.v2;

/* loaded from: classes.dex */
public class GMGdtOption {
    private boolean a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2021c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2022d;

    /* loaded from: classes.dex */
    public static class Builder {
        private boolean a = false;
        private String b = null;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2023c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2024d = false;

        public GMGdtOption build() {
            return new GMGdtOption(this);
        }

        public Builder setOpensdkVer(String str) {
            this.b = str;
            return this;
        }

        public Builder setSupportH265(boolean z) {
            this.f2023c = z;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z) {
            this.f2024d = z;
            return this;
        }

        public Builder setWxInstalled(boolean z) {
            this.a = z;
            return this;
        }
    }

    private GMGdtOption(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.f2021c = builder.f2023c;
        this.f2022d = builder.f2024d;
    }

    public String getOpensdkVer() {
        return this.b;
    }

    public boolean isSupportH265() {
        return this.f2021c;
    }

    public boolean isSupportSplashZoomout() {
        return this.f2022d;
    }

    public boolean isWxInstalled() {
        return this.a;
    }
}
