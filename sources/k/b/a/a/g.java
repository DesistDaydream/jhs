package k.b.a.a;

import java.io.InputStream;

/* loaded from: classes4.dex */
public class g {
    public static InputStream a(String str) {
        InputStream resourceAsStream = g.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        throw new IllegalArgumentException("Unable to resolve required resource: " + str);
    }
}
