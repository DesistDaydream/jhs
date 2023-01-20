package kotlin.reflect.jvm.internal.impl.resolve.constants;

import h.k2.u.l;
import h.p2.b0.g.t.n.z;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class IntegerLiteralTypeConstructor$valueToString$1 extends Lambda implements l<z, CharSequence> {
    public static final IntegerLiteralTypeConstructor$valueToString$1 INSTANCE = new IntegerLiteralTypeConstructor$valueToString$1();

    public IntegerLiteralTypeConstructor$valueToString$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final CharSequence invoke(@d z zVar) {
        return zVar.toString();
    }
}
