package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import java.util.Map;

/* loaded from: classes.dex */
public class GMAdSlotInterstitialFull extends GMAdSlotBase {

    /* renamed from: l  reason: collision with root package name */
    private int f2141l;

    /* renamed from: m  reason: collision with root package name */
    private int f2142m;
    private String n;
    private int o;
    private String p;
    private int q;
    private Map<String, String> r;

    /* loaded from: classes.dex */
    public static class Builder extends GMAdSlotBase.Builder {

        /* renamed from: k  reason: collision with root package name */
        private int f2143k = 640;

        /* renamed from: l  reason: collision with root package name */
        private int f2144l = 320;

        /* renamed from: m  reason: collision with root package name */
        private String f2145m;
        private int n;
        private String o;
        private int p;
        private Map<String, String> q;

        public GMAdSlotInterstitialFull build() {
            return new GMAdSlotInterstitialFull(this);
        }

        public Builder setBidNotify(boolean z) {
            this.f2125i = z;
            return this;
        }

        public Builder setCustomData(@NonNull Map<String, String> map) {
            this.q = map;
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

        public Builder setGMAdSlotBaiduOption(@NonNull GMAdSlotBaiduOption gMAdSlotBaiduOption) {
            this.f2121e = gMAdSlotBaiduOption;
            return this;
        }

        public Builder setGMAdSlotGDTOption(@NonNull GMAdSlotGDTOption gMAdSlotGDTOption) {
            this.f2120d = gMAdSlotGDTOption;
            return this;
        }

        public Builder setImageAdSize(int i2, int i3) {
            this.f2143k = i2;
            this.f2144l = i3;
            return this;
        }

        public Builder setMuted(boolean z) {
            this.a = z;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.n = i2;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.p = i2;
            return this;
        }

        public Builder setRewardName(@NonNull String str) {
            this.o = str;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.f2126j = str;
            return this;
        }

        @Deprecated
        public Builder setTestSlotId(String str) {
            this.f2123g = str;
            return this;
        }

        public Builder setUseSurfaceView(boolean z) {
            this.f2119c = z;
            return this;
        }

        public Builder setUserID(String str) {
            this.f2145m = str;
            return this;
        }

        public Builder setVolume(float f2) {
            this.b = f2;
            return this;
        }
    }

    private GMAdSlotInterstitialFull(Builder builder) {
        super(builder);
        this.f2141l = builder.f2143k;
        this.f2142m = builder.f2144l;
        this.n = builder.f2145m;
        this.o = builder.n;
        this.p = builder.o;
        this.q = builder.p;
        this.r = builder.q;
    }

    @Nullable
    public Map<String, String> getCustomData() {
        return this.r;
    }

    public GMAdSlotFullVideo getGMAdSlotFullVideo() {
        GMAdSlotFullVideo build = new GMAdSlotFullVideo.Builder().setUserID(this.n).setOrientation(this.o).setMuted(isMuted()).setVolume(getVolume()).setUseSurfaceView(isUseSurfaceView()).setGMAdSlotGDTOption(this.f2111d).setGMAdSlotBaiduOption(this.f2112e).setTestSlotId(getTestSlotId()).setDownloadType(getDownloadType()).setBidNotify(isBidNotify()).setRewardName(getRewardName()).setRewardAmount(getRewardAmount()).setCustomData(getCustomData()).build();
        if (build.getParams() != null && getParams() != null) {
            build.getParams().putAll(getParams());
        }
        return build;
    }

    public GMAdSlotInterstitial getGMAdSlotInterstitial() {
        GMAdSlotInterstitial build = new GMAdSlotInterstitial.Builder().setImageAdSize(getWidth(), getHeight()).setMuted(isMuted()).setVolume(getVolume()).setUseSurfaceView(isUseSurfaceView()).setGMAdSlotGDTOption(this.f2111d).setGMAdSlotBaiduOption(this.f2112e).setTestSlotId(getTestSlotId()).setDownloadType(getDownloadType()).setBidNotify(isBidNotify()).build();
        if (build.getParams() != null && getParams() != null) {
            build.getParams().putAll(getParams());
        }
        return build;
    }

    public int getHeight() {
        return this.f2142m;
    }

    public int getOrientation() {
        return this.o;
    }

    public int getRewardAmount() {
        return this.q;
    }

    public String getRewardName() {
        return this.p;
    }

    public String getUserID() {
        return this.n;
    }

    public int getWidth() {
        return this.f2141l;
    }
}
