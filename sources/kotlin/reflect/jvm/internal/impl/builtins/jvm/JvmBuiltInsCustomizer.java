package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import h.a2.d1;
import h.a2.t;
import h.a2.u;
import h.k2.v.n0;
import h.p2.b0.g.t.c.d1.g;
import h.p2.b0.g.t.c.d1.w;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.j;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.r;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.e.b.q;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.l;
import h.p2.b0.g.t.m.m;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.p.b;
import h.p2.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer implements h.p2.b0.g.t.c.c1.a, h.p2.b0.g.t.c.c1.c {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16431h = {n0.r(new PropertyReference1Impl(n0.d(JvmBuiltInsCustomizer.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), n0.r(new PropertyReference1Impl(n0.d(JvmBuiltInsCustomizer.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), n0.r(new PropertyReference1Impl(n0.d(JvmBuiltInsCustomizer.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    @k.e.a.d
    private final z a;
    @k.e.a.d
    private final h.p2.b0.g.t.b.k.d b = h.p2.b0.g.t.b.k.d.a;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final h f16432c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final h.p2.b0.g.t.n.z f16433d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final h f16434e;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private final h.p2.b0.g.t.m.a<h.p2.b0.g.t.g.c, h.p2.b0.g.t.c.d> f16435f;
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private final h f16436g;

    /* loaded from: classes3.dex */
    public enum JDKMemberStatus {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP
    }

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JDKMemberStatus.values().length];
            iArr[JDKMemberStatus.HIDDEN.ordinal()] = 1;
            iArr[JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 2;
            iArr[JDKMemberStatus.DROP.ordinal()] = 3;
            iArr[JDKMemberStatus.VISIBLE.ordinal()] = 4;
            a = iArr;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends w {
        public b(z zVar, h.p2.b0.g.t.g.c cVar) {
            super(zVar, cVar);
        }

        @Override // h.p2.b0.g.t.c.b0
        @k.e.a.d
        /* renamed from: C0 */
        public MemberScope.b q() {
            return MemberScope.b.b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c<N> implements b.d<h.p2.b0.g.t.c.d> {
        public c() {
        }

        @Override // h.p2.b0.g.t.p.b.d
        @k.e.a.d
        /* renamed from: b */
        public final Iterable<h.p2.b0.g.t.c.d> a(h.p2.b0.g.t.c.d dVar) {
            Collection<h.p2.b0.g.t.n.z> j2 = dVar.j().j();
            JvmBuiltInsCustomizer jvmBuiltInsCustomizer = JvmBuiltInsCustomizer.this;
            ArrayList arrayList = new ArrayList();
            for (h.p2.b0.g.t.n.z zVar : j2) {
                f c2 = zVar.I0().c();
                f a = c2 == null ? null : c2.a();
                h.p2.b0.g.t.c.d dVar2 = a instanceof h.p2.b0.g.t.c.d ? (h.p2.b0.g.t.c.d) a : null;
                LazyJavaClassDescriptor p = dVar2 != null ? jvmBuiltInsCustomizer.p(dVar2) : null;
                if (p != null) {
                    arrayList.add(p);
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends b.AbstractC0472b<h.p2.b0.g.t.c.d, JDKMemberStatus> {
        public final /* synthetic */ String a;
        public final /* synthetic */ Ref.ObjectRef<JDKMemberStatus> b;

        public d(String str, Ref.ObjectRef<JDKMemberStatus> objectRef) {
            this.a = str;
            this.b = objectRef;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
        /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
        /* JADX WARN: Type inference failed for: r0v5, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
        @Override // h.p2.b0.g.t.p.b.AbstractC0472b, h.p2.b0.g.t.p.b.e
        /* renamed from: d */
        public boolean c(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
            String a = q.a(SignatureBuildingComponents.a, dVar, this.a);
            h.p2.b0.g.t.b.k.f fVar = h.p2.b0.g.t.b.k.f.a;
            if (fVar.e().contains(a)) {
                this.b.element = JDKMemberStatus.HIDDEN;
            } else if (fVar.h().contains(a)) {
                this.b.element = JDKMemberStatus.VISIBLE;
            } else if (fVar.c().contains(a)) {
                this.b.element = JDKMemberStatus.DROP;
            }
            return this.b.element == null;
        }

        @Override // h.p2.b0.g.t.p.b.e
        @k.e.a.d
        /* renamed from: e */
        public JDKMemberStatus a() {
            JDKMemberStatus jDKMemberStatus = this.b.element;
            return jDKMemberStatus == null ? JDKMemberStatus.NOT_CONSIDERED : jDKMemberStatus;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e<N> implements b.d<CallableMemberDescriptor> {
        public static final e<N> a = new e<>();

        @Override // h.p2.b0.g.t.p.b.d
        @k.e.a.d
        /* renamed from: b */
        public final Iterable<CallableMemberDescriptor> a(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor.a().d();
        }
    }

    public JvmBuiltInsCustomizer(@k.e.a.d z zVar, @k.e.a.d m mVar, @k.e.a.d h.k2.u.a<JvmBuiltIns.a> aVar) {
        this.a = zVar;
        this.f16432c = mVar.c(aVar);
        this.f16433d = k(mVar);
        this.f16434e = mVar.c(new JvmBuiltInsCustomizer$cloneableType$2(this, mVar));
        this.f16435f = mVar.a();
        this.f16436g = mVar.c(new JvmBuiltInsCustomizer$notConsideredDeprecation$2(this));
    }

    private final h.p2.b0.g.t.c.n0 j(DeserializedClassDescriptor deserializedClassDescriptor, h.p2.b0.g.t.c.n0 n0Var) {
        v.a<? extends h.p2.b0.g.t.c.n0> x = n0Var.x();
        x.p(deserializedClassDescriptor);
        x.g(r.f15211e);
        x.l(deserializedClassDescriptor.r());
        x.c(deserializedClassDescriptor.F0());
        return x.build();
    }

    private final h.p2.b0.g.t.n.z k(m mVar) {
        g gVar = new g(new b(this.a, new h.p2.b0.g.t.g.c("java.io")), h.p2.b0.g.t.g.f.f("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, t.k(new LazyWrappedType(mVar, new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$superTypes$1(this))), o0.a, false, mVar);
        gVar.G0(MemberScope.b.b, d1.k(), null);
        return gVar.r();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d8, code lost:
        if (t(r3, r9) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Collection<h.p2.b0.g.t.c.n0> l(h.p2.b0.g.t.c.d r9, h.k2.u.l<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, ? extends java.util.Collection<? extends h.p2.b0.g.t.c.n0>> r10) {
        /*
            r8 = this;
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r0 = r8.p(r9)
            if (r0 != 0) goto Lb
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.E()
            return r9
        Lb:
            h.p2.b0.g.t.b.k.d r1 = r8.b
            h.p2.b0.g.t.g.c r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.i(r0)
            h.p2.b0.g.t.b.k.b$a r3 = h.p2.b0.g.t.b.k.b.f15062i
            h.p2.b0.g.t.b.f r3 = r3.a()
            java.util.Collection r1 = r1.i(r2, r3)
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.g3(r1)
            h.p2.b0.g.t.c.d r2 = (h.p2.b0.g.t.c.d) r2
            if (r2 != 0) goto L28
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.E()
            return r9
        L28:
            h.p2.b0.g.t.p.e$b r3 = h.p2.b0.g.t.p.e.f15632c
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = h.a2.u.Y(r1, r5)
            r4.<init>(r5)
            java.util.Iterator r1 = r1.iterator()
        L39:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L4d
            java.lang.Object r5 = r1.next()
            h.p2.b0.g.t.c.d r5 = (h.p2.b0.g.t.c.d) r5
            h.p2.b0.g.t.g.c r5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.i(r5)
            r4.add(r5)
            goto L39
        L4d:
            h.p2.b0.g.t.p.e r1 = r3.b(r4)
            h.p2.b0.g.t.b.k.d r3 = r8.b
            boolean r9 = r3.c(r9)
            h.p2.b0.g.t.m.a<h.p2.b0.g.t.g.c, h.p2.b0.g.t.c.d> r3 = r8.f16435f
            h.p2.b0.g.t.g.c r4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.i(r0)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1 r5 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1
            r5.<init>(r0, r2)
            java.lang.Object r0 = r3.a(r4, r5)
            h.p2.b0.g.t.c.d r0 = (h.p2.b0.g.t.c.d) r0
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r0.W()
            java.lang.Object r10 = r10.invoke(r0)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r10 = r10.iterator()
        L7b:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto Le0
            java.lang.Object r2 = r10.next()
            r3 = r2
            h.p2.b0.g.t.c.n0 r3 = (h.p2.b0.g.t.c.n0) r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r4 = r3.i()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r5 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION
            r6 = 1
            r7 = 0
            if (r4 == r5) goto L94
        L92:
            r6 = 0
            goto Lda
        L94:
            h.p2.b0.g.t.c.s r4 = r3.getVisibility()
            boolean r4 = r4.d()
            if (r4 != 0) goto L9f
            goto L92
        L9f:
            boolean r4 = h.p2.b0.g.t.b.f.h0(r3)
            if (r4 == 0) goto La6
            goto L92
        La6:
            java.util.Collection r4 = r3.d()
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto Lb2
        Lb0:
            r4 = 0
            goto Ld1
        Lb2:
            java.util.Iterator r4 = r4.iterator()
        Lb6:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto Lb0
            java.lang.Object r5 = r4.next()
            h.p2.b0.g.t.c.v r5 = (h.p2.b0.g.t.c.v) r5
            h.p2.b0.g.t.c.k r5 = r5.b()
            h.p2.b0.g.t.g.c r5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.i(r5)
            boolean r5 = r1.contains(r5)
            if (r5 == 0) goto Lb6
            r4 = 1
        Ld1:
            if (r4 == 0) goto Ld4
            goto L92
        Ld4:
            boolean r3 = r8.t(r3, r9)
            if (r3 != 0) goto L92
        Lda:
            if (r6 == 0) goto L7b
            r0.add(r2)
            goto L7b
        Le0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.l(h.p2.b0.g.t.c.d, h.k2.u.l):java.util.Collection");
    }

    private final f0 m() {
        return (f0) l.a(this.f16434e, this, f16431h[1]);
    }

    private static final boolean n(j jVar, TypeSubstitutor typeSubstitutor, j jVar2) {
        return OverridingUtil.y(jVar, jVar2.c(typeSubstitutor)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LazyJavaClassDescriptor p(h.p2.b0.g.t.c.d dVar) {
        if (!h.p2.b0.g.t.b.f.Z(dVar) && h.p2.b0.g.t.b.f.y0(dVar)) {
            h.p2.b0.g.t.g.d j2 = DescriptorUtilsKt.j(dVar);
            if (j2.f()) {
                h.p2.b0.g.t.g.b o = h.p2.b0.g.t.b.k.c.a.o(j2);
                h.p2.b0.g.t.g.c b2 = o == null ? null : o.b();
                if (b2 == null) {
                    return null;
                }
                h.p2.b0.g.t.c.d c2 = h.p2.b0.g.t.c.q.c(s().a(), b2, NoLookupLocation.FROM_BUILTINS);
                if (c2 instanceof LazyJavaClassDescriptor) {
                    return (LazyJavaClassDescriptor) c2;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private final JDKMemberStatus q(v vVar) {
        return (JDKMemberStatus) h.p2.b0.g.t.p.b.b(t.k((h.p2.b0.g.t.c.d) vVar.b()), new c(), new d(h.p2.b0.g.t.e.b.r.c(vVar, false, false, 3, null), new Ref.ObjectRef()));
    }

    private final h.p2.b0.g.t.c.b1.e r() {
        return (h.p2.b0.g.t.c.b1.e) l.a(this.f16436g, this, f16431h[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JvmBuiltIns.a s() {
        return (JvmBuiltIns.a) l.a(this.f16432c, this, f16431h[0]);
    }

    private final boolean t(h.p2.b0.g.t.c.n0 n0Var, boolean z) {
        String c2 = h.p2.b0.g.t.e.b.r.c(n0Var, false, false, 3, null);
        if (z ^ h.p2.b0.g.t.b.k.f.a.f().contains(q.a(SignatureBuildingComponents.a, (h.p2.b0.g.t.c.d) n0Var.b(), c2))) {
            return true;
        }
        return h.p2.b0.g.t.p.b.e(t.k(n0Var), e.a, new JvmBuiltInsCustomizer$isMutabilityViolation$2(this)).booleanValue();
    }

    private final boolean u(j jVar, h.p2.b0.g.t.c.d dVar) {
        if (jVar.h().size() == 1) {
            f c2 = ((v0) CollectionsKt___CollectionsKt.U4(jVar.h())).getType().I0().c();
            if (h.k2.v.f0.g(c2 == null ? null : DescriptorUtilsKt.j(c2), DescriptorUtilsKt.j(dVar))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e8, code lost:
        if (r2 != 3) goto L44;
     */
    @Override // h.p2.b0.g.t.c.c1.a
    @k.e.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<h.p2.b0.g.t.c.n0> a(@k.e.a.d h.p2.b0.g.t.g.f r7, @k.e.a.d h.p2.b0.g.t.c.d r8) {
        /*
            r6 = this;
            h.p2.b0.g.t.b.k.a$a r0 = h.p2.b0.g.t.b.k.a.f15060e
            h.p2.b0.g.t.g.f r0 = r0.a()
            boolean r0 = h.k2.v.f0.g(r7, r0)
            r1 = 1
            if (r0 == 0) goto L7e
            boolean r0 = r8 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor
            if (r0 == 0) goto L7e
            boolean r0 = h.p2.b0.g.t.b.f.c0(r8)
            if (r0 == 0) goto L7e
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r8 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) r8
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.T0()
            java.util.List r0 = r0.getFunctionList()
            boolean r2 = r0 instanceof java.util.Collection
            r3 = 0
            if (r2 == 0) goto L2e
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L2e
        L2c:
            r1 = 0
            goto L5a
        L2e:
            java.util.Iterator r0 = r0.iterator()
        L32:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L2c
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r2 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r2
            h.p2.b0.g.t.l.b.i r4 = r8.S0()
            h.p2.b0.g.t.f.z.c r4 = r4.g()
            int r2 = r2.getName()
            h.p2.b0.g.t.g.f r2 = h.p2.b0.g.t.l.b.q.b(r4, r2)
            h.p2.b0.g.t.b.k.a$a r4 = h.p2.b0.g.t.b.k.a.f15060e
            h.p2.b0.g.t.g.f r4 = r4.a()
            boolean r2 = h.k2.v.f0.g(r2, r4)
            if (r2 == 0) goto L32
        L5a:
            if (r1 == 0) goto L61
            java.util.List r7 = kotlin.collections.CollectionsKt__CollectionsKt.E()
            return r7
        L61:
            h.p2.b0.g.t.n.f0 r0 = r6.m()
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r0.q()
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r1 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BUILTINS
            java.util.Collection r7 = r0.a(r7, r1)
            java.lang.Object r7 = kotlin.collections.CollectionsKt___CollectionsKt.S4(r7)
            h.p2.b0.g.t.c.n0 r7 = (h.p2.b0.g.t.c.n0) r7
            h.p2.b0.g.t.c.n0 r7 = r6.j(r8, r7)
            java.util.List r7 = h.a2.t.k(r7)
            return r7
        L7e:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$a r0 = r6.s()
            boolean r0 = r0.b()
            if (r0 != 0) goto L8d
            java.util.List r7 = kotlin.collections.CollectionsKt__CollectionsKt.E()
            return r7
        L8d:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getFunctions$2 r0 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getFunctions$2
            r0.<init>(r7)
            java.util.Collection r7 = r6.l(r8, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L9f:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L10a
            java.lang.Object r2 = r7.next()
            h.p2.b0.g.t.c.n0 r2 = (h.p2.b0.g.t.c.n0) r2
            h.p2.b0.g.t.c.k r3 = r2.b()
            h.p2.b0.g.t.c.d r3 = (h.p2.b0.g.t.c.d) r3
            h.p2.b0.g.t.n.r0 r3 = h.p2.b0.g.t.b.k.g.a(r3, r8)
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r3 = r3.c()
            h.p2.b0.g.t.c.v r3 = r2.c(r3)
            java.lang.String r4 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor"
            java.util.Objects.requireNonNull(r3, r4)
            h.p2.b0.g.t.c.n0 r3 = (h.p2.b0.g.t.c.n0) r3
            h.p2.b0.g.t.c.v$a r3 = r3.x()
            r3.p(r8)
            h.p2.b0.g.t.c.m0 r4 = r8.F0()
            r3.c(r4)
            r3.k()
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus r2 = r6.q(r2)
            int[] r4 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.a.a
            int r2 = r2.ordinal()
            r2 = r4[r2]
            r4 = 0
            if (r2 == r1) goto Lf3
            r5 = 2
            if (r2 == r5) goto Leb
            r5 = 3
            if (r2 == r5) goto L104
            goto Lfd
        Leb:
            h.p2.b0.g.t.c.b1.e r2 = r6.r()
            r3.r(r2)
            goto Lfd
        Lf3:
            boolean r2 = h.p2.b0.g.t.c.x.a(r8)
            if (r2 == 0) goto Lfa
            goto L104
        Lfa:
            r3.d()
        Lfd:
            h.p2.b0.g.t.c.v r2 = r3.build()
            r4 = r2
            h.p2.b0.g.t.c.n0 r4 = (h.p2.b0.g.t.c.n0) r4
        L104:
            if (r4 == 0) goto L9f
            r0.add(r4)
            goto L9f
        L10a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.a(h.p2.b0.g.t.g.f, h.p2.b0.g.t.c.d):java.util.Collection");
    }

    @Override // h.p2.b0.g.t.c.c1.c
    public boolean b(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d h.p2.b0.g.t.c.n0 n0Var) {
        LazyJavaClassDescriptor p = p(dVar);
        if (p != null && n0Var.getAnnotations().n(h.p2.b0.g.t.c.c1.d.a())) {
            if (s().b()) {
                String c2 = h.p2.b0.g.t.e.b.r.c(n0Var, false, false, 3, null);
                Collection<h.p2.b0.g.t.c.n0> a2 = p.W().a(n0Var.getName(), NoLookupLocation.FROM_BUILTINS);
                if (!(a2 instanceof Collection) || !a2.isEmpty()) {
                    for (h.p2.b0.g.t.c.n0 n0Var2 : a2) {
                        if (h.k2.v.f0.g(h.p2.b0.g.t.e.b.r.c(n0Var2, false, false, 3, null), c2)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return true;
    }

    @Override // h.p2.b0.g.t.c.c1.a
    @k.e.a.d
    public Collection<h.p2.b0.g.t.c.c> c(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        h.p2.b0.g.t.c.d h2;
        boolean z;
        if (dVar.i() == ClassKind.CLASS && s().b()) {
            LazyJavaClassDescriptor p = p(dVar);
            if (p != null && (h2 = h.p2.b0.g.t.b.k.d.h(this.b, DescriptorUtilsKt.i(p), h.p2.b0.g.t.b.k.b.f15062i.a(), null, 4, null)) != null) {
                TypeSubstitutor c2 = h.p2.b0.g.t.b.k.g.a(h2, p).c();
                List<h.p2.b0.g.t.c.c> g2 = p.g();
                ArrayList<h.p2.b0.g.t.c.c> arrayList = new ArrayList();
                Iterator<T> it = g2.iterator();
                while (true) {
                    boolean z2 = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    h.p2.b0.g.t.c.c cVar = (h.p2.b0.g.t.c.c) next;
                    if (cVar.getVisibility().d()) {
                        Collection<h.p2.b0.g.t.c.c> g3 = h2.g();
                        if (!g3.isEmpty()) {
                            for (h.p2.b0.g.t.c.c cVar2 : g3) {
                                if (n(cVar2, c2, cVar)) {
                                    z = false;
                                    break;
                                }
                            }
                        }
                        z = true;
                        if (z && !u(cVar, dVar) && !h.p2.b0.g.t.b.f.h0(cVar) && !h.p2.b0.g.t.b.k.f.a.d().contains(q.a(SignatureBuildingComponents.a, p, h.p2.b0.g.t.e.b.r.c(cVar, false, false, 3, null)))) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        arrayList.add(next);
                    }
                }
                ArrayList arrayList2 = new ArrayList(u.Y(arrayList, 10));
                for (h.p2.b0.g.t.c.c cVar3 : arrayList) {
                    v.a<? extends v> x = cVar3.x();
                    x.p(dVar);
                    x.l(dVar.r());
                    x.k();
                    x.f(c2.j());
                    if (!h.p2.b0.g.t.b.k.f.a.g().contains(q.a(SignatureBuildingComponents.a, p, h.p2.b0.g.t.e.b.r.c(cVar3, false, false, 3, null)))) {
                        x.r(r());
                    }
                    v build = x.build();
                    Objects.requireNonNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                    arrayList2.add((h.p2.b0.g.t.c.c) build);
                }
                return arrayList2;
            }
            return CollectionsKt__CollectionsKt.E();
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.c.c1.a
    @k.e.a.d
    public Collection<h.p2.b0.g.t.n.z> d(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        h.p2.b0.g.t.g.d j2 = DescriptorUtilsKt.j(dVar);
        h.p2.b0.g.t.b.k.f fVar = h.p2.b0.g.t.b.k.f.a;
        return fVar.i(j2) ? CollectionsKt__CollectionsKt.L(m(), this.f16433d) : fVar.j(j2) ? t.k(this.f16433d) : CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.c.c1.a
    @k.e.a.d
    /* renamed from: o */
    public Set<h.p2.b0.g.t.g.f> e(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        LazyJavaClassMemberScope W;
        if (s().b()) {
            LazyJavaClassDescriptor p = p(dVar);
            Set<h.p2.b0.g.t.g.f> set = null;
            if (p != null && (W = p.W()) != null) {
                set = W.b();
            }
            return set == null ? d1.k() : set;
        }
        return d1.k();
    }
}
