package com.bytedance.msdk.api.v2.slot;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdmobNativeAdOptions;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import java.util.Map;

/* loaded from: classes.dex */
public class GMAdSlotBanner extends GMAdSlotBase {

    /* renamed from: l  reason: collision with root package name */
    private int f2105l;

    /* renamed from: m  reason: collision with root package name */
    private int f2106m;
    private int n;
    private boolean o;
    private String p;
    private AdmobNativeAdOptions q;

    /* loaded from: classes.dex */
    public static class Builder extends GMAdSlotBase.Builder {

        /* renamed from: k  reason: collision with root package name */
        private int f2107k = 640;

        /* renamed from: l  reason: collision with root package name */
        private int f2108l = 320;

        /* renamed from: m  reason: collision with root package name */
        private int f2109m = 3;
        private boolean n = false;
        private String o = "";
        private AdmobNativeAdOptions p;

        public GMAdSlotBanner build() {
            return new GMAdSlotBanner(this);
        }

        public Builder setAdmobNativeAdOptions(AdmobNativeAdOptions admobNativeAdOptions) {
            this.p = admobNativeAdOptions;
            return this;
        }

        public Builder setAllowShowCloseBtn(boolean z) {
            this.n = z;
            return this;
        }

        public Builder setBannerSize(int i2) {
            this.f2109m = i2;
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
            this.f2107k = i2;
            this.f2108l = i3;
            return this;
        }

        public Builder setMuted(boolean z) {
            this.a = z;
            return this;
        }

        @Deprecated
        public Builder setRefreshTime(int i2) {
            Log.d("TTMediationSDK", "************ 注意：BannerBuilder.setRefreshTime接口已废弃，设置banner轮播时长不生效，需在平台配置轮播功能 ************");
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

    private GMAdSlotBanner(Builder builder) {
        super(builder);
        this.f2105l = builder.f2107k;
        this.f2106m = builder.f2108l;
        this.n = builder.f2109m;
        this.o = builder.n;
        this.p = builder.o;
        this.q = builder.p != null ? builder.p : new AdmobNativeAdOptions();
    }

    public AdmobNativeAdOptions getAdmobNativeAdOptions() {
        return this.q;
    }

    public int getBannerSize() {
        return this.n;
    }

    public int getHeight() {
        return this.f2106m;
    }

    public String getUserID() {
        return this.p;
    }

    public int getWidth() {
        return this.f2105l;
    }

    public boolean isAllowShowCloseBtn() {
        return this.o;
    }
}
