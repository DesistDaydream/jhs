package h.p2.b0.g.t.b.k;

import h.a2.e1;
import h.a2.y;
import h.k2.v.f0;
import h.p2.b0.g.t.b.g;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes3.dex */
public final class f {
    @k.e.a.d
    public static final f a;
    @k.e.a.d
    private static final Set<String> b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final Set<String> f15077c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final Set<String> f15078d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final Set<String> f15079e;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final Set<String> f15080f;
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final Set<String> f15081g;

    static {
        f fVar = new f();
        a = fVar;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.a;
        b = e1.D(signatureBuildingComponents.f("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        f15077c = e1.C(e1.C(e1.C(e1.C(e1.C(e1.C(fVar.b(), signatureBuildingComponents.f("List", "sort(Ljava/util/Comparator;)V")), signatureBuildingComponents.e("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), signatureBuildingComponents.e("Double", "isInfinite()Z", "isNaN()Z")), signatureBuildingComponents.e("Float", "isInfinite()Z", "isNaN()Z")), signatureBuildingComponents.e("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), signatureBuildingComponents.e("CharSequence", "isEmpty()Z"));
        f15078d = e1.C(e1.C(e1.C(e1.C(e1.C(e1.C(signatureBuildingComponents.e("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), signatureBuildingComponents.f("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), signatureBuildingComponents.e("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), signatureBuildingComponents.e("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), signatureBuildingComponents.f("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), signatureBuildingComponents.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), signatureBuildingComponents.f("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        f15079e = e1.C(e1.C(signatureBuildingComponents.f("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), signatureBuildingComponents.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), signatureBuildingComponents.f("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        Set<String> a2 = fVar.a();
        String[] b2 = signatureBuildingComponents.b("D");
        String[] strArr = new String[b2.length];
        System.arraycopy(b2, 0, strArr, 0, b2.length);
        Set C = e1.C(a2, signatureBuildingComponents.e("Float", strArr));
        String[] b3 = signatureBuildingComponents.b("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        String[] strArr2 = new String[b3.length];
        System.arraycopy(b3, 0, strArr2, 0, b3.length);
        f15080f = e1.C(C, signatureBuildingComponents.e("String", strArr2));
        String[] b4 = signatureBuildingComponents.b("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        String[] strArr3 = new String[b4.length];
        System.arraycopy(b4, 0, strArr3, 0, b4.length);
        f15081g = signatureBuildingComponents.e("Throwable", strArr3);
    }

    private f() {
    }

    private final Set<String> a() {
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.a;
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BYTE;
        List<JvmPrimitiveType> L = CollectionsKt__CollectionsKt.L(JvmPrimitiveType.BOOLEAN, jvmPrimitiveType, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, jvmPrimitiveType, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JvmPrimitiveType jvmPrimitiveType2 : L) {
            String b2 = jvmPrimitiveType2.getWrapperFqName().g().b();
            String[] b3 = signatureBuildingComponents.b("Ljava/lang/String;");
            String[] strArr = new String[b3.length];
            System.arraycopy(b3, 0, strArr, 0, b3.length);
            y.q0(linkedHashSet, signatureBuildingComponents.e(b2, strArr));
        }
        return linkedHashSet;
    }

    private final Set<String> b() {
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.a;
        List<JvmPrimitiveType> L = CollectionsKt__CollectionsKt.L(JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JvmPrimitiveType jvmPrimitiveType : L) {
            String b2 = jvmPrimitiveType.getWrapperFqName().g().b();
            y.q0(linkedHashSet, signatureBuildingComponents.e(b2, jvmPrimitiveType.getJavaKeywordName() + "Value()" + jvmPrimitiveType.getDesc()));
        }
        return linkedHashSet;
    }

    @k.e.a.d
    public final Set<String> c() {
        return b;
    }

    @k.e.a.d
    public final Set<String> d() {
        return f15080f;
    }

    @k.e.a.d
    public final Set<String> e() {
        return f15077c;
    }

    @k.e.a.d
    public final Set<String> f() {
        return f15079e;
    }

    @k.e.a.d
    public final Set<String> g() {
        return f15081g;
    }

    @k.e.a.d
    public final Set<String> h() {
        return f15078d;
    }

    public final boolean i(@k.e.a.d h.p2.b0.g.t.g.d dVar) {
        if (!f0.g(dVar, g.a.f15042i)) {
            h.p2.b0.g.t.b.g gVar = h.p2.b0.g.t.b.g.a;
            if (!h.p2.b0.g.t.b.g.e(dVar)) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(@k.e.a.d h.p2.b0.g.t.g.d dVar) {
        if (i(dVar)) {
            return true;
        }
        h.p2.b0.g.t.g.b o = c.a.o(dVar);
        if (o == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(o.b().b()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
