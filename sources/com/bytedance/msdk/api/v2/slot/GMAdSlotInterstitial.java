package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import java.util.Map;

/* loaded from: classes.dex */
public class GMAdSlotInterstitial extends GMAdSlotBase {

    /* renamed from: l  reason: collision with root package name */
    private int f2137l;

    /* renamed from: m  reason: collision with root package name */
    private int f2138m;

    /* loaded from: classes.dex */
    public static class Builder extends GMAdSlotBase.Builder {

        /* renamed from: k  reason: collision with root package name */
        private int f2139k = 640;

        /* renamed from: l  reason: collision with root package name */
        private int f2140l = 320;

        public GMAdSlotInterstitial build() {
            return new GMAdSlotInterstitial(this);
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

        public Builder setGMAdSlotBaiduOption(@NonNull GMAdSlotBaiduOption gMAdSlotBaiduOption) {
            this.f2121e = gMAdSlotBaiduOption;
            return this;
        }

        public Builder setGMAdSlotGDTOption(@NonNull GMAdSlotGDTOption gMAdSlotGDTOption) {
            this.f2120d = gMAdSlotGDTOption;
            return this;
        }

        public Builder setImageAdSize(int i2, int i3) {
            this.f2139k = i2;
            this.f2140l = i3;
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
        public Builder setTestSlotId(String str) {
            this.f2123g = str;
            return this;
        }

        public Builder setUseSurfaceView(boolean z) {
            this.f2119c = z;
            return this;
        }

        public Builder setVolume(float f2) {
            this.b = f2;
            return this;
        }
    }

    private GMAdSlotInterstitial(Builder builder) {
        super(builder);
        this.f2137l = builder.f2139k;
        this.f2138m = builder.f2140l;
    }

    public int getHeight() {
        return this.f2138m;
    }

    public int getWidth() {
        return this.f2137l;
    }
}
