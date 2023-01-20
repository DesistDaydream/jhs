package com.tencent.qcloud.tuicore.util;

import com.huawei.hms.push.e;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.cb;
import e.j.a.b.c.f;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public class MD5Utils {
    private static final String[] hexDigits = {"0", "1", "2", "3", PushConstants.PUSH_TYPE_WITHDRAW_NOTIFICATION, "5", "6", "7", "8", "9", am.av, "b", "c", f.f10128d, e.a, "f"};
    private static MessageDigest messageDigest;

    static {
        messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
    }

    private static String byteArrayToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(byteToHexString(b));
        }
        return stringBuffer.toString();
    }

    public static String byteToHex(byte b) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = hexDigits;
        sb.append(strArr[(b & 240) >> 4]);
        sb.append("");
        sb.append(strArr[b & cb.f7124m]);
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String byteToHexString(byte r3) {
        /*
            if (r3 >= 0) goto L4
            int r3 = r3 + 256
        L4:
            int r0 = r3 / 16
            int r3 = r3 % 16
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String[] r2 = com.tencent.qcloud.tuicore.util.MD5Utils.hexDigits
            r0 = r2[r0]
            r1.append(r0)
            r3 = r2[r3]
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuicore.util.MD5Utils.byteToHexString(byte):java.lang.String");
    }

    public static String bytesToHex(byte[] bArr) {
        return bytesToHex(bArr, 0, bArr.length);
    }

    public static boolean checkFileMD5(File file, String str) {
        return getFileMD5String(file).equalsIgnoreCase(str);
    }

    public static boolean checkPassword(String str, String str2) {
        return getMD5String(str).equalsIgnoreCase(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileMD5String(java.io.File r9) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L46
            r1.<init>(r9)     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L46
            java.nio.channels.FileChannel r0 = r1.getChannel()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3e
            java.nio.channels.FileChannel$MapMode r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3e
            r4 = 0
            long r6 = r9.length()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3e
            r2 = r0
            java.nio.MappedByteBuffer r9 = r2.map(r3, r4, r6)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3e
            java.security.MessageDigest r2 = com.tencent.qcloud.tuicore.util.MD5Utils.messageDigest     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3e
            r2.update(r9)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3e
            java.security.MessageDigest r9 = com.tencent.qcloud.tuicore.util.MD5Utils.messageDigest     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3e
            byte[] r9 = r9.digest()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3e
            java.lang.String r9 = bytesToHex(r9)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3e
            r1.close()     // Catch: java.io.IOException -> L2a
            goto L2e
        L2a:
            r1 = move-exception
            r1.printStackTrace()
        L2e:
            if (r0 == 0) goto L61
            r0.close()     // Catch: java.io.IOException -> L34
            goto L61
        L34:
            r0 = move-exception
            r0.printStackTrace()
            goto L61
        L39:
            r9 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L63
        L3e:
            r9 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L48
        L43:
            r9 = move-exception
            r1 = r0
            goto L63
        L46:
            r9 = move-exception
            r1 = r0
        L48:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L62
            if (r0 == 0) goto L55
            r0.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r9 = move-exception
            r9.printStackTrace()
        L55:
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.io.IOException -> L5b
            goto L5f
        L5b:
            r9 = move-exception
            r9.printStackTrace()
        L5f:
            java.lang.String r9 = ""
        L61:
            return r9
        L62:
            r9 = move-exception
        L63:
            if (r0 == 0) goto L6d
            r0.close()     // Catch: java.io.IOException -> L69
            goto L6d
        L69:
            r0 = move-exception
            r0.printStackTrace()
        L6d:
            if (r1 == 0) goto L77
            r1.close()     // Catch: java.io.IOException -> L73
            goto L77
        L73:
            r0 = move-exception
            r0.printStackTrace()
        L77:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuicore.util.MD5Utils.getFileMD5String(java.io.File):java.lang.String");
    }

    public static String getMD5String(String str) {
        return getMD5String(str.getBytes());
    }

    public static String parseUrlToFileName(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(str.getBytes(StandardCharsets.UTF_8)));
    }

    public static String bytesToHex(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            sb.append(byteToHex(bArr[i4]));
        }
        return sb.toString();
    }

    public static boolean checkFileMD5(String str, String str2) {
        return checkFileMD5(new File(str), str2);
    }

    public static boolean checkPassword(char[] cArr, String str) {
        return checkPassword(new String(cArr), str);
    }

    public static String getMD5String(byte[] bArr) {
        messageDigest.update(bArr);
        return bytesToHex(messageDigest.digest());
    }

    public static String getFileMD5String(String str) {
        return getFileMD5String(new File(str));
    }
}
