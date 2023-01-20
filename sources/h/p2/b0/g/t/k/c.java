package h.p2.b0.g.t.k;

import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.f0;
import h.p2.b0.g.t.c.l0;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.n;
import h.p2.b0.g.t.c.o;
import h.p2.b0.g.t.c.p0;
import h.p2.b0.g.t.c.r;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.x0;
import h.p2.b0.g.t.n.a0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public class c {
    public static final h.p2.b0.g.t.g.c a = new h.p2.b0.g.t.g.c("kotlin.jvm.JvmName");
    public static final /* synthetic */ boolean b = false;

    private c() {
    }

    public static boolean A(@k.e.a.e h.p2.b0.g.t.c.k kVar) {
        return D(kVar, ClassKind.ENUM_CLASS);
    }

    public static boolean B(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (kVar == null) {
            a(36);
        }
        return D(kVar, ClassKind.ENUM_ENTRY);
    }

    public static boolean C(@k.e.a.e h.p2.b0.g.t.c.k kVar) {
        return D(kVar, ClassKind.INTERFACE);
    }

    private static boolean D(@k.e.a.e h.p2.b0.g.t.c.k kVar, @k.e.a.d ClassKind classKind) {
        if (classKind == null) {
            a(37);
        }
        return (kVar instanceof h.p2.b0.g.t.c.d) && ((h.p2.b0.g.t.c.d) kVar).i() == classKind;
    }

    public static boolean E(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (kVar == null) {
            a(1);
        }
        while (kVar != null) {
            if (u(kVar) || y(kVar)) {
                return true;
            }
            kVar = kVar.b();
        }
        return false;
    }

    private static boolean F(@k.e.a.d z zVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (zVar == null) {
            a(30);
        }
        if (kVar == null) {
            a(31);
        }
        h.p2.b0.g.t.c.f c2 = zVar.I0().c();
        if (c2 != null) {
            h.p2.b0.g.t.c.k a2 = c2.a();
            return (a2 instanceof h.p2.b0.g.t.c.f) && (kVar instanceof h.p2.b0.g.t.c.f) && ((h.p2.b0.g.t.c.f) kVar).j().equals(((h.p2.b0.g.t.c.f) a2).j());
        }
        return false;
    }

    public static boolean G(@k.e.a.e h.p2.b0.g.t.c.k kVar) {
        return (D(kVar, ClassKind.CLASS) || D(kVar, ClassKind.INTERFACE)) && ((h.p2.b0.g.t.c.d) kVar).t() == Modality.SEALED;
    }

    public static boolean H(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d h.p2.b0.g.t.c.d dVar2) {
        if (dVar == null) {
            a(28);
        }
        if (dVar2 == null) {
            a(29);
        }
        return I(dVar.r(), dVar2.a());
    }

    public static boolean I(@k.e.a.d z zVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (zVar == null) {
            a(32);
        }
        if (kVar == null) {
            a(33);
        }
        if (F(zVar, kVar)) {
            return true;
        }
        for (z zVar2 : zVar.I0().j()) {
            if (I(zVar2, kVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(@k.e.a.e h.p2.b0.g.t.c.k kVar) {
        return kVar != null && (kVar.b() instanceof b0);
    }

    public static boolean K(@k.e.a.d x0 x0Var, @k.e.a.d z zVar) {
        if (x0Var == null) {
            a(63);
        }
        if (zVar == null) {
            a(64);
        }
        if (x0Var.O() || a0.a(zVar)) {
            return false;
        }
        if (y0.b(zVar)) {
            return true;
        }
        h.p2.b0.g.t.b.f g2 = DescriptorUtilsKt.g(x0Var);
        if (!h.p2.b0.g.t.b.f.p0(zVar)) {
            h.p2.b0.g.t.n.e1.f fVar = h.p2.b0.g.t.n.e1.f.a;
            if (!fVar.b(g2.V(), zVar) && !fVar.b(g2.K().r(), zVar) && !fVar.b(g2.i(), zVar)) {
                h.p2.b0.g.t.b.i iVar = h.p2.b0.g.t.b.i.a;
                if (!h.p2.b0.g.t.b.i.d(zVar)) {
                    return false;
                }
            }
        }
        return true;
    }

    @k.e.a.d
    public static <D extends CallableMemberDescriptor> D L(@k.e.a.d D d2) {
        if (d2 == null) {
            a(59);
        }
        while (d2.i() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            Collection<? extends CallableMemberDescriptor> d3 = d2.d();
            if (!d3.isEmpty()) {
                d2 = (D) d3.iterator().next();
            } else {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + d2);
            }
        }
        if (d2 == null) {
            a(60);
        }
        return d2;
    }

    @k.e.a.d
    public static <D extends o> D M(@k.e.a.d D d2) {
        if (d2 == null) {
            a(61);
        }
        if (d2 instanceof CallableMemberDescriptor) {
            return L((CallableMemberDescriptor) d2);
        }
        if (d2 == null) {
            a(62);
        }
        return d2;
    }

    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 13:
            case 14:
            case 15:
            case 21:
            case 23:
            case 24:
            case 34:
            case 35:
            case 36:
            case 57:
            case 58:
            case 59:
            case 61:
            case 79:
            case 92:
            case 94:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 16:
                objArr[0] = "first";
                break;
            case 17:
                objArr[0] = "second";
                break;
            case 18:
            case 19:
                objArr[0] = "aClass";
                break;
            case 20:
                objArr[0] = "kotlinType";
                break;
            case 25:
                objArr[0] = "declarationDescriptor";
                break;
            case 26:
            case 28:
                objArr[0] = "subClass";
                break;
            case 27:
            case 29:
            case 33:
                objArr[0] = "superClass";
                break;
            case 30:
            case 32:
            case 45:
            case 64:
                objArr[0] = "type";
                break;
            case 31:
                objArr[0] = "other";
                break;
            case 37:
                objArr[0] = "classKind";
                break;
            case 38:
            case 39:
            case 41:
            case 44:
            case 48:
            case 54:
            case 65:
            case 66:
            case 67:
            case 74:
            case 75:
                objArr[0] = "classDescriptor";
                break;
            case 46:
                objArr[0] = "typeConstructor";
                break;
            case 55:
                objArr[0] = "innerClassName";
                break;
            case 56:
                objArr[0] = "location";
                break;
            case 63:
                objArr[0] = "variable";
                break;
            case 68:
                objArr[0] = "f";
                break;
            case 70:
                objArr[0] = "current";
                break;
            case 71:
                objArr[0] = "result";
                break;
            case 72:
                objArr[0] = "memberDescriptor";
                break;
            case 76:
            case 77:
            case 78:
                objArr[0] = "annotated";
                break;
            case 82:
            case 84:
            case 87:
            case 89:
                objArr[0] = "scope";
                break;
            case 85:
            case 88:
            case 90:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 12:
                objArr[1] = "getClassIdForNonLocalClass";
                break;
            case 22:
                objArr[1] = "getContainingModule";
                break;
            case 40:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 42:
            case 43:
                objArr[1] = "getSuperClassType";
                break;
            case 47:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 62:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 69:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 73:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 80:
            case 81:
                objArr[1] = "getContainingSourceFile";
                break;
            case 83:
                objArr[1] = "getAllDescriptors";
                break;
            case 86:
                objArr[1] = "getFunctionByName";
                break;
            case 91:
                objArr[1] = "getPropertyByName";
                break;
            case 93:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "getClassIdForNonLocalClass";
                break;
            case 13:
                objArr[2] = "isExtension";
                break;
            case 14:
                objArr[2] = "isOverride";
                break;
            case 15:
                objArr[2] = "isStaticDeclaration";
                break;
            case 16:
            case 17:
                objArr[2] = "areInSameModule";
                break;
            case 18:
            case 19:
                objArr[2] = "getParentOfType";
                break;
            case 20:
            case 23:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 21:
                objArr[2] = "getContainingModule";
                break;
            case 24:
                objArr[2] = "getContainingClass";
                break;
            case 25:
                objArr[2] = "isAncestor";
                break;
            case 26:
            case 27:
                objArr[2] = "isDirectSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSubclass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSameClass";
                break;
            case 32:
            case 33:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 34:
                objArr[2] = "isAnonymousObject";
                break;
            case 35:
                objArr[2] = "isAnonymousFunction";
                break;
            case 36:
                objArr[2] = "isEnumEntry";
                break;
            case 37:
                objArr[2] = "isKindOf";
                break;
            case 38:
                objArr[2] = "hasAbstractMembers";
                break;
            case 39:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 41:
                objArr[2] = "getSuperClassType";
                break;
            case 44:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 45:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 46:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 48:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 54:
            case 55:
            case 56:
                objArr[2] = "getInnerClassByName";
                break;
            case 57:
                objArr[2] = "isStaticNestedClass";
                break;
            case 58:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 61:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 63:
            case 64:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 65:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 66:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 67:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 68:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 70:
            case 71:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 72:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 74:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 75:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 76:
                objArr[2] = "getJvmName";
                break;
            case 77:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 78:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 79:
                objArr[2] = "getContainingSourceFile";
                break;
            case 82:
                objArr[2] = "getAllDescriptors";
                break;
            case 84:
            case 85:
                objArr[2] = "getFunctionByName";
                break;
            case 87:
            case 88:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 89:
            case 90:
                objArr[2] = "getPropertyByName";
                break;
            case 92:
                objArr[2] = "getDirectMember";
                break;
            case 94:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static boolean b(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.c.k kVar2) {
        if (kVar == null) {
            a(16);
        }
        if (kVar2 == null) {
            a(17);
        }
        return g(kVar).equals(g(kVar2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <D extends h.p2.b0.g.t.c.a> void c(@k.e.a.d D d2, @k.e.a.d Set<D> set) {
        if (d2 == null) {
            a(70);
        }
        if (set == 0) {
            a(71);
        }
        if (set.contains(d2)) {
            return;
        }
        for (h.p2.b0.g.t.c.a aVar : d2.a().d()) {
            h.p2.b0.g.t.c.a a2 = aVar.a();
            c(a2, set);
            set.add(a2);
        }
    }

    @k.e.a.d
    public static <D extends h.p2.b0.g.t.c.a> Set<D> d(@k.e.a.d D d2) {
        if (d2 == null) {
            a(68);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(d2.a(), linkedHashSet);
        return linkedHashSet;
    }

    @k.e.a.d
    public static h.p2.b0.g.t.c.d e(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(45);
        }
        return f(zVar.I0());
    }

    @k.e.a.d
    public static h.p2.b0.g.t.c.d f(@k.e.a.d q0 q0Var) {
        if (q0Var == null) {
            a(46);
        }
        h.p2.b0.g.t.c.d dVar = (h.p2.b0.g.t.c.d) q0Var.c();
        if (dVar == null) {
            a(47);
        }
        return dVar;
    }

    @k.e.a.d
    public static h.p2.b0.g.t.c.z g(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (kVar == null) {
            a(21);
        }
        h.p2.b0.g.t.c.z h2 = h(kVar);
        if (h2 == null) {
            a(22);
        }
        return h2;
    }

    @k.e.a.e
    public static h.p2.b0.g.t.c.z h(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (kVar == null) {
            a(23);
        }
        while (kVar != null) {
            if (kVar instanceof h.p2.b0.g.t.c.z) {
                return (h.p2.b0.g.t.c.z) kVar;
            }
            if (kVar instanceof f0) {
                return ((f0) kVar).y0();
            }
            kVar = kVar.b();
        }
        return null;
    }

    @k.e.a.e
    public static h.p2.b0.g.t.c.z i(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(20);
        }
        h.p2.b0.g.t.c.f c2 = zVar.I0().c();
        if (c2 == null) {
            return null;
        }
        return h(c2);
    }

    @k.e.a.d
    public static p0 j(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (kVar == null) {
            a(79);
        }
        if (kVar instanceof l0) {
            kVar = ((l0) kVar).V();
        }
        if (kVar instanceof n) {
            p0 b2 = ((n) kVar).getSource().b();
            if (b2 == null) {
                a(80);
            }
            return b2;
        }
        p0 p0Var = p0.a;
        if (p0Var == null) {
            a(81);
        }
        return p0Var;
    }

    @k.e.a.d
    public static s k(@k.e.a.d h.p2.b0.g.t.c.d dVar, boolean z) {
        if (dVar == null) {
            a(48);
        }
        ClassKind i2 = dVar.i();
        if (i2 != ClassKind.ENUM_CLASS && !i2.isSingleton()) {
            if (G(dVar)) {
                if (z) {
                    s sVar = r.f15209c;
                    if (sVar == null) {
                        a(50);
                    }
                    return sVar;
                }
                s sVar2 = r.a;
                if (sVar2 == null) {
                    a(51);
                }
                return sVar2;
            } else if (u(dVar)) {
                s sVar3 = r.f15218l;
                if (sVar3 == null) {
                    a(52);
                }
                return sVar3;
            } else {
                s sVar4 = r.f15211e;
                if (sVar4 == null) {
                    a(53);
                }
                return sVar4;
            }
        }
        s sVar5 = r.a;
        if (sVar5 == null) {
            a(49);
        }
        return sVar5;
    }

    @k.e.a.e
    public static m0 l(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (kVar == null) {
            a(0);
        }
        if (kVar instanceof h.p2.b0.g.t.c.d) {
            return ((h.p2.b0.g.t.c.d) kVar).F0();
        }
        return null;
    }

    @k.e.a.d
    public static h.p2.b0.g.t.g.d m(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (kVar == null) {
            a(2);
        }
        h.p2.b0.g.t.g.c o = o(kVar);
        return o != null ? o.j() : p(kVar);
    }

    @k.e.a.d
    public static h.p2.b0.g.t.g.c n(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (kVar == null) {
            a(3);
        }
        h.p2.b0.g.t.g.c o = o(kVar);
        if (o == null) {
            o = p(kVar).l();
        }
        if (o == null) {
            a(4);
        }
        return o;
    }

    @k.e.a.e
    private static h.p2.b0.g.t.g.c o(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (kVar == null) {
            a(5);
        }
        if (!(kVar instanceof h.p2.b0.g.t.c.z) && !h.p2.b0.g.t.n.s.r(kVar)) {
            if (kVar instanceof f0) {
                return ((f0) kVar).e();
            }
            if (kVar instanceof b0) {
                return ((b0) kVar).e();
            }
            return null;
        }
        return h.p2.b0.g.t.g.c.f15413c;
    }

    @k.e.a.d
    private static h.p2.b0.g.t.g.d p(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (kVar == null) {
            a(6);
        }
        h.p2.b0.g.t.g.d c2 = m(kVar.b()).c(kVar.getName());
        if (c2 == null) {
            a(7);
        }
        return c2;
    }

    @k.e.a.e
    public static <D extends h.p2.b0.g.t.c.k> D q(@k.e.a.e h.p2.b0.g.t.c.k kVar, @k.e.a.d Class<D> cls) {
        if (cls == null) {
            a(18);
        }
        return (D) r(kVar, cls, true);
    }

    @k.e.a.e
    public static <D extends h.p2.b0.g.t.c.k> D r(@k.e.a.e h.p2.b0.g.t.c.k kVar, @k.e.a.d Class<D> cls, boolean z) {
        if (cls == null) {
            a(19);
        }
        if (kVar == null) {
            return null;
        }
        if (z) {
            kVar = (D) kVar.b();
        }
        while (kVar != null) {
            if (cls.isInstance(kVar)) {
                return (D) kVar;
            }
            kVar = (D) kVar.b();
        }
        return null;
    }

    @k.e.a.e
    public static h.p2.b0.g.t.c.d s(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        if (dVar == null) {
            a(44);
        }
        for (z zVar : dVar.j().j()) {
            h.p2.b0.g.t.c.d e2 = e(zVar);
            if (e2.i() != ClassKind.INTERFACE) {
                return e2;
            }
        }
        return null;
    }

    public static boolean t(@k.e.a.e h.p2.b0.g.t.c.k kVar) {
        return D(kVar, ClassKind.ANNOTATION_CLASS);
    }

    public static boolean u(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (kVar == null) {
            a(34);
        }
        return v(kVar) && kVar.getName().equals(h.p2.b0.g.t.g.h.a);
    }

    public static boolean v(@k.e.a.e h.p2.b0.g.t.c.k kVar) {
        return D(kVar, ClassKind.CLASS);
    }

    public static boolean w(@k.e.a.e h.p2.b0.g.t.c.k kVar) {
        return v(kVar) || A(kVar);
    }

    public static boolean x(@k.e.a.e h.p2.b0.g.t.c.k kVar) {
        return D(kVar, ClassKind.OBJECT) && ((h.p2.b0.g.t.c.d) kVar).a0();
    }

    public static boolean y(h.p2.b0.g.t.c.k kVar) {
        return (kVar instanceof o) && ((o) kVar).getVisibility() == r.f15212f;
    }

    public static boolean z(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d h.p2.b0.g.t.c.d dVar2) {
        if (dVar == null) {
            a(26);
        }
        if (dVar2 == null) {
            a(27);
        }
        for (z zVar : dVar.j().j()) {
            if (F(zVar, dVar2.a())) {
                return true;
            }
        }
        return false;
    }
}
