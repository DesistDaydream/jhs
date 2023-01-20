package com.bytedance.msdk.api.v2.ad.custom;

import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;

/* loaded from: classes.dex */
public abstract class GMCustomTTAbsAdLoaderAdapter extends TTAbsAdLoaderAdapter {
    public String z;

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        return this.z;
    }
}
