package h.p2.b0.g.t.b;

import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface;
import com.umeng.analytics.pro.am;
import h.k2.u.l;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.c1.a;
import h.p2.b0.g.t.c.c1.c;
import h.p2.b0.g.t.c.f0;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.k0;
import h.p2.b0.g.t.c.l0;
import h.p2.b0.g.t.c.q;
import h.p2.b0.g.t.m.m;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.u0;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public abstract class f {

    /* renamed from: g */
    public static final h.p2.b0.g.t.g.f f15018g = h.p2.b0.g.t.g.f.i("<built-ins module>");

    /* renamed from: h */
    public static final /* synthetic */ boolean f15019h = false;
    private ModuleDescriptorImpl a;
    private h.p2.b0.g.t.m.h<ModuleDescriptorImpl> b;

    /* renamed from: c */
    private final h.p2.b0.g.t.m.h<e> f15020c;

    /* renamed from: d */
    private final h.p2.b0.g.t.m.h<Collection<f0>> f15021d;

    /* renamed from: e */
    private final h.p2.b0.g.t.m.f<h.p2.b0.g.t.g.f, h.p2.b0.g.t.c.d> f15022e;

    /* renamed from: f */
    private final m f15023f;

    /* loaded from: classes3.dex */
    public class a implements h.k2.u.a<Collection<f0>> {
        public a() {
            f.this = r1;
        }

        @Override // h.k2.u.a
        /* renamed from: a */
        public Collection<f0> invoke() {
            return Arrays.asList(f.this.r().j0(g.n), f.this.r().j0(g.p), f.this.r().j0(g.q), f.this.r().j0(g.o));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h.k2.u.a<e> {
        public b() {
            f.this = r1;
        }

        @Override // h.k2.u.a
        /* renamed from: a */
        public e invoke() {
            PrimitiveType[] values;
            EnumMap enumMap = new EnumMap(PrimitiveType.class);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                h.p2.b0.g.t.n.f0 q = f.this.q(primitiveType.getTypeName().b());
                h.p2.b0.g.t.n.f0 q2 = f.this.q(primitiveType.getArrayTypeName().b());
                enumMap.put((EnumMap) primitiveType, (PrimitiveType) q2);
                hashMap.put(q, q2);
                hashMap2.put(q2, q);
            }
            return new e(enumMap, hashMap, hashMap2, null);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements l<h.p2.b0.g.t.g.f, h.p2.b0.g.t.c.d> {
        public c() {
            f.this = r1;
        }

        @Override // h.k2.u.l
        /* renamed from: a */
        public h.p2.b0.g.t.c.d invoke(h.p2.b0.g.t.g.f fVar) {
            h.p2.b0.g.t.c.f f2 = f.this.s().f(fVar, NoLookupLocation.FROM_BUILTINS);
            if (f2 != null) {
                if (f2 instanceof h.p2.b0.g.t.c.d) {
                    return (h.p2.b0.g.t.c.d) f2;
                }
                throw new AssertionError("Must be a class descriptor " + fVar + ", but was " + f2);
            }
            throw new AssertionError("Built-in class " + g.n.c(fVar) + " is not found");
        }
    }

    /* loaded from: classes3.dex */
    public class d implements h.k2.u.a<Void> {
        public final /* synthetic */ ModuleDescriptorImpl a;

        public d(ModuleDescriptorImpl moduleDescriptorImpl) {
            f.this = r1;
            this.a = moduleDescriptorImpl;
        }

        @Override // h.k2.u.a
        /* renamed from: a */
        public Void invoke() {
            if (f.this.a != null) {
                throw new AssertionError("Built-ins module is already set: " + f.this.a + " (attempting to reset to " + this.a + ")");
            }
            f.this.a = this.a;
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public final Map<PrimitiveType, h.p2.b0.g.t.n.f0> a;
        public final Map<z, h.p2.b0.g.t.n.f0> b;

        /* renamed from: c */
        public final Map<h.p2.b0.g.t.n.f0, h.p2.b0.g.t.n.f0> f15024c;

        public /* synthetic */ e(Map map, Map map2, Map map3, a aVar) {
            this(map, map2, map3);
        }

        private static /* synthetic */ void a(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i2 != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private e(@k.e.a.d Map<PrimitiveType, h.p2.b0.g.t.n.f0> map, @k.e.a.d Map<z, h.p2.b0.g.t.n.f0> map2, @k.e.a.d Map<h.p2.b0.g.t.n.f0, h.p2.b0.g.t.n.f0> map3) {
            if (map == null) {
                a(0);
            }
            if (map2 == null) {
                a(1);
            }
            if (map3 == null) {
                a(2);
            }
            this.a = map;
            this.b = map2;
            this.f15024c = map3;
        }
    }

    public f(@k.e.a.d m mVar) {
        if (mVar == null) {
            a(0);
        }
        this.f15023f = mVar;
        this.f15021d = mVar.c(new a());
        this.f15020c = mVar.c(new b());
        this.f15022e = mVar.i(new c());
    }

    @k.e.a.e
    private static z A(@k.e.a.d z zVar, @k.e.a.d h.p2.b0.g.t.c.z zVar2) {
        h.p2.b0.g.t.g.b h2;
        h.p2.b0.g.t.g.b a2;
        h.p2.b0.g.t.c.d a3;
        if (zVar == null) {
            a(71);
        }
        if (zVar2 == null) {
            a(72);
        }
        h.p2.b0.g.t.c.f c2 = zVar.I0().c();
        if (c2 == null) {
            return null;
        }
        i iVar = i.a;
        if (!iVar.b(c2.getName()) || (h2 = DescriptorUtilsKt.h(c2)) == null || (a2 = iVar.a(h2)) == null || (a3 = FindClassInModuleKt.a(zVar2, a2)) == null) {
            return null;
        }
        return a3.r();
    }

    public static boolean A0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(132);
        }
        return u0(zVar) || x0(zVar) || v0(zVar) || w0(zVar);
    }

    @k.e.a.e
    public static PrimitiveType O(@k.e.a.d k kVar) {
        if (kVar == null) {
            a(77);
        }
        if (g.a.C0.contains(kVar.getName())) {
            return g.a.E0.get(h.p2.b0.g.t.k.c.m(kVar));
        }
        return null;
    }

    @k.e.a.d
    private h.p2.b0.g.t.c.d P(@k.e.a.d PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(16);
        }
        return p(primitiveType.getTypeName().b());
    }

    @k.e.a.e
    public static PrimitiveType R(@k.e.a.d k kVar) {
        if (kVar == null) {
            a(76);
        }
        if (g.a.B0.contains(kVar.getName())) {
            return g.a.D0.get(h.p2.b0.g.t.k.c.m(kVar));
        }
        return null;
    }

    public static boolean Z(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        if (dVar == null) {
            a(108);
        }
        return e(dVar, g.a.b);
    }

    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                i3 = 2;
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 72:
                objArr[0] = am.f7000e;
                break;
            case 2:
                objArr[0] = "computation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 9:
            case 10:
            case 76:
            case 77:
            case 89:
            case 96:
            case 103:
            case 107:
            case 108:
            case CameraInterface.TYPE_CAPTURE /* 145 */:
            case 146:
            case e.j.f.u.d.f11631g /* 148 */:
            case 156:
            case 157:
            case 158:
            case 159:
                objArr[0] = "descriptor";
                break;
            case 12:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 135:
                objArr[0] = "fqName";
                break;
            case 14:
                objArr[0] = "simpleName";
                break;
            case 16:
            case 17:
            case 53:
            case 88:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 97:
            case 99:
            case 105:
            case 109:
            case 110:
            case 111:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED /* 129 */:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case CameraInterface.TYPE_RECORDER /* 144 */:
            case 147:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 161:
                objArr[0] = "type";
                break;
            case 46:
                objArr[0] = "classSimpleName";
                break;
            case 67:
                objArr[0] = "arrayType";
                break;
            case 71:
                objArr[0] = "notNullArrayType";
                break;
            case 73:
                objArr[0] = "primitiveType";
                break;
            case 75:
                objArr[0] = "kotlinType";
                break;
            case 78:
            case 82:
                objArr[0] = "projectionType";
                break;
            case 79:
            case 83:
            case 85:
                objArr[0] = "argument";
                break;
            case 80:
                objArr[0] = "annotations";
                break;
            case 101:
                objArr[0] = "typeConstructor";
                break;
            case 112:
                objArr[0] = "classDescriptor";
                break;
            case 160:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i2) {
            case 3:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 4:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 5:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 6:
                objArr[1] = "getStorageManager";
                break;
            case 7:
                objArr[1] = "getBuiltInsModule";
                break;
            case 8:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 11:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 13:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 15:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 18:
                objArr[1] = "getSuspendFunction";
                break;
            case 19:
                objArr[1] = "getKFunction";
                break;
            case 20:
                objArr[1] = "getKSuspendFunction";
                break;
            case 21:
                objArr[1] = "getKClass";
                break;
            case 22:
                objArr[1] = "getKCallable";
                break;
            case 23:
                objArr[1] = "getKProperty";
                break;
            case 24:
                objArr[1] = "getKProperty0";
                break;
            case 25:
                objArr[1] = "getKProperty1";
                break;
            case 26:
                objArr[1] = "getKProperty2";
                break;
            case 27:
                objArr[1] = "getKMutableProperty0";
                break;
            case 28:
                objArr[1] = "getKMutableProperty1";
                break;
            case 29:
                objArr[1] = "getKMutableProperty2";
                break;
            case 30:
                objArr[1] = "getIterator";
                break;
            case 31:
                objArr[1] = "getIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterable";
                break;
            case 33:
                objArr[1] = "getMutableIterator";
                break;
            case 34:
                objArr[1] = "getCollection";
                break;
            case 35:
                objArr[1] = "getMutableCollection";
                break;
            case 36:
                objArr[1] = "getList";
                break;
            case 37:
                objArr[1] = "getMutableList";
                break;
            case 38:
                objArr[1] = "getSet";
                break;
            case 39:
                objArr[1] = "getMutableSet";
                break;
            case 40:
                objArr[1] = "getMap";
                break;
            case 41:
                objArr[1] = "getMutableMap";
                break;
            case 42:
                objArr[1] = "getMapEntry";
                break;
            case 43:
                objArr[1] = "getMutableMapEntry";
                break;
            case 44:
                objArr[1] = "getListIterator";
                break;
            case 45:
                objArr[1] = "getMutableListIterator";
                break;
            case 47:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 48:
                objArr[1] = "getNothingType";
                break;
            case 49:
                objArr[1] = "getNullableNothingType";
                break;
            case 50:
                objArr[1] = "getAnyType";
                break;
            case 51:
                objArr[1] = "getNullableAnyType";
                break;
            case 52:
                objArr[1] = "getDefaultBound";
                break;
            case 54:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 55:
                objArr[1] = "getNumberType";
                break;
            case 56:
                objArr[1] = "getByteType";
                break;
            case 57:
                objArr[1] = "getShortType";
                break;
            case 58:
                objArr[1] = "getIntType";
                break;
            case 59:
                objArr[1] = "getLongType";
                break;
            case 60:
                objArr[1] = "getFloatType";
                break;
            case 61:
                objArr[1] = "getDoubleType";
                break;
            case 62:
                objArr[1] = "getCharType";
                break;
            case 63:
                objArr[1] = "getBooleanType";
                break;
            case 64:
                objArr[1] = "getUnitType";
                break;
            case 65:
                objArr[1] = "getStringType";
                break;
            case 66:
                objArr[1] = "getIterableType";
                break;
            case 68:
            case 69:
            case 70:
                objArr[1] = "getArrayElementType";
                break;
            case 74:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 81:
            case 84:
                objArr[1] = "getArrayType";
                break;
            case 86:
                objArr[1] = "getEnumType";
                break;
            case 87:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
                objArr[2] = "setPostponedBuiltinsModuleComputation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                break;
            case 9:
                objArr[2] = "isBuiltIn";
                break;
            case 10:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 12:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 16:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 17:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 46:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 53:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 67:
                objArr[2] = "getArrayElementType";
                break;
            case 71:
            case 72:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 73:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 75:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 76:
            case 93:
                objArr[2] = "getPrimitiveType";
                break;
            case 77:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
                objArr[2] = "getArrayType";
                break;
            case 85:
                objArr[2] = "getEnumType";
                break;
            case 88:
                objArr[2] = "isArray";
                break;
            case 89:
            case 90:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 91:
                objArr[2] = "isPrimitiveArray";
                break;
            case 92:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 94:
                objArr[2] = "isPrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 96:
                objArr[2] = "isPrimitiveClass";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 101:
            case 102:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 103:
            case 104:
                objArr[2] = "classFqNameEquals";
                break;
            case 105:
            case 106:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 107:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 108:
            case 109:
                objArr[2] = "isAny";
                break;
            case 110:
            case 112:
                objArr[2] = "isBoolean";
                break;
            case 111:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 113:
                objArr[2] = "isNumber";
                break;
            case 114:
                objArr[2] = "isChar";
                break;
            case 115:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 116:
                objArr[2] = "isInt";
                break;
            case 117:
                objArr[2] = "isByte";
                break;
            case 118:
                objArr[2] = "isLong";
                break;
            case 119:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 120:
                objArr[2] = "isShort";
                break;
            case 121:
                objArr[2] = "isFloat";
                break;
            case 122:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 123:
                objArr[2] = "isDouble";
                break;
            case 124:
                objArr[2] = "isUByte";
                break;
            case 125:
                objArr[2] = "isUShort";
                break;
            case 126:
                objArr[2] = "isUInt";
                break;
            case 127:
                objArr[2] = "isULong";
                break;
            case 128:
                objArr[2] = "isUByteArray";
                break;
            case ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED /* 129 */:
                objArr[2] = "isUShortArray";
                break;
            case 130:
                objArr[2] = "isUIntArray";
                break;
            case 131:
                objArr[2] = "isULongArray";
                break;
            case 132:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 133:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 134:
            case 135:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 136:
                objArr[2] = "isNothing";
                break;
            case 137:
                objArr[2] = "isNullableNothing";
                break;
            case 138:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case 139:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case 140:
                objArr[2] = "isNullableAny";
                break;
            case 141:
                objArr[2] = "isDefaultBound";
                break;
            case 142:
                objArr[2] = "isUnit";
                break;
            case 143:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case CameraInterface.TYPE_RECORDER /* 144 */:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case CameraInterface.TYPE_CAPTURE /* 145 */:
                objArr[2] = "isMemberOfAny";
                break;
            case 146:
            case 147:
                objArr[2] = "isEnum";
                break;
            case e.j.f.u.d.f11631g /* 148 */:
            case 149:
                objArr[2] = "isComparable";
                break;
            case 150:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 151:
                objArr[2] = "isListOrNullableList";
                break;
            case 152:
                objArr[2] = "isSetOrNullableSet";
                break;
            case 153:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 154:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 155:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 156:
                objArr[2] = "isThrowable";
                break;
            case 157:
                objArr[2] = "isKClass";
                break;
            case 158:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 159:
                objArr[2] = "isCloneable";
                break;
            case 160:
                objArr[2] = "isDeprecated";
                break;
            case 161:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                throw new IllegalStateException(format);
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static boolean a0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(139);
        }
        return e0(zVar, g.a.b);
    }

    public static boolean b0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(88);
        }
        return e0(zVar, g.a.f15042i);
    }

    public static boolean c0(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        if (dVar == null) {
            a(89);
        }
        return e(dVar, g.a.f15042i) || O(dVar) != null;
    }

    public static boolean d0(@k.e.a.d k kVar) {
        if (kVar == null) {
            a(9);
        }
        return h.p2.b0.g.t.k.c.r(kVar, h.p2.b0.g.t.b.a.class, false) != null;
    }

    private static boolean e(@k.e.a.d h.p2.b0.g.t.c.f fVar, @k.e.a.d h.p2.b0.g.t.g.d dVar) {
        if (fVar == null) {
            a(103);
        }
        if (dVar == null) {
            a(104);
        }
        return fVar.getName().equals(dVar.i()) && dVar.equals(h.p2.b0.g.t.k.c.m(fVar));
    }

    private static boolean e0(@k.e.a.d z zVar, @k.e.a.d h.p2.b0.g.t.g.d dVar) {
        if (zVar == null) {
            a(97);
        }
        if (dVar == null) {
            a(98);
        }
        return t0(zVar.I0(), dVar);
    }

    private static boolean f0(@k.e.a.d z zVar, @k.e.a.d h.p2.b0.g.t.g.d dVar) {
        if (zVar == null) {
            a(134);
        }
        if (dVar == null) {
            a(135);
        }
        return e0(zVar, dVar) && !zVar.J0();
    }

    public static boolean g0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(141);
        }
        return m0(zVar);
    }

    public static boolean h0(@k.e.a.d k kVar) {
        if (kVar == null) {
            a(160);
        }
        if (kVar.a().getAnnotations().n(g.a.y)) {
            return true;
        }
        if (kVar instanceof j0) {
            j0 j0Var = (j0) kVar;
            boolean O = j0Var.O();
            k0 getter = j0Var.getGetter();
            l0 setter = j0Var.getSetter();
            if (getter != null && h0(getter)) {
                if (!O) {
                    return true;
                }
                if (setter != null && h0(setter)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean i0(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        if (dVar == null) {
            a(157);
        }
        return e(dVar, g.a.d0);
    }

    private static boolean j0(@k.e.a.d z zVar, @k.e.a.d h.p2.b0.g.t.g.d dVar) {
        if (zVar == null) {
            a(105);
        }
        if (dVar == null) {
            a(106);
        }
        return !zVar.J0() && e0(zVar, dVar);
    }

    public static boolean k0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(136);
        }
        return l0(zVar) && !y0.l(zVar);
    }

    public static boolean l0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(138);
        }
        return e0(zVar, g.a.f15036c);
    }

    public static boolean m0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(140);
        }
        return a0(zVar) && zVar.J0();
    }

    public static boolean n0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(91);
        }
        h.p2.b0.g.t.c.f c2 = zVar.I0().c();
        return (c2 == null || O(c2) == null) ? false : true;
    }

    public static boolean o0(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        if (dVar == null) {
            a(96);
        }
        return R(dVar) != null;
    }

    @k.e.a.d
    private h.p2.b0.g.t.c.d p(@k.e.a.d String str) {
        if (str == null) {
            a(14);
        }
        h.p2.b0.g.t.c.d invoke = this.f15022e.invoke(h.p2.b0.g.t.g.f.f(str));
        if (invoke == null) {
            a(15);
        }
        return invoke;
    }

    public static boolean p0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(94);
        }
        return !zVar.J0() && q0(zVar);
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 q(@k.e.a.d String str) {
        if (str == null) {
            a(46);
        }
        h.p2.b0.g.t.n.f0 r = p(str).r();
        if (r == null) {
            a(47);
        }
        return r;
    }

    public static boolean q0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(95);
        }
        h.p2.b0.g.t.c.f c2 = zVar.I0().c();
        return (c2 instanceof h.p2.b0.g.t.c.d) && o0((h.p2.b0.g.t.c.d) c2);
    }

    public static boolean r0(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        if (dVar == null) {
            a(107);
        }
        return e(dVar, g.a.b) || e(dVar, g.a.f15036c);
    }

    public static boolean s0(@k.e.a.e z zVar) {
        return zVar != null && j0(zVar, g.a.f15041h);
    }

    public static boolean t0(@k.e.a.d q0 q0Var, @k.e.a.d h.p2.b0.g.t.g.d dVar) {
        if (q0Var == null) {
            a(101);
        }
        if (dVar == null) {
            a(102);
        }
        h.p2.b0.g.t.c.f c2 = q0Var.c();
        return (c2 instanceof h.p2.b0.g.t.c.d) && e(c2, dVar);
    }

    public static boolean u0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(128);
        }
        return f0(zVar, g.a.x0.j());
    }

    public static boolean v0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(130);
        }
        return f0(zVar, g.a.z0.j());
    }

    public static boolean w0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(131);
        }
        return f0(zVar, g.a.A0.j());
    }

    public static boolean x0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED);
        }
        return f0(zVar, g.a.y0.j());
    }

    public static boolean y0(@k.e.a.d k kVar) {
        if (kVar == null) {
            a(10);
        }
        while (kVar != null) {
            if (kVar instanceof b0) {
                return ((b0) kVar).e().i(g.f15035m);
            }
            kVar = kVar.b();
        }
        return false;
    }

    public static boolean z0(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(142);
        }
        return j0(zVar, g.a.f15039f);
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 B() {
        h.p2.b0.g.t.n.f0 Q = Q(PrimitiveType.FLOAT);
        if (Q == null) {
            a(60);
        }
        return Q;
    }

    public void B0(@k.e.a.d ModuleDescriptorImpl moduleDescriptorImpl) {
        if (moduleDescriptorImpl == null) {
            a(1);
        }
        this.f15023f.d(new d(moduleDescriptorImpl));
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.d C(int i2) {
        return p(g.b(i2));
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 D() {
        h.p2.b0.g.t.n.f0 Q = Q(PrimitiveType.INT);
        if (Q == null) {
            a(58);
        }
        return Q;
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.d E() {
        h.p2.b0.g.t.c.d o = o(g.a.d0.l());
        if (o == null) {
            a(21);
        }
        return o;
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 F() {
        h.p2.b0.g.t.n.f0 Q = Q(PrimitiveType.LONG);
        if (Q == null) {
            a(59);
        }
        return Q;
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.d G() {
        return p("Nothing");
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 H() {
        h.p2.b0.g.t.n.f0 r = G().r();
        if (r == null) {
            a(48);
        }
        return r;
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 I() {
        h.p2.b0.g.t.n.f0 P0 = i().P0(true);
        if (P0 == null) {
            a(51);
        }
        return P0;
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 J() {
        h.p2.b0.g.t.n.f0 P0 = H().P0(true);
        if (P0 == null) {
            a(49);
        }
        return P0;
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.d K() {
        return p("Number");
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 L() {
        h.p2.b0.g.t.n.f0 r = K().r();
        if (r == null) {
            a(55);
        }
        return r;
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.c1.c M() {
        c.b bVar = c.b.a;
        if (bVar == null) {
            a(4);
        }
        return bVar;
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 N(@k.e.a.d PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(73);
        }
        h.p2.b0.g.t.n.f0 f0Var = this.f15020c.invoke().a.get(primitiveType);
        if (f0Var == null) {
            a(74);
        }
        return f0Var;
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 Q(@k.e.a.d PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(53);
        }
        h.p2.b0.g.t.n.f0 r = P(primitiveType).r();
        if (r == null) {
            a(54);
        }
        return r;
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 S() {
        h.p2.b0.g.t.n.f0 Q = Q(PrimitiveType.SHORT);
        if (Q == null) {
            a(57);
        }
        return Q;
    }

    @k.e.a.d
    public m T() {
        m mVar = this.f15023f;
        if (mVar == null) {
            a(6);
        }
        return mVar;
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.d U() {
        return p("String");
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 V() {
        h.p2.b0.g.t.n.f0 r = U().r();
        if (r == null) {
            a(65);
        }
        return r;
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.d W(int i2) {
        h.p2.b0.g.t.c.d o = o(g.f15027e.c(h.p2.b0.g.t.g.f.f(g.d(i2))));
        if (o == null) {
            a(18);
        }
        return o;
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.d X() {
        return p("Unit");
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 Y() {
        h.p2.b0.g.t.n.f0 r = X().r();
        if (r == null) {
            a(64);
        }
        return r;
    }

    public void f(boolean z) {
        ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(f15018g, this.f15023f, this, null);
        this.a = moduleDescriptorImpl;
        moduleDescriptorImpl.O0(BuiltInsLoader.a.a().a(this.f15023f, this.a, v(), M(), g(), z));
        ModuleDescriptorImpl moduleDescriptorImpl2 = this.a;
        moduleDescriptorImpl2.U0(moduleDescriptorImpl2);
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.c1.a g() {
        a.C0436a c0436a = a.C0436a.a;
        if (c0436a == null) {
            a(3);
        }
        return c0436a;
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.d h() {
        return p("Any");
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 i() {
        h.p2.b0.g.t.n.f0 r = h().r();
        if (r == null) {
            a(50);
        }
        return r;
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.d j() {
        return p("Array");
    }

    @k.e.a.d
    public z k(@k.e.a.d z zVar) {
        z A;
        if (zVar == null) {
            a(67);
        }
        if (b0(zVar)) {
            if (zVar.H0().size() == 1) {
                z type = zVar.H0().get(0).getType();
                if (type == null) {
                    a(68);
                }
                return type;
            }
            throw new IllegalStateException();
        }
        z n = y0.n(zVar);
        h.p2.b0.g.t.n.f0 f0Var = this.f15020c.invoke().f15024c.get(n);
        if (f0Var != null) {
            if (f0Var == null) {
                a(69);
            }
            return f0Var;
        }
        h.p2.b0.g.t.c.z i2 = h.p2.b0.g.t.k.c.i(n);
        if (i2 != null && (A = A(n, i2)) != null) {
            if (A == null) {
                a(70);
            }
            return A;
        }
        throw new IllegalStateException("not array: " + zVar);
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 l(@k.e.a.d Variance variance, @k.e.a.d z zVar) {
        if (variance == null) {
            a(82);
        }
        if (zVar == null) {
            a(83);
        }
        h.p2.b0.g.t.n.f0 m2 = m(variance, zVar, h.p2.b0.g.t.c.b1.e.w0.b());
        if (m2 == null) {
            a(84);
        }
        return m2;
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 m(@k.e.a.d Variance variance, @k.e.a.d z zVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        if (variance == null) {
            a(78);
        }
        if (zVar == null) {
            a(79);
        }
        if (eVar == null) {
            a(80);
        }
        h.p2.b0.g.t.n.f0 g2 = KotlinTypeFactory.g(eVar, j(), Collections.singletonList(new u0(variance, zVar)));
        if (g2 == null) {
            a(81);
        }
        return g2;
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 n() {
        h.p2.b0.g.t.n.f0 Q = Q(PrimitiveType.BOOLEAN);
        if (Q == null) {
            a(63);
        }
        return Q;
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.d o(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        if (cVar == null) {
            a(12);
        }
        h.p2.b0.g.t.c.d c2 = q.c(r(), cVar, NoLookupLocation.FROM_BUILTINS);
        if (c2 == null) {
            a(13);
        }
        return c2;
    }

    @k.e.a.d
    public ModuleDescriptorImpl r() {
        if (this.a == null) {
            this.a = this.b.invoke();
        }
        ModuleDescriptorImpl moduleDescriptorImpl = this.a;
        if (moduleDescriptorImpl == null) {
            a(7);
        }
        return moduleDescriptorImpl;
    }

    @k.e.a.d
    public MemberScope s() {
        MemberScope q = r().j0(g.n).q();
        if (q == null) {
            a(11);
        }
        return q;
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 t() {
        h.p2.b0.g.t.n.f0 Q = Q(PrimitiveType.BYTE);
        if (Q == null) {
            a(56);
        }
        return Q;
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 u() {
        h.p2.b0.g.t.n.f0 Q = Q(PrimitiveType.CHAR);
        if (Q == null) {
            a(62);
        }
        return Q;
    }

    @k.e.a.d
    public Iterable<h.p2.b0.g.t.c.c1.b> v() {
        List singletonList = Collections.singletonList(new h.p2.b0.g.t.b.j.a(this.f15023f, r()));
        if (singletonList == null) {
            a(5);
        }
        return singletonList;
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.d w() {
        h.p2.b0.g.t.c.d o = o(g.a.P);
        if (o == null) {
            a(34);
        }
        return o;
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.d x() {
        return p("Comparable");
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 y() {
        h.p2.b0.g.t.n.f0 I = I();
        if (I == null) {
            a(52);
        }
        return I;
    }

    @k.e.a.d
    public h.p2.b0.g.t.n.f0 z() {
        h.p2.b0.g.t.n.f0 Q = Q(PrimitiveType.DOUBLE);
        if (Q == null) {
            a(61);
        }
        return Q;
    }
}
