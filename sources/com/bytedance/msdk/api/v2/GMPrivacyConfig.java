package com.bytedance.msdk.api.v2;

import android.location.Location;
import com.bytedance.msdk.api.v2.GMAdConstant;
import java.util.List;

/* loaded from: classes.dex */
public class GMPrivacyConfig {
    public boolean appList() {
        return true;
    }

    public GMAdConstant.ADULT_STATE getAgeGroup() {
        return GMAdConstant.ADULT_STATE.AGE_ADULT;
    }

    public String getAndroidId() {
        return null;
    }

    public List<String> getAppList() {
        return null;
    }

    public String getDevImei() {
        return null;
    }

    public List<String> getDevImeis() {
        return null;
    }

    public String getDevOaid() {
        return null;
    }

    public Location getLocation() {
        return null;
    }

    public String getMacAddress() {
        return "";
    }

    public GMLocation getTTLocation() {
        return null;
    }

    @Deprecated
    public boolean isAdult() {
        return true;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUseMacAddress() {
        return true;
    }

    public boolean isCanUseOaid() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isCanUseWifiState() {
        return true;
    }

    public boolean isCanUseWriteExternal() {
        return true;
    }

    public boolean isLimitPersonalAds() {
        return false;
    }

    public boolean isProgrammaticRecommend() {
        return true;
    }
}
