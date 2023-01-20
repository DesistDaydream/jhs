package k.b.a.a.k;

import java.io.OutputStream;
import org.apache.commons.codec.CodecPolicy;

/* loaded from: classes4.dex */
public class i extends l {
    public i(OutputStream outputStream) {
        this(outputStream, true);
    }

    public i(OutputStream outputStream, boolean z) {
        super(outputStream, new g(false), z);
    }

    public i(OutputStream outputStream, boolean z, int i2, byte[] bArr) {
        super(outputStream, new g(i2, bArr), z);
    }

    public i(OutputStream outputStream, boolean z, int i2, byte[] bArr, CodecPolicy codecPolicy) {
        super(outputStream, new g(i2, bArr, false, codecPolicy), z);
    }
}
