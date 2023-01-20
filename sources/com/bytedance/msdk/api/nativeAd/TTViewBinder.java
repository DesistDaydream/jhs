package com.bytedance.msdk.api.nativeAd;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class TTViewBinder extends GMViewBinder {

    /* loaded from: classes.dex */
    public static class Builder extends GMViewBinder.Builder {
        public Builder(int i2) {
            super(i2);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder addExtra(String str, int i2) {
            this.f2102m.put(str, Integer.valueOf(i2));
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder addExtras(Map<String, Integer> map) {
            this.f2102m = new HashMap(map);
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public /* bridge */ /* synthetic */ GMViewBinder.Builder addExtras(Map map) {
            return addExtras((Map<String, Integer>) map);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public TTViewBinder build() {
            return new TTViewBinder(this);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder callToActionId(int i2) {
            this.f2093d = i2;
            return this;
        }

        @Deprecated
        public final Builder decriptionTextId(int i2) {
            this.f2092c = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public Builder descriptionTextId(int i2) {
            this.f2092c = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public Builder groupImage1Id(int i2) {
            this.f2099j = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder groupImage2Id(int i2) {
            this.f2100k = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder groupImage3Id(int i2) {
            this.f2101l = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder iconImageId(int i2) {
            this.f2094e = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public Builder logoLayoutId(int i2) {
            this.f2098i = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder mainImageId(int i2) {
            this.f2095f = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder mediaViewIdId(int i2) {
            this.f2096g = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder sourceId(int i2) {
            this.f2097h = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public Builder titleId(int i2) {
            this.b = i2;
            return this;
        }
    }

    private TTViewBinder(@NonNull Builder builder) {
        super(builder);
    }
}
