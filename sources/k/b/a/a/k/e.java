package k.b.a.a.k;

import java.io.InputStream;
import org.apache.commons.codec.CodecPolicy;

/* loaded from: classes4.dex */
public class e extends k {
    public e(InputStream inputStream) {
        this(inputStream, false);
    }

    public e(InputStream inputStream, boolean z) {
        super(inputStream, new d(false), z);
    }

    public e(InputStream inputStream, boolean z, int i2, byte[] bArr) {
        super(inputStream, new d(i2, bArr), z);
    }

    public e(InputStream inputStream, boolean z, int i2, byte[] bArr, CodecPolicy codecPolicy) {
        super(inputStream, new d(i2, bArr, false, (byte) 61, codecPolicy), z);
    }
}
