package kotlin.jvm.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.j256.ormlite.stmt.query.SimpleComparison;
import h.k2.a;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.w0;
import h.p2.g;
import h.p2.r;
import h.p2.t;
import h.s0;
import java.lang.annotation.Annotation;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.KVariance;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0013H\u0002J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\f\u0010\u0017\u001a\u00020\u0013*\u00020\u0006H\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "annotations", "", "getAnnotations", "()Ljava/util/List;", "getArguments", "getClassifier", "()Lkotlin/reflect/KClassifier;", "()Z", "arrayClassName", "", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "asString", "equals", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.4")
/* loaded from: classes3.dex */
public final class TypeReference implements r {
    @d
    private final g a;
    @d
    private final List<t> b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f16333c;

    public TypeReference(@d g gVar, @d List<t> list, boolean z) {
        this.a = gVar;
        this.b = list;
        this.f16333c = z;
    }

    private final String e() {
        String l2;
        g a = a();
        if (!(a instanceof h.p2.d)) {
            a = null;
        }
        h.p2.d dVar = (h.p2.d) a;
        Class<?> c2 = dVar != null ? a.c(dVar) : null;
        if (c2 == null) {
            l2 = a().toString();
        } else {
            l2 = c2.isArray() ? l(c2) : c2.getName();
        }
        return l2 + (u().isEmpty() ? "" : CollectionsKt___CollectionsKt.Z2(u(), ", ", SimpleComparison.LESS_THAN_OPERATION, SimpleComparison.GREATER_THAN_OPERATION, 0, null, new TypeReference$asString$args$1(this), 24, null)) + (b() ? "?" : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h(t tVar) {
        String valueOf;
        if (tVar.g() == null) {
            return "*";
        }
        r type = tVar.getType();
        if (!(type instanceof TypeReference)) {
            type = null;
        }
        TypeReference typeReference = (TypeReference) type;
        if (typeReference == null || (valueOf = typeReference.e()) == null) {
            valueOf = String.valueOf(tVar.getType());
        }
        KVariance g2 = tVar.g();
        if (g2 != null) {
            int i2 = w0.a[g2.ordinal()];
            if (i2 == 1) {
                return valueOf;
            }
            if (i2 == 2) {
                return "in " + valueOf;
            } else if (i2 == 3) {
                return "out " + valueOf;
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String l(Class<?> cls) {
        return f0.g(cls, boolean[].class) ? "kotlin.BooleanArray" : f0.g(cls, char[].class) ? "kotlin.CharArray" : f0.g(cls, byte[].class) ? "kotlin.ByteArray" : f0.g(cls, short[].class) ? "kotlin.ShortArray" : f0.g(cls, int[].class) ? "kotlin.IntArray" : f0.g(cls, float[].class) ? "kotlin.FloatArray" : f0.g(cls, long[].class) ? "kotlin.LongArray" : f0.g(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    @Override // h.p2.r
    @d
    public g a() {
        return this.a;
    }

    @Override // h.p2.r
    public boolean b() {
        return this.f16333c;
    }

    public boolean equals(@e Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (f0.g(a(), typeReference.a()) && f0.g(u(), typeReference.u()) && b() == typeReference.b()) {
                return true;
            }
        }
        return false;
    }

    @Override // h.p2.b
    @d
    public List<Annotation> getAnnotations() {
        return CollectionsKt__CollectionsKt.E();
    }

    public int hashCode() {
        return (((a().hashCode() * 31) + u().hashCode()) * 31) + Boolean.valueOf(b()).hashCode();
    }

    @d
    public String toString() {
        return e() + n0.b;
    }

    @Override // h.p2.r
    @d
    public List<t> u() {
        return this.b;
    }
}
