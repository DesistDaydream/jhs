package com.tencent.android.tpush.service.channel.security;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.Md5;

/* loaded from: classes3.dex */
public class TpnsSecurity {
    private static final String DEVICE_ID_KEY_NAME = "deviceId_v1";
    private static final String DEVICE_ID_PREFIX = "deviceId_";
    private static final String DEVICE_ID_VERSION = "v1";
    private static final String SETTINGS_DEVICE_ID_KEY_NAME = ".com.tencent.tpush.cache.deviceId_v1";
    private static final String SETTINGS_DEVICE_ID_PREFIX = ".com.tencent.tpush.cache";
    private static final String SHAREPREFERENCE_FILE_NAME = "device_id.vip";
    private static final String TAG = "TpnsSecurity";
    private static String sApkSignature = "";
    public static e tea;

    public static String generateLocalSocketServieName(Context context) {
        if (context != null) {
            try {
                return Security.generateLocalSocketServieNameNative(context);
            } catch (Throwable th) {
                TLogger.e(TAG, "generateLocalSocketServieName 未知错误", th);
            }
        }
        throw new SecurityException("generate local socket server name error");
    }

    public static String getBusinessDeviceId(Context context) {
        if (context != null) {
            String settingsLocalDeviceId = getSettingsLocalDeviceId(context);
            if (settingsLocalDeviceId != null) {
                return settingsLocalDeviceId;
            }
            String preferenceLocalDeviceId = getPreferenceLocalDeviceId(context);
            if (preferenceLocalDeviceId != null) {
                setSettingsLocalDeviceId(context, preferenceLocalDeviceId);
                return preferenceLocalDeviceId;
            }
            String businessDeviceIdNative = Security.getBusinessDeviceIdNative(context);
            setPreferenceLocalDeviceId(context, businessDeviceIdNative);
            setSettingsLocalDeviceId(context, businessDeviceIdNative);
            return businessDeviceIdNative;
        }
        throw new SecurityException("get business device id error cause context is null");
    }

    public static String getEncryptAPKSignature(Context context) {
        if (!TextUtils.isEmpty(sApkSignature)) {
            TLogger.d(TAG, "apkSignature already cached ");
            return sApkSignature;
        } else if (context != null) {
            String encryptAPKSignatureNative = Security.getEncryptAPKSignatureNative(context);
            sApkSignature = encryptAPKSignatureNative;
            return encryptAPKSignatureNative;
        } else {
            throw new SecurityException("get encrypt apk signature error");
        }
    }

    private static String getPreferenceLocalDeviceId(Context context) {
        String string;
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREPREFERENCE_FILE_NAME, 0);
        if (!sharedPreferences.contains(Md5.md5(DEVICE_ID_KEY_NAME)) || (string = sharedPreferences.getString(Md5.md5(DEVICE_ID_KEY_NAME), null)) == null || string.trim().equals("")) {
            return null;
        }
        String decrypt = Rijndael.decrypt(string);
        if (i.b(decrypt)) {
            return null;
        }
        return decrypt;
    }

    private static String getSettingsLocalDeviceId(Context context) {
        String a = com.tencent.android.tpush.service.util.d.a(context, SETTINGS_DEVICE_ID_KEY_NAME);
        if (a == null) {
            return null;
        }
        String decrypt = Rijndael.decrypt(a);
        if (i.b(decrypt)) {
            return null;
        }
        return decrypt;
    }

    public static e getTEA() {
        if (tea == null) {
            tea = new e("0123456789abcdef".getBytes());
        }
        return tea;
    }

    public static String oiSymmetryDecrypt2(String str) {
        "".getBytes();
        if (str != null) {
            try {
                if (str.length() > 0) {
                    byte[] a = b.a(str);
                    if (a != null && a.length > 0) {
                        byte[] oiSymmetryDecrypt2Byte = Security.oiSymmetryDecrypt2Byte(a);
                        if (oiSymmetryDecrypt2Byte != null && oiSymmetryDecrypt2Byte.length > 0) {
                            return new String(oiSymmetryDecrypt2Byte);
                        }
                        TLogger.e(TAG, ">> oiSymmetryDecrypt2 解密失败，返回空字符串");
                        return "failed";
                    }
                    TLogger.e(TAG, ">> oiSymmetryDecrypt2 解码失败，返回空字符串");
                    return "failed";
                }
            } catch (Throwable th) {
                TLogger.e(TAG, ">> oiSymmetryEncrypt2 未知错误", th);
                return "failed";
            }
        }
        TLogger.e(TAG, ">> oiSymmetryDecrypt2 解密内容输入为空");
        return "";
    }

    public static String oiSymmetryEncrypt2(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    byte[] oiSymmetryEncrypt2Byte = Security.oiSymmetryEncrypt2Byte(str);
                    if (oiSymmetryEncrypt2Byte == null) {
                        TLogger.e(TAG, ">> oiSymmetryEncrypt2 加密失败，返回空字符串 inBuff:" + str);
                        return "failed";
                    }
                    String a = c.a(oiSymmetryEncrypt2Byte);
                    if (a == null) {
                        TLogger.e(TAG, ">> oiSymmetryEncrypt2 Base64编码失败，返回空字符串");
                        return "failed";
                    }
                    return a;
                }
            } catch (Throwable th) {
                TLogger.e(TAG, ">> oiSymmetryEncrypt2 未知错误", th);
                return "failed";
            }
        }
        TLogger.e(TAG, ">> oiSymmetryEncrypt2 加密内容输入为空");
        return "";
    }

    private static void setPreferenceLocalDeviceId(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SHAREPREFERENCE_FILE_NAME, 0).edit();
        edit.putString(Md5.md5(DEVICE_ID_KEY_NAME), Rijndael.encrypt(str));
        edit.commit();
    }

    private static void setSettingsLocalDeviceId(Context context, String str) {
        com.tencent.android.tpush.service.util.d.a(context, SETTINGS_DEVICE_ID_KEY_NAME, Rijndael.encrypt(str));
    }
}
