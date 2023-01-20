package h.p2.b0.g.t.c.d1;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.q0;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public class m extends f {
    public static final /* synthetic */ boolean n = false;

    /* renamed from: j  reason: collision with root package name */
    private final q0 f15120j;

    /* renamed from: k  reason: collision with root package name */
    private final MemberScope f15121k;

    /* renamed from: l  reason: collision with root package name */
    private final h.p2.b0.g.t.m.h<Set<h.p2.b0.g.t.g.f>> f15122l;

    /* renamed from: m  reason: collision with root package name */
    private final h.p2.b0.g.t.c.b1.e f15123m;

    /* loaded from: classes3.dex */
    public class a extends h.p2.b0.g.t.k.r.f {

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ boolean f15124f = false;
        private final h.p2.b0.g.t.m.f<h.p2.b0.g.t.g.f, Collection<? extends n0>> b;

        /* renamed from: c  reason: collision with root package name */
        private final h.p2.b0.g.t.m.f<h.p2.b0.g.t.g.f, Collection<? extends j0>> f15125c;

        /* renamed from: d  reason: collision with root package name */
        private final h.p2.b0.g.t.m.h<Collection<h.p2.b0.g.t.c.k>> f15126d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f15127e;

        /* renamed from: h.p2.b0.g.t.c.d1.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0439a implements h.k2.u.l<h.p2.b0.g.t.g.f, Collection<? extends n0>> {
            public final /* synthetic */ m a;

            public C0439a(m mVar) {
                this.a = mVar;
            }

            @Override // h.k2.u.l
            /* renamed from: a */
            public Collection<? extends n0> invoke(h.p2.b0.g.t.g.f fVar) {
                return a.this.n(fVar);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements h.k2.u.l<h.p2.b0.g.t.g.f, Collection<? extends j0>> {
            public final /* synthetic */ m a;

            public b(m mVar) {
                this.a = mVar;
            }

            @Override // h.k2.u.l
            /* renamed from: a */
            public Collection<? extends j0> invoke(h.p2.b0.g.t.g.f fVar) {
                return a.this.o(fVar);
            }
        }

        /* loaded from: classes3.dex */
        public class c implements h.k2.u.a<Collection<h.p2.b0.g.t.c.k>> {
            public final /* synthetic */ m a;

            public c(m mVar) {
                this.a = mVar;
            }

            @Override // h.k2.u.a
            /* renamed from: a */
            public Collection<h.p2.b0.g.t.c.k> invoke() {
                return a.this.m();
            }
        }

        /* loaded from: classes3.dex */
        public class d extends h.p2.b0.g.t.k.f {
            public final /* synthetic */ Set a;

            public d(Set set) {
                this.a = set;
            }

            private static /* synthetic */ void f(int i2) {
                Object[] objArr = new Object[3];
                if (i2 == 1) {
                    objArr[0] = "fromSuper";
                } else if (i2 != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i2 == 1 || i2 == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // h.p2.b0.g.t.k.g
            public void a(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    f(0);
                }
                OverridingUtil.L(callableMemberDescriptor, null);
                this.a.add(callableMemberDescriptor);
            }

            @Override // h.p2.b0.g.t.k.f
            public void e(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor, @k.e.a.d CallableMemberDescriptor callableMemberDescriptor2) {
                if (callableMemberDescriptor == null) {
                    f(1);
                }
                if (callableMemberDescriptor2 == null) {
                    f(2);
                }
            }
        }

        public a(@k.e.a.d m mVar, h.p2.b0.g.t.m.m mVar2) {
            if (mVar2 == null) {
                i(0);
            }
            this.f15127e = mVar;
            this.b = mVar2.i(new C0439a(mVar));
            this.f15125c = mVar2.i(new b(mVar));
            this.f15126d = mVar2.c(new c(mVar));
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00b5 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00be  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void i(int r13) {
            /*
                Method dump skipped, instructions count: 346
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.c.d1.m.a.i(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        @k.e.a.d
        public Collection<h.p2.b0.g.t.c.k> m() {
            HashSet hashSet = new HashSet();
            for (h.p2.b0.g.t.g.f fVar : (Set) this.f15127e.f15122l.invoke()) {
                NoLookupLocation noLookupLocation = NoLookupLocation.FOR_NON_TRACKED_SCOPE;
                hashSet.addAll(a(fVar, noLookupLocation));
                hashSet.addAll(c(fVar, noLookupLocation));
            }
            return hashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @k.e.a.d
        public Collection<? extends n0> n(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
            if (fVar == null) {
                i(8);
            }
            return q(fVar, p().a(fVar, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        /* JADX INFO: Access modifiers changed from: private */
        @k.e.a.d
        public Collection<? extends j0> o(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
            if (fVar == null) {
                i(4);
            }
            return q(fVar, p().c(fVar, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        @k.e.a.d
        private MemberScope p() {
            MemberScope q = this.f15127e.j().j().iterator().next().q();
            if (q == null) {
                i(9);
            }
            return q;
        }

        @k.e.a.d
        private <D extends CallableMemberDescriptor> Collection<? extends D> q(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d Collection<? extends D> collection) {
            if (fVar == null) {
                i(10);
            }
            if (collection == null) {
                i(11);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            OverridingUtil.f16771d.w(fVar, collection, Collections.emptySet(), this.f15127e, new d(linkedHashSet));
            return linkedHashSet;
        }

        @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, h.p2.b0.g.t.k.r.h
        @k.e.a.d
        public Collection<? extends n0> a(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
            if (fVar == null) {
                i(5);
            }
            if (bVar == null) {
                i(6);
            }
            Collection<? extends n0> invoke = this.b.invoke(fVar);
            if (invoke == null) {
                i(7);
            }
            return invoke;
        }

        @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @k.e.a.d
        public Set<h.p2.b0.g.t.g.f> b() {
            Set<h.p2.b0.g.t.g.f> set = (Set) this.f15127e.f15122l.invoke();
            if (set == null) {
                i(17);
            }
            return set;
        }

        @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @k.e.a.d
        public Collection<? extends j0> c(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
            if (fVar == null) {
                i(1);
            }
            if (bVar == null) {
                i(2);
            }
            Collection<? extends j0> invoke = this.f15125c.invoke(fVar);
            if (invoke == null) {
                i(3);
            }
            return invoke;
        }

        @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @k.e.a.d
        public Set<h.p2.b0.g.t.g.f> d() {
            Set<h.p2.b0.g.t.g.f> set = (Set) this.f15127e.f15122l.invoke();
            if (set == null) {
                i(19);
            }
            return set;
        }

        @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @k.e.a.d
        public Set<h.p2.b0.g.t.g.f> e() {
            Set<h.p2.b0.g.t.g.f> emptySet = Collections.emptySet();
            if (emptySet == null) {
                i(18);
            }
            return emptySet;
        }

        @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
        @k.e.a.d
        public Collection<h.p2.b0.g.t.c.k> g(@k.e.a.d h.p2.b0.g.t.k.r.d dVar, @k.e.a.d h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
            if (dVar == null) {
                i(13);
            }
            if (lVar == null) {
                i(14);
            }
            Collection<h.p2.b0.g.t.c.k> invoke = this.f15126d.invoke();
            if (invoke == null) {
                i(15);
            }
            return invoke;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private m(@k.e.a.d h.p2.b0.g.t.m.m mVar, @k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d h.p2.b0.g.t.n.z zVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.m.h<Set<h.p2.b0.g.t.g.f>> hVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d o0 o0Var) {
        super(mVar, dVar, fVar, o0Var, false);
        if (mVar == null) {
            h0(6);
        }
        if (dVar == null) {
            h0(7);
        }
        if (zVar == null) {
            h0(8);
        }
        if (fVar == null) {
            h0(9);
        }
        if (hVar == null) {
            h0(10);
        }
        if (eVar == null) {
            h0(11);
        }
        if (o0Var == null) {
            h0(12);
        }
        this.f15123m = eVar;
        this.f15120j = new h.p2.b0.g.t.n.h(this, Collections.emptyList(), Collections.singleton(zVar), mVar);
        this.f15121k = new a(this, mVar);
        this.f15122l = hVar;
    }

    @k.e.a.d
    public static m H0(@k.e.a.d h.p2.b0.g.t.m.m mVar, @k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.m.h<Set<h.p2.b0.g.t.g.f>> hVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d o0 o0Var) {
        if (mVar == null) {
            h0(0);
        }
        if (dVar == null) {
            h0(1);
        }
        if (fVar == null) {
            h0(2);
        }
        if (hVar == null) {
            h0(3);
        }
        if (eVar == null) {
            h0(4);
        }
        if (o0Var == null) {
            h0(5);
        }
        return new m(mVar, dVar, dVar.r(), fVar, hVar, eVar, o0Var);
    }

    private static /* synthetic */ void h0(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i2) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i2) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.e
    public h.p2.b0.g.t.c.c E() {
        return null;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean X() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean a0() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d1.r
    @k.e.a.d
    public MemberScope f0(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        if (hVar == null) {
            h0(13);
        }
        MemberScope memberScope = this.f15121k;
        if (memberScope == null) {
            h0(14);
        }
        return memberScope;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public Collection<h.p2.b0.g.t.c.c> g() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            h0(16);
        }
        return emptyList;
    }

    @Override // h.p2.b0.g.t.c.b1.a
    @k.e.a.d
    public h.p2.b0.g.t.c.b1.e getAnnotations() {
        h.p2.b0.g.t.c.b1.e eVar = this.f15123m;
        if (eVar == null) {
            h0(21);
        }
        return eVar;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.w
    @k.e.a.d
    public h.p2.b0.g.t.c.s getVisibility() {
        h.p2.b0.g.t.c.s sVar = h.p2.b0.g.t.c.r.f15211e;
        if (sVar == null) {
            h0(20);
        }
        return sVar;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public ClassKind i() {
        ClassKind classKind = ClassKind.ENUM_ENTRY;
        if (classKind == null) {
            h0(18);
        }
        return classKind;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean i0() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean isInline() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.f
    @k.e.a.d
    public q0 j() {
        q0 q0Var = this.f15120j;
        if (q0Var == null) {
            h0(17);
        }
        return q0Var;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public MemberScope k0() {
        MemberScope.b bVar = MemberScope.b.b;
        if (bVar == null) {
            h0(15);
        }
        return bVar;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.e
    public h.p2.b0.g.t.c.d l0() {
        return null;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public Collection<h.p2.b0.g.t.c.d> m() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            h0(23);
        }
        return emptyList;
    }

    @Override // h.p2.b0.g.t.c.g
    public boolean n() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.g
    @k.e.a.d
    public List<t0> s() {
        List<t0> emptyList = Collections.emptyList();
        if (emptyList == null) {
            h0(22);
        }
        return emptyList;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.w
    @k.e.a.d
    public Modality t() {
        Modality modality = Modality.FINAL;
        if (modality == null) {
            h0(19);
        }
        return modality;
    }

    public String toString() {
        return "enum entry " + getName();
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean v() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean w() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean y() {
        return false;
    }
}
