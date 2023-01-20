package com.tencent.tpns.baseapi.base.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import com.tencent.tpns.baseapi.core.net.a;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CommonHelper {
    public static boolean checkManifestIfComponentConfiged(Context context, String str) {
        try {
            context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 0);
            return true;
        } catch (Throwable th) {
            Logger.e("CommonHelper", "CommonHelper -> checkManifestIfComponentConfiged", th);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] decodeGZipContent(byte[] r7) {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L39
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L39
            java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L36
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L36
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L33
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L33
            int r7 = r7.length     // Catch: java.lang.Throwable -> L33
            int r7 = r7 * 2
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L33
        L17:
            int r7 = r2.read(r3)     // Catch: java.lang.Throwable -> L31
            r5 = -1
            if (r7 == r5) goto L23
            r5 = 0
            r4.write(r3, r5, r7)     // Catch: java.lang.Throwable -> L31
            goto L17
        L23:
            byte[] r7 = r4.toByteArray()     // Catch: java.lang.Throwable -> L31
            r4.close()     // Catch: java.lang.Throwable -> L2a
        L2a:
            r2.close()     // Catch: java.lang.Throwable -> L2d
        L2d:
            r1.close()     // Catch: java.lang.Throwable -> L30
        L30:
            return r7
        L31:
            r7 = move-exception
            goto L3d
        L33:
            r7 = move-exception
            r4 = r0
            goto L3d
        L36:
            r7 = move-exception
            r2 = r0
            goto L3c
        L39:
            r7 = move-exception
            r1 = r0
            r2 = r1
        L3c:
            r4 = r2
        L3d:
            java.lang.String r3 = "CommonHelper"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
            r5.<init>()     // Catch: java.lang.Throwable -> L67
            java.lang.String r6 = "decode gzip content failed, error "
            r5.append(r6)     // Catch: java.lang.Throwable -> L67
            r5.append(r7)     // Catch: java.lang.Throwable -> L67
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L67
            com.tencent.tpns.baseapi.base.util.Logger.e(r3, r7)     // Catch: java.lang.Throwable -> L67
            if (r4 == 0) goto L5a
            r4.close()     // Catch: java.lang.Throwable -> L59
            goto L5a
        L59:
        L5a:
            if (r2 == 0) goto L61
            r2.close()     // Catch: java.lang.Throwable -> L60
            goto L61
        L60:
        L61:
            if (r1 == 0) goto L66
            r1.close()     // Catch: java.lang.Throwable -> L66
        L66:
            return r0
        L67:
            r7 = move-exception
            if (r4 == 0) goto L6f
            r4.close()     // Catch: java.lang.Throwable -> L6e
            goto L6f
        L6e:
        L6f:
            if (r2 == 0) goto L76
            r2.close()     // Catch: java.lang.Throwable -> L75
            goto L76
        L75:
        L76:
            if (r1 == 0) goto L7b
            r1.close()     // Catch: java.lang.Throwable -> L7b
        L7b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.base.util.CommonHelper.decodeGZipContent(byte[]):byte[]");
    }

    public static byte[] encodeGZipContent(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
        }
        try {
            gZIPOutputStream.write(bArr);
            try {
                gZIPOutputStream.close();
            } catch (Throwable unused) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Throwable unused2) {
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th3) {
            th = th3;
            try {
                Logger.e("CommonHelper", "encode gzip content failed, error " + th);
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                return null;
            } finally {
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused5) {
                    }
                }
            }
        }
    }

    public static Object getMetaData(Context context, String str, Object obj) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj2 = applicationInfo.metaData.get(str);
                if (obj2 != null) {
                    return obj2;
                }
            }
        } catch (Throwable unused) {
            Logger.e("CommonHelper", "unexpected for getMetaData:" + str);
        }
        return obj;
    }

    public static String getOfflineMsg(Context context, String str, String str2, HttpRequestCallback httpRequestCallback) {
        try {
            if (CloudManager.getInstance(context).shouldRefuse()) {
                Logger.i("CommonHelper", "getOfflineMsg refused by cloud");
                return "";
            }
            return a.a(context).a(str, a.a(str), str2, httpRequestCallback, true);
        } catch (Throwable th) {
            Logger.w("CommonHelper", "unexpected for getOfflineMsg, exception:", th);
            return "";
        }
    }

    public static boolean isIPValid(String str) {
        if (str == null || str.length() < 7 || str.length() > 15 || "".equals(str)) {
            return false;
        }
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
    }

    public static Object jsonGet(JSONObject jSONObject, String str, Object obj) {
        try {
            if (jSONObject.has(str)) {
                return jSONObject.get(str);
            }
        } catch (JSONException e2) {
            Logger.e("CommonHelper", "unexpected for jsonGet:" + e2.getMessage());
        }
        return obj;
    }

    public static boolean jsonPut(JSONObject jSONObject, String str, Object obj) {
        if (obj != null) {
            try {
                jSONObject.put(str, obj);
                return true;
            } catch (JSONException e2) {
                Logger.e("CommonHelper", "unexpected for jsonPush:" + e2.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
                return true;
            } catch (Throwable th) {
                Logger.e("CommonHelper", "unexpected for safeClose:" + th.getMessage());
                return false;
            }
        }
        return false;
    }
}
