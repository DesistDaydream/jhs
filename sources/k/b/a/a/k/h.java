package k.b.a.a.k;

import java.io.InputStream;
import org.apache.commons.codec.CodecPolicy;

/* loaded from: classes4.dex */
public class h extends k {
    public h(InputStream inputStream) {
        this(inputStream, false);
    }

    public h(InputStream inputStream, boolean z) {
        super(inputStream, new g(false), z);
    }

    public h(InputStream inputStream, boolean z, int i2, byte[] bArr) {
        super(inputStream, new g(i2, bArr), z);
    }

    public h(InputStream inputStream, boolean z, int i2, byte[] bArr, CodecPolicy codecPolicy) {
        super(inputStream, new g(i2, bArr, false, codecPolicy), z);
    }
}
