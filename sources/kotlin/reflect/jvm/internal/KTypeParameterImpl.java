package kotlin.reflect.jvm.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.a;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.v0;
import h.p2.b0.g.g;
import h.p2.b0.g.i;
import h.p2.b0.g.j;
import h.p2.b0.g.l;
import h.p2.b0.g.q;
import h.p2.b0.g.t.c.f1.a.f;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.e.b.m;
import h.p2.n;
import h.p2.r;
import h.p2.s;
import h.t1;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u0006\u0012\u0002\b\u00030#*\u00020$H\u0002J\u0010\u0010%\u001a\u0006\u0012\u0002\b\u00030&*\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "container", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "getContainerClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedMemberDescriptor;", "toKClassImpl", "Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KTypeParameterImpl implements s, g {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ n[] f16398d = {n0.r(new PropertyReference1Impl(n0.d(KTypeParameterImpl.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    @d
    private final l.a a = l.d(new KTypeParameterImpl$upperBounds$2(this));
    private final j b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final t0 f16399c;

    public KTypeParameterImpl(@e j jVar, @d t0 t0Var) {
        KClassImpl<?> kClassImpl;
        Object B;
        this.f16399c = t0Var;
        if (jVar == null) {
            k b = e().b();
            if (b instanceof h.p2.b0.g.t.c.d) {
                B = c((h.p2.b0.g.t.c.d) b);
            } else if (b instanceof CallableMemberDescriptor) {
                k b2 = ((CallableMemberDescriptor) b).b();
                if (b2 instanceof h.p2.b0.g.t.c.d) {
                    kClassImpl = c((h.p2.b0.g.t.c.d) b2);
                } else {
                    DeserializedMemberDescriptor deserializedMemberDescriptor = (DeserializedMemberDescriptor) (!(b instanceof DeserializedMemberDescriptor) ? null : b);
                    if (deserializedMemberDescriptor != null) {
                        h.p2.d g2 = a.g(a(deserializedMemberDescriptor));
                        Objects.requireNonNull(g2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                        kClassImpl = (KClassImpl) g2;
                    } else {
                        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + b);
                    }
                }
                B = b.B(new h.p2.b0.g.a(kClassImpl), t1.a);
            } else {
                throw new KotlinReflectionInternalError("Unknown type parameter container: " + b);
            }
            jVar = (j) B;
        }
        this.b = jVar;
    }

    private final Class<?> a(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        Class<?> e2;
        h.p2.b0.g.t.l.b.x.e K = deserializedMemberDescriptor.K();
        if (!(K instanceof h.p2.b0.g.t.e.b.g)) {
            K = null;
        }
        h.p2.b0.g.t.e.b.g gVar = (h.p2.b0.g.t.e.b.g) K;
        m f2 = gVar != null ? gVar.f() : null;
        f fVar = f2 instanceof f ? f2 : null;
        if (fVar == null || (e2 = fVar.e()) == null) {
            throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + deserializedMemberDescriptor);
        }
        return e2;
    }

    private final KClassImpl<?> c(h.p2.b0.g.t.c.d dVar) {
        Class<?> o = q.o(dVar);
        KClassImpl<?> kClassImpl = (KClassImpl) (o != null ? a.g(o) : null);
        if (kClassImpl != null) {
            return kClassImpl;
        }
        throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + dVar.b());
    }

    @Override // h.p2.b0.g.g
    @d
    /* renamed from: b */
    public t0 e() {
        return this.f16399c;
    }

    public boolean equals(@e Object obj) {
        if (obj instanceof KTypeParameterImpl) {
            KTypeParameterImpl kTypeParameterImpl = (KTypeParameterImpl) obj;
            if (f0.g(this.b, kTypeParameterImpl.b) && f0.g(getName(), kTypeParameterImpl.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // h.p2.s
    @d
    public String getName() {
        return e().getName().b();
    }

    @Override // h.p2.s
    @d
    public List<r> getUpperBounds() {
        return (List) this.a.b(this, f16398d[0]);
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + getName().hashCode();
    }

    @Override // h.p2.s
    public boolean l() {
        return e().l();
    }

    @Override // h.p2.s
    @d
    public KVariance o() {
        int i2 = i.a[e().o().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return KVariance.OUT;
                }
                throw new NoWhenBranchMatchedException();
            }
            return KVariance.IN;
        }
        return KVariance.INVARIANT;
    }

    @d
    public String toString() {
        return v0.f14940f.a(this);
    }
}
