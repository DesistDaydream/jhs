package kotlin.reflect.jvm.internal.impl.load.java.components;

import h.a2.s0;
import h.a2.t;
import h.a2.t0;
import h.k2.u.a;
import h.p2.b0.g.t.e.a.x.b;
import h.p2.b0.g.t.e.a.x.e;
import h.p2.b0.g.t.e.a.x.m;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.n.g;
import h.z0;
import java.util.Map;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class JavaTargetAnnotationDescriptor$allValueArguments$2 extends Lambda implements a<Map<f, ? extends g<? extends Object>>> {
    public final /* synthetic */ JavaTargetAnnotationDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaTargetAnnotationDescriptor$allValueArguments$2(JavaTargetAnnotationDescriptor javaTargetAnnotationDescriptor) {
        super(0);
        this.this$0 = javaTargetAnnotationDescriptor;
    }

    @Override // h.k2.u.a
    @d
    public final Map<f, ? extends g<? extends Object>> invoke() {
        g<?> c2;
        b b = this.this$0.b();
        if (b instanceof e) {
            c2 = JavaAnnotationTargetMapper.a.c(((e) this.this$0.b()).c());
        } else {
            c2 = b instanceof m ? JavaAnnotationTargetMapper.a.c(t.k(this.this$0.b())) : null;
        }
        Map<f, ? extends g<? extends Object>> k2 = c2 != null ? s0.k(z0.a(h.p2.b0.g.t.e.a.t.b.a.d(), c2)) : null;
        return k2 != null ? k2 : t0.z();
    }
}
