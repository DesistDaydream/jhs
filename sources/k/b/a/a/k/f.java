package k.b.a.a.k;

import java.io.OutputStream;
import org.apache.commons.codec.CodecPolicy;

/* loaded from: classes4.dex */
public class f extends l {
    public f(OutputStream outputStream) {
        this(outputStream, true);
    }

    public f(OutputStream outputStream, boolean z) {
        super(outputStream, new d(false), z);
    }

    public f(OutputStream outputStream, boolean z, int i2, byte[] bArr) {
        super(outputStream, new d(i2, bArr), z);
    }

    public f(OutputStream outputStream, boolean z, int i2, byte[] bArr, CodecPolicy codecPolicy) {
        super(outputStream, new d(i2, bArr, false, (byte) 61, codecPolicy), z);
    }
}
