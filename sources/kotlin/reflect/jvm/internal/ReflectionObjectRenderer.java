package kotlin.reflect.jvm.internal;

import h.p2.b0.g.n;
import h.p2.b0.g.q;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.n.z;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u0006\u0010\u001c\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "()V", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderCallable", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "renderFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderType", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ReflectionObjectRenderer {
    @d
    public static final ReflectionObjectRenderer b = new ReflectionObjectRenderer();
    private static final DescriptorRenderer a = DescriptorRenderer.f16750g;

    private ReflectionObjectRenderer() {
    }

    private final void a(StringBuilder sb, m0 m0Var) {
        if (m0Var != null) {
            sb.append(h(m0Var.getType()));
            sb.append(".");
        }
    }

    private final void b(StringBuilder sb, a aVar) {
        m0 h2 = q.h(aVar);
        m0 Q = aVar.Q();
        a(sb, h2);
        boolean z = (h2 == null || Q == null) ? false : true;
        if (z) {
            sb.append("(");
        }
        a(sb, Q);
        if (z) {
            sb.append(")");
        }
    }

    private final String c(a aVar) {
        if (aVar instanceof j0) {
            return g((j0) aVar);
        }
        if (aVar instanceof v) {
            return d((v) aVar);
        }
        throw new IllegalStateException(("Illegal callable: " + aVar).toString());
    }

    @d
    public final String d(@d v vVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        ReflectionObjectRenderer reflectionObjectRenderer = b;
        reflectionObjectRenderer.b(sb, vVar);
        sb.append(a.x(vVar.getName(), true));
        CollectionsKt___CollectionsKt.W2(vVar.h(), sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "(", (r14 & 8) == 0 ? ")" : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : ReflectionObjectRenderer$renderFunction$1$1.INSTANCE);
        sb.append(": ");
        sb.append(reflectionObjectRenderer.h(vVar.getReturnType()));
        return sb.toString();
    }

    @d
    public final String e(@d v vVar) {
        StringBuilder sb = new StringBuilder();
        ReflectionObjectRenderer reflectionObjectRenderer = b;
        reflectionObjectRenderer.b(sb, vVar);
        CollectionsKt___CollectionsKt.W2(vVar.h(), sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "(", (r14 & 8) == 0 ? ")" : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : ReflectionObjectRenderer$renderLambda$1$1.INSTANCE);
        sb.append(" -> ");
        sb.append(reflectionObjectRenderer.h(vVar.getReturnType()));
        return sb.toString();
    }

    @d
    public final String f(@d KParameterImpl kParameterImpl) {
        StringBuilder sb = new StringBuilder();
        int i2 = n.a[kParameterImpl.i().ordinal()];
        if (i2 == 1) {
            sb.append("extension receiver parameter");
        } else if (i2 == 2) {
            sb.append("instance parameter");
        } else if (i2 == 3) {
            sb.append("parameter #" + kParameterImpl.f() + ' ' + kParameterImpl.getName());
        }
        sb.append(" of ");
        sb.append(b.c(kParameterImpl.e().J()));
        return sb.toString();
    }

    @d
    public final String g(@d j0 j0Var) {
        StringBuilder sb = new StringBuilder();
        sb.append(j0Var.O() ? "var " : "val ");
        ReflectionObjectRenderer reflectionObjectRenderer = b;
        reflectionObjectRenderer.b(sb, j0Var);
        sb.append(a.x(j0Var.getName(), true));
        sb.append(": ");
        sb.append(reflectionObjectRenderer.h(j0Var.getType()));
        return sb.toString();
    }

    @d
    public final String h(@d z zVar) {
        return a.y(zVar);
    }
}
