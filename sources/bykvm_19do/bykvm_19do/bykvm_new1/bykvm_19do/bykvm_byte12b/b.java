package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.f;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i;
import com.bytedance.mapplog.util.TTEncryptUtils;
import com.caverock.androidsvg.SVG;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qiniu.android.common.Constants;
import com.qq.e.comm.adevent.AdEventType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    public static boolean a;
    private static c b;

    /* loaded from: classes.dex */
    public enum a {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        a(int i2) {
        }
    }

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0053b {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);

        EnumC0053b(int i2) {
        }
    }

    public static e a(long j2, String str, byte[] bArr, a aVar, String str2, boolean z) throws IOException {
        String str3;
        StringBuilder sb;
        if (str == null) {
            return new e(AdEventType.VIDEO_CACHE);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        String str4 = null;
        if (a.GZIP == aVar && length > 128) {
            bArr = c(bArr);
            str4 = "gzip";
        } else if (a.DEFLATER == aVar && length > 128) {
            bArr = b(bArr);
            str4 = "deflate";
        }
        String str5 = str4;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return new e(AdEventType.VIDEO_START);
        }
        if (z) {
            byte[] a2 = TTEncryptUtils.a(bArr2, bArr2.length);
            if (a2 != null) {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    str3 = "?";
                    if (!str.endsWith("?")) {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append(str3);
                        str = sb.toString();
                    }
                    str = str + "tt_data=a";
                    str2 = "application/octet-stream;tt-data=a";
                    bArr2 = a2;
                } else {
                    str3 = ContainerUtils.FIELD_DELIMITER;
                    if (!str.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append(str3);
                        str = sb.toString();
                    }
                    str = str + "tt_data=a";
                    str2 = "application/octet-stream;tt-data=a";
                    bArr2 = a2;
                }
            }
            return a(str, bArr2, str2, str5, "POST", true, true);
        }
        return a(str, bArr2, str2, str5, "POST", true, false);
    }

    public static e a(String str, String str2) {
        return a(str, str2, a());
    }

    public static e a(String str, String str2, boolean z) {
        e eVar;
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                eVar = a(SVG.I, str, str2.getBytes(), a.GZIP, "application/json; charset=utf-8", z);
                return eVar;
            }
            eVar = new e(AdEventType.VIDEO_CACHE);
            return eVar;
        } catch (Throwable th) {
            j.b(th);
            return new e((int) AdEventType.VIDEO_ERROR, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.e a(java.lang.String r4, byte[] r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b.a(java.lang.String, byte[], java.lang.String, java.lang.String, java.lang.String, boolean, boolean):bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.e");
    }

    private static e a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new e(AdEventType.VIDEO_RESUME);
        }
        String str = new String(bArr, Charset.forName(Constants.UTF_8));
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.length() > 0 ? new e(0, jSONObject) : new e((int) AdEventType.VIDEO_PAUSE, str);
        } catch (JSONException unused) {
            return new e((int) AdEventType.VIDEO_PAUSE, str);
        }
    }

    public static String a(Map map) {
        return i.f().a();
    }

    public static boolean a() {
        return true;
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    f.a(byteArrayOutputStream);
                }
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean b() {
        return true;
    }

    private static byte[] b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] c(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                j.b(th);
                gZIPOutputStream.close();
                return null;
            } catch (Throwable th2) {
                gZIPOutputStream.close();
                throw th2;
            }
        }
    }
}
