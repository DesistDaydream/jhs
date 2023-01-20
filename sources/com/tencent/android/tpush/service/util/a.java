package com.tencent.android.tpush.service.util;

import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;

/* loaded from: classes3.dex */
public class a {
    public static String a() {
        String str = null;
        if (com.tencent.android.tpush.service.b.e() != null) {
            try {
                str = TpnsSecurity.getBusinessDeviceId(com.tencent.android.tpush.service.b.e());
            } catch (Throwable th) {
                TLogger.e("DeviceInfo", ">>getFacilityIdentity err", th);
            }
            return (str == null || str.trim().length() == 0) ? "" : str;
        }
        TLogger.e("DeviceInfo", ">>> getFacilityIdentity() > context == null");
        return null;
    }
}
