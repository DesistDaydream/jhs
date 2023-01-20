package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import java.util.Map;

/* loaded from: classes.dex */
public class GMAdSlotRewardVideo extends GMAdSlotBase {

    /* renamed from: l  reason: collision with root package name */
    private String f2151l;

    /* renamed from: m  reason: collision with root package name */
    private int f2152m;
    private Map<String, String> n;
    private String o;
    private int p;

    /* loaded from: classes.dex */
    public static class Builder extends GMAdSlotBase.Builder {

        /* renamed from: m  reason: collision with root package name */
        private Map<String, String> f2155m;
        private int o;

        /* renamed from: k  reason: collision with root package name */
        private String f2153k = "";

        /* renamed from: l  reason: collision with root package name */
        private int f2154l = 0;
        private String n = "";

        public GMAdSlotRewardVideo build() {
            return new GMAdSlotRewardVideo(this);
        }

        public Builder setBidNotify(boolean z) {
            this.f2125i = z;
            return this;
        }

        public Builder setCustomData(@NonNull Map<String, String> map) {
            this.f2155m = map;
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

        public Builder setMuted(boolean z) {
            this.a = z;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.o = i2;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.f2154l = i2;
            return this;
        }

        public Builder setRewardName(@NonNull String str) {
            this.f2153k = str;
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
            this.n = str;
            return this;
        }

        public Builder setVolume(float f2) {
            this.b = f2;
            return this;
        }
    }

    private GMAdSlotRewardVideo(Builder builder) {
        super(builder);
        this.f2151l = builder.f2153k;
        this.f2152m = builder.f2154l;
        this.n = builder.f2155m;
        this.o = builder.n;
        this.p = builder.o;
    }

    @Nullable
    public Map<String, String> getCustomData() {
        return this.n;
    }

    public int getOrientation() {
        return this.p;
    }

    public int getRewardAmount() {
        return this.f2152m;
    }

    public String getRewardName() {
        return this.f2151l;
    }

    public String getUserID() {
        return this.o;
    }
}
