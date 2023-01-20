package com.bytedance.msdk.api;

import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BaiduRequestParameters {
    public static final int ADS_TYPE_DOWNLOAD = 2;
    public static final int ADS_TYPE_OPENPAGE = 1;
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    public static final int MAX_ASSETS_RESERVED = 15;
    private final String a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f1912c;

    /* renamed from: d  reason: collision with root package name */
    private int f1913d;

    /* renamed from: e  reason: collision with root package name */
    private int f1914e;

    /* renamed from: f  reason: collision with root package name */
    private int f1915f;

    /* loaded from: classes.dex */
    public static class Builder {
        private String a;
        private Map<String, String> b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private boolean f1916c = false;

        /* renamed from: d  reason: collision with root package name */
        private int f1917d = 640;

        /* renamed from: e  reason: collision with root package name */
        private int f1918e = 480;

        /* renamed from: f  reason: collision with root package name */
        private int f1919f = 1;

        public final Builder addExtra(String str, String str2) {
            if (ArticleInfo.PAGE_TITLE.equals(str)) {
                this.b.put(IAdInterListener.AdReqParam.MPT, String.valueOf(1));
            }
            this.b.put(str, str2);
            return this;
        }

        public final BaiduRequestParameters build() {
            return new BaiduRequestParameters(this);
        }

        @Deprecated
        public final Builder confirmDownloading(boolean z) {
            downloadAppConfirmPolicy(z ? 2 : 3);
            return this;
        }

        public final Builder downloadAppConfirmPolicy(int i2) {
            this.f1919f = i2;
            return this;
        }

        public final Builder setHeight(int i2) {
            this.f1918e = i2;
            return this;
        }

        public final Builder setKeywords(String str) {
            this.a = str;
            return this;
        }

        public final Builder setWidth(int i2) {
            this.f1917d = i2;
            return this;
        }
    }

    private BaiduRequestParameters(Builder builder) {
        this.f1913d = 0;
        this.f1914e = 0;
        this.a = builder.a;
        this.f1913d = builder.f1917d;
        this.f1914e = builder.f1918e;
        this.b = builder.f1916c;
        this.f1915f = builder.f1919f;
        setExtras(builder.b);
    }

    public int getAPPConfirmPolicy() {
        return this.f1915f;
    }

    public Map<String, String> getExtras() {
        return this.f1912c;
    }

    public int getHeight() {
        return this.f1914e;
    }

    public final String getKeywords() {
        return this.a;
    }

    public int getWidth() {
        return this.f1913d;
    }

    public boolean isConfirmDownloading() {
        return this.b;
    }

    public void setExtras(Map<String, String> map) {
        this.f1912c = map;
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("mKeywords", this.a);
        hashMap.put("confirmDownloading", Boolean.valueOf(this.b));
        HashMap hashMap2 = new HashMap();
        Map<String, String> map = this.f1912c;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, hashMap2);
        return hashMap;
    }
}
