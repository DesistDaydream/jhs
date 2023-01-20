package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.k.n.g;
import h.w;
import h.z;
import java.util.Map;
import k.e.a.d;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes3.dex */
public final class BuiltInAnnotationDescriptor implements c {
    @d
    private final f a;
    @d
    private final h.p2.b0.g.t.g.c b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final Map<h.p2.b0.g.t.g.f, g<?>> f16449c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final w f16450d = z.b(LazyThreadSafetyMode.PUBLICATION, new BuiltInAnnotationDescriptor$type$2(this));

    /* JADX WARN: Multi-variable type inference failed */
    public BuiltInAnnotationDescriptor(@d f fVar, @d h.p2.b0.g.t.g.c cVar, @d Map<h.p2.b0.g.t.g.f, ? extends g<?>> map) {
        this.a = fVar;
        this.b = cVar;
        this.f16449c = map;
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @d
    public Map<h.p2.b0.g.t.g.f, g<?>> a() {
        return this.f16449c;
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @d
    public h.p2.b0.g.t.g.c e() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @d
    public o0 getSource() {
        return o0.a;
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @d
    public h.p2.b0.g.t.n.z getType() {
        return (h.p2.b0.g.t.n.z) this.f16450d.getValue();
    }
}
