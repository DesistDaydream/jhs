package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ci {
    private static final Map<String, Long> a = new HashMap();

    private static void a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, Long> map = a;
        ArrayList<String> arrayList = new ArrayList(map.size());
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (elapsedRealtime - entry.getValue().longValue() > com.heytap.mcssdk.constant.a.f3314d) {
                arrayList.add(entry.getKey());
            }
        }
        for (String str : arrayList) {
            a.remove(str);
        }
    }

    public static boolean a(byte[] bArr, String str) {
        boolean z = false;
        if (bArr != null && bArr.length > 0 && !TextUtils.isEmpty(str)) {
            String a2 = com.xiaomi.push.ar.a(bArr);
            if (!TextUtils.isEmpty(a2)) {
                Map<String, Long> map = a;
                synchronized (map) {
                    if (map.get(a2 + str) != null) {
                        z = true;
                    } else {
                        map.put(a2 + str, Long.valueOf(SystemClock.elapsedRealtime()));
                    }
                    a();
                }
            }
        }
        return z;
    }
}
