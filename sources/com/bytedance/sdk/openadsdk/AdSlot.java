package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdSlot implements TTAdSlot {
    private String a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f2352c;

    /* renamed from: d  reason: collision with root package name */
    private float f2353d;

    /* renamed from: e  reason: collision with root package name */
    private float f2354e;

    /* renamed from: f  reason: collision with root package name */
    private int f2355f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2356g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2357h;

    /* renamed from: i  reason: collision with root package name */
    private String f2358i;

    /* renamed from: j  reason: collision with root package name */
    private String f2359j;

    /* renamed from: k  reason: collision with root package name */
    private int f2360k;

    /* renamed from: l  reason: collision with root package name */
    private int f2361l;

    /* renamed from: m  reason: collision with root package name */
    private int f2362m;
    private int n;
    private boolean o;
    private int[] p;
    private String q;
    private int r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private TTAdLoadType y;

    /* loaded from: classes.dex */
    public static class Builder {
        private String a;

        /* renamed from: g  reason: collision with root package name */
        private String f2367g;

        /* renamed from: j  reason: collision with root package name */
        private int f2370j;

        /* renamed from: k  reason: collision with root package name */
        private String f2371k;

        /* renamed from: l  reason: collision with root package name */
        private int f2372l;

        /* renamed from: m  reason: collision with root package name */
        private float f2373m;
        private float n;
        private int[] p;
        private int q;
        private String r;
        private String s;
        private String t;
        private String v;
        private String w;
        private String x;
        private int b = 640;

        /* renamed from: c  reason: collision with root package name */
        private int f2363c = 320;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2364d = true;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2365e = false;

        /* renamed from: f  reason: collision with root package name */
        private int f2366f = 1;

        /* renamed from: h  reason: collision with root package name */
        private String f2368h = "defaultUser";

        /* renamed from: i  reason: collision with root package name */
        private int f2369i = 2;
        private boolean o = true;
        private TTAdLoadType u = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.a = this.a;
            adSlot.f2355f = this.f2366f;
            adSlot.f2356g = this.f2364d;
            adSlot.f2357h = this.f2365e;
            adSlot.b = this.b;
            adSlot.f2352c = this.f2363c;
            float f2 = this.f2373m;
            if (f2 <= 0.0f) {
                adSlot.f2353d = this.b;
                adSlot.f2354e = this.f2363c;
            } else {
                adSlot.f2353d = f2;
                adSlot.f2354e = this.n;
            }
            adSlot.f2358i = this.f2367g;
            adSlot.f2359j = this.f2368h;
            adSlot.f2360k = this.f2369i;
            adSlot.f2362m = this.f2370j;
            adSlot.o = this.o;
            adSlot.p = this.p;
            adSlot.r = this.q;
            adSlot.s = this.r;
            adSlot.q = this.f2371k;
            adSlot.u = this.v;
            adSlot.v = this.w;
            adSlot.w = this.x;
            adSlot.f2361l = this.f2372l;
            adSlot.t = this.s;
            adSlot.x = this.t;
            adSlot.y = this.u;
            return adSlot;
        }

        public Builder setAdCount(int i2) {
            if (i2 <= 0) {
                i2 = 1;
                a.c("TT_AD_SDK", "setAdCount: adCount must greater than 0 ");
            }
            if (i2 > 20) {
                a.c("TT_AD_SDK", "setAdCount: adCount must less than or equal to 20 ");
                i2 = 20;
            }
            this.f2366f = i2;
            return this;
        }

        public Builder setAdId(String str) {
            this.v = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.u = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i2) {
            this.f2372l = i2;
            return this;
        }

        public Builder setAdloadSeq(int i2) {
            this.q = i2;
            return this;
        }

        public Builder setCodeId(String str) {
            this.a = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.w = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f2, float f3) {
            this.f2373m = f2;
            this.n = f3;
            return this;
        }

        public Builder setExt(String str) {
            this.x = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.p = iArr;
            return this;
        }

        public Builder setExtraParam(String str) {
            this.f2371k = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i2, int i3) {
            this.b = i2;
            this.f2363c = i3;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.o = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.f2367g = str;
            return this;
        }

        public Builder setNativeAdType(int i2) {
            this.f2370j = i2;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.f2369i = i2;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.r = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.f2364d = z;
            return this;
        }

        public Builder setUserData(String str) {
            this.t = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.f2368h = str;
            return this;
        }

        public Builder supportRenderControl() {
            this.f2365e = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.s = str;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdCount() {
        return this.f2355f;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getAdId() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public TTAdLoadType getAdLoadType() {
        return this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdType() {
        return this.f2361l;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdloadSeq() {
        return this.r;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getBidAdm() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCodeId() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCreativeId() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getDurationSlotType() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedHeight() {
        return this.f2354e;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedWidth() {
        return this.f2353d;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExt() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int[] getExternalABVid() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExtraSmartLookParam() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedHeight() {
        return this.f2352c;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedWidth() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getMediaExtra() {
        return this.f2358i;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getNativeAdType() {
        return this.f2362m;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getOrientation() {
        return this.f2360k;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getPrimeRit() {
        String str = this.s;
        return str == null ? "" : str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserData() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserID() {
        return this.f2359j;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isAutoPlay() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportDeepLink() {
        return this.f2356g;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportRenderConrol() {
        return this.f2357h;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setAdCount(int i2) {
        this.f2355f = i2;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.y = tTAdLoadType;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setDurationSlotType(int i2) {
        this.n = i2;
    }

    public void setExternalABVid(int... iArr) {
        this.p = iArr;
    }

    public void setGroupLoadMore(int i2) {
        this.f2358i = a(this.f2358i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setNativeAdType(int i2) {
        this.f2362m = i2;
    }

    public void setUserData(String str) {
        this.x = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.a);
            jSONObject.put("mIsAutoPlay", this.o);
            jSONObject.put("mImgAcceptedWidth", this.b);
            jSONObject.put("mImgAcceptedHeight", this.f2352c);
            jSONObject.put("mExpressViewAcceptedWidth", this.f2353d);
            jSONObject.put("mExpressViewAcceptedHeight", this.f2354e);
            jSONObject.put("mAdCount", this.f2355f);
            jSONObject.put("mSupportDeepLink", this.f2356g);
            jSONObject.put("mSupportRenderControl", this.f2357h);
            jSONObject.put("mMediaExtra", this.f2358i);
            jSONObject.put("mUserID", this.f2359j);
            jSONObject.put("mOrientation", this.f2360k);
            jSONObject.put("mNativeAdType", this.f2362m);
            jSONObject.put("mAdloadSeq", this.r);
            jSONObject.put("mPrimeRit", this.s);
            jSONObject.put("mExtraSmartLookParam", this.q);
            jSONObject.put("mAdId", this.u);
            jSONObject.put("mCreativeId", this.v);
            jSONObject.put("mExt", this.w);
            jSONObject.put("mBidAdm", this.t);
            jSONObject.put("mUserData", this.x);
            jSONObject.put("mAdLoadType", this.y);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.a + "', mImgAcceptedWidth=" + this.b + ", mImgAcceptedHeight=" + this.f2352c + ", mExpressViewAcceptedWidth=" + this.f2353d + ", mExpressViewAcceptedHeight=" + this.f2354e + ", mAdCount=" + this.f2355f + ", mSupportDeepLink=" + this.f2356g + ", mSupportRenderControl=" + this.f2357h + ", mMediaExtra='" + this.f2358i + "', mUserID='" + this.f2359j + "', mOrientation=" + this.f2360k + ", mNativeAdType=" + this.f2362m + ", mIsAutoPlay=" + this.o + ", mPrimeRit" + this.s + ", mAdloadSeq" + this.r + ", mAdId" + this.u + ", mCreativeId" + this.v + ", mExt" + this.w + ", mUserData" + this.x + ", mAdLoadType" + this.y + '}';
    }

    private AdSlot() {
        this.f2360k = 2;
        this.o = true;
    }

    private String a(String str, int i2) {
        JSONObject jSONObject;
        if (i2 < 1) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_tt_group_load_more", i2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return str;
        }
    }
}
