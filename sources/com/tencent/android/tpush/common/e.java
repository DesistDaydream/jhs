package com.tencent.android.tpush.common;

import com.umeng.analytics.pro.cb;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class e {
    public static String a(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        if (serializable == null) {
            return "";
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(serializable);
            String a = a(byteArrayOutputStream.toByteArray());
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return a;
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream2 = objectOutputStream;
            try {
                throw th;
            } catch (Throwable th4) {
                if (objectOutputStream2 != null) {
                    objectOutputStream2.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th4;
            }
        }
    }

    public static byte[] b(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < str.length(); i2 += 2) {
            char charAt = str.charAt(i2);
            int i3 = i2 / 2;
            if (i3 < length) {
                bArr[i3] = (byte) ((charAt - 'a') << 4);
                bArr[i3] = (byte) (bArr[i3] + (str.charAt(i2 + 1) - 'a'));
            }
        }
        return bArr;
    }

    public static Object a(String str) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ObjectInputStream objectInputStream;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(b(str));
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = null;
            }
        } catch (Throwable th3) {
            byteArrayInputStream = null;
            th = th3;
            objectInputStream = null;
        }
        try {
            Object readObject = objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th4) {
            th = th4;
            try {
                throw th;
            } catch (Throwable th5) {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                throw th5;
            }
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            stringBuffer.append((char) (((bArr[i2] >> 4) & 15) + 97));
            stringBuffer.append((char) ((bArr[i2] & cb.f7124m) + 97));
        }
        return stringBuffer.toString();
    }
}
