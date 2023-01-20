package kotlin.reflect.jvm.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.u.a;
import h.k2.v.f0;
import h.k2.v.g0;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.b0.g.l;
import h.p2.b0.g.q;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.x;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import h.p2.g;
import h.p2.n;
import h.p2.t;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u001bH\u0000¢\u0006\u0002\b*J\b\u0010+\u001a\u00020,H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006-"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/jvm/internal/KTypeBase;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getComputeJavaType$annotations", "()V", "isMarkedNullable", "", "()Z", "javaType", "getJavaType", "()Ljava/lang/reflect/Type;", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", TTDownloadField.TT_HASHCODE, "", "makeNullableAsSpecified", "nullable", "makeNullableAsSpecified$kotlin_reflection", "toString", "", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KTypeImpl implements g0 {

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ n[] f16395e = {n0.r(new PropertyReference1Impl(n0.d(KTypeImpl.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), n0.r(new PropertyReference1Impl(n0.d(KTypeImpl.class), "arguments", "getArguments()Ljava/util/List;"))};
    private final l.a<Type> a;
    @e
    private final l.a b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final l.a f16396c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final z f16397d;

    public KTypeImpl(@d z zVar, @e a<? extends Type> aVar) {
        this.f16397d = zVar;
        l.a<Type> aVar2 = null;
        l.a<Type> aVar3 = (l.a) (!(aVar instanceof l.a) ? null : aVar);
        if (aVar3 != null) {
            aVar2 = aVar3;
        } else if (aVar != null) {
            aVar2 = l.d(aVar);
        }
        this.a = aVar2;
        this.b = l.d(new KTypeImpl$classifier$2(this));
        this.f16396c = l.d(new KTypeImpl$arguments$2(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g e(z zVar) {
        z type;
        f c2 = zVar.I0().c();
        if (c2 instanceof h.p2.b0.g.t.c.d) {
            Class<?> o = q.o((h.p2.b0.g.t.c.d) c2);
            if (o != null) {
                if (o.isArray()) {
                    s0 s0Var = (s0) CollectionsKt___CollectionsKt.X4(zVar.H0());
                    if (s0Var != null && (type = s0Var.getType()) != null) {
                        g e2 = e(type);
                        if (e2 != null) {
                            return new KClassImpl(q.e(h.k2.a.c(h.p2.b0.d.a(e2))));
                        }
                        throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
                    }
                    return new KClassImpl(o);
                } else if (!y0.l(zVar)) {
                    Class<?> e3 = ReflectClassUtilKt.e(o);
                    if (e3 != null) {
                        o = e3;
                    }
                    return new KClassImpl(o);
                } else {
                    return new KClassImpl(o);
                }
            }
            return null;
        } else if (c2 instanceof t0) {
            return new KTypeParameterImpl(null, (t0) c2);
        } else {
            if (c2 instanceof h.p2.b0.g.t.c.s0) {
                throw new NotImplementedError("An operation is not implemented: Type alias classifiers are not yet supported");
            }
            return null;
        }
    }

    @Override // h.p2.r
    @e
    public g a() {
        return (g) this.b.b(this, f16395e[0]);
    }

    @Override // h.p2.r
    public boolean b() {
        return this.f16397d.J0();
    }

    @Override // h.k2.v.g0
    @e
    public Type c() {
        l.a<Type> aVar = this.a;
        if (aVar != null) {
            return aVar.invoke();
        }
        return null;
    }

    public boolean equals(@e Object obj) {
        return (obj instanceof KTypeImpl) && f0.g(this.f16397d, ((KTypeImpl) obj).f16397d);
    }

    @Override // h.p2.b
    @d
    public List<Annotation> getAnnotations() {
        return q.d(this.f16397d);
    }

    @d
    public final z getType() {
        return this.f16397d;
    }

    @d
    public final KTypeImpl h(boolean z) {
        return (x.b(this.f16397d) || b() != z) ? new KTypeImpl(y0.p(this.f16397d, z), this.a) : this;
    }

    public int hashCode() {
        return this.f16397d.hashCode();
    }

    @d
    public String toString() {
        return ReflectionObjectRenderer.b.h(this.f16397d);
    }

    @Override // h.p2.r
    @d
    public List<t> u() {
        return (List) this.f16396c.b(this, f16395e[1]);
    }

    public /* synthetic */ KTypeImpl(z zVar, a aVar, int i2, u uVar) {
        this(zVar, (i2 & 2) != 0 ? null : aVar);
    }
}
