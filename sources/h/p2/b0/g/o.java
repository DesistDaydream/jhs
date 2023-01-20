package h.p2.b0.g;

import h.k2.v.f0;
import h.p2.b0.g.d;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k0;
import h.p2.b0.g.t.c.l0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.f.a0.f.d;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "isKnownBuiltInFunction", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class o {
    @k.e.a.d
    public static final o b = new o();
    private static final h.p2.b0.g.t.g.b a = h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c("java.lang.Void"));

    private o() {
    }

    private final PrimitiveType a(Class<?> cls) {
        if (cls.isPrimitive()) {
            return JvmPrimitiveType.get(cls.getSimpleName()).getPrimitiveType();
        }
        return null;
    }

    private final boolean b(v vVar) {
        if (h.p2.b0.g.t.k.b.m(vVar) || h.p2.b0.g.t.k.b.n(vVar)) {
            return true;
        }
        return f0.g(vVar.getName(), h.p2.b0.g.t.b.k.a.f15060e.a()) && vVar.h().isEmpty();
    }

    private final JvmFunctionSignature.c d(v vVar) {
        return new JvmFunctionSignature.c(new d.b(e(vVar), h.p2.b0.g.t.e.b.r.c(vVar, false, false, 1, null)));
    }

    private final String e(CallableMemberDescriptor callableMemberDescriptor) {
        String b2 = SpecialBuiltinMembers.b(callableMemberDescriptor);
        return b2 != null ? b2 : callableMemberDescriptor instanceof k0 ? h.p2.b0.g.t.e.a.o.a(DescriptorUtilsKt.o(callableMemberDescriptor).getName().b()) : callableMemberDescriptor instanceof l0 ? h.p2.b0.g.t.e.a.o.d(DescriptorUtilsKt.o(callableMemberDescriptor).getName().b()) : callableMemberDescriptor.getName().b();
    }

    @k.e.a.d
    public final h.p2.b0.g.t.g.b c(@k.e.a.d Class<?> cls) {
        h.p2.b0.g.t.g.b n;
        if (cls.isArray()) {
            PrimitiveType a2 = a(cls.getComponentType());
            if (a2 != null) {
                return new h.p2.b0.g.t.g.b(h.p2.b0.g.t.b.g.n, a2.getArrayTypeName());
            }
            return h.p2.b0.g.t.g.b.m(g.a.f15042i.l());
        } else if (f0.g(cls, Void.TYPE)) {
            return a;
        } else {
            PrimitiveType a3 = a(cls);
            if (a3 != null) {
                return new h.p2.b0.g.t.g.b(h.p2.b0.g.t.b.g.n, a3.getTypeName());
            }
            h.p2.b0.g.t.g.b a4 = ReflectClassUtilKt.a(cls);
            return (a4.k() || (n = h.p2.b0.g.t.b.k.c.a.n(a4.b())) == null) ? a4 : n;
        }
    }

    @k.e.a.d
    public final d f(@k.e.a.d j0 j0Var) {
        j0 a2 = ((j0) h.p2.b0.g.t.k.c.L(j0Var)).a();
        if (a2 instanceof h.p2.b0.g.t.l.b.x.g) {
            h.p2.b0.g.t.l.b.x.g gVar = (h.p2.b0.g.t.l.b.x.g) a2;
            ProtoBuf.Property d0 = gVar.d0();
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) h.p2.b0.g.t.f.z.e.a(d0, JvmProtoBuf.f16705d);
            if (jvmPropertySignature != null) {
                return new d.c(a2, d0, jvmPropertySignature, gVar.J(), gVar.F());
            }
        } else if (a2 instanceof h.p2.b0.g.t.e.a.u.e) {
            o0 source = ((h.p2.b0.g.t.e.a.u.e) a2).getSource();
            if (!(source instanceof h.p2.b0.g.t.e.a.w.a)) {
                source = null;
            }
            h.p2.b0.g.t.e.a.w.a aVar = (h.p2.b0.g.t.e.a.w.a) source;
            h.p2.b0.g.t.e.a.x.l c2 = aVar != null ? aVar.c() : null;
            if (c2 instanceof h.p2.b0.g.t.c.f1.b.n) {
                return new d.a(((h.p2.b0.g.t.c.f1.b.n) c2).U());
            }
            if (c2 instanceof h.p2.b0.g.t.c.f1.b.q) {
                Method U = ((h.p2.b0.g.t.c.f1.b.q) c2).U();
                l0 setter = a2.getSetter();
                o0 source2 = setter != null ? setter.getSource() : null;
                if (!(source2 instanceof h.p2.b0.g.t.e.a.w.a)) {
                    source2 = null;
                }
                h.p2.b0.g.t.e.a.w.a aVar2 = (h.p2.b0.g.t.e.a.w.a) source2;
                h.p2.b0.g.t.e.a.x.l c3 = aVar2 != null ? aVar2.c() : null;
                if (!(c3 instanceof h.p2.b0.g.t.c.f1.b.q)) {
                    c3 = null;
                }
                h.p2.b0.g.t.c.f1.b.q qVar = (h.p2.b0.g.t.c.f1.b.q) c3;
                return new d.b(U, qVar != null ? qVar.U() : null);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + a2 + " (source = " + c2 + ')');
        }
        JvmFunctionSignature.c d2 = d(a2.getGetter());
        l0 setter2 = a2.getSetter();
        return new d.C0427d(d2, setter2 != null ? d(setter2) : null);
    }

    @k.e.a.d
    public final JvmFunctionSignature g(@k.e.a.d v vVar) {
        Method U;
        d.b b2;
        d.b e2;
        v a2 = ((v) h.p2.b0.g.t.k.c.L(vVar)).a();
        if (a2 instanceof h.p2.b0.g.t.l.b.x.c) {
            h.p2.b0.g.t.l.b.x.c cVar = (h.p2.b0.g.t.l.b.x.c) a2;
            h.p2.b0.g.t.i.n d0 = cVar.d0();
            if ((d0 instanceof ProtoBuf.Function) && (e2 = h.p2.b0.g.t.f.a0.f.g.a.e((ProtoBuf.Function) d0, cVar.J(), cVar.F())) != null) {
                return new JvmFunctionSignature.c(e2);
            }
            if ((d0 instanceof ProtoBuf.Constructor) && (b2 = h.p2.b0.g.t.f.a0.f.g.a.b((ProtoBuf.Constructor) d0, cVar.J(), cVar.F())) != null) {
                if (h.p2.b0.g.t.k.d.b(vVar.b())) {
                    return new JvmFunctionSignature.c(b2);
                }
                return new JvmFunctionSignature.b(b2);
            }
            return d(a2);
        }
        if (a2 instanceof JavaMethodDescriptor) {
            o0 source = ((JavaMethodDescriptor) a2).getSource();
            if (!(source instanceof h.p2.b0.g.t.e.a.w.a)) {
                source = null;
            }
            h.p2.b0.g.t.e.a.w.a aVar = (h.p2.b0.g.t.e.a.w.a) source;
            h.p2.b0.g.t.e.a.x.l c2 = aVar != null ? aVar.c() : null;
            h.p2.b0.g.t.c.f1.b.q qVar = (h.p2.b0.g.t.c.f1.b.q) (c2 instanceof h.p2.b0.g.t.c.f1.b.q ? c2 : null);
            if (qVar != null && (U = qVar.U()) != null) {
                return new JvmFunctionSignature.a(U);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + a2);
        } else if (a2 instanceof h.p2.b0.g.t.e.a.u.b) {
            o0 source2 = ((h.p2.b0.g.t.e.a.u.b) a2).getSource();
            if (!(source2 instanceof h.p2.b0.g.t.e.a.w.a)) {
                source2 = null;
            }
            h.p2.b0.g.t.e.a.w.a aVar2 = (h.p2.b0.g.t.e.a.w.a) source2;
            h.p2.b0.g.t.e.a.x.l c3 = aVar2 != null ? aVar2.c() : null;
            if (c3 instanceof h.p2.b0.g.t.c.f1.b.k) {
                return new JvmFunctionSignature.JavaConstructor(((h.p2.b0.g.t.c.f1.b.k) c3).U());
            }
            if (c3 instanceof ReflectJavaClass) {
                ReflectJavaClass reflectJavaClass = (ReflectJavaClass) c3;
                if (reflectJavaClass.m()) {
                    return new JvmFunctionSignature.FakeJavaAnnotationConstructor(reflectJavaClass.r());
                }
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + a2 + " (" + c3 + ')');
        } else if (b(a2)) {
            return d(a2);
        } else {
            throw new KotlinReflectionInternalError("Unknown origin of " + a2 + " (" + a2.getClass() + ')');
        }
    }
}
