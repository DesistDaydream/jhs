package h.p2.b0.g;

import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.v;
import h.t1;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KMutableProperty0Impl;
import kotlin.reflect.jvm.internal.KMutableProperty1Impl;
import kotlin.reflect.jvm.internal.KMutableProperty2Impl;
import kotlin.reflect.jvm.internal.KProperty0Impl;
import kotlin.reflect.jvm.internal.KProperty1Impl;
import kotlin.reflect.jvm.internal.KProperty2Impl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/CreateKCallableVisitor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "visitFunctionDescriptor", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "data", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public class a extends h.p2.b0.g.t.c.d1.k<KCallableImpl<?>, t1> {
    private final KDeclarationContainerImpl a;

    public a(@k.e.a.d KDeclarationContainerImpl kDeclarationContainerImpl) {
        this.a = kDeclarationContainerImpl;
    }

    @Override // h.p2.b0.g.t.c.d1.k, h.p2.b0.g.t.c.m
    @k.e.a.d
    /* renamed from: p */
    public KCallableImpl<?> i(@k.e.a.d v vVar, @k.e.a.d t1 t1Var) {
        return new KFunctionImpl(this.a, vVar);
    }

    @Override // h.p2.b0.g.t.c.d1.k, h.p2.b0.g.t.c.m
    @k.e.a.d
    /* renamed from: q */
    public KCallableImpl<?> c(@k.e.a.d j0 j0Var, @k.e.a.d t1 t1Var) {
        int i2 = (j0Var.M() != null ? 1 : 0) + (j0Var.Q() != null ? 1 : 0);
        if (j0Var.O()) {
            if (i2 == 0) {
                return new KMutableProperty0Impl(this.a, j0Var);
            }
            if (i2 == 1) {
                return new KMutableProperty1Impl(this.a, j0Var);
            }
            if (i2 == 2) {
                return new KMutableProperty2Impl(this.a, j0Var);
            }
        } else if (i2 == 0) {
            return new KProperty0Impl(this.a, j0Var);
        } else {
            if (i2 == 1) {
                return new KProperty1Impl(this.a, j0Var);
            }
            if (i2 == 2) {
                return new KProperty2Impl(this.a, j0Var);
            }
        }
        throw new KotlinReflectionInternalError("Unsupported property: " + j0Var);
    }
}
