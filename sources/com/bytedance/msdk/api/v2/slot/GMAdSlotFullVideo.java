package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import java.util.Map;

/* loaded from: classes.dex */
public class GMAdSlotFullVideo extends GMAdSlotBase {

    /* renamed from: l  reason: collision with root package name */
    private String f2132l;

    /* renamed from: m  reason: collision with root package name */
    private int f2133m;
    private String n;
    private int o;
    private Map<String, String> p;

    /* loaded from: classes.dex */
    public static class Builder extends GMAdSlotBase.Builder {

        /* renamed from: k  reason: collision with root package name */
        private String f2134k;

        /* renamed from: l  reason: collision with root package name */
        private int f2135l;

        /* renamed from: m  reason: collision with root package name */
        private String f2136m = "";
        private int n = 0;
        private Map<String, String> o;

        public GMAdSlotFullVideo build() {
            return new GMAdSlotFullVideo(this);
        }

        public Builder setBidNotify(boolean z) {
            this.f2125i = z;
            return this;
        }

        public Builder setCustomData(@NonNull Map<String, String> map) {
            this.o = map;
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
            this.f2135l = i2;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.n = i2;
            return this;
        }

        public Builder setRewardName(@NonNull String str) {
            this.f2136m = str;
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
            this.f2134k = str;
            return this;
        }

        public Builder setVolume(float f2) {
            this.b = f2;
            return this;
        }
    }

    private GMAdSlotFullVideo(Builder builder) {
        super(builder);
        this.f2132l = builder.f2134k;
        this.f2133m = builder.f2135l;
        this.n = builder.f2136m;
        this.o = builder.n;
        this.p = builder.o;
    }

    @Nullable
    public Map<String, String> getCustomData() {
        return this.p;
    }

    public int getOrientation() {
        return this.f2133m;
    }

    public int getRewardAmount() {
        return this.o;
    }

    public String getRewardName() {
        return this.n;
    }

    public String getUserID() {
        return this.f2132l;
    }
}
