package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

/* loaded from: classes2.dex */
public class m extends Thread {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public m(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean b;
        boolean d2;
        String c2;
        if (p.b()) {
            b = n.b(this.a);
            if (b) {
                return;
            }
            String a = o.a(this.a);
            if (!TextUtils.isEmpty(a)) {
                d2 = n.d(this.a, a, this.b);
                if (!d2) {
                    HMSLog.d("ReportAaidToken", "This time need not report.");
                    return;
                }
                String string = AGConnectServicesConfig.fromContext(this.a).getString("region");
                if (TextUtils.isEmpty(string)) {
                    HMSLog.i("ReportAaidToken", "The data storage region is empty.");
                    return;
                }
                String a2 = e.a(this.a, "com.huawei.hms.opendevicesdk", "ROOT", null, string);
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                c2 = n.c(this.a, a, this.b);
                Context context = this.a;
                n.b(this.a, d.a(context, a2 + "/rest/appdata/v1/aaid/report", c2, (Map<String, String>) null), a, this.b);
                return;
            }
            HMSLog.w("ReportAaidToken", "AAID is empty.");
            return;
        }
        HMSLog.d("ReportAaidToken", "Not HW Phone.");
    }
}
