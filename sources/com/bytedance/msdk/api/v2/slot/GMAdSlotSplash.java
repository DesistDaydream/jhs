package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import e.l.r.g0;
import java.util.Map;

/* loaded from: classes.dex */
public class GMAdSlotSplash extends GMAdSlotBase {

    /* renamed from: l  reason: collision with root package name */
    private int f2156l;

    /* renamed from: m  reason: collision with root package name */
    private int f2157m;
    private String n;
    private boolean o;
    private int p;
    @Deprecated
    private int q;
    private boolean r;
    private boolean s;

    /* loaded from: classes.dex */
    public static class Builder extends GMAdSlotBase.Builder {

        /* renamed from: m  reason: collision with root package name */
        private String f2160m;
        private boolean q;
        private boolean r;

        /* renamed from: k  reason: collision with root package name */
        private int f2158k = g0.b.f14277h;

        /* renamed from: l  reason: collision with root package name */
        private int f2159l = g0.b.f14278i;
        private boolean n = false;
        private int o = 3000;
        @Deprecated
        private int p = 1;

        public GMAdSlotSplash build() {
            return new GMAdSlotSplash(this);
        }

        public Builder setBidNotify(boolean z) {
            this.f2125i = z;
            return this;
        }

        @Deprecated
        public Builder setDownloadType(int i2) {
            this.f2124h = i2;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.f2122f;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setForceLoadBottom(boolean z) {
            this.q = z;
            return this;
        }

        public Builder setGMAdSlotBaiduOption(@NonNull GMAdSlotBaiduOption gMAdSlotBaiduOption) {
            this.f2121e = gMAdSlotBaiduOption;
            return this;
        }

        public Builder setGMAdSlotGDTOption(@NonNull GMAdSlotGDTOption gMAdSlotGDTOption) {
            this.f2120d = gMAdSlotGDTOption;
            return this;
        }

        public Builder setImageAdSize(int i2, int i3) {
            this.f2158k = i2;
            this.f2159l = i3;
            return this;
        }

        public Builder setMuted(boolean z) {
            this.a = z;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.f2126j = str;
            return this;
        }

        @Deprecated
        public Builder setSplashButtonType(int i2) {
            this.p = i2;
            return this;
        }

        public Builder setSplashPreLoad(boolean z) {
            this.n = z;
            return this;
        }

        public Builder setSplashShakeButton(boolean z) {
            this.r = z;
            return this;
        }

        @Deprecated
        public Builder setTestSlotId(String str) {
            this.f2123g = str;
            return this;
        }

        public Builder setTimeOut(int i2) {
            this.o = i2;
            return this;
        }

        public Builder setUseSurfaceView(boolean z) {
            this.f2119c = z;
            return this;
        }

        public Builder setUserID(String str) {
            this.f2160m = str;
            return this;
        }

        public Builder setVolume(float f2) {
            this.b = f2;
            return this;
        }
    }

    private GMAdSlotSplash(Builder builder) {
        super(builder);
        this.f2156l = builder.f2158k;
        this.f2157m = builder.f2159l;
        this.n = builder.f2160m;
        this.o = builder.n;
        this.p = builder.o;
        this.q = builder.p;
        this.r = builder.q;
        this.s = builder.r;
    }

    public int getHeight() {
        return this.f2157m;
    }

    @Deprecated
    public int getSplashButtonType() {
        return this.q;
    }

    public boolean getSplashShakeButton() {
        return this.s;
    }

    public int getTimeOut() {
        return this.p;
    }

    public String getUserID() {
        return this.n;
    }

    public int getWidth() {
        return this.f2156l;
    }

    public boolean isForceLoadBottom() {
        return this.r;
    }

    public boolean isSplashPreLoad() {
        return this.o;
    }
}
