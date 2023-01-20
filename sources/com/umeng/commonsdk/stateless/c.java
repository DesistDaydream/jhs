package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* loaded from: classes3.dex */
public class c {
    private String a = "10.0.0.172";
    private int b = 80;

    /* renamed from: c  reason: collision with root package name */
    private Context f7453c;

    public c(Context context) {
        this.f7453c = context;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f7453c, "sl_domain_p", "");
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        a.f7440i = DataHelper.assembleStatelessURL(imprintProperty);
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f7453c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f7453c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.f7439h = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.f7442k = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.f7440i = a.f7442k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            a.f7440i = a.f7439h;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00f7, code lost:
        if (r11 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00f9, code lost:
        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
        r11.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0123, code lost:
        if (r11 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0126, code lost:
        return r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [javax.net.ssl.HttpsURLConnection, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(byte[] r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
