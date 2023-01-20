package com.umeng.commonsdk.framework;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface UMLogDataProtocol {

    /* loaded from: classes3.dex */
    public enum UMBusinessType {
        U_APP,
        U_INTERNAL,
        U_ZeroEnv,
        U_Silent
    }

    void removeCacheData(Object obj);

    JSONObject setupReportData(long j2);

    void workEvent(Object obj, int i2);
}
