package h.p2.b0.g.t.e.a.t;

import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.k.f;
import h.p2.b0.g.t.l.b.l;
import h.t1;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: h.p2.b0.g.t.e.a.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0442a extends f {
        public final /* synthetic */ l a;
        public final /* synthetic */ Set b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f15266c;

        /* renamed from: h.p2.b0.g.t.e.a.t.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0443a implements h.k2.u.l<CallableMemberDescriptor, t1> {
            public C0443a() {
            }

            private static /* synthetic */ void a(int i2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
            }

            @Override // h.k2.u.l
            /* renamed from: b */
            public t1 invoke(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    a(0);
                }
                C0442a.this.a.a(callableMemberDescriptor);
                return t1.a;
            }
        }

        public C0442a(l lVar, Set set, boolean z) {
            this.a = lVar;
            this.b = set;
            this.f15266c = z;
        }

        private static /* synthetic */ void f(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1) {
                objArr[0] = "fromSuper";
            } else if (i2 == 2) {
                objArr[0] = "fromCurrent";
            } else if (i2 == 3) {
                objArr[0] = "member";
            } else if (i2 != 4) {
                objArr[0] = "fakeOverride";
            } else {
                objArr[0] = "overridden";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
            if (i2 == 1 || i2 == 2) {
                objArr[2] = "conflict";
            } else if (i2 == 3 || i2 == 4) {
                objArr[2] = "setOverriddenDescriptors";
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
            OverridingUtil.L(callableMemberDescriptor, new C0443a());
            this.b.add(callableMemberDescriptor);
        }

        @Override // h.p2.b0.g.t.k.g
        public void d(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor, @k.e.a.d Collection<? extends CallableMemberDescriptor> collection) {
            if (callableMemberDescriptor == null) {
                f(3);
            }
            if (collection == null) {
                f(4);
            }
            if (!this.f15266c || callableMemberDescriptor.i() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                super.d(callableMemberDescriptor, collection);
            }
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

    private static /* synthetic */ void a(int i2) {
        String str = i2 != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 18 ? 3 : 2];
        switch (i2) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "name";
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i2 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i2) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 == 18) {
            throw new IllegalStateException(format);
        }
    }

    @k.e.a.e
    public static v0 b(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.c.d dVar) {
        if (fVar == null) {
            a(19);
        }
        if (dVar == null) {
            a(20);
        }
        Collection<h.p2.b0.g.t.c.c> g2 = dVar.g();
        if (g2.size() != 1) {
            return null;
        }
        for (v0 v0Var : g2.iterator().next().h()) {
            if (v0Var.getName().equals(fVar)) {
                return v0Var;
            }
        }
        return null;
    }

    @k.e.a.d
    private static <D extends CallableMemberDescriptor> Collection<D> c(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d Collection<D> collection, @k.e.a.d Collection<D> collection2, @k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d l lVar, @k.e.a.d OverridingUtil overridingUtil, boolean z) {
        if (fVar == null) {
            a(12);
        }
        if (collection == null) {
            a(13);
        }
        if (collection2 == null) {
            a(14);
        }
        if (dVar == null) {
            a(15);
        }
        if (lVar == null) {
            a(16);
        }
        if (overridingUtil == null) {
            a(17);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        overridingUtil.w(fVar, collection, collection2, dVar, new C0442a(lVar, linkedHashSet, z));
        return linkedHashSet;
    }

    @k.e.a.d
    public static <D extends CallableMemberDescriptor> Collection<D> d(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d Collection<D> collection, @k.e.a.d Collection<D> collection2, @k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d l lVar, @k.e.a.d OverridingUtil overridingUtil) {
        if (fVar == null) {
            a(0);
        }
        if (collection == null) {
            a(1);
        }
        if (collection2 == null) {
            a(2);
        }
        if (dVar == null) {
            a(3);
        }
        if (lVar == null) {
            a(4);
        }
        if (overridingUtil == null) {
            a(5);
        }
        return c(fVar, collection, collection2, dVar, lVar, overridingUtil, false);
    }

    @k.e.a.d
    public static <D extends CallableMemberDescriptor> Collection<D> e(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d Collection<D> collection, @k.e.a.d Collection<D> collection2, @k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d l lVar, @k.e.a.d OverridingUtil overridingUtil) {
        if (fVar == null) {
            a(6);
        }
        if (collection == null) {
            a(7);
        }
        if (collection2 == null) {
            a(8);
        }
        if (dVar == null) {
            a(9);
        }
        if (lVar == null) {
            a(10);
        }
        if (overridingUtil == null) {
            a(11);
        }
        return c(fVar, collection, collection2, dVar, lVar, overridingUtil, true);
    }
}
