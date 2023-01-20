package h.p2.b0.g.t.g;

import h.k2.k;
import kotlin.text.Regex;

/* loaded from: classes3.dex */
public final class g {
    @k.e.a.d
    public static final g a = new g();
    @k.e.a.d
    private static final Regex b = new Regex("[^\\p{L}\\p{Digit}]");

    private g() {
    }

    @k
    @k.e.a.d
    public static final String a(@k.e.a.d String str) {
        return b.replace(str, "_");
    }
}
