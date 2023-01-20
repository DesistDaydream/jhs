package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.s;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.api.TTVideoOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class GMAdSlotBase {
    private boolean a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2110c;

    /* renamed from: d  reason: collision with root package name */
    public GMAdSlotGDTOption f2111d;

    /* renamed from: e  reason: collision with root package name */
    public GMAdSlotBaiduOption f2112e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, Object> f2113f;

    /* renamed from: g  reason: collision with root package name */
    private String f2114g;

    /* renamed from: h  reason: collision with root package name */
    private int f2115h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2116i;

    /* renamed from: j  reason: collision with root package name */
    private String f2117j;

    /* renamed from: k  reason: collision with root package name */
    private int f2118k;

    /* loaded from: classes.dex */
    public static abstract class Builder {
        public boolean a;
        public float b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2119c;

        /* renamed from: d  reason: collision with root package name */
        public GMAdSlotGDTOption f2120d;

        /* renamed from: e  reason: collision with root package name */
        public GMAdSlotBaiduOption f2121e;

        /* renamed from: g  reason: collision with root package name */
        public String f2123g;

        /* renamed from: i  reason: collision with root package name */
        public boolean f2125i;

        /* renamed from: j  reason: collision with root package name */
        public String f2126j;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, Object> f2122f = new HashMap();

        /* renamed from: h  reason: collision with root package name */
        public int f2124h = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r0 < 0.0f) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GMAdSlotBase(com.bytedance.msdk.api.v2.slot.GMAdSlotBase.Builder r4) {
        /*
            r3 = this;
            r3.<init>()
            boolean r0 = r4.a
            r3.a = r0
            float r0 = r4.b
            r1 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 <= 0) goto L12
        Lf:
            r4.b = r1
            goto L18
        L12:
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L18
            goto Lf
        L18:
            float r0 = r4.b
            r3.b = r0
            boolean r0 = r4.f2119c
            r3.f2110c = r0
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption r0 = r4.f2120d
            if (r0 == 0) goto L25
            goto L2e
        L25:
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption$Builder r0 = new com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption$Builder
            r0.<init>()
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption r0 = r0.build()
        L2e:
            r3.f2111d = r0
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption r0 = r4.f2121e
            if (r0 == 0) goto L35
            goto L3e
        L35:
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption$Builder r0 = new com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption$Builder
            r0.<init>()
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption r0 = r0.build()
        L3e:
            r3.f2112e = r0
            java.util.Map<java.lang.String, java.lang.Object> r0 = r4.f2122f
            r3.f2113f = r0
            java.lang.String r0 = r4.f2123g
            r3.f2114g = r0
            int r0 = r4.f2124h
            r3.f2115h = r0
            boolean r0 = r4.f2125i
            r3.f2116i = r0
            java.lang.String r4 = r4.f2126j
            r3.f2117j = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.api.v2.slot.GMAdSlotBase.<init>(com.bytedance.msdk.api.v2.slot.GMAdSlotBase$Builder):void");
    }

    public TTVideoOption createTTVideoOption(boolean z) {
        TTVideoOption.Builder builder = new TTVideoOption.Builder();
        builder.setMuted(isMuted());
        builder.setAdmobAppVolume(getVolume());
        builder.useSurfaceView(isUseSurfaceView());
        GMAdSlotGDTOption gMAdSlotGDTOption = getGMAdSlotGDTOption();
        if (gMAdSlotGDTOption != null) {
            builder.setGDTExtraOption(gMAdSlotGDTOption.getGDTExtraOption(z));
        }
        GMAdSlotBaiduOption gMAdSlotBaiduOption = getGMAdSlotBaiduOption();
        if (gMAdSlotGDTOption != null) {
            builder.setBaiduExtraOption(gMAdSlotBaiduOption.getBaiduExtra());
        }
        return builder.build();
    }

    @Deprecated
    public int getDownloadType() {
        return this.f2115h;
    }

    public GMAdSlotBaiduOption getGMAdSlotBaiduOption() {
        return this.f2112e;
    }

    public GMAdSlotGDTOption getGMAdSlotGDTOption() {
        return this.f2111d;
    }

    @Deprecated
    public int getNetWorkNum() {
        return this.f2118k;
    }

    @Nullable
    public Map<String, Object> getParams() {
        return this.f2113f;
    }

    public String getScenarioId() {
        return this.f2117j;
    }

    public TTRequestExtraParams getTTRequestExtraParams() {
        TTRequestExtraParams tTRequestExtraParams = new TTRequestExtraParams();
        if (getParams() != null && getParams().size() > 0) {
            tTRequestExtraParams.getExtraObject().putAll(getParams());
        }
        return tTRequestExtraParams;
    }

    public String getTestSlotId() {
        return this.f2114g;
    }

    public float getVolume() {
        return this.b;
    }

    public boolean isBidNotify() {
        return this.f2116i;
    }

    public boolean isMuted() {
        return this.a;
    }

    public boolean isUseSurfaceView() {
        return this.f2110c;
    }

    @Deprecated
    public void setNetWorkNum(String str) {
        this.f2118k = s.a(str);
    }
}
