package k.b.a.a.k;

import java.io.InputStream;
import org.apache.commons.codec.CodecPolicy;

/* loaded from: classes4.dex */
public class b extends k {
    public b(InputStream inputStream) {
        this(inputStream, false);
    }

    public b(InputStream inputStream, boolean z) {
        this(inputStream, z, false);
    }

    public b(InputStream inputStream, boolean z, boolean z2) {
        this(inputStream, z, z2, CodecPolicy.LENIENT);
    }

    public b(InputStream inputStream, boolean z, boolean z2, CodecPolicy codecPolicy) {
        super(inputStream, new a(z2, codecPolicy), z);
    }
}
