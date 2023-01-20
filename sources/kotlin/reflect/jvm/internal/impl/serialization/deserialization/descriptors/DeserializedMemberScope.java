package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.a2.t0;
import h.a2.u;
import h.a2.x;
import h.a2.y;
import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.d.b.b;
import h.p2.b0.g.t.i.p;
import h.p2.b0.g.t.k.e;
import h.p2.b0.g.t.k.r.d;
import h.p2.b0.g.t.k.r.f;
import h.p2.b0.g.t.l.b.i;
import h.p2.b0.g.t.l.b.q;
import h.p2.b0.g.t.m.g;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.l;
import h.p2.n;
import h.t1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes3.dex */
public abstract class DeserializedMemberScope extends f {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16823f = {n0.r(new PropertyReference1Impl(n0.d(DeserializedMemberScope.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), n0.r(new PropertyReference1Impl(n0.d(DeserializedMemberScope.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    @d
    private final i b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final a f16824c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final h f16825d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final h.p2.b0.g.t.m.i f16826e;

    /* loaded from: classes3.dex */
    public final class NoReorderImplementation implements a {
        public static final /* synthetic */ n<Object>[] o = {n0.r(new PropertyReference1Impl(n0.d(NoReorderImplementation.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), n0.r(new PropertyReference1Impl(n0.d(NoReorderImplementation.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), n0.r(new PropertyReference1Impl(n0.d(NoReorderImplementation.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), n0.r(new PropertyReference1Impl(n0.d(NoReorderImplementation.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), n0.r(new PropertyReference1Impl(n0.d(NoReorderImplementation.class), "allProperties", "getAllProperties()Ljava/util/List;")), n0.r(new PropertyReference1Impl(n0.d(NoReorderImplementation.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), n0.r(new PropertyReference1Impl(n0.d(NoReorderImplementation.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), n0.r(new PropertyReference1Impl(n0.d(NoReorderImplementation.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), n0.r(new PropertyReference1Impl(n0.d(NoReorderImplementation.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), n0.r(new PropertyReference1Impl(n0.d(NoReorderImplementation.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        @d
        private final List<ProtoBuf.Function> a;
        @d
        private final List<ProtoBuf.Property> b;
        @d

        /* renamed from: c  reason: collision with root package name */
        private final List<ProtoBuf.TypeAlias> f16827c;
        @d

        /* renamed from: d  reason: collision with root package name */
        private final h f16828d;
        @d

        /* renamed from: e  reason: collision with root package name */
        private final h f16829e;
        @d

        /* renamed from: f  reason: collision with root package name */
        private final h f16830f;
        @d

        /* renamed from: g  reason: collision with root package name */
        private final h f16831g;
        @d

        /* renamed from: h  reason: collision with root package name */
        private final h f16832h;
        @d

        /* renamed from: i  reason: collision with root package name */
        private final h f16833i;
        @d

        /* renamed from: j  reason: collision with root package name */
        private final h f16834j;
        @d

        /* renamed from: k  reason: collision with root package name */
        private final h f16835k;
        @d

        /* renamed from: l  reason: collision with root package name */
        private final h f16836l;
        @d

        /* renamed from: m  reason: collision with root package name */
        private final h f16837m;

        public NoReorderImplementation(@d List<ProtoBuf.Function> list, @d List<ProtoBuf.Property> list2, @d List<ProtoBuf.TypeAlias> list3) {
            this.a = list;
            this.b = list2;
            this.f16827c = DeserializedMemberScope.this.r().c().g().c() ? list3 : CollectionsKt__CollectionsKt.E();
            this.f16828d = DeserializedMemberScope.this.r().h().c(new DeserializedMemberScope$NoReorderImplementation$declaredFunctions$2(this));
            this.f16829e = DeserializedMemberScope.this.r().h().c(new DeserializedMemberScope$NoReorderImplementation$declaredProperties$2(this));
            this.f16830f = DeserializedMemberScope.this.r().h().c(new DeserializedMemberScope$NoReorderImplementation$allTypeAliases$2(this));
            this.f16831g = DeserializedMemberScope.this.r().h().c(new DeserializedMemberScope$NoReorderImplementation$allFunctions$2(this));
            this.f16832h = DeserializedMemberScope.this.r().h().c(new DeserializedMemberScope$NoReorderImplementation$allProperties$2(this));
            this.f16833i = DeserializedMemberScope.this.r().h().c(new DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2(this));
            this.f16834j = DeserializedMemberScope.this.r().h().c(new DeserializedMemberScope$NoReorderImplementation$functionsByName$2(this));
            this.f16835k = DeserializedMemberScope.this.r().h().c(new DeserializedMemberScope$NoReorderImplementation$propertiesByName$2(this));
            this.f16836l = DeserializedMemberScope.this.r().h().c(new DeserializedMemberScope$NoReorderImplementation$functionNames$2(this, DeserializedMemberScope.this));
            this.f16837m = DeserializedMemberScope.this.r().h().c(new DeserializedMemberScope$NoReorderImplementation$variableNames$2(this, DeserializedMemberScope.this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<h.p2.b0.g.t.c.n0> A() {
            return (List) l.a(this.f16831g, this, o[3]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<j0> B() {
            return (List) l.a(this.f16832h, this, o[4]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<s0> C() {
            return (List) l.a(this.f16830f, this, o[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<h.p2.b0.g.t.c.n0> D() {
            return (List) l.a(this.f16828d, this, o[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<j0> E() {
            return (List) l.a(this.f16829e, this, o[1]);
        }

        private final Map<h.p2.b0.g.t.g.f, Collection<h.p2.b0.g.t.c.n0>> F() {
            return (Map) l.a(this.f16834j, this, o[6]);
        }

        private final Map<h.p2.b0.g.t.g.f, Collection<j0>> G() {
            return (Map) l.a(this.f16835k, this, o[7]);
        }

        private final Map<h.p2.b0.g.t.g.f, s0> H() {
            return (Map) l.a(this.f16833i, this, o[5]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<h.p2.b0.g.t.c.n0> t() {
            Set<h.p2.b0.g.t.g.f> v = DeserializedMemberScope.this.v();
            ArrayList arrayList = new ArrayList();
            for (h.p2.b0.g.t.g.f fVar : v) {
                y.q0(arrayList, w(fVar));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<j0> u() {
            Set<h.p2.b0.g.t.g.f> w = DeserializedMemberScope.this.w();
            ArrayList arrayList = new ArrayList();
            for (h.p2.b0.g.t.g.f fVar : w) {
                y.q0(arrayList, x(fVar));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<h.p2.b0.g.t.c.n0> v() {
            List<ProtoBuf.Function> list = this.a;
            DeserializedMemberScope deserializedMemberScope = DeserializedMemberScope.this;
            ArrayList arrayList = new ArrayList();
            for (h.p2.b0.g.t.i.n nVar : list) {
                h.p2.b0.g.t.c.n0 n = deserializedMemberScope.b.f().n((ProtoBuf.Function) nVar);
                if (!deserializedMemberScope.z(n)) {
                    n = null;
                }
                if (n != null) {
                    arrayList.add(n);
                }
            }
            return arrayList;
        }

        private final List<h.p2.b0.g.t.c.n0> w(h.p2.b0.g.t.g.f fVar) {
            List<h.p2.b0.g.t.c.n0> D = D();
            DeserializedMemberScope deserializedMemberScope = DeserializedMemberScope.this;
            ArrayList arrayList = new ArrayList();
            for (Object obj : D) {
                if (f0.g(((k) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            deserializedMemberScope.m(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        private final List<j0> x(h.p2.b0.g.t.g.f fVar) {
            List<j0> E = E();
            DeserializedMemberScope deserializedMemberScope = DeserializedMemberScope.this;
            ArrayList arrayList = new ArrayList();
            for (Object obj : E) {
                if (f0.g(((k) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            deserializedMemberScope.n(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<j0> y() {
            List<ProtoBuf.Property> list = this.b;
            DeserializedMemberScope deserializedMemberScope = DeserializedMemberScope.this;
            ArrayList arrayList = new ArrayList();
            for (h.p2.b0.g.t.i.n nVar : list) {
                j0 p = deserializedMemberScope.b.f().p((ProtoBuf.Property) nVar);
                if (p != null) {
                    arrayList.add(p);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<s0> z() {
            List<ProtoBuf.TypeAlias> list = this.f16827c;
            DeserializedMemberScope deserializedMemberScope = DeserializedMemberScope.this;
            ArrayList arrayList = new ArrayList();
            for (h.p2.b0.g.t.i.n nVar : list) {
                s0 q = deserializedMemberScope.b.f().q((ProtoBuf.TypeAlias) nVar);
                if (q != null) {
                    arrayList.add(q);
                }
            }
            return arrayList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @d
        public Collection<h.p2.b0.g.t.c.n0> a(@d h.p2.b0.g.t.g.f fVar, @d b bVar) {
            Collection<h.p2.b0.g.t.c.n0> collection;
            return (b().contains(fVar) && (collection = F().get(fVar)) != null) ? collection : CollectionsKt__CollectionsKt.E();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @d
        public Set<h.p2.b0.g.t.g.f> b() {
            return (Set) l.a(this.f16836l, this, o[8]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @d
        public Collection<j0> c(@d h.p2.b0.g.t.g.f fVar, @d b bVar) {
            Collection<j0> collection;
            return (d().contains(fVar) && (collection = G().get(fVar)) != null) ? collection : CollectionsKt__CollectionsKt.E();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @d
        public Set<h.p2.b0.g.t.g.f> d() {
            return (Set) l.a(this.f16837m, this, o[9]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @d
        public Set<h.p2.b0.g.t.g.f> e() {
            List<ProtoBuf.TypeAlias> list = this.f16827c;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = DeserializedMemberScope.this;
            for (h.p2.b0.g.t.i.n nVar : list) {
                linkedHashSet.add(q.b(deserializedMemberScope.b.g(), ((ProtoBuf.TypeAlias) nVar).getName()));
            }
            return linkedHashSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        public void f(@d Collection<k> collection, @d h.p2.b0.g.t.k.r.d dVar, @d h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar, @d b bVar) {
            if (dVar.a(h.p2.b0.g.t.k.r.d.f15480c.i())) {
                for (Object obj : B()) {
                    if (lVar.invoke(((j0) obj).getName()).booleanValue()) {
                        collection.add(obj);
                    }
                }
            }
            if (dVar.a(h.p2.b0.g.t.k.r.d.f15480c.d())) {
                for (Object obj2 : A()) {
                    if (lVar.invoke(((h.p2.b0.g.t.c.n0) obj2).getName()).booleanValue()) {
                        collection.add(obj2);
                    }
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @e
        public s0 g(@d h.p2.b0.g.t.g.f fVar) {
            return H().get(fVar);
        }
    }

    /* loaded from: classes3.dex */
    public final class OptimizedImplementation implements a {

        /* renamed from: j  reason: collision with root package name */
        public static final /* synthetic */ n<Object>[] f16838j = {n0.r(new PropertyReference1Impl(n0.d(OptimizedImplementation.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), n0.r(new PropertyReference1Impl(n0.d(OptimizedImplementation.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        @d
        private final Map<h.p2.b0.g.t.g.f, byte[]> a;
        @d
        private final Map<h.p2.b0.g.t.g.f, byte[]> b;
        @d

        /* renamed from: c  reason: collision with root package name */
        private final Map<h.p2.b0.g.t.g.f, byte[]> f16839c;
        @d

        /* renamed from: d  reason: collision with root package name */
        private final h.p2.b0.g.t.m.f<h.p2.b0.g.t.g.f, Collection<h.p2.b0.g.t.c.n0>> f16840d;
        @d

        /* renamed from: e  reason: collision with root package name */
        private final h.p2.b0.g.t.m.f<h.p2.b0.g.t.g.f, Collection<j0>> f16841e;
        @d

        /* renamed from: f  reason: collision with root package name */
        private final g<h.p2.b0.g.t.g.f, s0> f16842f;
        @d

        /* renamed from: g  reason: collision with root package name */
        private final h f16843g;
        @d

        /* renamed from: h  reason: collision with root package name */
        private final h f16844h;

        public OptimizedImplementation(@d List<ProtoBuf.Function> list, @d List<ProtoBuf.Property> list2, @d List<ProtoBuf.TypeAlias> list3) {
            Map<h.p2.b0.g.t.g.f, byte[]> z;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                h.p2.b0.g.t.g.f b = q.b(DeserializedMemberScope.this.b.g(), ((ProtoBuf.Function) ((h.p2.b0.g.t.i.n) obj)).getName());
                Object obj2 = linkedHashMap.get(b);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(b, obj2);
                }
                ((List) obj2).add(obj);
            }
            this.a = p(linkedHashMap);
            DeserializedMemberScope deserializedMemberScope = DeserializedMemberScope.this;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list2) {
                h.p2.b0.g.t.g.f b2 = q.b(deserializedMemberScope.b.g(), ((ProtoBuf.Property) ((h.p2.b0.g.t.i.n) obj3)).getName());
                Object obj4 = linkedHashMap2.get(b2);
                if (obj4 == null) {
                    obj4 = new ArrayList();
                    linkedHashMap2.put(b2, obj4);
                }
                ((List) obj4).add(obj3);
            }
            this.b = p(linkedHashMap2);
            if (DeserializedMemberScope.this.r().c().g().c()) {
                DeserializedMemberScope deserializedMemberScope2 = DeserializedMemberScope.this;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj5 : list3) {
                    h.p2.b0.g.t.g.f b3 = q.b(deserializedMemberScope2.b.g(), ((ProtoBuf.TypeAlias) ((h.p2.b0.g.t.i.n) obj5)).getName());
                    Object obj6 = linkedHashMap3.get(b3);
                    if (obj6 == null) {
                        obj6 = new ArrayList();
                        linkedHashMap3.put(b3, obj6);
                    }
                    ((List) obj6).add(obj5);
                }
                z = p(linkedHashMap3);
            } else {
                z = t0.z();
            }
            this.f16839c = z;
            this.f16840d = DeserializedMemberScope.this.r().h().i(new DeserializedMemberScope$OptimizedImplementation$functions$1(this));
            this.f16841e = DeserializedMemberScope.this.r().h().i(new DeserializedMemberScope$OptimizedImplementation$properties$1(this));
            this.f16842f = DeserializedMemberScope.this.r().h().g(new DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1(this));
            this.f16843g = DeserializedMemberScope.this.r().h().c(new DeserializedMemberScope$OptimizedImplementation$functionNames$2(this, DeserializedMemberScope.this));
            this.f16844h = DeserializedMemberScope.this.r().h().c(new DeserializedMemberScope$OptimizedImplementation$variableNames$2(this, DeserializedMemberScope.this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<h.p2.b0.g.t.c.n0> m(h.p2.b0.g.t.g.f fVar) {
            Map<h.p2.b0.g.t.g.f, byte[]> map = this.a;
            p<ProtoBuf.Function> pVar = ProtoBuf.Function.PARSER;
            DeserializedMemberScope deserializedMemberScope = DeserializedMemberScope.this;
            byte[] bArr = map.get(fVar);
            List<ProtoBuf.Function> V2 = bArr == null ? null : SequencesKt___SequencesKt.V2(SequencesKt__SequencesKt.p(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(pVar, new ByteArrayInputStream(bArr), DeserializedMemberScope.this)));
            if (V2 == null) {
                V2 = CollectionsKt__CollectionsKt.E();
            }
            ArrayList arrayList = new ArrayList(V2.size());
            for (ProtoBuf.Function function : V2) {
                h.p2.b0.g.t.c.n0 n = deserializedMemberScope.r().f().n(function);
                if (!deserializedMemberScope.z(n)) {
                    n = null;
                }
                if (n != null) {
                    arrayList.add(n);
                }
            }
            deserializedMemberScope.m(fVar, arrayList);
            return h.p2.b0.g.t.p.a.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<j0> n(h.p2.b0.g.t.g.f fVar) {
            Map<h.p2.b0.g.t.g.f, byte[]> map = this.b;
            p<ProtoBuf.Property> pVar = ProtoBuf.Property.PARSER;
            DeserializedMemberScope deserializedMemberScope = DeserializedMemberScope.this;
            byte[] bArr = map.get(fVar);
            List<ProtoBuf.Property> V2 = bArr == null ? null : SequencesKt___SequencesKt.V2(SequencesKt__SequencesKt.p(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(pVar, new ByteArrayInputStream(bArr), DeserializedMemberScope.this)));
            if (V2 == null) {
                V2 = CollectionsKt__CollectionsKt.E();
            }
            ArrayList arrayList = new ArrayList(V2.size());
            for (ProtoBuf.Property property : V2) {
                j0 p = deserializedMemberScope.r().f().p(property);
                if (p != null) {
                    arrayList.add(p);
                }
            }
            deserializedMemberScope.n(fVar, arrayList);
            return h.p2.b0.g.t.p.a.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final s0 o(h.p2.b0.g.t.g.f fVar) {
            ProtoBuf.TypeAlias parseDelimitedFrom;
            byte[] bArr = this.f16839c.get(fVar);
            if (bArr == null || (parseDelimitedFrom = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(bArr), DeserializedMemberScope.this.r().c().j())) == null) {
                return null;
            }
            return DeserializedMemberScope.this.r().f().q(parseDelimitedFrom);
        }

        private final Map<h.p2.b0.g.t.g.f, byte[]> p(Map<h.p2.b0.g.t.g.f, ? extends Collection<? extends h.p2.b0.g.t.i.a>> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(h.a2.s0.j(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable<h.p2.b0.g.t.i.a> iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(u.Y(iterable, 10));
                for (h.p2.b0.g.t.i.a aVar : iterable) {
                    aVar.writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(t1.a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @d
        public Collection<h.p2.b0.g.t.c.n0> a(@d h.p2.b0.g.t.g.f fVar, @d b bVar) {
            return !b().contains(fVar) ? CollectionsKt__CollectionsKt.E() : this.f16840d.invoke(fVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @d
        public Set<h.p2.b0.g.t.g.f> b() {
            return (Set) l.a(this.f16843g, this, f16838j[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @d
        public Collection<j0> c(@d h.p2.b0.g.t.g.f fVar, @d b bVar) {
            return !d().contains(fVar) ? CollectionsKt__CollectionsKt.E() : this.f16841e.invoke(fVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @d
        public Set<h.p2.b0.g.t.g.f> d() {
            return (Set) l.a(this.f16844h, this, f16838j[1]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @d
        public Set<h.p2.b0.g.t.g.f> e() {
            return this.f16839c.keySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        public void f(@d Collection<k> collection, @d h.p2.b0.g.t.k.r.d dVar, @d h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar, @d b bVar) {
            if (dVar.a(h.p2.b0.g.t.k.r.d.f15480c.i())) {
                Set<h.p2.b0.g.t.g.f> d2 = d();
                ArrayList arrayList = new ArrayList();
                for (h.p2.b0.g.t.g.f fVar : d2) {
                    if (lVar.invoke(fVar).booleanValue()) {
                        arrayList.addAll(c(fVar, bVar));
                    }
                }
                x.p0(arrayList, e.b.a);
                collection.addAll(arrayList);
            }
            if (dVar.a(h.p2.b0.g.t.k.r.d.f15480c.d())) {
                Set<h.p2.b0.g.t.g.f> b = b();
                ArrayList arrayList2 = new ArrayList();
                for (h.p2.b0.g.t.g.f fVar2 : b) {
                    if (lVar.invoke(fVar2).booleanValue()) {
                        arrayList2.addAll(a(fVar2, bVar));
                    }
                }
                x.p0(arrayList2, e.b.a);
                collection.addAll(arrayList2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @k.e.a.e
        public s0 g(@d h.p2.b0.g.t.g.f fVar) {
            return this.f16842f.invoke(fVar);
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        @d
        Collection<h.p2.b0.g.t.c.n0> a(@d h.p2.b0.g.t.g.f fVar, @d b bVar);

        @d
        Set<h.p2.b0.g.t.g.f> b();

        @d
        Collection<j0> c(@d h.p2.b0.g.t.g.f fVar, @d b bVar);

        @d
        Set<h.p2.b0.g.t.g.f> d();

        @d
        Set<h.p2.b0.g.t.g.f> e();

        void f(@d Collection<k> collection, @d h.p2.b0.g.t.k.r.d dVar, @d h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar, @d b bVar);

        @k.e.a.e
        s0 g(@d h.p2.b0.g.t.g.f fVar);
    }

    public DeserializedMemberScope(@d i iVar, @d List<ProtoBuf.Function> list, @d List<ProtoBuf.Property> list2, @d List<ProtoBuf.TypeAlias> list3, @d h.k2.u.a<? extends Collection<h.p2.b0.g.t.g.f>> aVar) {
        this.b = iVar;
        this.f16824c = p(list, list2, list3);
        this.f16825d = iVar.h().c(new DeserializedMemberScope$classNames$2(aVar));
        this.f16826e = iVar.h().e(new DeserializedMemberScope$classifierNamesLazy$2(this));
    }

    private final a p(List<ProtoBuf.Function> list, List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3) {
        if (this.b.c().g().a()) {
            return new NoReorderImplementation(list, list2, list3);
        }
        return new OptimizedImplementation(list, list2, list3);
    }

    private final h.p2.b0.g.t.c.d q(h.p2.b0.g.t.g.f fVar) {
        return this.b.c().b(o(fVar));
    }

    private final Set<h.p2.b0.g.t.g.f> t() {
        return (Set) l.b(this.f16826e, this, f16823f[1]);
    }

    private final s0 x(h.p2.b0.g.t.g.f fVar) {
        return this.f16824c.g(fVar);
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, h.p2.b0.g.t.k.r.h
    @d
    public Collection<h.p2.b0.g.t.c.n0> a(@d h.p2.b0.g.t.g.f fVar, @d b bVar) {
        return this.f16824c.a(fVar, bVar);
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Set<h.p2.b0.g.t.g.f> b() {
        return this.f16824c.b();
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Collection<j0> c(@d h.p2.b0.g.t.g.f fVar, @d b bVar) {
        return this.f16824c.c(fVar, bVar);
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Set<h.p2.b0.g.t.g.f> d() {
        return this.f16824c.d();
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.e
    public Set<h.p2.b0.g.t.g.f> e() {
        return t();
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    @k.e.a.e
    public h.p2.b0.g.t.c.f f(@d h.p2.b0.g.t.g.f fVar, @d b bVar) {
        if (y(fVar)) {
            return q(fVar);
        }
        if (this.f16824c.e().contains(fVar)) {
            return x(fVar);
        }
        return null;
    }

    public abstract void k(@d Collection<k> collection, @d h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar);

    @d
    public final Collection<k> l(@d h.p2.b0.g.t.k.r.d dVar, @d h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar, @d b bVar) {
        ArrayList arrayList = new ArrayList(0);
        d.a aVar = h.p2.b0.g.t.k.r.d.f15480c;
        if (dVar.a(aVar.g())) {
            k(arrayList, lVar);
        }
        this.f16824c.f(arrayList, dVar, lVar, bVar);
        if (dVar.a(aVar.c())) {
            for (h.p2.b0.g.t.g.f fVar : s()) {
                if (lVar.invoke(fVar).booleanValue()) {
                    h.p2.b0.g.t.p.a.a(arrayList, q(fVar));
                }
            }
        }
        if (dVar.a(h.p2.b0.g.t.k.r.d.f15480c.h())) {
            for (h.p2.b0.g.t.g.f fVar2 : this.f16824c.e()) {
                if (lVar.invoke(fVar2).booleanValue()) {
                    h.p2.b0.g.t.p.a.a(arrayList, this.f16824c.g(fVar2));
                }
            }
        }
        return h.p2.b0.g.t.p.a.c(arrayList);
    }

    public void m(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d List<h.p2.b0.g.t.c.n0> list) {
    }

    public void n(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d List<j0> list) {
    }

    @k.e.a.d
    public abstract h.p2.b0.g.t.g.b o(@k.e.a.d h.p2.b0.g.t.g.f fVar);

    @k.e.a.d
    public final i r() {
        return this.b;
    }

    @k.e.a.d
    public final Set<h.p2.b0.g.t.g.f> s() {
        return (Set) l.a(this.f16825d, this, f16823f[0]);
    }

    @k.e.a.e
    public abstract Set<h.p2.b0.g.t.g.f> u();

    @k.e.a.d
    public abstract Set<h.p2.b0.g.t.g.f> v();

    @k.e.a.d
    public abstract Set<h.p2.b0.g.t.g.f> w();

    public boolean y(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
        return s().contains(fVar);
    }

    public boolean z(@k.e.a.d h.p2.b0.g.t.c.n0 n0Var) {
        return true;
    }
}
