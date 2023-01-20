package com.bytedance.msdk.api.v2;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GMPangleOption {
    private boolean a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2027c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2028d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f2029e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2030f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f2031g;

    /* renamed from: h  reason: collision with root package name */
    private String f2032h;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, String> f2033i;

    /* renamed from: j  reason: collision with root package name */
    private String f2034j;

    /* renamed from: k  reason: collision with root package name */
    private int f2035k;

    /* loaded from: classes.dex */
    public static class Builder {
        private boolean a = false;
        private int b = 0;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2036c = true;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2037d = false;

        /* renamed from: e  reason: collision with root package name */
        private int[] f2038e = {4, 3, 5};

        /* renamed from: f  reason: collision with root package name */
        private boolean f2039f = false;

        /* renamed from: g  reason: collision with root package name */
        private String[] f2040g = new String[0];

        /* renamed from: h  reason: collision with root package name */
        private String f2041h = "";

        /* renamed from: i  reason: collision with root package name */
        private final Map<String, String> f2042i = new HashMap();

        /* renamed from: j  reason: collision with root package name */
        private String f2043j = "";

        /* renamed from: k  reason: collision with root package name */
        private int f2044k = 2;

        public GMPangleOption build() {
            return new GMPangleOption(this);
        }

        public Builder setAllowShowNotify(boolean z) {
            this.f2036c = z;
            return this;
        }

        public Builder setAllowShowPageWhenScreenLock(boolean z) {
            this.f2037d = z;
            return this;
        }

        public Builder setData(@NonNull String str) {
            this.f2041h = str;
            return this;
        }

        public Builder setData(@NonNull String str, @NonNull String str2) {
            this.f2042i.put(str, str2);
            return this;
        }

        public Builder setData(@NonNull Map<String, String> map) {
            this.f2042i.putAll(map);
            return this;
        }

        public Builder setDirectDownloadNetworkType(@NonNull int... iArr) {
            this.f2038e = iArr;
            return this;
        }

        public Builder setIsPaid(boolean z) {
            this.a = z;
            return this;
        }

        public Builder setIsUseTextureView(boolean z) {
            this.f2039f = z;
            return this;
        }

        public Builder setKeywords(@NonNull String str) {
            this.f2043j = str;
            return this;
        }

        public Builder setNeedClearTaskReset(@NonNull String... strArr) {
            this.f2040g = strArr;
            return this;
        }

        public Builder setTitleBarTheme(int i2) {
            this.b = i2;
            return this;
        }
    }

    private GMPangleOption(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.f2027c = builder.f2036c;
        this.f2028d = builder.f2037d;
        this.f2029e = builder.f2038e;
        this.f2030f = builder.f2039f;
        this.f2031g = builder.f2040g;
        this.f2032h = builder.f2041h;
        this.f2033i = builder.f2042i;
        this.f2034j = builder.f2043j;
        this.f2035k = builder.f2044k;
    }

    public String getData() {
        return this.f2032h;
    }

    public int[] getDirectDownloadNetworkType() {
        return this.f2029e;
    }

    @NonNull
    public Map<String, String> getExtraData() {
        return this.f2033i;
    }

    public String getKeywords() {
        return this.f2034j;
    }

    public String[] getNeedClearTaskReset() {
        return this.f2031g;
    }

    public int getPluginUpdateConfig() {
        return this.f2035k;
    }

    public int getTitleBarTheme() {
        return this.b;
    }

    public boolean isAllowShowNotify() {
        return this.f2027c;
    }

    public boolean isAllowShowPageWhenScreenLock() {
        return this.f2028d;
    }

    public boolean isIsUseTextureView() {
        return this.f2030f;
    }

    public boolean isPaid() {
        return this.a;
    }
}
