package com.bytedance.msdk.api.v2;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.v2.GMGdtOption;
import com.bytedance.msdk.api.v2.GMPangleOption;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GMAdConfig {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1994c;

    /* renamed from: d  reason: collision with root package name */
    private String f1995d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1996e;

    /* renamed from: f  reason: collision with root package name */
    private GMPangleOption f1997f;

    /* renamed from: g  reason: collision with root package name */
    private GMGdtOption f1998g;

    /* renamed from: h  reason: collision with root package name */
    private GMConfigUserInfoForSegment f1999h;

    /* renamed from: i  reason: collision with root package name */
    private GMPrivacyConfig f2000i;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, Object> f2001j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2002k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2003l;

    /* renamed from: m  reason: collision with root package name */
    private JSONObject f2004m;
    private IGMLiveTokenInjectionAuth n;
    private Map<String, Object> o;

    /* loaded from: classes.dex */
    public static class Builder {
        private String a;
        private String b;

        /* renamed from: f  reason: collision with root package name */
        private GMPangleOption f2008f;

        /* renamed from: g  reason: collision with root package name */
        private GMGdtOption f2009g;

        /* renamed from: h  reason: collision with root package name */
        private GMConfigUserInfoForSegment f2010h;

        /* renamed from: i  reason: collision with root package name */
        private GMPrivacyConfig f2011i;

        /* renamed from: j  reason: collision with root package name */
        private Map<String, Object> f2012j;

        /* renamed from: m  reason: collision with root package name */
        private JSONObject f2015m;
        private IGMLiveTokenInjectionAuth n;
        private Map<String, Object> o;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2005c = false;

        /* renamed from: d  reason: collision with root package name */
        private String f2006d = "";

        /* renamed from: e  reason: collision with root package name */
        private boolean f2007e = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f2013k = false;

        /* renamed from: l  reason: collision with root package name */
        private boolean f2014l = false;

        public GMAdConfig build() {
            return new GMAdConfig(this);
        }

        public Builder injectionAuth(IGMLiveTokenInjectionAuth iGMLiveTokenInjectionAuth) {
            this.n = iGMLiveTokenInjectionAuth;
            return this;
        }

        public Builder setAppId(String str) {
            this.a = str;
            return this;
        }

        public Builder setAppName(String str) {
            this.b = str;
            return this;
        }

        public Builder setConfigUserInfoForSegment(@NonNull GMConfigUserInfoForSegment gMConfigUserInfoForSegment) {
            this.f2010h = gMConfigUserInfoForSegment;
            return this;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.f2015m = jSONObject;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.f2005c = z;
            return this;
        }

        public Builder setGdtOption(@NonNull GMGdtOption gMGdtOption) {
            this.f2009g = gMGdtOption;
            return this;
        }

        public Builder setGroMoreExtra(Map<String, Object> map) {
            this.o = map;
            return this;
        }

        public Builder setHttps(boolean z) {
            this.f2013k = z;
            return this;
        }

        public Builder setIsOpenPangleCustom(boolean z) {
            this.f2014l = z;
            return this;
        }

        public Builder setLocalExtra(Map<String, Object> map) {
            if (map != null && !map.isEmpty()) {
                HashMap hashMap = new HashMap();
                this.f2012j = hashMap;
                hashMap.putAll(map);
            }
            return this;
        }

        public Builder setOpenAdnTest(boolean z) {
            this.f2007e = z;
            return this;
        }

        public Builder setPangleOption(@NonNull GMPangleOption gMPangleOption) {
            this.f2008f = gMPangleOption;
            return this;
        }

        public Builder setPrivacyConfig(GMPrivacyConfig gMPrivacyConfig) {
            this.f2011i = gMPrivacyConfig;
            return this;
        }

        public Builder setPublisherDid(@NonNull String str) {
            this.f2006d = str;
            return this;
        }
    }

    private GMAdConfig(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.f1994c = builder.f2005c;
        this.f1995d = builder.f2006d;
        this.f1996e = builder.f2007e;
        this.f1997f = builder.f2008f != null ? builder.f2008f : new GMPangleOption.Builder().build();
        this.f1998g = builder.f2009g != null ? builder.f2009g : new GMGdtOption.Builder().build();
        this.f1999h = builder.f2010h != null ? builder.f2010h : new GMConfigUserInfoForSegment();
        this.f2000i = builder.f2011i;
        this.f2001j = builder.f2012j;
        this.f2002k = builder.f2013k;
        this.f2003l = builder.f2014l;
        this.f2004m = builder.f2015m;
        this.n = builder.n;
        this.o = builder.o;
    }

    public String getAppId() {
        return this.a;
    }

    public String getAppName() {
        return this.b;
    }

    public JSONObject getCutstomLocalConfig() {
        return this.f2004m;
    }

    @NonNull
    public GMConfigUserInfoForSegment getGMConfigUserInfoForSegment() {
        return this.f1999h;
    }

    @NonNull
    public GMGdtOption getGMGdtOption() {
        return this.f1998g;
    }

    @NonNull
    public GMPangleOption getGMPangleOption() {
        return this.f1997f;
    }

    public IGMLiveTokenInjectionAuth getGmLiveTokenInjectionAuth() {
        return this.n;
    }

    public Map<String, Object> getGromoreExtra() {
        return this.o;
    }

    public Map<String, Object> getLocalExtra() {
        return this.f2001j;
    }

    public GMPrivacyConfig getPrivacyConfig() {
        return this.f2000i;
    }

    public String getPublisherDid() {
        return this.f1995d;
    }

    public boolean isDebug() {
        return this.f1994c;
    }

    public boolean isHttps() {
        return this.f2002k;
    }

    public boolean isOpenAdnTest() {
        return this.f1996e;
    }

    public boolean isOpenPangleCustom() {
        return this.f2003l;
    }
}
