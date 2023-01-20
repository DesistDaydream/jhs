package com.qiniu.android.utils;

import com.caverock.androidsvg.SVG;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public final class Etag {
    /* JADX WARN: Removed duplicated region for block: B:32:0x002c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String data(byte[] r2, int r3, int r4) {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L16 java.io.IOException -> L18
            r1.<init>(r2, r3, r4)     // Catch: java.lang.Throwable -> L16 java.io.IOException -> L18
            long r2 = (long) r4
            java.lang.String r2 = stream(r1, r2)     // Catch: java.io.IOException -> L14 java.lang.Throwable -> L28
            r1.close()     // Catch: java.lang.Exception -> Lf
            goto L13
        Lf:
            r3 = move-exception
            r3.printStackTrace()
        L13:
            return r2
        L14:
            r2 = move-exception
            goto L1a
        L16:
            r2 = move-exception
            goto L2a
        L18:
            r2 = move-exception
            r1 = r0
        L1a:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L28
            if (r1 == 0) goto L27
            r1.close()     // Catch: java.lang.Exception -> L23
            goto L27
        L23:
            r2 = move-exception
            r2.printStackTrace()
        L27:
            return r0
        L28:
            r2 = move-exception
            r0 = r1
        L2a:
            if (r0 == 0) goto L34
            r0.close()     // Catch: java.lang.Exception -> L30
            goto L34
        L30:
            r3 = move-exception
            r3.printStackTrace()
        L34:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.utils.Etag.data(byte[], int, int):java.lang.String");
    }

    public static String file(File file) throws IOException {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            String stream = stream(fileInputStream, file.length());
            try {
                fileInputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return stream;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static byte[] oneBlock(byte[] bArr, InputStream inputStream, int i2) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha-1");
            int length = bArr.length;
            while (i2 != 0) {
                int i3 = length > i2 ? i2 : length;
                inputStream.read(bArr, 0, i3);
                messageDigest.update(bArr, 0, i3);
                i2 -= i3;
            }
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String resultEncode(byte[][] bArr) {
        byte[] bArr2;
        byte b;
        byte[] bArr3 = bArr[0];
        int length = bArr3.length;
        byte[] bArr4 = new byte[length + 1];
        if (bArr.length != 1) {
            b = -106;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("sha-1");
                for (byte[] bArr5 : bArr) {
                    messageDigest.update(bArr5);
                }
                bArr2 = messageDigest.digest();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            bArr2 = bArr3;
            b = 22;
        }
        bArr4[0] = b;
        System.arraycopy(bArr2, 0, bArr4, 1, length);
        return UrlSafeBase64.encodeToString(bArr4);
    }

    public static String stream(InputStream inputStream, long j2) throws IOException {
        if (j2 == 0) {
            return "Fto5o-5ea0sNMlW_75VgGJCv2AcJ";
        }
        byte[] bArr = new byte[65536];
        int i2 = (int) (((j2 + SVG.J) - 1) / SVG.J);
        byte[][] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            long j3 = j2 - (i3 * SVG.J);
            if (j3 > SVG.J) {
                j3 = 4194304;
            }
            bArr2[i3] = oneBlock(bArr, inputStream, (int) j3);
        }
        return resultEncode(bArr2);
    }

    public static String file(String str) throws IOException {
        return file(new File(str));
    }

    public static String data(byte[] bArr) {
        return data(bArr, 0, bArr.length);
    }
}
