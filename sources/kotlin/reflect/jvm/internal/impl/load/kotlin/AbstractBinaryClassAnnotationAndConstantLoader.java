package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import h.k2.v.f0;
import h.p2.b0.g.t.b.i;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.e.b.k;
import h.p2.b0.g.t.e.b.l;
import h.p2.b0.g.t.e.b.m;
import h.p2.b0.g.t.e.b.o;
import h.p2.b0.g.t.e.b.p;
import h.p2.b0.g.t.f.a0.f.d;
import h.p2.b0.g.t.f.a0.f.g;
import h.p2.b0.g.t.i.n;
import h.p2.b0.g.t.l.b.s;
import h.p2.b0.g.t.m.f;
import h.p2.b0.g.t.n.z;
import h.t2.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes3.dex */
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> implements h.p2.b0.g.t.l.b.a<A, C> {
    @k.e.a.d
    private final k a;
    @k.e.a.d
    private final f<m, a<A, C>> b;

    /* loaded from: classes3.dex */
    public enum PropertyRelatedElement {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD
    }

    /* loaded from: classes3.dex */
    public static final class a<A, C> {
        @k.e.a.d
        private final Map<p, List<A>> a;
        @k.e.a.d
        private final Map<p, C> b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@k.e.a.d Map<p, ? extends List<? extends A>> map, @k.e.a.d Map<p, ? extends C> map2) {
            this.a = map;
            this.b = map2;
        }

        @k.e.a.d
        public final Map<p, List<A>> a() {
            return this.a;
        }

        @k.e.a.d
        public final Map<p, C> b() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
            iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
            iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
            a = iArr;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements m.d {
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> a;
        public final /* synthetic */ HashMap<p, List<A>> b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HashMap<p, C> f16565c;

        /* loaded from: classes3.dex */
        public final class a extends b implements m.e {
            public a(@k.e.a.d p pVar) {
                super(pVar);
            }

            @Override // h.p2.b0.g.t.e.b.m.e
            @e
            public m.a b(int i2, @k.e.a.d h.p2.b0.g.t.g.b bVar, @k.e.a.d o0 o0Var) {
                p e2 = p.b.e(d(), i2);
                List<A> list = c.this.b.get(e2);
                if (list == null) {
                    list = new ArrayList<>();
                    c.this.b.put(e2, list);
                }
                return c.this.a.x(bVar, o0Var, list);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements m.c {
            @k.e.a.d
            private final p a;
            @k.e.a.d
            private final ArrayList<A> b = new ArrayList<>();

            public b(@k.e.a.d p pVar) {
                this.a = pVar;
            }

            @Override // h.p2.b0.g.t.e.b.m.c
            public void a() {
                if (!this.b.isEmpty()) {
                    c.this.b.put(this.a, this.b);
                }
            }

            @Override // h.p2.b0.g.t.e.b.m.c
            @e
            public m.a c(@k.e.a.d h.p2.b0.g.t.g.b bVar, @k.e.a.d o0 o0Var) {
                return c.this.a.x(bVar, o0Var, this.b);
            }

            @k.e.a.d
            public final p d() {
                return this.a;
            }
        }

        public c(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader, HashMap<p, List<A>> hashMap, HashMap<p, C> hashMap2) {
            this.a = abstractBinaryClassAnnotationAndConstantLoader;
            this.b = hashMap;
            this.f16565c = hashMap2;
        }

        @Override // h.p2.b0.g.t.e.b.m.d
        @e
        public m.c a(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d String str, @e Object obj) {
            C z;
            p a2 = p.b.a(fVar.b(), str);
            if (obj != null && (z = this.a.z(str, obj)) != null) {
                this.f16565c.put(a2, z);
            }
            return new b(a2);
        }

        @Override // h.p2.b0.g.t.e.b.m.d
        @e
        public m.e b(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d String str) {
            return new a(p.b.d(fVar.b(), str));
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements m.c {
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> a;
        public final /* synthetic */ ArrayList<A> b;

        public d(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader, ArrayList<A> arrayList) {
            this.a = abstractBinaryClassAnnotationAndConstantLoader;
            this.b = arrayList;
        }

        @Override // h.p2.b0.g.t.e.b.m.c
        public void a() {
        }

        @Override // h.p2.b0.g.t.e.b.m.c
        @e
        public m.a c(@k.e.a.d h.p2.b0.g.t.g.b bVar, @k.e.a.d o0 o0Var) {
            return this.a.x(bVar, o0Var, this.b);
        }
    }

    public AbstractBinaryClassAnnotationAndConstantLoader(@k.e.a.d h.p2.b0.g.t.m.m mVar, @k.e.a.d k kVar) {
        this.a = kVar;
        this.b = mVar.i(new AbstractBinaryClassAnnotationAndConstantLoader$storage$1(this));
    }

    private final List<A> A(s sVar, ProtoBuf.Property property, PropertyRelatedElement propertyRelatedElement) {
        boolean booleanValue = h.p2.b0.g.t.f.z.b.A.d(property.getFlags()).booleanValue();
        g gVar = g.a;
        boolean f2 = g.f(property);
        if (propertyRelatedElement == PropertyRelatedElement.PROPERTY) {
            p u = u(this, property, sVar.b(), sVar.d(), false, true, false, 40, null);
            return u == null ? CollectionsKt__CollectionsKt.E() : o(this, sVar, u, true, false, Boolean.valueOf(booleanValue), f2, 8, null);
        }
        p u2 = u(this, property, sVar.b(), sVar.d(), true, false, false, 48, null);
        if (u2 == null) {
            return CollectionsKt__CollectionsKt.E();
        }
        return StringsKt__StringsKt.V2(u2.a(), "$delegate", false, 2, null) != (propertyRelatedElement == PropertyRelatedElement.DELEGATE_FIELD) ? CollectionsKt__CollectionsKt.E() : n(sVar, u2, true, true, Boolean.valueOf(booleanValue), f2);
    }

    private final m C(s.a aVar) {
        o0 c2 = aVar.c();
        o oVar = c2 instanceof o ? (o) c2 : null;
        if (oVar == null) {
            return null;
        }
        return oVar.d();
    }

    private final int m(s sVar, n nVar) {
        if (nVar instanceof ProtoBuf.Function) {
            if (h.p2.b0.g.t.f.z.f.d((ProtoBuf.Function) nVar)) {
                return 1;
            }
        } else if (nVar instanceof ProtoBuf.Property) {
            if (h.p2.b0.g.t.f.z.f.e((ProtoBuf.Property) nVar)) {
                return 1;
            }
        } else if (nVar instanceof ProtoBuf.Constructor) {
            s.a aVar = (s.a) sVar;
            if (aVar.g() == ProtoBuf.Class.Kind.ENUM_CLASS) {
                return 2;
            }
            if (aVar.i()) {
                return 1;
            }
        } else {
            throw new UnsupportedOperationException(f0.C("Unsupported message: ", nVar.getClass()));
        }
        return 0;
    }

    private final List<A> n(s sVar, p pVar, boolean z, boolean z2, Boolean bool, boolean z3) {
        m p = p(sVar, v(sVar, z, z2, bool, z3));
        if (p == null) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<A> list = this.b.invoke(p).a().get(pVar);
        return list == null ? CollectionsKt__CollectionsKt.E() : list;
    }

    public static /* synthetic */ List o(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, s sVar, p pVar, boolean z, boolean z2, Boolean bool, boolean z3, int i2, Object obj) {
        if (obj == null) {
            return abstractBinaryClassAnnotationAndConstantLoader.n(sVar, pVar, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? null : bool, (i2 & 32) != 0 ? false : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    private final m p(s sVar, m mVar) {
        if (mVar != null) {
            return mVar;
        }
        if (sVar instanceof s.a) {
            return C((s.a) sVar);
        }
        return null;
    }

    private final p r(n nVar, h.p2.b0.g.t.f.z.c cVar, h.p2.b0.g.t.f.z.g gVar, AnnotatedCallableKind annotatedCallableKind, boolean z) {
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature;
        if (nVar instanceof ProtoBuf.Constructor) {
            p.a aVar = p.b;
            d.b b2 = g.a.b((ProtoBuf.Constructor) nVar, cVar, gVar);
            if (b2 == null) {
                return null;
            }
            return aVar.b(b2);
        } else if (nVar instanceof ProtoBuf.Function) {
            p.a aVar2 = p.b;
            d.b e2 = g.a.e((ProtoBuf.Function) nVar, cVar, gVar);
            if (e2 == null) {
                return null;
            }
            return aVar2.b(e2);
        } else if (!(nVar instanceof ProtoBuf.Property) || (jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) h.p2.b0.g.t.f.z.e.a((GeneratedMessageLite.ExtendableMessage) nVar, JvmProtoBuf.f16705d)) == null) {
            return null;
        } else {
            int i2 = b.a[annotatedCallableKind.ordinal()];
            if (i2 == 1) {
                if (jvmPropertySignature.hasGetter()) {
                    return p.b.c(cVar, jvmPropertySignature.getGetter());
                }
                return null;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return null;
                }
                return t((ProtoBuf.Property) nVar, cVar, gVar, true, true, z);
            } else if (jvmPropertySignature.hasSetter()) {
                return p.b.c(cVar, jvmPropertySignature.getSetter());
            } else {
                return null;
            }
        }
    }

    public static /* synthetic */ p s(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, n nVar, h.p2.b0.g.t.f.z.c cVar, h.p2.b0.g.t.f.z.g gVar, AnnotatedCallableKind annotatedCallableKind, boolean z, int i2, Object obj) {
        if (obj == null) {
            return abstractBinaryClassAnnotationAndConstantLoader.r(nVar, cVar, gVar, annotatedCallableKind, (i2 & 16) != 0 ? false : z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    private final p t(ProtoBuf.Property property, h.p2.b0.g.t.f.z.c cVar, h.p2.b0.g.t.f.z.g gVar, boolean z, boolean z2, boolean z3) {
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) h.p2.b0.g.t.f.z.e.a(property, JvmProtoBuf.f16705d);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (z) {
            d.a c2 = g.a.c(property, cVar, gVar, z3);
            if (c2 == null) {
                return null;
            }
            return p.b.b(c2);
        } else if (z2 && jvmPropertySignature.hasSyntheticMethod()) {
            return p.b.c(cVar, jvmPropertySignature.getSyntheticMethod());
        } else {
            return null;
        }
    }

    public static /* synthetic */ p u(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoBuf.Property property, h.p2.b0.g.t.f.z.c cVar, h.p2.b0.g.t.f.z.g gVar, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if (obj == null) {
            return abstractBinaryClassAnnotationAndConstantLoader.t(property, cVar, gVar, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? true : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
    }

    private final m v(s sVar, boolean z, boolean z2, Boolean bool, boolean z3) {
        s.a h2;
        if (z) {
            if (bool != null) {
                if (sVar instanceof s.a) {
                    s.a aVar = (s.a) sVar;
                    if (aVar.g() == ProtoBuf.Class.Kind.INTERFACE) {
                        return l.b(this.a, aVar.e().d(h.p2.b0.g.t.g.f.f("DefaultImpls")));
                    }
                }
                if (bool.booleanValue() && (sVar instanceof s.b)) {
                    o0 c2 = sVar.c();
                    h.p2.b0.g.t.e.b.g gVar = c2 instanceof h.p2.b0.g.t.e.b.g ? (h.p2.b0.g.t.e.b.g) c2 : null;
                    h.p2.b0.g.t.k.p.d e2 = gVar == null ? null : gVar.e();
                    if (e2 != null) {
                        return l.b(this.a, h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c(u.j2(e2.f(), Attributes.InternalPrefix, '.', false, 4, null))));
                    }
                }
            } else {
                throw new IllegalStateException(("isConst should not be null for property (container=" + sVar + ')').toString());
            }
        }
        if (z2 && (sVar instanceof s.a)) {
            s.a aVar2 = (s.a) sVar;
            if (aVar2.g() == ProtoBuf.Class.Kind.COMPANION_OBJECT && (h2 = aVar2.h()) != null && (h2.g() == ProtoBuf.Class.Kind.CLASS || h2.g() == ProtoBuf.Class.Kind.ENUM_CLASS || (z3 && (h2.g() == ProtoBuf.Class.Kind.INTERFACE || h2.g() == ProtoBuf.Class.Kind.ANNOTATION_CLASS)))) {
                return C(h2);
            }
        }
        if ((sVar instanceof s.b) && (sVar.c() instanceof h.p2.b0.g.t.e.b.g)) {
            o0 c3 = sVar.c();
            Objects.requireNonNull(c3, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
            h.p2.b0.g.t.e.b.g gVar2 = (h.p2.b0.g.t.e.b.g) c3;
            m f2 = gVar2.f();
            return f2 == null ? l.b(this.a, gVar2.d()) : f2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final m.a x(h.p2.b0.g.t.g.b bVar, o0 o0Var, List<A> list) {
        if (h.p2.b0.g.t.a.a.a().contains(bVar)) {
            return null;
        }
        return w(bVar, o0Var, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a<A, C> y(m mVar) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        mVar.a(new c(this, hashMap, hashMap2), q(mVar));
        return new a<>(hashMap, hashMap2);
    }

    @k.e.a.d
    public abstract A B(@k.e.a.d ProtoBuf.Annotation annotation, @k.e.a.d h.p2.b0.g.t.f.z.c cVar);

    @e
    public abstract C D(@k.e.a.d C c2);

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<A> a(@k.e.a.d s sVar, @k.e.a.d n nVar, @k.e.a.d AnnotatedCallableKind annotatedCallableKind, int i2, @k.e.a.d ProtoBuf.ValueParameter valueParameter) {
        p s = s(this, nVar, sVar.b(), sVar.d(), annotatedCallableKind, false, 16, null);
        if (s != null) {
            return o(this, sVar, p.b.e(s, i2 + m(sVar, nVar)), false, false, null, false, 60, null);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<A> b(@k.e.a.d s.a aVar) {
        m C = C(aVar);
        if (C != null) {
            ArrayList arrayList = new ArrayList(1);
            C.d(new d(this, arrayList), q(C));
            return arrayList;
        }
        throw new IllegalStateException(f0.C("Class for loading annotations is not found: ", aVar.a()).toString());
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<A> c(@k.e.a.d ProtoBuf.Type type, @k.e.a.d h.p2.b0.g.t.f.z.c cVar) {
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) type.getExtension(JvmProtoBuf.f16707f);
        ArrayList arrayList = new ArrayList(h.a2.u.Y(iterable, 10));
        for (ProtoBuf.Annotation annotation : iterable) {
            arrayList.add(B(annotation, cVar));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<A> d(@k.e.a.d s sVar, @k.e.a.d ProtoBuf.EnumEntry enumEntry) {
        p.a aVar = p.b;
        String string = sVar.b().getString(enumEntry.getName());
        h.p2.b0.g.t.f.a0.f.b bVar = h.p2.b0.g.t.f.a0.f.b.a;
        return o(this, sVar, aVar.a(string, h.p2.b0.g.t.f.a0.f.b.b(((s.a) sVar).e().c())), false, false, null, false, 60, null);
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<A> e(@k.e.a.d s sVar, @k.e.a.d n nVar, @k.e.a.d AnnotatedCallableKind annotatedCallableKind) {
        if (annotatedCallableKind == AnnotatedCallableKind.PROPERTY) {
            return A(sVar, (ProtoBuf.Property) nVar, PropertyRelatedElement.PROPERTY);
        }
        p s = s(this, nVar, sVar.b(), sVar.d(), annotatedCallableKind, false, 16, null);
        return s == null ? CollectionsKt__CollectionsKt.E() : o(this, sVar, s, false, false, null, false, 60, null);
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<A> f(@k.e.a.d ProtoBuf.TypeParameter typeParameter, @k.e.a.d h.p2.b0.g.t.f.z.c cVar) {
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) typeParameter.getExtension(JvmProtoBuf.f16709h);
        ArrayList arrayList = new ArrayList(h.a2.u.Y(iterable, 10));
        for (ProtoBuf.Annotation annotation : iterable) {
            arrayList.add(B(annotation, cVar));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.l.b.a
    @e
    public C g(@k.e.a.d s sVar, @k.e.a.d ProtoBuf.Property property, @k.e.a.d z zVar) {
        C c2;
        Boolean d2 = h.p2.b0.g.t.f.z.b.A.d(property.getFlags());
        g gVar = g.a;
        m p = p(sVar, v(sVar, true, true, d2, g.f(property)));
        if (p == null) {
            return null;
        }
        p r = r(property, sVar.b(), sVar.d(), AnnotatedCallableKind.PROPERTY, p.c().d().d(DeserializedDescriptorResolver.b.a()));
        if (r == null || (c2 = this.b.invoke(p).b().get(r)) == null) {
            return null;
        }
        i iVar = i.a;
        return i.d(zVar) ? D(c2) : c2;
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<A> h(@k.e.a.d s sVar, @k.e.a.d ProtoBuf.Property property) {
        return A(sVar, property, PropertyRelatedElement.BACKING_FIELD);
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<A> i(@k.e.a.d s sVar, @k.e.a.d n nVar, @k.e.a.d AnnotatedCallableKind annotatedCallableKind) {
        p s = s(this, nVar, sVar.b(), sVar.d(), annotatedCallableKind, false, 16, null);
        if (s != null) {
            return o(this, sVar, p.b.e(s, 0), false, false, null, false, 60, null);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<A> j(@k.e.a.d s sVar, @k.e.a.d ProtoBuf.Property property) {
        return A(sVar, property, PropertyRelatedElement.DELEGATE_FIELD);
    }

    @e
    public byte[] q(@k.e.a.d m mVar) {
        return null;
    }

    @e
    public abstract m.a w(@k.e.a.d h.p2.b0.g.t.g.b bVar, @k.e.a.d o0 o0Var, @k.e.a.d List<A> list);

    @e
    public abstract C z(@k.e.a.d String str, @k.e.a.d Object obj);
}
