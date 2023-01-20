package com.bytedance.pangle.util;

import android.text.TextUtils;
import com.apm.applog.AppLog;

/* loaded from: classes.dex */
public final class d {
    public static synchronized String a() {
        synchronized (d.class) {
            AppLog appLog = AppLog.getInstance("334386");
            if (appLog != null) {
                String did = appLog.getDid();
                if (!TextUtils.isEmpty(did)) {
                    return did;
                }
            }
            return m.a().a.getString("zeus_did", "0");
        }
    }
}
