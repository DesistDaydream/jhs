package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import java.util.Map;

/* loaded from: classes.dex */
public class GMAdSlotDraw extends GMAdSlotBase {

    /* renamed from: l  reason: collision with root package name */
    private int f2127l;

    /* renamed from: m  reason: collision with root package name */
    private int f2128m;
    private int n;

    /* loaded from: classes.dex */
    public static class Builder extends GMAdSlotBase.Builder {

        /* renamed from: k  reason: collision with root package name */
        private int f2129k = 640;

        /* renamed from: l  reason: collision with root package name */
        private int f2130l = 320;

        /* renamed from: m  reason: collision with root package name */
        private int f2131m = 1;

        public GMAdSlotDraw build() {
            return new GMAdSlotDraw(this);
        }

        public Builder setAdCount(int i2) {
            int i3 = 1;
            if (i2 >= 1) {
                i3 = 3;
                if (i2 <= 3) {
                    this.f2131m = i2;
                    return this;
                }
            }
            this.f2131m = i3;
            return this;
        }

        public Builder setBidNotify(boolean z) {
            this.f2125i = z;
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
            this.f2129k = i2;
            this.f2130l = i3;
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
    }

    private GMAdSlotDraw(Builder builder) {
        super(builder);
        this.f2127l = builder.f2129k;
        this.f2128m = builder.f2130l;
        this.n = builder.f2131m;
    }

    public int getAdCount() {
        return this.n;
    }

    public int getHeight() {
        return this.f2128m;
    }

    public int getWidth() {
        return this.f2127l;
    }
}
