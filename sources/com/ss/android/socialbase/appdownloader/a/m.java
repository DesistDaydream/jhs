package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class m extends a {
    public m(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        super(context, aVar, str);
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.endsWith(ContainerUtils.FIELD_DELIMITER) ? stringBuffer2.substring(0, stringBuffer2.length() - 1) : stringBuffer2;
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String c2 = this.b.c("s");
        String a = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("bb"), c2);
        if (!TextUtils.isEmpty(a) && a.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length == 2) {
            String a2 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("bc"), c2);
            if (!TextUtils.isEmpty(a2) && a2.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length == 2) {
                String[] split = a.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String[] split2 = a2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String a3 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("bd"), c2);
                String a4 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("be"), c2);
                String a5 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("bf"), c2);
                HashMap hashMap = new HashMap();
                hashMap.put(split[0], split[1]);
                hashMap.put(split2[0], split2[1]);
                hashMap.put(a3, this.f5421c);
                Intent intent = new Intent();
                intent.setAction(a5);
                intent.setData(Uri.parse(a4 + a(hashMap)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
