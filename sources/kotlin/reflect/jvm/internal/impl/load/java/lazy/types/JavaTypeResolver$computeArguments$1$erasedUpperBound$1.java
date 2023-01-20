package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import h.k2.u.a;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.z;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class JavaTypeResolver$computeArguments$1$erasedUpperBound$1 extends Lambda implements a<z> {
    public final /* synthetic */ h.p2.b0.g.t.e.a.v.j.a $attr;
    public final /* synthetic */ q0 $constructor;
    public final /* synthetic */ boolean $isRaw;
    public final /* synthetic */ t0 $parameter;

    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeArguments$1$erasedUpperBound$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements a<z> {
        public final /* synthetic */ q0 $constructor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(q0 q0Var) {
            super(0);
            this.$constructor = q0Var;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h.k2.u.a
        @d
        public final z invoke() {
            return TypeUtilsKt.s(this.$constructor.c().r());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaTypeResolver$computeArguments$1$erasedUpperBound$1(t0 t0Var, boolean z, h.p2.b0.g.t.e.a.v.j.a aVar, q0 q0Var) {
        super(0);
        this.$parameter = t0Var;
        this.$isRaw = z;
        this.$attr = aVar;
        this.$constructor = q0Var;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final z invoke() {
        return JavaTypeResolverKt.b(this.$parameter, this.$isRaw, this.$attr, new AnonymousClass1(this.$constructor));
    }
}
