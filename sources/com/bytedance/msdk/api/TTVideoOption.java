package com.bytedance.msdk.api;

@Deprecated
/* loaded from: classes.dex */
public class TTVideoOption {
    private final boolean a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private float f1971c;

    /* renamed from: d  reason: collision with root package name */
    private GDTExtraOption f1972d;

    /* renamed from: e  reason: collision with root package name */
    private BaiduExtraOptions f1973e;

    /* loaded from: classes.dex */
    public static final class Builder {
        @Deprecated
        private boolean a = true;
        @Deprecated
        private float b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        private GDTExtraOption f1974c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        private boolean f1975d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        private BaiduExtraOptions f1976e;

        public final TTVideoOption build() {
            return new TTVideoOption(this);
        }

        @Deprecated
        public Builder setAdmobAppVolume(float f2) {
            if (f2 > 1.0f) {
                f2 = 1.0f;
            } else if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            this.b = f2;
            return this;
        }

        @Deprecated
        public Builder setBaiduExtraOption(BaiduExtraOptions baiduExtraOptions) {
            this.f1976e = baiduExtraOptions;
            return this;
        }

        @Deprecated
        public Builder setGDTExtraOption(GDTExtraOption gDTExtraOption) {
            this.f1974c = gDTExtraOption;
            return this;
        }

        @Deprecated
        public final Builder setMuted(boolean z) {
            this.a = z;
            return this;
        }

        @Deprecated
        public final Builder useSurfaceView(boolean z) {
            this.f1975d = z;
            return this;
        }
    }

    private TTVideoOption(Builder builder) {
        this.a = builder.a;
        this.f1971c = builder.b;
        this.f1972d = builder.f1974c;
        this.b = builder.f1975d;
        this.f1973e = builder.f1976e;
    }

    public float getAdmobAppVolume() {
        return this.f1971c;
    }

    public BaiduExtraOptions getBaiduExtraOption() {
        return this.f1973e;
    }

    public GDTExtraOption getGDTExtraOption() {
        return this.f1972d;
    }

    public boolean isMuted() {
        return this.a;
    }

    public boolean useSurfaceView() {
        return this.b;
    }
}
