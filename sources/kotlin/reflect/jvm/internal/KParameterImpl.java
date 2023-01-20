package kotlin.reflect.jvm.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.u.a;
import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.b0.g.l;
import h.p2.b0.g.t.c.g0;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.g.f;
import h.p2.n;
import h.p2.r;
import java.lang.annotation.Annotation;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0013\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0002J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\"H\u0016R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006."}, d2 = {"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", "", TTDownloadField.TT_HASHCODE, "toString", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KParameterImpl implements KParameter {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ n[] f16371f = {n0.r(new PropertyReference1Impl(n0.d(KParameterImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), n0.r(new PropertyReference1Impl(n0.d(KParameterImpl.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    private final l.a a;
    @d
    private final l.a b = l.d(new KParameterImpl$annotations$2(this));
    @d

    /* renamed from: c  reason: collision with root package name */
    private final KCallableImpl<?> f16372c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16373d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final KParameter.Kind f16374e;

    public KParameterImpl(@d KCallableImpl<?> kCallableImpl, int i2, @d KParameter.Kind kind, @d a<? extends g0> aVar) {
        this.f16372c = kCallableImpl;
        this.f16373d = i2;
        this.f16374e = kind;
        this.a = l.d(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g0 h() {
        return (g0) this.a.b(this, f16371f[0]);
    }

    @d
    public final KCallableImpl<?> e() {
        return this.f16372c;
    }

    public boolean equals(@e Object obj) {
        if (obj instanceof KParameterImpl) {
            KParameterImpl kParameterImpl = (KParameterImpl) obj;
            if (f0.g(this.f16372c, kParameterImpl.f16372c) && f() == kParameterImpl.f()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KParameter
    public int f() {
        return this.f16373d;
    }

    @Override // h.p2.b
    @d
    public List<Annotation> getAnnotations() {
        return (List) this.b.b(this, f16371f[1]);
    }

    @Override // kotlin.reflect.KParameter
    @e
    public String getName() {
        g0 h2 = h();
        if (!(h2 instanceof v0)) {
            h2 = null;
        }
        v0 v0Var = (v0) h2;
        if (v0Var == null || v0Var.b().e0()) {
            return null;
        }
        f name = v0Var.getName();
        if (name.g()) {
            return null;
        }
        return name.b();
    }

    @Override // kotlin.reflect.KParameter
    @d
    public r getType() {
        return new KTypeImpl(h().getType(), new KParameterImpl$type$1(this));
    }

    public int hashCode() {
        return (this.f16372c.hashCode() * 31) + Integer.valueOf(f()).hashCode();
    }

    @Override // kotlin.reflect.KParameter
    @d
    public KParameter.Kind i() {
        return this.f16374e;
    }

    @Override // kotlin.reflect.KParameter
    public boolean k() {
        g0 h2 = h();
        return (h2 instanceof v0) && ((v0) h2).t0() != null;
    }

    @Override // kotlin.reflect.KParameter
    public boolean s() {
        g0 h2 = h();
        if (!(h2 instanceof v0)) {
            h2 = null;
        }
        v0 v0Var = (v0) h2;
        if (v0Var != null) {
            return DescriptorUtilsKt.a(v0Var);
        }
        return false;
    }

    @d
    public String toString() {
        return ReflectionObjectRenderer.b.f(this);
    }
}
