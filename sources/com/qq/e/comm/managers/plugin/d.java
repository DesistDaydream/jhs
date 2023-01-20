package com.qq.e.comm.managers.plugin;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.umeng.analytics.pro.am;

/* loaded from: classes3.dex */
public class d {
    private static final String[] a = {"0", "1", "2", "3", PushConstants.PUSH_TYPE_WITHDRAW_NOTIFICATION, "5", "6", "7", "8", "9", am.av, "b", "c", e.j.a.b.c.f.f10128d, com.huawei.hms.push.e.a, "f"};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 : bArr) {
            if (i2 < 0) {
                i2 += 256;
            }
            StringBuilder sb = new StringBuilder();
            String[] strArr = a;
            sb.append(strArr[i2 / 16]);
            sb.append(strArr[i2 % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }
}
