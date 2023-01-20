package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import h.k2.u.l;
import h.k2.v.f0;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class RawTypeImpl$render$newArgs$1 extends Lambda implements l<String, CharSequence> {
    public static final RawTypeImpl$render$newArgs$1 INSTANCE = new RawTypeImpl$render$newArgs$1();

    public RawTypeImpl$render$newArgs$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final CharSequence invoke(@d String str) {
        return f0.C("(raw) ", str);
    }
}
