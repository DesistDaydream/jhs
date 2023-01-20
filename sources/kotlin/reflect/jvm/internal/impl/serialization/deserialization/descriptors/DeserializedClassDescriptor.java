package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.a2.e1;
import h.a2.s0;
import h.a2.u;
import h.a2.y;
import h.k2.u.l;
import h.o2.q;
import h.p2.b0.g.t.c.c;
import h.p2.b0.g.t.c.d1.a;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.r0;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.t;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.k.r.f;
import h.p2.b0.g.t.k.r.h;
import h.p2.b0.g.t.l.b.i;
import h.p2.b0.g.t.l.b.s;
import h.p2.b0.g.t.l.b.x.j;
import h.p2.b0.g.t.m.g;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;

/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor extends a implements t {
    @d

    /* renamed from: g  reason: collision with root package name */
    private final ProtoBuf.Class f16808g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final h.p2.b0.g.t.f.z.a f16809h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final o0 f16810i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final b f16811j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final Modality f16812k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private final s f16813l;
    @d

    /* renamed from: m  reason: collision with root package name */
    private final ClassKind f16814m;
    @d
    private final i n;
    @d
    private final f o;
    @d
    private final DeserializedClassTypeConstructor p;
    @d
    private final ScopesHolderForClass<DeserializedClassMemberScope> q;
    @e
    private final EnumEntryClassDescriptors r;
    @d
    private final k s;
    @d
    private final h.p2.b0.g.t.m.i<c> t;
    @d
    private final h<Collection<c>> u;
    @d
    private final h.p2.b0.g.t.m.i<h.p2.b0.g.t.c.d> v;
    @d
    private final h<Collection<h.p2.b0.g.t.c.d>> w;
    @d
    private final s.a x;
    @d
    private final h.p2.b0.g.t.c.b1.e y;

    /* loaded from: classes3.dex */
    public final class DeserializedClassMemberScope extends DeserializedMemberScope {
        @d

        /* renamed from: g  reason: collision with root package name */
        private final h.p2.b0.g.t.n.e1.h f16815g;
        @d

        /* renamed from: h  reason: collision with root package name */
        private final h<Collection<k>> f16816h;
        @d

        /* renamed from: i  reason: collision with root package name */
        private final h<Collection<z>> f16817i;

        /* loaded from: classes3.dex */
        public static final class a extends h.p2.b0.g.t.k.f {
            public final /* synthetic */ List<D> a;

            public a(List<D> list) {
                this.a = list;
            }

            @Override // h.p2.b0.g.t.k.g
            public void a(@d CallableMemberDescriptor callableMemberDescriptor) {
                OverridingUtil.L(callableMemberDescriptor, null);
                this.a.add(callableMemberDescriptor);
            }

            @Override // h.p2.b0.g.t.k.f
            public void e(@d CallableMemberDescriptor callableMemberDescriptor, @d CallableMemberDescriptor callableMemberDescriptor2) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public DeserializedClassMemberScope(@k.e.a.d h.p2.b0.g.t.n.e1.h r9) {
            /*
                r7 = this;
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this = r8
                h.p2.b0.g.t.l.b.i r1 = r8.S0()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.T0()
                java.util.List r2 = r0.getFunctionList()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.T0()
                java.util.List r3 = r0.getPropertyList()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.T0()
                java.util.List r4 = r0.getTypeAliasList()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.T0()
                java.util.List r0 = r0.getNestedClassNameList()
                h.p2.b0.g.t.l.b.i r8 = r8.S0()
                h.p2.b0.g.t.f.z.c r8 = r8.g()
                java.util.ArrayList r5 = new java.util.ArrayList
                r6 = 10
                int r6 = h.a2.u.Y(r0, r6)
                r5.<init>(r6)
                java.util.Iterator r0 = r0.iterator()
            L3d:
                boolean r6 = r0.hasNext()
                if (r6 == 0) goto L55
                java.lang.Object r6 = r0.next()
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                h.p2.b0.g.t.g.f r6 = h.p2.b0.g.t.l.b.q.b(r8, r6)
                r5.add(r6)
                goto L3d
            L55:
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$2$1 r8 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$2$1
                r8.<init>(r5)
                r0 = r7
                r5 = r8
                r0.<init>(r1, r2, r3, r4, r5)
                r7.f16815g = r9
                h.p2.b0.g.t.l.b.i r8 = r7.r()
                h.p2.b0.g.t.m.m r8 = r8.h()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1 r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1
                r9.<init>(r7)
                h.p2.b0.g.t.m.h r8 = r8.c(r9)
                r7.f16816h = r8
                h.p2.b0.g.t.l.b.i r8 = r7.r()
                h.p2.b0.g.t.m.m r8 = r8.h()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1 r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1
                r9.<init>(r7)
                h.p2.b0.g.t.m.h r8 = r8.c(r9)
                r7.f16817i = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor, h.p2.b0.g.t.n.e1.h):void");
        }

        private final <D extends CallableMemberDescriptor> void C(h.p2.b0.g.t.g.f fVar, Collection<? extends D> collection, List<D> list) {
            r().c().m().a().w(fVar, collection, new ArrayList(list), D(), new a(list));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DeserializedClassDescriptor D() {
            return DeserializedClassDescriptor.this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, h.p2.b0.g.t.k.r.h
        @d
        public Collection<n0> a(@d h.p2.b0.g.t.g.f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
            h(fVar, bVar);
            return super.a(fVar, bVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @d
        public Collection<j0> c(@d h.p2.b0.g.t.g.f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
            h(fVar, bVar);
            return super.c(fVar, bVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
        @e
        public h.p2.b0.g.t.c.f f(@d h.p2.b0.g.t.g.f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
            h.p2.b0.g.t.c.d f2;
            h(fVar, bVar);
            EnumEntryClassDescriptors enumEntryClassDescriptors = D().r;
            return (enumEntryClassDescriptors == null || (f2 = enumEntryClassDescriptors.f(fVar)) == null) ? super.f(fVar, bVar) : f2;
        }

        @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
        @d
        public Collection<k> g(@d h.p2.b0.g.t.k.r.d dVar, @d l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
            return this.f16816h.invoke();
        }

        @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
        public void h(@d h.p2.b0.g.t.g.f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
            h.p2.b0.g.t.d.a.a(r().c().o(), bVar, D(), fVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void k(@d Collection<k> collection, @d l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
            EnumEntryClassDescriptors enumEntryClassDescriptors = D().r;
            Collection<h.p2.b0.g.t.c.d> d2 = enumEntryClassDescriptors == null ? null : enumEntryClassDescriptors.d();
            if (d2 == null) {
                d2 = CollectionsKt__CollectionsKt.E();
            }
            collection.addAll(d2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void m(@d h.p2.b0.g.t.g.f fVar, @d List<n0> list) {
            ArrayList arrayList = new ArrayList();
            for (z zVar : this.f16817i.invoke()) {
                arrayList.addAll(zVar.q().a(fVar, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            list.addAll(r().c().c().a(fVar, DeserializedClassDescriptor.this));
            C(fVar, arrayList, list);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void n(@d h.p2.b0.g.t.g.f fVar, @d List<j0> list) {
            ArrayList arrayList = new ArrayList();
            for (z zVar : this.f16817i.invoke()) {
                arrayList.addAll(zVar.q().c(fVar, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            C(fVar, arrayList, list);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @d
        public b o(@d h.p2.b0.g.t.g.f fVar) {
            return DeserializedClassDescriptor.this.f16811j.d(fVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @e
        public Set<h.p2.b0.g.t.g.f> u() {
            List<z> j2 = D().p.j();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (z zVar : j2) {
                Set<h.p2.b0.g.t.g.f> e2 = zVar.q().e();
                if (e2 == null) {
                    return null;
                }
                y.q0(linkedHashSet, e2);
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @d
        public Set<h.p2.b0.g.t.g.f> v() {
            List<z> j2 = D().p.j();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (z zVar : j2) {
                y.q0(linkedHashSet, zVar.q().b());
            }
            linkedHashSet.addAll(r().c().c().e(DeserializedClassDescriptor.this));
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @d
        public Set<h.p2.b0.g.t.g.f> w() {
            List<z> j2 = D().p.j();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (z zVar : j2) {
                y.q0(linkedHashSet, zVar.q().d());
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public boolean z(@d n0 n0Var) {
            return r().c().s().b(DeserializedClassDescriptor.this, n0Var);
        }
    }

    /* loaded from: classes3.dex */
    public final class DeserializedClassTypeConstructor extends h.p2.b0.g.t.n.b {
        @d

        /* renamed from: d  reason: collision with root package name */
        private final h<List<t0>> f16819d;

        public DeserializedClassTypeConstructor() {
            super(DeserializedClassDescriptor.this.S0().h());
            this.f16819d = DeserializedClassDescriptor.this.S0().h().c(new DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1(DeserializedClassDescriptor.this));
        }

        @Override // h.p2.b0.g.t.n.q0
        public boolean d() {
            return true;
        }

        @Override // h.p2.b0.g.t.n.q0
        @d
        public List<t0> getParameters() {
            return this.f16819d.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @d
        public Collection<z> h() {
            h.p2.b0.g.t.g.c b;
            List<ProtoBuf.Type> k2 = h.p2.b0.g.t.f.z.f.k(DeserializedClassDescriptor.this.T0(), DeserializedClassDescriptor.this.S0().j());
            DeserializedClassDescriptor deserializedClassDescriptor = DeserializedClassDescriptor.this;
            ArrayList arrayList = new ArrayList(u.Y(k2, 10));
            for (ProtoBuf.Type type : k2) {
                arrayList.add(deserializedClassDescriptor.S0().i().p(type));
            }
            List q4 = CollectionsKt___CollectionsKt.q4(arrayList, DeserializedClassDescriptor.this.S0().c().c().d(DeserializedClassDescriptor.this));
            ArrayList<NotFoundClasses.b> arrayList2 = new ArrayList();
            Iterator it = q4.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h.p2.b0.g.t.c.f c2 = ((z) it.next()).I0().c();
                NotFoundClasses.b bVar = c2 instanceof NotFoundClasses.b ? (NotFoundClasses.b) c2 : null;
                if (bVar != null) {
                    arrayList2.add(bVar);
                }
            }
            if (!arrayList2.isEmpty()) {
                h.p2.b0.g.t.l.b.l i2 = DeserializedClassDescriptor.this.S0().c().i();
                DeserializedClassDescriptor deserializedClassDescriptor2 = DeserializedClassDescriptor.this;
                ArrayList arrayList3 = new ArrayList(u.Y(arrayList2, 10));
                for (NotFoundClasses.b bVar2 : arrayList2) {
                    b h2 = DescriptorUtilsKt.h(bVar2);
                    String b2 = (h2 == null || (b = h2.b()) == null) ? null : b.b();
                    if (b2 == null) {
                        b2 = bVar2.getName().b();
                    }
                    arrayList3.add(b2);
                }
                i2.b(deserializedClassDescriptor2, arrayList3);
            }
            return CollectionsKt___CollectionsKt.I5(q4);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @d
        public r0 n() {
            return r0.a.a;
        }

        @d
        public String toString() {
            return DeserializedClassDescriptor.this.getName().toString();
        }

        @Override // h.p2.b0.g.t.n.b
        @d
        /* renamed from: w */
        public DeserializedClassDescriptor v() {
            return DeserializedClassDescriptor.this;
        }
    }

    /* loaded from: classes3.dex */
    public final class EnumEntryClassDescriptors {
        @d
        private final Map<h.p2.b0.g.t.g.f, ProtoBuf.EnumEntry> a;
        @d
        private final g<h.p2.b0.g.t.g.f, h.p2.b0.g.t.c.d> b;
        @d

        /* renamed from: c  reason: collision with root package name */
        private final h<Set<h.p2.b0.g.t.g.f>> f16821c;

        public EnumEntryClassDescriptors() {
            List<ProtoBuf.EnumEntry> enumEntryList = DeserializedClassDescriptor.this.T0().getEnumEntryList();
            LinkedHashMap linkedHashMap = new LinkedHashMap(q.n(s0.j(u.Y(enumEntryList, 10)), 16));
            for (Object obj : enumEntryList) {
                linkedHashMap.put(h.p2.b0.g.t.l.b.q.b(DeserializedClassDescriptor.this.S0().g(), ((ProtoBuf.EnumEntry) obj).getName()), obj);
            }
            this.a = linkedHashMap;
            this.b = DeserializedClassDescriptor.this.S0().h().g(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(this, DeserializedClassDescriptor.this));
            this.f16821c = DeserializedClassDescriptor.this.S0().h().c(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<h.p2.b0.g.t.g.f> e() {
            HashSet hashSet = new HashSet();
            for (z zVar : DeserializedClassDescriptor.this.j().j()) {
                for (k kVar : h.a.a(zVar.q(), null, null, 3, null)) {
                    if ((kVar instanceof n0) || (kVar instanceof j0)) {
                        hashSet.add(kVar.getName());
                    }
                }
            }
            List<ProtoBuf.Function> functionList = DeserializedClassDescriptor.this.T0().getFunctionList();
            DeserializedClassDescriptor deserializedClassDescriptor = DeserializedClassDescriptor.this;
            for (ProtoBuf.Function function : functionList) {
                hashSet.add(h.p2.b0.g.t.l.b.q.b(deserializedClassDescriptor.S0().g(), function.getName()));
            }
            List<ProtoBuf.Property> propertyList = DeserializedClassDescriptor.this.T0().getPropertyList();
            DeserializedClassDescriptor deserializedClassDescriptor2 = DeserializedClassDescriptor.this;
            for (ProtoBuf.Property property : propertyList) {
                hashSet.add(h.p2.b0.g.t.l.b.q.b(deserializedClassDescriptor2.S0().g(), property.getName()));
            }
            return e1.C(hashSet, hashSet);
        }

        @d
        public final Collection<h.p2.b0.g.t.c.d> d() {
            Set<h.p2.b0.g.t.g.f> keySet = this.a.keySet();
            ArrayList arrayList = new ArrayList();
            for (h.p2.b0.g.t.g.f fVar : keySet) {
                h.p2.b0.g.t.c.d f2 = f(fVar);
                if (f2 != null) {
                    arrayList.add(f2);
                }
            }
            return arrayList;
        }

        @e
        public final h.p2.b0.g.t.c.d f(@d h.p2.b0.g.t.g.f fVar) {
            return this.b.invoke(fVar);
        }
    }

    public DeserializedClassDescriptor(@d i iVar, @d ProtoBuf.Class r10, @d h.p2.b0.g.t.f.z.c cVar, @d h.p2.b0.g.t.f.z.a aVar, @d o0 o0Var) {
        super(iVar.h(), h.p2.b0.g.t.l.b.q.a(cVar, r10.getFqName()).j());
        h.p2.b0.g.t.c.b1.e jVar;
        this.f16808g = r10;
        this.f16809h = aVar;
        this.f16810i = o0Var;
        this.f16811j = h.p2.b0.g.t.l.b.q.a(cVar, r10.getFqName());
        h.p2.b0.g.t.l.b.t tVar = h.p2.b0.g.t.l.b.t.a;
        this.f16812k = tVar.b(h.p2.b0.g.t.f.z.b.f15388e.d(r10.getFlags()));
        this.f16813l = h.p2.b0.g.t.l.b.u.a(tVar, h.p2.b0.g.t.f.z.b.f15387d.d(r10.getFlags()));
        ClassKind a = tVar.a(h.p2.b0.g.t.f.z.b.f15389f.d(r10.getFlags()));
        this.f16814m = a;
        i a2 = iVar.a(this, r10.getTypeParameterList(), cVar, new h.p2.b0.g.t.f.z.g(r10.getTypeTable()), h.p2.b0.g.t.f.z.i.b.a(r10.getVersionRequirementTable()), aVar);
        this.n = a2;
        ClassKind classKind = ClassKind.ENUM_CLASS;
        this.o = a == classKind ? new StaticScopeForKotlinEnum(a2.h(), this) : MemberScope.b.b;
        this.p = new DeserializedClassTypeConstructor();
        this.q = ScopesHolderForClass.f16442e.a(this, a2.h(), a2.c().m().c(), new DeserializedClassDescriptor$memberScopeHolder$1(this));
        this.r = a == classKind ? new EnumEntryClassDescriptors() : null;
        k e2 = iVar.e();
        this.s = e2;
        this.t = a2.h().e(new DeserializedClassDescriptor$primaryConstructor$1(this));
        this.u = a2.h().c(new DeserializedClassDescriptor$constructors$1(this));
        this.v = a2.h().e(new DeserializedClassDescriptor$companionObjectDescriptor$1(this));
        this.w = a2.h().c(new DeserializedClassDescriptor$sealedSubclasses$1(this));
        h.p2.b0.g.t.f.z.c g2 = a2.g();
        h.p2.b0.g.t.f.z.g j2 = a2.j();
        DeserializedClassDescriptor deserializedClassDescriptor = e2 instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) e2 : null;
        this.x = new s.a(r10, g2, j2, o0Var, deserializedClassDescriptor != null ? deserializedClassDescriptor.x : null);
        if (!h.p2.b0.g.t.f.z.b.f15386c.d(r10.getFlags()).booleanValue()) {
            jVar = h.p2.b0.g.t.c.b1.e.w0.b();
        } else {
            jVar = new j(a2.h(), new DeserializedClassDescriptor$annotations$1(this));
        }
        this.y = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h.p2.b0.g.t.c.d N0() {
        if (this.f16808g.hasCompanionObjectName()) {
            h.p2.b0.g.t.c.f f2 = U0().f(h.p2.b0.g.t.l.b.q.b(this.n.g(), this.f16808g.getCompanionObjectName()), NoLookupLocation.FROM_DESERIALIZATION);
            if (f2 instanceof h.p2.b0.g.t.c.d) {
                return (h.p2.b0.g.t.c.d) f2;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<c> O0() {
        return CollectionsKt___CollectionsKt.q4(CollectionsKt___CollectionsKt.q4(Q0(), CollectionsKt__CollectionsKt.M(E())), this.n.c().c().c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c P0() {
        Object obj;
        if (this.f16814m.isSingleton()) {
            h.p2.b0.g.t.c.d1.e i2 = h.p2.b0.g.t.k.b.i(this, o0.a);
            i2.c1(r());
            return i2;
        }
        Iterator<T> it = this.f16808g.getConstructorList().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!h.p2.b0.g.t.f.z.b.f15396m.d(((ProtoBuf.Constructor) obj).getFlags()).booleanValue()) {
                break;
            }
        }
        ProtoBuf.Constructor constructor = (ProtoBuf.Constructor) obj;
        if (constructor == null) {
            return null;
        }
        return S0().f().m(constructor, true);
    }

    private final List<c> Q0() {
        List<ProtoBuf.Constructor> constructorList = this.f16808g.getConstructorList();
        ArrayList<ProtoBuf.Constructor> arrayList = new ArrayList();
        for (Object obj : constructorList) {
            if (h.p2.b0.g.t.f.z.b.f15396m.d(((ProtoBuf.Constructor) obj).getFlags()).booleanValue()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(u.Y(arrayList, 10));
        for (ProtoBuf.Constructor constructor : arrayList) {
            arrayList2.add(S0().f().m(constructor, false));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<h.p2.b0.g.t.c.d> R0() {
        if (this.f16812k != Modality.SEALED) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<Integer> sealedSubclassFqNameList = this.f16808g.getSealedSubclassFqNameList();
        if (!sealedSubclassFqNameList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Integer num : sealedSubclassFqNameList) {
                h.p2.b0.g.t.c.d b = S0().c().b(h.p2.b0.g.t.l.b.q.a(S0().g(), num.intValue()));
                if (b != null) {
                    arrayList.add(b);
                }
            }
            return arrayList;
        }
        return h.p2.b0.g.t.k.a.a.a(this, false);
    }

    private final DeserializedClassMemberScope U0() {
        return this.q.c(this.n.c().m().c());
    }

    @Override // h.p2.b0.g.t.c.d
    @e
    public c E() {
        return this.t.invoke();
    }

    @d
    public final i S0() {
        return this.n;
    }

    @d
    public final ProtoBuf.Class T0() {
        return this.f16808g;
    }

    @d
    public final h.p2.b0.g.t.f.z.a V0() {
        return this.f16809h;
    }

    @Override // h.p2.b0.g.t.c.d
    @d
    /* renamed from: W0 */
    public f k0() {
        return this.o;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean X() {
        return false;
    }

    @d
    public final s.a X0() {
        return this.x;
    }

    public final boolean Y0(@d h.p2.b0.g.t.g.f fVar) {
        return U0().s().contains(fVar);
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean a0() {
        return h.p2.b0.g.t.f.z.b.f15389f.d(this.f16808g.getFlags()) == ProtoBuf.Class.Kind.COMPANION_OBJECT;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.l, h.p2.b0.g.t.c.k
    @d
    public k b() {
        return this.s;
    }

    @Override // h.p2.b0.g.t.c.d1.r
    @d
    public MemberScope f0(@d h.p2.b0.g.t.n.e1.h hVar) {
        return this.q.c(hVar);
    }

    @Override // h.p2.b0.g.t.c.d
    @d
    public Collection<c> g() {
        return this.u.invoke();
    }

    @Override // h.p2.b0.g.t.c.b1.a
    @d
    public h.p2.b0.g.t.c.b1.e getAnnotations() {
        return this.y;
    }

    @Override // h.p2.b0.g.t.c.n
    @d
    public o0 getSource() {
        return this.f16810i;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.w
    @d
    public h.p2.b0.g.t.c.s getVisibility() {
        return this.f16813l;
    }

    @Override // h.p2.b0.g.t.c.d
    @d
    public ClassKind i() {
        return this.f16814m;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean i0() {
        return h.p2.b0.g.t.f.z.b.f15393j.d(this.f16808g.getFlags()).booleanValue();
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean isExternal() {
        return h.p2.b0.g.t.f.z.b.f15392i.d(this.f16808g.getFlags()).booleanValue();
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean isInline() {
        return h.p2.b0.g.t.f.z.b.f15394k.d(this.f16808g.getFlags()).booleanValue() && this.f16809h.e(1, 4, 1);
    }

    @Override // h.p2.b0.g.t.c.f
    @d
    public q0 j() {
        return this.p;
    }

    @Override // h.p2.b0.g.t.c.d
    @e
    public h.p2.b0.g.t.c.d l0() {
        return this.v.invoke();
    }

    @Override // h.p2.b0.g.t.c.d
    @d
    public Collection<h.p2.b0.g.t.c.d> m() {
        return this.w.invoke();
    }

    @Override // h.p2.b0.g.t.c.g
    public boolean n() {
        return h.p2.b0.g.t.f.z.b.f15390g.d(this.f16808g.getFlags()).booleanValue();
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.g
    @d
    public List<t0> s() {
        return this.n.i().k();
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.w
    @d
    public Modality t() {
        return this.f16812k;
    }

    @d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("deserialized ");
        sb.append(i0() ? "expect " : "");
        sb.append("class ");
        sb.append(getName());
        return sb.toString();
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean v() {
        return h.p2.b0.g.t.f.z.b.f15395l.d(this.f16808g.getFlags()).booleanValue();
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean w() {
        return h.p2.b0.g.t.f.z.b.f15394k.d(this.f16808g.getFlags()).booleanValue() && this.f16809h.c(1, 4, 2);
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean y() {
        return h.p2.b0.g.t.f.z.b.f15391h.d(this.f16808g.getFlags()).booleanValue();
    }
}
