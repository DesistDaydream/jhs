package com.baidu.mobads.sdk.api;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class RequestParameters {
    public static final int ADS_TYPE_DOWNLOAD = 2;
    public static final int ADS_TYPE_OPENPAGE = 1;
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    public static final int MAX_ASSETS_RESERVED = 15;
    public static final String TAG = "RequestParameters";
    private int adsType;
    private boolean confirmDownloading;
    private boolean customSize;
    private int downloadAppConfirmPolicy;
    private Map<String, String> extras;
    private int height;
    private final String mKeywords;
    public String mPlacementId;
    private int width;

    /* loaded from: classes.dex */
    public static class Builder {
        private String keywords;
        private Map<String, String> extras = new HashMap();
        private int adsType = 3;
        private boolean clickConfirm = false;
        private int width = 640;
        private int height = 480;
        private int downloadAppConfirmPolicy = 1;
        private boolean customSize = false;

        public final Builder addExtra(String str, String str2) {
            this.extras.put(str, str2);
            return this;
        }

        public final RequestParameters build() {
            return new RequestParameters(this);
        }

        @Deprecated
        public final Builder confirmDownloading(boolean z) {
            if (z) {
                downloadAppConfirmPolicy(2);
            } else {
                downloadAppConfirmPolicy(3);
            }
            return this;
        }

        public final Builder downloadAppConfirmPolicy(int i2) {
            this.downloadAppConfirmPolicy = i2;
            return this;
        }

        public final Builder setHeight(int i2) {
            this.height = i2;
            this.customSize = true;
            return this;
        }

        public final Builder setWidth(int i2) {
            this.width = i2;
            this.customSize = true;
            return this;
        }
    }

    public int getAPPConfirmPolicy() {
        return this.downloadAppConfirmPolicy;
    }

    public String getAdPlacementId() {
        return this.mPlacementId;
    }

    public int getAdsType() {
        return this.adsType;
    }

    public Map<String, String> getExtras() {
        return this.extras;
    }

    public int getHeight() {
        return this.height;
    }

    public final String getKeywords() {
        return this.mKeywords;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isConfirmDownloading() {
        return this.confirmDownloading;
    }

    public boolean isCustomSize() {
        return this.customSize;
    }

    public void setAdsType(int i2) {
        this.adsType = i2;
    }

    public void setExtras(Map<String, String> map) {
        this.extras = map;
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("mKeywords", this.mKeywords);
        hashMap.put("adsType", Integer.valueOf(this.adsType));
        hashMap.put("confirmDownloading", Boolean.valueOf(this.confirmDownloading));
        HashMap hashMap2 = new HashMap();
        Map<String, String> map = this.extras;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, hashMap2);
        return hashMap;
    }

    private RequestParameters(Builder builder) {
        this.width = 0;
        this.height = 0;
        this.mKeywords = builder.keywords;
        this.adsType = builder.adsType;
        this.width = builder.width;
        this.height = builder.height;
        this.customSize = builder.customSize;
        this.confirmDownloading = builder.clickConfirm;
        this.downloadAppConfirmPolicy = builder.downloadAppConfirmPolicy;
        setExtras(builder.extras);
    }
}
