package e.t.l;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"readString", "", "Ljava/io/InputStream;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class n {
    @k.e.a.d
    public static final String a(@k.e.a.d InputStream inputStream) {
        String k2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String str = null;
        try {
            if (inputStream.available() == 0) {
                h.h2.a.l(inputStream, byteArrayOutputStream, 0, 2, null);
                k2 = h.t2.u.k2(new String(byteArrayOutputStream.toByteArray(), h.t2.d.a), "\n", "", false, 4, null);
            } else {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                byteArrayOutputStream.write(bArr);
                k2 = h.t2.u.k2(new String(bArr, h.t2.d.a), "\n", "", false, 4, null);
            }
            h.h2.b.a(byteArrayOutputStream, null);
            str = k2;
        } catch (Throwable th) {
            Log.e("safeUse", String.valueOf(th.getMessage()));
        }
        return str == null ? "" : str;
    }
}
