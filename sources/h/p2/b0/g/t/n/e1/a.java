package h.p2.b0.g.t.n.e1;

import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.e1.g;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.r0;
import h.p2.b0.g.t.n.z;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public class a extends AbstractTypeCheckerContext {
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    public static final C0467a f15559k = new C0467a(null);

    /* renamed from: e  reason: collision with root package name */
    private final boolean f15560e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f15561f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f15562g;
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private final h f15563h;
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    private final g f15564i;
    @k.e.a.d

    /* renamed from: j  reason: collision with root package name */
    private final c f15565j;

    /* renamed from: h.p2.b0.g.t.n.e1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0467a {

        /* renamed from: h.p2.b0.g.t.n.e1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0468a extends AbstractTypeCheckerContext.a.AbstractC0498a {
            public final /* synthetic */ c a;
            public final /* synthetic */ TypeSubstitutor b;

            public C0468a(c cVar, TypeSubstitutor typeSubstitutor) {
                this.a = cVar;
                this.b = typeSubstitutor;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.a
            @k.e.a.d
            public h.p2.b0.g.t.n.g1.i a(@k.e.a.d AbstractTypeCheckerContext abstractTypeCheckerContext, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
                c cVar = this.a;
                return cVar.b(this.b.n((z) cVar.j0(gVar), Variance.INVARIANT));
            }
        }

        private C0467a() {
        }

        public /* synthetic */ C0467a(h.k2.v.u uVar) {
            this();
        }

        @k.e.a.d
        public final AbstractTypeCheckerContext.a.AbstractC0498a a(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar) {
            String b;
            if (!(iVar instanceof f0)) {
                b = b.b(iVar);
                throw new IllegalArgumentException(b.toString());
            }
            return new C0468a(cVar, r0.f15601c.a((z) iVar).c());
        }
    }

    public /* synthetic */ a(boolean z, boolean z2, boolean z3, h hVar, g gVar, c cVar, int i2, h.k2.v.u uVar) {
        this(z, (i2 & 2) != 0 ? true : z2, (i2 & 4) == 0 ? z3 : true, (i2 & 8) != 0 ? h.a.a : hVar, (i2 & 16) != 0 ? g.a.a : gVar, (i2 & 32) != 0 ? q.a : cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    public boolean l(@k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
        return (gVar instanceof c1) && this.f15562g && (((c1) gVar).I0() instanceof n);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    public boolean n() {
        return this.f15560e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    public boolean o() {
        return this.f15561f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    @k.e.a.d
    public h.p2.b0.g.t.n.g1.g p(@k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
        String b;
        if (!(gVar instanceof z)) {
            b = b.b(gVar);
            throw new IllegalArgumentException(b.toString());
        }
        return this.f15564i.a(((z) gVar).L0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    @k.e.a.d
    public h.p2.b0.g.t.n.g1.g q(@k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
        String b;
        if (!(gVar instanceof z)) {
            b = b.b(gVar);
            throw new IllegalArgumentException(b.toString());
        }
        return this.f15563h.g((z) gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    @k.e.a.d
    /* renamed from: s */
    public c j() {
        return this.f15565j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    @k.e.a.d
    /* renamed from: t */
    public AbstractTypeCheckerContext.a.AbstractC0498a r(@k.e.a.d h.p2.b0.g.t.n.g1.i iVar) {
        return f15559k.a(j(), iVar);
    }

    public a(boolean z, boolean z2, boolean z3, @k.e.a.d h hVar, @k.e.a.d g gVar, @k.e.a.d c cVar) {
        this.f15560e = z;
        this.f15561f = z2;
        this.f15562g = z3;
        this.f15563h = hVar;
        this.f15564i = gVar;
        this.f15565j = cVar;
    }
}
