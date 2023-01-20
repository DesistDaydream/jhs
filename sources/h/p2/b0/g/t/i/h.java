package h.p2.b0.g.t.i;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class h {
    public static final byte[] a;
    public static final ByteBuffer b;

    /* loaded from: classes3.dex */
    public interface a {
        int getNumber();
    }

    /* loaded from: classes3.dex */
    public interface b<T extends a> {
        T a(int i2);
    }

    static {
        byte[] bArr = new byte[0];
        a = bArr;
        b = ByteBuffer.wrap(bArr);
    }

    public static boolean a(byte[] bArr) {
        return u.e(bArr);
    }

    public static String b(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported?", e2);
        }
    }
}
