package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import h.k2.u.a;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.z;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class CapturedTypeConstructorKt$createCapturedIfNeeded$1 extends Lambda implements a<z> {
    public final /* synthetic */ s0 $this_createCapturedIfNeeded;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturedTypeConstructorKt$createCapturedIfNeeded$1(s0 s0Var) {
        super(0);
        this.$this_createCapturedIfNeeded = s0Var;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final z invoke() {
        return this.$this_createCapturedIfNeeded.getType();
    }
}
