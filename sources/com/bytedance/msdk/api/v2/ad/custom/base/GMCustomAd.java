package com.bytedance.msdk.api.v2.ad.custom.base;

import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomTTBaseAd;
import java.util.Map;

/* loaded from: classes.dex */
public class GMCustomAd {
    public GMCustomTTBaseAd a = new GMCustomTTBaseAd();

    public ITTAdatperCallback getTTAdapterCallback() {
        return this.a.getTTAdapterCallback();
    }

    public GMCustomTTBaseAd getTTBaseAd() {
        return this.a;
    }

    public void putExtraMsg(Map<String, Object> map) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd != null) {
            gMCustomTTBaseAd.putExtraMsg(map);
        }
    }

    public void setAdType(int i2) {
        this.a.setAdType(i2);
    }

    public void setCpm(double d2) {
        this.a.setCpm(d2);
    }

    public void setGMCustomBaseAdapter(GMCustomBaseAdapter gMCustomBaseAdapter) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd != null) {
            gMCustomTTBaseAd.setGMCustomBaseAdapter(gMCustomBaseAdapter);
        }
    }

    public void setMediaExtraInfo(Map<String, Object> map) {
        GMCustomTTBaseAd gMCustomTTBaseAd;
        if (map == null || (gMCustomTTBaseAd = this.a) == null) {
            return;
        }
        gMCustomTTBaseAd.setMediaExtraInfo(map);
    }
}
