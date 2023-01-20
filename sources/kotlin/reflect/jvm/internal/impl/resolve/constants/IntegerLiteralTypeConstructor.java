package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.xiaomi.mipush.sdk.Constants;
import h.k2.v.u;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.k.n.r;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.q0;
import h.w;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k.e.a.d;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;

/* loaded from: classes3.dex */
public final class IntegerLiteralTypeConstructor implements q0 {
    @d

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f16778f = new Companion(null);
    private final long a;
    @d
    private final z b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final Set<h.p2.b0.g.t.n.z> f16779c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final f0 f16780d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final w f16781e;

    /* loaded from: classes3.dex */
    public static final class Companion {

        /* loaded from: classes3.dex */
        public enum Mode {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE
        }

        /* loaded from: classes3.dex */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[Mode.values().length];
                iArr[Mode.COMMON_SUPER_TYPE.ordinal()] = 1;
                iArr[Mode.INTERSECTION_TYPE.ordinal()] = 2;
                a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }

        private final f0 a(Collection<? extends f0> collection, Mode mode) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator<T> it = collection.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    Companion companion = IntegerLiteralTypeConstructor.f16778f;
                    next = companion.e((f0) next, (f0) it.next(), mode);
                }
                return (f0) next;
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        private final f0 c(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, IntegerLiteralTypeConstructor integerLiteralTypeConstructor2, Mode mode) {
            Set V2;
            int i2 = a.a[mode.ordinal()];
            if (i2 == 1) {
                V2 = CollectionsKt___CollectionsKt.V2(integerLiteralTypeConstructor.i(), integerLiteralTypeConstructor2.i());
            } else if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                V2 = CollectionsKt___CollectionsKt.P5(integerLiteralTypeConstructor.i(), integerLiteralTypeConstructor2.i());
            }
            IntegerLiteralTypeConstructor integerLiteralTypeConstructor3 = new IntegerLiteralTypeConstructor(integerLiteralTypeConstructor.a, integerLiteralTypeConstructor.b, V2, null);
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            return KotlinTypeFactory.e(e.w0.b(), integerLiteralTypeConstructor3, false);
        }

        private final f0 d(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, f0 f0Var) {
            if (integerLiteralTypeConstructor.i().contains(f0Var)) {
                return f0Var;
            }
            return null;
        }

        private final f0 e(f0 f0Var, f0 f0Var2, Mode mode) {
            if (f0Var == null || f0Var2 == null) {
                return null;
            }
            q0 I0 = f0Var.I0();
            q0 I02 = f0Var2.I0();
            boolean z = I0 instanceof IntegerLiteralTypeConstructor;
            if (z && (I02 instanceof IntegerLiteralTypeConstructor)) {
                return c((IntegerLiteralTypeConstructor) I0, (IntegerLiteralTypeConstructor) I02, mode);
            }
            if (z) {
                return d((IntegerLiteralTypeConstructor) I0, f0Var2);
            }
            if (I02 instanceof IntegerLiteralTypeConstructor) {
                return d((IntegerLiteralTypeConstructor) I02, f0Var);
            }
            return null;
        }

        @k.e.a.e
        public final f0 b(@d Collection<? extends f0> collection) {
            return a(collection, Mode.INTERSECTION_TYPE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private IntegerLiteralTypeConstructor(long j2, z zVar, Set<? extends h.p2.b0.g.t.n.z> set) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        this.f16780d = KotlinTypeFactory.e(e.w0.b(), this, false);
        this.f16781e = h.z.c(new IntegerLiteralTypeConstructor$supertypes$2(this));
        this.a = j2;
        this.b = zVar;
        this.f16779c = set;
    }

    public /* synthetic */ IntegerLiteralTypeConstructor(long j2, z zVar, Set set, u uVar) {
        this(j2, zVar, set);
    }

    private final List<h.p2.b0.g.t.n.z> l() {
        return (List) this.f16781e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m() {
        Collection<h.p2.b0.g.t.n.z> a = r.a(this.b);
        if ((a instanceof Collection) && a.isEmpty()) {
            return true;
        }
        for (h.p2.b0.g.t.n.z zVar : a) {
            if (!(!i().contains(zVar))) {
                return false;
            }
        }
        return true;
    }

    private final String n() {
        return '[' + CollectionsKt___CollectionsKt.Z2(this.f16779c, Constants.ACCEPT_TIME_SEPARATOR_SP, null, null, 0, null, IntegerLiteralTypeConstructor$valueToString$1.INSTANCE, 30, null) + ']';
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    public q0 a(@d h hVar) {
        return this;
    }

    @Override // h.p2.b0.g.t.n.q0
    @k.e.a.e
    public f c() {
        return null;
    }

    @Override // h.p2.b0.g.t.n.q0
    public boolean d() {
        return false;
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    public List<t0> getParameters() {
        return CollectionsKt__CollectionsKt.E();
    }

    @d
    public final Set<h.p2.b0.g.t.n.z> i() {
        return this.f16779c;
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    public Collection<h.p2.b0.g.t.n.z> j() {
        return l();
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    public h.p2.b0.g.t.b.f k() {
        return this.b.k();
    }

    @d
    public String toString() {
        return h.k2.v.f0.C("IntegerLiteralType", n());
    }
}
