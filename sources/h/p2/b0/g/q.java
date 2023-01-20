package h.p2.b0.g;

import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.Constants;
import com.vivo.push.PushClientConstants;
import h.a2.t0;
import h.k2.v.f0;
import h.p2.b0.g.t.c.f1.a.m;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.k.n.o;
import h.p2.b0.g.t.n.z;
import h.t2.u;
import h.z0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.PropertyReference;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;

@Metadata(d1 = {"\u0000Â\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001an\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\b\b\u0000\u0010\u0013*\u00020\u0014\"\b\b\u0001\u0010\u0012*\u00020\u00062\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u001d\u0010\u001e\u001a\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00120\u001f¢\u0006\u0002\b!H\u0000¢\u0006\u0002\u0010\"\u001a.\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0002\u001a(\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010)\u001a\u00020*H\u0002\u001a%\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H.00H\u0080\bø\u0001\u0000¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u000103*\u0004\u0018\u00010\u000eH\u0000\u001a\u0010\u00104\u001a\u0004\u0018\u000105*\u0004\u0018\u00010\u000eH\u0000\u001a\u0014\u00106\u001a\b\u0012\u0002\b\u0003\u0018\u000107*\u0004\u0018\u00010\u000eH\u0000\u001a\u0012\u00108\u001a\b\u0012\u0004\u0012\u00020:09*\u00020;H\u0000\u001a\u0014\u0010<\u001a\u0006\u0012\u0002\b\u00030\u0016*\u0006\u0012\u0002\b\u00030\u0016H\u0000\u001a\u000e\u0010=\u001a\u0004\u0018\u00010:*\u00020>H\u0002\u001a\u0012\u0010?\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016*\u00020@H\u0000\u001a\u000e\u0010A\u001a\u0004\u0018\u00010B*\u00020CH\u0000\u001a\u001a\u0010D\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030E2\u0006\u0010$\u001a\u00020%H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006F"}, d2 = {"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "isInlineClassType", "", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Z", "defaultPrimitiveValue", "", "type", "Ljava/lang/reflect/Type;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", Constants.FLAG_PACKAGE_NAME, "", PushClientConstants.TAG_CLASS_NAME, "arrayDimensions", "", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "reflectionCall", "R", ReportItem.LogTypeBlock, "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "createArrayType", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class q {
    @k.e.a.d
    private static final h.p2.b0.g.t.g.c a = new h.p2.b0.g.t.g.c("kotlin.jvm.JvmStatic");

    @k.e.a.e
    public static final KCallableImpl<?> a(@k.e.a.e Object obj) {
        KCallableImpl<?> kCallableImpl = (KCallableImpl) (!(obj instanceof KCallableImpl) ? null : obj);
        if (kCallableImpl == null) {
            kCallableImpl = b(obj);
        }
        return kCallableImpl != null ? kCallableImpl : c(obj);
    }

    @k.e.a.e
    public static final KFunctionImpl b(@k.e.a.e Object obj) {
        KFunctionImpl kFunctionImpl = (KFunctionImpl) (!(obj instanceof KFunctionImpl) ? null : obj);
        if (kFunctionImpl != null) {
            return kFunctionImpl;
        }
        if (!(obj instanceof FunctionReference)) {
            obj = null;
        }
        FunctionReference functionReference = (FunctionReference) obj;
        h.p2.c compute = functionReference != null ? functionReference.compute() : null;
        return compute instanceof KFunctionImpl ? compute : null;
    }

    @k.e.a.e
    public static final KPropertyImpl<?> c(@k.e.a.e Object obj) {
        KPropertyImpl<?> kPropertyImpl = (KPropertyImpl) (!(obj instanceof KPropertyImpl) ? null : obj);
        if (kPropertyImpl != null) {
            return kPropertyImpl;
        }
        if (!(obj instanceof PropertyReference)) {
            obj = null;
        }
        PropertyReference propertyReference = (PropertyReference) obj;
        h.p2.c compute = propertyReference != null ? propertyReference.compute() : null;
        return compute instanceof KPropertyImpl ? compute : null;
    }

    @k.e.a.d
    public static final List<Annotation> d(@k.e.a.d h.p2.b0.g.t.c.b1.a aVar) {
        h.p2.b0.g.t.c.b1.e annotations = aVar.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (h.p2.b0.g.t.c.b1.c cVar : annotations) {
            o0 source = cVar.getSource();
            Annotation annotation = null;
            if (source instanceof h.p2.b0.g.t.c.f1.a.b) {
                annotation = ((h.p2.b0.g.t.c.f1.a.b) source).d();
            } else if (source instanceof m.a) {
                h.p2.b0.g.t.c.f1.b.l c2 = ((m.a) source).c();
                if (!(c2 instanceof h.p2.b0.g.t.c.f1.b.b)) {
                    c2 = null;
                }
                h.p2.b0.g.t.c.f1.b.b bVar = (h.p2.b0.g.t.c.f1.b.b) c2;
                if (bVar != null) {
                    annotation = bVar.R();
                }
            } else {
                annotation = n(cVar);
            }
            if (annotation != null) {
                arrayList.add(annotation);
            }
        }
        return arrayList;
    }

    @k.e.a.d
    public static final Class<?> e(@k.e.a.d Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    @k.e.a.e
    public static final Object f(@k.e.a.d Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            if (f0.g(type, Boolean.TYPE)) {
                return Boolean.FALSE;
            }
            if (f0.g(type, Character.TYPE)) {
                return Character.valueOf((char) 0);
            }
            if (f0.g(type, Byte.TYPE)) {
                return Byte.valueOf((byte) 0);
            }
            if (f0.g(type, Short.TYPE)) {
                return Short.valueOf((short) 0);
            }
            if (f0.g(type, Integer.TYPE)) {
                return 0;
            }
            if (f0.g(type, Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (f0.g(type, Long.TYPE)) {
                return 0L;
            }
            if (f0.g(type, Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            if (f0.g(type, Void.TYPE)) {
                throw new IllegalStateException("Parameter with void type is illegal");
            }
            throw new UnsupportedOperationException("Unknown primitive: " + type);
        }
        return null;
    }

    @k.e.a.e
    public static final <M extends h.p2.b0.g.t.i.n, D extends h.p2.b0.g.t.c.a> D g(@k.e.a.d Class<?> cls, @k.e.a.d M m2, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d h.p2.b0.g.t.f.z.g gVar, @k.e.a.d h.p2.b0.g.t.f.z.a aVar, @k.e.a.d h.k2.u.p<? super MemberDeserializer, ? super M, ? extends D> pVar) {
        List<ProtoBuf.TypeParameter> typeParameterList;
        h.p2.b0.g.t.c.f1.a.k b = k.b(cls);
        if (m2 instanceof ProtoBuf.Function) {
            typeParameterList = ((ProtoBuf.Function) m2).getTypeParameterList();
        } else if (!(m2 instanceof ProtoBuf.Property)) {
            throw new IllegalStateException(("Unsupported message: " + m2).toString());
        } else {
            typeParameterList = ((ProtoBuf.Property) m2).getTypeParameterList();
        }
        return pVar.invoke(new MemberDeserializer(new h.p2.b0.g.t.l.b.i(b.a(), cVar, b.b(), gVar, h.p2.b0.g.t.f.z.i.b.b(), aVar, null, null, typeParameterList)), m2);
    }

    @k.e.a.e
    public static final m0 h(@k.e.a.d h.p2.b0.g.t.c.a aVar) {
        if (aVar.M() != null) {
            h.p2.b0.g.t.c.k b = aVar.b();
            Objects.requireNonNull(b, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return ((h.p2.b0.g.t.c.d) b).F0();
        }
        return null;
    }

    @k.e.a.d
    public static final h.p2.b0.g.t.g.c i() {
        return a;
    }

    public static final boolean j(@k.e.a.d h.p2.r rVar) {
        z type;
        if (!(rVar instanceof KTypeImpl)) {
            rVar = null;
        }
        KTypeImpl kTypeImpl = (KTypeImpl) rVar;
        return (kTypeImpl == null || (type = kTypeImpl.getType()) == null || !h.p2.b0.g.t.k.d.c(type)) ? false : true;
    }

    private static final Class<?> k(ClassLoader classLoader, String str, String str2, int i2) {
        if (f0.g(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        String str3 = str + '.' + u.j2(str2, '.', '$', false, 4, null);
        if (i2 > 0) {
            str3 = u.g2("[", i2) + 'L' + str3 + ';';
        }
        return h.p2.b0.g.t.c.f1.a.e.a(classLoader, str3);
    }

    private static final Class<?> l(ClassLoader classLoader, h.p2.b0.g.t.g.b bVar, int i2) {
        h.p2.b0.g.t.g.b o = h.p2.b0.g.t.b.k.c.a.o(bVar.b().j());
        if (o != null) {
            bVar = o;
        }
        return k(classLoader, bVar.h().b(), bVar.i().b(), i2);
    }

    public static /* synthetic */ Class m(ClassLoader classLoader, h.p2.b0.g.t.g.b bVar, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return l(classLoader, bVar, i2);
    }

    private static final Annotation n(h.p2.b0.g.t.c.b1.c cVar) {
        h.p2.b0.g.t.c.d f2 = DescriptorUtilsKt.f(cVar);
        Class<?> o = f2 != null ? o(f2) : null;
        if (!(o instanceof Class)) {
            o = null;
        }
        if (o != null) {
            Set<Map.Entry<h.p2.b0.g.t.g.f, h.p2.b0.g.t.k.n.g<?>>> entrySet = cVar.a().entrySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                h.p2.b0.g.t.g.f fVar = (h.p2.b0.g.t.g.f) entry.getKey();
                Object q = q((h.p2.b0.g.t.k.n.g) entry.getValue(), o.getClassLoader());
                Pair a2 = q != null ? z0.a(fVar.b(), q) : null;
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            return (Annotation) AnnotationConstructorCallerKt.d(o, t0.B0(arrayList), null, 4, null);
        }
        return null;
    }

    @k.e.a.e
    public static final Class<?> o(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        o0 source = dVar.getSource();
        if (source instanceof h.p2.b0.g.t.e.b.o) {
            h.p2.b0.g.t.e.b.m d2 = ((h.p2.b0.g.t.e.b.o) source).d();
            Objects.requireNonNull(d2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((h.p2.b0.g.t.c.f1.a.f) d2).e();
        } else if (source instanceof m.a) {
            h.p2.b0.g.t.c.f1.b.l c2 = ((m.a) source).c();
            Objects.requireNonNull(c2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((ReflectJavaClass) c2).r();
        } else {
            h.p2.b0.g.t.g.b h2 = DescriptorUtilsKt.h(dVar);
            if (h2 != null) {
                return l(ReflectClassUtilKt.f(dVar.getClass()), h2, 0);
            }
            return null;
        }
    }

    @k.e.a.e
    public static final KVisibility p(@k.e.a.d s sVar) {
        if (f0.g(sVar, h.p2.b0.g.t.c.r.f15211e)) {
            return KVisibility.PUBLIC;
        }
        if (f0.g(sVar, h.p2.b0.g.t.c.r.f15209c)) {
            return KVisibility.PROTECTED;
        }
        if (f0.g(sVar, h.p2.b0.g.t.c.r.f15210d)) {
            return KVisibility.INTERNAL;
        }
        if (f0.g(sVar, h.p2.b0.g.t.c.r.a) || f0.g(sVar, h.p2.b0.g.t.c.r.b)) {
            return KVisibility.PRIVATE;
        }
        return null;
    }

    private static final Object q(h.p2.b0.g.t.k.n.g<?> gVar, ClassLoader classLoader) {
        if (gVar instanceof h.p2.b0.g.t.k.n.a) {
            return n(((h.p2.b0.g.t.k.n.a) gVar).a());
        }
        if (gVar instanceof h.p2.b0.g.t.k.n.b) {
            List<? extends h.p2.b0.g.t.k.n.g<?>> a2 = ((h.p2.b0.g.t.k.n.b) gVar).a();
            ArrayList arrayList = new ArrayList(h.a2.u.Y(a2, 10));
            Iterator<T> it = a2.iterator();
            while (it.hasNext()) {
                arrayList.add(q((h.p2.b0.g.t.k.n.g) it.next(), classLoader));
            }
            Object[] array = arrayList.toArray(new Object[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return array;
        } else if (gVar instanceof h.p2.b0.g.t.k.n.i) {
            Pair<? extends h.p2.b0.g.t.g.b, ? extends h.p2.b0.g.t.g.f> a3 = ((h.p2.b0.g.t.k.n.i) gVar).a();
            h.p2.b0.g.t.g.f component2 = a3.component2();
            Class m2 = m(classLoader, a3.component1(), 0, 4, null);
            if (m2 != null) {
                Objects.requireNonNull(m2, "null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
                return p.a(m2, component2.b());
            }
            return null;
        } else if (gVar instanceof h.p2.b0.g.t.k.n.o) {
            o.b a4 = ((h.p2.b0.g.t.k.n.o) gVar).a();
            if (a4 instanceof o.b.C0463b) {
                o.b.C0463b c0463b = (o.b.C0463b) a4;
                return l(classLoader, c0463b.b(), c0463b.a());
            } else if (a4 instanceof o.b.a) {
                h.p2.b0.g.t.c.f c2 = ((o.b.a) a4).getType().I0().c();
                if (!(c2 instanceof h.p2.b0.g.t.c.d)) {
                    c2 = null;
                }
                h.p2.b0.g.t.c.d dVar = (h.p2.b0.g.t.c.d) c2;
                if (dVar != null) {
                    return o(dVar);
                }
                return null;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if ((gVar instanceof h.p2.b0.g.t.k.n.j) || (gVar instanceof h.p2.b0.g.t.k.n.q)) {
            return null;
        } else {
            return gVar.a();
        }
    }
}
