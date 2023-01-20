package h.p2.b0.g.t.l.b.w;

import java.io.InputStream;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes3.dex */
public final class c {
    @e
    public final InputStream a(@d String str) {
        ClassLoader classLoader = c.class.getClassLoader();
        InputStream resourceAsStream = classLoader == null ? null : classLoader.getResourceAsStream(str);
        return resourceAsStream == null ? ClassLoader.getSystemResourceAsStream(str) : resourceAsStream;
    }
}
