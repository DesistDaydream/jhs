package com.bytedance.pangle.util;

import com.umeng.analytics.pro.cb;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class f {
    public static String a = "DES/ECB/NoPadding";
    public static String b = "DESede/ECB/NoPadding";

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f2350c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        return b(a(str.getBytes(), "MD5"));
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x003c: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:26:0x003c */
    private static byte[] b(File file) {
        Closeable closeable;
        FileInputStream fileInputStream;
        Closeable closeable2 = null;
        try {
            if (file == null) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e2) {
                e = e2;
                fileInputStream = null;
                e.printStackTrace();
                g.a(fileInputStream);
                return null;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                fileInputStream = null;
                e.printStackTrace();
                g.a(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                g.a(closeable2);
                throw th;
            }
            try {
                DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance("MD5"));
                do {
                } while (digestInputStream.read(new byte[262144]) > 0);
                byte[] digest = digestInputStream.getMessageDigest().digest();
                g.a(fileInputStream);
                return digest;
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                g.a(fileInputStream);
                return null;
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                e.printStackTrace();
                g.a(fileInputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
        }
    }

    public static String a(File file) {
        return b(b(file));
    }

    private static byte[] a(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String a(byte[] bArr) {
        return b(a(bArr, "MD5"));
    }

    private static String b(byte[] bArr) {
        int length;
        if (bArr != null && (length = bArr.length) > 0) {
            char[] cArr = new char[length << 1];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = i2 + 1;
                char[] cArr2 = f2350c;
                cArr[i2] = cArr2[(bArr[i3] >>> 4) & 15];
                i2 = i4 + 1;
                cArr[i4] = cArr2[bArr[i3] & cb.f7124m];
            }
            return new String(cArr);
        }
        return null;
    }

    public static String b(String str) {
        boolean z = false;
        if (str != null) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isWhitespace(str.charAt(i2))) {
                    break;
                }
            }
        }
        z = true;
        return a(z ? null : new File(str));
    }
}
