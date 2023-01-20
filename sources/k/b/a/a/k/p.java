package k.b.a.a.k;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes4.dex */
public class p {
    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        return charSequence.length() == charSequence2.length() && n.a(charSequence, false, 0, charSequence2, 0, charSequence.length());
    }

    private static ByteBuffer b(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return ByteBuffer.wrap(str.getBytes(charset));
    }

    public static ByteBuffer c(String str) {
        return b(str, StandardCharsets.UTF_8);
    }

    private static byte[] d(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return str.getBytes(charset);
    }

    public static byte[] e(String str) {
        return d(str, StandardCharsets.ISO_8859_1);
    }

    public static byte[] f(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e2) {
            throw l(str2, e2);
        }
    }

    public static byte[] g(String str) {
        return d(str, StandardCharsets.US_ASCII);
    }

    public static byte[] h(String str) {
        return d(str, StandardCharsets.UTF_16);
    }

    public static byte[] i(String str) {
        return d(str, StandardCharsets.UTF_16BE);
    }

    public static byte[] j(String str) {
        return d(str, StandardCharsets.UTF_16LE);
    }

    public static byte[] k(String str) {
        return d(str, StandardCharsets.UTF_8);
    }

    private static IllegalStateException l(String str, UnsupportedEncodingException unsupportedEncodingException) {
        return new IllegalStateException(str + ": " + unsupportedEncodingException);
    }

    public static String m(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e2) {
            throw l(str, e2);
        }
    }

    private static String n(byte[] bArr, Charset charset) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    public static String o(byte[] bArr) {
        return n(bArr, StandardCharsets.ISO_8859_1);
    }

    public static String p(byte[] bArr) {
        return n(bArr, StandardCharsets.US_ASCII);
    }

    public static String q(byte[] bArr) {
        return n(bArr, StandardCharsets.UTF_16);
    }

    public static String r(byte[] bArr) {
        return n(bArr, StandardCharsets.UTF_16BE);
    }

    public static String s(byte[] bArr) {
        return n(bArr, StandardCharsets.UTF_16LE);
    }

    public static String t(byte[] bArr) {
        return n(bArr, StandardCharsets.UTF_8);
    }
}
