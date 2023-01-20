package com.tencent.tpns.baseapi.base.security;

import android.content.Context;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.umeng.analytics.pro.cb;
import java.io.File;

/* loaded from: classes3.dex */
public class Security {
    private static final String TAG = "Security";
    private static boolean loadedTpnsSecuritySo = false;
    public static final String tpnsSecurityLibFullName = "libxgVipSecurity.so";
    private static final String tpnsSecurityLibName = "xgVipSecurity";

    static {
        try {
            System.loadLibrary(tpnsSecurityLibName);
            loadedTpnsSecuritySo = true;
        } catch (Throwable th) {
            TBaseLogger.e(TAG, "can not load library,error:", th);
            loadedTpnsSecuritySo = false;
        }
    }

    public static boolean checkTpnsSecurityLibSo(Context context) {
        if (loadedTpnsSecuritySo) {
            return true;
        }
        if (context != null) {
            String str = "";
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getDir("lib", 0).getParentFile().getAbsolutePath());
                String str2 = File.separator;
                sb.append(str2);
                sb.append("lib");
                sb.append(str2);
                sb.append(tpnsSecurityLibFullName);
                str = sb.toString();
                System.load(str);
                loadedTpnsSecuritySo = true;
            } catch (Throwable th) {
                loadedTpnsSecuritySo = false;
                TBaseLogger.e(TAG, "can not load library from " + str + ",error:" + th);
            }
        }
        return loadedTpnsSecuritySo;
    }

    public static byte[] decryptSrvData(byte[] bArr) {
        TBaseLogger.ii(TAG, "---decrypt---");
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    byte[] doDecryptSrvData = doDecryptSrvData(bArr);
                    if (doDecryptSrvData == null) {
                        TBaseLogger.ee(TAG, ">> decryptSrvData: decrypt failed!");
                        return null;
                    }
                    return doDecryptSrvData;
                }
            } catch (Throwable th) {
                TBaseLogger.e(TAG, ">> decryptSrvData: throwable", th);
                return null;
            }
        }
        TBaseLogger.ee(TAG, ">> decryptSrvData: encData is empty");
        return null;
    }

    public static native byte[] doDecryptSrvData(byte[] bArr);

    public static native byte[] doEncryptSrvData(byte[] bArr);

    public static byte[] encryptSrvData(byte[] bArr) {
        TBaseLogger.ii(TAG, "---encrypt---");
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    byte[] doEncryptSrvData = doEncryptSrvData(bArr);
                    if (doEncryptSrvData == null) {
                        TBaseLogger.ee(TAG, ">> encryptSrvData: encrypt failed!");
                        return null;
                    }
                    return doEncryptSrvData;
                }
            } catch (Throwable th) {
                TBaseLogger.e(TAG, ">> encryptSrvData: throwable", th);
                return null;
            }
        }
        TBaseLogger.ee(TAG, ">> encryptSrvData: input text is empty");
        return null;
    }

    public static native String generateLocalSocketServieNameNative(Object obj);

    public static native String getBusinessDeviceIdNative(Object obj);

    public static native String getEncryptAPKSignatureNative(Object obj);

    public static native byte[] oiSymmetryDecrypt2Byte(byte[] bArr);

    public static native byte[] oiSymmetryEncrypt2Byte(String str);

    private static String toCharsString(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i2 = 0; i2 < length; i2++) {
            byte b = bArr[i2];
            int i3 = (b >> 4) & 15;
            int i4 = i2 * 2;
            cArr[i4] = (char) (i3 >= 10 ? (i3 + 97) - 10 : i3 + 48);
            int i5 = b & cb.f7124m;
            cArr[i4 + 1] = (char) (i5 >= 10 ? (i5 + 97) - 10 : i5 + 48);
        }
        return new String(cArr);
    }
}
