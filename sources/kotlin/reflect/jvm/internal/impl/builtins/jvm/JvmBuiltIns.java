package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import h.k2.v.n0;
import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.c.c1.c;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.l;
import h.p2.b0.g.t.m.m;
import h.p2.n;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes3.dex */
public final class JvmBuiltIns extends f {

    /* renamed from: l  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16427l = {n0.r(new PropertyReference1Impl(n0.d(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    @d

    /* renamed from: i  reason: collision with root package name */
    private final Kind f16428i;
    @e

    /* renamed from: j  reason: collision with root package name */
    private h.k2.u.a<a> f16429j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final h f16430k;

    /* loaded from: classes3.dex */
    public enum Kind {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK
    }

    /* loaded from: classes3.dex */
    public static final class a {
        @d
        private final z a;
        private final boolean b;

        public a(@d z zVar, boolean z) {
            this.a = zVar;
            this.b = z;
        }

        @d
        public final z a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Kind.values().length];
            iArr[Kind.FROM_DEPENDENCIES.ordinal()] = 1;
            iArr[Kind.FROM_CLASS_LOADER.ordinal()] = 2;
            iArr[Kind.FALLBACK.ordinal()] = 3;
            a = iArr;
        }
    }

    public JvmBuiltIns(@d m mVar, @d Kind kind) {
        super(mVar);
        this.f16428i = kind;
        this.f16430k = mVar.c(new JvmBuiltIns$customizer$2(this, mVar));
        int i2 = b.a[kind.ordinal()];
        if (i2 == 2) {
            f(false);
        } else if (i2 != 3) {
        } else {
            f(true);
        }
    }

    @Override // h.p2.b0.g.t.b.f
    @d
    /* renamed from: E0 */
    public List<h.p2.b0.g.t.c.c1.b> v() {
        return CollectionsKt___CollectionsKt.n4(super.v(), new JvmBuiltInClassDescriptorFactory(T(), r(), null, 4, null));
    }

    @d
    public final JvmBuiltInsCustomizer F0() {
        return (JvmBuiltInsCustomizer) l.a(this.f16430k, this, f16427l[0]);
    }

    public final void G0(@d z zVar, boolean z) {
        H0(new JvmBuiltIns$initialize$1(zVar, z));
    }

    public final void H0(@d h.k2.u.a<a> aVar) {
        h.k2.u.a<a> aVar2 = this.f16429j;
        this.f16429j = aVar;
    }

    @Override // h.p2.b0.g.t.b.f
    @d
    public c M() {
        return F0();
    }

    @Override // h.p2.b0.g.t.b.f
    @d
    public h.p2.b0.g.t.c.c1.a g() {
        return F0();
    }
}
