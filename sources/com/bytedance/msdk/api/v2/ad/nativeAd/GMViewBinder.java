package com.bytedance.msdk.api.v2.ad.nativeAd;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GMViewBinder {
    public final int callToActionId;
    public final int decriptionTextId;
    @NonNull
    public final Map<String, Integer> extras;
    public final int groupImage1Id;
    public final int groupImage2Id;
    public final int groupImage3Id;
    public final int iconImageId;
    public final int layoutId;
    public final int logoLayoutId;
    public final int mainImageId;
    public final int mediaViewId;
    public final int sourceId;
    public final int titleId;

    /* loaded from: classes.dex */
    public static class Builder {
        public int a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f2092c;

        /* renamed from: d  reason: collision with root package name */
        public int f2093d;

        /* renamed from: e  reason: collision with root package name */
        public int f2094e;

        /* renamed from: f  reason: collision with root package name */
        public int f2095f;

        /* renamed from: g  reason: collision with root package name */
        public int f2096g;

        /* renamed from: h  reason: collision with root package name */
        public int f2097h;

        /* renamed from: i  reason: collision with root package name */
        public int f2098i;

        /* renamed from: j  reason: collision with root package name */
        public int f2099j;

        /* renamed from: k  reason: collision with root package name */
        public int f2100k;

        /* renamed from: l  reason: collision with root package name */
        public int f2101l;
        @NonNull

        /* renamed from: m  reason: collision with root package name */
        public Map<String, Integer> f2102m;

        public Builder(int i2) {
            this.f2102m = Collections.emptyMap();
            this.a = i2;
            this.f2102m = new HashMap();
        }

        @NonNull
        public Builder addExtra(String str, int i2) {
            this.f2102m.put(str, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        public Builder addExtras(Map<String, Integer> map) {
            this.f2102m = new HashMap(map);
            return this;
        }

        @NonNull
        public GMViewBinder build() {
            return new GMViewBinder(this);
        }

        @NonNull
        public Builder callToActionId(int i2) {
            this.f2093d = i2;
            return this;
        }

        @NonNull
        public Builder descriptionTextId(int i2) {
            this.f2092c = i2;
            return this;
        }

        @NonNull
        public Builder groupImage1Id(int i2) {
            this.f2099j = i2;
            return this;
        }

        @NonNull
        public Builder groupImage2Id(int i2) {
            this.f2100k = i2;
            return this;
        }

        @NonNull
        public Builder groupImage3Id(int i2) {
            this.f2101l = i2;
            return this;
        }

        @NonNull
        public Builder iconImageId(int i2) {
            this.f2094e = i2;
            return this;
        }

        @NonNull
        public Builder logoLayoutId(int i2) {
            this.f2098i = i2;
            return this;
        }

        @NonNull
        public Builder mainImageId(int i2) {
            this.f2095f = i2;
            return this;
        }

        @NonNull
        public Builder mediaViewIdId(int i2) {
            this.f2096g = i2;
            return this;
        }

        @NonNull
        public Builder sourceId(int i2) {
            this.f2097h = i2;
            return this;
        }

        @NonNull
        public Builder titleId(int i2) {
            this.b = i2;
            return this;
        }
    }

    public GMViewBinder(@NonNull Builder builder) {
        this.layoutId = builder.a;
        this.titleId = builder.b;
        this.decriptionTextId = builder.f2092c;
        this.callToActionId = builder.f2093d;
        this.iconImageId = builder.f2094e;
        this.mainImageId = builder.f2095f;
        this.mediaViewId = builder.f2096g;
        this.sourceId = builder.f2097h;
        this.extras = builder.f2102m;
        this.groupImage1Id = builder.f2099j;
        this.groupImage2Id = builder.f2100k;
        this.groupImage3Id = builder.f2101l;
        this.logoLayoutId = builder.f2098i;
    }
}
