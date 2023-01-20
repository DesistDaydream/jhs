package com.jihuanshe.model;

import h.k2.v.f0;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class GlobalConfigKt {
    public static final boolean isPoster(@e GlobalConfig globalConfig) {
        return globalConfig != null && f0.g(globalConfig.getAdOffer(), GlobalConfig.AD_TYPE_POSTER);
    }
}
