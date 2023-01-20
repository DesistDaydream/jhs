package h.p2.b0.g;

import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.f.a0.f.d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.RuntimeTypeMapperKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0082\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "()V", "asString", "", "JavaField", "JavaMethodProperty", "KotlinProperty", "MappedKotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public abstract class d {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a extends d {
        @k.e.a.d
        private final Field a;

        public a(@k.e.a.d Field field) {
            super(null);
            this.a = field;
        }

        @Override // h.p2.b0.g.d
        @k.e.a.d
        public String a() {
            return h.p2.b0.g.t.e.a.o.a(this.a.getName()) + "()" + ReflectClassUtilKt.b(this.a.getType());
        }

        @k.e.a.d
        public final Field b() {
            return this.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class b extends d {
        @k.e.a.d
        private final Method a;
        @k.e.a.e
        private final Method b;

        public b(@k.e.a.d Method method, @k.e.a.e Method method2) {
            super(null);
            this.a = method;
            this.b = method2;
        }

        @Override // h.p2.b0.g.d
        @k.e.a.d
        public String a() {
            return RuntimeTypeMapperKt.a(this.a);
        }

        @k.e.a.d
        public final Method b() {
            return this.a;
        }

        @k.e.a.e
        public final Method c() {
            return this.b;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "string", "", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class c extends d {
        private final String a;
        @k.e.a.d
        private final j0 b;
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        private final ProtoBuf.Property f14994c;
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        private final JvmProtoBuf.JvmPropertySignature f14995d;
        @k.e.a.d

        /* renamed from: e  reason: collision with root package name */
        private final h.p2.b0.g.t.f.z.c f14996e;
        @k.e.a.d

        /* renamed from: f  reason: collision with root package name */
        private final h.p2.b0.g.t.f.z.g f14997f;

        public c(@k.e.a.d j0 j0Var, @k.e.a.d ProtoBuf.Property property, @k.e.a.d JvmProtoBuf.JvmPropertySignature jvmPropertySignature, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d h.p2.b0.g.t.f.z.g gVar) {
            super(null);
            String str;
            this.b = j0Var;
            this.f14994c = property;
            this.f14995d = jvmPropertySignature;
            this.f14996e = cVar;
            this.f14997f = gVar;
            if (jvmPropertySignature.hasGetter()) {
                str = cVar.getString(jvmPropertySignature.getGetter().getName()) + cVar.getString(jvmPropertySignature.getGetter().getDesc());
            } else {
                d.a d2 = h.p2.b0.g.t.f.a0.f.g.d(h.p2.b0.g.t.f.a0.f.g.a, property, cVar, gVar, false, 8, null);
                if (d2 != null) {
                    String d3 = d2.d();
                    str = h.p2.b0.g.t.e.a.o.a(d3) + c() + "()" + d2.e();
                } else {
                    throw new KotlinReflectionInternalError("No field signature for property: " + j0Var);
                }
            }
            this.a = str;
        }

        private final String c() {
            h.p2.b0.g.t.c.k b = this.b.b();
            if (f0.g(this.b.getVisibility(), h.p2.b0.g.t.c.r.f15210d) && (b instanceof DeserializedClassDescriptor)) {
                Integer num = (Integer) h.p2.b0.g.t.f.z.e.a(((DeserializedClassDescriptor) b).T0(), JvmProtoBuf.f16710i);
                String str = (num == null || (str = this.f14996e.getString(num.intValue())) == null) ? "main" : "main";
                return "$" + h.p2.b0.g.t.g.g.a(str);
            } else if (f0.g(this.b.getVisibility(), h.p2.b0.g.t.c.r.a) && (b instanceof b0)) {
                j0 j0Var = this.b;
                Objects.requireNonNull(j0Var, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                h.p2.b0.g.t.l.b.x.e K = ((h.p2.b0.g.t.l.b.x.g) j0Var).K();
                if (K instanceof h.p2.b0.g.t.e.b.g) {
                    h.p2.b0.g.t.e.b.g gVar = (h.p2.b0.g.t.e.b.g) K;
                    if (gVar.e() != null) {
                        return "$" + gVar.g().b();
                    }
                    return "";
                }
                return "";
            } else {
                return "";
            }
        }

        @Override // h.p2.b0.g.d
        @k.e.a.d
        public String a() {
            return this.a;
        }

        @k.e.a.d
        public final j0 b() {
            return this.b;
        }

        @k.e.a.d
        public final h.p2.b0.g.t.f.z.c d() {
            return this.f14996e;
        }

        @k.e.a.d
        public final ProtoBuf.Property e() {
            return this.f14994c;
        }

        @k.e.a.d
        public final JvmProtoBuf.JvmPropertySignature f() {
            return this.f14995d;
        }

        @k.e.a.d
        public final h.p2.b0.g.t.f.z.g g() {
            return this.f14997f;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "getGetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getSetterSignature", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* renamed from: h.p2.b0.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0427d extends d {
        @k.e.a.d
        private final JvmFunctionSignature.c a;
        @k.e.a.e
        private final JvmFunctionSignature.c b;

        public C0427d(@k.e.a.d JvmFunctionSignature.c cVar, @k.e.a.e JvmFunctionSignature.c cVar2) {
            super(null);
            this.a = cVar;
            this.b = cVar2;
        }

        @Override // h.p2.b0.g.d
        @k.e.a.d
        public String a() {
            return this.a.a();
        }

        @k.e.a.d
        public final JvmFunctionSignature.c b() {
            return this.a;
        }

        @k.e.a.e
        public final JvmFunctionSignature.c c() {
            return this.b;
        }
    }

    private d() {
    }

    @k.e.a.d
    public abstract String a();

    public /* synthetic */ d(u uVar) {
        this();
    }
}
