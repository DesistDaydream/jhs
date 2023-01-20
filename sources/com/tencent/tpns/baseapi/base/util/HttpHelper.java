package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import android.util.Base64;
import com.tencent.tpns.baseapi.core.c.b;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import com.tencent.tpns.baseapi.core.net.a;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class HttpHelper {
    private static String a(byte[] bArr, String str) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(str.getBytes("UTF-8"), "HmacSHA256"));
            return Base64.encodeToString(b.a(mac.doFinal(bArr)).getBytes(), 2);
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static byte[] byteMerger(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null) {
            return bArr;
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static Map<String, String> getSignAuthHeader(String str, String str2, byte[] bArr) {
        try {
            if (!Util.isNullOrEmptyString(str2) && !Util.isNullOrEmptyString(str)) {
                HashMap hashMap = new HashMap();
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                hashMap.put("Sign", a(byteMerger((valueOf + str).getBytes("UTF-8"), bArr), str2));
                hashMap.put("TimeStamp", valueOf);
                hashMap.put("AccessId", "" + str);
                return hashMap;
            }
            Logger.d("HttpHelper", "accessId or accessKey was null");
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String sendHttpRequest(Context context, String str, String str2, String str3, HttpRequestCallback httpRequestCallback, boolean z) {
        return a.a(context).a(str, str2, str3, httpRequestCallback, z);
    }
}
