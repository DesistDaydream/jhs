package com.bytedance.msdk.api.v2.ad.custom.init;

import android.content.Context;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomInitConfig;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class GMCustomAdapterConfiguration {
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private GMCustomInitConfig a;

    static {
        String str = "TTMediationSDK_" + GMCustomAdapterConfiguration.class.getSimpleName();
    }

    public final void callInitSuccess() {
        b.set(true);
    }

    public abstract String getAdapterSdkVersion();

    public String getBiddingToken(Context context, Map<String, Object> map) {
        return null;
    }

    public final String getCustomADNName() {
        return this.a.getADNName();
    }

    public abstract String getNetworkSdkVersion();

    public String getSdkInfo(Context context, Map<String, Object> map) {
        return null;
    }

    public abstract void initializeADN(Context context, GMCustomInitConfig gMCustomInitConfig, Map<String, Object> map);

    public final void initializeInnerADN(Context context, GMCustomInitConfig gMCustomInitConfig, Map<String, Object> map) {
        b.set(false);
        this.a = gMCustomInitConfig;
        initializeADN(context, gMCustomInitConfig, map);
    }

    public final boolean isInit() {
        return b.get();
    }
}
