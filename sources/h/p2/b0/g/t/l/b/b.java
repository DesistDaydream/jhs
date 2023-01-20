package h.p2.b0.g.t.l.b;

import h.k2.v.f0;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.l.b.s;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;

/* loaded from: classes3.dex */
public final class b implements h.p2.b0.g.t.l.b.a<h.p2.b0.g.t.c.b1.c, h.p2.b0.g.t.k.n.g<?>> {
    @k.e.a.d
    private final h.p2.b0.g.t.l.a a;
    @k.e.a.d
    private final c b;

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;
            iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;
            a = iArr;
        }
    }

    public b(@k.e.a.d z zVar, @k.e.a.d NotFoundClasses notFoundClasses, @k.e.a.d h.p2.b0.g.t.l.a aVar) {
        this.a = aVar;
        this.b = new c(zVar, notFoundClasses);
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<h.p2.b0.g.t.c.b1.c> a(@k.e.a.d s sVar, @k.e.a.d h.p2.b0.g.t.i.n nVar, @k.e.a.d AnnotatedCallableKind annotatedCallableKind, int i2, @k.e.a.d ProtoBuf.ValueParameter valueParameter) {
        List<ProtoBuf.Annotation> list = (List) valueParameter.getExtension(this.a.g());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(h.a2.u.Y(list, 10));
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.b.a(annotation, sVar.b()));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<h.p2.b0.g.t.c.b1.c> b(@k.e.a.d s.a aVar) {
        List<ProtoBuf.Annotation> list = (List) aVar.f().getExtension(this.a.a());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(h.a2.u.Y(list, 10));
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.b.a(annotation, aVar.b()));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<h.p2.b0.g.t.c.b1.c> c(@k.e.a.d ProtoBuf.Type type, @k.e.a.d h.p2.b0.g.t.f.z.c cVar) {
        List<ProtoBuf.Annotation> list = (List) type.getExtension(this.a.k());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(h.a2.u.Y(list, 10));
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.b.a(annotation, cVar));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<h.p2.b0.g.t.c.b1.c> d(@k.e.a.d s sVar, @k.e.a.d ProtoBuf.EnumEntry enumEntry) {
        List<ProtoBuf.Annotation> list = (List) enumEntry.getExtension(this.a.d());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(h.a2.u.Y(list, 10));
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.b.a(annotation, sVar.b()));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<h.p2.b0.g.t.c.b1.c> e(@k.e.a.d s sVar, @k.e.a.d h.p2.b0.g.t.i.n nVar, @k.e.a.d AnnotatedCallableKind annotatedCallableKind) {
        List<ProtoBuf.Annotation> list;
        if (nVar instanceof ProtoBuf.Constructor) {
            list = (List) ((ProtoBuf.Constructor) nVar).getExtension(this.a.c());
        } else if (nVar instanceof ProtoBuf.Function) {
            list = (List) ((ProtoBuf.Function) nVar).getExtension(this.a.f());
        } else if (!(nVar instanceof ProtoBuf.Property)) {
            throw new IllegalStateException(f0.C("Unknown message: ", nVar).toString());
        } else {
            int i2 = a.a[annotatedCallableKind.ordinal()];
            if (i2 == 1) {
                list = (List) ((ProtoBuf.Property) nVar).getExtension(this.a.h());
            } else if (i2 == 2) {
                list = (List) ((ProtoBuf.Property) nVar).getExtension(this.a.i());
            } else if (i2 == 3) {
                list = (List) ((ProtoBuf.Property) nVar).getExtension(this.a.j());
            } else {
                throw new IllegalStateException("Unsupported callable kind with property proto".toString());
            }
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(h.a2.u.Y(list, 10));
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.b.a(annotation, sVar.b()));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<h.p2.b0.g.t.c.b1.c> f(@k.e.a.d ProtoBuf.TypeParameter typeParameter, @k.e.a.d h.p2.b0.g.t.f.z.c cVar) {
        List<ProtoBuf.Annotation> list = (List) typeParameter.getExtension(this.a.l());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(h.a2.u.Y(list, 10));
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.b.a(annotation, cVar));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<h.p2.b0.g.t.c.b1.c> h(@k.e.a.d s sVar, @k.e.a.d ProtoBuf.Property property) {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<h.p2.b0.g.t.c.b1.c> i(@k.e.a.d s sVar, @k.e.a.d h.p2.b0.g.t.i.n nVar, @k.e.a.d AnnotatedCallableKind annotatedCallableKind) {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.d
    public List<h.p2.b0.g.t.c.b1.c> j(@k.e.a.d s sVar, @k.e.a.d ProtoBuf.Property property) {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.l.b.a
    @k.e.a.e
    /* renamed from: k */
    public h.p2.b0.g.t.k.n.g<?> g(@k.e.a.d s sVar, @k.e.a.d ProtoBuf.Property property, @k.e.a.d h.p2.b0.g.t.n.z zVar) {
        ProtoBuf.Annotation.Argument.Value value = (ProtoBuf.Annotation.Argument.Value) h.p2.b0.g.t.f.z.e.a(property, this.a.b());
        if (value == null) {
            return null;
        }
        return this.b.f(zVar, value, sVar.b());
    }
}
