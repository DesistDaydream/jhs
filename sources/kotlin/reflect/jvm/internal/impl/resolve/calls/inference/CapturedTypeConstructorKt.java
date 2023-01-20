package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import h.a2.u;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.k.m.a.b;
import h.p2.b0.g.t.n.k;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.u0;
import h.p2.b0.g.t.n.v0;
import h.p2.b0.g.t.n.y;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class CapturedTypeConstructorKt {

    /* loaded from: classes3.dex */
    public static final class a extends k {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f16776d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v0 f16777e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, v0 v0Var) {
            super(v0Var);
            this.f16776d = z;
            this.f16777e = v0Var;
        }

        @Override // h.p2.b0.g.t.n.k, h.p2.b0.g.t.n.v0
        public boolean b() {
            return this.f16776d;
        }

        @Override // h.p2.b0.g.t.n.k, h.p2.b0.g.t.n.v0
        @e
        public s0 e(@d z zVar) {
            s0 e2 = super.e(zVar);
            if (e2 == null) {
                return null;
            }
            f c2 = zVar.I0().c();
            return CapturedTypeConstructorKt.b(e2, c2 instanceof t0 ? (t0) c2 : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final s0 b(s0 s0Var, t0 t0Var) {
        if (t0Var == null || s0Var.c() == Variance.INVARIANT) {
            return s0Var;
        }
        if (t0Var.o() == s0Var.c()) {
            if (s0Var.b()) {
                return new u0(new LazyWrappedType(LockBasedStorageManager.f16850e, new CapturedTypeConstructorKt$createCapturedIfNeeded$1(s0Var)));
            }
            return new u0(s0Var.getType());
        }
        return new u0(c(s0Var));
    }

    @d
    public static final z c(@d s0 s0Var) {
        return new h.p2.b0.g.t.k.m.a.a(s0Var, null, false, null, 14, null);
    }

    public static final boolean d(@d z zVar) {
        return zVar.I0() instanceof b;
    }

    @d
    public static final v0 e(@d v0 v0Var, boolean z) {
        if (v0Var instanceof y) {
            y yVar = (y) v0Var;
            t0[] i2 = yVar.i();
            List<Pair> Oz = ArraysKt___ArraysKt.Oz(yVar.h(), yVar.i());
            ArrayList arrayList = new ArrayList(u.Y(Oz, 10));
            for (Pair pair : Oz) {
                arrayList.add(b((s0) pair.getFirst(), (t0) pair.getSecond()));
            }
            Object[] array = arrayList.toArray(new s0[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return new y(i2, (s0[]) array, z);
        }
        return new a(z, v0Var);
    }

    public static /* synthetic */ v0 f(v0 v0Var, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        return e(v0Var, z);
    }
}
