package com.huawei.hms.base.log;

import android.content.Context;
import com.huawei.hms.support.log.HMSExtLogger;

/* loaded from: classes2.dex */
public class d implements b {
    public final HMSExtLogger a;
    public b b;

    public d(HMSExtLogger hMSExtLogger) {
        this.a = hMSExtLogger;
    }

    @Override // com.huawei.hms.base.log.b
    public void a(Context context, String str) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.b
    public void a(b bVar) {
        this.b = bVar;
    }

    @Override // com.huawei.hms.base.log.b
    public void a(String str, int i2, String str2, String str3) {
        HMSExtLogger hMSExtLogger = this.a;
        if (hMSExtLogger != null) {
            if (i2 == 3) {
                hMSExtLogger.d(str2, str3);
            } else if (i2 == 4) {
                hMSExtLogger.i(str2, str3);
            } else if (i2 != 5) {
                hMSExtLogger.e(str2, str3);
            } else {
                hMSExtLogger.w(str2, str3);
            }
        }
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(str, i2, str2, str3);
        }
    }
}
