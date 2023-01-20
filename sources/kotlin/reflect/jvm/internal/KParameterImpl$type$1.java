package kotlin.reflect.jvm.internal;

import h.k2.u.a;
import h.k2.v.f0;
import h.p2.b0.g.q;
import h.p2.b0.g.t.c.g0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.m0;
import java.lang.reflect.Type;
import java.util.Objects;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KParameterImpl$type$1 extends Lambda implements a<Type> {
    public final /* synthetic */ KParameterImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KParameterImpl$type$1(KParameterImpl kParameterImpl) {
        super(0);
        this.this$0 = kParameterImpl;
    }

    @Override // h.k2.u.a
    @d
    public final Type invoke() {
        g0 h2;
        h2 = this.this$0.h();
        if ((h2 instanceof m0) && f0.g(q.h(this.this$0.e().J()), h2) && this.this$0.e().J().i() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            k b = this.this$0.e().J().b();
            Objects.requireNonNull(b, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> o = q.o((h.p2.b0.g.t.c.d) b);
            if (o != null) {
                return o;
            }
            throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + h2);
        }
        return this.this$0.e().G().a().get(this.this$0.f());
    }
}
