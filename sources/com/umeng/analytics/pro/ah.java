package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import org.repackage.com.heytap.openid.sdk.OpenIDSDK;

/* loaded from: classes3.dex */
public class ah implements z {
    private boolean a = false;

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        try {
            if (!this.a) {
                OpenIDSDK.a(context);
                this.a = true;
            }
            if (!OpenIDSDK.a()) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
                return null;
            }
            return OpenIDSDK.c(context);
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
