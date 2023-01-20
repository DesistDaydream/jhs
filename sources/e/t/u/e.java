package e.t.u;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Lcom/vector/util/ConvertUtil;", "", "()V", "fileToBytes", "", "filePath", "", "toString", "inputStream", "Ljava/io/InputStream;", k.b.a.a.n.n.c.b, "unicodeToString", "text", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    @k.e.a.d
    public static final e a = new e();

    private e() {
    }

    @h.k2.k
    @k.e.a.d
    public static final String d(@k.e.a.d String str) {
        Matcher matcher = Pattern.compile("(\\\\u(\\p{XDigit}{4}))").matcher(str);
        String str2 = str;
        while (matcher.find()) {
            String group = matcher.group(1);
            str2 = h.t2.u.k2(str2, group, String.valueOf((char) Integer.parseInt(matcher.group(2), 16)) + "", false, 4, null);
        }
        return str2;
    }

    @k.e.a.e
    public final byte[] a(@k.e.a.d String str) {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception unused) {
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (Exception unused2) {
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            byteArrayOutputStream = null;
        }
        try {
            h.h2.a.l(fileInputStream, byteArrayOutputStream, 0, 2, null);
            bArr = byteArrayOutputStream.toByteArray();
        } catch (Exception unused3) {
        } catch (Throwable th4) {
            th = th4;
            e.t.l.i.a(fileInputStream);
            e.t.l.i.a(byteArrayOutputStream);
            throw th;
        }
        e.t.l.i.a(fileInputStream);
        e.t.l.i.a(byteArrayOutputStream);
        return bArr;
    }

    @k.e.a.d
    public final String b(@k.e.a.d InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        h.h2.a.l(inputStream, byteArrayOutputStream, 0, 2, null);
        return h.t2.u.k2(byteArrayOutputStream.toString("UTF-8"), "\n", "", false, 4, null);
    }

    @k.e.a.d
    public final String c(@k.e.a.d Object obj) {
        return obj instanceof Double ? Double.toString(((Number) obj).doubleValue()) : obj instanceof Integer ? Integer.toString(((Number) obj).intValue()) : toString();
    }
}
