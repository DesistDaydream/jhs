package com.tencent.android.tpush.encrypt;

import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;

/* loaded from: classes3.dex */
public class Rijndael {
    public static String decrypt(String str) {
        if (i.b(str)) {
            return "";
        }
        String oiSymmetryDecrypt2 = TpnsSecurity.oiSymmetryDecrypt2(str);
        for (int i2 = 0; i2 < 3; i2++) {
            if (!"failed".equals(oiSymmetryDecrypt2)) {
                return oiSymmetryDecrypt2;
            }
            oiSymmetryDecrypt2 = TpnsSecurity.oiSymmetryDecrypt2(str);
        }
        return "";
    }

    public static String encrypt(String str) {
        if (i.b(str)) {
            return "";
        }
        String oiSymmetryEncrypt2 = TpnsSecurity.oiSymmetryEncrypt2(str);
        for (int i2 = 0; i2 < 3; i2++) {
            if (!"failed".equals(oiSymmetryEncrypt2)) {
                return oiSymmetryEncrypt2;
            }
            oiSymmetryEncrypt2 = TpnsSecurity.oiSymmetryEncrypt2(str);
        }
        return "";
    }
}
