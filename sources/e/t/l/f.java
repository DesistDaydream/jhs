package e.t.l;

import h.k2.v.f0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0086\u0004\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0006¨\u0006\b"}, d2 = {"and", "", "", "other", "toHex", "", "", "toUTF8", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class f {
    public static final int a(byte b, int i2) {
        return b & i2;
    }

    @k.e.a.d
    public static final String b(@k.e.a.d byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(a(b, 255));
            if (hexString.length() == 1) {
                hexString = f0.C("0", hexString);
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    @k.e.a.d
    public static final String c(@k.e.a.d byte[] bArr) {
        return new String(bArr, h.t2.d.a);
    }
}
