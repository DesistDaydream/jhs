package com.qiniu.android.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
public class GZipUtil {
    public static byte[] gUnzip(byte[] bArr) {
        Throwable th;
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2 = null;
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = gZIPInputStream.read(bArr2);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    gZIPInputStream.close();
                } catch (IOException unused) {
                    gZIPInputStream2 = gZIPInputStream;
                    if (gZIPInputStream2 != null) {
                        gZIPInputStream2.close();
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th2) {
                    th = th2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            } catch (Throwable th3) {
                th = th3;
                gZIPInputStream = null;
            }
        } catch (IOException unused4) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] gZip(String str) {
        if (str == null) {
            return null;
        }
        return gZip(str.getBytes());
    }

    public static byte[] gZip(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.close();
                } catch (IOException unused) {
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused4) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
