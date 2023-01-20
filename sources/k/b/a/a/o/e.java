package k.b.a.a.o;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import k.b.a.a.k.p;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public abstract class e {
    public static final char a = '?';
    public static final String b = "?=";

    /* renamed from: c  reason: collision with root package name */
    public static final String f16243c = "=?";

    public String a(String str) throws DecoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        if (str.startsWith(f16243c) && str.endsWith(b)) {
            int length = str.length() - 2;
            int indexOf = str.indexOf(63, 2);
            if (indexOf != length) {
                String substring = str.substring(2, indexOf);
                if (!substring.equals("")) {
                    int i2 = indexOf + 1;
                    int indexOf2 = str.indexOf(63, i2);
                    if (indexOf2 != length) {
                        String substring2 = str.substring(i2, indexOf2);
                        if (h().equalsIgnoreCase(substring2)) {
                            int i3 = indexOf2 + 1;
                            return new String(b(p.g(str.substring(i3, str.indexOf(63, i3)))), substring);
                        }
                        throw new DecoderException("This codec cannot decode " + substring2 + " encoded content");
                    }
                    throw new DecoderException("RFC 1522 violation: encoding token not found");
                }
                throw new DecoderException("RFC 1522 violation: charset not specified");
            }
            throw new DecoderException("RFC 1522 violation: charset token not found");
        }
        throw new DecoderException("RFC 1522 violation: malformed encoded content");
    }

    public abstract byte[] b(byte[] bArr) throws DecoderException;

    public abstract byte[] c(byte[] bArr) throws EncoderException;

    public String d(String str, String str2) throws EncoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return g(str, Charset.forName(str2));
    }

    public String g(String str, Charset charset) throws EncoderException {
        if (str == null) {
            return null;
        }
        return f16243c + charset + a + h() + a + p.p(c(str.getBytes(charset))) + b;
    }

    public abstract String h();
}
