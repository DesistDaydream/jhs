package k.b.a.a.k;

import java.io.OutputStream;
import org.apache.commons.codec.CodecPolicy;

/* loaded from: classes4.dex */
public class c extends l {
    public c(OutputStream outputStream) {
        this(outputStream, true);
    }

    public c(OutputStream outputStream, boolean z) {
        this(outputStream, z, false);
    }

    public c(OutputStream outputStream, boolean z, boolean z2) {
        this(outputStream, z, z2, CodecPolicy.LENIENT);
    }

    public c(OutputStream outputStream, boolean z, boolean z2, CodecPolicy codecPolicy) {
        super(outputStream, new a(z2, codecPolicy), z);
    }
}
