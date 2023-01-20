package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdmobNativeAdOptions;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import java.util.Map;

/* loaded from: classes.dex */
public class GMAdSlotNative extends GMAdSlotBase {

    /* renamed from: l  reason: collision with root package name */
    private int f2146l;

    /* renamed from: m  reason: collision with root package name */
    private int f2147m;
    private int n;
    private int o;
    private String p;
    private AdmobNativeAdOptions q;

    /* loaded from: classes.dex */
    public static class Builder extends GMAdSlotBase.Builder {

        /* renamed from: k  reason: collision with root package name */
        private int f2148k = 640;

        /* renamed from: l  reason: collision with root package name */
        private int f2149l = 320;

        /* renamed from: m  reason: collision with root package name */
        private int f2150m = 1;
        private int n = 2;
        private String o = "";
        private AdmobNativeAdOptions p;

        public GMAdSlotNative build() {
            return new GMAdSlotNative(this);
        }

        public Builder setAdCount(int i2) {
            this.f2150m = i2;
            return this;
        }

        public Builder setAdStyleType(int i2) {
            this.n = i2;
            return this;
        }

        public Builder setAdmobNativeAdOptions(AdmobNativeAdOptions admobNativeAdOptions) {
            this.p = admobNativeAdOptions;
            return this;
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
            this.f2148k = i2;
            this.f2149l = i3;
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

        public Builder setUserID(String str) {
            this.o = str;
            return this;
        }

        public Builder setVolume(float f2) {
            this.b = f2;
            return this;
        }
    }

    private GMAdSlotNative(Builder builder) {
        super(builder);
        this.f2146l = builder.f2148k;
        this.f2147m = builder.f2149l;
        this.n = builder.f2150m;
        this.p = builder.o;
        this.o = builder.n;
        this.q = builder.p != null ? builder.p : new AdmobNativeAdOptions();
    }

    public int getAdCount() {
        int i2 = this.n;
        if (i2 <= 0) {
            return 1;
        }
        if (i2 <= 3) {
            return i2;
        }
        return 3;
    }

    public int getAdStyleType() {
        return this.o;
    }

    public AdmobNativeAdOptions getAdmobNativeAdOptions() {
        return this.q;
    }

    public int getHeight() {
        return this.f2147m;
    }

    public int getRequestCount() {
        int netWorkNum = getNetWorkNum();
        if (netWorkNum > 3) {
            netWorkNum = 3;
        }
        if (netWorkNum <= 0) {
            netWorkNum = this.n;
            if (netWorkNum <= 0) {
                return 1;
            }
            if (netWorkNum > 3) {
                return 3;
            }
        }
        return netWorkNum;
    }

    public String getUserID() {
        return this.p;
    }

    public int getWidth() {
        return this.f2146l;
    }
}
