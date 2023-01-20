package com.qq.e.ads.nativ;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NativeUnifiedADAppInfoImpl implements NativeUnifiedADAppMiitInfo {
    private final String a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5041c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5042d;

    /* renamed from: e  reason: collision with root package name */
    private final String f5043e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5044f;

    /* loaded from: classes3.dex */
    public interface Keys {
        public static final String APP_NAME = "app_name";
        public static final String AUTHOR_NAME = "author_name";
        public static final String PACKAGE_SIZE = "package_size";
        public static final String PERMISSION_URL = "permission_url";
        public static final String PRIVACY_AGREEMENT = "privacy_agreement";
        public static final String VERSION_NAME = "version_name";
    }

    public NativeUnifiedADAppInfoImpl(JSONObject jSONObject) {
        this.a = jSONObject.optString("app_name");
        this.b = jSONObject.optString(Keys.AUTHOR_NAME);
        this.f5041c = jSONObject.optLong(Keys.PACKAGE_SIZE);
        this.f5042d = jSONObject.optString(Keys.PERMISSION_URL);
        this.f5043e = jSONObject.optString(Keys.PRIVACY_AGREEMENT);
        this.f5044f = jSONObject.optString(Keys.VERSION_NAME);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAppName() {
        return this.a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAuthorName() {
        return this.b;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public long getPackageSizeBytes() {
        return this.f5041c;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPermissionsUrl() {
        return this.f5042d;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPrivacyAgreement() {
        return this.f5043e;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getVersionName() {
        return this.f5044f;
    }
}
