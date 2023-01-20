package com.bytedance.msdk.api;

import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMPrivacyConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public final class TTAdConfig {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1949c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1950d;

    /* renamed from: e  reason: collision with root package name */
    private String f1951e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1952f;

    /* renamed from: g  reason: collision with root package name */
    private int f1953g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f1954h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1955i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1956j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f1957k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1958l;

    /* renamed from: m  reason: collision with root package name */
    private String f1959m;
    private Map<String, String> n;
    private boolean o;
    private String p;
    private Set<String> q;
    private Map<String, Map<String, String>> r;
    private Map<String, Map<String, String>> s;
    private UserInfoForSegment t;
    private int u;
    private GMPrivacyConfig v;

    /* loaded from: classes.dex */
    public static class Builder {
        @Deprecated
        private String a;
        @Deprecated
        private String b;
        @Deprecated

        /* renamed from: h  reason: collision with root package name */
        private int[] f1965h;
        @Deprecated

        /* renamed from: j  reason: collision with root package name */
        private String[] f1967j;
        @Deprecated

        /* renamed from: k  reason: collision with root package name */
        private String f1968k;
        @Deprecated

        /* renamed from: m  reason: collision with root package name */
        private boolean f1970m;
        @Deprecated
        private String n;
        @Deprecated
        private String p;
        private Set<String> q;
        private Map<String, Map<String, String>> r;
        private Map<String, Map<String, String>> s;
        @Deprecated
        private UserInfoForSegment t;
        private GMPrivacyConfig v;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        private boolean f1960c = false;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        private boolean f1961d = false;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        private int f1962e = 0;
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        private boolean f1963f = true;
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        private boolean f1964g = false;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        private boolean f1966i = false;
        @Deprecated

        /* renamed from: l  reason: collision with root package name */
        private boolean f1969l = true;
        @Deprecated
        private Map<String, String> o = new HashMap();
        @Deprecated
        private int u = 2;

        @Deprecated
        public Builder allowPangleShowNotify(boolean z) {
            this.f1963f = z;
            return this;
        }

        @Deprecated
        public Builder allowPangleShowPageWhenScreenLock(boolean z) {
            this.f1964g = z;
            return this;
        }

        @Deprecated
        public Builder appId(String str) {
            this.a = str;
            return this;
        }

        @Deprecated
        public Builder appName(String str) {
            this.b = str;
            return this;
        }

        @Deprecated
        public TTAdConfig build() {
            return new TTAdConfig(this);
        }

        @Deprecated
        public Builder data(String str) {
            this.n = str;
            return this;
        }

        @Deprecated
        public Builder data(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.o.put(str, str2);
            }
            return this;
        }

        @Deprecated
        public Builder dataMap(Map<String, String> map) {
            if (map != null && map.size() > 0) {
                this.o.putAll(map);
            }
            return this;
        }

        @Deprecated
        public Builder isPanglePaid(boolean z) {
            this.f1961d = z;
            return this;
        }

        @Deprecated
        public Builder needPangleClearTaskReset(String... strArr) {
            this.f1967j = strArr;
            return this;
        }

        @Deprecated
        public Builder openAdnTest(boolean z) {
            this.f1970m = z;
            return this;
        }

        @Deprecated
        public Builder openDebugLog(boolean z) {
            this.f1960c = z;
            return this;
        }

        public Builder setBaiduSdkReadDeviceId(boolean z) {
            this.f1969l = z;
            return this;
        }

        @Deprecated
        public Builder setKeywords(String str) {
            this.p = str;
            return this;
        }

        @Deprecated
        public Builder setPangleDirectDownloadNetworkType(int... iArr) {
            this.f1965h = iArr;
            return this;
        }

        @Deprecated
        public Builder setPangleTitleBarTheme(int i2) {
            this.f1962e = i2;
            return this;
        }

        public Builder setPrivacyConfig(GMPrivacyConfig gMPrivacyConfig) {
            this.v = gMPrivacyConfig;
            return this;
        }

        public Builder setPublisherDid(String str) {
            this.f1968k = str;
            return this;
        }

        @Deprecated
        public Builder setUserInfoForSegment(UserInfoForSegment userInfoForSegment) {
            this.t = userInfoForSegment;
            return this;
        }

        @Deprecated
        public Builder usePangleTextureView(boolean z) {
            this.f1966i = z;
            return this;
        }
    }

    private TTAdConfig(Builder builder) {
        this.f1949c = false;
        this.f1950d = false;
        this.f1951e = null;
        this.f1953g = 0;
        this.f1955i = true;
        this.f1956j = false;
        this.f1958l = false;
        this.o = true;
        this.u = 2;
        this.a = builder.a;
        this.b = builder.b;
        this.f1949c = builder.f1960c;
        this.f1950d = builder.f1961d;
        this.f1951e = builder.f1968k;
        this.f1952f = builder.f1970m;
        this.f1953g = builder.f1962e;
        this.f1954h = builder.f1967j;
        this.f1955i = builder.f1963f;
        this.f1956j = builder.f1964g;
        this.f1957k = builder.f1965h;
        this.f1958l = builder.f1966i;
        this.f1959m = builder.n;
        this.n = builder.o;
        this.p = builder.p;
        this.q = builder.q;
        this.r = builder.r;
        this.s = builder.s;
        this.o = builder.f1969l;
        this.t = builder.t;
        this.u = builder.u;
        this.v = builder.v;
    }

    public boolean allowBaiduSdkReadDeviceId() {
        return this.o;
    }

    public Set<String> getAdapterConfigurationClasses() {
        Set<String> set = this.q;
        if (set != null) {
            return Collections.unmodifiableSet(set);
        }
        return null;
    }

    public String getAppId() {
        return this.a;
    }

    public String getAppName() {
        return this.b;
    }

    public Map<String, String> getExtraData() {
        return this.n;
    }

    public Map<String, Map<String, String>> getMediatedNetworkConfigurations() {
        Map<String, Map<String, String>> map = this.r;
        if (map != null) {
            return Collections.unmodifiableMap(map);
        }
        return null;
    }

    @Deprecated
    public String getPangleData() {
        return this.f1959m;
    }

    public int[] getPangleDirectDownloadNetworkType() {
        return this.f1957k;
    }

    public String getPangleKeywords() {
        return this.p;
    }

    public String[] getPangleNeedClearTaskReset() {
        return this.f1954h;
    }

    public int getPanglePluginUpdateConfig() {
        return this.u;
    }

    public int getPangleTitleBarTheme() {
        return this.f1953g;
    }

    public GMPrivacyConfig getPrivacyConfig() {
        return this.v;
    }

    public String getPublisherDid() {
        return this.f1951e;
    }

    public Map<String, Map<String, String>> getRequestOptions() {
        Map<String, Map<String, String>> map = this.s;
        if (map != null) {
            return Collections.unmodifiableMap(map);
        }
        return null;
    }

    public UserInfoForSegment getUserInfoForSegment() {
        return this.t;
    }

    public boolean isDebug() {
        return this.f1949c;
    }

    public boolean isOpenAdnTest() {
        return this.f1952f;
    }

    public boolean isPangleAllowShowNotify() {
        return this.f1955i;
    }

    public boolean isPangleAllowShowPageWhenScreenLock() {
        return this.f1956j;
    }

    public boolean isPanglePaid() {
        return this.f1950d;
    }

    public boolean isPangleUseTextureView() {
        return this.f1958l;
    }
}
